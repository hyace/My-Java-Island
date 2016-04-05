package service;

import domain.Table;
import org.aspectj.apache.bcel.generic.TABLESWITCH;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Author: 张晖
 * MIS: zhanghui20
 * Date: 16/2/29
 * Email: zhanghui20@meituan.com
 */
public class FirstBlood {
    @Autowired
    private TableService tableService;
    private static String content;
    static{
        content = "Init ";
        System.out.println(content);
        System.out.println("static Block!");
    }
    public FirstBlood(){
        System.out.println(content);
        System.out.println("Construction!");
    }
    public String getContent(){
        return content;
    }
    public void opDB(){
        Table table = tableService.getTable(5);
        System.out.println(" id:" + table.getId() + "\n value:" + table.getValue() + "\n dt: " + table.getDt());
        Table t = new Table();
        int result;
//        t.setId(20);
//        t.setValue("opDB");
//        t.setDt(new Date());
//        tableService.insertTable(t);
        t.setId(10);
//        t.setValue("Duplicate12");
        t.setDt(new Date());
        System.out.println(t.getValue());
        result = tableService.insertOrUpdateTable(t);
        table = tableService.getTable(10);
        System.out.println(" id:" + table.getId() + "\n value:" + table.getValue() + "\n dt: " + table.getDt());
        System.out.println("insert on duplicate result: "+result);

        t = new Table();
        t.setValue("Insert unique.");
        t.setDt(new Date());
        result = tableService.insertOrUpdateTable(t);
        System.out.println("insert unique result: " + result);


        t.setId(33);
        t.setValue("update");
        result = tableService.update(t);
        table = tableService.getTable(10);
        System.out.println(" id:" + table.getId() + "\n value:" + table.getValue() + "\n dt: " + table.getDt());
        System.out.println("result: "+result);
        long cur = System.currentTimeMillis();
        System.out.println(cur);
        long sqlDate = tableService.testSqlDate(new java.sql.Date(cur));
        System.out.println(sqlDate+" : "+new Date(sqlDate*1000));

    }
}
