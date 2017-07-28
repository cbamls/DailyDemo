package com.cbam.MultiThreadDemo.my;

import org.springframework.web.servlet.HttpServletBean;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * Created by ershu.liang on 2017/7/28.
 */
public class MyClassLoaderTwo extends ClassLoader {
    private String name;
    private String path = "D:\\";
    MyClassLoaderTwo(String name) {
        this.name = name;
    }
    MyClassLoaderTwo(ClassLoader parent, String name) {
        super(parent);
        this.name = name;
    }
    /**
     * 重写findClass方法
     */
    @Override
    public Class<?> findClass(String name) {
        byte[] data = loadClassData(name);
        return this.defineClass(name, data, 0, data.length);
    }
    public byte[] loadClassData(String name) {
        try {
            FileInputStream is = new FileInputStream(new File(path + name + ".class"));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b = 0;
            while ((b = is.read()) != -1) {
                baos.write(b);
            }
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

