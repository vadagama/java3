package lesson2;

import java.sql.*;


public class Main  {

    private static Connection connection;
    private static Statement stmt;

    public static void main(String[] args) throws SQLException {

        // connect
        try {
            connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //read, write, update or delete
        try {
            updateDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        disconnect();
    }

    // Update Database
    public static void readDB() throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT * FROM Students");
        System.out.println(rs);
    }

    // Insert into Database
    public static void insertIntoDB() throws SQLException {
        String name = "Oleg";
        String group = "Student";
        int id = 40;
        String sql = String.format("INSERT INTO Students (Name, GroupName, Score) VALUES (\"%s\", \"%s\", \"%d\");", name, group, id);
        stmt.executeUpdate(sql);
    }

    // Delete from Database
    public static void deleteFromDB() throws SQLException {
        String sql = String.format("DELETE FROM Students where StudID = \"1\";");
        System.out.println(sql);
        stmt.executeUpdate(sql);
    }

    // Update Database
    public static void updateDB() throws SQLException {
        int score = 30;
        int id = 2;
        String sql = String.format("UPDATE Students SET score = %d where StudID = %d", score, id);
        stmt.executeUpdate(sql);
    }

    // Connect to Database
    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:index.db");
        stmt = connection.createStatement();
    }

    // Connect from Database
    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
