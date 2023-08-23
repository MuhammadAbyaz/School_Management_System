import java.util.Scanner;

public class Student {

    public Scanner scanner =new Scanner(System.in);

    private String name;
    private String address;
    private int grade;
    private int id;

    public Student(){
        System.out.println("Enter Student's name: ");
        String name= scanner.next();
        System.out.println("Enter Student's address: ");
        String address = scanner.next();
        System.out.println("Enter Student's grade: ");
        int grade = scanner.nextInt();
        id = (int) (Math.random()*100000);
        System.out.println("Your Student Id is: " + id);

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

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getGrade() {
        return grade;
    }


    public int getId() {
        return id;
    }
}
