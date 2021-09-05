package ch14.lambda;

@FunctionalInterface
interface MyFunction3 {
    void myMethod();
}

class Outer {
    int val = 10;   // Outer.this.val

    class Inner {
        int val = 20;   // this.val

        // 람다식 내에서 참조하는 지역변수는 final이 붙지 않았어도 상수로 간주됨
        void method(int i) {    // void method(final int i)
            int val = 30;       // final int val = 30;

            MyFunction3 f = () -> {
                System.out.println("             i : " + i);
                System.out.println("           val : " + val);
                System.out.println("      this.val : " + ++this.val);
                System.out.println("Outer.this.val : " + ++Outer.this.val);
            };

            f.myMethod();
        }
    } // end of Inner
}// end of Outer


public class LambdaEx3 {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.method(100);

        /* 실행결과
                     i : 100
                   val : 30
              this.val : 21
        Outer.this.val : 11
         */
    }
}
