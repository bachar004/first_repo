package projetjava;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class user_signup extends JFrame implements ActionListener  {
    JButton register=new JButton("register");
    JLabel login = new JLabel(" LOGIN :");
    JTextField login1 = new JTextField(10);
    JPasswordField pwd1 =new JPasswordField(10);
    JLabel pwd = new JLabel(" PASSWORD : ");
    JLabel adr = new JLabel(" ADDRESS : ");
    JTextField adr1 = new JTextField(10);
    JLabel mail = new JLabel(" EMAIL : ");
    JTextField mail1 = new JTextField(10);
    JButton endo = new JButton("undo");
    user_login a;
    public user_signup(user_login a3){
        super("sign_up");
        setLocation(550,170);
        a=a3;
        setSize(350,300);
        setResizable(false);
        setVisible(true);
        JPanel k = new JPanel(new GridLayout(5,2,25,35));
        k.add(login);
        k.add(login1);
        k.add(pwd);
        k.add(pwd1);
        k.add(adr);
        k.add(mail1);
        k.add(mail);
        k.add(adr1);
        k.add(register);
        k.add(endo);
        endo.addActionListener(this);
        register.addActionListener(this);
        setContentPane(k);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==register){
            String log=(login1.getText()).replace(" ","");
            String mdp=pwd1.getText();
            String adresse=(adr1.getText()).replace(" ","");
            String email=(mail1.getText()).replace(" ","");
            if(log.equals("")|| mdp.equals("") || adresse.equals("") || email.equals(""))   {
                JOptionPane.showMessageDialog(null, "all fields are required");
            } 
            else{
                utilisateur u=new utilisateur(log,mdp,email,adresse);
                boolean test=u.login_exist(log);
                if(!test){
                u.ajout_utilisateur(log,mdp,adresse,email);
                }
                else{
                    JOptionPane.showMessageDialog(null,"login exist try another login");
                }
                login1.setText("");
                pwd1.setText("");
                adr1.setText("");
                mail1.setText("");
            }
        }
        else{
            a.setVisible(true);
            dispose();
        }
    }
}