package com.company;

import java.util.function.Function;
import java.util.function.Predicate;

public class Main {


    public static <T, U> Function<T, U> ternaryOperator(Function<? super T,? extends U> ifTrue, Function<? super T,? extends U> ifFalse, Predicate<? super T> condition){
//        Function<String, Integer> result = s -> (Integer) (condition.test((T) s)? ifTrue.apply((T) s) : ifFalse.apply((T) s));
//        System.out.println(result.apply("Vasya Pupkin"));
        return x -> condition.test(x) ? ifTrue.apply(x) : ifFalse.apply(x);
    }
    public static void main(String[] args) {
        Function<String, Integer> ifTrue = s -> s.length();
        Function<String, Integer> ifFalse = s -> s.hashCode();
        Predicate<String> condition = s -> s.length() > 0;
        System.out.println((ternaryOperator(ifTrue,ifFalse,condition).apply("Vasya Pupkin")));


    }
}
