package kata5;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class kata5 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("org.sqlite.JDBC");
        Connection cn = DriverManager.getConnection("jdbc:sqlite:people");
        Statement st = cn.createStatement();

        String name = "C:\\Users\\usuario\\Desktop\\mails.txt";
        ArrayList<String> mailArray = MailReader.read(name);
        for (String mail : mailArray) {
            st.executeUpdate("INSERT INTO mails(mails) VALUES('" + mail + "')");
        }
        ResultSet rs = st.executeQuery("SELECT mails FROM mails");
        while (rs.next()) {
            System.out.println("mail= " + rs.getString("mails"));
        }
        rs.close();
        st.close();
        cn.close();
    }

}
