package projetjava;

import java.sql.*;

import javax.swing.JOptionPane;

public class administrateur {
    public boolean checkadmin(String login,String pwd){
        boolean b=false;
        try{
            String query = "SELECT * FROM admin where login='"+login+"'and mdp='"+pwd+"';";
            Statement stmt = database.conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                // ken thama star raw unique teba3 admin sinon mathama hatta star 
                b=true;
            }
        }catch (Exception e){
             JOptionPane.showMessageDialog(null,"" +e);
        }
        return b;
    }
}
