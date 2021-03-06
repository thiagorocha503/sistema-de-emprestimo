/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.EmprestimoController;
import java.awt.event.KeyEvent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.EmprestimoTableModel;

/**
 *
 * @author thiago
 */
public class JanelaListagem extends javax.swing.JFrame {

    /**
     * Creates new form JanelaListagem
     */
    private final EmprestimoController controller;
    private final EmprestimoTableModel emprestimoTabelModel = new EmprestimoTableModel();
    
    public JanelaListagem() {
        initComponents();
        this.controller = new EmprestimoController(emprestimoTabelModel);
        this.tbEmprestimos.setModel(this.emprestimoTabelModel);
        this.findAll();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPanelFrame = new javax.swing.JScrollPane();
        panelContainer = new javax.swing.JPanel();
        panelBusca = new javax.swing.JPanel();
        btnPesquisar = new javax.swing.JButton();
        txtBusca = new javax.swing.JTextField();
        scrollPaneTable = new javax.swing.JScrollPane();
        tbEmprestimos = new javax.swing.JTable();
        panelButtons = new javax.swing.JPanel();
        btnDevolver = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnEmprestar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de emprestimos");
        setMinimumSize(new java.awt.Dimension(800, 400));
        setName("frmPrincipal"); // NOI18N
        setSize(new java.awt.Dimension(700, 350));

        panelContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 255)));

        panelBusca.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnPesquisar.setText("Buscar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        txtBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout panelBuscaLayout = new javax.swing.GroupLayout(panelBusca);
        panelBusca.setLayout(panelBuscaLayout);
        panelBuscaLayout.setHorizontalGroup(
            panelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBuscaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPesquisar)
                .addGap(330, 330, 330))
        );
        panelBuscaLayout.setVerticalGroup(
            panelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBuscaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbEmprestimos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "item", "data emprestimo", "data devolução", "data devolvido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbEmprestimos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEmprestimosMouseClicked(evt);
            }
        });
        scrollPaneTable.setViewportView(tbEmprestimos);

        btnDevolver.setText("Devolver");
        btnDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolverActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelButtonsLayout = new javax.swing.GroupLayout(panelButtons);
        panelButtons.setLayout(panelButtonsLayout);
        panelButtonsLayout.setHorizontalGroup(
            panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelButtonsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRemover)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDevolver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSair)
                .addGap(22, 22, 22))
        );
        panelButtonsLayout.setVerticalGroup(
            panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnRemover)
                    .addComponent(btnDevolver)
                    .addComponent(btnSair)))
        );

        btnEmprestar.setText("Novo emprestimo");
        btnEmprestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmprestarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelContainerLayout = new javax.swing.GroupLayout(panelContainer);
        panelContainer.setLayout(panelContainerLayout);
        panelContainerLayout.setHorizontalGroup(
            panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContainerLayout.createSequentialGroup()
                        .addGroup(panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(panelButtons, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(scrollPaneTable))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContainerLayout.createSequentialGroup()
                        .addGroup(panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelContainerLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnEmprestar))
                            .addComponent(panelBusca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(16, 16, 16))))
        );
        panelContainerLayout.setVerticalGroup(
            panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEmprestar)
                .addGap(18, 18, 18)
                .addComponent(scrollPaneTable, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        scrollPanelFrame.setViewportView(panelContainer);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPanelFrame, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPanelFrame, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public JTable getTbEmprestimos() {
        return tbEmprestimos;
    }
    
    public void findAll(){
        //apaga tudo  
        emprestimoTabelModel.removeAll();
        this.controller.findAll();
    }
    
    public void findByItem(String item){
         //apaga tudo  
        emprestimoTabelModel.removeAll();
        this.controller.findByItem(item);

    }
    
    private void btnEmprestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmprestarActionPerformed
        // TODO add your handling code here:
        JDialog janelaEmprestimo = new DialogEmprestimoCadastro(this, true,this.controller);
        janelaEmprestimo.setVisible(true);
    }//GEN-LAST:event_btnEmprestarActionPerformed

    
    private boolean isDevolvido(Object data){
        if (data == null){
            return false;
        }
        if (data.equals("") || data.equals("  /  /  /")){
            return false;
        } else {
            return true;
        }
    }
    private void btnDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolverActionPerformed
        // TODO add your handling code here:
        if (this.tbEmprestimos.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "Selecione um emprestimos");
            return;
        }
        Object data = this.emprestimoTabelModel.getValueAt(this.tbEmprestimos.getSelectedRow(), 6);
        if (! isDevolvido(data)){
            int id = Integer.parseInt(this.emprestimoTabelModel.getValueAt(this.tbEmprestimos.getSelectedRow() , 0).toString());
            System.err.println(id);
            JDialog dialogEmprestimo = new DialogDevolucao(this, true, this.controller, id);
            dialogEmprestimo.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Item já devolvido");
        }           
        
        
    }//GEN-LAST:event_btnDevolverActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        // TODO add your handling code here:
        int row = this.tbEmprestimos.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(null,"Escolha um emprestimo");
            return;
        }
        int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza de deseja remover item selecionado?","Remoção",JOptionPane.YES_NO_OPTION);
        System.out.println(resposta);
        if (resposta==0){      
            int id = Integer.parseInt(this.emprestimoTabelModel.getValueAt(row, 0).toString());
            if (this.controller.remover(id)){
                JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso","Exclusão",JOptionPane.INFORMATION_MESSAGE);          
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao excluir", "erro", JOptionPane.ERROR_MESSAGE);
            }            
         }
        
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        if (this.tbEmprestimos.getSelectedRow() != -1){
            new DialogEmprestimoAlterar(this, true, controller, emprestimoTabelModel, this.tbEmprestimos.getSelectedRow()).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null,"Selecione um emprestimo");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        // TODO add your handling code here:
        if(this.txtBusca.getText().equals("")){
            //findAll
            this.controller.findAll();
        } else {
            this.controller.findByItem(this.txtBusca.getText());
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void txtBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(this.txtBusca.getText().equals("")){
            //findAll
                this.findAll();       
            } else {
                this.findByItem(this.txtBusca.getText());
            }
        }
    }//GEN-LAST:event_txtBuscaKeyPressed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void tbEmprestimosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEmprestimosMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2 && this.tbEmprestimos.getSelectedRow() != -1){
            new DialogEmprestimoAlterar(this, true, controller, emprestimoTabelModel, this.tbEmprestimos.getSelectedRow()).setVisible(true);
        }
        
    }//GEN-LAST:event_tbEmprestimosMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaListagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new JanelaListagem().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDevolver;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEmprestar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSair;
    private javax.swing.JPanel panelBusca;
    private javax.swing.JPanel panelButtons;
    private javax.swing.JPanel panelContainer;
    private javax.swing.JScrollPane scrollPaneTable;
    private javax.swing.JScrollPane scrollPanelFrame;
    private javax.swing.JTable tbEmprestimos;
    private javax.swing.JTextField txtBusca;
    // End of variables declaration//GEN-END:variables
}
