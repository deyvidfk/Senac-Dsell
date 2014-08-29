package com.senac.pi.controller.Jtable;

import static java.util.Collections.sort;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.annotation.Resource;
import com.senac.pi.model.bo.CadastrarProduto;
import static com.senac.pi.model.bo.CadastrarProduto.getProduto;
import com.senac.pi.model.vo.ModelProduto;
import com.senac.pi.views.FrmCadastrarProd;
import com.senac.util.jTable.CellRenderer;
import com.senac.util.jTable.ModelJTable;

public class JtableProduto {

    /**
     * PROPRIEDADES
     */
    private static ModelJTable _modelJtable;
    private static com.senac.pi.views.FrmCadastrarProd _viewFrmProduto;

    /**
     * GETTERS E SETTERS *
     */
    public static ModelJTable getModelJtable() {
        return _modelJtable;
    }

    public static void setModelJtable(ModelJTable aModelJtable) {
        _modelJtable = aModelJtable;
    }

    public static void setViewFrm(com.senac.pi.views.FrmCadastrarProd aViewFrmProduto) {
        _viewFrmProduto = aViewFrmProduto;
    }
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
        this.getViewFrm().getjTableProduto().getModel().setValueAt(txtCnpj, i, 0);
        this.getViewFrm().getjTableProduto().getModel().setValueAt(txtRazaoS, i, 1);
        this.getViewFrm().getjTableProduto().getModel().setValueAt(txtSetorDeAtuacao, i, 2);
        this.getViewFrm().getjTableProduto().getModel().setValueAt(telefone, i, 3);
        this.getViewFrm().getjTableProduto().getModel().setValueAt(email, i, 4);
        this.getViewFrm().getjTableProduto().getModel().setValueAt(site, i, 5);
        this.getViewFrm().getjTableProduto().getModel().setValueAt(cidade, i, 6);
        this.getViewFrm().getjTableProduto().getModel().setValueAt(estado, i, 7);
        this.getViewFrm().getjTableProduto().getModel().setValueAt(pais, i, 8);
        this.getViewFrm().getjTableProduto().getModel().setValueAt(bairro, i, 9);
        this.getViewFrm().getjTableProduto().getModel().setValueAt(rua, i, 10);
        this.getViewFrm().getjTableProduto().getModel().setValueAt(numero, i, 11);
        this.getViewFrm().getjTableProduto().getModel().setValueAt(complemento, i, 12);
        this.getViewFrm().getjTableProduto().getModel().setValueAt(cep, i, 13);
    }

    public int getRowCount() {
        return this.getViewFrm().getjTableProduto().getModel().getRowCount();
    }

    public void popularJtable() {
        ordenarPorNome();
        try {
            ModelJTable tabela = new ModelJTable(getProduto());
            this.getViewFrm().getjTableProduto().setModel(tabela);
            this.getViewFrm().getjTableProduto().setDefaultRenderer(Object.class, new CellRenderer());
        } catch (Exception e) {
            getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
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
        sort(getProduto(), new Comparator<ModelProduto>() {
            @Override
            public int compare(ModelProduto o1, ModelProduto o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        });

    }

    public void searchRecord(String Output, String idFornecedor) {
        try {
            if (!Output.isEmpty()) {
                produto = new CadastrarProduto();
                setModelJtable(new ModelJTable(produto.searchRecord(Output, idFornecedor)));
                this.getViewFrm().getjTableProduto().setModel(getModelJtable());
            }
        } catch (Exception e) {
            getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public void searchRecordFiltro(String Output, String idFornecedor) {
        produto = new CadastrarProduto();
        try {
            if (!Output.isEmpty()) {
                setModelJtable(new ModelJTable(produto.searchRecordFiltro(Output, idFornecedor)));
                this.getViewFrm().getjTableProduto().setModel(getModelJtable());
            }
        } catch (Exception e) {
            getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public void searchRecord(String idFornecedor) {
        produto = new CadastrarProduto();
        try {
            ModelJTable tabela = new ModelJTable(produto.searchRecord(idFornecedor));
            this.getViewFrm().getjTableProduto().setModel(tabela);
            this.getViewFrm().getjTableProduto().setDefaultRenderer(Object.class, new CellRenderer());
        } catch (Exception e) {
            getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public com.senac.pi.views.FrmCadastrarProd getViewFrm() {
        return _viewFrmProduto;
    }
    private static final Logger LOG = getLogger(JtableProduto.class.getName());
}
