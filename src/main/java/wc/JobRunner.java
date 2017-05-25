package mr.wc;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * ���ڷ�װ������Ϣ�����ύ��hadoop��Ⱥȥִ��
 * @author
 *
 *  hadoop jar wc-mr.jar cn.itcast.bigdata.mr.wc.JobRunner
 *
 */
public class JobRunner {
	
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		
		Job wcjob = new Job(conf, "wordCount");
		
		//ͨ�����������������ƻ�ȡ����job�����д������ڵ�jar��
		wcjob.setJarByClass(JobRunner.class);
		
		//ָ����jobʹ�õ�mapper��
		wcjob.setMapperClass(WordCountMapper.class);
		//ָ����jobʹ�õ�reducer��
		wcjob.setReducerClass(WordCountReducer.class);
		
		//ָ��mapper�����kv����������
		wcjob.setMapOutputKeyClass(Text.class);
		wcjob.setMapOutputValueClass(IntWritable.class);
		
		//ָ��reducer�����kv��������
		wcjob.setOutputKeyClass(Text.class);
		wcjob.setOutputValueClass(IntWritable.class);
		
		//ָ����jobҪ������ļ����ڵ�·��
		FileInputFormat.setInputPaths(wcjob, new Path("/wc/data/"));
		//ָ����job����Ľ���ļ������ĸ�·��
		FileOutputFormat.setOutputPath(wcjob, new Path("/wc/output/"));
		
		//����job��hadoop��Ⱥ�ύִ��
		boolean res = wcjob.waitForCompletion(true);
		
		System.exit(res?0:1);
	}
	

}
