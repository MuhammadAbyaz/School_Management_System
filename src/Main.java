import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        School school = new School();
        Admin admin = new Admin();
        school.addAdmin(admin);
        homeScreen(school, admin);
    }

    public static void homeScreen(School school, Admin admin) {
        int option = 0;
        while (!(option == 5)) {
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
                option = scanner.nextInt();
                if (option < 1 || option > 5) {
                    System.out.println("Invalid Input! Please Select from 1 - 5: ");
                }
                if (option == 1) {
                    mainMenuForSchool(school);
                } else if (option == 2) {
                    mainMenuForAdmin(admin);
                } else if (option == 3) {
                    mainMenuForTeacher(school);
                } else if (option == 4) {
                    mainMenuForStudent(school);
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid number");
                scanner.next();
            }
        }
    }

    public static void mainMenuForSchool(School school) {
        int option = 0;
        while (!(option == 10)) {
            System.out.println("\t\t\t\t      ___________________________");
            System.out.println("\t\t\t\t     |   |                       |");
            System.out.println("\t\t\t\t     | 1 | Add a student         |");
            System.out.println("\t\t\t\t     | 2 | Delete a student      |");
            System.out.println("\t\t\t\t     | 3 | Add a teacher         |");
            System.out.println("\t\t\t\t     | 4 | Delete a teacher      |");
            System.out.println("\t\t\t\t     | 5 | Add an admin          |");
            System.out.println("\t\t\t\t     | 6 | Remove an admin       |");
            System.out.println("\t\t\t\t     | 7 | View a student        |");
            System.out.println("\t\t\t\t     | 8 | View a Teacher        |");
            System.out.println("\t\t\t\t     | 9 | View an admin         |");
            System.out.println("\t\t\t\t     | 10| Back                  |");
            System.out.println("\t\t\t\t     |___|_______________________|");

            System.out.println("Select from above: ");
            try {
                option = scanner.nextInt();
                if (option < 1 || option > 10) {
                    System.out.println("Please Select from 1 - 10: ");
                }
            } catch (Exception e) {
                System.out.println("Please enter valid number");
                scanner.next();
            }
            if (option == 1) {
                school.addStudent(new Student());
                option = 10;
            } else if (option == 2) {
                school.removeStudent();
                option = 10;
            } else if (option == 3) {
                school.addTeacher(new Teacher());
                option = 10;
            } else if (option == 4) {
                school.removeTeacher();
                option = 10;
            } else if (option == 5) {
                school.addAdmin(new Admin());
                option = 10;
            } else if (option == 6) {
                school.removeAdmin();
                option = 10;
            } else if (option == 7) {
                school.viewStudentProfile();
                option = 10;
            } else if (option == 8) {
                school.viewTeacherProfile();
                option = 10;
            } else if (option == 9) {
                school.viewAdminProfile();
                option = 10;
            }
        }
    }

    public static void mainMenuForAdmin(Admin admin) {
        int option = 0;
        while (!(option == 8)) {
            System.out.println("\t\t\t\t      ___________________________");
            System.out.println("\t\t\t\t     |   |                       |");
            System.out.println("\t\t\t\t     | 1 | Add a student         |");
            System.out.println("\t\t\t\t     | 2 | Delete a student      |");
            System.out.println("\t\t\t\t     | 3 | Add a teacher         |");
            System.out.println("\t\t\t\t     | 4 | Delete a teacher      |");
            System.out.println("\t\t\t\t     | 5 | View a student        |");
            System.out.println("\t\t\t\t     | 6 | View a teacher        |");
            System.out.println("\t\t\t\t     | 7 | View an admin         |");
            System.out.println("\t\t\t\t     | 8 | Back                  |");
            System.out.println("\t\t\t\t     |___|_______________________|");

            System.out.println("Select from above: ");
            try {
                option = scanner.nextInt();
                if (option < 1 || option > 8) {
                    System.out.println("Please Select from 1 - 8: ");
                }
            } catch (Exception e) {
                System.out.println("Please enter valid number");
                scanner.next();
            }
            if (option == 1) {
                admin.addStudent(new Student());
                option = 8;
            } else if (option == 2) {
                admin.removeStudent();
                option = 8;
            } else if (option == 3) {
                admin.addTeacher(new Teacher());
                option = 8;
            } else if (option == 4) {
                admin.removeTeacher();
                option = 8;
            } else if (option == 5) {
                admin.viewStudentProfile();
                option = 8;
            } else if (option == 6) {
                admin.viewTeacherProfile();
                option = 8;
            } else if (option == 7) {
                admin.viewAdminProfile();
                option = 8;
            }
        }
    }


    public static void mainMenuForTeacher(School school) {
        Teacher teacher = new Teacher(school);
        int option = 0;
        while (!(option == 2)) {
            System.out.println("\t\t\t\t      ___________________________");
            System.out.println("\t\t\t\t     |   |                       |");
            System.out.println("\t\t\t\t     | 1 | View Profile          |");
            System.out.println("\t\t\t\t     | 2 | Back                  |");
            System.out.println("\t\t\t\t     |___|_______________________|");

            System.out.println("Select from above: ");
            try {
                option = scanner.nextInt();
                if (option < 1 || option > 2) {
                    System.out.println("Please Select from 1 - 2: ");
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid number");
                scanner.next();
            }
            if (option == 1) {
                teacher.viewProfile();
                option = 2;
            }
        }
    }

    public static void mainMenuForStudent(School school) {
        Student student = new Student(school);
        int option = 0;
        while (!(option == 2)) {
            System.out.println("\t\t\t\t      __________________________");
            System.out.println("\t\t\t\t     |   |                      |");
            System.out.println("\t\t\t\t     | 1 | View Profile         |");
            System.out.println("\t\t\t\t     | 2 | Back                 |");
            System.out.println("\t\t\t\t     |___|______________________|");

            System.out.println("Select from above: ");
            try {
                option = scanner.nextInt();
                if (option < 1 || option > 2) {
                    System.out.println("Please Select from 1 - 2: ");
                }
            } catch (Exception e) {
                System.out.println("Please enter valid number");
            }
            if (option == 1) {
                student.viewProfile();
            }
        }
    }
}

