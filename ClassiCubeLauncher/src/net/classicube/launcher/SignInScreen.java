package net.classicube.launcher;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class SignInScreen extends javax.swing.JFrame {

    /**
     * Creates new form SignInScreen
     */
    public SignInScreen() {
        initComponents();
        Image bg = Resources.getClassiCubeBackground();
        bgPanel = new TiledImagePanel(bg);
        this.setContentPane(bgPanel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        bClassiCubeNet = new javax.swing.JToggleButton();
        bMinecraftNet = new javax.swing.JToggleButton();
        cAccount = new javax.swing.JComboBox();
        tPassword = new javax.swing.JPasswordField();
        xRememberMe = new javax.swing.JCheckBox();
        bSignIn = new javax.swing.JButton();
        canvas1 = new java.awt.Canvas();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWidths = new int[] {0, 5, 0};
        layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0};
        getContentPane().setLayout(layout);

        bClassiCubeNet.setText("ClassiCube.net");
        bClassiCubeNet.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                bClassiCubeNet_StateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        getContentPane().add(bClassiCubeNet, gridBagConstraints);

        bMinecraftNet.setText("Minecraft.net");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        getContentPane().add(bMinecraftNet, gridBagConstraints);

        cAccount.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        getContentPane().add(cAccount, gridBagConstraints);

        tPassword.setText("jPasswordField1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        getContentPane().add(tPassword, gridBagConstraints);

        xRememberMe.setText("Remember me");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        getContentPane().add(xRememberMe, gridBagConstraints);

        bSignIn.setText("Sign In");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_END;
        getContentPane().add(bSignIn, gridBagConstraints);

        canvas1.setName(""); // NOI18N
        canvas1.setPreferredSize(new java.awt.Dimension(250, 75));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        getContentPane().add(canvas1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bClassiCubeNet_StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_bClassiCubeNet_StateChanged
        canvas1.setBackground(Color.red);
    }//GEN-LAST:event_bClassiCubeNet_StateChanged
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton bClassiCubeNet;
    private javax.swing.JToggleButton bMinecraftNet;
    private javax.swing.JButton bSignIn;
    private javax.swing.JComboBox cAccount;
    private java.awt.Canvas canvas1;
    private javax.swing.JPasswordField tPassword;
    private javax.swing.JCheckBox xRememberMe;
    // End of variables declaration//GEN-END:variables

    TiledImagePanel bgPanel;
}