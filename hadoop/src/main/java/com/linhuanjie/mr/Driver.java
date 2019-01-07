package com.linhuanjie.mr;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * @author: linhuanjie
 * @description:
 * @createTime : 2019-01-03 22:16
 * @email: lhuanjie@qq.com
 */
public class Driver {

    public static void main(String[] args) throws Exception{

        Configuration conf = new Configuration();
        // 本地启动
//        conf.set("mapreduce.framework.name","local");
        Job job = Job.getInstance(conf);

        job.setJarByClass(Driver.class);

        job.setMapperClass(WordCountMapper.class);
        job.setReducerClass(WordCountReduce.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

//        job.setNumReduceTasks(2);

//        FileInputFormat.setInputPaths(job,"/wordcount");
//        FileOutputFormat.setOutputPath(job,new Path("/wordcount/result"));

        FileInputFormat.setInputPaths(job," /temp/wordcount/input");
        FileOutputFormat.setOutputPath(job,new Path("/temp/wordcount/output"));

//        job.submit();
        boolean b = job.waitForCompletion(true);
        System.out.println(b);
    }



}
