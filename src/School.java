import java.util.ArrayList;

public class School {
    private final String name;
    private final String address;
    private final ArrayList<Teacher> teacherList;

    private final ArrayList<Student> studentList;


    public School(String _name, String _address) {
        this.name = _name;
        this.address = _address;
        this.teacherList = new ArrayList<>();
        this.studentList = new ArrayList<>();
    }

    public ArrayList<Teacher> getTeacherList() {
        return teacherList;
    }


    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

}
