package com.company;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
    String s;
    s="Test sample sam string str s sa samr gdn";
    List<String> s2 = Arrays.asList(s.split(" "));//разделили строчку на слова и в лист
    List<String> list = s2.stream()//поток
            .filter(x -> x.startsWith("s"))//первая s
            .filter(x -> x.length()<5)//меньше 5
            .collect(Collectors.toList());

    list.stream()
            .forEach(x -> System.out.println(x + " : " + x.length()));//вывод
    System.out.println(list.size());

//            .forEach(x -> System.out.println(x + ":" + x.length())



    }

}
