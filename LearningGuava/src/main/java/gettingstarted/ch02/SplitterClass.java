package gettingstarted.ch02;

import org.junit.Test;

/**
 * Created by Chyace on 2015/8/3.
 */
public class SplitterClass {
    @Test
    public void splitterTest(){
        String originString = "沈阳军区,北京军区,济南军区,兰州军区,成都军区,南京军区,广州军区,,,";
        String[] stringSplit = originString.split(",");
        System.out.println("Length of array:"+stringSplit.length);
        for(String str : stringSplit){
            System.out.print(str + " ");
        }

    }
}
