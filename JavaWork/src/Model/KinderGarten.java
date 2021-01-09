package Model;

public class KinderGarten {
    private int ChildNum; //孩子编号
    private String ChildName;//孩子名字
    private int ChildAge; //孩子年龄
    private String ChildSex;//孩子性别
    private String ChildClass;//孩子班级
    private int ChildHeader;//孩子班主任编号
    private String ChildStatus ;//孩子当前是否在幼儿园

    public int getChildNum() {
        return ChildNum;
    }

    public void setChildNum(int childNum) {
        ChildNum = childNum;
    }

    public String getChildName() {
        return ChildName;
    }

    public void setChildName(String childName) {
        ChildName = childName;
    }

    public int getChildAge() {
        return ChildAge;
    }

    public void setChildAge(int childAge) {
        ChildAge = childAge;
    }

    public String getChildSex() {
        return ChildSex;
    }

    public void setChildSex(String childSex) {
        ChildSex = childSex;
    }

    public String getChildClass() {
        return ChildClass;
    }

    public void setChildClass(String childClass) {
        ChildClass = childClass;
    }

    public int getChildHeader() {
        return ChildHeader;
    }

    public void setChildHeader(int childHeader) {
        ChildHeader = childHeader;
    }

    public String getChildStatus() {
        return ChildStatus;
    }

    public void setChildStatus(String childStatus) {
        ChildStatus = childStatus;
    }

    @Override
    public String toString() {
        return "KinderGarten{" +
                "ChildNum=" + ChildNum +
                ", ChildName='" + ChildName + '\'' +
                ", ChildAge=" + ChildAge +
                ", ChildSex='" + ChildSex + '\'' +
                ", ChildClass='" + ChildClass + '\'' +
                ", ChildHeader=" + ChildHeader +
                ", ChildStatus='" + ChildStatus + '\'' +
                '}';
    }
}
