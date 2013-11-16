package pi.controller.Jtable;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.swing.JOptionPane;
import pi.controller.CadastrarVenda;
import pi.model.Jtable.ModelJTable;
import pi.views.FrmCadastrarVenda;

public final class JtableVenda {

    /**
     * PROPRIEDADES
     */
    private static ModelJTable _Jtable;
    private static FrmCadastrarVenda _frmVenda;

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
            ModelJTable tabela = new ModelJTable((ArrayList) pi.controller.CadastrarVenda.getVENDAS());
            JtableVenda.getFrmVenda().getjTableVenda().setModel(tabela);
            JtableVenda.getFrmVenda().getjTableVenda().setDefaultRenderer(Object.class, new CellRenderer());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void searchRecord(int Output) {
        setJtable(new ModelJTable((ArrayList) CadastrarVenda.searchRecord(Output)));
        JtableVenda.getFrmVenda().getjTableVenda().setModel(getJtable());
    }

    public void searchRecordByUser(int Output) {
        setJtable(new ModelJTable((ArrayList) CadastrarVenda.searchRecordByUser(Output)));
        JtableVenda.getFrmVenda().getjTableVenda().setModel(getJtable());
    }

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
}
