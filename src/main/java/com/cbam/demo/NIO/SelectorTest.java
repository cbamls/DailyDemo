package com.cbam.demo.NIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: demo
 * Comments:
 * Author:cbam
 * Create Date:2017/1/22
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */
public class SelectorTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("E:\\workplace\\demo\\src\\main\\resources\\Buffer.txt", "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();
        Selector selector = Selector.open();

    }
}
