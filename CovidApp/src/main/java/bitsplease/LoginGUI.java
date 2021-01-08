package bitsplease;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

public class LoginGUI extends javax.swing.JFrame {
    
    int xMouse;
    int yMouse;

    private final Connection conn = Account.getConnection();

    public LoginGUI() {
        initComponents();

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("Icon.png"));
        setIconImage(icon.getImage());

        //center the LOGIN window!
        this.setLocationRelativeTo(null);
        
        //boarder for the JPanel title (Login)
        Border jpanel_border = BorderFactory.createMatteBorder(0, 1, 1, 1, Color.orange);
        // set the border to the jpanel_title
        JPanel_title.setBorder(jpanel_border);
        
        //boarder for the minimize & close jlabels
        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
        JLabel_minimize.setBorder(label_border);
        JLabel_close.setBorder(label_border);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPasswordField = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton_login = new javax.swing.JButton();
        CreateNewAcc = new javax.swing.JLabel();
        jFormattedTextFieldID = new javax.swing.JFormattedTextField();
        JLabel_close = new javax.swing.JLabel();
        JLabel_minimize = new javax.swing.JLabel();
        JPanel_title = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        WindowMoverLabel = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 115, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(250, 153, 0));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText(" Enter ID:");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText(" Enter password:");

        jButton_login.setBackground(new java.awt.Color(0, 51, 204));
        jButton_login.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton_login.setText("Login");
        jButton_login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_loginMouseClicked(evt);
            }
        });
        jButton_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_loginActionPerformed(evt);
            }
        });

        CreateNewAcc.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CreateNewAcc.setForeground(new java.awt.Color(51, 102, 255));
        CreateNewAcc.setText(" Create an account");
        CreateNewAcc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CreateNewAcc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CreateNewAccMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CreateNewAccMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CreateNewAccMouseExited(evt);
            }
        });

        try {
            jFormattedTextFieldID.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UU ######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_login, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CreateNewAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jFormattedTextFieldID, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton_login, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(CreateNewAcc)
                .addContainerGap())
        );

        JLabel_close.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        JLabel_close.setText(" X ");
        JLabel_close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JLabel_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JLabel_closeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JLabel_closeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JLabel_closeMouseExited(evt);
            }
        });

        JLabel_minimize.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        JLabel_minimize.setText(" -");
        JLabel_minimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JLabel_minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JLabel_minimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JLabel_minimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JLabel_minimizeMouseExited(evt);
            }
        });

        JPanel_title.setBackground(new java.awt.Color(0, 84, 140));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Login");

        javax.swing.GroupLayout JPanel_titleLayout = new javax.swing.GroupLayout(JPanel_title);
        JPanel_title.setLayout(JPanel_titleLayout);
        JPanel_titleLayout.setHorizontalGroup(
            JPanel_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanel_titleLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(23, 23, 23))
        );
        JPanel_titleLayout.setVerticalGroup(
            JPanel_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanel_titleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JPanel_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(JLabel_minimize, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLabel_close)
                .addGap(8, 8, 8))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JLabel_close)
                            .addComponent(JLabel_minimize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(JPanel_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        WindowMoverLabel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                WindowMoverLabelMouseDragged(evt);
            }
        });
        WindowMoverLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                WindowMoverLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(WindowMoverLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(WindowMoverLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JLabel_minimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLabel_minimizeMouseEntered
       //when we enter the cursor in the minimize button(JLabel) it turns for black to white
       //thats like a sign that the button works.
       Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
       JLabel_minimize.setBorder(label_border);
       JLabel_minimize.setForeground(Color.white);   
    }//GEN-LAST:event_JLabel_minimizeMouseEntered

    private void JLabel_minimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLabel_minimizeMouseExited
       //when we move the cursor out of the minimize button(JLabel) it turns back to black.
       Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
       JLabel_minimize.setBorder(label_border);
       JLabel_minimize.setForeground(Color.black);
    }//GEN-LAST:event_JLabel_minimizeMouseExited

    private void JLabel_closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLabel_closeMouseEntered
       //when we enter the cursor in the close button(JLabel) it turns for black to white
       //thats like a sign that the button works.
       Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
       JLabel_close.setBorder(label_border);
       JLabel_close.setForeground(Color.white);
    }//GEN-LAST:event_JLabel_closeMouseEntered
  
    
    private void JLabel_closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLabel_closeMouseExited
      //when we move the cursor out of the close button(JLabel) it turns back to black.
      Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
      JLabel_close.setBorder(label_border);
      JLabel_close.setForeground(Color.black);
    }//GEN-LAST:event_JLabel_closeMouseExited

    private void jPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldActionPerformed

    private ResultSet userAuthentication(String ID, String pass) throws SQLException {
        Statement myStmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
                ResultSet.CONCUR_UPDATABLE);
    	ResultSet myRs = myStmt.executeQuery("select * from Accounts where id = '" + ID 
                + "' and pass = '" + pass + "'");
        return myRs;
    }

    private void checkIfUserExists(ResultSet myRs) throws InputException, SQLException {
        if(!myRs.next()) {
            JOptionPane.showMessageDialog(null, "You are not registered. Create an account first!"
                    ,"Login error",2);
            jFormattedTextFieldID.setValue(null);
    	    jPasswordField.setText("");
            throw new InputException();
        }
    }

    private void openMenu(ResultSet myRs) throws SQLException {
        Account acc = new Account(myRs.getString("id"), myRs.getString("Email"), 
                myRs.getString("Pass"));
    	Menu menu = new Menu(acc);
    	menu.setVisible(true);
    	menu.pack();
    	menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.dispose();
    }

    public void closeConnection() {
        try {
           conn.close();
       } catch (SQLException e) {
       }
    }
    private void jButton_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_loginActionPerformed

    	try {
            // Delete the entries that are older than 12 days
            Statement myStmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
                  ResultSet.CONCUR_UPDATABLE);
            myStmt.executeUpdate("DELETE FROM EntryInfos WHERE DATEDIFF(CURDATE(), "
                    + "DATE_FORMAT(DepartureTime, '%Y-%m-%d')) > 12");

            jFormattedTextFieldID.requestFocusInWindow();
            String ID = jFormattedTextFieldID.getText();
            String pass = String.valueOf(jPasswordField.getPassword());

            ResultSet myRs = userAuthentication(ID, pass);
            checkIfUserExists(myRs);
            openMenu(myRs);
            closeConnection();
        } catch (SQLException e) {

        } catch (InputException e) {

    	} catch (Exception e) {
           JOptionPane.showMessageDialog(null, "We are sorry, something went wrong!","Error",2);
           System.exit(1);
        }
    }//GEN-LAST:event_jButton_loginActionPerformed

    private void JLabel_minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLabel_minimizeMouseClicked
        //This operatation is performed when click the minimize button,
        //and minimizes the window.
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_JLabel_minimizeMouseClicked

    private void JLabel_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLabel_closeMouseClicked
        //This operatation is performed when click the close button,
        //and it closes the program.
        System.exit(0);
    }//GEN-LAST:event_JLabel_closeMouseClicked

    private void jButton_loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_loginMouseClicked
        
    }//GEN-LAST:event_jButton_loginMouseClicked

    private void CreateNewAccMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateNewAccMouseEntered
       //when we enter the cursor in the Create an account button(JLabel) it gets underlined
       //thats like a sign that the button works
       Border label_border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black);
       CreateNewAcc.setBorder(label_border);
    }//GEN-LAST:event_CreateNewAccMouseEntered

    private void CreateNewAccMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateNewAccMouseExited
       //when we move the cursor out of the button(JLabel) turns back to normal
       CreateNewAcc.setBorder(null);
    }//GEN-LAST:event_CreateNewAccMouseExited

    private void CreateNewAccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateNewAccMouseClicked
       //This operation is performed when we click the Create an account button
       //and it opens the Signup window (frame) by instanciate it and closes the Login window(frame.
       SignupGUI sign = new SignupGUI();
       sign.setVisible(true);
       sign.pack();
       sign.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.dispose();
       closeConnection();
    }//GEN-LAST:event_CreateNewAccMouseClicked

    private void WindowMoverLabelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_WindowMoverLabelMouseDragged
       int x = evt.getXOnScreen();
       int y = evt.getYOnScreen();

       //This operation is needed bec otherwise the cursor snaps in the top left of the window.
       this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_WindowMoverLabelMouseDragged

    private void WindowMoverLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_WindowMoverLabelMousePressed
       //When we have pressed the WindowMoverLabel (at the top of the JFrame)
       //those variables are getting the coordinates of our cursor.
       xMouse = evt.getX();
       yMouse = evt.getY();
    }//GEN-LAST:event_WindowMoverLabelMousePressed

    public static String instructions() {
        return "The goal of our application is to inform its users via email in case they had contacts\n"
               + "with other users that have registered themselves as confirmed cases.\n\n"
               + "In order to use our application, you first need to Sign up. The only personal details\n"
               + "you need to provide us with, is your ID number and your email address. Your data will\n"
               + "not be visible by the other users.\n\n"
               + "To make the best out of our application, you will need to add entries containing the\n"
               + "places that you have been. You can do that by using “Option 1” in the Menu.\n\n"
               + "If you have been tested positive for the virus you must use “Option 2” in the Menu in\n"
               + "order to inform the users of the application that you have contacted in the last twelve\n"
               + "days. Your data will not be be disclosed at any stage of the process.\n\n"
               + "If you have any questions, feel free to ask by clicking on “ContactUs”, at the bottom of\n"
               + "the Menu.";

    }
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JOptionPane.showMessageDialog(null, instructions(),"Welcome!",1);
                new LoginGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CreateNewAcc;
    private javax.swing.JLabel JLabel_close;
    private javax.swing.JLabel JLabel_minimize;
    private javax.swing.JPanel JPanel_title;
    private javax.swing.JLabel WindowMoverLabel;
    private javax.swing.JButton jButton_login;
    private javax.swing.JFormattedTextField jFormattedTextFieldID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField jPasswordField;
    // End of variables declaration//GEN-END:variables
}
