package ch14.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaEx5 {
    public static void main(String[] args) {
        Supplier<Integer> s = () -> (int)(Math.random()*100) + 1;
        Consumer<Integer> c = i -> System.out.println(i + ", ");
        Predicate<Integer> p = i -> i%2==0;
        Function<Integer, Integer> f = i -> i/10*10;    // i의 일의자리를 없앰

        List<Integer> list = new ArrayList<>();
        // list에 랜덤 숫자 10개가 저장됨
        makeRancomList(s, list);
        System.out.println(list);

        // list의 원소 중 짝수를 출력
        printEvenNum(p, c, list);

        // list와 같은 크기의 newList가 생성되고, 1의자리를 없앤 list의 원소가 newList에 저장됨
        List<Integer> newList = doSomething(f, list);
        System.out.println(newList);
    }

    static <T> List<T> doSomething(Function<T, T> f, List<T> list){
        List<T> newList = new ArrayList<>(list.size());

        for(T i : list){
            newList.add(f.apply(i));
        }
        return newList;
    }

    static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list){
        System.out.print("[");
        for(T i : list){
            if(p.test(i)) {
                c.accept(i);
            }
        }
        System.out.println("]");
    }

    static <T> void makeRancomList(Supplier<T> s, List<T> list) {
        for(int i=0;i<10;i++){
            list.add(s.get());
        }
    }
}
