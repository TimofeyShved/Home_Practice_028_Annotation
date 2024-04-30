package com.company;

import java.lang.reflect.Method;

public class BookAnnolizator {

    public void annolize(Class<?> clazz){
        Method[] methods = clazz.getMethods();

        for (Method m : methods){
            if (m.isAnnotationPresent(XMLAtribute.class)){
                XMLAtribute xmlAtribute = m.getAnnotation(XMLAtribute.class);
                System.out.println("search: " + xmlAtribute.name());
            }
            if (m.isAnnotationPresent(XMLElement.class)){
                XMLElement xmlAtribute = m.getAnnotation(XMLElement.class);
                System.out.println("search: " + xmlAtribute.name());
            }
        }
    }
}
