package com.liusir.thread.basic.collection;

import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class CollectionsTest {



    public static void main(String[] args) {
        test02();
    }

    public static void test02(){
        Enumeration<SEASON> enumeration =  Collections.enumeration(Arrays.asList(SEASON.values()));
        while (enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement().code);
        }

    }

    public static void test01(){
        List<Person> list = Arrays.asList(
                new Person("tom", 14),
                new Person("tomy", 18),
                new Person("joy", 17),
                new Person("jack", 20));
        List<Person> subList = Collections.unmodifiableList(list);
        subList.add(new Person("aa", 12));
    }
}

enum SEASON{


    SPRING("春天", "1"),SUMMER("夏天", "2"), AUTUMN("秋天", "3"), WINNER("冬天", "4");

    String name;
    String code;

    SEASON(String name, String code){
        this.name = name;
        this.code = code;
    }

}

class Person{
    private String name;
    private Integer age;

    public Person(String name, Integer age){

        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

