import java.util.Scanner;

public class Admin {
    Scanner scanner = new Scanner(System.in);
    private String name;
    private String address;

    private int employeeId;
    private School school;


    public Admin (){
        System.out.println("Enter admin name: ");
        String name = scanner.next();
        System.out.println("Enter admin address: ");
        String address = scanner.next();
        employeeId = (int)(Math.random()*100000);
        System.out.println("Your Employee id is: " + employeeId);
        this.name = name;
        this.address = address;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getEmployeeId() {
        return employeeId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public School getSchool() {
        return school;
    }

    Admin(School school) {
        this.school = school;
    }

    public void addTeacher(Teacher teacher){
        this.school.addTeacher(teacher);
    }
    public void removeTeacher(int teacherId){
        this.school.removeTeacher();
    }
    public void addStudent(Student student){
        this.school.addStudent(student);
    }
    public void removeStudent(int studentId){
        this.school.removeStudent();
    }
}
