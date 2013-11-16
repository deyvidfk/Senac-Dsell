/**
 * @author deyvid.fk
 * @version 3.0
 */
package pi.controller;

import java.awt.Dimension;
import static java.lang.Thread.sleep;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import pi.views.FrmLoginDSell;

@SuppressWarnings("serial")
public class Sistema extends JWindow {

    private AbsoluteLayout absoluto;
    private AbsoluteConstraints absimage;
    private AbsoluteConstraints absbarra;
    private ImageIcon image;
    private JLabel jLabel;
    private JProgressBar barra;
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
                        Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                FrmLoginDSell FrmLogin = new FrmLoginDSell();
                FrmLogin.setVisible(true);
                FrmLogin.pack();
                FrmLogin.setVisible(true);
                FrmLogin.setLocationRelativeTo(null);
                dispose();
            }
        }.start();
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public static String getDate() {
        Date hoje = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(hoje);
    }

    public static String getTime() {
        Date hoje = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        return sdf.format(hoje);
    }

    private JProgressBar getBarra() {
        return barra;
    }
}
