package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void listProc(ArrayList<Integer> list, Predicate<Integer> p, int f) {//метод для умножения
        int n=0;
        for(Integer i : list){
            if(p.test(i)){
                list.set(n,i*f);
                }
                n++;
        }
    }

    public static void main(String[] args) {
        Consumer<List> out = s -> System.out.println(s);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);



        listProc(list, (n) -> (n%2)==0, 3);//проверка на четность и умножение
        listProc(list, (n) -> (n%2)!=0, 5);//проверка на нечетность
        out.accept(list);
    }
}
