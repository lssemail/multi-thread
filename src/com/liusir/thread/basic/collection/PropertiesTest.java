package com.liusir.thread.basic.collection;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Properties;

public class PropertiesTest extends Properties {

    public static void main(String[] args) throws Exception {

        File file = new File("src/com/liusir/thread/basic/collection/my.properties");
        InputStream inputStream = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(inputStream);
        String value = properties.getProperty("my.title");
        System.out.println(value);
    }

}

