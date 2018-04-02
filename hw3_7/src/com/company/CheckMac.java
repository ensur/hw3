package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckMac {
    public String getMac(){//метод чтения
        Scanner in = new Scanner(System.in);
        System.out.println("Put mac:");
        return in.nextLine();
    }
    public void checkMac(){//метод проверки
        Pattern p = Pattern.compile("^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$");//регулярка
        Matcher m = p.matcher(getMac());//проверка)
        System.out.println(m.matches());//вывод
    }
}
