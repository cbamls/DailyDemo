package com.qunar;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.StormSubmitter;
import org.apache.storm.generated.AlreadyAliveException;
import org.apache.storm.generated.AuthorizationException;
import org.apache.storm.generated.InvalidTopologyException;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.tuple.Fields;

/**
 * Created by ershu.liang on 2017/8/24.
 */
public class WordCountByStorm {
    public static void main(String[] args) throws InvalidTopologyException, AuthorizationException, AlreadyAliveException {
        TopologyBuilder builder =  new TopologyBuilder();
        builder.setSpout("spout", new Spout(), 1);
        builder.setBolt("split", new SplitBolt(), 2).shuffleGrouping("spout");
        builder.setBolt("count", new CountBolt(), 3).fieldsGrouping("split", new Fields("word"));
        Config config = new Config();
        StormSubmitter.submitTopology("word_count", config, builder.createTopology());
        LocalCluster localCluster  = new LocalCluster();
        localCluster.submitTopology("word_count", config, builder.createTopology());
    }
}
