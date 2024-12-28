package projetjava;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.sql.*;
import java.util.ArrayList;
public class car_rent extends JFrame implements ActionListener  {
    voiture v=new voiture();
    JButton achat=new JButton("rent");
    JButton undo=new JButton("undo");
    JLabel marque=new JLabel(" CAR BRAND :");
    JLabel marque1=new JLabel();
    JLabel modele =new JLabel("CAR MODEL :");
    JComboBox<String> car_marque= new JComboBox<>();
    ArrayList <String> a1=v.marque();
    JComboBox<String>car_modele= new JComboBox<>();
    JLabel age=new JLabel(" CAR AGE :");
    JComboBox age1=new JComboBox<>();
    JComboBox prix1=new JComboBox<>();
    JLabel prix = new JLabel("PRICE DT :");
    JLabel marque_selected=new JLabel(" BRAND SELECTED :");
    JLabel modele_selected=new JLabel(" MODEL SELECTED :");
    JLabel age_selected=new JLabel(" AGE SELECTED :");
    JLabel prix_selected=new JLabel(" PRICE SELECTED :");
    JLabel marque_selected1=new JLabel();
    JLabel modele_selected1=new JLabel();
    JLabel age_selected1=new JLabel();
    JLabel prix_selected1=new JLabel();
    user_conn u1;
    public car_rent(user_conn u2){
        super("car rent");
        setLocation(550,170);
        u1=u2;
        setSize(420,420);
        setResizable(false);
        setVisible(true);
        JPanel p=new JPanel(new GridLayout(9,2,25,25));
        for(int i=0;i<a1.size();i++){
            car_marque.addItem(a1.get(i));
        }
        p.add(marque);
        p.add(car_marque);
        p.add(marque_selected);
        p.add(marque_selected1);
        p.add(modele);
        p.add(car_modele);
        p.add(modele_selected);
        p.add(modele_selected1);
        p.add(age);
        p.add(age1);
        p.add(age_selected);
        p.add(age_selected1);
        p.add(prix);
        p.add(prix1);
        p.add(prix_selected);
        p.add(prix_selected1);
        p.add(achat);
        p.add(undo);
        car_marque.addActionListener(this);
        car_modele.addActionListener(this);
        age1.addActionListener(this);
        prix1.addActionListener(this);
        achat.addActionListener(this);
        undo.addActionListener(this);
        setContentPane(p);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==undo){
            u1.setVisible(true);
            dispose();
        }
        else if(e.getSource()==car_marque){
            car_modele.removeAllItems();
            marque_selected1.setText((String)car_marque.getSelectedItem());
            ArrayList <String> a=v.modele((String)car_marque.getSelectedItem());
            for(int i=0;i<a.size();i++){
                car_modele.addItem(a.get(i));
            }
        }
        else if(e.getSource()==car_modele){
            age1.removeAllItems();
            modele_selected1.setText((String)car_modele.getSelectedItem());
            ArrayList <String> a3=v.age((String)car_modele.getSelectedItem(),(String)car_marque.getSelectedItem());
            for(int i=0;i<a3.size();i++){
                age1.addItem(a3.get(i));
            }
        }
        else if(e.getSource()==age1){
            prix1.removeAllItems();
            age_selected1.setText((String)age1.getSelectedItem());
            ArrayList <String> a4=v.prix((String)age1.getSelectedItem(),(String)car_modele.getSelectedItem(),(String)car_marque.getSelectedItem());
            for(int i=0;i<a4.size();i++){
                prix1.addItem(a4.get(i));
            }
        }
        else if(e.getSource()==prix1){
            prix_selected1.setText((String)prix1.getSelectedItem());
            }
        else if(e.getSource()==achat){
            if(!(marque_selected1.getText().equals(""))){
            String imm=v.get_imm((String)age1.getSelectedItem(),(String)car_modele.getSelectedItem(),(String)car_marque.getSelectedItem(),(String)prix1.getSelectedItem());
            v.louer_voiture(u1.u.log, imm);  
            car_modele.removeAllItems();
            marque_selected1.setText("");
            JOptionPane.showMessageDialog(null, " CAR RENTED"); 
            }
        }
    }
}
