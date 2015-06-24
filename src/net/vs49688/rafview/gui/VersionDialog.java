package net.vs49688.rafview.gui;

import javax.swing.*;

public class VersionDialog extends JDialog {

	public VersionDialog(JFrame parent) {
		super(parent, true);
		initComponents();
	}

	public String getVersionText() {
		return m_VersionText.getText();
	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JButton m_OKBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        m_VersionText = new javax.swing.JTextField();

        setTitle("Version:");
        setModal(true);
        setResizable(false);

        m_OKBtn.setText("OK");
        m_OKBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_OKBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Please enter the version of this archive:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(m_OKBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 54, Short.MAX_VALUE))
                    .addComponent(m_VersionText))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(m_VersionText, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(m_OKBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void m_OKBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_OKBtnActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_m_OKBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField m_VersionText;
    // End of variables declaration//GEN-END:variables
}