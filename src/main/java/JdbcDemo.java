import java.sql.*;

public class JdbcDemo {
    public static void main(String[] args) {
       String url = "jdbc:mysql://localhost:3306/student";
       String uname = "root";
       String pass = "";
       String query = "select * from register";
       String userData = "password";


        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, uname, pass);

            Statement st = con.createStatement();
            st.executeQuery(query);

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) ;
            {
                userData = rs.getInt(1) + " : " + rs.getString(2);
                System.out.println(userData);
            }
            st.close();
            con.close();
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
