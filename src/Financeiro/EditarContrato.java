/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Financeiro;

import DAO.JBDCCadastroFinanceiro;
import Model.FinanceiroModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Matheus
 */
public class EditarContrato extends javax.swing.JPanel {

    /**
     * Creates new form EditarContrato
     */
    public EditarContrato() {
        initComponents();
        MostrarListaClientes();
        MostrarListaImoveis();
        JButton[] btns = {BtnEditarContrato, BtnCancelar, BtnRetornar};
        for (JButton btn : btns) {
            btn.setBackground(new Color(30, 122, 206));
            btn.setUI(new BasicButtonUI());
            BtnRetornar.setBackground(Color.WHITE);
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
                    BtnRetornar.setBackground(Color.WHITE);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btn.setBackground(new Color(30, 122, 206));
                    BtnRetornar.setBackground(Color.WHITE);
                }

            });
        }
    }

    public void atualizarCampos(FinanceiroModel contratoModel) {
        idContrato.setText(String.valueOf(contratoModel.getIdContrato()));
        NomeContrato.setText(contratoModel.getNomeContrato());
        NParcelas.setText(contratoModel.getNumeroParcelas());
        ValorParcela.setText(contratoModel.getValorParcela());
        ValorTotal.setText(contratoModel.getValor_total());
        situacaoComboFinanceiro.setSelectedItem(contratoModel.getSituacaoComboFinanceiro());
        nomeImovelFinanceiro.setText(contratoModel.getNome_imovel());
        nomeClienteFinanceiro.setText(contratoModel.getLocador());
    }

    private void entregaClientePesquisado(ArrayList<FinanceiroModel> imoveis) {

        DefaultTableModel modelo = (DefaultTableModel) tableClientes.getModel();
        modelo.setRowCount(0);

        for (FinanceiroModel imovel : imoveis) {
            modelo.addRow(new Object[]{
                imovel.getIdimovel(),
                imovel.getNome_imovel()
            });
        }
    }

    private void entregaDadosPesquisado(ArrayList<FinanceiroModel> imoveis) {

        DefaultTableModel modelo = (DefaultTableModel) tableImoveis.getModel();
        modelo.setRowCount(0);

        for (FinanceiroModel imovel : imoveis) {
            modelo.addRow(new Object[]{
                imovel.getIdimovel(),
                imovel.getNome_imovel()
            });
        }
    }

    public void MostrarListaClientes() {

        pesquisarClienteEdit.setText("");
        DefaultTableModel model = (DefaultTableModel) tableClientes.getModel();

        if (model.getColumnCount() == 0) {
            model.addColumn("ID Cliente");
            model.addColumn("Cliente");
        }

        model.setRowCount(0);

        JBDCCadastroFinanceiro ListaProdutos = new JBDCCadastroFinanceiro();
        ArrayList<FinanceiroModel> listaProdutos = ListaProdutos.MostrarClientesTabela();

        for (FinanceiroModel produto : listaProdutos) {
            Object[] row = {
                produto.getIdimovel(),
                produto.getNome_imovel(),};
            model.addRow(row);
        }
    }

    public void MostrarListaImoveis() {

        pesquisarImovelEdit.setText("");
        DefaultTableModel model = (DefaultTableModel) tableImoveis.getModel();

        if (model.getColumnCount() == 0) {
            model.addColumn("ID Imovel");
            model.addColumn("Imovel");
        }

        model.setRowCount(0);

        JBDCCadastroFinanceiro ListaProdutos = new JBDCCadastroFinanceiro();
        ArrayList<FinanceiroModel> listaProdutos = ListaProdutos.MostrarImoveisTabela();

        for (FinanceiroModel produto : listaProdutos) {
            Object[] row = {
                produto.getIdimovel(),
                produto.getNome_imovel(),};
            model.addRow(row);
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

        jPanel1 = new javax.swing.JPanel();
        PainelCentral = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        BtnEditarContrato = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ValorTotalLabel = new javax.swing.JLabel();
        SituacaoComboLabel = new javax.swing.JLabel();
        BtnCancelar = new javax.swing.JButton();
        BtnRetornar = new javax.swing.JButton();
        ValorTotal = new javax.swing.JTextField();
        ValorParcela = new javax.swing.JTextField();
        ValorParcelaLabel = new javax.swing.JLabel();
        NParcelas = new javax.swing.JTextField();
        NParcelasLabel = new javax.swing.JLabel();
        nomeClienteFinanceiro = new javax.swing.JTextField();
        NomeLocadorLabel = new javax.swing.JLabel();
        NomeContratoLabel1 = new javax.swing.JLabel();
        NomeContrato = new javax.swing.JTextField();
        IdImovelLabel1 = new javax.swing.JLabel();
        nomeImovelFinanceiro = new javax.swing.JTextField();
        situacaoComboFinanceiro = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableImoveis = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableClientes = new javax.swing.JTable();
        BtnProcurarImovel = new javax.swing.JButton();
        BtnProcurarCliente = new javax.swing.JButton();
        pesquisarImovelEdit = new javax.swing.JTextField();
        pesquisarClienteEdit = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        idContrato = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        PainelCentral.setBackground(new java.awt.Color(36, 114, 221));
        PainelCentral.setForeground(new java.awt.Color(255, 255, 255));
        PainelCentral.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("/Home/Financeiro/Editar");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Imobils, Sistema Imobiliário");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        BtnEditarContrato.setBackground(new java.awt.Color(30, 122, 206));
        BtnEditarContrato.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        BtnEditarContrato.setForeground(new java.awt.Color(255, 255, 255));
        BtnEditarContrato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Edit_1.png"))); // NOI18N
        BtnEditarContrato.setText("Editar Contrato");
        BtnEditarContrato.setBorderPainted(false);
        BtnEditarContrato.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnEditarContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditarContratoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Editar Contrato Financeiro");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Aqui é possível editar os contratos.");

        ValorTotalLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ValorTotalLabel.setForeground(new java.awt.Color(153, 153, 153));
        ValorTotalLabel.setText("Valor Total:");

        SituacaoComboLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SituacaoComboLabel.setForeground(new java.awt.Color(153, 153, 153));
        SituacaoComboLabel.setText("Situação:");

        BtnCancelar.setBackground(new java.awt.Color(30, 122, 206));
        BtnCancelar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        BtnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        BtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Close.png"))); // NOI18N
        BtnCancelar.setText("Cancelar");
        BtnCancelar.setBorderPainted(false);
        BtnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });

        BtnRetornar.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        BtnRetornar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/U Turn to Left_1.png"))); // NOI18N
        BtnRetornar.setText("Retornar");
        BtnRetornar.setAlignmentY(0.0F);
        BtnRetornar.setBorderPainted(false);
        BtnRetornar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnRetornar.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        BtnRetornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRetornarActionPerformed(evt);
            }
        });

        ValorTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        ValorTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValorTotalActionPerformed(evt);
            }
        });
        ValorTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ValorTotalKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ValorTotalKeyTyped(evt);
            }
        });

        ValorParcela.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        ValorParcela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValorParcelaActionPerformed(evt);
            }
        });
        ValorParcela.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ValorParcelaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ValorParcelaKeyTyped(evt);
            }
        });

        ValorParcelaLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ValorParcelaLabel.setForeground(new java.awt.Color(153, 153, 153));
        ValorParcelaLabel.setText("Valor Parcela:");

        NParcelas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        NParcelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NParcelasActionPerformed(evt);
            }
        });
        NParcelas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NParcelasKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NParcelasKeyTyped(evt);
            }
        });

        NParcelasLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        NParcelasLabel.setForeground(new java.awt.Color(153, 153, 153));
        NParcelasLabel.setText("N° Parcelas:");

        nomeClienteFinanceiro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        nomeClienteFinanceiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeClienteFinanceiroActionPerformed(evt);
            }
        });
        nomeClienteFinanceiro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomeClienteFinanceiroKeyPressed(evt);
            }
        });

        NomeLocadorLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        NomeLocadorLabel.setForeground(new java.awt.Color(153, 153, 153));
        NomeLocadorLabel.setText("Nome Cliente:");

        NomeContratoLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        NomeContratoLabel1.setForeground(new java.awt.Color(153, 153, 153));
        NomeContratoLabel1.setText("Nome Contrato");

        NomeContrato.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        NomeContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeContratoActionPerformed(evt);
            }
        });
        NomeContrato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NomeContratoKeyPressed(evt);
            }
        });

        IdImovelLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        IdImovelLabel1.setForeground(new java.awt.Color(153, 153, 153));
        IdImovelLabel1.setText("Nome imovel");

        nomeImovelFinanceiro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        nomeImovelFinanceiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeImovelFinanceiroActionPerformed(evt);
            }
        });
        nomeImovelFinanceiro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomeImovelFinanceiroKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nomeImovelFinanceiroKeyTyped(evt);
            }
        });

        situacaoComboFinanceiro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Regular", "Pendente", "Atrasado" }));
        situacaoComboFinanceiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                situacaoComboFinanceiroActionPerformed(evt);
            }
        });

        tableImoveis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID Imovel", "Imovel"
            }
        ));
        jScrollPane1.setViewportView(tableImoveis);

        tableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID Cliente", "Cliente"
            }
        ));
        jScrollPane2.setViewportView(tableClientes);

        BtnProcurarImovel.setBackground(new java.awt.Color(30, 122, 206));
        BtnProcurarImovel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        BtnProcurarImovel.setForeground(new java.awt.Color(255, 255, 255));
        BtnProcurarImovel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Search.png"))); // NOI18N
        BtnProcurarImovel.setBorderPainted(false);
        BtnProcurarImovel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnProcurarImovel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnProcurarImovelActionPerformed(evt);
            }
        });

        BtnProcurarCliente.setBackground(new java.awt.Color(30, 122, 206));
        BtnProcurarCliente.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        BtnProcurarCliente.setForeground(new java.awt.Color(255, 255, 255));
        BtnProcurarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Search.png"))); // NOI18N
        BtnProcurarCliente.setBorderPainted(false);
        BtnProcurarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnProcurarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnProcurarClienteActionPerformed(evt);
            }
        });

        pesquisarImovelEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarImovelEditActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Pesquisar Cliente");

        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("Pesquisar Imovel");

        idContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idContratoActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("ID Contrato");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnRetornar)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(situacaoComboFinanceiro, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SituacaoComboLabel)
                                .addComponent(BtnEditarContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(IdImovelLabel1))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NomeContratoLabel1)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(NomeContrato, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                        .addComponent(ValorParcelaLabel)
                                        .addComponent(nomeImovelFinanceiro))
                                    .addComponent(ValorParcela, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(NParcelasLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BtnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ValorTotalLabel)
                                    .addComponent(ValorTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                    .addComponent(NParcelas, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                    .addComponent(NomeLocadorLabel)
                                    .addComponent(nomeClienteFinanceiro)))
                            .addComponent(jLabel3))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(pesquisarImovelEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BtnProcurarImovel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(pesquisarClienteEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BtnProcurarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(idContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(302, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(BtnRetornar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(idContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NomeContratoLabel1)
                            .addComponent(NParcelasLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NomeContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BtnProcurarImovel)
                            .addComponent(pesquisarImovelEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 26, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IdImovelLabel1)
                            .addComponent(NomeLocadorLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomeImovelFinanceiro, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomeClienteFinanceiro, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ValorTotalLabel)
                            .addComponent(ValorParcelaLabel)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ValorParcela, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addComponent(SituacaoComboLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(situacaoComboFinanceiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnEditarContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BtnProcurarCliente)
                            .addComponent(pesquisarClienteEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(261, 261, 261))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1003, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PainelCentral, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 941, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PainelCentral, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1003, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 941, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnEditarContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditarContratoActionPerformed
        // TODO add your handling code here:
        try {
            String locador = null;
            Integer idImovel = null;

            int selectedRowCliente = tableClientes.getSelectedRow();
            if (selectedRowCliente != -1) {
                locador = tableClientes.getValueAt(selectedRowCliente, 0).toString();
            } else {
                locador = nomeClienteFinanceiro.getText();
            }

            int selectedRowImovel = tableImoveis.getSelectedRow();
            if (selectedRowImovel != -1) {
                idImovel = Integer.parseInt(tableImoveis.getValueAt(selectedRowImovel, 0).toString());
            } else {
                String nomeImovel = nomeImovelFinanceiro.getText();
                if (nomeImovel != null && !nomeImovel.trim().isEmpty()) {

                    JBDCCadastroFinanceiro damn = new JBDCCadastroFinanceiro();
                    idImovel = damn.buscarIdImovelPorNome(nomeImovel);
                }
            }

            String nomeContrato = NomeContrato.getText();
            String situacaoTexto = situacaoComboFinanceiro.getSelectedItem().toString();
            String valorParcela = ValorParcela.getText();
            String numeroParcelas = NParcelas.getText();
            String valorTotal = ValorTotal.getText();
            int IdContrato = Integer.parseInt(idContrato.getText());

            FinanceiroModel financeiro = new FinanceiroModel(
                    nomeContrato, situacaoTexto, valorParcela, numeroParcelas, valorTotal, locador, idImovel
            );

            JBDCCadastroFinanceiro dao = new JBDCCadastroFinanceiro();
            dao.atualizarContratoFinanceiro(IdContrato, financeiro);

            JOptionPane.showMessageDialog(null, "Contrato atualizado com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar contrato: " + ex.getMessage());
        }


    }//GEN-LAST:event_BtnEditarContratoActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        // TODO add your handling code here:
        String[] options = {"Sim", "Cancelar"};
        int resposta = JOptionPane.showOptionDialog(
                this,
                "Esta ação apagará todos os campos, tem certeza?",
                "Confirmação",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                options,
                options[0]
        );
        if (resposta == 0) {

        } else {
            BtnCancelar.requestFocus();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void BtnRetornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRetornarActionPerformed
        // TODO add your handling code here:

        Financeiro financeiroPrincipal = new Financeiro();
        ShowPanel(financeiroPrincipal);
    }//GEN-LAST:event_BtnRetornarActionPerformed

    private void ValorTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValorTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ValorTotalActionPerformed

    private void ValorTotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ValorTotalKeyPressed
        // TODO add your handling code here:
        if (evt.getExtendedKeyCode() == evt.VK_ENTER) {
            nomeClienteFinanceiro.requestFocus();
        }
    }//GEN-LAST:event_ValorTotalKeyPressed

    private void ValorTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ValorTotalKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_ValorTotalKeyTyped

    private void ValorParcelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValorParcelaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ValorParcelaActionPerformed

    private void ValorParcelaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ValorParcelaKeyPressed
        // TODO add your handling code here:
        if (evt.getExtendedKeyCode() == evt.VK_ENTER) {
            NParcelas.requestFocus();
        }
    }//GEN-LAST:event_ValorParcelaKeyPressed

    private void ValorParcelaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ValorParcelaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_ValorParcelaKeyTyped

    private void NParcelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NParcelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NParcelasActionPerformed

    private void NParcelasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NParcelasKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_NParcelasKeyPressed

    private void NParcelasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NParcelasKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_NParcelasKeyTyped

    private void nomeClienteFinanceiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeClienteFinanceiroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeClienteFinanceiroActionPerformed

    private void nomeClienteFinanceiroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeClienteFinanceiroKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeClienteFinanceiroKeyPressed

    private void NomeContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeContratoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeContratoActionPerformed

    private void NomeContratoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NomeContratoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeContratoKeyPressed

    private void nomeImovelFinanceiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeImovelFinanceiroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeImovelFinanceiroActionPerformed

    private void nomeImovelFinanceiroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeImovelFinanceiroKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeImovelFinanceiroKeyPressed

    private void nomeImovelFinanceiroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeImovelFinanceiroKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeImovelFinanceiroKeyTyped

    private void situacaoComboFinanceiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_situacaoComboFinanceiroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_situacaoComboFinanceiroActionPerformed

    private void BtnProcurarImovelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnProcurarImovelActionPerformed

        String valorPesquisa = pesquisarImovelEdit.getText();

        JBDCCadastroFinanceiro dao = new JBDCCadastroFinanceiro();

        ArrayList<FinanceiroModel> produtosFiltrados = dao.filtrarImoveisPorNome(valorPesquisa);

        entregaDadosPesquisado(produtosFiltrados);        // TODO add your handling code here:
    }//GEN-LAST:event_BtnProcurarImovelActionPerformed

    private void BtnProcurarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnProcurarClienteActionPerformed

        String valorPesquisa = pesquisarClienteEdit.getText();

        JBDCCadastroFinanceiro dao = new JBDCCadastroFinanceiro();

        ArrayList<FinanceiroModel> produtosFiltrados = dao.filtrarClientesPorNome(valorPesquisa);

        entregaClientePesquisado(produtosFiltrados);
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnProcurarClienteActionPerformed

    private void pesquisarImovelEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarImovelEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pesquisarImovelEditActionPerformed

    private void idContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idContratoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idContratoActionPerformed

    private void ShowPanel(JPanel p) {
        p.setSize(799, 700);
        p.setLocation(0, 0);

        PainelCentral.removeAll();
        PainelCentral.add(p, BorderLayout.CENTER);
        PainelCentral.revalidate();
        PainelCentral.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnEditarContrato;
    private javax.swing.JButton BtnProcurarCliente;
    private javax.swing.JButton BtnProcurarImovel;
    private javax.swing.JButton BtnRetornar;
    private javax.swing.JLabel IdImovelLabel1;
    private javax.swing.JTextField NParcelas;
    private javax.swing.JLabel NParcelasLabel;
    private javax.swing.JTextField NomeContrato;
    private javax.swing.JLabel NomeContratoLabel1;
    private javax.swing.JLabel NomeLocadorLabel;
    private javax.swing.JPanel PainelCentral;
    private javax.swing.JLabel SituacaoComboLabel;
    private javax.swing.JTextField ValorParcela;
    private javax.swing.JLabel ValorParcelaLabel;
    private javax.swing.JTextField ValorTotal;
    private javax.swing.JLabel ValorTotalLabel;
    private javax.swing.JTextField idContrato;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nomeClienteFinanceiro;
    private javax.swing.JTextField nomeImovelFinanceiro;
    private javax.swing.JTextField pesquisarClienteEdit;
    private javax.swing.JTextField pesquisarImovelEdit;
    private javax.swing.JComboBox<String> situacaoComboFinanceiro;
    private javax.swing.JTable tableClientes;
    private javax.swing.JTable tableImoveis;
    // End of variables declaration//GEN-END:variables
}
