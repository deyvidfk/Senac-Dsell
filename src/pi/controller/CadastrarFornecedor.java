package pi.controller;

import pi.dao.DaoPessoaJuridica;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.swing.JOptionPane;
import pi.controller.Jtable.JtableFornecedor;
import util.ValidaForm;
import pi.model.ModelPessoaJuridica;

public class CadastrarFornecedor extends DaoPessoaJuridica {

    public CadastrarFornecedor() {
    }

    /**
     * Cadastrar fornecedor.
     *
     * @param txtCnpj
     * @param txtRazaoSocial
     * @param txtSetorDeAtuacao
     * @param txtTelefone
     * @param txtEmail
     * @param txtSite
     * @param txtCidade
     * @param txtEstado
     * @param txtPais
     * @param txtBairro
     * @param txtRua
     * @param txtNumero
     * @param txtComplemento
     * @param txtCep
     * @return
     */
    public boolean creat(ModelPessoaJuridica pj) {
        try {
            int newId = (CadastrarFornecedor.getFornecedor().size() - 1) + 1;
            pj.setId(newId);
            if (ValidaForm.isValid(pj)) {
                getFornecedor().add(pj);
                createXml(getFornecedor());
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
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
            if (CadastrarProduto.searchRecordSize(id) == 0) {
                deleteXml(id);
                /*Exclui o registro da tabela.*/
                JtableFornecedor table = new JtableFornecedor();
                table.deleteRow(id);
            } else {
                /* Exceção!
                 * As regras de negocio do sistema não permitiram excluir o registro, caso contenha dependências. */
                throw new IllegalArgumentException("Você não pode excluir este fornecedor, pois existem dependencências.  Ele cotem produtos cadastrados no sistema.");
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            Logger.getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Atualizar registro.
     *
     * @param id
     * @param txtCnpj
     * @param txtRazaoS
     * @param txtSetorDeAtuacao
     * @param txtTelefone
     * @param txtEmail
     * @param txtSite
     * @param txtCidade
     * @param txtEstado
     * @param txtPais
     * @param txtBairro
     * @param txtRua
     * @param txtNumero
     * @param txtComplemento
     * @param txtCep
     */
    public boolean update(int id, ModelPessoaJuridica pj) {
        if (ValidaForm.isValid(pj)) {
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
