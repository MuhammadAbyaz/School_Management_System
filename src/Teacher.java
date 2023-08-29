import java.util.ArrayList;

public class Teacher {
    private final String name;
    private int ID = 0;
    private final String address;
    private final int employeeId;
    private final ArrayList<String> subjectToTeach;

    public Teacher(String _name, String _address) {
        this.name = _name;
        this.address = _address;
        this.employeeId = generateId();
        this.subjectToTeach = new ArrayList<>();
    }

    public int generateId() {
        return ID++;
    }

    public void printTeacher() {
        System.out.println("Id       : " + getEmployeeId());
        System.out.println("Name     : " + getName());
        System.out.println("Address  : " + getAddress());
        System.out.println("Subjects : " + getSubjectToTeach());
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getSubjectToTeach() {
        return subjectToTeach;
    }


    public String getAddress() {
        return address;
    }
}

