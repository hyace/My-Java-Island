package practice;

/**
 * Created by Hyace on 2015/9/1.
 */
public class StaticInnerClass {
    public static Integer membA = 1;

    public StaticInnerClass() {
        System.out.println("A: " + membA);
        System.out.println("B: " + membB);
//        System.out.println("D: " + Inner.membD);
//        System.out.println("A: "+membC);
    }

    public Integer membB = 2;

    static {
        Integer membC = 3;
        System.out.println("Static Block~" + membC);
        System.out.println("SA: " + membA);
//        System.out.println("A: "+membB);
        System.out.println("SC: " + membC);
//        System.out.println("SID: " + Inner.membD);
    }

    public static class Inner {
        public Inner() {
            System.out.println("IA: " + membA);
//            System.out.println("B: " + membB);
//            System.out.println("C: " + membC);
            System.out.println("ID: " + membD);
            System.out.println("IE: " + membE);
        }

        static Integer membD = 4;
        Integer membE = 5;

        static {
            System.out.println("ISA: " + membA);
//            System.out.println("B: " + membB);
//        System.out.println("C: "+membC);
            System.out.println("ISD: " + membD);
//            System.out.println("E: " + membE);
        }

        public static void printStatic() {
            System.out.println("IPA: " + membA);
//            System.out.println("B: " + membB);
//            System.out.println("C: " + membC);
            System.out.println("IPD: " + membD);
//            System.out.println("IPE: " + membE);

        }

        public void print() {
            System.out.println("IPA: " + membA);
//            System.out.println("B: " + membB);
//            System.out.println("C: " + membC);
            System.out.println("IPD: " + membD);
            System.out.println("IPE: " + membE);

        }
    }


}
