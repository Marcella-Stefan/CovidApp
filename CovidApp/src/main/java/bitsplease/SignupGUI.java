package bitsplease;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

public class SignupGUI extends javax.swing.JFrame {

    int xMouse;
    int yMouse;

    private final Connection conn = Account.getConnection();

    public SignupGUI() {
        initComponents();

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("Icon.png"));
        setIconImage(icon.getImage());

        //center the SIGNUP window!
        this.setLocationRelativeTo(null);
        
        //boarder for the JPanel title
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPasswordField = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton_signup = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        JText_email = new javax.swing.JTextField();
        LoginLabel = new javax.swing.JLabel();
        jFormattedTextField_ID = new javax.swing.JFormattedTextField();
        JLabel_close = new javax.swing.JLabel();
        JLabel_minimize = new javax.swing.JLabel();
        JPanel_title = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        MoveWindowPanel = new javax.swing.JLabel();

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

        jButton_signup.setBackground(new java.awt.Color(0, 51, 204));
        jButton_signup.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton_signup.setText("Signup");
        jButton_signup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_signupActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText(" Enter email:");

        JText_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JText_emailActionPerformed(evt);
            }
        });

        LoginLabel.setForeground(new java.awt.Color(51, 102, 255));
        LoginLabel.setText(" Already registered? Login");
        LoginLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LoginLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LoginLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LoginLabelMouseExited(evt);
            }
        });

        try {
            jFormattedTextField_ID.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UU ######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JText_email, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(36, 36, 36))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_signup, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextField_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(55, 55, 55))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(LoginLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JText_email, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jButton_signup, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(LoginLabel)
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
        jLabel3.setText("Signup");

        javax.swing.GroupLayout JPanel_titleLayout = new javax.swing.GroupLayout(JPanel_title);
        JPanel_title.setLayout(JPanel_titleLayout);
        JPanel_titleLayout.setHorizontalGroup(
            JPanel_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanel_titleLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
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
                .addGap(79, 79, 79)
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

        MoveWindowPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                MoveWindowPanelMouseDragged(evt);
            }
        });
        MoveWindowPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MoveWindowPanelMousePressed(evt);
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
            .addComponent(MoveWindowPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(MoveWindowPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
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

    private void jPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldActionPerformed

    private void clearTextFields() {
         jFormattedTextField_ID.setValue(null);
         JText_email.setText("");
         jPasswordField.setText("");
    }

    private void openMenu(Account acc) {
        Menu menu = new Menu(acc);
    	menu.setVisible(true);
    	menu.pack();
    	menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.dispose();
    }

    private void checkForEmptyTextFields(String ID, String email, String pass)
            throws InputException{
        if(jFormattedTextField_ID.getText().equals("         ") || JText_email.getText().isEmpty()
                || String.valueOf(jPasswordField.getPassword()).isEmpty()) {
            throw new InputException("All fields must be completed!");
        }
    }

    private void checkForInvalidPass(String pass) throws InputException {
        if(pass.length() < 7) {
            throw new InputException("Weak password, your password has to be more than 6 digits!");
        }
    }

    private void checkForInvalidEmail(String email) throws InputException {
        Pattern pattern = Pattern.compile("^[a-z0-9._-]{4,16}@[a-z]{3,12}\\.[a-z]{2,6}$"
                , Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
	boolean matchFound = matcher.find();
	if(!matchFound) {
            throw new InputException("Invalid email, you must register with a valid email!");
	}
    }

    private void openLogin() {
        LoginGUI log = new LoginGUI();
        log.setVisible(true);
        log.pack();
        log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }

    private void checksIfTheIDExists(String ID) throws SQLException, InputException {
        Statement myStmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
                ResultSet.CONCUR_UPDATABLE);
    	ResultSet myRs = myStmt.executeQuery("select * from Accounts where id = '" + ID + "'");
        if (myRs.next()){
            // id is unique so if it already exists in the database that means that the user
            // is already registered, thats why we open the login window.
            closeConnection();
            openLogin();
            throw new InputException("You are already registered! Please login");
        }
    }

    private void checksIfTheEmailExists(String email) throws SQLException, InputException {
        Statement myStmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
                ResultSet.CONCUR_UPDATABLE);
    	ResultSet myRs = myStmt.executeQuery("select * from Accounts where email = '" + email + "'");
        if(myRs.next()) {
            throw new InputException("This email is already in use");
        }
    }

    private void newUserCreation(Account acc) throws SQLException {
        Statement myStmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
                ResultSet.CONCUR_UPDATABLE);
        myStmt.executeUpdate("insert into Accounts (ID, Email, Pass) values ('"
                        + acc.getId() + "', '" + acc.getEmail() + "', '" + acc.getPass() + "')");
    }

    private void createsUser(String ID, String email, String pass) throws SQLException {
        Account acc = new Account(ID, email, pass);
        newUserCreation(acc);
        closeConnection();
        openMenu(acc);
    }

    private void closeConnection() {
        try {
           conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SignupGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void deleteOldEntries() throws SQLException {
        // Delete the entries that are older than 12 days
        Statement myStmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
              ResultSet.CONCUR_UPDATABLE);
        myStmt.executeUpdate("DELETE FROM EntryInfos WHERE DATEDIFF(CURDATE(), "
              + "DATE_FORMAT(DepartureTime, '%Y-%m-%d')) > 12");
    }

    private void jButton_signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_signupActionPerformed

        try {
            deleteOldEntries();

            jFormattedTextField_ID.requestFocusInWindow();
            String ID = jFormattedTextField_ID.getText();
            String email = JText_email.getText();
            String pass = String.valueOf(jPasswordField.getPassword());

            checkForEmptyTextFields(ID, email, pass);
            checkForInvalidPass(pass);
            checkForInvalidEmail(email);
            checksIfTheIDExists(ID);
            checksIfTheEmailExists(email);
            createsUser(ID, email, pass);
        } catch (InputException e) {
            JOptionPane.showMessageDialog(null, e.getMessage() , "Signup error", 2);
            clearTextFields();
        } catch (SQLException ex) {
            Logger.getLogger(SignupGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_signupActionPerformed

    private void JLabel_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLabel_closeMouseClicked
        //This operatation is performed when click the close button,
        //and it closes the program.
        closeConnection();
        System.exit(0);
    }//GEN-LAST:event_JLabel_closeMouseClicked

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

    private void JLabel_minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLabel_minimizeMouseClicked
        //This operatation is performed when click the minimize button,
        //and it minimizes the window.
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_JLabel_minimizeMouseClicked

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

    private void JText_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JText_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JText_emailActionPerformed

    private void LoginLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginLabelMouseEntered
       //when we enter the cursor in the Login button(JLabel) it gets underlined
       //thats like a sign that the button works.
        Border label_border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black);
        LoginLabel.setBorder(label_border);
    }//GEN-LAST:event_LoginLabelMouseEntered

    private void LoginLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginLabelMouseExited
        //when we move the cursor out of the button(JLabel) turns back to normal.
        LoginLabel.setBorder(null);
    }//GEN-LAST:event_LoginLabelMouseExited

    private void LoginLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginLabelMouseClicked
       //This operation is performed when we click the Login button
       //and it opens a Login window(frame) by instanciate it and closes the Signup window(frame)
       closeConnection();
       openLogin();
    }//GEN-LAST:event_LoginLabelMouseClicked

    private void MoveWindowPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MoveWindowPanelMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        //This operation is needed bec otherwise the cursor snaps in the top left of the window
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_MoveWindowPanelMouseDragged

    private void MoveWindowPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MoveWindowPanelMousePressed
       //When we have pressed the WindowMoverLabel (at the top of the JFrame)
       //those variables are getting the coordinates of our cursor. 
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_MoveWindowPanelMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabel_close;
    private javax.swing.JLabel JLabel_minimize;
    private javax.swing.JPanel JPanel_title;
    private javax.swing.JTextField JText_email;
    private javax.swing.JLabel LoginLabel;
    private javax.swing.JLabel MoveWindowPanel;
    private javax.swing.JButton jButton_signup;
    private javax.swing.JFormattedTextField jFormattedTextField_ID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField jPasswordField;
    // End of variables declaration//GEN-END:variables
}