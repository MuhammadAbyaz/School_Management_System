import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        School school = new School();
        homeScreen(school);

    }

    public static void homeScreen(School school) {
        int option=0;
        while (!(option==5)) {
            System.out.println("\t\t\t\t ______________________________________");
            System.out.println("\t\t\t\t|                                      |");
            System.out.println("\t\t\t\t|  Welcome to School Management System |");
            System.out.println("\t\t\t\t|______________________________________|");
            System.out.println("\t\t\t\t      _______________________");
            System.out.println("\t\t\t\t     |   |                   |");
            System.out.println("\t\t\t\t     | 1 | School            |");
            System.out.println("\t\t\t\t     | 2 | Admin             |");
            System.out.println("\t\t\t\t     | 3 | Teacher           |");
            System.out.println("\t\t\t\t     | 4 | Student           |");
            System.out.println("\t\t\t\t     | 5 | Exit              |");
            System.out.println("\t\t\t\t     |___|___________________|");
            try {
                option = sc.nextInt();
                if (option < 1 || option > 5) {
                    System.out.println("Invalid Input! Please Select from 1 - 5: ");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            if (option == 1) {
                mainMenuForSchool(school);
            } else if (option == 2) {
                mainMenuForAdmin();
            } else if (option == 3){
                mainMenuForTeacher();
            } else if (option == 4) {
                mainMenuForStudent();
            }
        }
    }

    public static void mainMenuForSchool(School school) {
        System.out.println("\t\t\t\t      ___________________________");
        System.out.println("\t\t\t\t     |   |                       |");
        System.out.println("\t\t\t\t     | 1 | Add a Student         |");
        System.out.println("\t\t\t\t     | 2 | Delete a Student      |");
        System.out.println("\t\t\t\t     | 3 | Add a Teacher         |");
        System.out.println("\t\t\t\t     | 4 | Delete a Teacher      |");
        System.out.println("\t\t\t\t     | 5 | Add an admin          |");
        System.out.println("\t\t\t\t     | 6 | Remove an admin       |");
        System.out.println("\t\t\t\t     | 7 | Back                  |");
        System.out.println("\t\t\t\t     |___|_______________________|");

        System.out.println("Select from above: ");
        int option = 0;
        while (!(option ==7)){
            try {
                option = sc.nextInt();
                if (option < 1 || option > 7) {
                    System.out.println("Invalid Input! Please Select from 1 - 7: ");
                }
            } catch (Exception e) {
                System.out.println();
            }
            if (option == 1) {
                school.addStudent(new Student());
                option = 7;
            } else if (option == 2) {
                school.removeStudent();
                option = 7;
            } else if (option == 3) {
                school.addTeacher(new Teacher());
                option = 7;
            } else if (option == 4) {
                school.removeTeacher();
                option = 7;
            } else if (option == 5) {
                school.addAdmin(new Admin());
                option = 7;
            } else if (option == 6) {
                school.removeAdmin();
                option = 7;
            }
        }
    }

    public static void mainMenuForAdmin() {
        System.out.println("\t\t\t\t      ___________________________");
        System.out.println("\t\t\t\t     |   |                       |");
        System.out.println("\t\t\t\t     | 1 | Add a Student         |");
        System.out.println("\t\t\t\t     | 2 | Delete a Student      |");
        System.out.println("\t\t\t\t     | 3 | Edit a Student        |");
        System.out.println("\t\t\t\t     | 4 | Add a Teacher         |");
        System.out.println("\t\t\t\t     | 5 | Delete a Teacher      |");
        System.out.println("\t\t\t\t     | 6 | Edit a Teacher        |");
        System.out.println("\t\t\t\t     | 7 | Edit an admin         |");
        System.out.println("\t\t\t\t     | 8 | Back                  |");
        System.out.println("\t\t\t\t     |___|_______________________|");

        System.out.println("Select from above: ");
        int option = 0;
        while (option < 1) {
            try {
                option = sc.nextInt();
                if (option < 1 || option > 8) {
                    System.out.println("Invalid Input! Please Select from 1 - 8: ");
                }
            } catch (Exception e) {
                System.out.println();
            }
            if (option == 1) {
                mainMenuForAdmin();
            } else if (option == 2) {
                mainMenuForTeacher();
            }
        }
    }

    public static void mainMenuForTeacher() {
        System.out.println("\t\t\t\t      ___________________________");
        System.out.println("\t\t\t\t     |   |                       |");
        System.out.println("\t\t\t\t     | 1 | View Profile          |");
        System.out.println("\t\t\t\t     | 2 | Edit Profile          |");
        System.out.println("\t\t\t\t     | 3 | Edit a Student        |");
        System.out.println("\t\t\t\t     | 4 | Back                  |");
        System.out.println("\t\t\t\t     |___|_______________________|");

        System.out.println("Select from above: ");
        int option = 0;
        while (option < 1) {
            try {
                option = sc.nextInt();
                if (option < 1 || option > 4) {
                    System.out.println("Invalid Input! Please Select from 1 - 4: ");
                }
            } catch (Exception e) {
                System.out.println();
            }
            if (option == 1) {
                mainMenuForAdmin();
            } else if (option == 2) {
                mainMenuForTeacher();
            }
        }
    }

    public static void mainMenuForStudent() {
        System.out.println("\t\t\t\t      __________________________");
        System.out.println("\t\t\t\t     |   |                      |");
        System.out.println("\t\t\t\t     | 1 | View Profile         |");
        System.out.println("\t\t\t\t     | 2 | Edit Profile         |");
        System.out.println("\t\t\t\t     | 3 | Back                 |");
        System.out.println("\t\t\t\t     |___|______________________|");

        System.out.println("Select from above: ");

        int option = 0;
        while (option < 1) {
            try {
                option = sc.nextInt();
                if (option < 1 || option > 3) {
                    System.out.println("Invalid Input! Please Select from 1 - 3: ");
                }
            } catch (Exception e) {
                System.out.println();
            }
            if (option == 1) {
                mainMenuForAdmin();
            } else if (option == 2) {
                mainMenuForTeacher();
            }
        }
    }
}
