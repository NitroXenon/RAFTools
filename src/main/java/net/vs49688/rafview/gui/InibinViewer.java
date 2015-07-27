/*
 * RAFTools - Copyright (C) 2015 Zane van Iperen.
 *    Contact: zane.vaniperen@uqconnect.edu.au
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 2, and only
 * version 2 as published by the Free Software Foundation. 
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 * Any and all GPL restrictions may be circumvented with permission from the
 * the original author.
 */
package net.vs49688.rafview.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import net.vs49688.rafview.inibin.*;

public class InibinViewer extends JPanel {

	private Map<Integer, Value> m_Inibin;
	
	public InibinViewer(ActionListener listener) {
		initComponents();

		m_TextArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
		
		m_LoadExternalBtn.addActionListener(listener);

		setInibin(null);
	}

	public final synchronized void setInibin(Map<Integer, Value> inibin) {
		if(inibin == null)
			inibin = new HashMap<>();

		m_Inibin = inibin;
		
		m_TextArea.setText("");
		m_RAWRadio.doClick();
	}
	
	private void _displayAsRaw(Map<Integer, Value> map) {
		
		m_TextArea.setText("");
		
		for(final Integer key : map.keySet()) {
			m_TextArea.append(String.format("%12d: %s\n", key, map.get(key).toString()));
		}
	}
	
	private void _displayAsChampion(Map<Integer, Value> map) {
		m_TextArea.setText("");
	}
	
	private void _displayAsAbility(Map<Integer, Value> map) {
		m_TextArea.setText("");
	}
	
	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
	 * content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.ButtonGroup treatGroup = new javax.swing.ButtonGroup();
        m_LoadExternalBtn = new javax.swing.JButton();
        m_RAWRadio = new javax.swing.JRadioButton();
        m_ChampionRadio = new javax.swing.JRadioButton();
        m_AbilityRadio = new javax.swing.JRadioButton();
        javax.swing.JLabel treatAsLabel = new javax.swing.JLabel();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        m_TextArea = new javax.swing.JTextArea();

        m_LoadExternalBtn.setText("Load External File");
        m_LoadExternalBtn.setActionCommand("inibin->loadexternal");

        treatGroup.add(m_RAWRadio);
        m_RAWRadio.setText("Raw");
        m_RAWRadio.setActionCommand("raw");
        m_RAWRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _onTreatmentChange(evt);
            }
        });

        treatGroup.add(m_ChampionRadio);
        m_ChampionRadio.setText("Champion");
        m_ChampionRadio.setActionCommand("champion");
        m_ChampionRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _onTreatmentChange(evt);
            }
        });

        treatGroup.add(m_AbilityRadio);
        m_AbilityRadio.setText("Ability");
        m_AbilityRadio.setActionCommand("ability");
        m_AbilityRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _onTreatmentChange(evt);
            }
        });

        treatAsLabel.setText("Treat as:");

        m_TextArea.setEditable(false);
        m_TextArea.setColumns(20);
        m_TextArea.setRows(5);
        jScrollPane1.setViewportView(m_TextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(treatAsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(m_RAWRadio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(m_ChampionRadio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(m_AbilityRadio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
                        .addComponent(m_LoadExternalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(m_RAWRadio)
                        .addComponent(m_ChampionRadio)
                        .addComponent(m_AbilityRadio)
                        .addComponent(treatAsLabel))
                    .addComponent(m_LoadExternalBtn))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void _onTreatmentChange(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__onTreatmentChange
        String cmd = evt.getActionCommand();
		
		if(cmd.equals("ability")) {
			_displayAsAbility(m_Inibin);
		} else if(cmd.equals("champion")) {
			_displayAsChampion(m_Inibin);
		} else if(cmd.equals("raw")) {
			_displayAsRaw(m_Inibin);
		}
    }//GEN-LAST:event__onTreatmentChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton m_AbilityRadio;
    private javax.swing.JRadioButton m_ChampionRadio;
    private javax.swing.JButton m_LoadExternalBtn;
    private javax.swing.JRadioButton m_RAWRadio;
    private javax.swing.JTextArea m_TextArea;
    // End of variables declaration//GEN-END:variables
}
