package ch14.lambda;

public class LambdaEx2 {
    public static void main(String[] args) {
        // 형변환 생략 가능
        // MyFunction F = (MyFunction) (()->{});
        MyFunction f = () -> {};

        // 람다식은 Object로 형변환할 수 없음
        // 굳이 Object로 형변환하려면, 먼저 함수형 인터페이스로 형변환 한 후 Object 타입으로 형변환 해야 함
        Object obj = (Object) (MyFunction) (()->{});
        String str = ((Object)(MyFunction) (()->{})).toString();

        System.out.println(f);
        System.out.println(obj);
        System.out.println(str);

//        System.out.println(()->{});
        System.out.println( (MyFunction)(()->{}) );
//        System.out.println((MyFunction)(()->{}).toString());
        System.out.println( ((Object)(MyFunction) (()->{})).toString() );

        /* 실행결과
        ch14.lambda.LambdaEx2$$Lambda$1/1324119927@3d075dc0
        ch14.lambda.LambdaEx2$$Lambda$2/1078694789@214c265e
        ch14.lambda.LambdaEx2$$Lambda$3/1831932724@682a0b20
        ch14.lambda.LambdaEx2$$Lambda$4/1149319664@7cca494b
        ch14.lambda.LambdaEx2$$Lambda$5/2074407503@3b9a45b3

        컴파일러가 만든 람다식의 타입 형식 : '외부클래스이름$$Lambda$번호'
        일반 클래스의 타입 형식 : '외부클래스이름$번호'
        */
    }
}
