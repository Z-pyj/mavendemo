package com.course.base.day01;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();

        //TreeSet自然排序
        set.add(5);
        set.add(2);
        set.add(9);
        System.out.println(set);

        //for...each变量TreeSet
        for (Integer s: set) {
            System.out.println(s);
        }
        Person p1 = new Person("李四",3);
        Person p2 = new Person("赵四",56);
        Person p3 = new Person("王二",32);
        Person p4 = new Person("张三",13);
        Person p5 = new Person("王二麻子",2);

        //自定义排序
        Set<Person> set1 = new TreeSet<>(new Person());
        set1.add(p1);
        set1.add(p2);
        set1.add(p3);
        set1.add(p4);
        set1.add(p5);

        for (Person p :
                set1) {
            System.out.println(p.age+"    "+p.name);
        }

    }

}

/**
 * 自定义安装Person类的age属性正序排列
 */
class Person implements Comparator<Person> {
    String name;
    int age;
    public Person(){}
    public Person(String name, int age){
        this.age=age;
        this.name=name;
    }


    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.age, o2.age);
    }
}
