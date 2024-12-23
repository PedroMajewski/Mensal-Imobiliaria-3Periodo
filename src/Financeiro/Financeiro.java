/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Financeiro;

import DAO.JBDCCadastroFinanceiro;
import Imóvel.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import TelaInicial.TelaInicial;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.basic.BasicComboBoxUI;

import Financeiro.CadastroFinanceiro;
import Model.FinanceiroModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pedro
 */
public class Financeiro extends javax.swing.JPanel {

    /**
     * Creates new form CadastroImóvel
     */
    public Financeiro() {
        initComponents();
        exibirDadosTabelaFinanceiro();
        JButton[] btns = {BtnImovel, BtnPesquisa, BtnEditar};
        for (JButton btn : btns) {
            btn.setBackground(new Color(30, 122, 206));
            btn.setUI(new BasicButtonUI());
            btn.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {

                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    btn.setBackground(new Color(47, 141, 227));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btn.setBackground(new Color(30, 122, 206));
                }

            });
        }

// Adiciona o SistemaContent ao novo JPanel ou à outra parte da interface
    }

    public void exibirDadosTabelaFinanceiro() {
        DefaultTableModel modelo = (DefaultTableModel) tabelaContratos.getModel();

        if (modelo.getColumnCount() == 0) {
            modelo.addColumn("ID Contrato");
            modelo.addColumn("ID Imóvel");
            modelo.addColumn("Nome Contrato");
            modelo.addColumn("Nome Cliente");
            modelo.addColumn("Valor Parcela");
            modelo.addColumn("Número Parcelas");
            modelo.addColumn("Valor Total");
            modelo.addColumn("Situação");
        }

        modelo.setRowCount(0);

        JBDCCadastroFinanceiro dao = new JBDCCadastroFinanceiro();
        ArrayList<FinanceiroModel> listaFinanceiro = dao.buscarDadosTabelaFinanceiro();

        for (FinanceiroModel financeiro : listaFinanceiro) {
            Object[] row = {
                financeiro.getIdContrato(),
                financeiro.getIdImovelFinanceiro(),
                financeiro.getNomeContrato(),
                financeiro.getLocador(),
                financeiro.getValorParcela(),
                financeiro.getNumeroParcelas(),
                financeiro.getValor_total(),
                financeiro.getSituacaoComboFinanceiro()
            };
            modelo.addRow(row);

        }
    }

    public void atualizarTabelaContratos() {
        try {

            DefaultTableModel model = (DefaultTableModel) tabelaContratos.getModel();
            model.setRowCount(0);

            JBDCCadastroFinanceiro dao = new JBDCCadastroFinanceiro();
            ArrayList<FinanceiroModel> contratos = dao.buscarDadosTabelaFinanceiro(); // Esse método retorna todos os contratos

            for (FinanceiroModel contrato : contratos) {
                model.addRow(new Object[]{
                    contrato.getIdContrato(),
                    contrato.getIdImovelFinanceiro(),
                    contrato.getNomeContrato(),
                    contrato.getLocador(),
                    contrato.getValorParcela(),
                    contrato.getNumeroParcelas(),
                    contrato.getValor_total(),
                    contrato.getSituacaoComboFinanceiro()
                });
            }

            pesquisaText.setText("");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar a tabela: " + ex.getMessage());
        }
    }

    private void entregaDadosPesquisado(ArrayList<FinanceiroModel> contratos) {

        DefaultTableModel modelo = (DefaultTableModel) tabelaContratos.getModel();

        modelo.setRowCount(0);

        for (FinanceiroModel contrato : contratos) {
            modelo.addRow(new Object[]{
                contrato.getIdContrato(),
                contrato.getIdImovelFinanceiro(),
                contrato.getNomeContrato(),
                contrato.getLocador(),
                contrato.getValorParcela(),
                contrato.getNumeroParcelas(),
                contrato.getValor_total(),
                contrato.getSituacaoComboFinanceiro()
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PainelCentral = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        BtnImovel = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaContratos = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        pesquisaText = new javax.swing.JTextField();
        FiltroCombo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        BtnPesquisa = new javax.swing.JButton();
        atualizarTabela = new javax.swing.JButton();
        BtnEditar = new javax.swing.JButton();
        BtnExcluir = new javax.swing.JButton();

        PainelCentral.setBackground(new java.awt.Color(36, 114, 221));
        PainelCentral.setForeground(new java.awt.Color(255, 255, 255));
        PainelCentral.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("/Home/Financeiro");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Imobils, Sistema Imobiliário");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        BtnImovel.setBackground(new java.awt.Color(30, 122, 206));
        BtnImovel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        BtnImovel.setForeground(new java.awt.Color(255, 255, 255));
        BtnImovel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Edit_1.png"))); // NOI18N
        BtnImovel.setText("Cadastrar Contrato Financeiro");
        BtnImovel.setBorderPainted(false);
        BtnImovel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnImovel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnImovelActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Financeiro");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Aqui é possível o Financeiro e visualizar os contratos.");

        tabelaContratos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Contrato", "ID Imovel", "Nome Contrato", "Cliente", "Valor Parcela", "Numero Parcelas", "Valor Total", "Situação"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaContratos);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Pesquisar");

        pesquisaText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        FiltroCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID Imovel", "Nome Contrato", "Nome Cliente", "Situação" }));
        FiltroCombo.setBorder(null);
        FiltroCombo.setLightWeightPopupEnabled(false);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Filtrar por:");

        BtnPesquisa.setBackground(new java.awt.Color(30, 122, 206));
        BtnPesquisa.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        BtnPesquisa.setForeground(new java.awt.Color(255, 255, 255));
        BtnPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Search.png"))); // NOI18N
        BtnPesquisa.setText("Pesquisar");
        BtnPesquisa.setBorderPainted(false);
        BtnPesquisa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPesquisaActionPerformed(evt);
            }
        });

        atualizarTabela.setBackground(new java.awt.Color(30, 122, 206));
        atualizarTabela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Available Updates_1.png"))); // NOI18N
        atualizarTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarTabelaActionPerformed(evt);
            }
        });

        BtnEditar.setBackground(new java.awt.Color(30, 122, 206));
        BtnEditar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        BtnEditar.setForeground(new java.awt.Color(255, 255, 255));
        BtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Edit_1.png"))); // NOI18N
        BtnEditar.setText("Editar Contrato");
        BtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditarActionPerformed(evt);
            }
        });

        BtnExcluir.setBackground(new java.awt.Color(255, 51, 51));
        BtnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        BtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Close.png"))); // NOI18N
        BtnExcluir.setText("Excluir Contrato");
        BtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(pesquisaText, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel5)
                    .addComponent(BtnImovel, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FiltroCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BtnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(atualizarTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnImovel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pesquisaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FiltroCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(atualizarTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout PainelCentralLayout = new javax.swing.GroupLayout(PainelCentral);
        PainelCentral.setLayout(PainelCentralLayout);
        PainelCentralLayout.setHorizontalGroup(
            PainelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelCentralLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(PainelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PainelCentralLayout.setVerticalGroup(
            PainelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelCentralLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 799, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PainelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 724, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PainelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnImovelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnImovelActionPerformed
        // TODO add your handling code here:
        CadastroFinanceiro CdFinanceiro = new CadastroFinanceiro();
        ShowPanel(CdFinanceiro);

    }//GEN-LAST:event_BtnImovelActionPerformed

    private void BtnPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPesquisaActionPerformed

        String colunaSelecionada = FiltroCombo.getSelectedItem().toString();

        String valorPesquisa = pesquisaText.getText();

        if (valorPesquisa.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, insira um valor para pesquisa.");
            return;
        }

        JBDCCadastroFinanceiro contratoss = new JBDCCadastroFinanceiro();
        ArrayList<FinanceiroModel> contratosFiltrados = contratoss.filtrarContratos(colunaSelecionada, valorPesquisa);

        DefaultTableModel modelo = (DefaultTableModel) tabelaContratos.getModel();
        modelo.setRowCount(0);

        if (contratosFiltrados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum contrato encontrado");
        } else {

            entregaDadosPesquisado(contratosFiltrados);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnPesquisaActionPerformed

    private void atualizarTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarTabelaActionPerformed
        atualizarTabelaContratos();        // TODO add your handling code here:
    }//GEN-LAST:event_atualizarTabelaActionPerformed

    private void BtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditarActionPerformed

        int linhaSelecionada = tabelaContratos.getSelectedRow();

        // Verifica se alguma linha foi selecionada
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um contrato para editar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int idContrato = Integer.parseInt(tabelaContratos.getValueAt(linhaSelecionada, 0).toString());
        int idImovel = Integer.parseInt(tabelaContratos.getValueAt(linhaSelecionada, 1).toString());
        String nomeContrato = tabelaContratos.getValueAt(linhaSelecionada, 2).toString();
        String nomeCliente = tabelaContratos.getValueAt(linhaSelecionada, 3).toString();
        String valorParcela = tabelaContratos.getValueAt(linhaSelecionada, 4).toString();
        String numeroParcelas = tabelaContratos.getValueAt(linhaSelecionada, 5).toString();
        String valorTotal = tabelaContratos.getValueAt(linhaSelecionada, 6).toString();
        String situacao = tabelaContratos.getValueAt(linhaSelecionada, 7).toString();

        JBDCCadastroFinanceiro cad = new JBDCCadastroFinanceiro();

        String nomeImovel = cad.consultarNomeImovel(idImovel);

        if (nomeImovel == null) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar o nome do imóvel no banco.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        FinanceiroModel contratoModel = new FinanceiroModel();

        contratoModel.setIdContrato(idContrato);
        contratoModel.setNomeContrato(nomeContrato);
        contratoModel.setNumeroParcelas(numeroParcelas);
        contratoModel.setValorParcela(valorParcela);
        contratoModel.setValor_total(valorTotal);
        contratoModel.setSituacaoComboFinanceiro(situacao);
        contratoModel.setNome_imovel(nomeImovel);
        contratoModel.setLocador(nomeCliente);

        EditarContrato editarContrato = new EditarContrato();
        editarContrato.atualizarCampos(contratoModel);

        ShowPanel(editarContrato);

    }//GEN-LAST:event_BtnEditarActionPerformed

    private void BtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExcluirActionPerformed
        try {

            int selectedRow = tabelaContratos.getSelectedRow();

            if (selectedRow == -1) {

                JOptionPane.showMessageDialog(null, "Por favor, selecione um contrato para excluir.");
                return;
            }

            int contratoId = (int) tabelaContratos.getValueAt(selectedRow, 0);

            JBDCCadastroFinanceiro dao = new JBDCCadastroFinanceiro();
            dao.excluirContratoFinanceiro(contratoId);

            ((DefaultTableModel) tabelaContratos.getModel()).removeRow(selectedRow);

            JOptionPane.showMessageDialog(null, "Contrato excluído com sucesso!");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir contrato: " + ex.getMessage());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_BtnExcluirActionPerformed

    private void ShowPanel(JPanel p) {
        p.setSize(799, 700);
        p.setLocation(0, 0);

        PainelCentral.removeAll();
        PainelCentral.add(p, BorderLayout.CENTER);
        PainelCentral.revalidate();
        PainelCentral.repaint();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEditar;
    private javax.swing.JButton BtnExcluir;
    private javax.swing.JButton BtnImovel;
    private javax.swing.JButton BtnPesquisa;
    private javax.swing.JComboBox<String> FiltroCombo;
    private javax.swing.JPanel PainelCentral;
    private javax.swing.JButton atualizarTabela;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField pesquisaText;
    private javax.swing.JTable tabelaContratos;
    // End of variables declaration//GEN-END:variables
}
