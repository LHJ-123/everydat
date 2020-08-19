package test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TestGson {
    static class Student {
        private String name;
        private int id;
        private double score;

        public Student(String name, int id, double score) {
            this.name = name;
            this.id = id;
            this.score = score;
        }
    }
    public static void main(String[] args) {
        //实例化Gson对象，工厂模式
        Gson gson = new GsonBuilder().create();
       //把一个对象转为JSON字符串
       Student student = new Student("nihao",1,99);
       String jsonString = gson.toJson(student);
        System.out.println(jsonString);
        //把JSON字符串转为对象
        String str = "{\"name\":\"nihao\",\"id\":1,\"score\":99.0}";
        Student s = gson.fromJson(str,Student.class);
        System.out.println(s.id+" "+s.name+" "+s.score);
    }
}
