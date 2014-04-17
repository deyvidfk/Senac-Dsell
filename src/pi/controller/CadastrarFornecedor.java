package pi.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.annotation.Resource;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import static pi.controller.CadastrarProduto.searchRecordSize;
import pi.controller.Jtable.JtableFornecedor;
import pi.dao.DaoPessoaJuridica;
import pi.model.ModelPessoaJuridica;
import static util.ValidaForm.isValid;

public class CadastrarFornecedor extends DaoPessoaJuridica {

    private static final Logger LOG = getLogger(CadastrarFornecedor.class.getName());

    static {
        System.out.println(LOG.getName());
    }

    public CadastrarFornecedor() {
    }

    public int numeroDeRegistros() {
        return getFornecedor().size();
    }

    public boolean creat(ModelPessoaJuridica pj) {
        try {
            int newId = (getFornecedor().size() - 1) + 1;
            pj.setId(newId);
            if (isValid(pj)) {
                getFornecedor().add(pj);
                createXml(getFornecedor());
                return true;
            }
        } catch (Exception e) {
            showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
            getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    /**
     * Excluir registro. As regras de negocio do sistema não permitiram excluir
     * o registro, caso contenha dependências.
     *
     * @param id
     */
    public void delete(int id) {
        try {
            if (searchRecordSize(id) == 0) {
                deleteXml(id);
                /*Exclui o registro da tabela.*/
                JtableFornecedor table = new JtableFornecedor();
                table.deleteRow(id);
            } else {
                /* Exceção!
                 * As regras de negocio do sistema não permitiram excluir o registro, caso contenha dependências. */
                throw new IllegalArgumentException(MensagensDoSistema.SISTEMA.MSG_002_000.getCodigo() + "\n" + MensagensDoSistema.SISTEMA.MSG_002_000.getMenssagem());
            }
        } catch (IllegalArgumentException e) {
            showMessageDialog(null, e.getMessage());
            getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public boolean update(int id, ModelPessoaJuridica pj) {
        if (isValid(pj)) {
            getFornecedor().set(id, pj);
            updateXml(getFornecedor());
            return true;
        }
        return false;
    }

    public ModelPessoaJuridica passagem(int id, String txtCnpj, String txtRazaoSocial, String txtSetorDeAtuacao, String txtTelefone, String txtEmail, String txtSite, String txtCidade, String txtEstado, String txtPais, String txtBairro, String txtRua, String txtNumero, String txtComplemento, String txtCep) {
        ModelPessoaJuridica instancePJ = new ModelPessoaJuridica();
        instancePJ.setId(id);
        instancePJ.setCnpj(txtCnpj);
        instancePJ.setNome(txtRazaoSocial);
        instancePJ.setSetorDeAtuacao(txtSetorDeAtuacao);
        instancePJ.setTelefone(txtTelefone);
        instancePJ.setEmail(txtEmail);
        instancePJ.setSite(txtSite);
        instancePJ.setCidade(txtCidade);
        instancePJ.setEstado(txtEstado);
        instancePJ.setPais(txtPais);
        instancePJ.setBairro(txtBairro);
        instancePJ.setRua(txtRua);
        instancePJ.setNumero(txtNumero);
        instancePJ.setComplemento(txtComplemento);
        instancePJ.setCep(txtCep);
        instancePJ.setTelefone(txtTelefone);
        return instancePJ;
    }
}
