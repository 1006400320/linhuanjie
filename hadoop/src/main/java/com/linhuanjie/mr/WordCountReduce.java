package com.linhuanjie.mr;


import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author: linhuanjie
 * @description:
 * @createTime : 2019-01-03 22:02
 * @email: lhuanjie@qq.com
 */
public class WordCountReduce extends Reducer<Text, IntWritable,Text,IntWritable> {

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int count = 0;
        for (IntWritable value : values) {
            count += value.get();
        }

        context.write(key,new IntWritable(count));
    }
}
