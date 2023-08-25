import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Teacher {
    Scanner scanner = new Scanner(System.in);
    private String name;
    private String address;
    private int employeeId;
    private String[] subjectsToTeach;
    private School school;


    public Teacher() {
        System.out.println("Enter Teacher's name: ");
        String name = scanner.next();
        System.out.println("Enter Teacher's address");
        String address = scanner.next();
        System.out.println("How many subjects will he teach? ");
        int subject = scanner.nextInt();
        this.subjectsToTeach = new String[subject];
        String subjects;
        for (int i = 0; i <= subjectsToTeach.length - 1; i++) {
            System.out.println("Enter " + i + 1 + " subject: ");
            subjects = scanner.next();
            subjectsToTeach[i] = subjects;
        }
        employeeId = (int) (Math.random() * 100000);
        System.out.println("Teacher's employee id is: " + employeeId);
        this.name = name;
        this.address = address;
    }

    Teacher(School school) {
        this.school = school;
    }

    public String getName() {
        return name;
    }


    public String getAddress() {
        return address;
    }

    public String[] getSubjectsToTeach() {
        return subjectsToTeach;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void viewProfile() {
        school.viewTeacherProfile();
    }
}

