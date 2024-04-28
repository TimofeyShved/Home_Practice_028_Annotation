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
@Retention(RetentionPolicy.RUNTIME)
@interface Repeat {
    int value();
}

class CustomThreadPoolExecutor extends ThreadPoolExecutor {
    public CustomThreadPoolExecutor(int corePoolSize) {
        // why Integer.MAX_VALUE, 0m and TimeUnit.MILLISECONDS?
        // see Executors.newFixedThreadPool(int nThreads)
        super(corePoolSize, Integer.MAX_VALUE, 0, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());
    }

    @Override
    public void execute(Runnable command) {
        if (command != null) {
            Class<? extends Runnable> runnableClass = command.getClass();
            Repeat repeat = runnableClass.getAnnotation(Repeat.class);
            for (int i = 0; i < (repeat != null ? repeat.value() : 1); i++) {
                super.execute(command);
            }
        }
    }
}
~~~

Итог: 
--------

>- [X] Есть готовое решение 
>- [ ] Свой код написан 
