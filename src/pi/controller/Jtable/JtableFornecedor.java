package pi.controller.Jtable;

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
import static pi.dao.DaoPessoaJuridica.getFornecedor;
import pi.model.ModelPessoaJuridica;
import pi.views.FrmCadastrarPJ;
import util.jTable.CellRenderer;
import util.jTable.ModelJTable;

public class JtableFornecedor {

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
            ModelJTable tabela = new ModelJTable(getFornecedor());
            this.getViewFrm().getjTableFornecedor().setModel(tabela);
            this.getViewFrm().getjTableFornecedor().setDefaultRenderer(Object.class, new CellRenderer());
        } catch (Exception e) {
            getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public void updateJtable() {
//        ((ModelJTable) this.getViewFrm().getjTableFornecedor().getModel()).addRow();
    }

    /**
     * ATUALIZA REGISTRO NA LINHA ALTERADA INDICADA PELO ID
     */
    public void updateRow(int i, String txtCnpj, String txtRazaoS, String txtSetorDeAtuacao, String telefone, String email, String site, String cidade, String estado, String pais, String bairro, String rua, String numero, String complemento, String cep) {
        this.getViewFrm().getjTableFornecedor().getModel().setValueAt(txtCnpj, i, 1);
        this.getViewFrm().getjTableFornecedor().getModel().setValueAt(txtRazaoS, i, 2);
        this.getViewFrm().getjTableFornecedor().getModel().setValueAt(txtSetorDeAtuacao, i, 3);
        this.getViewFrm().getjTableFornecedor().getModel().setValueAt(telefone, i, 4);
        this.getViewFrm().getjTableFornecedor().getModel().setValueAt(email, i, 5);
        this.getViewFrm().getjTableFornecedor().getModel().setValueAt(site, i, 6);
        this.getViewFrm().getjTableFornecedor().getModel().setValueAt(cidade, i, 7);
        this.getViewFrm().getjTableFornecedor().getModel().setValueAt(estado, i, 8);
        this.getViewFrm().getjTableFornecedor().getModel().setValueAt(pais, i, 9);
        this.getViewFrm().getjTableFornecedor().getModel().setValueAt(bairro, i, 10);
        this.getViewFrm().getjTableFornecedor().getModel().setValueAt(rua, i, 11);
        this.getViewFrm().getjTableFornecedor().getModel().setValueAt(numero, i, 12);
        this.getViewFrm().getjTableFornecedor().getModel().setValueAt(complemento, i, 13);
        this.getViewFrm().getjTableFornecedor().getModel().setValueAt(cep, i, 14);
    }

    public void deleteRow(int id) {
//        ((ModelJTable) this.getViewFrm().getjTableFornecedor().getModel()).DeleteRow(id);
    }

    /**
     * ORDENA OS REGISTROS DA TABELA POR NOME EM ORDEM ALFABETICA
     */
    public void ordenarPorNome() {
        //ordena pelo nome
        sort(getFornecedor(), new Comparator<ModelPessoaJuridica>() {
            @Override
            public int compare(ModelPessoaJuridica o1, ModelPessoaJuridica o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        });
    }

    public void moveRecord(int i) {
        this.getViewFrm().getTxtRazaoS().setText(getFornecedor().get(i).getNome());
        this.getViewFrm().getTxtCnpj().setText(getFornecedor().get(i).getCnpj());
        this.getViewFrm().getTxtSetorAt().setText(getFornecedor().get(i).getSetorDeAtuacao());
        this.getViewFrm().getTxtTelefone().setText(getFornecedor().get(i).getTelefone());
        this.getViewFrm().getTxtEmail().setText(getFornecedor().get(i).getEmail());
        this.getViewFrm().getTxtSite().setText(getFornecedor().get(i).getSite());
        this.getViewFrm().getTxtCidade().setText(getFornecedor().get(i).getCidade());
        this.getViewFrm().getTxtEstado().setText(getFornecedor().get(i).getEstado());
        this.getViewFrm().getTxtPais().setText(getFornecedor().get(i).getPais());
        this.getViewFrm().getTxtBairro().setText(getFornecedor().get(i).getBairro());
        this.getViewFrm().getTxtRua().setText(getFornecedor().get(i).getRua());
        this.getViewFrm().getTxtNumero().setText(getFornecedor().get(i).getNumero());
        this.getViewFrm().getTxtComplemento().setText(getFornecedor().get(i).getComplemento());
        this.getViewFrm().getTxtCep().setText(getFornecedor().get(i).getCep());
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
            ArrayList<ModelPessoaJuridica> listaAuxiliar = new ArrayList<>();

            for (int index = 0; index < getFornecedor().size(); index++) {
                if (getFornecedor().get(index).getNome().toUpperCase(Locale.ROOT).contains(txtOutput) || getFornecedor().get(index).getCnpj().toUpperCase(Locale.ROOT).contains(txtOutput)) {
                    listaAuxiliar.add(getFornecedor().get(index));
                }
            }
            setModelJtable(new ModelJTable(listaAuxiliar));
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
    private static final Logger LOG = getLogger(JtableFornecedor.class.getName());
}
