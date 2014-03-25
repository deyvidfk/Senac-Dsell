package util.jTable;

import java.awt.Color;
import java.awt.Component;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * @author Deyvid Franklin
 * @version 3.1
 */
@SuppressWarnings("serial")
public class CellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int row, int column) {
        super.getTableCellRendererComponent(jtable, o, bln, bln1, row, column); //To change body of generated methods, choose Tools | Templates.

        if (row % 2 == 0) {
            setBackground(Color.LIGHT_GRAY);
        } else {
            setBackground(null);
        }
        if (bln) {
            setBackground(Color.CYAN);
        }

        return this;
    }
    private static final Logger LOG = getLogger(CellRenderer.class.getName());
}
