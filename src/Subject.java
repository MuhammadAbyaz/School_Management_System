import java.util.ArrayList;

public class Subject {
    private String name;
    private ArrayList<Teacher> teacherList;
    private ArrayList<Student> studentList;

    public Subject(String name, ArrayList<Teacher> teacherList, ArrayList<Student> studentList){
        this.name = name;
        this.teacherList = teacherList;
        this.studentList = studentList;
    }
}
