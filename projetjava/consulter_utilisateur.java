package projetjava;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class consulter_utilisateur extends JFrame implements ActionListener  {
    JLabel users=new JLabel(" LOGIN USER :");
    JComboBox <String> users1 =new JComboBox<>();
    JLabel adr=new JLabel(" ADDRESS :");
    JLabel adr1=new JLabel();
    JLabel mail=new JLabel(" EMAIL :");
    JLabel mail1=new JLabel();
    JButton undo=new JButton("UNDO ");
    JLabel selected_user=new JLabel(" SELECTED USER :");
    JLabel selected_user1=new JLabel();
    admin_conn admin ;
    utilisateur u=new utilisateur(null,null,null,null);
    ArrayList <String> a=u.all_users();
    public consulter_utilisateur(admin_conn admin){
        super("check user ");
        setLocation(550,170);
        setSize(400,350);
        setResizable(false);
        setVisible(true);
        this.admin=admin;
        for(int i=0;i<a.size();i++){
            users1.addItem(a.get(i));
        }
        JPanel p=new JPanel(new GridLayout(5,2,25,50));
        p.add(users);
        p.add(users1);
        p.add(selected_user);
        p.add(selected_user1);
        p.add(adr);
        p.add(adr1);
        p.add(mail);
        p.add(mail1);
        p.add(undo);
        users1.addActionListener(this);
        undo.addActionListener(this);
        setContentPane(p);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==undo){
            dispose();
            admin.setVisible(true);
        }
        else{
            String login=(String)users1.getSelectedItem();
            selected_user1.setText(login);
            String adr=u.get_adr(login);
            adr1.setText(adr);
            String mail=u.get_mail(login);
            mail1.setText(mail);
        }
    }  
}
