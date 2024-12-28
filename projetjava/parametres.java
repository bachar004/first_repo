package projetjava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class parametres extends JFrame implements ActionListener {
    JButton undo=new JButton("undo");
    JButton edit= new JButton("edit");
    JLabel login= new JLabel(" LOGIN:");
    JLabel login1= new JLabel();
    JLabel old_pwd= new JLabel(" CURRENT PASSWORD :");
    JPasswordField old_pwd1=new JPasswordField(10);
    JLabel new_pwd= new JLabel(" NEW PASSWORD :");
    JPasswordField new_pwd1=new JPasswordField(10);
    JLabel old_adr= new JLabel();
    JLabel old_email= new JLabel();
    JLabel new_adr= new JLabel(" NEW ADDRESS :");
    JTextField new_adr1= new JTextField(10);
    JLabel new_email= new JLabel(" NEW MAIL :");
    JTextField new_email1= new JTextField(10);
    JLabel old_email1=new JLabel(" CURRENT MAIL :");
    JLabel old_adr1= new JLabel(" CURRENT ADDRESS :");
    JLabel a=new JLabel("CHANGE PASSWORD :");
    JLabel b=new JLabel();
    user_conn u1;
public parametres (user_conn u2){
    super("settings");
    setLocation(550,170);
    this.u1=u2;
    login.setForeground(Color.GRAY);
    new_adr.setForeground(Color.GRAY);
    old_email1.setForeground(Color.GRAY);
    old_adr1.setForeground(Color.GRAY);
    new_email.setForeground(Color.GRAY);
    new_pwd.setForeground(Color.GRAY);
    old_pwd.setForeground(Color.GRAY);
    login1.setText(u1.u.log);
    old_adr.setText(u1.u.adr);
    old_email.setText(u1.u.email);
    setVisible(true);
    setSize(450,450);
    setResizable(false);
    JPanel j=new JPanel(new GridLayout(9,2,50,25));
    j.add(login);
    j.add(login1);
    j.add(old_adr1);
    j.add(old_adr);
    j.add(old_email1);
    j.add(old_email);
    j.add(new_adr);
    j.add(new_adr1);
    j.add(new_email);
    j.add(new_email1);
    j.add(a);
    j.add(b);
    j.add(old_pwd);
    j.add(old_pwd1);
    j.add(new_pwd);
    j.add(new_pwd1);
    j.add(edit);
    j.add(undo);
    setContentPane(j);
    undo.addActionListener(this);
    edit.addActionListener(this);
}
public void actionPerformed(ActionEvent e){
    if (e.getSource()==undo){
        dispose();
        u1.setVisible(true);
    }
    else if(e.getSource()==edit){
        String new_mail=new_email1.getText();
        String new_address=new_adr1.getText();
        String current_pwd=old_pwd1.getText();
        String new_mdp=new_pwd1.getText();
        if(!(new_mail.equals(""))){
            JOptionPane.showMessageDialog(null,"mail updated");
            u1.u.editer_mail_utilisateur(u1.u.log,new_mail);
            u1.u.cordonnées_utilisateur(u1.u.log);
            old_email.setText(u1.u.email);
            new_email1.setText("");
        }
        if(!(new_address.equals(""))){
            JOptionPane.showMessageDialog(null,"address updated");
            u1.u.editer_adr_utilisateur(u1.u.log,new_address);
            u1.u.cordonnées_utilisateur(u1.u.log);
            old_adr.setText(u1.u.adr);
            new_adr1.setText("");
        }
        //a etudier
        if(!(new_mdp.equals(""))){
            if(u1.u.mdp.equals(current_pwd)){
                u1.u.editer_mdp_utilisateur(u1.u.log,new_mdp);
                u1.u.cordonnées_utilisateur(u1.u.log);
                JOptionPane.showMessageDialog(null,"password updated");
            }
            else{
                JOptionPane.showMessageDialog(null,"invalid current password");
            }
            new_pwd1.setText("");
            old_pwd1.setText("");
        }
    }
}}
