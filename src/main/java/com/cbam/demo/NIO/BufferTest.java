package com.cbam.demo.NIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.FileChannel;

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
public class BufferTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("E:\\workplace\\demo\\src\\main\\resources\\Buffer.txt", "rw");
        RandomAccessFile randomAccessFile_2 = new RandomAccessFile("E:\\workplace\\demo\\src\\main\\resources\\Buffer_2.txt", "rw");

        FileChannel fileChannel = randomAccessFile.getChannel();
        FileChannel fileChannel_2 = randomAccessFile_2.getChannel();
        fileChannel.truncate(2);
        ByteBuffer byteBuffer = ByteBuffer.allocate(48);
        int bytesRead = 0;
        bytesRead = fileChannel.read(byteBuffer);

        while(bytesRead != -1) {
            byteBuffer.flip();
            while(byteBuffer.hasRemaining()) {
                System.out.println((char) byteBuffer.get());
                byteBuffer.compact();
                fileChannel_2.read(byteBuffer);
                byteBuffer.flip();
            }
            byteBuffer.clear();
            bytesRead = fileChannel.read(byteBuffer);
        }
        fileChannel.close();
    }
}
