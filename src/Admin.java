import java.util.Scanner;

public class Admin {
    Scanner scanner = new Scanner(System.in);
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
        Teacher teacher = new Teacher(name, address);
        System.out.println("How many subjects will he/she teach? ");
        int numberOfSubjects = scanner.nextInt();
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
        }
        System.out.println(" ______________________________");
        System.out.println("|                              |");
        System.out.println("| Teacher Successfully Removed |");
        System.out.println("|______________________________|");
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
        return studentToGet;
    }
}
