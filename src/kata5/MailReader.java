package kata5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MailReader {
    public static ArrayList <String> read(String name) throws FileNotFoundException, IOException, SQLException, ClassNotFoundException{
        ArrayList <String> mailList = new ArrayList<>();
        Class.forName("org.sqlite.JDBC");
        Connection cn = DriverManager.getConnection("jdbc:sqlite:people");
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("SELECT mails FROM mails");
        while(rs.next()){
            String mail = rs.getString("mail");
            mailList.add(mail);
        }
        return mailList;
    }
}