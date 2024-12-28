package projetjava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class admin extends JFrame implements ActionListener {
    JLabel login = new JLabel("LOGIN");
    JPasswordField pwd1 =new JPasswordField(10);
    JLabel pwd = new JLabel("PASSWORD");
    JTextField login1 = new JTextField(10);
    JButton endo = new JButton("undo");
    JButton ok = new JButton("ok");
    acceuil a;
    public admin(acceuil a1){
        super("admin");
        setResizable(false);
        setLocation(550,170);
        a=a1;
        JPanel p = new JPanel(new GridLayout(3,2,25,75));
        setSize(300,250);
        setVisible(true);
        p.add(login);
        p.add(login1);
        p.add(pwd);
        p.add(pwd1);
        p.add(ok);
        p.add(endo);
        setContentPane(p);
        ok.addActionListener(this);
        endo.addActionListener(this);

    }
    
    public void actionPerformed(ActionEvent e){
        String name=login1.getText();
        String mdp=pwd1.getText();
        administrateur admin=new administrateur();
        boolean ad=admin.checkadmin(name, mdp);
        if(e.getSource()==endo)
        {
            dispose();
            a.setVisible(true);
        }
        else{
            if(ad){
                admin_conn a4=new admin_conn(this);
                setVisible(false);}
            else{
                JOptionPane.showMessageDialog(null,"invalid password or login " );
            }
            login1.setText("");
            pwd1.setText("");
            }
    }
}
