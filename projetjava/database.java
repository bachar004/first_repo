package projetjava;
import java.sql.*;

import javax.swing.JOptionPane;

public class database {
    public static Connection conn=null;
    public static void loadconnection(){
        String URL = "jdbc:mysql://localhost:3306/app";  // Update with your database name
        String USER = "root";  // Update with your MySQL username
        String PASSWORD = "bachar123";  // Update with your MySQL password
    try{
        conn=DriverManager.getConnection(URL,USER,PASSWORD);
    }catch (Exception e){
        JOptionPane.showMessageDialog(null,"erreur base de données" +e);
    }
    }
}
