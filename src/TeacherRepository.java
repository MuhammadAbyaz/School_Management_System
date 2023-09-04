import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TeacherRepository {
    private final Db db = new Db();

    public Boolean checkIfTableExists() {
        boolean result = false;
        try {
            Statement statement;
            String query = "SELECT EXISTS (" +
                    "SELECT * FROM information_schema.tables " +
                    "WHERE table_schema = 'public' AND table_name = 'teacher');";
            statement = db.connectToDb().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            result = resultSet.getBoolean(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public void createTeacherTable() throws SQLException {
        Connection conn = db.connectToDb();
        if (checkIfTableExists()) {
            System.out.println("Table already exist");
        } else {
            try {
                Statement statement;
                String query = "CREATE TABLE teacher (ID serial NOT NULL, NAME varchar(200) NOT NULL, ADDRESS varchar(200) NOT NULL,SUBJECTS varchar [] NOT NULL" +
                        ", primary key(id));";
                statement = db.connectToDb().createStatement();
                statement.executeQuery(query);
                System.out.println("Table created");
            } catch (Exception e) {
                System.out.println("Error occurred");
            }
        }
        conn.close();
    }

    public void addTeacher(Teacher teacher) throws SQLException {
        Connection conn = db.connectToDb();
        Statement statement;
        try {
            String query = String.format("INSERT INTO teacher (NAME, ADDRESS, SUBJECTS)\n" +
                    "VALUES ('%s', '%s',ARRAY ['%s']);", teacher.getName(), teacher.getAddress(), teacher.getSubjectToTeach());
            statement = db.connectToDb().createStatement();
            statement.executeUpdate(query);
            System.out.println(" ____________________________");
            System.out.println("|                            |");
            System.out.println("| Teacher Successfully Added |");
            System.out.println("|____________________________|");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        conn.close();
    }

    public void deleteTeacher(int id) throws SQLException {
        Connection conn = db.connectToDb();
        Statement statement;
        try {
            String queryOne = String.format(
                    "SELECT EXISTS (SELECT ID FROM teacher WHERE ID = %s);", id);
            statement = db.connectToDb().createStatement();
            ResultSet resultSet = statement.executeQuery(queryOne);
            resultSet.next();
            if (resultSet.getBoolean(1)) {
                String queryTwo = String.format("DELETE FROM teacher WHERE ID = %s;", id);
                statement = db.connectToDb().createStatement();
                statement.executeUpdate(queryTwo);
                System.out.println(" ______________________________");
                System.out.println("|                              |");
                System.out.println("| Teacher Successfully Removed |");
                System.out.println("|______________________________|");
            } else {
                System.out.println("This id does not exists");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        conn.close();
    }

    public void getTeacherById(int id) throws SQLException {
        Connection conn = db.connectToDb();
        Statement statement;
        try {
            String queryOne = String.format(
                    "SELECT EXISTS (SELECT ID FROM teacher WHERE ID = %s);", id);
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(queryOne);
            resultSet.next();
            if (resultSet.getBoolean(1)) {
                String query = String.format("SELECT * FROM teacher WHERE ID = %s", id);
                statement = db.connectToDb().createStatement();
                resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    System.out.println("ID       : " + resultSet.getInt("ID"));
                    System.out.println("Name     : " + resultSet.getString("NAME"));
                    System.out.println("Address  : " + resultSet.getString("ADDRESS"));
                    System.out.println("Subjects : " + resultSet.getArray("SUBJECTS"));
                }
            } else {
                System.out.println("This id does not exist");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        conn.close();
    }

    public void updateTeacher(int id, String column, String value) throws SQLException {
        Connection conn = db.connectToDb();
        Statement statement;
        try {
            if (checkingID(id)) {
                String query = String.format("UPDATE teacher SET %s = '%s' WHERE ID = %s ", column, value, id);
                statement = conn.createStatement();
                statement.executeUpdate(query);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        conn.close();
    }

    public void updateSubjects(int id, String query2) throws SQLException {
        Connection conn = db.connectToDb();
        Statement statement;
        try {
            String query = String.format("SELECT SUBJECTS FROM teacher WHERE ID = %s", id);
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            System.out.println(resultSet.getArray("SUBJECTS"));
            statement.executeUpdate(query2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Boolean checkingID(int id) throws SQLException {
        Connection conn = db.connectToDb();
        String queryOne = String.format(
                "SELECT EXISTS (SELECT ID FROM teacher WHERE ID = %s);", id);
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(queryOne);
        resultSet.next();
        return resultSet.getBoolean(1);
    }
}
