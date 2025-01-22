/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package lk.javainstitute.adyapana.gui;

import com.formdev.flatlaf.FlatClientProperties;
import java.io.InputStream;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lk.javainstitute.adyapana.connection.MySQL;
import static lk.javainstitute.adyapana.gui.SplashWindow.logger;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author KAVINDU DILSHAN
 */
public class Payments extends javax.swing.JPanel {

    private static Dashboard dashboard;
    private static HashMap<String, String> teacherMap = new HashMap<>();
    private static HashMap<String, String> monthMap = new HashMap<>();
    private static HashMap<String, String> studentMap = new HashMap<>();
    private static HashMap<String, String> subjectMap = new HashMap<>();

    public Payments(Dashboard dashboard) {
        initComponents();
        this.dashboard = dashboard;
        loadTeachers();
        loadMonths();
        loadStudents();
        loadSubject();
        loadpaymentDetails("");
        setPlaceholder();

    }

    private void setPlaceholder() {

        // Place holder
        jTextField2.putClientProperty("Jcomponent.roundRect", true);
        jTextField2.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Student N.I.C here.. ");
        jTextField2.putClientProperty(FlatClientProperties.STYLE, "margin:0,10,0,10");
        jTextField2.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON, true);

    }

    private void loadpaymentDetails(String nic) {

        try {
            ResultSet rs = MySQL.executeSearch("SELECT * FROM `invoice` "
                    + "INNER JOIN `student` ON `student`.`nic` = `invoice`.`student_nic`"
                    + " INNER JOIN `teacher` ON `teacher`.`teacher_no` = `invoice`.`teacher_teacher_no`"
                    + "INNER JOIN `subject` ON `subject`.`id` = `invoice`.`subject_id` "
                    + "INNER JOIN `month` ON `month`.`id` = `invoice`.`month_id` WHERE `student`.`nic` LIKE '" + nic + "%' ORDER BY `invoice`.`id` ASC ");
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(rs.getString("invoice.id"));
                jLabel3.setText(String.valueOf(Integer.parseInt(rs.getString("invoice.id")) + 1));
                vector.add(rs.getString("value"));
                vector.add(rs.getString("student.nic") + " : " + rs.getString("student.Full Name"));
                vector.add(rs.getString("teacher.fullname"));
                vector.add(rs.getString("subject.description"));
                vector.add(rs.getString("month.month"));
                vector.add(rs.getString("date"));

                dtm.addRow(vector);
            }

            jTable1.setModel(dtm);
        } catch (Exception e) {
            logger.log(java.util.logging.Level.WARNING, "Exception Occured", e);
        }

    }

    private void loadTeachers() {
        try {
            ResultSet rs = MySQL.executeSearch("SELECT * FROM `teacher` ");
            Vector<String> v = new Vector<>();
            v.add("Select");
            while (rs.next()) {
                v.add(rs.getString("fullname"));
                teacherMap.put(rs.getString("fullname"), rs.getString("teacher_no"));
            }
            DefaultComboBoxModel model = new DefaultComboBoxModel(v);
            jComboBox2.setModel(model);
        } catch (Exception e) {
            logger.log(java.util.logging.Level.WARNING, "Exception Occured", e);
        }
    }

    private void loadMonths() {
        try {
            ResultSet rs = MySQL.executeSearch("SELECT * FROM `month` ");
            Vector<String> v = new Vector<>();
            v.add("Select");
            while (rs.next()) {
                v.add(rs.getString("month"));
                monthMap.put(rs.getString("month"), rs.getString("id"));
            }
            DefaultComboBoxModel model = new DefaultComboBoxModel(v);
            jComboBox4.setModel(model);
        } catch (Exception e) {
            logger.log(java.util.logging.Level.WARNING, "Exception Occured", e);
        }
    }

    private void loadStudents() {
        try {
            ResultSet rs = MySQL.executeSearch("SELECT * FROM `student` ");
            Vector<String> v = new Vector<>();
            v.add("Select");
            while (rs.next()) {
                v.add(rs.getString("nic") + " : " + rs.getString("Full Name"));
                studentMap.put(rs.getString("nic") + " : " + rs.getString("Full Name"), rs.getString("nic"));
            }
            DefaultComboBoxModel model = new DefaultComboBoxModel(v);
            jComboBox1.setModel(model);
        } catch (Exception e) {
            logger.log(java.util.logging.Level.WARNING, "Exception Occured", e);
        }
    }

    private void loadSubject() {
        try {
            ResultSet rs = MySQL.executeSearch("SELECT * FROM `subject` ");
            Vector<String> v = new Vector<>();
            v.add("Select");
            while (rs.next()) {
                v.add(rs.getString("description"));
                subjectMap.put(rs.getString("description"), rs.getString("id"));
            }
            DefaultComboBoxModel model = new DefaultComboBoxModel(v);
            jComboBox3.setModel(model);
        } catch (Exception e) {
            logger.log(java.util.logging.Level.WARNING, "Exception Occured", e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Payments ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Invoice Number :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("0000");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Amount :");

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Student : ");

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Teacher : ");

        jComboBox2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Subject :");

        jComboBox3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Month :");

        jComboBox4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Date :");

        jDateChooser1.setDateFormatString("yyyy-MM-dd");
        jDateChooser1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Payment ID", "Amount", "Student", "Teacher", "Subject", "Month", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setShowGrid(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39)
                                        .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(4, 4, 4)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(138, 138, 138)
                                        .addComponent(jTextField2))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(73, 73, 73))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(jLabel9))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 2) {
            int row = jTable1.getSelectedRow();

            if (row > -1) {
                try {
                    String getPaymentID = String.valueOf(jTable1.getValueAt(row, 0));
                    String getAmount = String.valueOf(jTable1.getValueAt(row, 1));
                    String getStudent = String.valueOf(jTable1.getValueAt(row, 2));
                    String getTeacher = String.valueOf(jTable1.getValueAt(row, 3));
                    String getSubject = String.valueOf(jTable1.getValueAt(row, 4));
                    String getMonth = String.valueOf(jTable1.getValueAt(row, 5));
                    String getDate = String.valueOf(jTable1.getValueAt(row, 6));
                    Date formatDate = new SimpleDateFormat("yyyy-MM-dd").parse(getDate);

                    jLabel3.setText(getPaymentID);
                    jTextField1.setText(getAmount);
                    jComboBox2.setSelectedItem(getTeacher);
                    jComboBox4.setSelectedItem(getMonth);
                    jComboBox1.setSelectedItem(getStudent);
                    jComboBox3.setSelectedItem(getSubject);
                    jDateChooser1.setDate(formatDate);

                } catch (Exception e) {
                    logger.log(java.util.logging.Level.WARNING, "Exception Occured", e);
                }
            }

        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String amount = jTextField1.getText();
        String teacher = String.valueOf(jComboBox2.getSelectedItem());
        String month = String.valueOf(jComboBox4.getSelectedItem());
        String student = String.valueOf(jComboBox1.getSelectedItem());
        String subject = String.valueOf(jComboBox3.getSelectedItem());

        if (amount.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter amount", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!amount.matches("^[1-9]\\d*(\\.\\d+)?$")) {
            JOptionPane.showMessageDialog(this, "Please enter valid amount", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (teacher.matches("Select")) {
            JOptionPane.showMessageDialog(this, "Please select teacher", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (month.matches("Select")) {
            JOptionPane.showMessageDialog(this, "Please select month", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (student.matches("Select")) {
            JOptionPane.showMessageDialog(this, "Please select student", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (subject.matches("Select")) {
            JOptionPane.showMessageDialog(this, "Please select subject", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (jDateChooser1.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Please select date", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String fomatDate = dateFormat.format(jDateChooser1.getDate());
            try {
                ResultSet rs = MySQL.executeSearch("SELECT * FROM `invoice` WHERE `value` = '" + Double.valueOf(amount) + "' AND `student_nic` = '" + studentMap.get(student) + "' AND `teacher_teacher_no` = '" + teacherMap.get(teacher) + "' AND `subject_id` = '" + subjectMap.get(subject) + "' AND `month_id` = '" + monthMap.get(month) + "' AND `date` = '" + fomatDate + "' ");

                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Payment already done", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {

                    MySQL.executeIUD("INSERT INTO `invoice` (`value` , `student_nic` , `teacher_teacher_no` , `subject_id` , `month_id` , `date`) "
                            + "VALUES('" + Double.valueOf(amount) + "' ,"
                            + " '" + studentMap.get(student) + "' ,"
                            + " '" + teacherMap.get(teacher) + "' ,"
                            + " '" + subjectMap.get(subject) + "' ,"
                            + "'" + monthMap.get(month) + "' ,"
                            + " '" + fomatDate + "' ) ");
//                    JOptionPane.showMessageDialog(this, "Payment completed", "Warning", JOptionPane.INFORMATION_MESSAGE);
                    InputStream s = this.getClass().getResourceAsStream("/lk/javainstitute/adyapana/reports/adyapana_nInvoice.jasper");
                    HashMap<String, Object> params = new HashMap<>();
                    params.put("Parameter1", jLabel3.getText());//payment id
                    params.put("Parameter2", amount);//amount
                    params.put("Parameter3", student);//student
                    params.put("Parameter4", teacher);//teacher
                    params.put("Parameter5", subject);//subject
                    params.put("Parameter6", month);//month

                    JRTableModelDataSource dataSource = new JRTableModelDataSource(jTable1.getModel());

                    JasperPrint jasperPrint = JasperFillManager.fillReport(s, params, dataSource);

                    JasperViewer.viewReport(jasperPrint, false);
                    reset();
                }
            } catch (Exception e) {
                logger.log(java.util.logging.Level.WARNING, "Exception Occured", e);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int row = jTable1.getSelectedRow();

        if (row > -1) {
            String amount = jTextField1.getText();
            String teacher = String.valueOf(jComboBox2.getSelectedItem());
            String month = String.valueOf(jComboBox4.getSelectedItem());
            String student = String.valueOf(jComboBox1.getSelectedItem());
            String subject = String.valueOf(jComboBox3.getSelectedItem());

            if (amount.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter amount", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (!amount.matches("^[1-9]\\d*(\\.\\d+)?$")) {
                JOptionPane.showMessageDialog(this, "Please enter valid amount", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (teacher.matches("Select")) {
                JOptionPane.showMessageDialog(this, "Please select teacher", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (month.matches("Select")) {
                JOptionPane.showMessageDialog(this, "Please select month", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (student.matches("Select")) {
                JOptionPane.showMessageDialog(this, "Please select student", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (subject.matches("Select")) {
                JOptionPane.showMessageDialog(this, "Please select subject", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (jDateChooser1.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Please select date", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String fomatDate = dateFormat.format(jDateChooser1.getDate());
                try {
                    String getPaymentID = String.valueOf(jTable1.getValueAt(row, 0));

                    if (jLabel3.getText().equals(getPaymentID)) {
                        JOptionPane.showMessageDialog(this, "Payment details already exists", "Warning", JOptionPane.WARNING_MESSAGE);
                    } else {

                        MySQL.executeIUD("UPDATE `invoice` SET `value` = '" + amount + "' ,"
                                + " `student_nic` ='" + studentMap.get(student) + "' "
                                + ", `teacher_teacher_no` = '" + teacherMap.get(teacher) + "' , "
                                + " `subject_id` = '" + subjectMap.get(subject) + "' , "
                                + " `month_id` = '" + monthMap.get(month) + "' ,"
                                + " `date` = '" + fomatDate + "'  ");
                        JOptionPane.showMessageDialog(this, "Payment updated success", "Success", JOptionPane.INFORMATION_MESSAGE);
                        reset();
                    }
                } catch (Exception e) {
                    logger.log(java.util.logging.Level.WARNING, "Exception Occured", e);
                }
            }

        } else {
            JOptionPane.showMessageDialog(this, "Please select row to update", "Warning", JOptionPane.WARNING_MESSAGE);
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        reset();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        loadpaymentDetails(jTextField2.getText());
    }//GEN-LAST:event_jTextField2KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

    private void reset() {
        loadpaymentDetails("");
        jTextField2.setText("");
        jTextField1.setText("");
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        jComboBox3.setSelectedIndex(0);
        jComboBox4.setSelectedIndex(0);
        jDateChooser1.setDate(null);
        jTable1.clearSelection();
    }
}
