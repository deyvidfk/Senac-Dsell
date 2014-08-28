package com.senac.pi.controller.Jtable;

import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.annotation.Resource;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import com.senac.pi.controller.CadastrarVenda;
import static com.senac.pi.model.dao.DaoVenda.getVENDAS;
import com.senac.pi.views.FrmCadastrarVenda;
import com.senac.util.jTable.CellRenderer;
import com.senac.util.jTable.ModelJTable;

public class JtableVenda {

    /**
     * PROPRIEDADES
     */
    private static ModelJTable _Jtable;
    private static FrmCadastrarVenda _frmVenda;

    /**
     * GETTERS E SETTERS *
     */
    public static ModelJTable getJtable() {
        return _Jtable;
    }

    /**
     * @param aJtable the _Jtable to set
     */
    public static void setJtable(ModelJTable aJtable) {
        _Jtable = aJtable;
    }

    /**
     * @return the _frmVenda
     */
    public static FrmCadastrarVenda getFrmVenda() {
        return _frmVenda;
    }

    /**
     * @param aFrmVenda the _frmVenda to set
     */
    public static void setFrmVenda(FrmCadastrarVenda aFrmVenda) {
        _frmVenda = aFrmVenda;
    }

    /**
     * CONSTRUTOR DA CLASSE
     */
    public JtableVenda(FrmCadastrarVenda frm) {
        JtableVenda._frmVenda = frm;

    }

    /**
     * MÉTODOS *
     */
    /**
     * POPULA A TABELA "JTable" COM OS DADOS
     */
    public void popularJtable() {
        try {
            ModelJTable tabela = new ModelJTable(getVENDAS());
            getFrmVenda().getjTableVenda().setModel(tabela);
            getFrmVenda().getjTableVenda().setDefaultRenderer(Object.class, new CellRenderer());
        } catch (Exception e) {
            showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
            getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void searchRecord(int Output) {
        setJtable(new ModelJTable(CadastrarVenda.searchRecord(Output)));
        getFrmVenda().getjTableVenda().setModel(getJtable());
    }

    public void searchRecordByUser(int Output) {
        setJtable(new ModelJTable(CadastrarVenda.searchRecordByUser(Output)));
        getFrmVenda().getjTableVenda().setModel(getJtable());
    }
    private static final Logger LOG = getLogger(JtableVenda.class.getName());
}
