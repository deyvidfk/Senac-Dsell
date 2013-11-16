package pi.controller.Jtable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.swing.JOptionPane;
import pi.model.Jtable.ModelJTable;

import pi.model.ModelPessoaJuridica;
import pi.views.FrmCadastrarPJ;

public final class JtableFornecedor {

    /**
     * PROPRIEDADES
     */
    private static ModelJTable _modelJtable;
    private static pi.views.FrmCadastrarPJ _viewFrm;

    /**
     * CONSTRUTORES DA CLASSE
     */
    public JtableFornecedor() {
    }

    public JtableFornecedor(FrmCadastrarPJ ViewFornecedor) {

        setViewFrm(ViewFornecedor);
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
            ModelJTable tabela = new ModelJTable((ArrayList) pi.controller.CadastrarFornecedor.getFornecedor());
            this.getViewFrm().getjTableFornecedor().setModel(tabela);
            this.getViewFrm().getjTableFornecedor().setDefaultRenderer(Object.class, new CellRenderer());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public void updateJtable() {
//        ((ModelJTable) this.getViewFrm().getjTableFornecedor().getModel()).addRow();
    }

    /**
     * ATUALIZA REGISTRO NA LINHA ALTERADA INDICADA PELO ID
     */
    public void updateRow(int i, String txtCnpj, String txtRazaoS, String txtSetorDeAtuacao, String telefone, String email, String site, String cidade, String estado, String pais, String bairro, String rua, String numero, String complemento, String cep) {
        ((ModelJTable) this.getViewFrm().getjTableFornecedor().getModel()).setValueAt(txtCnpj, i, 1);
        ((ModelJTable) this.getViewFrm().getjTableFornecedor().getModel()).setValueAt(txtRazaoS, i, 2);
        ((ModelJTable) this.getViewFrm().getjTableFornecedor().getModel()).setValueAt(txtSetorDeAtuacao, i, 3);
        ((ModelJTable) this.getViewFrm().getjTableFornecedor().getModel()).setValueAt(telefone, i, 4);
        ((ModelJTable) this.getViewFrm().getjTableFornecedor().getModel()).setValueAt(email, i, 5);
        ((ModelJTable) this.getViewFrm().getjTableFornecedor().getModel()).setValueAt(site, i, 6);
        ((ModelJTable) this.getViewFrm().getjTableFornecedor().getModel()).setValueAt(cidade, i, 7);
        ((ModelJTable) this.getViewFrm().getjTableFornecedor().getModel()).setValueAt(estado, i, 8);
        ((ModelJTable) this.getViewFrm().getjTableFornecedor().getModel()).setValueAt(pais, i, 9);
        ((ModelJTable) this.getViewFrm().getjTableFornecedor().getModel()).setValueAt(bairro, i, 10);
        ((ModelJTable) this.getViewFrm().getjTableFornecedor().getModel()).setValueAt(rua, i, 11);
        ((ModelJTable) this.getViewFrm().getjTableFornecedor().getModel()).setValueAt(numero, i, 12);
        ((ModelJTable) this.getViewFrm().getjTableFornecedor().getModel()).setValueAt(complemento, i, 13);
        ((ModelJTable) this.getViewFrm().getjTableFornecedor().getModel()).setValueAt(cep, i, 14);
    }

    public void deleteRow(int id) {
//        ((ModelJTable) this.getViewFrm().getjTableFornecedor().getModel()).DeleteRow(id);
    }

    /**
     * ORDENA OS REGISTROS DA TABELA POR NOME EM ORDEM ALFABETICA
     */
    public void ordenarPorNome() {
        //ordena pelo nome
        Collections.sort(pi.controller.CadastrarFornecedor.getFornecedor(), new Comparator<ModelPessoaJuridica>() {
            @Override
            public int compare(ModelPessoaJuridica o1, ModelPessoaJuridica o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        });
    }

    public void moveRecord(int i) {
        this.getViewFrm().getTxtRazaoS().setText(pi.controller.CadastrarFornecedor.getFornecedor().get(i).getNome());
        this.getViewFrm().getTxtCnpj().setText(pi.controller.CadastrarFornecedor.getFornecedor().get(i).getCnpj());
        this.getViewFrm().getTxtSetorAt().setText(pi.controller.CadastrarFornecedor.getFornecedor().get(i).getSetorDeAtuacao());
        this.getViewFrm().getTxtTelefone().setText(pi.controller.CadastrarFornecedor.getFornecedor().get(i).getTelefone());
        this.getViewFrm().getTxtEmail().setText(pi.controller.CadastrarFornecedor.getFornecedor().get(i).getEmail());
        this.getViewFrm().getTxtSite().setText(pi.controller.CadastrarFornecedor.getFornecedor().get(i).getSite());
        this.getViewFrm().getTxtCidade().setText(pi.controller.CadastrarFornecedor.getFornecedor().get(i).getCidade());
        this.getViewFrm().getTxtEstado().setText(pi.controller.CadastrarFornecedor.getFornecedor().get(i).getEstado());
        this.getViewFrm().getTxtPais().setText(pi.controller.CadastrarFornecedor.getFornecedor().get(i).getPais());
        this.getViewFrm().getTxtBairro().setText(pi.controller.CadastrarFornecedor.getFornecedor().get(i).getBairro());
        this.getViewFrm().getTxtRua().setText(pi.controller.CadastrarFornecedor.getFornecedor().get(i).getRua());
        this.getViewFrm().getTxtNumero().setText(pi.controller.CadastrarFornecedor.getFornecedor().get(i).getNumero());
        this.getViewFrm().getTxtComplemento().setText(pi.controller.CadastrarFornecedor.getFornecedor().get(i).getComplemento());
        this.getViewFrm().getTxtCep().setText(pi.controller.CadastrarFornecedor.getFornecedor().get(i).getCep());
        this.getViewFrm().getTxtID().setText(Integer.toString(i));
    }

    /**
     * FILTRA FORNECEDOR POR NOME.
     *
     * @param Output
     */
    public void searchRecord(String Output) {
        if (!Output.isEmpty()) {
            String txtOutput = Output.toUpperCase(Locale.ROOT);
            ArrayList<ModelPessoaJuridica> ListaAuxiliar = new ArrayList<>(pi.controller.CadastrarFornecedor.getFornecedor());
            ListaAuxiliar.clear();
            for (int index = 0; index < pi.controller.CadastrarFornecedor.getFornecedor().size(); index++) {
                if (pi.controller.CadastrarFornecedor.getFornecedor().get(index).getCnpj().toUpperCase(Locale.ROOT).contains(txtOutput) || pi.controller.CadastrarFornecedor.getFornecedor().get(index).getCnpj().toUpperCase(Locale.ROOT).contains(txtOutput)) {
                    if (pi.controller.CadastrarFornecedor.getFornecedor().size() > 0) {
                        ListaAuxiliar.add(pi.controller.CadastrarFornecedor.getFornecedor().get(index));
                    }
                }
            }
            setModelJtable(new ModelJTable(ListaAuxiliar));
            this.getViewFrm().getjTableFornecedor().setModel(getModelJtable());
        }
    }

    /**
     * GETTERS E SETTERS *
     */
    private pi.views.FrmCadastrarPJ getViewFrm() {
        return _viewFrm;
    }

    private void setViewFrm(pi.views.FrmCadastrarPJ ViewFrmFornecedor) {
        JtableFornecedor._viewFrm = ViewFrmFornecedor;
    }

    private ModelJTable getModelJtable() {
        return _modelJtable;
    }

    private void setModelJtable(ModelJTable ModelJtable) {
        JtableFornecedor._modelJtable = ModelJtable;
    }
}
