package other;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by chyace on 15-7-18.
 */
public class DeepClone {
    class A implements Cloneable{
        private int a;
        private BigDecimal b;
        private Integer c;
        private String d;
        private A e;

        public A(){
        }

        public A(int a, BigDecimal b, Integer c, String d, A e) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
        }

        public int getA() {
            return a;
        }

        public BigDecimal getB() {
            return b;
        }

        public Integer getC() {
            return c;
        }

        public String getD() {
            return d;
        }

        public A getE() {
            return e;
        }

        public void setA(int a) {
            this.a = a;
        }

        public void setB(BigDecimal b) {
            this.b = b;
        }

        public void setC(Integer c) {
            this.c = c;
        }

        public void setD(String d) {
            this.d = d;
        }

        public void setE(A e) {
            this.e = e;
        }

        @Override
        protected A clone() throws CloneNotSupportedException {
            return (A)super.clone();
        }
    }

    /**
     * 重写clone方法的类需要实现cloneable接口，复制出来的新对象和原对象不同，但是引用类型的成员变量没有变化。
     * @throws CloneNotSupportedException
     */
    @Test
    public void cloneTest() throws CloneNotSupportedException {
        A obja = new A(2,new BigDecimal("2.33"),277,"Test!",new A());
        A objb = obja.clone();

        System.out.println(obja.hashCode()+" VS "+objb.hashCode());
        System.out.println("int value : " + obja.getA() + " VS " + objb.getA());
        System.out.println("BigDecimal hashCode : " + obja.getB().hashCode()+" VS "+objb.getB().hashCode());
        System.out.println("Integer hashCode : "+obja.getC().hashCode()+" VS "+objb.getC().hashCode());
        System.out.println("String hashCode : "+obja.getD().hashCode()+" VS "+objb.getD().hashCode());
        System.out.println(obja.getD()==objb.getD());
        System.out.println("A hashCode : "+obja.getE().hashCode()+" VS "+objb.getE().hashCode());
        String f = new String("Test!");
        System.out.println(f == obja.getD());
        String g = new String("Test!").intern();
        System.out.println(g == f);
        System.out.println(g.hashCode());
        System.out.println(f.hashCode());
    }
}
