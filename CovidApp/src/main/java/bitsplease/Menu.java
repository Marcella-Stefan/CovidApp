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

public class Menu extends javax.swing.JFrame {

    private int xMouse;
    private int yMouse;

    private final Account acc;

    private final Connection conn = Account.getConnection();

    public Menu(Account acc) {
        initComponents();

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("Icon.png"));
        setIconImage(icon.getImage());

        this.acc = acc;
        //center the MENU window!
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        JText_place = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton_SumbitEntry = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        JText_address = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jFormattedTextField_TK = new javax.swing.JFormattedTextField();
        jFormattedTextField_ArrTime = new javax.swing.JFormattedTextField();
        jFormattedTextField_DepTime = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ContactUs = new javax.swing.JLabel();
        JLabel_close = new javax.swing.JLabel();
        JLabel_minimize = new javax.swing.JLabel();
        JPanel_title = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        WindowMoverLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(250, 153, 0));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        JText_place.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JText_placeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText(" Enter place:");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText(" Enter postal code:");

        jButton_SumbitEntry.setBackground(new java.awt.Color(0, 51, 204));
        jButton_SumbitEntry.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton_SumbitEntry.setText("Submit entry");
        jButton_SumbitEntry.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_SumbitEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SumbitEntryActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText(" Enter address:");

        JText_address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JText_addressActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText(" Enter arrival time in YYYY-MM-DD HH:MM form:");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText(" Enter departure time in YYYY-MM-DD HH:MM form:");

        jButton1.setBackground(new java.awt.Color(255, 51, 0));
        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setText("Press if you tested positive");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        try {
            jFormattedTextField_TK.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFormattedTextField_ArrTime.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-## ##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFormattedTextField_DepTime.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-## ##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel8.setFont(new java.awt.Font("Arial", 1, 28)); // NOI18N
        jLabel8.setText("Option 2: State that you tested positive");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 28)); // NOI18N
        jLabel9.setText("Option 1: Sumbit a new entry!");

        ContactUs.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ContactUs.setForeground(new java.awt.Color(51, 102, 255));
        ContactUs.setText("  Contact Us");
        ContactUs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ContactUs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ContactUsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ContactUsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ContactUsMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                                .addGap(26, 26, 26))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_SumbitEntry, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jFormattedTextField_DepTime, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(jFormattedTextField_ArrTime)
                            .addComponent(jFormattedTextField_TK)
                            .addComponent(JText_address)
                            .addComponent(JText_place))
                        .addGap(47, 47, 47))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel8))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(jLabel9)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ContactUs, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(315, 315, 315))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel9)
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JText_place, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JText_address, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField_TK, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField_ArrTime, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jFormattedTextField_DepTime, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jButton_SumbitEntry)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(26, 26, 26)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(ContactUs)
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
        jLabel3.setText("Menu");

        javax.swing.GroupLayout JPanel_titleLayout = new javax.swing.GroupLayout(JPanel_title);
        JPanel_title.setLayout(JPanel_titleLayout);
        JPanel_titleLayout.setHorizontalGroup(
            JPanel_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel_titleLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        JPanel_titleLayout.setVerticalGroup(
            JPanel_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel_titleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JPanel_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(229, 229, 229)
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
                .addContainerGap(21, Short.MAX_VALUE))
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

    private void JText_placeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JText_placeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JText_placeActionPerformed

    private void clearTextFields() {
        JText_place.setText("");
        JText_address.setText("");
        jFormattedTextField_TK.setValue(null);
        jFormattedTextField_ArrTime.setValue(null);
        jFormattedTextField_DepTime.setValue(null);
    }

    private void checksPlaceAddress() throws InputException {
       if(JText_place.getText().isEmpty()) {
            throw new InputException("The place field cannot be empty.");
       }
       if(!JText_address.getText().matches(".*\\d.*")) {
           throw new InputException("Invalid address! It must contain the number.");
       }
    }

    // We are changing date in greece 2 hours before the CURDATE(), so if we want to
    // add entries that happend from 00:00 till 02:00, we can add them to the database
    // only after 02:00. (We do not need to take care of that because of the quarantine
    // restrictions).
    public void checksDate(String dateTime) throws SQLException, InputException {
        Statement myStmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
                ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = myStmt.executeQuery("select (DATEDIFF(CURDATE(), DATE_FORMAT('" + dateTime 
                + "', '%Y-%m-%d')) >= 12 OR DATE_FORMAT('" + dateTime 
                + "', '%Y-%m-%d') > CURDATE());");
        //1 => true , 0 => false
        rs.first();
        if(rs.getString(1).equals("1")){
            throw new InputException("Invalid dates!");
        }
    }

    public void checksDates(String arrivalTime, String departureTime) 
            throws SQLException, InputException {
        //Checks if departure time is after the arrival time.
        Statement myStmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
                ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = myStmt.executeQuery("SELECT '" + arrivalTime + "' >= '" + departureTime + "'");
        //1 => true , 0 => false
        rs.first();
        if(rs.getString(1).equals("1")){
            throw new InputException("The arrival time cannot be after the departure time!");
        }
    }

    private void addEntry(Account acc, String place, String address, int TK,
            String arrivalTime, String departureTime) throws SQLException {
        Statement myStmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
                ResultSet.CONCUR_UPDATABLE);
        myStmt.executeUpdate("insert into EntryInfos (ID, Email, Pass, Place, Address,"
                + " TK, ArrivalTime, DepartureTime) " + "values ('" + acc.getId()
                + "', '" + acc.getEmail() + "', '" + acc.getPass() + "', '" + place
                + "', '" + address + "', '" + TK + "', '" + arrivalTime + "', '" + departureTime 
                + "');");
    }

    private void jButton_SumbitEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SumbitEntryActionPerformed

        try {
            JText_place.requestFocusInWindow();
            String place = JText_place.getText();
            String address = JText_address.getText();
            int TK = Integer.parseInt(jFormattedTextField_TK.getText());
            String arrivalTime = jFormattedTextField_ArrTime.getText();
            String departureTime = jFormattedTextField_DepTime.getText();

            checksPlaceAddress();
            checksDate(arrivalTime);
            checksDate(departureTime);
            checksDates(arrivalTime, departureTime);
            addEntry(acc, place, address, TK, arrivalTime, departureTime);
            JOptionPane.showMessageDialog(null, "Successfull entry");
            clearTextFields();          
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Its mandatory to fill in the postal code field!"
                    , "Error", 2);
            clearTextFields();
        } catch (SQLException e) {

        } catch (InputException e) {
            JOptionPane.showMessageDialog(null, e.getMessage() , "Error", 2);
            clearTextFields();
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Invalid dates!" , "Error", 2);
            clearTextFields();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "We are sorry, something went wrong!"
                    , "Error", 2);
            System.exit(1);
        }
    }//GEN-LAST:event_jButton_SumbitEntryActionPerformed

    private void JText_addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JText_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JText_addressActionPerformed

    private void JLabel_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLabel_closeMouseClicked
        //This operatation is performed when click the close button,
        //and it closes the programm.
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        acc.testedPositive();
        JOptionPane.showMessageDialog(null, "Thank you for your help!");
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void closeConnection() {
        try {
           conn.close();
       } catch (SQLException e) {
       }
    }

    private void ContactUsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ContactUsMouseClicked
        //This operation is performed when we click the Contact Us button
        //And it opens a ContactUs window(frame) by instanciate it and closes the Menu window(frame).
        ContactUs contUs = new ContactUs(acc);
        contUs.setVisible(true);
        contUs.pack();
        contUs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
        closeConnection();
    }//GEN-LAST:event_ContactUsMouseClicked

    private void ContactUsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ContactUsMouseEntered
        //when we enter the cursor in the Contact Us button(JLabel) it gets underlined
        //thats like a sign that the button works.
        Border label_border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black);
        ContactUs.setBorder(label_border);
    }//GEN-LAST:event_ContactUsMouseEntered

    private void ContactUsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ContactUsMouseExited
        //when we move the cursor out of the button(JLabel) turns back to normal.
        ContactUs.setBorder(null);
    }//GEN-LAST:event_ContactUsMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ContactUs;
    private javax.swing.JLabel JLabel_close;
    private javax.swing.JLabel JLabel_minimize;
    private javax.swing.JPanel JPanel_title;
    private javax.swing.JTextField JText_address;
    private javax.swing.JTextField JText_place;
    private javax.swing.JLabel WindowMoverLabel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_SumbitEntry;
    private javax.swing.JFormattedTextField jFormattedTextField_ArrTime;
    private javax.swing.JFormattedTextField jFormattedTextField_DepTime;
    private javax.swing.JFormattedTextField jFormattedTextField_TK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
