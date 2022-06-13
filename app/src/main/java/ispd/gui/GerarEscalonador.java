/* ==========================================================
 * iSPD : iconic Simulator of Parallel and Distributed System
 * ==========================================================
 *
 * (C) Copyright 2010-2014, by Grupo de pesquisas em Sistemas Paralelos e Distribuídos da Unesp (GSPD).
 *
 * Project Info:  http://gspd.dcce.ibilce.unesp.br/
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 *
 * [Oracle and Java are registered trademarks of Oracle and/or its affiliates. 
 * Other names may be trademarks of their respective owners.]
 *
 * ---------------
 * GerarEscalonador.java
 * ---------------
 * (C) Copyright 2014, by Grupo de pesquisas em Sistemas Paralelos e Distribuídos da Unesp (GSPD).
 *
 * Original Author:  Denison Menezes (for GSPD);
 * Contributor(s):   -;
 *
 * Changes
 * -------
 * Created on 30/04/2011
 * 09-Set-2014 : Version 2.0;
 *
 */
package ispd.gui;

import ispd.utils.ValidaValores;
import ispd.arquivo.interpretador.gerador.InterpretadorGerador;
import ispd.alocacaoVM.ManipularArquivosAlloc;
import ispd.escalonador.ManipularArquivos;
import ispd.escalonadorCloud.ManipularArquivosCloud;
import java.awt.Color;
import java.awt.Toolkit;
import java.io.File;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 *
 * @author denison
 */
public class GerarEscalonador extends javax.swing.JDialog {

    private final int INICIAL = 0;
    private final int VARIAVEL = 1;
    private final int OPERADOR = 2;
    private final int ABRE_CHAVE = 3;
    private final int FECHA_CHAVE = 4;
    public static final int GRID = 0;
    public static final int IAAS = 1;
    public static final int ALLOC = 2;
    private int passoAtual;
    private String caminho;
    private String ordenacao;
    private String ordenacao_t = "Random"; //NOI18N
    private String ordenacao_r = "Random"; //NOI18N
    private LinkedList<String> formula;
    private LinkedList<String> formula_t = new LinkedList<String>() {

        @Override
        public String toString() {
            String result = ""; //NOI18N
            for (String item : this) {
                result += item + " "; //NOI18N
            }
            return result;
        }
    };
    private LinkedList<String> formula_r = new LinkedList<String>() {

        @Override
        public String toString() {
            String result = ""; //NOI18N
            for (String item : this) {
                result += item + " "; //NOI18N
            }
            return result;
        }
    };
    private int tipoBotao;
    private int tipoBotao_t = INICIAL;
    private int tipoBotao_r = INICIAL;
    private int contaParent;
    private int contaParent_t = 0;
    private int contaParent_r = 0;
    private ManipularArquivos arquivosEscalonadores = null;
    private ManipularArquivosCloud arquivosEscalonadoresCloud = null;
    private ManipularArquivosAlloc arquivosAlocadores = null;
    private InterpretadorGerador parse = null;
    private ResourceBundle palavras;
    private int tipoModelo;

    /**
     * Creates new form GerarEscalonador
     */
    public GerarEscalonador(java.awt.Frame parent, boolean modal, String caminho, ResourceBundle palavras) {
        super(parent, modal);
        this.palavras = palavras;
        this.caminho = caminho;
        this.passoAtual = 1;
        //Inicio das variaveis para formula
        this.ordenacao = "Random"; //NOI18N
        this.formula = formula_t;
        this.tipoBotao = INICIAL;
        this.contaParent = 0;
        //Fim das variaveis para formula
        initComponents();
        //Adiciona a janela o primeiro painel
        this.jScrollPanePrincipal.setViewportView(this.jPanelPasso1);
        jTextFieldP1NomeEscKeyReleased(null);
        //Esconde Topologia do painel 2
        jLabelP2Topologia.setVisible(false);
        jRadioButtonP2Centralizada.setVisible(false);
        jRadioButtonP2Distribuida.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPasso1 = new javax.swing.JPanel();
        jLabelP1NomeEsc = new javax.swing.JLabel();
        jTextFieldP1NomeEsc = new javax.swing.JTextField();
        jLabelP1LocalArq = new javax.swing.JLabel();
        jTextFieldP1LocalArq = new javax.swing.JTextField();
        jSeparatorP1 = new javax.swing.JSeparator();
        jLabelP1Informacao = new javax.swing.JLabel();
        jPanelPasso2 = new javax.swing.JPanel();
        jLabelP2Informacao = new javax.swing.JLabel();
        jRadioButtonP2Estatica = new javax.swing.JRadioButton();
        jRadioButtonP2Dinamica = new javax.swing.JRadioButton();
        jLabelP2Forma = new javax.swing.JLabel();
        jRadioButtonP2Tempo = new javax.swing.JRadioButton();
        jRadioButtonP2Chegada = new javax.swing.JRadioButton();
        jRadioButtonP2Saida = new javax.swing.JRadioButton();
        jFormattedTextFieldP2Tempo = new javax.swing.JFormattedTextField();
        jLabelP2Topologia = new javax.swing.JLabel();
        jRadioButtonP2Centralizada = new javax.swing.JRadioButton();
        jRadioButtonP2Distribuida = new javax.swing.JRadioButton();
        jRadioButtonP2concluida = new javax.swing.JRadioButton();
        jPanelPasso3 = new javax.swing.JPanel();
        jOpSimples = new javax.swing.JRadioButton();
        jOpAvancada = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanelPasso4 = new javax.swing.JPanel();
        jLabelP4Formula = new javax.swing.JLabel();
        jTextFieldP4Formula = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButtonP4Add = new javax.swing.JButton();
        jButtonP4Sub = new javax.swing.JButton();
        jButtonP4AbreParent = new javax.swing.JButton();
        jButtonP4FechaParent = new javax.swing.JButton();
        jButtonP4Div = new javax.swing.JButton();
        jButtonP4Mult = new javax.swing.JButton();
        jButtonP4Voltar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButtonP4TComputacao = new javax.swing.JButton();
        jButtonP4TComunicacao = new javax.swing.JButton();
        jButtonP4NTSubmetidas = new javax.swing.JButton();
        jButtonP4NTConcluidas = new javax.swing.JButton();
        jButtonP4PComputUser = new javax.swing.JButton();
        jButtonP4Const = new javax.swing.JButton();
        jFormattedTextP4DigitaConst = new javax.swing.JFormattedTextField();
        jButtonP4PTempoCriacao = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jRadioButtonP4Crescente = new javax.swing.JRadioButton();
        jRadioButtonP4Decrescente = new javax.swing.JRadioButton();
        jRadioButtonP4Random = new javax.swing.JRadioButton();
        jRadioButtonP4FIFO = new javax.swing.JRadioButton();
        jPanelPasso5 = new javax.swing.JPanel();
        jLabelP5Formula = new javax.swing.JLabel();
        jTextFieldP5Formula = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jButtonP5Add = new javax.swing.JButton();
        jButtonP5Sub = new javax.swing.JButton();
        jButtonP5AbreParent = new javax.swing.JButton();
        jButtonP5FechaParent = new javax.swing.JButton();
        jButtonP5Div = new javax.swing.JButton();
        jButtonP5Mult = new javax.swing.JButton();
        jButtonP5Voltar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButtonP5PProcessamento = new javax.swing.JButton();
        jButtonP5LinkComunicacao = new javax.swing.JButton();
        jButtonP5TCompTarefa = new javax.swing.JButton();
        jButtonP5NumTExec = new javax.swing.JButton();
        jButtonP5TComunTarefa = new javax.swing.JButton();
        jButtonP5Const1 = new javax.swing.JButton();
        jFormattedTextP5DigitaConst = new javax.swing.JFormattedTextField();
        jButtonP5MflopExec = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jRadioButtonP5Crescente = new javax.swing.JRadioButton();
        jRadioButtonP5Decrescente = new javax.swing.JRadioButton();
        jRadioButtonP5Random = new javax.swing.JRadioButton();
        jRadioButtonP5FIFO = new javax.swing.JRadioButton();
        jPanelPassoSimples = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListRecurso = new javax.swing.JList();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListTarefa = new javax.swing.JList();
        jPanelPasso6 = new javax.swing.JPanel();
        jSeparatorP6 = new javax.swing.JSeparator();
        jRadioButtonP6SemRestricao = new javax.swing.JRadioButton();
        jRadioButtonP6PorRecurso = new javax.swing.JRadioButton();
        jRadioButtonP6PorUsuario = new javax.swing.JRadioButton();
        jLabelP6_1 = new javax.swing.JLabel();
        jTextFieldP6Num = new javax.swing.JFormattedTextField();
        jLabelP6_2 = new javax.swing.JLabel();
        jPanelPasso7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPaneP7Gramatica = new javax.swing.JTextPane();
        jPanelPassos = new javax.swing.JPanel();
        jLabelPassos = new javax.swing.JLabel();
        jLabelPasso1 = new javax.swing.JLabel();
        jLabelPasso2 = new javax.swing.JLabel();
        jLabelPasso3 = new javax.swing.JLabel();
        jLabelPasso4 = new javax.swing.JLabel();
        jLabelPasso5 = new javax.swing.JLabel();
        jLabelPasso6 = new javax.swing.JLabel();
        jLabelPasso7 = new javax.swing.JLabel();
        jPanelControle = new javax.swing.JPanel();
        jButtonVoltar = new javax.swing.JButton();
        jButtonProximo = new javax.swing.JButton();
        jButtonFinalizar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jScrollPanePrincipal = new javax.swing.JScrollPane();

        jPanelPasso1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)), palavras.getString("Enter the name of the scheduler"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 12))); // NOI18N

        jLabelP1NomeEsc.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jLabelP1NomeEsc.setText(palavras.getString("Scheduler name")); // NOI18N

        jTextFieldP1NomeEsc.setText("NewScheduler");
        jTextFieldP1NomeEsc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldP1NomeEscKeyReleased(evt);
            }
        });

        jLabelP1LocalArq.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jLabelP1LocalArq.setText(palavras.getString("File")); // NOI18N

        jTextFieldP1LocalArq.setEditable(false);
        jTextFieldP1LocalArq.setText(this.caminho + "NewScheduler.java");

        jSeparatorP1.setForeground(new Color(0, 0, 0));

        jLabelP1Informacao.setForeground(new Color(204, 0, 0));

        javax.swing.GroupLayout jPanelPasso1Layout = new javax.swing.GroupLayout(jPanelPasso1);
        jPanelPasso1.setLayout(jPanelPasso1Layout);
        jPanelPasso1Layout.setHorizontalGroup(
            jPanelPasso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPasso1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPasso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelP1NomeEsc)
                    .addComponent(jLabelP1LocalArq))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPasso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldP1LocalArq, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                    .addComponent(jTextFieldP1NomeEsc, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jSeparatorP1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
            .addGroup(jPanelPasso1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelP1Informacao, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelPasso1Layout.setVerticalGroup(
            jPanelPasso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPasso1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPasso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelP1NomeEsc)
                    .addComponent(jTextFieldP1NomeEsc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPasso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelP1LocalArq)
                    .addComponent(jTextFieldP1LocalArq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparatorP1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelP1Informacao, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jPanelPasso2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)), palavras.getString("Enter the characteristics"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 12))); // NOI18N

        jLabelP2Informacao.setText(palavras.getString("Search for information:")); // NOI18N

        jRadioButtonP2Estatica.setSelected(true);
        jRadioButtonP2Estatica.setText(palavras.getString("Static")); // NOI18N
        jRadioButtonP2Estatica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonP2EstaticaActionPerformed(evt);
            }
        });

        jRadioButtonP2Dinamica.setText(palavras.getString("Dynamic")); // NOI18N
        jRadioButtonP2Dinamica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonP2DinamicaActionPerformed(evt);
            }
        });

        jLabelP2Forma.setText(palavras.getString("How to refresh:")); // NOI18N
        jLabelP2Forma.setEnabled(false);

        jRadioButtonP2Tempo.setSelected(true);
        jRadioButtonP2Tempo.setText(palavras.getString("Time interval")); // NOI18N
        jRadioButtonP2Tempo.setToolTipText(palavras.getString("Variables will be refreshed after the passing of specified time")); // NOI18N
        jRadioButtonP2Tempo.setEnabled(false);
        jRadioButtonP2Tempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonP2TempoActionPerformed(evt);
            }
        });

        jRadioButtonP2Chegada.setText(palavras.getString("Task arrival")); // NOI18N
        jRadioButtonP2Chegada.setEnabled(false);
        jRadioButtonP2Chegada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonP2ChegadaActionPerformed(evt);
            }
        });

        jRadioButtonP2Saida.setText(palavras.getString("Task output")); // NOI18N
        jRadioButtonP2Saida.setEnabled(false);
        jRadioButtonP2Saida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonP2SaidaActionPerformed(evt);
            }
        });

        jFormattedTextFieldP2Tempo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jFormattedTextFieldP2Tempo.setText("1");
        jFormattedTextFieldP2Tempo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jFormattedTextFieldP2Tempo.setEnabled(false);

        jLabelP2Topologia.setText(palavras.getString("Topology:")); // NOI18N

        jRadioButtonP2Centralizada.setSelected(true);
        jRadioButtonP2Centralizada.setText(palavras.getString("Centralized")); // NOI18N
        jRadioButtonP2Centralizada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonP2CentralizadaActionPerformed(evt);
            }
        });

        jRadioButtonP2Distribuida.setText(palavras.getString("Distributed")); // NOI18N
        jRadioButtonP2Distribuida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonP2DistribuidaActionPerformed(evt);
            }
        });

        jRadioButtonP2concluida.setText(palavras.getString("Task completed")); // NOI18N
        jRadioButtonP2concluida.setEnabled(false);
        jRadioButtonP2concluida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonP2concluidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPasso2Layout = new javax.swing.GroupLayout(jPanelPasso2);
        jPanelPasso2.setLayout(jPanelPasso2Layout);
        jPanelPasso2Layout.setHorizontalGroup(
            jPanelPasso2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPasso2Layout.createSequentialGroup()
                .addGroup(jPanelPasso2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPasso2Layout.createSequentialGroup()
                        .addGroup(jPanelPasso2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelPasso2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelP2Informacao))
                            .addGroup(jPanelPasso2Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanelPasso2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButtonP2Estatica)
                                    .addComponent(jRadioButtonP2Dinamica)
                                    .addComponent(jRadioButtonP2Tempo)
                                    .addComponent(jRadioButtonP2Chegada)
                                    .addComponent(jRadioButtonP2Saida)
                                    .addComponent(jRadioButtonP2concluida))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGap(81, 81, 81)
                        .addGroup(jPanelPasso2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFormattedTextFieldP2Tempo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelP2Topologia)
                            .addGroup(jPanelPasso2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanelPasso2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButtonP2Distribuida)
                                    .addComponent(jRadioButtonP2Centralizada)))))
                    .addGroup(jPanelPasso2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelP2Forma)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanelPasso2Layout.setVerticalGroup(
            jPanelPasso2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPasso2Layout.createSequentialGroup()
                .addGroup(jPanelPasso2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPasso2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jRadioButtonP2Estatica)
                        .addGap(0, 0, 0)
                        .addComponent(jRadioButtonP2Dinamica))
                    .addGroup(jPanelPasso2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelPasso2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelP2Informacao)
                            .addComponent(jLabelP2Topologia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonP2Centralizada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonP2Distribuida)))
                .addGap(18, 18, 18)
                .addComponent(jLabelP2Forma)
                .addGap(10, 10, 10)
                .addGroup(jPanelPasso2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonP2Tempo)
                    .addComponent(jFormattedTextFieldP2Tempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonP2Chegada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonP2Saida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonP2concluida)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelPasso3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)), palavras.getString("Generator type"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 12))); // NOI18N

        jOpSimples.setSelected(true);
        jOpSimples.setText(palavras.getString("Simple")); // NOI18N
        jOpSimples.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOpSimplesActionPerformed(evt);
            }
        });

        jOpAvancada.setText(palavras.getString("Advanced")); // NOI18N
        jOpAvancada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOpAvancadaActionPerformed(evt);
            }
        });

        jLabel3.setText(palavras.getString("Select a option of scheduler generator:")); // NOI18N

        jLabel4.setText(palavras.getString("This option provides common standards of scheduling policies")); // NOI18N

        jLabel5.setText(palavras.getString("This option allows to create scheduling policies through mathematical formulation")); // NOI18N

        javax.swing.GroupLayout jPanelPasso3Layout = new javax.swing.GroupLayout(jPanelPasso3);
        jPanelPasso3.setLayout(jPanelPasso3Layout);
        jPanelPasso3Layout.setHorizontalGroup(
            jPanelPasso3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPasso3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanelPasso3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jOpSimples)
                    .addComponent(jOpAvancada)
                    .addGroup(jPanelPasso3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel4))
                    .addGroup(jPanelPasso3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel5)))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        jPanelPasso3Layout.setVerticalGroup(
            jPanelPasso3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPasso3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jOpSimples)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jOpAvancada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jPanelPasso4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)), palavras.getString("Advanced") + " - " + palavras.getString("Tasks distribution order"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 12))); // NOI18N
        jPanelPasso4.setPreferredSize(new java.awt.Dimension(600, 350));

        jLabelP4Formula.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jLabelP4Formula.setText(palavras.getString("Formula:")); // NOI18N

        jTextFieldP4Formula.setEditable(false);
        jTextFieldP4Formula.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jTextFieldP4Formula.setText("Random");
        jTextFieldP4Formula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldP4FormulaActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(palavras.getString("Operators and precedence"))); // NOI18N

        jButtonP4Add.setText("+");
        jButtonP4Add.setMaximumSize(new java.awt.Dimension(37, 50));
        jButtonP4Add.setMinimumSize(new java.awt.Dimension(37, 23));
        jButtonP4Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonP4AddActionPerformed(evt);
            }
        });

        jButtonP4Sub.setText("-");
        jButtonP4Sub.setMaximumSize(new java.awt.Dimension(37, 50));
        jButtonP4Sub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonP4SubActionPerformed(evt);
            }
        });

        jButtonP4AbreParent.setText("(");
        jButtonP4AbreParent.setMaximumSize(new java.awt.Dimension(37, 50));
        jButtonP4AbreParent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonP4AbreParentActionPerformed(evt);
            }
        });

        jButtonP4FechaParent.setText(")");
        jButtonP4FechaParent.setMaximumSize(new java.awt.Dimension(37, 50));
        jButtonP4FechaParent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonP4FechaParentActionPerformed(evt);
            }
        });

        jButtonP4Div.setText("/");
        jButtonP4Div.setMaximumSize(new java.awt.Dimension(37, 50));
        jButtonP4Div.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonP4DivActionPerformed(evt);
            }
        });

        jButtonP4Mult.setText("*");
        jButtonP4Mult.setMaximumSize(new java.awt.Dimension(37, 50));
        jButtonP4Mult.setMinimumSize(new java.awt.Dimension(37, 23));
        jButtonP4Mult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonP4MultActionPerformed(evt);
            }
        });

        jButtonP4Voltar.setText("←");
        jButtonP4Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonP4VoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonP4AbreParent, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jButtonP4Add, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jButtonP4Mult, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jButtonP4Div, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jButtonP4Sub, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jButtonP4FechaParent, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonP4Voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonP4Add, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonP4Sub, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonP4Mult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jButtonP4Div, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jButtonP4AbreParent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonP4FechaParent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonP4Voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(palavras.getString("Variables"))); // NOI18N

        jButtonP4TComputacao.setText(palavras.getString("Computational size") + " - TCP"); // NOI18N
        jButtonP4TComputacao.setToolTipText(palavras.getString("Computational size")); // NOI18N
        jButtonP4TComputacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonP4TComputacaoActionPerformed(evt);
            }
        });

        jButtonP4TComunicacao.setText(palavras.getString("Communication size") + " - TC"); // NOI18N
        jButtonP4TComunicacao.setToolTipText(palavras.getString("Communication size")); // NOI18N
        jButtonP4TComunicacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonP4TComunicacaoActionPerformed(evt);
            }
        });

        jButtonP4NTSubmetidas.setText(palavras.getString("Number of submitted tasks") + " - NTS"); // NOI18N
        jButtonP4NTSubmetidas.setToolTipText(palavras.getString("Number of submitted tasks by the user")); // NOI18N
        jButtonP4NTSubmetidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonP4NTSubmetidasActionPerformed(evt);
            }
        });

        jButtonP4NTConcluidas.setText(palavras.getString("Number of completed tasks") + " - NTC"); // NOI18N
        jButtonP4NTConcluidas.setToolTipText("Número de tarefas concluídas do usuário");
        jButtonP4NTConcluidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonP4NTConcluidasActionPerformed(evt);
            }
        });

        jButtonP4PComputUser.setText(palavras.getString("User's computational power") + " - PCU"); // NOI18N
        jButtonP4PComputUser.setToolTipText(palavras.getString("Computational power given by the user to grid")); // NOI18N
        jButtonP4PComputUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonP4PComputUserActionPerformed(evt);
            }
        });

        jButtonP4Const.setText("Const");
        jButtonP4Const.setToolTipText(palavras.getString("Numerical constant")); // NOI18N
        jButtonP4Const.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonP4ConstActionPerformed(evt);
            }
        });

        jFormattedTextP4DigitaConst.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jFormattedTextP4DigitaConst.setText("1");
        jFormattedTextP4DigitaConst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextP4DigitaConstActionPerformed(evt);
            }
        });

        jButtonP4PTempoCriacao.setText(palavras.getString("Task creation time") + " - TCR"); // NOI18N
        jButtonP4PTempoCriacao.setToolTipText(palavras.getString("Task creation time")); // NOI18N
        jButtonP4PTempoCriacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonP4PTempoCriacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonP4TComputacao, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                    .addComponent(jButtonP4TComunicacao, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                    .addComponent(jButtonP4NTSubmetidas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                    .addComponent(jButtonP4PComputUser, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                    .addComponent(jButtonP4NTConcluidas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonP4Const, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextP4DigitaConst, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                    .addComponent(jButtonP4PTempoCriacao, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButtonP4TComputacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonP4TComunicacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonP4NTSubmetidas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonP4NTConcluidas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonP4PComputUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonP4PTempoCriacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonP4Const)
                    .addComponent(jFormattedTextP4DigitaConst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(palavras.getString("Order"))); // NOI18N

        jRadioButtonP4Crescente.setText(palavras.getString("Crescent")); // NOI18N
        jRadioButtonP4Crescente.setToolTipText(palavras.getString("This option schedules by the generated formula in crescent order")); // NOI18N
        jRadioButtonP4Crescente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonP4CrescenteActionPerformed(evt);
            }
        });

        jRadioButtonP4Decrescente.setText(palavras.getString("Decrescent")); // NOI18N
        jRadioButtonP4Decrescente.setToolTipText(palavras.getString("This option schedules by the generated formula in decrescent order")); // NOI18N
        jRadioButtonP4Decrescente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonP4DecrescenteActionPerformed(evt);
            }
        });

        jRadioButtonP4Random.setSelected(true);
        jRadioButtonP4Random.setText(palavras.getString("Random")); // NOI18N
        jRadioButtonP4Random.setToolTipText(palavras.getString("This option schedules randomly")); // NOI18N
        jRadioButtonP4Random.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonP4RandomActionPerformed(evt);
            }
        });

        jRadioButtonP4FIFO.setText("FIFO");
        jRadioButtonP4FIFO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonP4FIFOActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonP4Crescente)
                    .addComponent(jRadioButtonP4Decrescente)
                    .addComponent(jRadioButtonP4Random)
                    .addComponent(jRadioButtonP4FIFO))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButtonP4Crescente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonP4Decrescente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonP4Random)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonP4FIFO)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelPasso4Layout = new javax.swing.GroupLayout(jPanelPasso4);
        jPanelPasso4.setLayout(jPanelPasso4Layout);
        jPanelPasso4Layout.setHorizontalGroup(
            jPanelPasso4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPasso4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPasso4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPasso4Layout.createSequentialGroup()
                        .addComponent(jLabelP4Formula)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldP4Formula, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPasso4Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelPasso4Layout.setVerticalGroup(
            jPanelPasso4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPasso4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPasso4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelP4Formula)
                    .addComponent(jTextFieldP4Formula, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPasso4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanelPasso5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)), palavras.getString("Advanced") + " - " + palavras.getString("Resource aloccation order"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 12))); // NOI18N
        jPanelPasso5.setPreferredSize(new java.awt.Dimension(600, 350));

        jLabelP5Formula.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jLabelP5Formula.setText(palavras.getString("Formula:")); // NOI18N

        jTextFieldP5Formula.setEditable(false);
        jTextFieldP5Formula.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jTextFieldP5Formula.setText("Random");
        jTextFieldP5Formula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldP5FormulaActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(palavras.getString("Operators and precedence"))); // NOI18N

        jButtonP5Add.setText("+");
        jButtonP5Add.setMaximumSize(new java.awt.Dimension(37, 50));
        jButtonP5Add.setMinimumSize(new java.awt.Dimension(37, 23));
        jButtonP5Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonP5AddActionPerformed(evt);
            }
        });

        jButtonP5Sub.setText("-");
        jButtonP5Sub.setMaximumSize(new java.awt.Dimension(37, 50));
        jButtonP5Sub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonP5SubActionPerformed(evt);
            }
        });

        jButtonP5AbreParent.setText("(");
        jButtonP5AbreParent.setMaximumSize(new java.awt.Dimension(37, 50));
        jButtonP5AbreParent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonP5AbreParentActionPerformed(evt);
            }
        });

        jButtonP5FechaParent.setText(")");
        jButtonP5FechaParent.setMaximumSize(new java.awt.Dimension(37, 50));
        jButtonP5FechaParent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonP5FechaParentActionPerformed(evt);
            }
        });

        jButtonP5Div.setText("/");
        jButtonP5Div.setMaximumSize(new java.awt.Dimension(37, 50));
        jButtonP5Div.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonP5DivActionPerformed(evt);
            }
        });

        jButtonP5Mult.setText("*");
        jButtonP5Mult.setMaximumSize(new java.awt.Dimension(37, 50));
        jButtonP5Mult.setMinimumSize(new java.awt.Dimension(37, 23));
        jButtonP5Mult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonP5MultActionPerformed(evt);
            }
        });

        jButtonP5Voltar.setText("←");
        jButtonP5Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonP5VoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonP5AbreParent, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButtonP5Sub, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonP5Add, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                    .addComponent(jButtonP5Mult, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jButtonP5Div, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jButtonP5FechaParent, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonP5Voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButtonP5Voltar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jButtonP5Add, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonP5Sub, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonP5Mult, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonP5Div, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonP5AbreParent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonP5FechaParent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(palavras.getString("Variables"))); // NOI18N

        jButtonP5PProcessamento.setText(palavras.getString("Processing power") + " - PP"); // NOI18N
        jButtonP5PProcessamento.setToolTipText(palavras.getString("Resource processing power")); // NOI18N
        jButtonP5PProcessamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonP5PProcessamentoActionPerformed(evt);
            }
        });

        jButtonP5LinkComunicacao.setText(palavras.getString("Communication link") + " - LC"); // NOI18N
        jButtonP5LinkComunicacao.setToolTipText(palavras.getString("Band of the communication link")); // NOI18N
        jButtonP5LinkComunicacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonP5LinkComunicacaoActionPerformed(evt);
            }
        });

        jButtonP5TCompTarefa.setText(palavras.getString("Task computational size") + " - TCT"); // NOI18N
        jButtonP5TCompTarefa.setToolTipText(palavras.getString("Computational size of the submitted task")); // NOI18N
        jButtonP5TCompTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonP5TCompTarefaActionPerformed(evt);
            }
        });

        jButtonP5NumTExec.setText(palavras.getString("Number of running taks") + " - NTE"); // NOI18N
        jButtonP5NumTExec.setToolTipText(palavras.getString("Number of running tasks in the resource")); // NOI18N
        jButtonP5NumTExec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonP5NumTExecActionPerformed(evt);
            }
        });

        jButtonP5TComunTarefa.setText(palavras.getString("Task communication size") + " - TCMT"); // NOI18N
        jButtonP5TComunTarefa.setToolTipText(palavras.getString("Commnication size of the submmited task")); // NOI18N
        jButtonP5TComunTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonP5TComunTarefaActionPerformed(evt);
            }
        });

        jButtonP5Const1.setText("Const");
        jButtonP5Const1.setToolTipText(palavras.getString("Numerical constant")); // NOI18N
        jButtonP5Const1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonP5Const1ActionPerformed(evt);
            }
        });

        jFormattedTextP5DigitaConst.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jFormattedTextP5DigitaConst.setText("1");
        jFormattedTextP5DigitaConst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextP5DigitaConstActionPerformed(evt);
            }
        });

        jButtonP5MflopExec.setText(palavras.getString("Running Mflops") + " - MFE"); // NOI18N
        jButtonP5MflopExec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonP5MflopExecActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonP5PProcessamento, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                    .addComponent(jButtonP5LinkComunicacao, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                    .addComponent(jButtonP5NumTExec, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                    .addComponent(jButtonP5TCompTarefa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                    .addComponent(jButtonP5TComunTarefa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jButtonP5Const1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextP5DigitaConst, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                    .addComponent(jButtonP5MflopExec, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jButtonP5PProcessamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonP5LinkComunicacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonP5TCompTarefa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonP5TComunTarefa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonP5NumTExec)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonP5MflopExec)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonP5Const1)
                    .addComponent(jFormattedTextP5DigitaConst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(palavras.getString("Order"))); // NOI18N

        jRadioButtonP5Crescente.setText(palavras.getString("Crescent")); // NOI18N
        jRadioButtonP5Crescente.setToolTipText(palavras.getString("This option schedules by the generated formula in crescent order")); // NOI18N
        jRadioButtonP5Crescente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonP5CrescenteActionPerformed(evt);
            }
        });

        jRadioButtonP5Decrescente.setText(palavras.getString("Decrescent")); // NOI18N
        jRadioButtonP5Decrescente.setToolTipText(palavras.getString("This option schedules by the generated formula in decrescent order")); // NOI18N
        jRadioButtonP5Decrescente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonP5DecrescenteActionPerformed(evt);
            }
        });

        jRadioButtonP5Random.setSelected(true);
        jRadioButtonP5Random.setText(palavras.getString("Random")); // NOI18N
        jRadioButtonP5Random.setToolTipText(palavras.getString("This option schedules randomly")); // NOI18N
        jRadioButtonP5Random.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonP5RandomActionPerformed(evt);
            }
        });

        jRadioButtonP5FIFO.setText("FIFO");
        jRadioButtonP5FIFO.setToolTipText("");
        jRadioButtonP5FIFO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonP5FIFOActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonP5Crescente)
                    .addComponent(jRadioButtonP5Random)
                    .addComponent(jRadioButtonP5Decrescente)
                    .addComponent(jRadioButtonP5FIFO))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButtonP5Crescente)
                .addGap(3, 3, 3)
                .addComponent(jRadioButtonP5Decrescente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonP5Random)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonP5FIFO)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelPasso5Layout = new javax.swing.GroupLayout(jPanelPasso5);
        jPanelPasso5.setLayout(jPanelPasso5Layout);
        jPanelPasso5Layout.setHorizontalGroup(
            jPanelPasso5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPasso5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPasso5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPasso5Layout.createSequentialGroup()
                        .addComponent(jLabelP5Formula)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldP5Formula, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPasso5Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelPasso5Layout.setVerticalGroup(
            jPanelPasso5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPasso5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPasso5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelP5Formula)
                    .addComponent(jTextFieldP5Formula, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPasso5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanelPasso5.getAccessibleContext().setAccessibleName("Ordem de alocação de recursos");

        jPanelPassoSimples.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)), palavras.getString("Simple") + " - " + palavras.getString("Scheduling options"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 12))); // NOI18N

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new Color(0, 0, 0), 1, true), palavras.getString("Resource Scheduler"))); // NOI18N

        jListRecurso.setBorder(javax.swing.BorderFactory.createTitledBorder(palavras.getString("Select the policy used:"))); // NOI18N
        jListRecurso.setModel(this.simplesRecurso());
        jListRecurso.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListRecurso.setSelectedIndex(0);
        jScrollPane2.setViewportView(jListRecurso);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new Color(0, 0, 0), 1, true), palavras.getString("Task Scheduler"))); // NOI18N

        jListTarefa.setBorder(javax.swing.BorderFactory.createTitledBorder(palavras.getString("Select the policy used:"))); // NOI18N
        jListTarefa.setModel(simplesTarefa());
        jListTarefa.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListTarefa.setSelectedIndex(0);
        jScrollPane1.setViewportView(jListTarefa);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelPassoSimplesLayout = new javax.swing.GroupLayout(jPanelPassoSimples);
        jPanelPassoSimples.setLayout(jPanelPassoSimplesLayout);
        jPanelPassoSimplesLayout.setHorizontalGroup(
            jPanelPassoSimplesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPassoSimplesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelPassoSimplesLayout.setVerticalGroup(
            jPanelPassoSimplesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPassoSimplesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPassoSimplesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanelPasso6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)), palavras.getString("Restrictions"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 12))); // NOI18N

        jSeparatorP6.setForeground(new Color(0, 0, 0));

        jRadioButtonP6SemRestricao.setSelected(true);
        jRadioButtonP6SemRestricao.setText(palavras.getString("No restrictions")); // NOI18N
        jRadioButtonP6SemRestricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonP6SemRestricaoActionPerformed(evt);
            }
        });

        jRadioButtonP6PorRecurso.setText(palavras.getString("Limit the number of tasks submitted by resource")); // NOI18N
        jRadioButtonP6PorRecurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonP6PorRecursoActionPerformed(evt);
            }
        });

        jRadioButtonP6PorUsuario.setText(palavras.getString("Limit the number of tasks submitted by user")); // NOI18N
        jRadioButtonP6PorUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonP6PorUsuarioActionPerformed(evt);
            }
        });

        jLabelP6_1.setText(palavras.getString("The scheduler stop when there are more than")); // NOI18N
        jLabelP6_1.setEnabled(false);

        jTextFieldP6Num.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        jTextFieldP6Num.setText("1");
        jTextFieldP6Num.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextFieldP6Num.setEnabled(false);

        jLabelP6_2.setText(palavras.getString("tasks in all resources.")); // NOI18N
        jLabelP6_2.setEnabled(false);

        javax.swing.GroupLayout jPanelPasso6Layout = new javax.swing.GroupLayout(jPanelPasso6);
        jPanelPasso6.setLayout(jPanelPasso6Layout);
        jPanelPasso6Layout.setHorizontalGroup(
            jPanelPasso6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPasso6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButtonP6SemRestricao)
                .addContainerGap(359, Short.MAX_VALUE))
            .addGroup(jPanelPasso6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButtonP6PorUsuario)
                .addContainerGap(219, Short.MAX_VALUE))
            .addComponent(jSeparatorP6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
            .addGroup(jPanelPasso6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelP6_1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldP6Num, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelP6_2)
                .addContainerGap(62, Short.MAX_VALUE))
            .addGroup(jPanelPasso6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButtonP6PorRecurso)
                .addContainerGap(199, Short.MAX_VALUE))
        );
        jPanelPasso6Layout.setVerticalGroup(
            jPanelPasso6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPasso6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButtonP6SemRestricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonP6PorRecurso)
                .addGap(4, 4, 4)
                .addComponent(jRadioButtonP6PorUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparatorP6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelPasso6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelP6_1)
                    .addComponent(jTextFieldP6Num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelP6_2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelPasso7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)), palavras.getString("Finish"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 12))); // NOI18N

        jTextPaneP7Gramatica.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jScrollPane3.setViewportView(jTextPaneP7Gramatica);

        javax.swing.GroupLayout jPanelPasso7Layout = new javax.swing.GroupLayout(jPanelPasso7);
        jPanelPasso7.setLayout(jPanelPasso7Layout);
        jPanelPasso7Layout.setHorizontalGroup(
            jPanelPasso7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPasso7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelPasso7Layout.setVerticalGroup(
            jPanelPasso7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPasso7Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(palavras.getString("New Scheduler")); // NOI18N
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("imagens/Logo_iSPD_25.png")));
        setLocation(new java.awt.Point(0, 0));

        jPanelPassos.setBackground(new Color(255, 255, 255));
        jPanelPassos.setBorder(new javax.swing.border.MatteBorder(null));

        jLabelPassos.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabelPassos.setText("<html><b>" + palavras.getString("Steps") + "<br>----------------</b></html>"); // NOI18N

        jLabelPasso1.setText("1 - " + palavras.getString("Enter the name")); // NOI18N

        jLabelPasso2.setText("2 - " + palavras.getString("Characteristics")); // NOI18N
        jLabelPasso2.setEnabled(false);

        jLabelPasso3.setText("3 - " + palavras.getString("Generator type")); // NOI18N
        jLabelPasso3.setEnabled(false);

        jLabelPasso4.setText("4 - " + palavras.getString("Task Scheduler")); // NOI18N
        jLabelPasso4.setEnabled(false);

        jLabelPasso5.setText("5 - " + palavras.getString("Resource Scheduler")); // NOI18N
        jLabelPasso5.setEnabled(false);

        jLabelPasso6.setText("6 - " + palavras.getString("Restrictions")); // NOI18N
        jLabelPasso6.setEnabled(false);

        jLabelPasso7.setText("7 - " + palavras.getString("Finish")); // NOI18N
        jLabelPasso7.setEnabled(false);

        javax.swing.GroupLayout jPanelPassosLayout = new javax.swing.GroupLayout(jPanelPassos);
        jPanelPassos.setLayout(jPanelPassosLayout);
        jPanelPassosLayout.setHorizontalGroup(
            jPanelPassosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPassosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPassosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPassos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelPasso1)
                    .addComponent(jLabelPasso2)
                    .addComponent(jLabelPasso4)
                    .addComponent(jLabelPasso5)
                    .addComponent(jLabelPasso3)
                    .addComponent(jLabelPasso6)
                    .addComponent(jLabelPasso7))
                .addContainerGap())
        );
        jPanelPassosLayout.setVerticalGroup(
            jPanelPassosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPassosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelPassos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelPasso1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelPasso2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelPasso3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelPasso4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelPasso5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelPasso6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelPasso7)
                .addContainerGap(262, Short.MAX_VALUE))
        );

        jPanelControle.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonVoltar.setText("< " + palavras.getString("Back")); // NOI18N
        jButtonVoltar.setEnabled(false);
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jButtonProximo.setText(palavras.getString("Next") + " >"); // NOI18N
        jButtonProximo.setActionCommand(palavras.getString("Next") + " >"); // NOI18N
        jButtonProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProximoActionPerformed(evt);
            }
        });

        jButtonFinalizar.setText(palavras.getString("Finish")); // NOI18N
        jButtonFinalizar.setEnabled(false);
        jButtonFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalizarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText(palavras.getString("Cancel")); // NOI18N
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelControleLayout = new javax.swing.GroupLayout(jPanelControle);
        jPanelControle.setLayout(jPanelControleLayout);
        jPanelControleLayout.setHorizontalGroup(
            jPanelControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelControleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonVoltar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonProximo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonFinalizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCancelar)
                .addContainerGap(380, Short.MAX_VALUE))
        );
        jPanelControleLayout.setVerticalGroup(
            jPanelControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelControleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonVoltar)
                    .addComponent(jButtonProximo)
                    .addComponent(jButtonFinalizar)
                    .addComponent(jButtonCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelPassos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPanePrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
                    .addComponent(jPanelControle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPanePrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelControle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelPassos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldP1NomeEscKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldP1NomeEscKeyReleased
        if (this.jTextFieldP1NomeEsc.getText().equals("")) {
            this.jLabelP1Informacao.setText(palavras.getString("Provide a valid name for a Java class"));
            this.jTextFieldP1LocalArq.setText("");
            this.jButtonProximo.setEnabled(false);
        } else if (ValidaValores.validaNomeClasse(this.jTextFieldP1NomeEsc.getText())) {
            this.jLabelP1Informacao.setText("");
            this.jTextFieldP1LocalArq.setText(this.caminho + "\\" + this.jTextFieldP1NomeEsc.getText() + ".java");
            this.jButtonProximo.setEnabled(true);
        } else {
            this.jLabelP1Informacao.setText(palavras.getString("The class name is invalid"));
            this.jButtonProximo.setEnabled(false);
        }
        File arq = new File(caminho + "\\" + this.jTextFieldP1NomeEsc.getText() + ".java");
        if (arq.exists()) {
            this.jLabelP1Informacao.setText(this.jLabelP1Informacao.getText() + "\n" + palavras.getString("This scheduler name already exists"));
        }
    }//GEN-LAST:event_jTextFieldP1NomeEscKeyReleased

    private void jButtonProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProximoActionPerformed
        switch (this.passoAtual) {
            case 1:
                this.jScrollPanePrincipal.setViewportView(this.jPanelPasso2);
                this.jButtonVoltar.setEnabled(true);
                this.jLabelPasso1.setEnabled(false);
                this.jLabelPasso2.setEnabled(true);
                this.passoAtual = 2;
                break;
            case 2:
                this.jScrollPanePrincipal.setViewportView(this.jPanelPasso3);
                this.jLabelPasso2.setEnabled(false);
                this.jLabelPasso3.setEnabled(true);
                this.passoAtual = 3;
                break;
            case 3:
                this.jLabelPasso3.setEnabled(false);
                if (jOpSimples.isSelected()) {
                    this.jScrollPanePrincipal.setViewportView(this.jPanelPassoSimples);
                    this.jLabelPasso4.setEnabled(true);
                    this.jLabelPasso5.setEnabled(true);
                    passoAtual = 5;
                } else {
                    this.jScrollPanePrincipal.setViewportView(this.jPanelPasso4);
                    this.jLabelPasso4.setEnabled(true);
                    passoAtual = 4;
                }
                break;
            case 4:
                this.jScrollPanePrincipal.setViewportView(this.jPanelPasso5);
                this.jLabelPasso4.setEnabled(false);
                this.jLabelPasso5.setEnabled(true);
                this.passoAtual = 5;
                this.ordenacao_t = ordenacao;
                this.contaParent_t = contaParent;
                this.tipoBotao_t = tipoBotao;
                ordenacao = this.ordenacao_r;
                formula = this.formula_r;
                tipoBotao = this.tipoBotao_r;
                contaParent = this.contaParent_r;
                escreverFormula();
                break;
            case 5:
                this.ordenacao_r = ordenacao;
                this.contaParent_r = contaParent;
                this.tipoBotao_r = tipoBotao;
                this.jScrollPanePrincipal.setViewportView(this.jPanelPasso6);
                this.jLabelPasso4.setEnabled(false);
                this.jLabelPasso5.setEnabled(false);
                this.jLabelPasso6.setEnabled(true);
                this.passoAtual = 6;
                break;
            case 6:
                escreverGramatica();
                this.jScrollPanePrincipal.setViewportView(this.jPanelPasso7);
                this.jLabelPasso6.setEnabled(false);
                this.jLabelPasso7.setEnabled(true);
                this.passoAtual = 7;
                this.jButtonProximo.setEnabled(false);
                this.jButtonFinalizar.setEnabled(true);
                break;
        }
    }//GEN-LAST:event_jButtonProximoActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        switch (this.passoAtual) {
            case 2:
                this.jScrollPanePrincipal.setViewportView(this.jPanelPasso1);
                this.jButtonVoltar.setEnabled(false);
                this.jLabelPasso1.setEnabled(true);
                this.jLabelPasso2.setEnabled(false);
                this.passoAtual = 1;
                break;
            case 3:
                this.jScrollPanePrincipal.setViewportView(this.jPanelPasso2);
                this.jLabelPasso2.setEnabled(true);
                this.jLabelPasso3.setEnabled(false);
                this.passoAtual = 2;
                break;
            case 4:
                this.jScrollPanePrincipal.setViewportView(this.jPanelPasso3);
                this.jLabelPasso3.setEnabled(true);
                this.jLabelPasso4.setEnabled(false);
                this.passoAtual = 3;
                break;
            case 5:
                this.jLabelPasso5.setEnabled(false);
                if (jOpSimples.isSelected()) {
                    this.jScrollPanePrincipal.setViewportView(this.jPanelPasso3);
                    this.jLabelPasso4.setEnabled(false);
                    this.jLabelPasso3.setEnabled(true);
                    passoAtual = 3;
                } else {
                    this.jScrollPanePrincipal.setViewportView(this.jPanelPasso4);
                    this.jLabelPasso4.setEnabled(true);
                    passoAtual = 4;
                }
                this.ordenacao_r = ordenacao;
                //this.formula_r.remove();
                //this.formula_r.addAll(formula);
                this.contaParent_r = contaParent;
                this.tipoBotao_r = tipoBotao;
                ordenacao = this.ordenacao_t;
                formula = this.formula_t;
                tipoBotao = this.tipoBotao_t;
                contaParent = this.contaParent_t;
                escreverFormula();
                break;
            case 6:
                this.jLabelPasso6.setEnabled(false);
                this.jLabelPasso5.setEnabled(true);
                if (jOpSimples.isSelected()) {
                    this.jScrollPanePrincipal.setViewportView(this.jPanelPassoSimples);
                    this.jLabelPasso4.setEnabled(true);
                } else {
                    this.jScrollPanePrincipal.setViewportView(this.jPanelPasso5);
                }
                this.passoAtual = 5;
                break;
            case 7:
                this.jLabelPasso7.setEnabled(false);
                this.jLabelPasso6.setEnabled(true);
                this.jScrollPanePrincipal.setViewportView(this.jPanelPasso6);
                this.jButtonProximo.setEnabled(true);
                this.jButtonFinalizar.setEnabled(false);
                this.passoAtual = 6;
                break;
        }
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jRadioButtonP4RandomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonP4RandomActionPerformed
        this.jRadioButtonP4FIFO.setSelected(false);
        this.jRadioButtonP4Random.setSelected(true);
        this.jRadioButtonP4Crescente.setSelected(false);
        this.jRadioButtonP4Decrescente.setSelected(false);
        this.ordenacao = "Random";
        escreverFormula();
    }//GEN-LAST:event_jRadioButtonP4RandomActionPerformed

    private void jRadioButtonP4DecrescenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonP4DecrescenteActionPerformed
        this.jRadioButtonP4FIFO.setSelected(false);
        this.jRadioButtonP4Random.setSelected(false);
        this.jRadioButtonP4Crescente.setSelected(false);
        this.jRadioButtonP4Decrescente.setSelected(true);
        this.ordenacao = "Decrescente";
        escreverFormula();
    }//GEN-LAST:event_jRadioButtonP4DecrescenteActionPerformed

    private void jRadioButtonP4CrescenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonP4CrescenteActionPerformed
        this.jRadioButtonP4FIFO.setSelected(false);
        this.jRadioButtonP4Random.setSelected(false);
        this.jRadioButtonP4Crescente.setSelected(true);
        this.jRadioButtonP4Decrescente.setSelected(false);
        this.ordenacao = "Crescente";
        escreverFormula();
    }//GEN-LAST:event_jRadioButtonP4CrescenteActionPerformed

    private void jButtonP4TComputacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonP4TComputacaoActionPerformed
        // TODO add your handling code here:
        pressionarVariavel("[TCP]");
    }//GEN-LAST:event_jButtonP4TComputacaoActionPerformed

    private void jButtonP4AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonP4AddActionPerformed
        // TODO add your handling code here:
        pressionarOperador("+");
    }//GEN-LAST:event_jButtonP4AddActionPerformed

    private void jButtonP4VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonP4VoltarActionPerformed
        // TODO add your handling code here:
        String operador = "+ - / * ";
        if (!formula.isEmpty()) {
            if (this.tipoBotao == ABRE_CHAVE) {
                this.contaParent--;
            } else if (this.tipoBotao == FECHA_CHAVE) {
                this.contaParent++;
            }
            this.formula.removeLast();
            if (formula.isEmpty()) {
                this.tipoBotao = INICIAL;
                this.contaParent = 0;
            } else if (operador.contains(formula.getLast())) {
                this.tipoBotao = OPERADOR;
            } else if (formula.getLast().contains("(")) {
                this.tipoBotao = ABRE_CHAVE;
            } else if (formula.getLast().contains(")")) {
                this.tipoBotao = FECHA_CHAVE;
            } else {
                this.tipoBotao = VARIAVEL;
            }
        } else {
            this.tipoBotao = INICIAL;
            this.contaParent = 0;
        }
        escreverFormula();
    }//GEN-LAST:event_jButtonP4VoltarActionPerformed

    private void jButtonP4NTSubmetidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonP4NTSubmetidasActionPerformed
        // TODO add your handling code here:
        pressionarVariavel("[NTS]");
    }//GEN-LAST:event_jButtonP4NTSubmetidasActionPerformed

    private void jButtonP4NTConcluidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonP4NTConcluidasActionPerformed
        // TODO add your handling code here:
        pressionarVariavel("[NTC]");
    }//GEN-LAST:event_jButtonP4NTConcluidasActionPerformed

    private void jButtonP4TComunicacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonP4TComunicacaoActionPerformed
        // TODO add your handling code here:
        pressionarVariavel("[TC]");
    }//GEN-LAST:event_jButtonP4TComunicacaoActionPerformed

    private void jButtonP4PComputUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonP4PComputUserActionPerformed
        // TODO add your handling code here:
        pressionarVariavel("[PCU]");
    }//GEN-LAST:event_jButtonP4PComputUserActionPerformed

    private void jButtonP4SubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonP4SubActionPerformed
        // TODO add your handling code here:
        pressionarOperador("-");
    }//GEN-LAST:event_jButtonP4SubActionPerformed

    private void jButtonP4MultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonP4MultActionPerformed
        // TODO add your handling code here:
        pressionarOperador("*");
    }//GEN-LAST:event_jButtonP4MultActionPerformed

    private void jButtonP4DivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonP4DivActionPerformed
        // TODO add your handling code here:
        pressionarOperador("/");
    }//GEN-LAST:event_jButtonP4DivActionPerformed

    private void jButtonP4AbreParentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonP4AbreParentActionPerformed
        // TODO add your handling code here:
        if (tipoBotao == INICIAL || tipoBotao == OPERADOR || tipoBotao == ABRE_CHAVE) {
            this.contaParent++;
            this.tipoBotao = ABRE_CHAVE;
            this.formula.add("(");
        }
        escreverFormula();
    }//GEN-LAST:event_jButtonP4AbreParentActionPerformed

    private void jButtonP4FechaParentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonP4FechaParentActionPerformed
        // TODO add your handling code here:
        if (contaParent != 0 && (tipoBotao == VARIAVEL || tipoBotao == FECHA_CHAVE)) {
            this.contaParent--;
            this.tipoBotao = FECHA_CHAVE;
            this.formula.add(")");
        }
        escreverFormula();
    }//GEN-LAST:event_jButtonP4FechaParentActionPerformed

private void jButtonP4ConstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonP4ConstActionPerformed
// TODO add your handling code here:
    pressionarVariavel("[" + this.jFormattedTextP4DigitaConst.getText() + "]");
}//GEN-LAST:event_jButtonP4ConstActionPerformed

private void jButtonP5AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonP5AddActionPerformed
// TODO add your handling code here:
    pressionarOperador("+");
}//GEN-LAST:event_jButtonP5AddActionPerformed

private void jButtonP5SubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonP5SubActionPerformed
// TODO add your handling code here:
    pressionarOperador("-");
}//GEN-LAST:event_jButtonP5SubActionPerformed

private void jButtonP5AbreParentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonP5AbreParentActionPerformed
    // TODO add your handling code here:
    jButtonP4AbreParentActionPerformed(evt);
}//GEN-LAST:event_jButtonP5AbreParentActionPerformed

private void jButtonP5FechaParentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonP5FechaParentActionPerformed
    // TODO add your handling code here:
    jButtonP4FechaParentActionPerformed(evt);
}//GEN-LAST:event_jButtonP5FechaParentActionPerformed

private void jButtonP5DivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonP5DivActionPerformed
// TODO add your handling code here:
    pressionarOperador("/");
}//GEN-LAST:event_jButtonP5DivActionPerformed

private void jButtonP5MultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonP5MultActionPerformed
// TODO add your handling code here:
    pressionarOperador("*");
}//GEN-LAST:event_jButtonP5MultActionPerformed

private void jButtonP5PProcessamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonP5PProcessamentoActionPerformed
// TODO add your handling code here:
    pressionarVariavel("[PP]");
}//GEN-LAST:event_jButtonP5PProcessamentoActionPerformed

private void jButtonP5LinkComunicacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonP5LinkComunicacaoActionPerformed
// TODO add your handling code here:
    pressionarVariavel("[LC]");
}//GEN-LAST:event_jButtonP5LinkComunicacaoActionPerformed

private void jButtonP5TCompTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonP5TCompTarefaActionPerformed
// TODO add your handling code here:
    pressionarVariavel("[TCT]");
}//GEN-LAST:event_jButtonP5TCompTarefaActionPerformed

private void jButtonP5NumTExecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonP5NumTExecActionPerformed
// TODO add your handling code here:
    pressionarVariavel("[NTE]");
}//GEN-LAST:event_jButtonP5NumTExecActionPerformed

private void jButtonP5TComunTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonP5TComunTarefaActionPerformed
// TODO add your handling code here:
    pressionarVariavel("[TCMT]");
}//GEN-LAST:event_jButtonP5TComunTarefaActionPerformed

private void jButtonP5Const1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonP5Const1ActionPerformed
// TODO add your handling code here:
    pressionarVariavel("[" + this.jFormattedTextP5DigitaConst.getText() + "]");
}//GEN-LAST:event_jButtonP5Const1ActionPerformed

private void jRadioButtonP5CrescenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonP5CrescenteActionPerformed
    // TODO add your handling code here:
    this.jRadioButtonP5FIFO.setSelected(false);
    this.jRadioButtonP5Random.setSelected(false);
    this.jRadioButtonP5Crescente.setSelected(true);
    this.jRadioButtonP5Decrescente.setSelected(false);
    this.ordenacao = "Crescente";
    escreverFormula();
}//GEN-LAST:event_jRadioButtonP5CrescenteActionPerformed

private void jRadioButtonP5DecrescenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonP5DecrescenteActionPerformed
    // TODO add your handling code here:
    this.jRadioButtonP5FIFO.setSelected(false);
    this.jRadioButtonP5Random.setSelected(false);
    this.jRadioButtonP5Crescente.setSelected(false);
    this.jRadioButtonP5Decrescente.setSelected(true);
    this.ordenacao = "Decrescente";
    escreverFormula();
}//GEN-LAST:event_jRadioButtonP5DecrescenteActionPerformed

private void jRadioButtonP5RandomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonP5RandomActionPerformed
    // TODO add your handling code here:
    this.jRadioButtonP5FIFO.setSelected(false);
    this.jRadioButtonP5Random.setSelected(true);
    this.jRadioButtonP5Crescente.setSelected(false);
    this.jRadioButtonP5Decrescente.setSelected(false);
    this.ordenacao = "Random";
    escreverFormula();
}//GEN-LAST:event_jRadioButtonP5RandomActionPerformed

private void jTextFieldP5FormulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldP5FormulaActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jTextFieldP5FormulaActionPerformed

private void jTextFieldP4FormulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldP4FormulaActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jTextFieldP4FormulaActionPerformed

private void jFormattedTextP5DigitaConstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextP5DigitaConstActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jFormattedTextP5DigitaConstActionPerformed

private void jFormattedTextP4DigitaConstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextP4DigitaConstActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jFormattedTextP4DigitaConstActionPerformed

private void jOpSimplesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOpSimplesActionPerformed
    if (this.jOpSimples.isSelected()) {
        this.jOpAvancada.setSelected(false);
        this.jOpSimples.setSelected(true);
    } else {
        this.jOpAvancada.setSelected(true);
        this.jOpSimples.setSelected(false);
    }
}//GEN-LAST:event_jOpSimplesActionPerformed

private void jOpAvancadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOpAvancadaActionPerformed
// TODO add your handling code here:
    if (this.jOpAvancada.isSelected()) {
        this.jOpSimples.setSelected(false);
        this.jOpAvancada.setSelected(true);
    } else {
        this.jOpAvancada.setSelected(false);
        this.jOpSimples.setSelected(true);
    }
}//GEN-LAST:event_jOpAvancadaActionPerformed

    private void jRadioButtonP2EstaticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonP2EstaticaActionPerformed
        // TODO add your handling code here:
        jRadioButtonP2Estatica.setSelected(true);
        jRadioButtonP2Dinamica.setSelected(false);
        setEnableDinamica(false);
    }//GEN-LAST:event_jRadioButtonP2EstaticaActionPerformed

    private void jRadioButtonP2DinamicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonP2DinamicaActionPerformed
        // TODO add your handling code here:
        jRadioButtonP2Estatica.setSelected(false);
        jRadioButtonP2Dinamica.setSelected(true);
        setEnableDinamica(true);
    }//GEN-LAST:event_jRadioButtonP2DinamicaActionPerformed

    private void jRadioButtonP2TempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonP2TempoActionPerformed
        jRadioButtonP2Tempo.setSelected(true);
        jRadioButtonP2Chegada.setSelected(false);
        jRadioButtonP2Saida.setSelected(false);
        jRadioButtonP2concluida.setSelected(false);
    }//GEN-LAST:event_jRadioButtonP2TempoActionPerformed

    private void jRadioButtonP2ChegadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonP2ChegadaActionPerformed
        jRadioButtonP2Tempo.setSelected(false);
        jRadioButtonP2Chegada.setSelected(true);
        jRadioButtonP2Saida.setSelected(false);
        jRadioButtonP2concluida.setSelected(false);
    }//GEN-LAST:event_jRadioButtonP2ChegadaActionPerformed

    private void jRadioButtonP2SaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonP2SaidaActionPerformed
        jRadioButtonP2Tempo.setSelected(false);
        jRadioButtonP2Chegada.setSelected(false);
        jRadioButtonP2Saida.setSelected(true);
        jRadioButtonP2concluida.setSelected(false);
    }//GEN-LAST:event_jRadioButtonP2SaidaActionPerformed

    private void jRadioButtonP2CentralizadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonP2CentralizadaActionPerformed
        // TODO add your handling code here:
        jRadioButtonP2Centralizada.setSelected(true);
        jRadioButtonP2Distribuida.setSelected(false);
    }//GEN-LAST:event_jRadioButtonP2CentralizadaActionPerformed

    private void jRadioButtonP2DistribuidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonP2DistribuidaActionPerformed
        // TODO add your handling code here:
        jRadioButtonP2Centralizada.setSelected(false);
        jRadioButtonP2Distribuida.setSelected(true);
    }//GEN-LAST:event_jRadioButtonP2DistribuidaActionPerformed

    private void jButtonP5VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonP5VoltarActionPerformed
        // TODO add your handling code here:
        jButtonP4VoltarActionPerformed(evt);
    }//GEN-LAST:event_jButtonP5VoltarActionPerformed

    private void jButtonFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarActionPerformed
        // TODO add your handling code here:
        String codigo = jTextPaneP7Gramatica.getText();
        parse = new InterpretadorGerador(codigo);
        if (tipoModelo == GRID) {
            if (!parse.executarParse()) {
                if (arquivosEscalonadores != null) {
                    arquivosEscalonadores.escrever(parse.getNome(), parse.getCodigo());
                    String result = arquivosEscalonadores.compilar(parse.getNome());
                    if (result != null) {
                        JOptionPane.showMessageDialog(this, result, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    if (arquivosEscalonadores.listar().contains(parse.getNome())) {
                        this.dispose();
                    } else {
                        parse = null;
                    }
                } else {
                    this.dispose();
                }
            }
        }
        else if (tipoModelo == IAAS){
            if (!parse.executarParse()) {
                if (arquivosEscalonadoresCloud != null) {
                    arquivosEscalonadoresCloud.escrever(parse.getNome(), parse.getCodigo());
                    String result = arquivosEscalonadoresCloud.compilar(parse.getNome());
                    if (result != null) {
                        JOptionPane.showMessageDialog(this, result, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    if (arquivosEscalonadoresCloud.listar().contains(parse.getNome())) {
                        this.dispose();
                    } else {
                        parse = null;
                    }
                } else {
                    this.dispose();
                }
            }
        }
        else if (tipoModelo == ALLOC) {
            if (!parse.executarParse()) {
                if (arquivosAlocadores != null) {
                    arquivosAlocadores.escrever(parse.getNome(), parse.getCodigo());
                    String result = arquivosAlocadores.compilar(parse.getNome());
                    if (result != null) {
                        JOptionPane.showMessageDialog(this, result, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    if (arquivosAlocadores.listar().contains(parse.getNome())) {
                        this.dispose();
                    } else {
                        parse = null;
                    }
                } else {
                    this.dispose();
                }
            }
        }
    }//GEN-LAST:event_jButtonFinalizarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonP5MflopExecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonP5MflopExecActionPerformed
        pressionarVariavel("[MFE]");
    }//GEN-LAST:event_jButtonP5MflopExecActionPerformed

    private void jButtonP4PTempoCriacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonP4PTempoCriacaoActionPerformed
        pressionarVariavel("[TCR]");
    }//GEN-LAST:event_jButtonP4PTempoCriacaoActionPerformed

    private void jRadioButtonP2concluidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonP2concluidaActionPerformed
        jRadioButtonP2Tempo.setSelected(false);
        jRadioButtonP2Chegada.setSelected(false);
        jRadioButtonP2Saida.setSelected(false);
        jRadioButtonP2concluida.setSelected(true);
    }//GEN-LAST:event_jRadioButtonP2concluidaActionPerformed

    private void jRadioButtonP4FIFOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonP4FIFOActionPerformed
        // TODO add your handling code here:
        this.jRadioButtonP4FIFO.setSelected(true);
        this.jRadioButtonP4Random.setSelected(false);
        this.jRadioButtonP4Crescente.setSelected(false);
        this.jRadioButtonP4Decrescente.setSelected(false);
        this.ordenacao = "FIFO";
        escreverFormula();
    }//GEN-LAST:event_jRadioButtonP4FIFOActionPerformed

    private void jRadioButtonP5FIFOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonP5FIFOActionPerformed
        // TODO add your handling code here:
        this.jRadioButtonP5FIFO.setSelected(true);
        this.jRadioButtonP5Random.setSelected(false);
        this.jRadioButtonP5Crescente.setSelected(false);
        this.jRadioButtonP5Decrescente.setSelected(false);
        this.ordenacao = "FIFO";
        escreverFormula();
    }//GEN-LAST:event_jRadioButtonP5FIFOActionPerformed

    private void jRadioButtonP6SemRestricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonP6SemRestricaoActionPerformed
        jRadioButtonP6SemRestricao.setSelected(true);
        jRadioButtonP6PorRecurso.setSelected(false);
        jRadioButtonP6PorUsuario.setSelected(false);
        jLabelP6_1.setEnabled(false);
        jTextFieldP6Num.setEnabled(false);
        jLabelP6_2.setEnabled(false);
    }//GEN-LAST:event_jRadioButtonP6SemRestricaoActionPerformed

    private void jRadioButtonP6PorRecursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonP6PorRecursoActionPerformed
        jRadioButtonP6SemRestricao.setSelected(false);
        jRadioButtonP6PorRecurso.setSelected(true);
        jRadioButtonP6PorUsuario.setSelected(false);
        jLabelP6_1.setEnabled(true);
        jTextFieldP6Num.setEnabled(true);
        jLabelP6_2.setEnabled(true);
        jLabelP6_2.setText(palavras.getString("tasks in all resources."));
    }//GEN-LAST:event_jRadioButtonP6PorRecursoActionPerformed

    private void jRadioButtonP6PorUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonP6PorUsuarioActionPerformed
        jRadioButtonP6SemRestricao.setSelected(false);
        jRadioButtonP6PorRecurso.setSelected(false);
        jRadioButtonP6PorUsuario.setSelected(true);
        jLabelP6_1.setEnabled(true);
        jTextFieldP6Num.setEnabled(true);
        jLabelP6_2.setEnabled(true);
        jLabelP6_2.setText(palavras.getString("tasks by all user."));
    }//GEN-LAST:event_jRadioButtonP6PorUsuarioActionPerformed

    private void setEnableDinamica(boolean b) {
        jLabelP2Forma.setEnabled(b);
        jRadioButtonP2Tempo.setEnabled(b);
        jRadioButtonP2Chegada.setEnabled(b);
        jRadioButtonP2Saida.setEnabled(b);
        jRadioButtonP2concluida.setEnabled(b);
        jFormattedTextFieldP2Tempo.setEnabled(b);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonFinalizar;
    private javax.swing.JButton jButtonP4AbreParent;
    private javax.swing.JButton jButtonP4Add;
    private javax.swing.JButton jButtonP4Const;
    private javax.swing.JButton jButtonP4Div;
    private javax.swing.JButton jButtonP4FechaParent;
    private javax.swing.JButton jButtonP4Mult;
    private javax.swing.JButton jButtonP4NTConcluidas;
    private javax.swing.JButton jButtonP4NTSubmetidas;
    private javax.swing.JButton jButtonP4PComputUser;
    private javax.swing.JButton jButtonP4PTempoCriacao;
    private javax.swing.JButton jButtonP4Sub;
    private javax.swing.JButton jButtonP4TComputacao;
    private javax.swing.JButton jButtonP4TComunicacao;
    private javax.swing.JButton jButtonP4Voltar;
    private javax.swing.JButton jButtonP5AbreParent;
    private javax.swing.JButton jButtonP5Add;
    private javax.swing.JButton jButtonP5Const1;
    private javax.swing.JButton jButtonP5Div;
    private javax.swing.JButton jButtonP5FechaParent;
    private javax.swing.JButton jButtonP5LinkComunicacao;
    private javax.swing.JButton jButtonP5MflopExec;
    private javax.swing.JButton jButtonP5Mult;
    private javax.swing.JButton jButtonP5NumTExec;
    private javax.swing.JButton jButtonP5PProcessamento;
    private javax.swing.JButton jButtonP5Sub;
    private javax.swing.JButton jButtonP5TCompTarefa;
    private javax.swing.JButton jButtonP5TComunTarefa;
    private javax.swing.JButton jButtonP5Voltar;
    private javax.swing.JButton jButtonProximo;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JFormattedTextField jFormattedTextFieldP2Tempo;
    private javax.swing.JFormattedTextField jFormattedTextP4DigitaConst;
    private javax.swing.JFormattedTextField jFormattedTextP5DigitaConst;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelP1Informacao;
    private javax.swing.JLabel jLabelP1LocalArq;
    private javax.swing.JLabel jLabelP1NomeEsc;
    private javax.swing.JLabel jLabelP2Forma;
    private javax.swing.JLabel jLabelP2Informacao;
    private javax.swing.JLabel jLabelP2Topologia;
    private javax.swing.JLabel jLabelP4Formula;
    private javax.swing.JLabel jLabelP5Formula;
    private javax.swing.JLabel jLabelP6_1;
    private javax.swing.JLabel jLabelP6_2;
    private javax.swing.JLabel jLabelPasso1;
    private javax.swing.JLabel jLabelPasso2;
    private javax.swing.JLabel jLabelPasso3;
    private javax.swing.JLabel jLabelPasso4;
    private javax.swing.JLabel jLabelPasso5;
    private javax.swing.JLabel jLabelPasso6;
    private javax.swing.JLabel jLabelPasso7;
    private javax.swing.JLabel jLabelPassos;
    private javax.swing.JList jListRecurso;
    private javax.swing.JList jListTarefa;
    private javax.swing.JRadioButton jOpAvancada;
    private javax.swing.JRadioButton jOpSimples;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanelControle;
    private javax.swing.JPanel jPanelPasso1;
    private javax.swing.JPanel jPanelPasso2;
    private javax.swing.JPanel jPanelPasso3;
    private javax.swing.JPanel jPanelPasso4;
    private javax.swing.JPanel jPanelPasso5;
    private javax.swing.JPanel jPanelPasso6;
    private javax.swing.JPanel jPanelPasso7;
    private javax.swing.JPanel jPanelPassoSimples;
    private javax.swing.JPanel jPanelPassos;
    private javax.swing.JRadioButton jRadioButtonP2Centralizada;
    private javax.swing.JRadioButton jRadioButtonP2Chegada;
    private javax.swing.JRadioButton jRadioButtonP2Dinamica;
    private javax.swing.JRadioButton jRadioButtonP2Distribuida;
    private javax.swing.JRadioButton jRadioButtonP2Estatica;
    private javax.swing.JRadioButton jRadioButtonP2Saida;
    private javax.swing.JRadioButton jRadioButtonP2Tempo;
    private javax.swing.JRadioButton jRadioButtonP2concluida;
    private javax.swing.JRadioButton jRadioButtonP4Crescente;
    private javax.swing.JRadioButton jRadioButtonP4Decrescente;
    private javax.swing.JRadioButton jRadioButtonP4FIFO;
    private javax.swing.JRadioButton jRadioButtonP4Random;
    private javax.swing.JRadioButton jRadioButtonP5Crescente;
    private javax.swing.JRadioButton jRadioButtonP5Decrescente;
    private javax.swing.JRadioButton jRadioButtonP5FIFO;
    private javax.swing.JRadioButton jRadioButtonP5Random;
    private javax.swing.JRadioButton jRadioButtonP6PorRecurso;
    private javax.swing.JRadioButton jRadioButtonP6PorUsuario;
    private javax.swing.JRadioButton jRadioButtonP6SemRestricao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPanePrincipal;
    private javax.swing.JSeparator jSeparatorP1;
    private javax.swing.JSeparator jSeparatorP6;
    private javax.swing.JTextField jTextFieldP1LocalArq;
    private javax.swing.JTextField jTextFieldP1NomeEsc;
    private javax.swing.JTextField jTextFieldP4Formula;
    private javax.swing.JTextField jTextFieldP5Formula;
    private javax.swing.JFormattedTextField jTextFieldP6Num;
    private javax.swing.JTextPane jTextPaneP7Gramatica;
    // End of variables declaration//GEN-END:variables

    private void escreverFormula() {
        if (this.ordenacao.equals("Random") || this.ordenacao.equals("FIFO")) {
            this.jTextFieldP4Formula.setText(this.ordenacao);
            this.jTextFieldP5Formula.setText(this.ordenacao);
        } else {
            this.jTextFieldP4Formula.setText(this.ordenacao + "( " + this.formula + ")");
            this.jTextFieldP5Formula.setText(this.ordenacao + "( " + this.formula + ")");
        }
    }

    private void pressionarOperador(String token) {
        if (tipoBotao == VARIAVEL || tipoBotao == FECHA_CHAVE) {
            this.tipoBotao = OPERADOR;
            formula.add(token);
        } else if (tipoBotao == OPERADOR) {
            formula.set(formula.size() - 1, token);
        }
        escreverFormula();
    }

    private void pressionarVariavel(String token) {
        if (tipoBotao == INICIAL || tipoBotao == OPERADOR || tipoBotao == ABRE_CHAVE) {
            this.tipoBotao = VARIAVEL;
            formula.add(token);
        } else if (tipoBotao == VARIAVEL) {
            formula.set(formula.size() - 1, token);
        }
        escreverFormula();
    }

    private void escreverGramatica() {
        this.jTextPaneP7Gramatica.setText("");
        print("SCHEDULER ", Color.blue);
        println(jTextFieldP1NomeEsc.getText());
        if (!jRadioButtonP6SemRestricao.isSelected()) {
            print("RESTRICT ", Color.blue);
            print(this.jTextFieldP6Num.getText(), Color.green);
            if (jRadioButtonP6PorRecurso.isSelected()) {
                println(" TASKPER RESOURCE", Color.blue);
            } else {
                println(" TASKPER USER", Color.blue);
            }
        }
        if (this.jRadioButtonP2Estatica.isSelected()) {
            println("STATIC", Color.blue);
        } else {
            print("DYNAMIC ", Color.blue);
            if (this.jRadioButtonP2Chegada.isSelected()) {
                println("TASK ENTRY", Color.blue);
            } else if (this.jRadioButtonP2Saida.isSelected()) {
                println("TASK DISPACTH", Color.blue);
            } else if (this.jRadioButtonP2concluida.isSelected()) {
                println("TASK COMPLETED", Color.blue);
            } else {
                print("TIME INTERVAL ", Color.blue);
                println(this.jFormattedTextFieldP2Tempo.getText(), Color.green);
            }
        }
        print("TASK SCHEDULER: ", Color.blue);
        if (jOpSimples.isSelected()) {
            switch (jListTarefa.getSelectedIndex()) {
                case 0:
                    println("FIFO", Color.blue);
                    break;
                case 1:
                    print("DECREASING", Color.blue);
                    println(" ( [TCP] )");
                    break;
                case 2:
                    print("CRESCENT", Color.blue);
                    println(" ( [TCP] )");
                    break;
                case 3:
                    print("DECREASING", Color.blue);
                    println(" ( [TC] )");
                    break;
                case 4:
                    print("CRESCENT", Color.blue);
                    println(" ( [TC] )");
                    break;
                case 5:
                    print("CRESCENT", Color.blue);
                    println(" ( [NTS] - [NTC] )");
                    break;
            }
        } else {
            if (this.ordenacao_t.equals("Random")) {
                println("RANDOM", Color.blue);
            } else if (this.ordenacao_t.equals("FIFO")) {
                println("FIFO", Color.blue);
            } else if (this.ordenacao_t.equals("Crescente")) {
                print("CRESCENT", Color.blue);
                print(" ( ");
                print(this.formula_t.toString());
                println(")");
            } else {
                print("DECREASING", Color.blue);
                print(" ( ");
                print(this.formula_t.toString());
                println(")");
            }
        }
        print("RESOURCE SCHEDULER: ", Color.blue);
        if (jOpSimples.isSelected()) {
            switch (jListRecurso.getSelectedIndex()) {
                case 0:
                    println("FIFO", Color.blue);
                    break;
                case 1:
                    print("DECREASING", Color.blue);
                    println(" ( [PP] - [MFE] )");
                    break;
                case 2:
                    print("CRESCENT", Color.blue);
                    println(" ( [MFE] )");
                    break;
                case 3:
                    print("DECREASING", Color.blue);
                    println(" ( [LC] / ( [NTE] + [1] ) )");
                    break;
            }
        } else {
            if (this.ordenacao_r.equals("Random")) {
                println("RANDOM", Color.blue);
            } else if (this.ordenacao_r.equals("FIFO")) {
                println("FIFO", Color.blue);
            } else if (this.ordenacao_r.equals("Crescente")) {
                print("CRESCENT", Color.blue);
                print(" ( ");
                print(this.formula_r.toString());
                println(")");
            } else {
                print("DECREASING", Color.blue);
                print(" ( ");
                print(this.formula_r.toString());
                println(")");
            }
        }
    }

    public void println(String text, Color cor) {
        this.print(text, cor);
        this.print("\n", cor);
    }

    public void println(String text) {
        this.print(text, Color.black);
        this.print("\n", Color.black);
    }

    public void print(String text) {
        this.print(text, Color.black);
    }

    public void print(String text, Color cor) {
        SimpleAttributeSet configuraCor = new SimpleAttributeSet();
        Document doc = jTextPaneP7Gramatica.getDocument();
        try {
            if (cor != null) {
                StyleConstants.setForeground(configuraCor, cor);
            } else {
                StyleConstants.setForeground(configuraCor, Color.black);
            }
            //if(palavras.containsKey(text)){
            //    doc.insertString(doc.getLength(), palavras.getString(text), configuraCor);
            //}else{
            doc.insertString(doc.getLength(), text, configuraCor);
            //}
        } catch (BadLocationException ex) {
            Logger.getLogger(JSimulacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void setEscalonadores(ManipularArquivos escalonadores) {
        arquivosEscalonadores = escalonadores;
        tipoModelo = GRID;

    }

    void setEscalonadoresCloud(ManipularArquivosCloud escalonadores) {
        arquivosEscalonadoresCloud = escalonadores;
        tipoModelo = IAAS;
        
    }
    
    void setAlocadores(ManipularArquivosAlloc alocadores) {
        arquivosAlocadores = alocadores;
        tipoModelo = ALLOC;
        
     
    }

    public InterpretadorGerador getParse() {
        return parse;
    }

    private javax.swing.AbstractListModel simplesRecurso() {
        return new javax.swing.AbstractListModel() {

            String[] strings = {palavras.getString("Round-Robin (circular queue)"),
                palavras.getString("The most computational power resource"),
                palavras.getString("Resource with less workload"),
                palavras.getString("Resource with better communication link")};

            public int getSize() {
                return strings.length;
            }

            public Object getElementAt(int i) {
                return strings[i];
            }
        };
    }

    private javax.swing.AbstractListModel simplesTarefa() {
        return new javax.swing.AbstractListModel() {

            String[] strings = {palavras.getString("FIFO (First In, First Out)"),
                palavras.getString("Largest Task First") + " " + palavras.getString("(Cost of Processing)"),
                palavras.getString("Lowest Task First") + " " + palavras.getString("(Cost of Processing)"),
                palavras.getString("Largest Task First") + " " + palavras.getString("(Cost of Communication)"),
                palavras.getString("Lowest Task First") + " " + palavras.getString("(Cost of Communication)"),
                palavras.getString("User with Less Use of Grid First")};

            public int getSize() {
                return strings.length;
            }

            public Object getElementAt(int i) {
                return strings[i];
            }
        };
    }
}
