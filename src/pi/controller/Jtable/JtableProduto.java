package pi.controller.Jtable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.swing.JOptionPane;
import pi.controller.CadastrarProduto;
import pi.model.Jtable.ModelJTable;
import pi.model.ModelProduto;
import pi.views.FrmCadastrarProd;

public final class JtableProduto {

    /**
     * PROPRIEDADES
     */
    private static ModelJTable _modelJtable;
    private static pi.views.FrmCadastrarProd _viewFrmProduto;
    private CadastrarProduto produto;

    /**
     * CONSTRUTOR DA CLASSE
     */
    public JtableProduto(FrmCadastrarProd ViewProduto) {
        setViewFrm(ViewProduto);
    }

    /**
     * MÉTODOS *
     */
    public void updateRow(int i, String txtCnpj, String txtRazaoS, String txtSetorDeAtuacao, String telefone, String email, String site, String cidade, String estado, String pais, String bairro, String rua, String numero, String complemento, String cep) {
        ((ModelJTable) this.getViewFrm().getjTableProduto().getModel()).setValueAt(txtCnpj, i, 0);
        ((ModelJTable) this.getViewFrm().getjTableProduto().getModel()).setValueAt(txtRazaoS, i, 1);
        ((ModelJTable) this.getViewFrm().getjTableProduto().getModel()).setValueAt(txtSetorDeAtuacao, i, 2);
        ((ModelJTable) this.getViewFrm().getjTableProduto().getModel()).setValueAt(telefone, i, 3);
        ((ModelJTable) this.getViewFrm().getjTableProduto().getModel()).setValueAt(email, i, 4);
        ((ModelJTable) this.getViewFrm().getjTableProduto().getModel()).setValueAt(site, i, 5);
        ((ModelJTable) this.getViewFrm().getjTableProduto().getModel()).setValueAt(cidade, i, 6);
        ((ModelJTable) this.getViewFrm().getjTableProduto().getModel()).setValueAt(estado, i, 7);
        ((ModelJTable) this.getViewFrm().getjTableProduto().getModel()).setValueAt(pais, i, 8);
        ((ModelJTable) this.getViewFrm().getjTableProduto().getModel()).setValueAt(bairro, i, 9);
        ((ModelJTable) this.getViewFrm().getjTableProduto().getModel()).setValueAt(rua, i, 10);
        ((ModelJTable) this.getViewFrm().getjTableProduto().getModel()).setValueAt(numero, i, 11);
        ((ModelJTable) this.getViewFrm().getjTableProduto().getModel()).setValueAt(complemento, i, 12);
        ((ModelJTable) this.getViewFrm().getjTableProduto().getModel()).setValueAt(cep, i, 13);
    }

    public int getRowCount() {
        return ((ModelJTable) this.getViewFrm().getjTableProduto().getModel()).getRowCount();
    }

    /**
     * POPULA A TABELA "JTable" COM OS DADOS
     */
    public void popularJtable() {
        ordenarPorNome();
        try {
            ModelJTable tabela = new ModelJTable((ArrayList) pi.controller.CadastrarProduto.getProduto());
            this.getViewFrm().getjTableProduto().setModel(tabela);
            this.getViewFrm().getjTableProduto().setDefaultRenderer(Object.class, new CellRenderer());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * ATUALIZA A TABELA "JTable"
     */
    public void updateJtable() {
//        ((ModelJTable) this.getViewFrm().getjTableProduto().getModel()).addRow();
    }

    /**
     * ORDENA OS REGISTROS DA TABELA POR NOME EM ORDEM ALFABETICA
     */
    public void ordenarPorNome() {
        //ordena pelo nome
        Collections.sort(pi.controller.CadastrarProduto.getProduto(), new Comparator<ModelProduto>() {
            @Override
            public int compare(ModelProduto o1, ModelProduto o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        });

    }

    public void searchRecord(String Output, int idFornecedor) {
        try {
            if (!Output.isEmpty()) {
                produto = new CadastrarProduto();
                setModelJtable(new ModelJTable((ArrayList) produto.searchRecord(Output, idFornecedor)));
                this.getViewFrm().getjTableProduto().setModel(getModelJtable());
            }
        } catch (Exception e) {
            System.err.println("Erro em searchRecord()" + e);
        }

    }

    public void searchRecordFiltro(String Output, int idFornecedor) {
        produto = new CadastrarProduto();
        try {
            if (!Output.isEmpty()) {
                setModelJtable(new ModelJTable((ArrayList) produto.searchRecordFiltro(Output, idFornecedor)));
                this.getViewFrm().getjTableProduto().setModel(getModelJtable());
            }
        } catch (Exception e) {
            System.err.println("Erro em searchRecord()" + e);
        }

    }

    public void searchRecord(int idFornecedor) {
        produto = new CadastrarProduto();
        try {
            setModelJtable(new ModelJTable((ArrayList) produto.searchRecord(idFornecedor)));
            this.getViewFrm().getjTableProduto().setModel(getModelJtable());
        } catch (Exception e) {
            System.err.println("Erro em searchRecord()" + e);
        }

    }

    /**
     * GETTERS E SETTERS *
     */
    public static ModelJTable getModelJtable() {
        return _modelJtable;
    }

    public static void setModelJtable(ModelJTable aModelJtable) {
        _modelJtable = aModelJtable;
    }

    public pi.views.FrmCadastrarProd getViewFrm() {
        return _viewFrmProduto;
    }

    public static void setViewFrm(pi.views.FrmCadastrarProd aViewFrmProduto) {
        _viewFrmProduto = aViewFrmProduto;
    }
}
