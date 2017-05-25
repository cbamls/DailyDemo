package weibo;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: mr
 * Comments:
 * Author:cbam
 * Create Date:2017/5/23
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */
public class TopK {

    private enum WeiBoEnum {
        Error
    }

//hadoop jar mr-1.jar weibo.TopK /weibo/pro2_data  /weibo/pro3
    //hadoop fs -cat /weibo/pro3/part-r-00000
    public static class MapCount extends Mapper<LongWritable, Text, Text, IntWritable> {

        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            try {
                String[] arr = value.toString().split(",");
                if (arr.length >= 10) {
                    if (StringUtils.isNotBlank(arr[1])) {
                        context.write(new Text(arr[2]), new IntWritable(1));
                    }
                }
            } catch (Exception e) {
                context.getCounter(WeiBoEnum.Error).increment(1);
                e.printStackTrace();
            }
        }
    }

    static class Node {
        String key;
        Long value;

        public Node(Long value, String key) {
            this.value = value;
            this.key = key;
        }
    }

    public static class TopKReduce extends Reducer<Text, IntWritable, Text, LongWritable> {

        private Queue<Node> queue = new PriorityQueue<Node>(7, new Comparator<Node>() {
            public int compare(Node o1, Node o2) {
                return o1.value > o2.value == true ? 1 : -1;
            }
        });

        public TopKReduce() {

        }

        @Override
        protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
            long sum = 0;
            for (IntWritable each : values) {
                sum += each.get();
            }
            if (queue.size() >= 5) {
                if (queue.peek().value < sum) {
                    queue.poll();
                    queue.add(new Node(sum, key.toString()));
                }
            } else {
                queue.add(new Node(sum, key.toString()));
            }
        }

        @Override
        protected void cleanup(Context context) throws IOException, InterruptedException {
            while(!queue.isEmpty()) {
                Node node = queue.poll();
                context.write(new Text(node.key), new LongWritable(node.value));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();

        Job wcjob = new Job(conf, "weiboTopk");

        wcjob.setJarByClass(TopK.class);

        wcjob.setMapperClass(TopK.MapCount.class);
        wcjob.setReducerClass(TopK.TopKReduce.class);


        wcjob.setMapOutputKeyClass(Text.class);
        wcjob.setMapOutputValueClass(IntWritable.class);

        wcjob.setOutputKeyClass(Text.class);
        wcjob.setOutputValueClass(LongWritable.class);

        FileInputFormat.setInputPaths(wcjob, new Path(args[0]));

        FileOutputFormat.setOutputPath(wcjob, new Path(args[1]));
        FileSystem fs = FileSystem.get(conf);
        if (fs.exists(new Path(args[0]))) {
            fs.delete(new Path(args[1]), true);
        }
        boolean res = wcjob.waitForCompletion(true);
        if (res) {
            System.out.println("Error number: " + wcjob.getCounters().findCounter(TopK.WeiBoEnum.Error).getValue());
        }
        System.exit(res ? 0 : 1);
    }
}
