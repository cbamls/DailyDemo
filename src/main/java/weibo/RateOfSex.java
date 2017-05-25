package weibo;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: mr
 * Comments:hadoop jar mr-1.jar weibo.RateOfSex /weibo/pro2_data  /weibo/pro4
 * hadoop fs -cat /weibo/pro2_data/part-r-00000
 * Author:cbam
 * Create Date:2017/5/23
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */
public class RateOfSex {

    private enum WeiBoEnum {
        Error, MALE, FEMALE, SUCCESS
    }
    public static class MapCount extends Mapper<LongWritable, Text, Text, LongWritable> {
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            try {
                String[] arr = value.toString().split(",");
                if (arr.length == 4 && arr[3].equals("True")) {
                    if (arr[2].equals("m")) {
                        context.getCounter(WeiBoEnum.MALE).increment(1);
                        context.write(new Text("m"), new LongWritable(1));
                    } else {
                        context.getCounter(WeiBoEnum.FEMALE).increment(1);
                        context.write(new Text("f"), new LongWritable(1));
                    }
                } else {
                    throw new Exception("error ====");
                }
            } catch (Exception e) {
                context.getCounter(WeiBoEnum.Error).increment(1);
                e.printStackTrace();
            }
        }
    }

    public static class ReduceCount extends Reducer<Text, LongWritable, Text, DoubleWritable> {
        private long male = 0;
        private long female = 0;
        @Override
        protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
            if(key.toString().equals("m")) {
               for(LongWritable lw : values) {
                   male += lw.get();
               }
            } else {
                for(LongWritable lw : values) {
                    female += lw.get();
                }
            }
        }

        @Override
        protected void cleanup(Context context) throws IOException, InterruptedException {
            context.write(new Text("rate => "), new DoubleWritable(male / (1.0 * female)));
        }
    }

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();

        Job wcjob = new Job(conf, "RateOfSex");

        wcjob.setJarByClass(RateOfSex.class);

        wcjob.setMapperClass(MapCount.class);
        wcjob.setReducerClass(ReduceCount.class);


        wcjob.setMapOutputKeyClass(Text.class);
        wcjob.setMapOutputValueClass(LongWritable.class);

        wcjob.setOutputKeyClass(Text.class);
        wcjob.setOutputValueClass(DoubleWritable.class);

        FileInputFormat.setInputPaths(wcjob, new Path(args[0]));

        FileOutputFormat.setOutputPath(wcjob, new Path(args[1]));
        FileSystem fs = FileSystem.get(conf);
        if (fs.exists(new Path(args[0]))) {
            fs.delete(new Path(args[1]), true);
        }
        boolean res = wcjob.waitForCompletion(true);
        if (res) {
            System.out.println("Error number: " + wcjob.getCounters().findCounter(RateOfSex.WeiBoEnum.Error).getValue());
            System.out.println("SUCCESS number: " + wcjob.getCounters().findCounter(RateOfSex.WeiBoEnum.SUCCESS).getValue());
            System.out.println("Male number / Female number: " + wcjob.getCounters().findCounter(WeiBoEnum.MALE).getValue() / (wcjob.getCounters().findCounter(WeiBoEnum.FEMALE).getValue() * 1.0));
        }
        System.exit(res ? 0 : 1);
    }
}
