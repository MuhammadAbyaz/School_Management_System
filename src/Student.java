public class Student {

    private final String name;
    private final String address;
    private final int grade;
    private final int id;
    private int ID = 0;
    
    public Student(String name, String address, int grade) {
        this.id = generateId();
        this.name = name;
        this.address = address;
        this.grade = grade;
    }

    public int generateId() {
        return ID++;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public int getGrade() {
        return grade;
    }

    public void printStudent() {
        System.out.println("Id      : " + getId());
        System.out.println("Name    : " + getName());
        System.out.println("Address : " + getAddress());
        System.out.println("Grade   : " + getGrade());
    }
}
