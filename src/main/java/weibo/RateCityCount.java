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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: mr
 * Comments:hadoop jar mr-1.jar weibo.RateCityCount /weibo/pro1_data  /weibo/pro1
 * Author:cbam
 * hadoop fs -cat /weibo/pro1/part-r-00000
 * Create Date:2017/5/15
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */
public class RateCityCount {

    private enum WeiBoEnum {
        Error
    }

    public static class MapCount extends Mapper<LongWritable, Text, IntWritable, IntWritable> {
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            try {
                String[] arr = value.toString().split(",");
                if(arr.length == 4 && arr[1] != null && StringUtils.isNumeric(arr[1])) {
                    context.write(new IntWritable(Integer.parseInt(arr[1])), new IntWritable(1));
                } else {
                    throw new Exception("error =====");
                }
            } catch (Exception e) {
                context.getCounter(WeiBoEnum.Error).increment(1);
            }
        }
    }

    public static class ReduceCount extends Reducer<IntWritable, IntWritable, Text, Text> {

        HashMap<Integer, String> initMap = new HashMap<Integer, String>();
        private static TreeMap<Integer, Integer> mp = new TreeMap<Integer, Integer>();
        private static long totalNumber = 0;
        private static double ans = 0;

        @Override
        protected void setup(Context context) throws IOException, InterruptedException {
            BufferedReader br = new BufferedReader(new FileReader("/provinces.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split("\t");
                initMap.put(Integer.parseInt(fields[0]), fields[1]);
            }
            br.close();
        }

        @Override
        protected void reduce(IntWritable key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
            int total = 0;
            for(IntWritable each : values) {
                total += each.get();
                totalNumber++;
            }
            mp.put(key.get(), total);
        }

        @Override
        protected void cleanup(Context context) throws IOException, InterruptedException {
            for(Map.Entry<Integer, Integer> entry : mp.entrySet()) {
                ans += Double.parseDouble(new DecimalFormat("#0.00").format((entry.getValue() * 100) / (1.0 * totalNumber)));
                if(initMap.containsKey(entry.getKey())) {
                    context.write(new Text(initMap.get(entry.getKey())), new Text(new DecimalFormat("#0.00").format((entry.getValue() * 100) / (1.0 * totalNumber))));
                } else {
                    context.getCounter(WeiBoEnum.Error).increment(1);
                }

            }
        }
    }

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();

        Job wcjob = new Job(conf, "weiboCount");

        wcjob.setJarByClass(RateCityCount.class);

        wcjob.setMapperClass(MapCount.class);
        wcjob.setReducerClass(ReduceCount.class);


        wcjob.setMapOutputKeyClass(IntWritable.class);
        wcjob.setMapOutputValueClass(IntWritable.class);

        wcjob.setOutputKeyClass(Text.class);
        wcjob.setOutputValueClass(DoubleWritable.class);

        FileInputFormat.setInputPaths(wcjob, new Path(args[0]));

        FileOutputFormat.setOutputPath(wcjob, new Path(args[1]));
        FileSystem fs = FileSystem.get(conf);
        if( fs.exists(new Path(args[0]))) {
            fs.delete(new Path(args[1]) ,true);
        }
        boolean res = wcjob.waitForCompletion(true);
        if(res) {
            System.out.println("Error number: " + wcjob.getCounters().findCounter(WeiBoEnum.Error).getValue());
        }
        System.exit(res?0:1);
    }

}
