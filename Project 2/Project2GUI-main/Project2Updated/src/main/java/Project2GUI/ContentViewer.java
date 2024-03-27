/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Project2GUI;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.*;

import javax.naming.spi.DirStateFactory.Result;

import java.io.*;
import static java.lang.System.*;
import java.sql.*;
/**
 *
 * @author naoka
 */

public class ContentViewer extends javax.swing.JFrame {
    public static String userId = "1488844";
    public static String month ="01";
    public static String year = "1999";
    /**
     * Creates new form ContentViewer
     */
    public ContentViewer() {
        initComponents();
        jLabel6.setVisible(false);
        outputTitles();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        buttonChangeUser = new javax.swing.JButton();
        buttonChangeView = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelTitlesWatched = new javax.swing.JLabel();
        title1 = new javax.swing.JButton();
        title3 = new javax.swing.JButton();
        title4 = new javax.swing.JButton();
        title2 = new javax.swing.JButton();
        title6 = new javax.swing.JButton();
        title5 = new javax.swing.JButton();
        labelRecommended = new javax.swing.JLabel();
        recommended1 = new javax.swing.JButton();
        recommended6 = new javax.swing.JButton();
        recommended5 = new javax.swing.JButton();
        recommended3 = new javax.swing.JButton();
        recommended4 = new javax.swing.JButton();
        recommended2 = new javax.swing.JButton();
        username = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonChangeUser.setText("Change User");
        buttonChangeUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChangeUserActionPerformed(evt);
            }
        });

        buttonChangeView.setText("Change View");
        buttonChangeView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChangeViewActionPerformed(evt);
            }
        });

        jLabel1.setText("Month");

        jLabel2.setText("Year");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1999", "2000", "2001", "2002", "2003", "2004", "2005" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 100, 244));
        jLabel3.setText("JmboMax");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Content Viewer");

        labelTitlesWatched.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelTitlesWatched.setText("Titles Watched");

        title1.setText("Title 1");
        title1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                title1ActionPerformed(evt);
            }
        });

        title3.setText("Title 3");

        title4.setText("Title 4");

        title2.setText("Title 2");

        title6.setText("Title 6");

        title5.setText("Title 5");

        labelRecommended.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelRecommended.setText("Recommended");

        recommended1.setText("Title 1");
        recommended1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recommended1ActionPerformed(evt);
            }
        });

        recommended6.setText("Title 6");

        recommended5.setText("Title 5");

        recommended3.setText("Title 3");

        recommended4.setText("Title 4");

        recommended2.setText("Title 2");

        username.setText("1488844");

        jLabel6.setForeground(new java.awt.Color(200, 0, 0));
        jLabel6.setText("No content available");

        jLabel7.setText("Logged in as:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(recommended1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(title1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(title2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(title3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(title4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(title5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(recommended2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(recommended3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(recommended4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(recommended5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(recommended6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(title6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(42, 42, 42))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(61, 61, 61))
                    .addComponent(labelTitlesWatched)
                    .addComponent(labelRecommended))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(username)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buttonChangeUser)
                        .addGap(18, 18, 18)
                        .addComponent(buttonChangeView)
                        .addGap(31, 31, 31))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(username)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonChangeUser)
                            .addComponent(buttonChangeView)))
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTitlesWatched)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(title6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(title5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(title1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(title2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(title3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(title4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addComponent(labelRecommended)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(recommended6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(recommended5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(recommended1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(recommended2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(recommended3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(recommended4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonChangeViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChangeViewActionPerformed
        ContentAnalyst ca = new ContentAnalyst();
        ca.setVisible(true);
    }//GEN-LAST:event_buttonChangeViewActionPerformed
    
    private void buttonChangeUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChangeUserActionPerformed
        // change user
        changeUser cu = new changeUser();
        cu.setVisible(true);
    }//GEN-LAST:event_buttonChangeUserActionPerformed

    private void title1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_title1ActionPerformed
       
    }//GEN-LAST:event_title1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        setMonth((String)jComboBox1.getSelectedItem());
        outputTitles();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        setYear((String)jComboBox2.getSelectedItem());
        outputTitles();
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void recommended1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recommended1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_recommended1ActionPerformed
    
    public javax.swing.JLabel getUsername() {
        return username;
    }

    public void setUserId(String newUserId) {
        // check if userid exists
        username.setText(newUserId);
        userId = newUserId;
    }
    
    public void setMonth(String newMonth){
        month = newMonth;
    }
    public void setYear(String newYear){
        year = newYear;
    }
    public static String getMonth(){
        return month;
    }
    public static String getYear(){
        return year;
    }
    
    public void outputTitles(){
         //String[] name = {}; // might change to string arrray
         List<String> name = new ArrayList<String>();
         List<String> date = new ArrayList<String>();
         try {
            ResultSet rs = P2backend.contentviewerWatch(userId,getMonth(),getYear());
            if(!rs.next()){
                System.out.println("Set is empty!");  
                jLabel6.setVisible(true);
                title1.setVisible(false);
                title2.setVisible(false);
                title3.setVisible(false);
                title4.setVisible(false);
                title5.setVisible(false);
                title6.setVisible(false);
            }else{
                while (rs.next()) {
                    name.add(rs.getString("OriginalTitle"));
                    date.add(rs.getString("daterating"));
                }
                int num_titles = name.size();
                switch(num_titles){
                    case 1: 
                        title1.setText(name.get(0));
                    case 2:
                        title1.setText(name.get(0));
                        title2.setText(name.get(1));
                    case 3: 
                        title1.setText(name.get(0));
                        title2.setText(name.get(1));
                        title3.setText(name.get(2));
                    case 4:
                        title1.setText(name.get(0));
                        title2.setText(name.get(1));
                        title3.setText(name.get(2));
                        title4.setText(name.get(3));
                    case 5:
                        title1.setText(name.get(0));
                        title2.setText(name.get(1));
                        title3.setText(name.get(2));
                        title4.setText(name.get(3));
                        title5.setText(name.get(4));
                    case 6:
                        title1.setText(name.get(0));
                        title2.setText(name.get(1));
                        title3.setText(name.get(2));
                        title4.setText(name.get(3));
                        title5.setText(name.get(4));
                        title6.setText(name.get(5));
                }
                
                title1.setVisible(true);
                title2.setVisible(true);
                title3.setVisible(true);
                title4.setVisible(true);
                title5.setVisible(true);
                title6.setVisible(true);
                jLabel6.setVisible(false);

            }
            } catch (Exception ex) {
                Logger.getLogger(ContentViewer.class.getName()).log(Level.SEVERE, null, ex);
            } 
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ContentViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ContentViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ContentViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ContentViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ContentViewer().setVisible(true);
            }
        });

         
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonChangeUser;
    private javax.swing.JButton buttonChangeView;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel labelRecommended;
    private javax.swing.JLabel labelTitlesWatched;
    private javax.swing.JButton recommended1;
    private javax.swing.JButton recommended2;
    private javax.swing.JButton recommended3;
    private javax.swing.JButton recommended4;
    private javax.swing.JButton recommended5;
    private javax.swing.JButton recommended6;
    private javax.swing.JButton title1;
    private javax.swing.JButton title2;
    private javax.swing.JButton title3;
    private javax.swing.JButton title4;
    private javax.swing.JButton title5;
    private javax.swing.JButton title6;
    public javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
