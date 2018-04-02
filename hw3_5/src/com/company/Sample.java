package com.company;
import java.lang.annotation.*;
import java.lang.reflect.Method;


public class Sample{
    @Argument(value = 6)
    public static void sample(){
        Sample ob = new Sample();
        try{ // для "взятия аннотации из метода"        //
            Class<?> c = ob.getClass();                 //рефлексия
            Method m = c.getMethod("sample");     //
            Argument arg = m.getAnnotation(Argument.class);//достаём аннотацию
            for(int j=1;j<=arg.value();j++){//табличка
                for(int i=1;i<10;i++){
                    System.out.println(j + "*" + i +"=" + i*j);

                }
                System.out.println(" ");
            }

        }catch (NoSuchMethodException exc) {
            System.out.println("No Method");//если не нашли метод
        }


    }

}
