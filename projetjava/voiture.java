package projetjava;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
public class voiture {
    int immatricule;
    String marque;
    String modéle;
    int age;
    double prix;
    utilisateur u;
    public ArrayList <String> modele(String marque ){
        ArrayList <String> a=new ArrayList();
        try{
            String query="select distinct modele from voiture where marque='"+marque+"' and login_user is null";
            Statement stmt=database.conn.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                String mod=rs.getString("modele");
                a.add(mod);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return a ;
    }
    public ArrayList <String> marque(){
        ArrayList <String> a=new ArrayList();
        try{
            String query="select distinct marque from voiture where login_user is null";
            Statement stmt=database.conn.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                String mod=rs.getString("marque");
                a.add(mod);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return a ;
    }
    public ArrayList <String> age(String modele,String marque){
        ArrayList <String> a=new ArrayList();
        try{
            String query="select distinct age from voiture where modele='"+modele+"' and marque='"+marque+"' and login_user is null";
            Statement stmt=database.conn.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                String mod=rs.getString("age");
                a.add(mod);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return a ;
    }
    public ArrayList <String> prix(String age,String modele,String marque){
        ArrayList <String> a=new ArrayList();
        try{
            String query="select distinct prix from voiture where age='"+age+"' and modele='"+modele+"'and marque='"+marque+"' and login_user is null";
            Statement stmt=database.conn.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                String mod=rs.getString("prix");
                a.add(mod);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return a ;
    }
    public String get_imm(String age,String modele,String marque,String prix){
        String imm="";
        try{
            String query="select immatricule from voiture where prix='"+prix+"' and age='"+age+"' and modele='"+modele+"'and marque='"+marque+"' and login_user is null LIMIT 1 ";
            Statement stmt=database.conn.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            if(rs.next()){
                imm=rs.getString("immatricule");
            }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        return imm;
    }
    public void louer_voiture(String login_user,String imm){
        try{
        String query="update voiture set login_user=? where immatricule='"+imm+"'";
        PreparedStatement stmt=database.conn.prepareStatement(query);
        stmt.setString(1,login_user);
        stmt.executeUpdate();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    public void ajout_voiture(String imm,String marque,String modele,String age,String prix,String user){
        try{
            String query="insert into voiture values (?,?,?,?,?,?)";
            PreparedStatement stmt=database.conn.prepareStatement(query);
            stmt.setString(1, imm);
            stmt.setString(2, marque);
            stmt.setString(3, modele);
            stmt.setString(4, age);
            stmt.setString(5, prix);
            stmt.setString(6, user);
            stmt.executeUpdate();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
            
        }
    }
    public ArrayList<String> all_cars(){
        ArrayList <String> a=new ArrayList<>();
        try{
            String query="select immatricule from voiture";
            Statement stmt=database.conn.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                String car=rs.getString("immatricule");
                a.add(car);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return a;
    }
    public String get_marque(String imm){
        String marque="";
        try{
            String query="select marque from voiture where immatricule='"+imm+"'";
            Statement stmt=database.conn.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            if(rs.next()){
                marque=rs.getString("marque");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return marque;
    }
    public String get_modele(String imm){
        String modele="";
        try{
            String query="select modele from voiture where immatricule='"+imm+"'";
            Statement stmt=database.conn.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            if(rs.next()){
                modele=rs.getString("modele");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return modele;
    }
    public String get_age(String imm){
        String age="";
        try{
            String query="select age from voiture where immatricule='"+imm+"'";
            Statement stmt=database.conn.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            if(rs.next()){
                age=rs.getString("age");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return age;
    }
    public String get_prix(String imm){
        String prix="";
        try{
            String query="select prix from voiture where immatricule='"+imm+"'";
            Statement stmt=database.conn.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            if(rs.next()){
                prix=rs.getString("prix");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return prix;
    }
    public String get_user(String imm){
        String user="";
        try{
            String query="select login_user from voiture where immatricule='"+imm+"'";
            Statement stmt=database.conn.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            if(rs.next()){
                user=rs.getString("login_user");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }
}
