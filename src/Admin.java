import java.sql.SQLException;
import java.util.Scanner;

public class Admin {
    Scanner scanner = new Scanner(System.in);
    Menus menus = new Menus();
    StudentRepository studentRepository = new StudentRepository();
    TeacherRepository teacherRepository = new TeacherRepository();

    public void addStudent() throws SQLException {
        studentRepository.createStudentTable();
        System.out.println("Enter student's name: ");
        String name = scanner.next();
        System.out.println("Enter student's address: ");
        String address = scanner.next();
        System.out.println("Enter student's grade: ");
        int grade = scanner.nextInt();
        if (grade < 1) {
            System.out.println("Grade cannot be less than 1");
            return;
        }
        Student student = new Student(name, address, grade);
        studentRepository.addStudent(student);
    }

    public void removeStudent() throws SQLException {
        System.out.println("Enter student id: ");
        int id = scanner.nextInt();
        studentRepository.deleteStudent(id);
    }

    public void viewStudent() throws SQLException {
        System.out.println("Enter student id: ");
        int id = scanner.nextInt();
        studentRepository.getStudentById(id);
    }

    public void editStudent() throws SQLException {
        System.out.println("Enter student id: ");
        int id = scanner.nextInt();
        if (studentRepository.checkingID(id)) {
            System.out.println("Which info you want to edit");
            System.out.println("\t\t\t\t      ___________________________");
            System.out.println("\t\t\t\t     |   |                       |");
            System.out.println("\t\t\t\t     | 1 | Name                  |");
            System.out.println("\t\t\t\t     | 2 | Address               |");
            System.out.println("\t\t\t\t     | 3 | Grade                 |");
            System.out.println("\t\t\t\t     |___|_______________________|");

            System.out.println("Select from above: ");
            int option = scanner.nextInt();
            switch (option) {
                case 1 -> {
                    System.out.println("Enter Edited name: ");
                    String name = scanner.next();
                    studentRepository.updateStudent(id, "NAME", name);
                    message("Student");
                }
                case 2 -> {
                    System.out.println("Enter edited address: ");
                    String address = scanner.next();
                    studentRepository.updateStudent(id, "ADDRESS", address);
                    message("Student");
                }
                case 3 -> {
                    System.out.println("Enter edited grade: ");
                    int grade = scanner.nextInt();
                    studentRepository.updateStudent(id, "GRADE", String.valueOf(grade));
                    message("Student");
                }
                default -> System.out.println("Please select form above options");
            }
        } else {
            System.out.println("This id does not exist");
        }
    }

    public void addTeacher() throws SQLException {
        teacherRepository.createTeacherTable();
        System.out.println("Enter teacher's name: ");
        String name = scanner.next();
        System.out.println("Enter teacher's address: ");
        String address = scanner.next();
        System.out.println("How many subjects will he/she teach? ");
        int numberOfSubjects = scanner.nextInt();
        if (numberOfSubjects <= 0) {
            System.out.println("A teacher at least teaches one subject");
            return;
        }
        Teacher teacher = new Teacher(name, address);
        String subjects;
        for (int i = 1; i <= numberOfSubjects; i++) {
            System.out.println("Subject " + i + " :");
            subjects = scanner.next();
            teacher.getSubjectToTeach().add(subjects);
        }
        teacherRepository.addTeacher(teacher);
    }

    public void removeTeacher() throws SQLException {
        System.out.println("Enter teacher id: ");
        int id = scanner.nextInt();
        teacherRepository.deleteTeacher(id);
    }

    public void viewTeacher() throws SQLException {
        System.out.println("Enter teacher id: ");
        int id = scanner.nextInt();
        teacherRepository.getTeacherById(id);
    }


    public void editTeacher() throws SQLException {
        System.out.println("Enter teacher id: ");
        int id = scanner.nextInt();
        if (teacherRepository.checkingID(id)) {
            System.out.println("Which info you want to edit");
            System.out.println("\t\t\t\t      ___________________________");
            System.out.println("\t\t\t\t     |   |                       |");
            System.out.println("\t\t\t\t     | 1 | Name                  |");
            System.out.println("\t\t\t\t     | 2 | Address               |");
            System.out.println("\t\t\t\t     | 3 | Subjects              |");
            System.out.println("\t\t\t\t     |___|_______________________|");

            System.out.println("Select from above: ");

            int option = scanner.nextInt();
            switch (option) {
                case 1 -> {
                    System.out.println("Enter edited name: ");
                    String name = scanner.next();
                    teacherRepository.updateTeacher(id, "NAME", name);
                    message("Teacher");
                }
                case 2 -> {
                    System.out.println("Enter edited address: ");
                    String address = scanner.next();
                    teacherRepository.updateTeacher(id, "ADDRESS", address);
                    message("Teacher");
                }
                case 3 -> {
                    menus.menuForSubjects();
                    int choice = scanner.nextInt();
                    String subject;
                    String query;
                    switch (choice) {
                        case 1 -> {
                            System.out.println("Enter subject you want to add: ");
                            subject = scanner.next();
                            query = String.format("UPDATE teacher SET SUBJECTS = ARRAY_APPEND(SUBJECTS, '%s') WHERE ID = %s ;", subject, id);
                            teacherRepository.updateSubjects(id, query);
                        }
                        case 2 -> {
                            System.out.println("Enter subject you want to remove: ");
                            subject = scanner.next();
                            query = String.format("UPDATE teacher SET SUBJECTS = ARRAY_REMOVE(SUBJECTS, '%s') WHERE ID = %s", subject, id);
                            teacherRepository.updateSubjects(id, query);
                        }
                        case 3 -> {
                            System.out.println("Enter subject you want to replace: ");
                            String subjectToBeReplaced = scanner.next();
                            System.out.println("Enter subject you want to replace with: ");
                            subject = scanner.next();
                            query = String.format("UPDATE teacher SET SUBJECTS = ARRAY_REPLACE(SUBJECTS, '%s', '%s') WHERE ID = %s", subjectToBeReplaced, subject, id);
                            teacherRepository.updateSubjects(id, query);
                        }
                    }
                }
            }
        } else {
            System.out.println("This id does not exists");
        }
    }

    public void message(String person) {
        System.out.println(" ______________________________");
        System.out.println("|                              |");
        System.out.println("| " + person + " Successfully Edited  |");
        System.out.println("|______________________________|");
    }

}
