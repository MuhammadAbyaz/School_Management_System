import java.util.ArrayList;

public class Teacher {
    private String name;
    private int ID = 0;
    private String address;
    private final int employeeId;
    private ArrayList<String> subjectToTeach;

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

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSubjectToTeach(ArrayList<String> subjectToTeach) {
        this.subjectToTeach = subjectToTeach;
    }

}

