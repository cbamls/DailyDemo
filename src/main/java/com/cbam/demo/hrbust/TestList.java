package com.cbam.demo.hrbust;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.tinify.Exception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by ershu.liang on 2017/9/18.
 */
public class TestList {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestList.class);

    static class Bean {
        int a;
        int b;
    }

    public static byte[] get() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            baos.write(3);

            return baos.toByteArray();
        } catch (Exception e) {
            System.out.println("catch");
        } finally {
            System.out.println("finally");
            baos.close();
        }
        return null;
    }
    public static void main(String[] args) throws IOException {
        LinkedHashMap<String, String> mp = new LinkedHashMap<>();
        mp.put("s", null);
        System.out.println(mp);
    }
}
