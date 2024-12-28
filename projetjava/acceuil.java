package projetjava;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class acceuil extends JFrame implements ActionListener{
    JButton ad= new JButton("admin");
    JButton ut= new JButton("user");
    public acceuil(){
        super ("car app");
        setLocation(550,170);
        setVisible(true);
        setSize(200,150);
        setResizable(false);
        JPanel p = new JPanel(new GridLayout(2,1,25,15));
        p.add(ad);
        p.add(ut);
        setContentPane(p);
        ad.addActionListener(this);
        ut.addActionListener(this);
    }
        public static void main (String args[]){
            acceuil a1=new acceuil();
            database.loadconnection();
            }
    public void actionPerformed (ActionEvent e){
        if(e.getSource()==ad){
             admin a2=new admin(this);
             setVisible(false);
        }
        else{
            user_login a3=new user_login(this);
            setVisible(false);
        }
    }
    
}