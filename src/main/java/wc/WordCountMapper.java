package mr.wc;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * KEYIN ��������kv���е�key�����ͣ�Ĭ������£�key��һ���ı�����ʼƫ������Long VALUEIN
 * ��������kv��value�����ͣ�Ĭ������£�value��һ���ı������ݣ�String
 * 
 * 
 * KEYOUT �������kv���е�key�����ͣ����������wordcount�߼��У������key��һ������, String VALUEOUT
 * �������kv���е�value�����ͣ����������wordcount�߼��У������value��һ��1, Int
 * 
 * ������hadoop�У�������Ҫ�ڸ����ڵ�֮��������紫��ģ���Ҫ�������л�����jdk�����л�����̫���࣬����hadoop�Զ�����һ���Լ������л�����
 * ��hadoop�д�������ݾͱ���Ҫʵ��hadoop�Զ�������л����ƣ����ԣ�һЩ���õĻ�������������hadoop�ж�����Ӧ�ķ�װ�棬���磺 Long
 * ��������> LongWritable String ��������> Text Integer ��������> IntWritable
 * 
 * @author
 * 
 */
public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	/**
	 * mapper�׶εĴ����߼�д��map�����У�mapreduce��ܻ������������������ Ĭ������µ��õĹ����ǣ�ÿһ�����ݴ��ݽ������͵���һ��
	 * 
	 * �����еĲ���key��������һ�е���ʼƫ���� �����еĲ���value��������һ�е�����
	 */
	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

		// �õ�һ�е�����ת����String����
		String line = value.toString();

		// ����һ�������зֳ�����
		String[] words = line.split(" ");

		// �������ÿһ�����ʺ�1
		for (String word : words) {

			context.write(new Text(word), new IntWritable(1));

		}

	}

}
