/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.event.ActionListener;
import javax.swing.JSlider;

/**
 *
 * @author Rafael
 */
public class SelectOptions extends javax.swing.JFrame {
    private ActionListener eventListener;

    /**
     * Creates new form SelectOptions
     * @param title
     */
    public SelectOptions(String title) {
        initComponents();
        this.frameTitle.setText(title);
        
        this.xPanel.setVisible(false);
        this.yPanel.setVisible(false);
        this.degreesPanel.setVisible(false);
        this.choicesPanel.setVisible(false);
        this.rPanel.setVisible(false);
        this.gPanel.setVisible(false);
        this.bPanel.setVisible(false);

    }
    
    public void addEventListener(ActionListener actionListener) {
        this.eventListener = actionListener;
    }
    
    public float getPercentageValue(JSlider slider) {
        return (float) slider.getValue() / 100;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frameTitle = new javax.swing.JLabel();
        xPanel = new javax.swing.JPanel();
        xSlider = new javax.swing.JSlider();
        xLabel = new javax.swing.JLabel();
        xValueLabel = new javax.swing.JLabel();
        yPanel = new javax.swing.JPanel();
        ySlider = new javax.swing.JSlider();
        yLabel = new javax.swing.JLabel();
        yValueLabel = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        degreesPanel = new javax.swing.JPanel();
        degreesSlider = new javax.swing.JSlider();
        degreesValueLabel = new javax.swing.JLabel();
        degreesLabel1 = new javax.swing.JLabel();
        choicesPanel = new javax.swing.JPanel();
        choicesLabel = new javax.swing.JLabel();
        choices = new java.awt.Choice();
        rPanel = new javax.swing.JPanel();
        rSlider = new javax.swing.JSlider();
        rValueLabel = new javax.swing.JLabel();
        rLabel = new javax.swing.JLabel();
        gPanel = new javax.swing.JPanel();
        gSlider = new javax.swing.JSlider();
        gValueLabel = new javax.swing.JLabel();
        gLabel = new javax.swing.JLabel();
        bPanel = new javax.swing.JPanel();
        bSlider = new javax.swing.JSlider();
        bValueLabel = new javax.swing.JLabel();
        bLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        frameTitle.setText("[TITLE]");

        xPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        xSlider.setPaintLabels(true);
        xSlider.setPaintTicks(true);
        xSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                xSliderStateChanged(evt);
            }
        });
        xPanel.add(xSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 28, -1, -1));

        xLabel.setText("X");
        xPanel.add(xLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        xValueLabel.setText(String.format("%d", this.xSlider.getValue()));
        xPanel.add(xValueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 28, -1, -1));

        yPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ySlider.setPaintLabels(true);
        ySlider.setPaintTicks(true);
        ySlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ySliderStateChanged(evt);
            }
        });
        yPanel.add(ySlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 28, -1, -1));

        yLabel.setText("Y");
        yPanel.add(yLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        yValueLabel.setText(String.format("%d", this.ySlider.getValue()));
        yPanel.add(yValueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 29, -1, -1));

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        degreesPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        degreesSlider.setMaximum(359);
        degreesSlider.setMinimum(1);
        degreesSlider.setPaintLabels(true);
        degreesSlider.setPaintTicks(true);
        degreesSlider.setValue(45);
        degreesSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                degreesSliderStateChanged(evt);
            }
        });
        degreesPanel.add(degreesSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 28, -1, -1));

        degreesValueLabel.setText(String.format("%d", this.degreesSlider.getValue()));
        degreesPanel.add(degreesValueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 29, -1, -1));

        degreesLabel1.setText("Ângulo de Rotação");
        degreesPanel.add(degreesLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        choicesPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        choicesLabel.setText("Título das escolhas");
        choicesPanel.add(choicesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));
        choicesPanel.add(choices, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 170, -1));

        rPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSlider.setPaintLabels(true);
        rSlider.setPaintTicks(true);
        rSlider.setValue(100);
        rSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rSliderStateChanged(evt);
            }
        });
        rPanel.add(rSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 28, -1, -1));

        rValueLabel.setText(String.format("%.2f", getPercentageValue(rSlider)));
        rPanel.add(rValueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 29, -1, -1));

        rLabel.setText("R");
        rPanel.add(rLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        gPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gSlider.setPaintLabels(true);
        gSlider.setPaintTicks(true);
        gSlider.setToolTipText("");
        gSlider.setValue(100);
        gSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                gSliderStateChanged(evt);
            }
        });
        gPanel.add(gSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 28, -1, -1));

        gValueLabel.setText(String.format("%.2f", getPercentageValue(gSlider)));
        gPanel.add(gValueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 29, -1, -1));

        gLabel.setText("G");
        gPanel.add(gLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        bPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bSlider.setPaintLabels(true);
        bSlider.setPaintTicks(true);
        bSlider.setValue(100);
        bSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                bSliderStateChanged(evt);
            }
        });
        bPanel.add(bSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 28, -1, -1));

        bValueLabel.setText(String.format("%.2f", getPercentageValue(bSlider)));
        bPanel.add(bValueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 29, -1, -1));

        bLabel.setText("B");
        bPanel.add(bLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(xPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelButton)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(choicesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(gPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                        .addComponent(okButton)
                        .addGap(94, 94, 94))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(frameTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(degreesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(frameTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(xPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(degreesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(okButton)
                            .addComponent(cancelButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(choicesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 28, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        this.eventListener.actionPerformed(null);
        this.dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void xSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_xSliderStateChanged
        this.xValueLabel.setText(String.format("%d", xSlider.getValue()));
    }//GEN-LAST:event_xSliderStateChanged

    private void ySliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ySliderStateChanged
        this.yValueLabel.setText(String.format("%d", ySlider.getValue()));
    }//GEN-LAST:event_ySliderStateChanged

    private void degreesSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_degreesSliderStateChanged
        this.degreesValueLabel.setText(String.format("%d", degreesSlider.getValue()));
    }//GEN-LAST:event_degreesSliderStateChanged

    private void rSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rSliderStateChanged
        this.rValueLabel.setText(String.format("%.2f", getPercentageValue(rSlider)));
    }//GEN-LAST:event_rSliderStateChanged

    private void gSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_gSliderStateChanged
        this.gValueLabel.setText(String.format("%.2f", getPercentageValue(gSlider)));
    }//GEN-LAST:event_gSliderStateChanged

    private void bSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_bSliderStateChanged
        this.bValueLabel.setText(String.format("%.2f", getPercentageValue(bSlider)));
    }//GEN-LAST:event_bSliderStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bLabel;
    public javax.swing.JPanel bPanel;
    public javax.swing.JSlider bSlider;
    private javax.swing.JLabel bValueLabel;
    private javax.swing.JButton cancelButton;
    public java.awt.Choice choices;
    public javax.swing.JLabel choicesLabel;
    public javax.swing.JPanel choicesPanel;
    private javax.swing.JLabel degreesLabel1;
    public javax.swing.JPanel degreesPanel;
    public javax.swing.JSlider degreesSlider;
    private javax.swing.JLabel degreesValueLabel;
    private javax.swing.JLabel frameTitle;
    private javax.swing.JLabel gLabel;
    public javax.swing.JPanel gPanel;
    public javax.swing.JSlider gSlider;
    private javax.swing.JLabel gValueLabel;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel rLabel;
    public javax.swing.JPanel rPanel;
    public javax.swing.JSlider rSlider;
    private javax.swing.JLabel rValueLabel;
    private javax.swing.JLabel xLabel;
    public javax.swing.JPanel xPanel;
    public javax.swing.JSlider xSlider;
    private javax.swing.JLabel xValueLabel;
    private javax.swing.JLabel yLabel;
    public javax.swing.JPanel yPanel;
    public javax.swing.JSlider ySlider;
    private javax.swing.JLabel yValueLabel;
    // End of variables declaration//GEN-END:variables
}
