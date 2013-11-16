package pi.controller.Jtable;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.swing.JOptionPane;
import pi.model.Jtable.ModelJTable;
import pi.model.ModelPessoaFisica;
import pi.views.FrmCadastrarPF;

public final class JtableUsuario {

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
        ordenarPorNome();
        try {
            ModelJTable tabela = new ModelJTable((ArrayList) pi.controller.CadastrarUsuario.getUsuario());
            this.getViewForm().getjTableLoadUsers().setModel(tabela);
            this.getViewForm().getjTableLoadUsers().setDefaultRenderer(Object.class, new CellRenderer());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * ATUALIZA A TABELA "JTable"
     */
    public void updateJtable() {
        ((ModelJTable) this.getViewForm().getjTableLoadUsers().getModel()).fireTableDataChanged();
    }

    /**
     * ATUALIZA REGISTRO NA LINHA ALTERADA INDICADA PELO ID
     */
    public void updateRow(int i, String nome, String rg, String cpf, String telefone, String email, String site, String cidade, String estado, String pais, String bairro, String rua, String numero, String complemento, String cep) {
        ((ModelJTable) this.getViewForm().getjTableLoadUsers().getModel()).setValueAt(nome, i, 0);
        ((ModelJTable) this.getViewForm().getjTableLoadUsers().getModel()).setValueAt(rg, i, 1);
        ((ModelJTable) this.getViewForm().getjTableLoadUsers().getModel()).setValueAt(cpf, i, 2);
        ((ModelJTable) this.getViewForm().getjTableLoadUsers().getModel()).setValueAt(telefone, i, 3);
        ((ModelJTable) this.getViewForm().getjTableLoadUsers().getModel()).setValueAt(email, i, 4);
        ((ModelJTable) this.getViewForm().getjTableLoadUsers().getModel()).setValueAt(site, i, 5);
        ((ModelJTable) this.getViewForm().getjTableLoadUsers().getModel()).setValueAt(cidade, i, 6);
        ((ModelJTable) this.getViewForm().getjTableLoadUsers().getModel()).setValueAt(estado, i, 7);
        ((ModelJTable) this.getViewForm().getjTableLoadUsers().getModel()).setValueAt(pais, i, 8);
        ((ModelJTable) this.getViewForm().getjTableLoadUsers().getModel()).setValueAt(bairro, i, 9);
        ((ModelJTable) this.getViewForm().getjTableLoadUsers().getModel()).setValueAt(rua, i, 10);
        ((ModelJTable) this.getViewForm().getjTableLoadUsers().getModel()).setValueAt(numero, i, 11);
        ((ModelJTable) this.getViewForm().getjTableLoadUsers().getModel()).setValueAt(complemento, i, 12);
        ((ModelJTable) this.getViewForm().getjTableLoadUsers().getModel()).setValueAt(cep, i, 13);
    }

    /**
     * ORDENA OS REGISTROS DA TABELA POR NOME EM ORDEM ALFABETICA
     */
    public void ordenarPorNome() {
        //ordena pelo nome
        Collections.sort(pi.controller.CadastrarUsuario.getUsuario(), new Comparator<ModelPessoaFisica>() {
            @Override
            public int compare(ModelPessoaFisica o1, ModelPessoaFisica o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        });
    }

    public void moveRecord(int i) {
        this.getViewForm().getTxtNome().setText(pi.controller.CadastrarUsuario.getUsuario().get(i).getNome());
        this.getViewForm().getTxtRg().setText(pi.controller.CadastrarUsuario.getUsuario().get(i).getRg());
        this.getViewForm().getTxtCpf().setText(pi.controller.CadastrarUsuario.getUsuario().get(i).getCpf());
        this.getViewForm().getTxtTelefone().setText(pi.controller.CadastrarUsuario.getUsuario().get(i).getTelefone());
        this.getViewForm().getTxtEmail().setText(pi.controller.CadastrarUsuario.getUsuario().get(i).getEmail());
        this.getViewForm().getTxtSite().setText(pi.controller.CadastrarUsuario.getUsuario().get(i).getSite());
        this.getViewForm().getTxtCidade().setText(pi.controller.CadastrarUsuario.getUsuario().get(i).getCidade());
        this.getViewForm().getTxtEstado().setText(pi.controller.CadastrarUsuario.getUsuario().get(i).getEstado());
        this.getViewForm().getTxtPais().setText(pi.controller.CadastrarUsuario.getUsuario().get(i).getPais());
        this.getViewForm().getTxtBairro().setText(pi.controller.CadastrarUsuario.getUsuario().get(i).getBairro());
        this.getViewForm().getTxtRua().setText(pi.controller.CadastrarUsuario.getUsuario().get(i).getRua());
        this.getViewForm().getTxtNumero().setText(pi.controller.CadastrarUsuario.getUsuario().get(i).getNumero());
        this.getViewForm().getTxtComplemento().setText(pi.controller.CadastrarUsuario.getUsuario().get(i).getComplemento());
        this.getViewForm().getTxtCep().setText(pi.controller.CadastrarUsuario.getUsuario().get(i).getCep());
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
            ArrayList<ModelPessoaFisica> ListaAuxiliar = new ArrayList<>(pi.controller.CadastrarUsuario.getUsuario());
            ListaAuxiliar.clear();
            for (int index = 0; index < pi.controller.CadastrarUsuario.getUsuario().size(); index++) {
                if (pi.controller.CadastrarUsuario.getUsuario().get(index).getRg().toUpperCase(Locale.ROOT).contains(txtOutput) || pi.controller.CadastrarUsuario.getUsuario().get(index).getCpf().toUpperCase(Locale.ROOT).contains(txtOutput) || pi.controller.CadastrarUsuario.getUsuario().get(index).getNome().toUpperCase(Locale.ROOT).contains(txtOutput)) {
                    if (pi.controller.CadastrarUsuario.getUsuario().size() > 0) {
                        ListaAuxiliar.add(pi.controller.CadastrarUsuario.getUsuario().get(index));
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
    private pi.views.FrmCadastrarPF getViewForm() {
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
}
