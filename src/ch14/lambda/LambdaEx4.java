package ch14.lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LambdaEx4{
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<10;i++)
            list.add(i);

        // list의 모든 요소 출력
        // void forEach(Consumer<T> action)
        list.forEach(i -> System.out.println(i + ", "));
        System.out.println();

        // list에서 2 또는 3의 배수 제거
        // boolean removdIf(Predicate<E> filter)
        list.removeIf(x -> x%2==0 || x%3==0);
        System.out.println();

        // list의 각 요소에 10을 곱함
        // void replaceAll(UnaryOperator<E> operator)
        list.replaceAll(i -> i*10);

        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");

        // map의 요소를 {k, v} 형태로 출력
        // void forEach(BiConsumer<K,V> action)
        map.forEach((k,v)-> System.out.println("{" + k +", " + v + "}, "));
        System.out.println();

        /* 실행결과
        0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        [1, 5, 7]
        [10, 50, 70]
        {1, 1}, {2, 2}, {3, 3}, {4, 4}
         */
    }
}
