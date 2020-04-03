package com.bit.demo4;

import java.util.Arrays;
class Student implements Comparable<Student>{   //需要特殊接口
    public String name;
    public int age;
    public int score;

    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        /*if(this.age<o.age) {          //根据age排序
            return -1;
        }
        if (this.age==o.age) {
            return 0;
        }
        return 1;*/
        return this.score-o.age;  //从小到大排序

        //return o.score-this.score;  //从大到小排序
    }

    @Override
    public String toString() { //打印类中的属性
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
public class TestDemo {
    //对自定义类型进行排序,一定要是可比较的，学生不可比较，所以需要特殊接口
    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student("类",12,22);
        students[1] = new Student("你",16,62);
        students[2] = new Student("打",13,52);
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }


    public static void main1(String[] args) {
        int[] array = {18,5,3,2,10};
        Arrays.sort(array);//排序
        System.out.println(Arrays.toString(array));

    }
}
