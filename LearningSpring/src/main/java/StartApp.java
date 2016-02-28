import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.FirstBlood;

/**
 * Author: 张晖
 * MIS: zhanghui20
 * Date: 16/2/28
 * Email: zhanghui20@meituan.com
 */
public class StartApp {

    private static ClassPathXmlApplicationContext ctx;

    public static void main(String[] args){
        ctx = new ClassPathXmlApplicationContext("classpath:context.xml");
        FirstBlood fb = (FirstBlood)ctx.getBean("firstBlood");
        System.out.println("StartApp: " + fb.getContent());
        fb.opDB();
    }
}
