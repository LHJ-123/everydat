public class User {
    private String name;

    public String getName() {
        return name;
    }

    public User(String name) {
        this.name = name;
    }

    public User() {
        System.out.println("无参");
    }

    public void setName(String name) {
        this.name = name;
    }
    public void show() {
        System.out.println("name= "+name);
    }
}
