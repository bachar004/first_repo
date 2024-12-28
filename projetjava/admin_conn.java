package projetjava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class admin_conn extends JFrame implements ActionListener{
    JButton add_car=new JButton("add car");
    JButton consulter_car=new JButton("check car");
    JButton consulter_user=new JButton("check user");
    JButton deconnexion=new JButton("log out");
    admin a;
    public admin_conn (admin a){
        super("admin");
        this.a=a;
        setLocation(550,170);
        setSize(300,250);
        setResizable(false);
        setVisible(true);
        JPanel p=new JPanel(new GridLayout(4,1,25,25));
        p.add(add_car);
        p.add(consulter_car);
        p.add(consulter_user);
        p.add(deconnexion);
        setContentPane(p);
        add_car.addActionListener(this);
        consulter_car.addActionListener(this);
        consulter_user.addActionListener(this);
        deconnexion.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==add_car){
            ajouter_voiture v=new ajouter_voiture(this);
            setVisible(false);
        }
        else if (e.getSource()==deconnexion){
            dispose();
            a.setVisible(true);
        }
        else if (e.getSource()==consulter_car){
            consulter_voiture v=new consulter_voiture(this);
            setVisible(false);
        }
        else if (e.getSource()==consulter_user){
            consulter_utilisateur cu=new consulter_utilisateur(this);
            setVisible(false);
        }
    }
}
