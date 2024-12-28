package projetjava;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class user_login extends JFrame implements ActionListener {
    JLabel login = new JLabel(" LOGIN :");
    JPasswordField pwd1 =new JPasswordField(10);
    JLabel pwd = new JLabel(" PASSWORD :");
    JTextField login1 = new JTextField(10);
    JButton ok = new JButton("ok");
    JButton sign_up = new JButton("sign up");
    JButton endo = new JButton("undo");
    acceuil a1;
    public user_login(acceuil a){
        super("user");
        setLocation(550,170);
        a1=a;
        setVisible(true);
        setResizable(false);
        JPanel p=new JPanel(new GridLayout(4,2,25,40));
        p.add(login);
        p.add(login1);
        p.add(pwd);
        p.add(pwd1);
        p.add(ok);
        p.add(sign_up);
        p.add(endo);
        ok.addActionListener(this);
        endo.addActionListener(this);
        sign_up.addActionListener(this);
        setSize(300,250);
        setContentPane(p);
    }
    public void actionPerformed(ActionEvent e){
        String log=login1.getText();
        String mdp=pwd1.getText();
        utilisateur u=new utilisateur(log,mdp,null,null);
        boolean test =u.verif_utilisateur(log, mdp);
        if(e.getSource()==ok){
            if(test){
                u.cordonnées_utilisateur(log);
                user_conn u1=new user_conn(u,this);
                setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(null,"user doesn't exist please verify login and password ");
            }
            login1.setText("");
            pwd1.setText("");
        }
        else if (e.getSource()==sign_up){
            user_signup a3=new user_signup(this);
            setVisible(false);
        }
        else if(e.getSource()==endo) {
            a1.setVisible(true);
            dispose();
        }
    }

}
