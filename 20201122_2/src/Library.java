public class Library {
    public String _name;
    public String _num;
    public String _isUsed;
    public String _capacity;

    Library(String name, String num, String isUsed, String capacity) {
        _name = name;
        _num = num;
        _isUsed = isUsed;
        _capacity = capacity;
    }



    @Override
    public String toString() {
        return "Library{" +
                "实验室名称：'" + _name + '\'' +"'\n"+
                ",实验室编号：'" + _num + '\'' +"\n"+
                ",实验室是否使用：'" + _isUsed + '\'' +"\n"+
                ",实验室容量：'" + _capacity + '\'' +"\n"+
                '}';
    }
}
