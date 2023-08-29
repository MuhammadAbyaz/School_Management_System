import java.util.Scanner;

public class Admin {
    Scanner scanner = new Scanner(System.in);
    Menus menus = new Menus();
    private final School school;

    public Admin(School school) {
        this.school = school;
    }

    public void addStudent() {
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
        school.getStudentList().add(student);
        System.out.println("Student ID is: " + student.getId());
        System.out.println(" ____________________________");
        System.out.println("|                            |");
        System.out.println("| Student Successfully Added |");
        System.out.println("|____________________________|");
    }

    public void addTeacher() {
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
        school.getTeacherList().add(teacher);
        System.out.println("Employee ID is: " + teacher.getEmployeeId());
        System.out.println(" ____________________________");
        System.out.println("|                            |");
        System.out.println("| Teacher Successfully Added |");
        System.out.println("|____________________________|");
    }

    public void removeStudent() {
        System.out.println("Enter student id: ");
        int id = scanner.nextInt();
        Student studentToRemove = null;
        for (Student student : school.getStudentList()) {
            if (student.getId() == id) {
                studentToRemove = student;
                break;
            }
        }
        if (studentToRemove != null) {
            school.getStudentList().remove(studentToRemove);
        } else {
            System.out.println("This id does not exist");
            return;
        }
        System.out.println(" ______________________________");
        System.out.println("|                              |");
        System.out.println("| Student Successfully Removed |");
        System.out.println("|______________________________|");
    }

    public void removeTeacher() {
        System.out.println("Enter employee id: ");
        int id = scanner.nextInt();
        Teacher teacherToRemove = null;
        for (Teacher teacher : school.getTeacherList()) {
            if (teacher.getEmployeeId() == id) {
                teacherToRemove = teacher;
                break;
            }
        }
        if (teacherToRemove != null) {
            school.getTeacherList().remove(teacherToRemove);
        } else {
            System.out.println("This id does not exist");
            return;
        }
        System.out.println(" ______________________________");
        System.out.println("|                              |");
        System.out.println("| Teacher Successfully Removed |");
        System.out.println("|______________________________|");
    }

    public void editTeacher() {
        System.out.println("Enter employee id: ");
        int id = scanner.nextInt();
        Teacher teacherToEdit = null;
        for (Teacher teacher : school.getTeacherList()) {
            if (teacher.getEmployeeId() == id) {
                teacherToEdit = teacher;
            }
        }
        if (teacherToEdit == null) {
            System.out.println("This id does not exists");
        } else {
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
                    teacherToEdit.setName(name);
                    message("Teacher");
                }
                case 2 -> {
                    System.out.println("Enter edited address: ");
                    String address = scanner.next();
                    teacherToEdit.setAddress(address);
                    message("Teacher");
                }
                case 3 -> {
                    menus.menuForSubjects();
                    int choice = scanner.nextInt();
                    if (choice == 1) {
                        System.out.println("Enter subject you want to add: ");
                        String subjectToBeAdded = scanner.next();
                        teacherToEdit.getSubjectToTeach().add(subjectToBeAdded);
                        message("Teacher");
                    } else if (choice == 2) {
                        System.out.println(teacherToEdit.getSubjectToTeach());
                        System.out.println("Enter subject you want to remove: ");
                        String subjectToBeRemoved = scanner.next();
                        for (String s : teacherToEdit.getSubjectToTeach()) {
                            if (s.equals(subjectToBeRemoved)) {
                                teacherToEdit.getSubjectToTeach().remove(subjectToBeRemoved);
                                message("Teacher");
                                break;
                            }
                        }
                    } else if (choice == 3) {
                        System.out.println(teacherToEdit.getSubjectToTeach());
                        System.out.println("Select subject you want to remove: ");
                        String subjectToBeEdited = scanner.next();
                        System.out.println("Enter edited subject: ");
                        String editedSubject = scanner.next();
                        for (String s : teacherToEdit.getSubjectToTeach()) {
                            if (s.equals(subjectToBeEdited)) {
                                teacherToEdit.getSubjectToTeach().remove(subjectToBeEdited);
                                teacherToEdit.getSubjectToTeach().add(editedSubject);
                                message("Teacher");
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public void editStudent() {
        System.out.println("Enter student id: ");
        int id = scanner.nextInt();
        Student studentToEdit = null;
        for (Student student : school.getStudentList()) {
            if (student.getId() == id) {
                studentToEdit = student;
            }
        }
        if (studentToEdit == null) {
            System.out.println("This id does not exist");
        } else {
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
                    System.out.println("Enter edited name: ");
                    String name = scanner.next();
                    studentToEdit.setName(name);
                    message("Student");
                }
                case 2 -> {
                    System.out.println("Enter edited address: ");
                    String address = scanner.next();
                    studentToEdit.setAddress(address);
                    message("Student");
                }
                case 3 -> {
                    System.out.println("Enter edited grade: ");
                    int grade = scanner.nextInt();
                    studentToEdit.setGrade(grade);
                    message("Student");
                }
                default -> System.out.println("Please select form above options");
            }
        }
    }


    public Teacher getTeacherById() {
        System.out.println("Enter employee Id: ");
        int id = scanner.nextInt();
        Teacher teacherToGet = null;
        for (Teacher teacher :
                school.getTeacherList()) {
            if (teacher.getEmployeeId() == id) {
                teacherToGet = teacher;
                break;
            }
        }
        if (teacherToGet == null) {
            System.out.println("This id does not exist!!");
        }
        return teacherToGet;
    }

    public Student getStudentById() {
        System.out.println("Enter student Id: ");
        int id = scanner.nextInt();
        Student studentToGet = null;
        for (Student student :
                school.getStudentList()) {
            if (student.getId() == id) {
                studentToGet = student;
                break;
            }
        }
        if (studentToGet == null) {
            System.out.println("This id does not exist!!");
        }
        return studentToGet;
    }

    public void message(String person) {
        System.out.println(" ______________________________");
        System.out.println("|                              |");
        System.out.println("| " + person + " Successfully Edited  |");
        System.out.println("|______________________________|");
    }
}
