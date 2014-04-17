package pi.controller;

import static java.util.UUID.randomUUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.annotation.Resource;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import pi.dao.DaoPessoaFisica;
import pi.model.ModelPessoaFisica;
import static util.ValidaForm.isValid;

public class CadastrarUsuario extends DaoPessoaFisica {

    private static final Logger LOG = getLogger(CadastrarUsuario.class.getName());

    public boolean creat(String cnpj, String txtRg, String txtCpf, String telefone, String email, String site, String cidade, String estado, String pais, String bairro, String rua, String numero, String complemento, String cep) {

        try {

            String newId = randomUUID().toString();
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

            if (isValid(pj)) {
                getUsuario().add(pj);
                createXml(getUsuario());
                return true;
            }

        } catch (Exception e) {
            showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
            getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    public int numeroDeRegistros() {
        return getUsuario().size();
    }

    public void delete(int id) {
        deleteXml(id);
    }

    public boolean update(String id, String txtNome, String txtRg, String txtCpf, String txtTelefone, String txtEmail, String txtSite, String txtCidade, String txtEstado, String txtPais, String txtBairro, String txtRua, String txtNumero, String txtComplemento, String txtCep) {
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

            if (isValid(pj)) {
                int indice = obterIndice(id);
                getUsuario().get(indice).setNome(pj.getNome());
                getUsuario().get(indice).setRg(pj.getRg());
                getUsuario().get(indice).setCpf(pj.getCpf());
                getUsuario().get(indice).setTelefone(pj.getTelefone());
                getUsuario().get(indice).setEmail(pj.getEmail());
                getUsuario().get(indice).setSite(pj.getSite());
                getUsuario().get(indice).setCidade(pj.getCidade());
                getUsuario().get(indice).setEstado(pj.getEstado());
                getUsuario().get(indice).setPais(pj.getPais());
                getUsuario().get(indice).setBairro(pj.getBairro());
                getUsuario().get(indice).setRua(pj.getRua());
                getUsuario().get(indice).setNumero(pj.getNumero());
                getUsuario().get(indice).setComplemento(pj.getComplemento());
                getUsuario().get(indice).setCep(pj.getCep());
                updateXml(getUsuario());
                return true;
            }

        } catch (Exception e) {
            showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
            getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    private int obterIndice(String id) {
        for (int i = 0; i < getUsuario().size(); i++) {
            if (getUsuario().get(i).getId().equals(id)) {
                return i;
            }
        }
        return 0;
    }
}
