package wrapper;
public class Wrapper {
    public static void main(String[] args) {

        int num1 = 10;
        int num2 = 20;

        Integer a = new Integer(num1);
        Integer b = new Integer(num2);

        System.out.println(a);
        System.out.println(b);

        String str1 = "123";
        String str2 = "45.67";

        Integer x = Integer.valueOf(str1);
        System.out.println(x);

        Double y = Double.valueOf(str2);
        System.out.println(y);

        Integer n = new Integer(789);
        Double m = new Double(12.34);

        String s1 = n.toString();
        String s2 = m.toString();

        System.out.println(s1);
        System.out.println(s2);
    }
}