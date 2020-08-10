package frank;

public class Duck2 {
    private String name;
    private int age;

    public Duck2(String n, int a) {
        this.name = n;
        this.age = a;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Duck2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}