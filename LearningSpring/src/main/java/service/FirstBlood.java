package service;

import domain.Table;
import org.aspectj.apache.bcel.generic.TABLESWITCH;
import org.springframework.beans.factory.annotation.Autowired;

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
        System.out.println("id:"+table.getId()+"\n value:"+table.getValue()+"\n dt: "+table.getDt());
    }
}
