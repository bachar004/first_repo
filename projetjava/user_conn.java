package projetjava;

import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.*;

public class user_conn extends JFrame implements ActionListener {
    JButton deconnexion=new JButton("log out");
    JButton louer=new JButton("rent");
    JButton parametre=new JButton("settings");
    utilisateur u;
    user_login page_Login;
    public user_conn(utilisateur u,user_login page_Login){
        super("user_conn");
        setLocation(550,170);
        setVisible(true);
        setSize(250,250);
        setResizable(false);
        this.u=u;
        this.page_Login=page_Login;
        JPanel j=new JPanel(new GridLayout(3,1,25,35));
        j.add(louer);
        j.add(parametre);
        j.add(deconnexion);
        setContentPane(j);
        louer.addActionListener(this);
        parametre.addActionListener(this);
        deconnexion.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==parametre){
            parametres p=new parametres(this);
            setVisible(false);
        }
        else if(e.getSource()==louer){
            car_rent car=new car_rent(this);
            setVisible(false);
        }
        else{
            dispose();
            page_Login.setVisible(true);
        }
    }
}
