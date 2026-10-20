import java.sql.*;

public class JdbcDemo {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college",
                "root",
                "Sid@2005");

        PreparedStatement ps = con.prepareStatement(
                "insert into student values(?,?,?)");

        ps.setInt(1, 101);
        ps.setString(2, "Rahul");
        ps.setString(3, "CSE");

        ps.executeUpdate();
        System.out.println("Record Inserted");

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from student");

        while (rs.next()) {
            System.out.println(
                    rs.getInt(1) + " " +
                    rs.getString(2) + " " +
                    rs.getString(3));
        }

        con.close();
    }
}
