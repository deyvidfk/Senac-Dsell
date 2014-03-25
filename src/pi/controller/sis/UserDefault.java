/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.controller.sis;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import static javax.swing.JOptionPane.showMessageDialog;
import pi.controller.CadastrarLogin;
import pi.controller.seguranca.ModuloAcesso;
import pi.controller.seguranca.Sessao;
import pi.dao.DaoPessoaFisica;
import static pi.dao.DaoPessoaFisica.getUsuario;
import pi.model.ModelLogin;
import pi.model.ModelPessoaFisica;
import pi.views.system.Menu;

public class UserDefault extends DaoPessoaFisica {

    private static final Logger LOG = getLogger(UserDefault.class.getName());

    static {
        System.out.println(LOG.getName());
    }

    public boolean getStatusSistema() {
        return getUsuario().size() != 0;
    }

    public void creatUserDefault() {

        ModelPessoaFisica ps = new ModelPessoaFisica();
        ps.setId(0);
        ps.setNome("ADM");
        ps.setRg("12.123.123-1");
        ps.setCpf("000.000.000-00");
        ps.setTelefone("(11) 0000-0000");
        ps.setEmail("exemplo@exemplo.com");
        ps.setSite("exemplo.com.br");
        ps.setCidade("Sao Paulo");
        ps.setEstado("Sao Paulo");
        ps.setPais("Brasil");
        ps.setBairro("JD");
        ps.setRua("Rua");
        ps.setNumero("0");
        ps.setComplemento("complem.");
        ps.setCep("04872-290");

        ModelLogin login = new ModelLogin();
        CadastrarLogin cadastro = new CadastrarLogin();
        ModuloAcesso moduloAcesso = new ModuloAcesso();
        login.setId(0);
        login.setUsername("ADM");
        try {
            login.setPass("ADM");

            getUsuario().add(ps);
            createXml(getUsuario());
            cadastro.creat(login);

            List menu = new ArrayList<>();
            menu.add(Menu.SISTEMA);
            moduloAcesso.addModuloAcesso(ps.getId(), menu);

            showMessageDialog(null, "Configurao Default do sistema criada com sucesso. Para seguranca do sistema altere a senha padrao 'ADM'para uma senha de sua escolha. Atencao, os menus estao desativados. Ativeos e faca o login novamente. ");
        } catch (GeneralSecurityException | UnsupportedEncodingException ex) {
        }
    }

    public void creatConfigDefault() {
        creatUserDefault();
        CadastrarLogin login = new CadastrarLogin();
        ModelLogin _callback = login.loginAuthentication("ADM", "ADM");
        if (_callback != null) {
            Sessao sessao = new Sessao(_callback);
            sessao.newSessao();
        }
    }

}
