import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentRepository {
    private final Db db = new Db();

    public Boolean checkIfTableExists() {
        boolean result = false;
        try {
            Statement statement;
            String query = "SELECT EXISTS (" +
                    "SELECT * FROM information_schema.tables " +
                    "WHERE table_schema = 'public' AND table_name = 'student');";
            statement = db.connectToDb().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            result = resultSet.getBoolean(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public void createStudentTable() throws SQLException {
        Connection conn = db.connectToDb();
        if (checkIfTableExists()) {
            System.out.println("Table already exist");
        } else {
            try {
                Statement statement;
                String query = "CREATE TABLE student (ID serial NOT NULL, " +
                        "NAME varchar(200) NOT NULL, ADDRESS varchar(200) NOT NULL," +
                        " GRADE integer NOT NULL, primary key(id));";
                statement = db.connectToDb().createStatement();
                statement.executeUpdate(query);
            } catch (Exception e) {
                System.out.println("Some error occurred");
            }
        }
        conn.close();
    }

    public void addStudent(Student student) throws SQLException {
        Connection conn = db.connectToDb();
        Statement statement;
        try {
            String query = String.format("INSERT INTO student (NAME, ADDRESS, GRADE)\n" +
                    "VALUES ('%s', '%s','%s');", student.getName(), student.getAddress(), student.getGrade());
            statement = db.connectToDb().createStatement();
            statement.executeUpdate(query);
            System.out.println(" ____________________________");
            System.out.println("|                            |");
            System.out.println("| Student Successfully Added |");
            System.out.println("|____________________________|");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        conn.close();
    }

    public void deleteStudent(int id) throws SQLException {
        Connection conn = db.connectToDb();
        Statement statement;
        try {

            if (checkingID(id)) {
                String queryTwo = String.format("DELETE FROM student WHERE ID = %s;", id);
                statement = db.connectToDb().createStatement();
                statement.executeUpdate(queryTwo);
                System.out.println(" ______________________________");
                System.out.println("|                              |");
                System.out.println("| Student Successfully Removed |");
                System.out.println("|______________________________|");
            } else {
                System.out.println("This id does not exists");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        conn.close();
    }

    public void getStudentById(int id) throws SQLException {
        Connection conn = db.connectToDb();
        Statement statement;
        try {
            if (checkingID(id)) {
                String query = String.format("SELECT * FROM student WHERE ID = %s", id);
                statement = db.connectToDb().createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    System.out.println("ID      : " + resultSet.getInt("ID"));
                    System.out.println("Name    : " + resultSet.getString("NAME"));
                    System.out.println("Address : " + resultSet.getString("ADDRESS"));
                    System.out.println("Grade   : " + resultSet.getInt("GRADE"));
                }
            } else {
                System.out.println("This id does not exist");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        conn.close();
    }

    public void updateStudent(int id, String column, String value) throws SQLException {
        Connection conn = db.connectToDb();
        Statement statement;
        try {
            if (checkingID(id)) {
                String query = String.format("UPDATE student SET %s = '%s' WHERE ID = %s ", column, value, id);
                statement = conn.createStatement();
                statement.executeUpdate(query);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        conn.close();
    }

    public Boolean checkingID(int id) throws SQLException {
        Connection conn = db.connectToDb();
        String queryOne = String.format(
                "SELECT EXISTS (SELECT ID FROM student WHERE ID = %s);", id);
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(queryOne);
        resultSet.next();
        return resultSet.getBoolean(1);
    }
}
