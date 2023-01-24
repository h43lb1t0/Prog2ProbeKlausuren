public class Main {
    public static void main(String[] args) {
        int a = Integer.MAX_VALUE - 300;
        int b = -200;
        if (a > Integer.MAX_VALUE - b) {
            System.out.println("foo");
        } else {
            int result = a + b;
        }

        int c = Integer.MIN_VALUE - 100;
        int d = 200;
        if (c > Integer.MIN_VALUE - d) {
            System.out.println("foo1");
        } else {
            int result1 = c - b;
        }

    }
}