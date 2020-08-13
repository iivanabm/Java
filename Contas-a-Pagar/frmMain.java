package trab;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class frmMain extends javax.swing.JFrame {

    private DefaultTableModel modeloTabela;

    public frmMain() {

        initComponents();
        setLocationRelativeTo(null);
        modeloTabela = (DefaultTableModel) tabela.getModel();
        modeloTabela.addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent tme) {
                saveTable();
                menuRemover.setEnabled(false);
                atualizaValorTotal();
            }
        });
        tabela.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                menuRemover.setEnabled(!event.getValueIsAdjusting() && tabela.getSelectedRow() != -1);
            }
        });
        loadTable();
        atualizaValorTotal();
    }

    private void atualizaValorTotal() {
        BigDecimal valor = new BigDecimal("0");
        for (int row = 0; row < tabela.getRowCount(); row++) {
            valor = valor.add(new BigDecimal(tabela.getValueAt(row, 1).toString()));
        }
        valor.setScale(2, RoundingMode.HALF_EVEN);
        lblValorTotal.setText("Valor total: R$ " + valor);
    }

    private void saveTable() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("contas.dat"));
            out.writeObject(modeloTabela.getDataVector());
            out.close();
        } catch (Exception ex) {
        }
    }

    private void loadTable() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("contas.dat"));
            Vector rowData = (Vector) in.readObject();
            Iterator itr = rowData.iterator();
            while (itr.hasNext()) {
                modeloTabela.addRow((Vector) itr.next());
            }
            in.close();
        } catch (Exception ex) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgAdd = new javax.swing.JDialog();
        btnAdd = new javax.swing.JButton();
        lblValor = new javax.swing.JLabel();
        txtDesc = new javax.swing.JTextField();
        lblDesc = new javax.swing.JLabel();
        lblVencimento = new javax.swing.JLabel();
        txtValor = new javax.swing.JFormattedTextField();
        txtVencimento = new javax.swing.JFormattedTextField();
        scrollPane = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        lblValorTotal = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        menuAdicionar = new javax.swing.JMenu();
        menuRemover = new javax.swing.JMenu();

        dlgAdd.setTitle("Adicionar conta");
        dlgAdd.setAlwaysOnTop(true);
        dlgAdd.setResizable(false);
        dlgAdd.setSize(new java.awt.Dimension(380, 150));
        dlgAdd.setLocationRelativeTo(null);

        btnAdd.setText("Adicionar");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lblValor.setText("Valor: R$");

        txtDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescActionPerformed(evt);
            }
        });

        lblDesc.setText("Descrição");

        lblVencimento.setText("Vencimento");

        txtValor.setMinimumSize(new java.awt.Dimension(6, 18));

        txtVencimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVencimentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dlgAddLayout = new javax.swing.GroupLayout(dlgAdd.getContentPane());
        dlgAdd.getContentPane().setLayout(dlgAddLayout);
        dlgAddLayout.setHorizontalGroup(
            dlgAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgAddLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dlgAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAdd)
                    .addGroup(dlgAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, dlgAddLayout.createSequentialGroup()
                            .addComponent(lblDesc)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, dlgAddLayout.createSequentialGroup()
                            .addComponent(lblVencimento)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblValor)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        dlgAddLayout.setVerticalGroup(
            dlgAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgAddLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dlgAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDesc)
                    .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dlgAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVencimento)
                    .addComponent(lblValor)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAdd)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        try {
            MaskFormatter maskData = new MaskFormatter("##/##/####");
            maskData.install(txtVencimento);
        }catch(Exception ignored){

        }

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Contas a pagar");
        setResizable(false);
        setSize(new java.awt.Dimension(640, 480));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descrição", "Valor (R$)", "Vencimento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.setColumnSelectionAllowed(true);
        tabela.getTableHeader().setReorderingAllowed(false);
        scrollPane.setViewportView(tabela);
        tabela.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setResizable(false);
            tabela.getColumnModel().getColumn(0).setPreferredWidth(400);
            tabela.getColumnModel().getColumn(1).setResizable(false);
            tabela.getColumnModel().getColumn(2).setResizable(false);
        }

        lblValorTotal.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblValorTotal.setText("Valor total: R$ 0");

        menuAdicionar.setText("Adicionar");
        menuAdicionar.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                menuAdicionarMenuSelected(evt);
            }
        });
        menuAdicionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAdicionarMouseClicked(evt);
            }
        });
        menuAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAdicionarActionPerformed(evt);
            }
        });
        menu.add(menuAdicionar);

        menuRemover.setText("Remover");
        menuRemover.setEnabled(false);
        menuRemover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuRemoverMouseClicked(evt);
            }
        });
        menu.add(menuRemover);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblValorTotal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblValorTotal)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAdicionarActionPerformed

    }//GEN-LAST:event_menuAdicionarActionPerformed

    private void menuAdicionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAdicionarMouseClicked

    }//GEN-LAST:event_menuAdicionarMouseClicked

    private void txtDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescActionPerformed

    }//GEN-LAST:event_txtDescActionPerformed

    private void mostrarMensagemDeErro(String erro) {
        JFrame jf = new JFrame();
        jf.setAlwaysOnTop(true);
        JOptionPane.showMessageDialog(jf, erro, "Erro", ERROR_MESSAGE);
    }

    public static boolean verificaData(String data) {
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            df.setLenient(false);
            df.parse(data);
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public static boolean verificaValor(String valor) {
        try {
            double d = Double.parseDouble(valor);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked

        String desc = txtDesc.getText().trim();
        String valor = txtValor.getText().trim();
        String vencimento = txtVencimento.getText().trim();
        if (desc.isEmpty() || valor.isEmpty() || vencimento.isEmpty()) {
            mostrarMensagemDeErro("Por favor preencha todos os campos");
            return;
        }
        if (!verificaData(vencimento)) {
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            mostrarMensagemDeErro("Vencimento inválido");
            return;
        }
        if (!verificaValor(valor)) {
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            mostrarMensagemDeErro("Valor inválido");
            return;
        }
        valor = new BigDecimal(valor).setScale(2, RoundingMode.HALF_EVEN).toString();
        modeloTabela.addRow(new String[]{desc, valor, vencimento});
        dlgAdd.setVisible(false);
        setEnabled(true);
        requestFocus();

    }//GEN-LAST:event_btnAddMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

    }//GEN-LAST:event_btnAddActionPerformed

    private void txtVencimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVencimentoActionPerformed

    }//GEN-LAST:event_txtVencimentoActionPerformed

    private void menuRemoverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuRemoverMouseClicked

        modeloTabela.removeRow(tabela.getSelectedRow());
    }//GEN-LAST:event_menuRemoverMouseClicked

    private void menuAdicionarMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_menuAdicionarMenuSelected

        setEnabled(false);
        dlgAdd.setVisible(true);
        txtDesc.requestFocus();
        txtDesc.setText("");
        txtValor.setText("");
        txtVencimento.setText("");
        dlgAdd.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                setEnabled(true);
                requestFocus();
            }
        });
    }//GEN-LAST:event_menuAdicionarMenuSelected

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new frmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAdd;
    public javax.swing.JDialog dlgAdd;
    public javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblValor;
    private javax.swing.JLabel lblValorTotal;
    public javax.swing.JLabel lblVencimento;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menuAdicionar;
    private javax.swing.JMenu menuRemover;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tabela;
    public javax.swing.JTextField txtDesc;
    public javax.swing.JFormattedTextField txtValor;
    public javax.swing.JFormattedTextField txtVencimento;
    // End of variables declaration//GEN-END:variables
}
