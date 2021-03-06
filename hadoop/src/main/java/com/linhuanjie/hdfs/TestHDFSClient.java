package com.linhuanjie.hdfs;

import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.FileInputStream;

/**
 * Created by Itcast .
 */
public class TestHDFSClient {

    public static void main(String[] args) throws Exception {

        Configuration conf = new Configuration();

        //这里指定使用的是 hdfs 文件系统
        conf.set("fs.defaultFS", "hdfs://node-1:9000");

        //通过这种方式设置java客户端访问hdfs的身份
        System.setProperty("HADOOP_USER_NAME", "root");

        FileSystem fs = FileSystem.get(conf);
        //FileSystem fs = FileSystem.get(new URI("hdfs://node-21:9000"), conf, "root");

//        fs.create(new Path("/helloByJava"));
        //文件下载到本地
//        fs.copyToLocalFile(new Path("/install.log.syslog"),new Path("e://"));

        //使用Stream的形式 操作HDFS 更底层的方式
        FSDataOutputStream outputStream = fs.create(new Path("/1.txt"), true);

        FileInputStream inputStream = new FileInputStream("D:\\1.txt");

        IOUtils.copy(inputStream, outputStream);

        fs.close();
    }
}
