package com.senac.util.jTable;

import java.awt.Color;
import java.awt.Component;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

@SuppressWarnings("serial")
public class CellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int row, int column) {
        super.getTableCellRendererComponent(jtable, o, bln, bln1, row, column); //To change body of generated methods, choose Tools | Templates.
        if (row % 2 == 0) {
            setBackground(new Color(198, 226, 255));
        } else {
            setBackground(new Color(248, 248, 255));
        }
        if (bln) {
            setBackground(new Color(0, 191, 255));
        }
        return this;
    }
    private static final Logger LOG = getLogger(CellRenderer.class.getName());
}
