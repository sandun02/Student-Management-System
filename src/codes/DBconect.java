
package codes;


import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.Connection;

public class DBconect {
    
    public static Connection connect(){
        Connection conn = null;
   
        String pathToConnector = "com.mysql.cj.jdbc.Driver";
        try{
            Class.forName(pathToConnector);
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/projectyt","root","");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e );
          
        }
        return conn;
    }
}
