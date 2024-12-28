package projetjava;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.*;

public class utilisateur {
    String log;
    String mdp;
    String email;
    String adr;
    public utilisateur(String log,String mdp,String email,String adr){
        this.log=log;
        this.mdp=mdp;
        this.email=email;
        this.adr=adr;
    }
    public boolean verif_utilisateur(String login ,String pwd){
        boolean test = false;
        try{
            String query="select login,mdp from user where login='"+login+"' and mdp='"+pwd+"';";
            Statement stmt= database.conn.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            if(rs.next()){
                test=true;
            }

        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"" +e);
        }
        return test;
    }
    public void ajout_utilisateur(String login ,String pwd,String mail,String adr){
        try{
        String query="insert into user values (?,?,?,?)";
        PreparedStatement stmt = database.conn.prepareStatement(query);
        stmt.setString(1, login);
        stmt.setString(2, pwd);
        stmt.setString(3, adr);
        stmt.setString(4, mail);
        stmt.executeUpdate();
        JOptionPane.showMessageDialog(null,"sign up validée retourner au login " );
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"" +e);
        }
    }
    public void cordonnées_utilisateur(String login){
        try{
            String query = "SELECT * FROM user where login='"+login+"'";
            Statement stmt = database.conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                this.email=rs.getString("mail");
                this.adr=rs.getString("ville");
                this.mdp=rs.getString("mdp");
            }
        }catch (Exception e){
             JOptionPane.showMessageDialog(null,e);
        }
    }
    public void editer_mail_utilisateur(String login,String new_mail){
        try{
            String query="update user set mail=? where login='"+login+"'";
            PreparedStatement st=database.conn.prepareStatement(query);
            st.setString(1,new_mail);
            st.executeUpdate();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }

    }
    public void editer_adr_utilisateur(String login,String new_adr){
        try{
                String query="update user set ville=? where login='"+login+"'";
                PreparedStatement st=database.conn.prepareStatement(query);
                st.setString(1,new_adr);
                st.executeUpdate();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }

    }
    public void editer_mdp_utilisateur(String login,String new_mdp){
        try{
            String query="update user set mdp=? where login='"+login+"'";
            PreparedStatement st=database.conn.prepareStatement(query);
            st.setString(1,new_mdp);
            st.executeUpdate();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }

    }
    public boolean login_exist(String login){
        boolean test=false;
        try{
            String query="select login from user where login='"+login+"'";
            Statement stmt=database.conn.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            if(rs.next()){
                test=true;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return test ;
    }
    // retourner tous les utilisateurs dans la base de données 
    public ArrayList<String> all_users(){
        ArrayList <String> a=new ArrayList<>();
        try{
            String query="select login from user";
            Statement stmt=database.conn.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                String user=rs.getString("login");
                a.add(user);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return a;
    }
    public String get_adr(String login){
        String adr="";
        try{
            String query="select ville from user where login='"+login+"'";
            Statement stmt=database.conn.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            if(rs.next()){
                adr=rs.getString("ville");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return adr;
    }
    public String get_mail(String login){
        String mail="";
        try{
            String query="select mail from user where login='"+login+"'";
            Statement stmt=database.conn.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            if(rs.next()){
                mail=rs.getString("mail");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return mail;
    }
}
