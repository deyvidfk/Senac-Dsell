package pi.controller;

import pi.dao.DaoPessoaFisica;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.swing.JOptionPane;
import util.ValidaForm;
import pi.model.ModelPessoaFisica;

public final class CadastrarUsuario extends DaoPessoaFisica {

    public boolean creat(String cnpj, String txtRg, String txtCpf, String telefone, String email, String site, String cidade, String estado, String pais, String bairro, String rua, String numero, String complemento, String cep) {

        try {
            int newId = (getUsuario().size() - 1) + 1;
            ModelPessoaFisica pj = new ModelPessoaFisica();
            pj.setId(newId);
            pj.setNome(cnpj);
            pj.setRg(txtRg);
            pj.setCpf(txtCpf);
            pj.setTelefone(telefone);
            pj.setEmail(email);
            pj.setSite(site);
            pj.setCidade(cidade);
            pj.setEstado(estado);
            pj.setPais(pais);
            pj.setBairro(bairro);
            pj.setRua(rua);
            pj.setNumero(numero);
            pj.setComplemento(complemento);
            pj.setCep(cep);
            pj.setTelefone(telefone);

            if (ValidaForm.isValid(pj)) {
                getUsuario().add(pj);
                createXml(getUsuario());
                return true;
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    public int numeroDeRegistros() {
        return getUsuario().size();
    }

    public void delete(int id) {
        deleteXml(id);
    }

    public boolean update(int id, String txtNome, String txtRg, String txtCpf, String txtTelefone, String txtEmail, String txtSite, String txtCidade, String txtEstado, String txtPais, String txtBairro, String txtRua, String txtNumero, String txtComplemento, String txtCep) {
        try {
            ModelPessoaFisica pj = new ModelPessoaFisica();
            pj.setId(id);
            pj.setNome(txtNome);
            pj.setRg(txtRg);
            pj.setCpf(txtCpf);
            pj.setTelefone(txtTelefone);
            pj.setEmail(txtEmail);
            pj.setSite(txtSite);
            pj.setCidade(txtCidade);
            pj.setEstado(txtEstado);
            pj.setPais(txtPais);
            pj.setBairro(txtBairro);
            pj.setRua(txtRua);
            pj.setNumero(txtNumero);
            pj.setComplemento(txtComplemento);
            pj.setCep(txtCep);


            if (ValidaForm.isValid(pj)) {
                getUsuario().get(id).setNome(pj.getNome());
                getUsuario().get(id).setRg(pj.getRg());
                getUsuario().get(id).setCpf(pj.getCpf());
                getUsuario().get(id).setTelefone(pj.getTelefone());
                getUsuario().get(id).setEmail(pj.getEmail());
                getUsuario().get(id).setSite(pj.getSite());
                getUsuario().get(id).setCidade(pj.getCidade());
                getUsuario().get(id).setEstado(pj.getEstado());
                getUsuario().get(id).setPais(pj.getPais());
                getUsuario().get(id).setBairro(pj.getBairro());
                getUsuario().get(id).setRua(pj.getRua());
                getUsuario().get(id).setNumero(pj.getNumero());
                getUsuario().get(id).setComplemento(pj.getComplemento());
                getUsuario().get(id).setCep(pj.getCep());
                updateXml(getUsuario());
                return true;
            }



        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
}
