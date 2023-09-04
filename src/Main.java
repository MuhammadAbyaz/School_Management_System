import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Menus menu = new Menus();


    public static void main(String[] args) {
        Db db = new Db();
        db.connectToDb();
        Admin admin = new Admin();
        homeScreen(admin);
    }

    public static void homeScreen(Admin admin) {
        int option = 0;
        while (option != 3) {
            menu.mainMenu();
            try {
                option = scanner.nextInt();
                if (option < 1 || option > 3) {
                    System.out.println("Invalid Input! Please Select from 1 - 3: ");
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid number");
                scanner.next();
            }
            if (option == 1) {
                menu.menuForTeacher();
                optionForTeacher(admin);
                return;
            } else if (option == 2) {
                menu.menuForStudent();
                optionForStudent(admin);
                return;
            }
        }
    }

    public static void optionForTeacher(Admin admin) {
        int option;
        try {
            option = scanner.nextInt();
            if (option < 1 || option > 5) {
                System.out.println("Please Select from 1 - 5: ");
            }
            if (option == 1) {
                admin.addTeacher();
            } else if (option == 2) {
                admin.removeTeacher();
            } else if (option == 3) {
                admin.viewTeacher();
            } else if (option == 4) {
                admin.editTeacher();
            }
        } catch (Exception e) {
            System.out.println("Please enter a valid number");
        }
        homeScreen(admin);
    }

    public static void optionForStudent(Admin admin) {
        int option;
        try {
            option = scanner.nextInt();
            if (option < 1 || option > 5) {
                System.out.println("Please Select from 1 - 5: ");
            }
            if (option == 1) {
                admin.addStudent();
            } else if (option == 2) {
                admin.removeStudent();
            } else if (option == 3) {
                admin.viewStudent();
            } else if (option == 4) {
                admin.editStudent();
            }
        } catch (Exception e) {
            System.out.println("Please enter valid number");
        }
        homeScreen(admin);
    }
}

