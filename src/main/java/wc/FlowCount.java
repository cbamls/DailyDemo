package mr.wc;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

//cn.itcast.bigdata.mr.flowcount.FlowCount
public class FlowCount {

	public static class FlowCountMapper extends Mapper<LongWritable, Text, Text, FlowBean> {
		@Override
		protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

			// �õ����е�����ת��string
			String line = value.toString();

			String[] fields = StringUtils.split(line, "\t");
			try {
				if (fields.length > 3) {
					// ����ֻ��ż������������ֶ�ֵ
					String phone = fields[1];
					long upFlow = Long.parseLong(fields[fields.length - 3]);
					long dFlow = Long.parseLong(fields[fields.length - 2]);

					// �����һ�еĴ�����,keyΪ�ֻ��ţ�valueΪ������Ϣbean
					context.write(new Text(phone), new FlowBean(upFlow, dFlow));
				} else {
					return;
				}
			} catch (Exception e) {

			}

		}

	}

	public static class FlowCountReducer extends Reducer<Text, FlowBean, Text, FlowBean> {

		@Override
		protected void reduce(Text key, Iterable<FlowBean> values, Context context) throws IOException, InterruptedException {

			long upSum = 0;
			long dSum = 0;

			for (FlowBean bean : values) {

				upSum += bean.getUpFlow();
				dSum += bean.getdFlow();
			}

			FlowBean resultBean = new FlowBean(upSum, dSum);
			context.write(key, resultBean);

		}

	}

	public static void main(String[] args) throws Exception {

		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf);

		job.setJarByClass(FlowCount.class);

		job.setMapperClass(FlowCountMapper.class);
		job.setReducerClass(FlowCountReducer.class);

		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(FlowBean.class);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(FlowBean.class);

		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		boolean res = job.waitForCompletion(true);
		System.exit(res ? 0 : 1);

	}

}
