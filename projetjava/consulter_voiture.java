package projetjava;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class consulter_voiture extends JFrame implements ActionListener {
    JLabel imm=new JLabel(" CAR REGISTRATION :");
    JComboBox <String> imm1= new JComboBox<>();
    JLabel marque=new JLabel(" CAR BRAND :");
    JLabel marque1=new JLabel();
    JLabel modele=new JLabel(" CAR MODEL :");
    JLabel modele1=new JLabel();
    JLabel age=new JLabel(" CAR AGE :");
    JLabel age1=new JLabel();
    JLabel prix=new JLabel(" CAR PRICE :");
    JLabel prix1=new JLabel();
    JLabel user=new JLabel(" CAR USER :");
    JLabel user1=new JLabel();
    JButton undo=new JButton("undo");
    admin_conn a;
    voiture v= new voiture();
    ArrayList <String> b=v.all_cars();
    public consulter_voiture(admin_conn a){
        super("check car");
        this.a=a;
        for(int i=0;i<b.size();i++){
            imm1.addItem(b.get(i));
        }
        setLocation(550,170);
        setSize(400,400);
        setResizable(false);
        setVisible(true);
        JPanel p=new JPanel(new GridLayout(7,2,25,25));
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
        p.add(undo);
        imm1.addActionListener(this);
        undo.addActionListener(this);
        setContentPane(p);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==undo){
            dispose();
            a.setVisible(true);
        }
        else{
            String immatricule=(String)imm1.getSelectedItem();
            String marquev=v.get_marque(immatricule);
            marque1.setText(marquev);
            String modelev=v.get_modele(immatricule);
            modele1.setText(modelev);
            String agev=v.get_age(immatricule);
            age1.setText(agev);
            String prixv=v.get_prix(immatricule);
            prix1.setText(prixv);
            String userv=v.get_user(immatricule);
            user1.setText(userv);
            
        }
    }
}
