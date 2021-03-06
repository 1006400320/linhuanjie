package com.linhuanjie.easyexcel;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: linhuanjie
 * @description:
 * @createTime : 2018-11-29 17:53
 * @email: lhuanjie@qq.com
 */
public class WriterWithoutHead {

    /**
     * 每行数据是List<String>无表头
     *
     * @throws IOException
     */
    @Test
    public void writeWithoutHead() throws IOException {
        try (OutputStream out = new FileOutputStream("withoutHead.xlsx")) {
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, false);
            Sheet sheet1 = new Sheet(1, 0);
            sheet1.setSheetName("sheet1");

            List<List<String>> data = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                List<String> item = new ArrayList<>();
                item.add("item0" + i);
                item.add("item1" + i);
                item.add("item2" + i);
                data.add(item);
            }
            writer.write0(data, sheet1);
            writer.finish();
        }
    }
}
