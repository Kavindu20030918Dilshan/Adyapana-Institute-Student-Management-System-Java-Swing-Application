/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lk.javainstitute.adyapana.gui;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.SwingUtilities;
import java.sql.ResultSet;
import lk.javainstitute.adyapana.connection.MySQL;
import static lk.javainstitute.adyapana.gui.SplashWindow.logger;

/**
 *
 * @author KAVINDU DILSHAN
 */
public class Dashboard extends javax.swing.JFrame {

    public static StudentManagement studentManagement;
    public static SubjectManagement SubjectManagement;
    public static TeacherManagement teacherManagement;
    public static ClassManagement classManagement;
    public static ClassShedule classShedule;
    public static StudentAttendence studentAttendence;
    public static Payments payments;

    public Dashboard() {
        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/lk/javainstitute/adyapana/recources/icon.png")));
        setDate();
        addStudentManagement();
        setLogin();
    }

    private void setLogin(){
        try {
            ResultSet rs = MySQL.executeSearch("SELECT * FROM `admin`");
            if (rs.next()) {
                jLabel3.setText(rs.getString("username"));
            }
        } catch (Exception e) {
             logger.log(java.util.logging.Level.WARNING, "Exception Occured", e);
        }
    }
    private void setDate() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fomatDate = dateFormat.format(currentDate);
        jLabel1.setText("Date : " + fomatDate);

    }

    //-------------------------Add Remove Panels--------------------------------
    public void addStudentManagement() {

        if (studentManagement == null) {
            studentManagement = new StudentManagement(this);
            jPanel2.add(studentManagement, BorderLayout.CENTER);
            SwingUtilities.updateComponentTreeUI(jPanel2);
        }
    }

    public void removeStudentManagement() {
        if (studentManagement != null) {
            jPanel2.remove(studentManagement);
            studentManagement = null;
            SwingUtilities.updateComponentTreeUI(jPanel2);
        }

    }

    public void addSubjectManagement() {

        if (SubjectManagement == null) {
            SubjectManagement = new SubjectManagement(this);
            jPanel2.add(SubjectManagement, BorderLayout.CENTER);
            SwingUtilities.updateComponentTreeUI(jPanel2);
        }
    }

    public void removeSubjectManagement() {
        if (SubjectManagement != null) {
            jPanel2.remove(SubjectManagement);
            SubjectManagement = null;
            SwingUtilities.updateComponentTreeUI(jPanel2);
        }

    }

    public void addTeacherManagement() {

        if (teacherManagement == null) {
            teacherManagement = new TeacherManagement(this);
            jPanel2.add(teacherManagement, BorderLayout.CENTER);
            SwingUtilities.updateComponentTreeUI(jPanel2);
        }
    }

    public void removeTeacherManagement() {
        if (teacherManagement != null) {
            jPanel2.remove(teacherManagement);
            teacherManagement = null;
            SwingUtilities.updateComponentTreeUI(jPanel2);
        }

    }

    public void addClassManagement() {

        if (classManagement == null) {
            classManagement = new ClassManagement(this);
            jPanel2.add(classManagement, BorderLayout.CENTER);
            SwingUtilities.updateComponentTreeUI(jPanel2);
        }
    }

    public void removeClassManagement() {
        if (classManagement != null) {
            jPanel2.remove(classManagement);
            classManagement = null;
            SwingUtilities.updateComponentTreeUI(jPanel2);
        }

    }

    public void addClassShedule() {

        if (classShedule == null) {
            classShedule = new ClassShedule(this);
            jPanel2.add(classShedule, BorderLayout.CENTER);
            SwingUtilities.updateComponentTreeUI(jPanel2);
        }
    }

    public void removeClassShedule() {
        if (classShedule != null) {
            jPanel2.remove(classShedule);
            classShedule = null;
            SwingUtilities.updateComponentTreeUI(jPanel2);
        }

    }

    public void addStudentAttendence() {

        if (studentAttendence == null) {
            studentAttendence = new StudentAttendence(this);
            jPanel2.add(studentAttendence, BorderLayout.CENTER);
            SwingUtilities.updateComponentTreeUI(jPanel2);
        }
    }

    public void removeStudentAttendence() {
        if (studentAttendence != null) {
            jPanel2.remove(studentAttendence);
            studentAttendence = null;
            SwingUtilities.updateComponentTreeUI(jPanel2);
        }

    }

    public void addPayments() {

        if (payments == null) {
            payments = new Payments(this);
            jPanel2.add(payments, BorderLayout.CENTER);
            SwingUtilities.updateComponentTreeUI(jPanel2);
        }
    }

    public void removePayments() {
        if (payments != null) {
            jPanel2.remove(payments);
            payments = null;
            SwingUtilities.updateComponentTreeUI(jPanel2);
        }

    }

    //-------------------------Add Remove Panels--------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Adyapana Institute System");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Student Management");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setText("Subject Management");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton3.setText("Teacher Management");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton4.setText("Class Management");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton5.setText("Class Shedule");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton6.setText("Student Attendance");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton7.setText("Payments");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Hello Welcome.");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("..................................");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(28, 28, 28)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setPreferredSize(new java.awt.Dimension(797, 560));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Date : ");
        jPanel2.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        addTeacherManagement();
        removeStudentManagement();
        removeSubjectManagement();
        removeClassManagement();
        removeClassShedule();
        removeStudentAttendence();
        removePayments();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        addClassManagement();
        removeStudentManagement();
        removeSubjectManagement();
        removeTeacherManagement();
        removeClassShedule();
        removeStudentAttendence();
        removePayments();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        addClassShedule();
        removeStudentManagement();
        removeSubjectManagement();
        removeTeacherManagement();
        removeClassManagement();
        removeStudentAttendence();
        removePayments();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        addStudentAttendence();
        removeStudentManagement();
        removeSubjectManagement();
        removeTeacherManagement();
        removeClassManagement();
        removeClassShedule();
        removePayments();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        addStudentManagement();
        removeSubjectManagement();
        removeTeacherManagement();
        removeClassManagement();
        removeClassShedule();
        removeStudentAttendence();
        removePayments();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        addSubjectManagement();
        removeStudentManagement();
        removeTeacherManagement();
        removeClassManagement();
        removeClassShedule();
        removeStudentAttendence();
        removePayments();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        addPayments();
        removeStudentManagement();
        removeTeacherManagement();
        removeClassManagement();
        removeClassShedule();
        removeStudentAttendence();
        removeSubjectManagement();
    }//GEN-LAST:event_jButton7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatMacLightLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
