package com.qunar;

import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ershu.liang on 2017/8/24.
 */
public class CountBolt extends BaseBasicBolt {

    private Map<String, Integer> mp = new HashMap<>();

    @Override
    public void execute(Tuple tuple, BasicOutputCollector basicOutputCollector) {
        String word = tuple.getString(0);
        if(mp.containsKey(word)) {
            mp.put(word, mp.get(word) + 1);
        } else {
            mp.put(word, 1);
        }
        System.out.println(word + " " + mp.get(word));
        basicOutputCollector.emit(new Values(word, mp.get(word)));
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("word", "count"));
    }
}
