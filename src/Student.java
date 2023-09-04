public class Student {

    private String name;
    private String address;
    private int grade;


    public Student(String name, String address, int grade) {
        this.name = name;
        this.address = address;
        this.grade = grade;
    }
    

    public String getName() {
        return name;
    }


    public String getAddress() {
        return address;
    }

    public int getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

}
