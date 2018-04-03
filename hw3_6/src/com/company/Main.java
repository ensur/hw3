package com.company;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;


public class Main {


    public static void main(String[] args) {


        System.out.println();
       Sample ob = new Sample();//рефлексия
       Class<?> c = ob.getClass();

       Field[] m = c.getDeclaredFields();
       HashMap<String, Integer> ar = new HashMap<>();//создаем хэшмапу



      for(Field s : m){//идем по Field[], знаем, что s принимает значения строки

           ar.put(s.toString().split(" ")[0], ar.get(s.toString().split(" ")[0])==null ? 1 : ar.get(s.toString().split(" ")[0])+1 );//Работая со строкой берем первое слово, это ключ в мапе,
                                                                                                                                                    //достаём по нему количество вхождений, если null,
       }                                                                                                                                             //то ставим единицу(т.к. нашли элемент), если нет - прибавляем счетчик

        ar.forEach((k,v) -> System.out.println(k + " "+ v));//ну и вывод через лямду

    }
}