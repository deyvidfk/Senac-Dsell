package pi.views.system;

import static java.lang.System.exit;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.swing.ImageIcon;
import static javax.swing.UIManager.setLookAndFeel;
import javax.swing.UnsupportedLookAndFeelException;
import static pi.controller.seguranca.Sessao.getSessao;
import pi.views.FrmAutenticaLogin;
import pi.views.FrmCadastrarPF;
import pi.views.FrmCadastrarPJ;
import pi.views.FrmCadastrarVenda;
import pi.views.FrmConsultarFornecedor;
import pi.views.FrmConsultarVenda;
import pi.views.FrmGerenciarModuloAcessoAoSistema;
import static pi.views.system.Menu.RELATORIO;
import static pi.views.system.Menu.SISTEMA;

public final class FrmMDI extends javax.swing.JFrame {

    ImageIcon image;
    FrmCadastrarPF formCadastroDeUsuario;
    FrmCadastrarPJ formCadastroPJ;
    FrmCadastrarVenda Comprarprodutos;
    FrmConsultarFornecedor frmConsultarFornecedor;
    FrmConsultarVenda vendas;
    FrmDesepenhoDoSistema formDesepenhoDoSistema;
    FrmAutenticaLogin FrmLogin;
    FrmSobre formSobre;
    String menu;

    public void menu1Visivel(List<Menu> m) {
        jMenu1.setVisible(false);
        jMenu2.setVisible(false);
        jMenu3.setVisible(false);
        jMenu4.setVisible(false);
        for (int i = 0; i < m.size(); i++) {
            switch (m.get(i)) {
                case SISTEMA:
                    this.jMenu3.setVisible(true);
                    break;
                case CADASTRO:
                    this.jMenu1.setVisible(true);
                    break;
                case RELATORIO:
                    this.jMenu2.setVisible(true);
                    break;
                case SOBRE:
                    this.jMenu3.setVisible(true);
                    break;
                default:
                    fileMenu.setVisible(true);
            }
        }
    }

    /**
     * Creates new form FrmMDI
     */
    public FrmMDI(List listaMenu) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        initComponents();
        try {
            setLookAndFeel(ConfigLayout.LookAndFeelDefault.getLookAndFeel());

        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(FrmMDI.class.getName()).log(Level.SEVERE, null, ex);
        }
        FrmSobre formSobre = new FrmSobre();
        getDesktopPane().add(formSobre);
        menu1Visivel(listaMenu);
        lblDadosSessao.setText("Olá " + getSessao().get(0).getUser().getNome());
        formSobre.setVisible(true);
    }

    private FrmMDI() {
        super();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        lblDadosSessao = new javax.swing.JLabel();
        backg = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        menuPj = new javax.swing.JMenuItem();
        menuPf = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        subMenuModuloAcesso = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblDadosSessao.setText("Dados da Sessao");
        desktopPane.add(lblDadosSessao);
        lblDadosSessao.setBounds(1050, 10, 170, 30);

        backg.setText("jLabel1");
        desktopPane.add(backg);
        backg.setBounds(180, 80, 1070, 590);

        fileMenu.setMnemonic('f');
        fileMenu.setText("...");

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        jMenuItem2.setText("Logout");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem2);

        jMenuItem6.setText("Sobre");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem6);

        menuBar.add(fileMenu);

        jMenu1.setText("Cadastro");

        menuPj.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        menuPj.setText("Fornecedor/Produto");
        menuPj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPjActionPerformed(evt);
            }
        });
        jMenu1.add(menuPj);

        menuPf.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        menuPf.setText("Usuário");
        menuPf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPfActionPerformed(evt);
            }
        });
        jMenu1.add(menuPf);

        menuBar.add(jMenu1);

        jMenu2.setText("Relatório");

        jMenuItem4.setText("Fornecedor");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Vendas");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        menuBar.add(jMenu2);

        jMenu4.setText("Consultar");

        jMenuItem3.setText("Venda");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        menuBar.add(jMenu4);

        jMenu3.setText("Sistema");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Criar registro");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        subMenuModuloAcesso.setText("Modulo Acesso");
        subMenuModuloAcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuModuloAcessoActionPerformed(evt);
            }
        });
        jMenu3.add(subMenuModuloAcesso);

        menuBar.add(jMenu3);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1226, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void menuPjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPjActionPerformed
        formCadastroPJ = new FrmCadastrarPJ();
        if (!formCadastroPJ.isVisible()) {
            getDesktopPane().add(formCadastroPJ);
            formCadastroPJ.setVisible(true);
            this.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_menuPjActionPerformed

    private void menuPfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPfActionPerformed

        formCadastroDeUsuario = new FrmCadastrarPF();
        if (!formCadastroDeUsuario.isVisible()) {
            getDesktopPane().add(formCadastroDeUsuario);
            formCadastroDeUsuario.setVisible(rootPaneCheckingEnabled);
            this.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_menuPfActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        formDesepenhoDoSistema = new FrmDesepenhoDoSistema();
        if (!formDesepenhoDoSistema.isVisible()) {
            getDesktopPane().add(formDesepenhoDoSistema);
            formDesepenhoDoSistema.setVisible(true);
            this.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Comprarprodutos = new FrmCadastrarVenda();
        if (!Comprarprodutos.isVisible()) {
            getDesktopPane().add(Comprarprodutos);
            Comprarprodutos.setVisible(true);
            this.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed

        frmConsultarFornecedor = new FrmConsultarFornecedor();
        getDesktopPane().add(frmConsultarFornecedor);
        frmConsultarFornecedor.pack();
        frmConsultarFornecedor.setVisible(true);
        this.setLocationRelativeTo(null);
        // }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        vendas = new FrmConsultarVenda();
        if (!vendas.isVisible()) {
            getDesktopPane().add(vendas);
            vendas.pack();
            vendas.setVisible(true);
            this.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void subMenuModuloAcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuModuloAcessoActionPerformed
        FrmGerenciarModuloAcessoAoSistema mod = new FrmGerenciarModuloAcessoAoSistema();
        mod.setVisible(true);
    }//GEN-LAST:event_subMenuModuloAcessoActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        FrmLogin = new FrmAutenticaLogin();
        if (!FrmLogin.isActive()) {
            FrmLogin.pack();
            FrmLogin.setVisible(true);
            FrmLogin.setLocationRelativeTo(null);
            FrmLogin.setTxtNomeUsuario(getSessao().get(0).getUser().getNome());
            dispose();
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        formSobre = new FrmSobre();
        if (!formSobre.isVisible()) {
            getDesktopPane().add(formSobre);
            formSobre.setVisible(true);
            this.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backg;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JLabel lblDadosSessao;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuPf;
    private javax.swing.JMenuItem menuPj;
    private javax.swing.JMenuItem subMenuModuloAcesso;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JDesktopPane getDesktopPane() {
        return desktopPane;
    }

    public void setDesktopPane(javax.swing.JDesktopPane desktopPane) {
        this.desktopPane = desktopPane;
    }

    /**
     * @return the jMenuItem1
     */
    public javax.swing.JMenuItem getjMenuItem1() {
        return jMenuItem1;
    }

    /**
     * @param jMenuItem1 the jMenuItem1 to set
     */
    public void setjMenuItem1(javax.swing.JMenuItem jMenuItem1) {
        this.jMenuItem1 = jMenuItem1;
    }
    private static final Logger LOG = getLogger(FrmMDI.class.getName());
}
