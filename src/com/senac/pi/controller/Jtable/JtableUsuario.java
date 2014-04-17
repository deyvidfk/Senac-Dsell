package com.senac.pi.controller.Jtable;

import java.awt.Color;
import java.util.ArrayList;
import static java.util.Collections.sort;
import java.util.Comparator;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.annotation.Resource;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.AbstractTableModel;
import static com.senac.pi.dao.DaoPessoaFisica.getUsuario;
import com.senac.pi.model.ModelPessoaFisica;
import com.senac.pi.views.FrmCadastrarPF;
import com.senac.util.jTable.CellRenderer;
import com.senac.util.jTable.ModelJTable;

public class JtableUsuario {

    /**
     * PROPRIEDADES
     */
    private static ModelJTable _modelJtable;
    private static FrmCadastrarPF _viewForm;

    /**
     * CONSTRUTOR DA CLASSE
     */
    public JtableUsuario(FrmCadastrarPF ViewUsuario) {
        setViewFrm(ViewUsuario);
    }

    /**
     * MÉTODOS *
     */
    /**
     * POPULA A TABELA "JTable" COM OS DADOS
     */
    public void popularJtable() {
//        ordenarPorNome();
        try {
            ModelJTable tabela = new ModelJTable(getUsuario());
            this.getViewForm().getjTableLoadUsers().setModel(tabela);
            this.getViewForm().getjTableLoadUsers().setDefaultRenderer(Object.class, new CellRenderer());
        } catch (Exception e) {
            showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
            getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * ATUALIZA A TABELA "JTable"
     */
    public void updateJtable() {
        ((AbstractTableModel) this.getViewForm().getjTableLoadUsers().getModel()).fireTableDataChanged();
    }

    /**
     * ATUALIZA REGISTRO NA LINHA ALTERADA INDICADA PELO ID
     */
    public void updateRow(int i, String nome, String rg, String cpf, String telefone, String email, String site, String cidade, String estado, String pais, String bairro, String rua, String numero, String complemento, String cep) {
        this.getViewForm().getjTableLoadUsers().getModel().setValueAt(nome, i, 0);
        this.getViewForm().getjTableLoadUsers().getModel().setValueAt(rg, i, 1);
        this.getViewForm().getjTableLoadUsers().getModel().setValueAt(cpf, i, 2);
        this.getViewForm().getjTableLoadUsers().getModel().setValueAt(telefone, i, 3);
        this.getViewForm().getjTableLoadUsers().getModel().setValueAt(email, i, 4);
        this.getViewForm().getjTableLoadUsers().getModel().setValueAt(site, i, 5);
        this.getViewForm().getjTableLoadUsers().getModel().setValueAt(cidade, i, 6);
        this.getViewForm().getjTableLoadUsers().getModel().setValueAt(estado, i, 7);
        this.getViewForm().getjTableLoadUsers().getModel().setValueAt(pais, i, 8);
        this.getViewForm().getjTableLoadUsers().getModel().setValueAt(bairro, i, 9);
        this.getViewForm().getjTableLoadUsers().getModel().setValueAt(rua, i, 10);
        this.getViewForm().getjTableLoadUsers().getModel().setValueAt(numero, i, 11);
        this.getViewForm().getjTableLoadUsers().getModel().setValueAt(complemento, i, 12);
        this.getViewForm().getjTableLoadUsers().getModel().setValueAt(cep, i, 13);
    }

    /**
     * ORDENA OS REGISTROS DA TABELA POR NOME EM ORDEM ALFABETICA
     */
    public void ordenarPorNome() {
        //ordena pelo nome
        sort(getUsuario(), new Comparator<ModelPessoaFisica>() {
            @Override
            public int compare(ModelPessoaFisica o1, ModelPessoaFisica o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        });
    }

    public void moveRecord(int i) {
        this.getViewForm().getTxtNome().setText(getUsuario().get(i).getNome());
        this.getViewForm().getTxtRg().setText(getUsuario().get(i).getRg());
        this.getViewForm().getTxtCpf().setText(getUsuario().get(i).getCpf());
        this.getViewForm().getTxtTelefone().setText(getUsuario().get(i).getTelefone());
        this.getViewForm().getTxtEmail().setText(getUsuario().get(i).getEmail());
        this.getViewForm().getTxtSite().setText(getUsuario().get(i).getSite());
        this.getViewForm().getTxtCidade().setText(getUsuario().get(i).getCidade());
        this.getViewForm().getTxtEstado().setText(getUsuario().get(i).getEstado());
        this.getViewForm().getTxtPais().setText(getUsuario().get(i).getPais());
        this.getViewForm().getTxtBairro().setText(getUsuario().get(i).getBairro());
        this.getViewForm().getTxtRua().setText(getUsuario().get(i).getRua());
        this.getViewForm().getTxtNumero().setText(getUsuario().get(i).getNumero());
        this.getViewForm().getTxtComplemento().setText(getUsuario().get(i).getComplemento());
        this.getViewForm().getTxtCep().setText(getUsuario().get(i).getCep());
        this.getViewForm().getTxtID().setText(Integer.toString(i));
    }

    /**
     * O METODO PESQUISA O REGISTRO POR NOME. OBS: O METODO FAZ A BUSCA DIRETO
     * NA LISTA ESTATICA JÁ CARREGADA NA MEMORIA, E NÃO NA TABELA “JTable”. APÓS
     * SE O REGISTRO É ENCONTRADO NA LISTA A TABELA É ATUALIZADA.
     */
    public void searchRecord(String Output) {
        if (!Output.isEmpty()) {
            String txtOutput = Output.toUpperCase(Locale.ROOT);
            ArrayList<ModelPessoaFisica> ListaAuxiliar = new ArrayList<>(getUsuario());
            ListaAuxiliar.clear();
            for (int index = 0; index < getUsuario().size(); index++) {
                if (getUsuario().get(index).getRg().toUpperCase(Locale.ROOT).contains(txtOutput) || getUsuario().get(index).getCpf().toUpperCase(Locale.ROOT).contains(txtOutput) || getUsuario().get(index).getNome().toUpperCase(Locale.ROOT).contains(txtOutput)) {
                    if (getUsuario().size() > 0) {
                        ListaAuxiliar.add(getUsuario().get(index));
                    }
                }
            }

            setModelJtable(new ModelJTable(ListaAuxiliar));
            this.getViewForm().getjTableLoadUsers().setModel(getModelJtable());
            this.getViewForm().getjTableLoadUsers().setBackground(Color.yellow);
        }
    }

    /**
     * GETTERS E SETTERS *
     */
    private com.senac.pi.views.FrmCadastrarPF getViewForm() {
        return _viewForm;
    }

    private void setViewFrm(FrmCadastrarPF ViewFrmFornecedor) {
        JtableUsuario._viewForm = ViewFrmFornecedor;
    }

    private ModelJTable getModelJtable() {
        return _modelJtable;
    }

    private void setModelJtable(ModelJTable ModelJtable) {
        JtableUsuario._modelJtable = ModelJtable;
    }
    private static final Logger LOG = getLogger(JtableUsuario.class.getName());
}
