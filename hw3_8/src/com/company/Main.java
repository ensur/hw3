package com.company;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static String getData(){//взятие даты
        Scanner in = new Scanner(System.in);
        System.out.println("Put data:");
        return in.next();

    }
    public static String getTemplate(){//взятие шаблона
        Scanner in = new Scanner(System.in);
        System.out.println("Put data template:");
        return in.next();
    }
    public static String makeReg(){//создаём регулярку
        String temp = getTemplate();
        Pattern delimiter = Pattern.compile("\\W");//разделитель
        List<String> formatData = new ArrayList<>();//лист для кусков шаблона без разделителя
        List<Integer> indexDelimeter = new ArrayList<>();//индекс разделителя
        List<String> regExp = new ArrayList<>();//лист для регулярок
        int mem = 0;
        for(int i=0; i<temp.length(); i++){//цикл по строчке, ищем разделители
            char c = temp.charAt(i);//костыль для matcher(String)
            String s = ""+c;
            if(delimiter.matcher(s).find()){//нашли разделитель
                indexDelimeter.add(i);//добавили в соответствующий лист
                formatData.add(temp.substring(mem, i));//добавили кусок строки в соответствующий лист
                mem=i+1;
                }
        }
        formatData.add(temp.substring(mem, temp.length()));//Чей туфля? Ой, моё! это чтобы последний кусок после разделителя тоже добавило
        //formatData.forEach(s -> System.out.println("format data:" + s + "Format data size: " + formatData.size()));
        for(int i=0; i<formatData.size(); i++){//это ставим соответствие листу с кусками - соответствующий по индексам лист регулярок
           // System.out.println("Индекс : " + i + ", берем длину элемента :" + formatData.get(i));
            switch(formatData.get(i).length()){
                case 2:
                    regExp.add("([0-9][0-9])");//регулярка для dd/mm/yy
                    break;
                case 4:
                    regExp.add("([0-9]{1,4})");//регулярка для yyyy
                    break;
            }
            //System.out.println("Добавлена регулярка: " + regExp.get(i) + " с индексом " + i);
        }

        //indexDelimeter.forEach(s -> System.out.println(s));
       // regExp.forEach(s -> System.out.println(s));
        String reg = regExp.get(0) + "[" + temp.charAt(indexDelimeter.get(0)) + "]"+ regExp.get(1) +"[" + temp.charAt(indexDelimeter.get(1)) + "]"+regExp.get(2);
        System.out.println("Regulyarrrrrka:" + reg); //составили наше регулярное выражение. Разделителей два, если больше то нужно это всё пихать в цикл и ставить их по циклу, но давайте пользователь умный, иначе быдлокод получается :(
        return reg;
    }
    public static void testData(String reg, String data){
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(data);
        System.out.println("Validation for " + data  +
                (matcher.matches() ? " passed." : " not passed."));//тест
    }

    public static void main(String[] args) {

        testData(makeReg(), getData());
    }
}//P.S. Програмка сыровата, понимаю, знаю как доделать, но пора делать юнит тесты, иначе в чт. буду плавать и новое накопится, если
// считаете, что всё это не Рио-де-Жанейро, а гораздо хуже, то наверное тогда ставить как есть дз, без этой проги.