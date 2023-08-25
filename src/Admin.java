import java.util.Scanner;

public class Admin {
    Scanner scanner = new Scanner(System.in);
    private String name;
    private String address;

    private int employeeId;
    private School school;

    public String getName() {
        return name;
    }


    public int getEmployeeId() {
        return employeeId;
    }

    public String getAddress() {
        return address;
    }

    public Admin() {
        System.out.println("Enter admin name: ");
        String name = scanner.next();
        System.out.println("Enter admin address: ");
        String address = scanner.next();
        employeeId = (int) (Math.random() * 100000);
        System.out.println("Admin\n's employee id is: " + employeeId);
        this.name = name;
        this.address = address;
    }

    public Admin(School school) {
        this.school = school;
    }


    public void addTeacher(Teacher teacher) {
        school.addTeacher(teacher);
    }

    public void removeTeacher() {
        school.removeTeacher();
    }

    public void addStudent(Student student) {
        school.addStudent(student);
    }

    public void removeStudent() {
        school.removeStudent();
    }

    public void viewStudentProfile() {
        school.viewStudentProfile();
    }

    public void viewTeacherProfile() {
        school.viewTeacherProfile();
    }

    public void viewAdminProfile() {
        school.viewAdminProfile();
    }

}
