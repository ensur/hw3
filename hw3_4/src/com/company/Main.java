package com.company;



import java.util.*;
import java.util.function.Function;

import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Students student = new Students();//студент
        student.name.add("Bob");
        student.name.add("Karl");
        student.name.add("Mark");
        student.name.add("John");
        student.name.add("Dan");
        student.name.add("Ben");
        student.fac.add("Falt");
        student.fac.add("Falt");
        student.fac.add("Fopf");
        student.fac.add("Frtk");
        student.fac.add("Fupm");
        student.fac.add("Fnbic");
        student.fac.add("Frtk");
        student.fac.add("Fnbic");
        student.fac.add("Fnbic");

        System.out.println("Факультеты:");//сортировка через поток
        student.fac.stream()
                .sorted()
                .distinct()
                .forEach(p -> System.out.println(p));


        Map<String, Long> tops;//создаем мапу
        tops = student.fac.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));//собираем по совпадениям+счетчик

        System.out.println("Топ 3:");
        tops.entrySet().stream()
                .sorted(Comparator.comparing(
                        (Function<Map.Entry<String, Long>, Long>) Map.Entry::getValue).reversed())//по значению в обратную сторону
                .limit(3)//топ 3
                .forEach(x -> System.out.println(x.getKey()));//вывод
    }
}
