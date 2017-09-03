package com.qunar;

import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

import java.util.StringTokenizer;

/**
 * Created by ershu.liang on 2017/8/24.
 */
public class SplitBolt extends BaseBasicBolt {

    @Override
    public void execute(Tuple tuple, BasicOutputCollector basicOutputCollector) {
        String sentence = tuple.getString(0);
        StringTokenizer iter = new StringTokenizer(sentence);
        while(iter.hasMoreElements()) {
            basicOutputCollector.emit(new Values(iter.nextToken()));
        }
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("word"));
    }
}
