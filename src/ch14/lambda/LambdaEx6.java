package ch14.lambda;

import java.util.Arrays;
import java.util.function.*;

public class LambdaEx6 {
    public static void main(String[] args) {
        IntSupplier s = () -> (int)(Math.random()*100) + 1;
        IntConsumer c = i -> System.out.println(i + ", ");
        IntPredicate p = i -> i%2==0;
        // intFunction이 아닌 intUnaryOpertor 사용하는 이유
        // 오토박싱 & 언박싱의 횟수가 줄어들어 더 성능이 좋음
        IntUnaryOperator op = i -> i/10*10;    // i의 일의자리를 없앰

        int arr[] = new int[10];

        // arr에 랜덤 숫자 10개가 저장됨
        makeRancomList(s, arr);
        System.out.println(Arrays.toString(arr));

        // arr의 원소 중 짝수를 출력
        printEvenNum(p, c, arr);

        // arr와 같은 크기의 newArr가 생성되고, 1의자리를 없앤 arr의 원소가 newArr에 저장됨
        int newArr[] = doSomething(op, arr);
        System.out.println(Arrays.toString(newArr));
    }

    static int[] doSomething(IntUnaryOperator op, int arr[]){
        int newArr[] = new int[arr.length];

        for(int i=0;i<newArr.length;i++){
            newArr[i] = op.applyAsInt(arr[i]);
        }
        return newArr;
    }

    static void printEvenNum(IntPredicate p, IntConsumer c, int arr[]){
        System.out.print("[");
        for(int i : arr){
            if(p.test(i)) {
                c.accept(i);
            }
        }
        System.out.println("]");
    }

    static void makeRancomList(IntSupplier s, int arr[]) {
        for(int i=0;i<10;i++){
            arr[i] = s.getAsInt();
        }
    }
}
