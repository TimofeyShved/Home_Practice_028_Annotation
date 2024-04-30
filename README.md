# Аннотация

9.1. Своя аннотация — создание и использование

![](C:\Users\Admin\IdeaProjects\Home_Practice_028_Annotation\4.png)
![](C:\Users\Admin\IdeaProjects\Home_Practice_028_Annotation\2.png)
![](C:\Users\Admin\IdeaProjects\Home_Practice_028_Annotation\1.png)
![](C:\Users\Admin\IdeaProjects\Home_Practice_028_Annotation\3.png)
___

Задача
--------

> Создайте две свои аннотации: XMLAtribute и XMLElement с полем 

~~~Java
String name();
~~~

> Задать Target и Retention.
> 
> В текстовом классе отметить соответствующую сущность аннотациями
>
> С помощью рефлексии вывести список аннотаций в текстовое поле name



___
Решение:
--------

Производитель:

~~~Java
public class BookAnnolizator {

    public void annolize(Class<?> clazz){
        Method[] methods = clazz.getMethods();

        for (Method m : methods){
            if (m.isAnnotationPresent(XMLAtribute.class)){
                XMLAtribute xmlAtribute = m.getAnnotation(XMLAtribute.class);
                System.out.println(xmlAtribute.name());
            }
            if (m.isAnnotationPresent(XMLElement.class)){
                XMLElement xmlAtribute = m.getAnnotation(XMLElement.class);
                System.out.println(xmlAtribute.name());
            }
        }
    }
}
~~~

Итог: 
--------

>- [X] Есть готовое решение 
>- [X] Свой код написан 
