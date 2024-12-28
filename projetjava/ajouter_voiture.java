package projetjava;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ajouter_voiture extends JFrame implements ActionListener {
    JLabel imm=new JLabel(" CAR REGISTRATION :");
    JLabel modele=new JLabel(" CAR MODEL :");
    JLabel marque=new JLabel(" CAR BRAND :");
    JLabel age=new JLabel(" CAR AGE :");
    JLabel prix=new JLabel(" PRICE :");
    JLabel user=new JLabel(" USER :");
    JTextField imm1=new JTextField();
    JTextField modele1=new JTextField();
    JTextField marque1=new JTextField();
    JTextField age1=new JTextField();
    JTextField prix1=new JTextField();
    JTextField user1=new JTextField();
    JButton add=new JButton("add");
    JButton undo = new JButton("undo");
    admin_conn a;
    voiture v=new voiture();
    public ajouter_voiture (admin_conn a){
        super("add car");
        setSize(400,400);
        setVisible(true);
        setLocation(550,170);
        setResizable(false);
        this.a=a;
        JPanel p=new JPanel(new GridLayout(7,2,55,30));
        p.add(imm);
        p.add(imm1);
        p.add(marque);
        p.add(marque1);
        p.add(modele);
        p.add(modele1);
        p.add(age);
        p.add(age1);
        p.add(prix);
        p.add(prix1);
        p.add(user);
        p.add(user1);
        p.add(add);
        p.add(undo);
        add.addActionListener(this);
        undo.addActionListener(this);
        setContentPane(p);
    }
    public void actionPerformed(ActionEvent e){
        String get_imm=(imm1.getText()).replace(" ","");
        String get_marque=(marque1.getText()).replace(" ","");
        String get_modele=(modele1.getText()).replace(" ","");
        String get_age=(age1.getText()).replace(" ","");
        String get_prix=(prix1.getText()).replace(" ","");
        String get_user=(user1.getText()).replace(" ","");
        if(e.getSource()==undo){
            a.setVisible(true);
            dispose();
        }
        else{
            if(get_imm.equals("")|| get_marque.equals("") || get_modele.equals("")|| get_age.equals("") || get_prix.equals("")){
                JOptionPane.showMessageDialog(null,"only user field is optional ");
            }
            else{
                if(get_user.equals("")){
                    v.ajout_voiture(get_imm, get_marque, get_modele, get_age, get_prix,null);
                }
                else{
                    v.ajout_voiture(get_imm, get_marque, get_modele, get_age, get_prix, get_user);
                }
                JOptionPane.showMessageDialog(null, "car added if there is no exception");
            }
            imm1.setText("");
            marque1.setText("");
            modele1.setText("");
            age1.setText("");
            prix1.setText("");
            user1.setText("");
        }
    }
}
