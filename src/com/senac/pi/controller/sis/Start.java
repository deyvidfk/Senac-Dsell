package com.senac.pi.controller.sis;

import java.awt.Dimension;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import com.senac.pi.views.FrmAutenticaLogin;

public final class Start {

    /**
     * @param args the commancreatConfigDefault line arguments
     */
    public static void main(String[] args) {
        Start start = new Start();
        Sistema sistema = start.new Sistema();
    }

    @SuppressWarnings("serial")
    public class Sistema extends JWindow {

        private final AbsoluteLayout absoluto;
        private final AbsoluteConstraints absimage;
        private AbsoluteConstraints absbarra;
        private final ImageIcon image;
        private final JLabel jLabel;
        private final JProgressBar barra;
        private final String LOGOTIPO_DSELL = "dsell.png";

        public Sistema() {

            absoluto = new AbsoluteLayout();
            absimage = new AbsoluteConstraints(0, 0);
            absbarra = new AbsoluteConstraints(0, 309);
            absbarra = new AbsoluteConstraints(0, 280);
            jLabel = new JLabel();
            image = new ImageIcon(this.getClass().getResource(LOGOTIPO_DSELL));
            jLabel.setIcon(image);
            barra = new JProgressBar();
            barra.setPreferredSize(new Dimension(480, 10));

            this.getContentPane().setLayout(absoluto);
            this.getContentPane().add(jLabel, absimage);
            this.getContentPane().add(barra, absbarra);

            new Thread() {
                @Override
                public void run() {
                    int i = 0;
                    while (i < 101) {
                        getBarra().setValue(i);
                        i++;
                        try {
                            sleep(5);
                        } catch (InterruptedException ex) {
                            getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    UserDefault us = new UserDefault();
                    //Verifica se já existe algum usuário cadastrado
                    if (us.getStatusSistema()) {
                        FrmAutenticaLogin FrmLogin = new FrmAutenticaLogin();
                        FrmLogin.pack();
                        FrmLogin.setVisible(true);
                        FrmLogin.setLocationRelativeTo(null);
                        dispose();

                    } else {
                        us.criaUsuarioDefault();
                    }
                }
            }.start();
            this.pack();
            this.setVisible(true);
            this.setLocationRelativeTo(null);
        }

        private JProgressBar getBarra() {
            return barra;
        }
    }
    private static final Logger LOG = getLogger(Start.class.getName());
}
