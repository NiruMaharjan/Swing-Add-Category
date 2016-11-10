/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaswing2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Lenovo
 */
public class AddCategoryUI extends JFrame{
private JLabel lblCategoryName,lblParentId;
private JTextField txtCategoryName,txtParentId;
private JButton btnSave;

    public AddCategoryUI() {
        setTitle("Add category");
        setSize(400,400);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         initComponents();
        setVisible(true);
   
    }
    
    public void initComponents(){
        lblCategoryName=new JLabel("Category name");
        txtCategoryName=new JTextField(50);
        lblParentId=new JLabel("Parent id");
        txtParentId=new JTextField(30);
        btnSave=new JButton("Save");
        
        btnSave.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
            Class.forName("com.mysql.jdbc.Driver");
                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/commerce2","root","");
                    String sql="Insert into category(category_name,parent_id)values(?,?)";
                    PreparedStatement stmt=conn.prepareStatement(sql);
                    stmt.setString(1, txtCategoryName.getText());
                    stmt.setInt(2, Integer.parseInt(txtParentId.getText()));
                    int result=stmt.executeUpdate();
                    if(result>0){
                        JOptionPane.showMessageDialog(null, "Added Succesfully");
                    }
                }
                catch(ClassNotFoundException  |SQLException ex){
                    
                }
            
            }
        } );
        add(lblCategoryName);
        add(txtCategoryName);
        add(lblParentId);
        add(txtParentId);
        add(btnSave);
        
    }
    
    
    
    
    
}
