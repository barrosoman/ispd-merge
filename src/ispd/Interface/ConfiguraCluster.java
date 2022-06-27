/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ConfiguraCluster.java
 *
 * Created on 29/12/2009, 13:31:47
 */
package ispd.Interface;
import javax.swing.*;
import java.awt.*;
import java.util.*;
/**
 *
 * @author Aldo Ianelo Guerra
 */
public class ConfiguraCluster extends JDialog {

    /** Creates new form ConfiguraCluster */
    public ConfiguraCluster(Icone iAux,HashSet<String> listaNos) {
        initComponents(iAux,listaNos);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents(Icone iAux,HashSet<String> listaNos) {

	this.I = iAux;
        this.listaNos = listaNos;
        jLabeInicial = new javax.swing.JLabel();
        jLabelLatencia = new javax.swing.JLabel();
        jLabelX = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jLabelY = new javax.swing.JLabel();
        jLabelNumNos = new javax.swing.JLabel();
        jLabelPoderComputacional = new javax.swing.JLabel();
        jTextFieldLatencia = new javax.swing.JTextField();
        jLabelLatencia1 = new javax.swing.JLabel();
        jTextFieldNumNos = new javax.swing.JTextField();
        jTextFieldY = new javax.swing.JTextField();
        jLabelY1 = new javax.swing.JLabel();
        jTextFieldX = new javax.swing.JTextField();
        jLabelX1 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldPoderComputacional = new javax.swing.JTextField();
        jLabelPoderComputacional1 = new javax.swing.JLabel();
        jLabelBanda = new javax.swing.JLabel();
        jTextFieldBanda = new javax.swing.JTextField();
        jLabelPoderCompucional3 = new javax.swing.JLabel();
        jComboBoxAlgoritmos = new javax.swing.JComboBox();
        jLabeInicial2 = new javax.swing.JLabel();
        jButtonOk = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();


        setTitle("Cluster icon configuration");
        setLocationRelativeTo(null);
        setResizable(false);
	setModal(true);

        jLabeInicial.setText("Configuration for the icon #: "+String.valueOf(I.getIdGlobal()));

        jLabelLatencia.setText("Latency:");

        jLabelX.setText("X-coordinate:");

        jLabelNome.setText("Label:");

        jLabelY.setText("Y-coordinate:");

        jLabelNumNos.setText("Number of nodes:");

        jLabelPoderComputacional.setText("Computational power:");

        jTextFieldLatencia.setText(String.valueOf(I.getLatencia()));

        jLabelLatencia1.setText("s");

        jTextFieldNumNos.setText(String.valueOf(I.getNumeroEscravos()));

        jTextFieldY.setEditable(false);
        jTextFieldY.setText(String.valueOf(I.getNumY()));
        jTextFieldY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldYActionPerformed(evt);
            }
        });

        jLabelY1.setText("px");

        jTextFieldX.setEditable(false);
        jTextFieldX.setText(String.valueOf(I.getNumX()));

        jLabelX1.setText("px");

        jTextFieldNome.setText(I.getNome());
	listaNos.remove(jTextFieldNome.getText());

        jTextFieldPoderComputacional.setText(String.valueOf(I.getPoderComputacional()));
        jTextFieldPoderComputacional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPoderComputacionalActionPerformed(evt);
            }
        });

        jLabelPoderComputacional1.setText("Mflop/s");

        jLabelBanda.setText("Bandwidth:");

        jTextFieldBanda.setText(String.valueOf(I.getBanda()));

        jLabelPoderCompucional3.setText("Mb/s");

        jComboBoxAlgoritmos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---" , "Round - Robin (RR)" , "Workqueue" }));
		if(I.getAlgoritmo()=="---"){
			jComboBoxAlgoritmos.setSelectedIndex(0);
		}
		if(I.getAlgoritmo()=="RoundRobin"){
			jComboBoxAlgoritmos.setSelectedIndex(1);
		}
		if(I.getAlgoritmo()=="Workqueue"){
			jComboBoxAlgoritmos.setSelectedIndex(2);
		}
		
        jComboBoxAlgoritmos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxAlgoritmosActionPerformed(evt);
            }
        });

        jLabeInicial2.setText("Scheduling algorithm:");

        jButtonOk.setText("Ok");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancel");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabeInicial)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelNome)
                            .addComponent(jLabelX)
                            .addComponent(jLabelY)
                            .addComponent(jLabelNumNos)
                            .addComponent(jLabelPoderComputacional)
                            .addComponent(jLabelBanda)
                            .addComponent(jLabelLatencia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTextFieldPoderComputacional, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jTextFieldLatencia, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextFieldBanda, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jTextFieldY, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldX, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jTextFieldNumNos, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelLatencia1)
                                    .addComponent(jLabelX1)
                                    .addComponent(jLabelY1)
                                    .addComponent(jLabelPoderCompucional3)
                                    .addComponent(jLabelPoderComputacional1))))
                        .addGap(18, 18, 18))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(jComboBoxAlgoritmos, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jButtonOk)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jButtonCancelar)))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabeInicial2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabeInicial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelX)
                    .addComponent(jLabelY1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelY)
                    .addComponent(jLabelX1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNumNos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNumNos))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPoderComputacional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPoderComputacional)
                    .addComponent(jLabelPoderComputacional1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldBanda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelBanda)
                    .addComponent(jLabelPoderCompucional3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldLatencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelLatencia)
                    .addComponent(jLabelLatencia1))
                .addGap(14, 14, 14)
                .addComponent(jLabeInicial2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxAlgoritmos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonOk))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldYActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTextFieldYActionPerformed

    private void jTextFieldPoderComputacionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPoderComputacionalActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTextFieldPoderComputacionalActionPerformed

    private void jComboBoxAlgoritmosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxAlgoritmosActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jComboBoxAlgoritmosActionPerformed

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
        // TODO add your handling code here:
	if(listaNos.contains(jTextFieldNome.getText()) && jTextFieldNome.getText()!=""){
		JOptionPane.showMessageDialog(null,"There's already an icon named \'"+jTextFieldNome.getText()+"\'.\nPlease enter a different name.","WARNING",JOptionPane.PLAIN_MESSAGE);
	}else if(ValidaValores.validaNome(jTextFieldNome.getText()) && ValidaValores.validaDouble(jTextFieldBanda.getText()) && ValidaValores.validaDouble(jTextFieldPoderComputacional.getText()) && ValidaValores.validaDouble(jTextFieldLatencia.getText()) && ValidaValores.validaInteiro(jTextFieldNumNos.getText()) ){
	        this.setVisible(false);
		listaNos.add(jTextFieldNome.getText());
		I.setNome(jTextFieldNome.getText());
		I.setLatencia(Double.parseDouble(jTextFieldLatencia.getText()));
		I.setBanda(Double.parseDouble(jTextFieldBanda.getText()));
		I.setPoderComputacional(Double.parseDouble(jTextFieldPoderComputacional.getText()));
		I.setPosition(Integer.parseInt(jTextFieldX.getText()),Integer.parseInt(jTextFieldY.getText()));		
		I.setNumeroEscravos(Integer.parseInt(jTextFieldNumNos.getText()));
		switch(jComboBoxAlgoritmos.getSelectedIndex()){
			case 0: I.setAlgoritmo("---"); break;
			case 1: I.setAlgoritmo("RoundRobin"); break;
			case 2: I.setAlgoritmo("Workqueue"); break;
		}
	}
}//GEN-LAST:event_jButtonOkActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
}//GEN-LAST:event_jButtonCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JComboBox jComboBoxAlgoritmos;
    private javax.swing.JLabel jLabeInicial;
    private javax.swing.JLabel jLabeInicial2;
    private javax.swing.JLabel jLabelBanda;
    private javax.swing.JLabel jLabelLatencia;
    private javax.swing.JLabel jLabelLatencia1;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelNumNos;
    private javax.swing.JLabel jLabelPoderCompucional3;
    private javax.swing.JLabel jLabelPoderComputacional;
    private javax.swing.JLabel jLabelPoderComputacional1;
    private javax.swing.JLabel jLabelX;
    private javax.swing.JLabel jLabelX1;
    private javax.swing.JLabel jLabelY;
    private javax.swing.JLabel jLabelY1;
    private javax.swing.JTextField jTextFieldBanda;
    private javax.swing.JTextField jTextFieldLatencia;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldNumNos;
    private javax.swing.JTextField jTextFieldPoderComputacional;
    private javax.swing.JTextField jTextFieldX;
    private javax.swing.JTextField jTextFieldY;
    private HashSet<String> listaNos;
	private Icone I;
    // End of variables declaration//GEN-END:variables

}