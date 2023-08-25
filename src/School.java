import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class School {
    Scanner scanner = new Scanner(System.in);
    private String name;
    private String address;

    private ArrayList<Teacher> teacherList;
    private ArrayList<Student> studentList;
    private ArrayList<Grades> gradeList;

    private final ArrayList<Admin> adminList;


    public School() {
        this.name = "S.M. Public Academy";
        this.address = "North Nazimabad";
        this.teacherList = new ArrayList<Teacher>();
        this.studentList = new ArrayList<Student>();
        this.gradeList = new ArrayList<Grades>();
        this.adminList = new ArrayList<Admin>();
    }

    public void addAdmin(Admin admin) {
        adminList.add(admin);
    }

    public void addTeacher(Teacher teacher) {
        teacherList.add(teacher);
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void removeAdmin() {
        System.out.println("Enter Admin id you want to remove: ");
        int id = scanner.nextInt();
        Admin adminToRemove = null;
        for (Admin admin :
                adminList) {
            if (admin.getEmployeeId() == id) {
                adminToRemove = admin;
                break;
            }
        }
        if (adminToRemove != null) {
            adminList.remove(adminToRemove);
        }
    }

    public void removeTeacher() {
        System.out.println("Enter teacher's employee id you want to delete: ");
        int id = scanner.nextInt();
        Teacher teacherToRemove = null;
        for (Teacher teacher : teacherList) {
            if (teacher.getEmployeeId() == id) {
                teacherToRemove = teacher;
                break;
            }
        }
        if (teacherToRemove != null) {
            teacherList.remove(teacherToRemove);
        }
    }

    public void removeStudent() {
        try {
            System.out.println("Enter student id you want to delete: ");
            int id = scanner.nextInt();
            Student studentToRemove = null;
            for (Student student : studentList) {
                if (student.getId() == id) {
                    studentToRemove = student;
                    break;
                }
            }
            if (studentToRemove != null) {
                studentList.remove(studentToRemove);
            }
        } catch (Exception e) {
            System.out.println("Please enter valid student id");
        }
    }

    public void viewTeacherProfile() {
        System.out.println("Enter your employee id: ");
        int id = scanner.nextInt();
        Teacher teacherToGet = null;
        for (Teacher teacher :
                teacherList) {
            if (teacher.getEmployeeId() == id) {
                teacherToGet = teacher;
            }
            if (teacherToGet != null) {
                System.out.println("NAME: " + teacherToGet.getName());
                System.out.println("ADDRESS: " + teacherToGet.getAddress());
                System.out.println("EMPLOYEE ID: " + teacherToGet.getEmployeeId());
                System.out.println("SUBJECTS TO TEACH: " + Arrays.toString(teacherToGet.getSubjectsToTeach()));
            }
        }
    }

    public void viewStudentProfile() {
        System.out.println("Enter your student id: ");
        int id = scanner.nextInt();
        Student studentToGet = null;
        for (Student student : studentList) {
            if (student.getId() == id) {
                studentToGet = student;
                break;
            }
        }
        if (studentToGet != null) {
            System.out.println("NAME: " + studentToGet.getName());
            System.out.println("ADDRESS: " + studentToGet.getAddress());
            System.out.println("STUDENT ID: " + studentToGet.getId());
            System.out.println("GRADE: " + studentToGet.getGrade());
        }
    }

    public void viewAdminProfile() {
        System.out.println("Enter your student id: ");
        int id = scanner.nextInt();
        Admin adminToGet = null;
        for (Admin admin : adminList) {
            if (admin.getEmployeeId() == id) {
                adminToGet = admin;
                break;
            }
        }
        if (adminToGet != null) {
            System.out.println("NAME: " + adminToGet.getName());
            System.out.println("ADDRESS: " + adminToGet.getAddress());
            System.out.println("EMPLOYEE ID: " + adminToGet.getEmployeeId());
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setLocation(String address) {
        this.address = address;
    }

    public ArrayList<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(ArrayList<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public ArrayList<Grades> getGradeList() {
        return gradeList;
    }

    public void setGradeList(ArrayList<Grades> gradeList) {
        this.gradeList = gradeList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

}
