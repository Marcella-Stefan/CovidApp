package bitsplease;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

public class ContactUs extends javax.swing.JFrame {

    int xMouse;
    int yMouse;

    private final Connection conn = Account.getConnection();

    private final Account acc;

    public ContactUs(Account acc) {
        initComponents();

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("Icon.png"));
        setIconImage(icon.getImage());

        this.acc = acc;
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton_Send = new javax.swing.JButton();
        BackToMenu = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        JLabel_close = new javax.swing.JLabel();
        JLabel_minimize = new javax.swing.JLabel();
        JPanel_title = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        WindowMoverLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(250, 153, 0));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Subject:");

        jButton_Send.setBackground(new java.awt.Color(0, 51, 204));
        jButton_Send.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton_Send.setText("Send");
        jButton_Send.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Send.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_SendMouseClicked(evt);
            }
        });
        jButton_Send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SendActionPerformed(evt);
            }
        });

        BackToMenu.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        BackToMenu.setForeground(new java.awt.Color(51, 102, 255));
        BackToMenu.setText(" Back to the Menu");
        BackToMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BackToMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackToMenuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BackToMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BackToMenuMouseExited(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton_Send, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 136, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BackToMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(197, 197, 197))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton_Send, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(BackToMenu)
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
        jLabel3.setText("Contact us");

        javax.swing.GroupLayout JPanel_titleLayout = new javax.swing.GroupLayout(JPanel_title);
        JPanel_title.setLayout(JPanel_titleLayout);
        JPanel_titleLayout.setHorizontalGroup(
            JPanel_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanel_titleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(JPanel_title, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
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
                .addContainerGap(20, Short.MAX_VALUE))
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

    private void jButton_SendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_SendMouseClicked

    }//GEN-LAST:event_jButton_SendMouseClicked

    public void openMenu() {
        Menu menu = new Menu(acc);
    	menu.setVisible(true);
    	menu.pack();
    	menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.dispose();
    }

    public void uploadTheMessToDB(String body) throws SQLException {
        PreparedStatement myStmt = conn.prepareStatement("INSERT INTO EmailsTowardUs VALUES (?)");
        myStmt.setString(1, body);
        myStmt.execute();
    }

    public void closeConnection() {
        try {
           conn.close();
       } catch (SQLException ex) { 
            Logger.getLogger(ContactUs.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    /* When someone presses the send button what actually happens is that we
     * send an email to our selves that contains the message he want to send
     * and we add his email in the first line so that we know where to reply
     * (We cant send the email from his email bec we dont know the password).
     */
    private void jButton_SendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SendActionPerformed
        String subject = jTextField1.getText();
        String body = jTextArea1.getText();

        // I add the email of the user that sends the email, in the Body of the email
        // so i can know to whom i have to reply.
        body = "Email from: " + acc.getEmail() + "\n\nAbout: " + subject + "\n\n" + body;

        try {
            uploadTheMessToDB(body);
            JOptionPane.showMessageDialog(null, "We will reply to you as soon as possible."
                    + "\n                  Stay safe!","Confirmation message",1);
            closeConnection();
            openMenu();
        } catch (SQLException e) {
            Logger.getLogger(SignupGUI.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_jButton_SendActionPerformed

    private void BackToMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackToMenuMouseClicked
        //This operation is performed when we click the Back to the Menu button.
        closeConnection();
        openMenu();
    }//GEN-LAST:event_BackToMenuMouseClicked

    private void BackToMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackToMenuMouseEntered
        //when we enter the cursor in the Back to the Menu button(JLabel) it gets underlined
        //thats like a sign that the button works.
        Border label_border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black);
        BackToMenu.setBorder(label_border);
    }//GEN-LAST:event_BackToMenuMouseEntered

    private void BackToMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackToMenuMouseExited
        //when we move the cursor out of the button(JLabel) turns back to normal.
        BackToMenu.setBorder(null);
    }//GEN-LAST:event_BackToMenuMouseExited

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackToMenu;
    private javax.swing.JLabel JLabel_close;
    private javax.swing.JLabel JLabel_minimize;
    private javax.swing.JPanel JPanel_title;
    private javax.swing.JLabel WindowMoverLabel;
    private javax.swing.JButton jButton_Send;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
