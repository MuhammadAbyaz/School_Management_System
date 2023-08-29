import java.util.Scanner;

public class Menus {
    Scanner scanner = new Scanner(System.in);

    public void mainMenu() {
        System.out.println("\t\t\t\t ______________________________________");
        System.out.println("\t\t\t\t|                                      |");
        System.out.println("\t\t\t\t|  Welcome to School Management System |");
        System.out.println("\t\t\t\t|______________________________________|");
        System.out.println("\t\t\t\t      _______________________");
        System.out.println("\t\t\t\t     |   |                   |");
        System.out.println("\t\t\t\t     | 1 | Teacher           |");
        System.out.println("\t\t\t\t     | 2 | Student           |");
        System.out.println("\t\t\t\t     | 3 | Exit              |");
        System.out.println("\t\t\t\t     |___|___________________|");
    }

    public void menuForTeacher(Admin admin) {
        System.out.println("\t\t\t\t      ___________________________");
        System.out.println("\t\t\t\t     |   |                       |");
        System.out.println("\t\t\t\t     | 1 | Add Profile           |");
        System.out.println("\t\t\t\t     | 2 | Remove Profile        |");
        System.out.println("\t\t\t\t     | 3 | View Profile          |");
        System.out.println("\t\t\t\t     | 4 | Back                  |");
        System.out.println("\t\t\t\t     |___|_______________________|");

        System.out.println("Select from above: ");
        int option = 0;
        try {
            option = scanner.nextInt();
            if (option < 1 || option > 4) {
                System.out.println("Please Select from 1 - 4: ");
            }
            if (option == 1) {
                admin.addTeacher();
            } else if (option == 2) {
                admin.removeTeacher();
            } else if (option == 3) {
                Teacher teacher = admin.getTeacherById();
                teacher.printTeacher();
            }
        } catch (Exception e) {
            System.out.println("Please enter a valid number");
            scanner.next();
        }
    }

    public void menuForStudent(Admin admin) {
        System.out.println("\t\t\t\t      __________________________");
        System.out.println("\t\t\t\t     |   |                      |");
        System.out.println("\t\t\t\t     | 1 | Add Profile          |");
        System.out.println("\t\t\t\t     | 2 | Remove Profile       |");
        System.out.println("\t\t\t\t     | 3 | View Profile         |");
        System.out.println("\t\t\t\t     | 4 | Back                 |");
        System.out.println("\t\t\t\t     |___|______________________|");

        System.out.println("Select from above: ");
        int option = 0;
        try {
            option = scanner.nextInt();
            if (option < 1 || option > 4) {
                System.out.println("Please Select from 1 - 4: ");
            }
            if (option == 1) {
                admin.addStudent();
            } else if (option == 2) {
                admin.removeStudent();
            } else if (option == 3) {
                Student student = admin.getStudentById();
                student.printStudent();
            }
        } catch (Exception e) {
            System.out.println("Please enter valid number");
        }
    }
}
