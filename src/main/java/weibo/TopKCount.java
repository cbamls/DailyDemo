package weibo;

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
import java.util.Arrays;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: mr
 * Comments:
 * Author:cbam
 * Create Date:2017/5/16
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */
public class TopKCount {
    public static class TopKMapper extends Mapper<LongWritable, Text, IntWritable, IntWritable> {

        int len;
        int[] tmp;

        /**
         * Map任务启动的时候调用
         */
        @Override
        protected void setup( Context context)
                throws IOException, InterruptedException {
            /**
             * 通过context获取任务启动时传入的TopK的K值
             */
            len = context.getConfiguration().getInt("K", 10);
            /**
             * 创建一个数组来存放topK的值
             */
            tmp = new int[len + 1];
        }

        @Override
        protected void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {
            String line = value.toString();
            String[] arr = line.split(",");
            if(arr.length == 11) {
                addParm(Integer.valueOf(arr[3]));
            }
        }
        /**
         * 把新取出的数值放到数组中的第一位，并按从小到大排序
         * 这样下一次放入时就把最小的数值去除掉了
         */
        private void addParm(int parm) {
            tmp[0] = parm;
            Arrays.sort(tmp);
        }

        @Override
        protected void cleanup(Context context)
                throws IOException, InterruptedException {
            /**
             * 把数组中的数值倒序的输出，这样每个Map就输出了自己的TOPK去reduce端
             */
            for( int i = 1 ; i <= len ; i ++) {
                context.write(new IntWritable(tmp[i]), new IntWritable(tmp[i]));
            }
        }
    }

    public static class TopKReducer extends Reducer<IntWritable, IntWritable, IntWritable, IntWritable> {
        int len;
        int[] tmp;

        @Override
        protected void setup( Context context)
                throws IOException, InterruptedException {
            len = context.getConfiguration().getInt("K", 10);
            tmp = new int[len + 1];
        }

        @Override
        protected void reduce(IntWritable key, Iterable<IntWritable> values, Context arg2)
                throws IOException, InterruptedException {
            for(IntWritable value: values) {
                addParm(value.get());
            }
        }

        private void addParm(int parm) {
            tmp[0] = parm;
            Arrays.sort(tmp);
        }

        @Override
        protected void cleanup( Context context)
                throws IOException, InterruptedException {
            for( int i = len; i > 0 ; i --) {
                context.write(new IntWritable(len - i + 1), new IntWritable(tmp[i]));
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Configuration configuration = new Configuration();
        /**
         * 把传入参数放入Configuration中，map或reduce中可以通过
         * 获取Configuration来获取传入的参数，这是hadoop传入参数的
         * 方式之一
         */
        configuration.set("K", args[2]);
        Job job = new Job(configuration, "topK-job");
        job.setJarByClass(TopKCount.class);
        job.setMapperClass(TopKMapper.class);
        job.setMapOutputKeyClass(IntWritable.class);
        job.setMapOutputValueClass(IntWritable.class);
        job.setReducerClass(TopKReducer.class);
        job.setOutputKeyClass(IntWritable.class);
        job.setOutputValueClass(IntWritable.class);
        FileInputFormat.addInputPath(job, new Path(args[0]));
        Path outputDir = new Path(args[1]);
        FileSystem fs = FileSystem.get(configuration);
        if(fs.exists(outputDir)) {
            fs.delete(outputDir, true);
        }
        FileOutputFormat.setOutputPath(job, outputDir);
        System.exit(job.waitForCompletion(true)? 0: 1);
    }
}
