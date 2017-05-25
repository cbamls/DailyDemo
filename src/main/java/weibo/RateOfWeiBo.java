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
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: mr
 * Comments:
 * hadoop jar mr-1.jar weibo.RateOfWeiBo /weibo/data /weibo/pro2
 * Author:cbam
 * Create Date:2017/5/15
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */
public class RateOfWeiBo {

    private enum WeiBoEnum {
        Error, TotalNumer, SUCCESS, FORMAT_EXCEPTION, REDUCE, WEIBO_NUM, NUM, value;
    }

    public static class MapCount extends Mapper<LongWritable, Text, IntWritable, IntWritable> {

        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            context.getCounter(WeiBoEnum.SUCCESS).increment(1);

            try {
                String[] arr = value.toString().split(",");
                int i;
                for(i = arr.length - 1; i >= 0; i--) {
                    Date date = null;
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                    if(arr[i].matches("^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$")) {
                        if( arr[i - 1].matches("^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$")) {
                            date = sdf.parse(arr[i - 1].split(" ")[1]);
                        } else {
                            date = sdf.parse(arr[i].split(" ")[1]);
                        }
                        context.getCounter(WeiBoEnum.TotalNumer).increment(1);
                        if((date.before(sdf.parse("24:00:00")) && date.after(sdf.parse("19:59:59"))) || arr[i - 1].split(" ")[1].equals("00:00:00")) {
                            context.getCounter(WeiBoEnum.WEIBO_NUM).increment(1);
                        }
                        break;
                    }
                }
                if(i < 0) {
                    context.getCounter(WeiBoEnum.NUM).increment(1);
                    throw new Exception("error ===");
                }
            } catch (Exception e) {
                context.getCounter(WeiBoEnum.FORMAT_EXCEPTION).increment(1);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();

        Job wcjob = Job.getInstance();
        wcjob.setJobName(RateOfWeiBo.class.getSimpleName());

        wcjob.setJarByClass(RateOfWeiBo.class);

        wcjob.setMapperClass(MapCount.class);

        wcjob.setMapOutputKeyClass(IntWritable.class);
        wcjob.setMapOutputValueClass(IntWritable.class);

        FileInputFormat.setInputPaths(wcjob, new Path(args[0]));
        FileOutputFormat.setOutputPath(wcjob, new Path(args[1]));
        FileSystem fs = FileSystem.get(conf);
        if (fs.exists(new Path(args[0]))) {
            fs.delete(new Path(args[1]), true);
        }
        boolean res = wcjob.waitForCompletion(true);
        if (res) {
            System.out.println("Error number: " + wcjob.getCounters().findCounter(WeiBoEnum.Error).getValue());
            System.out.println("Total number: " + wcjob.getCounters().findCounter(WeiBoEnum.TotalNumer).getValue());
            System.out.println("Success number: " + wcjob.getCounters().findCounter(WeiBoEnum.SUCCESS).getValue());
            System.out.println("Format number: " + wcjob.getCounters().findCounter(WeiBoEnum.FORMAT_EXCEPTION).getValue());
            System.out.println("REDUCE number: " + wcjob.getCounters().findCounter(WeiBoEnum.REDUCE).getValue());
            System.out.println("ans = ===> " + (wcjob.getCounters().findCounter(WeiBoEnum.WEIBO_NUM).getValue() / (wcjob.getCounters().findCounter(WeiBoEnum.TotalNumer).getValue()*1.0)));
            System.out.println("NUM = ===> " + (wcjob.getCounters().findCounter(WeiBoEnum.NUM).getValue()));
            System.out.println("value = ===> " + (wcjob.getCounters().findCounter(WeiBoEnum.value).getValue() ));

        }
        System.exit(res ? 0 : 1);
    }
}
