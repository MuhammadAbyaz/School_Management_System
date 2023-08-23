import java.util.ArrayList;
import java.util.Scanner;

public class Teacher {
    Scanner scanner = new Scanner(System.in);
    private String name;
    private String address;
    private int employeeId;

    private ArrayList<String> subjectsToTeach;

    public Teacher(){
        System.out.println("Enter Teacher's name: ");
        String name = scanner.next();
        System.out.println("Enter Teacher's address");
        String address = scanner.next();
        String subjects;
        System.out.println("Enter subjects you can teach");
        for (int i = 0; i <=subjectsToTeach.size(); i++) {
            subjectsToTeach.add(subjects = scanner.next());
        }
        employeeId = (int) (Math.random()*100000);
        System.out.println("Your employee id is: " + employeeId);
        this.name = name;
        this.address = address;
        this.subjectsToTeach = new ArrayList<String>();
    }
    public String getName() {
        return name;
    }

    public ArrayList<String> getSubjectsToTeach() {
        return subjectsToTeach;
    }

    public String getAddress() {
        return address;
    }

    public int getEmployeeId() {
        return employeeId;
    }
}
