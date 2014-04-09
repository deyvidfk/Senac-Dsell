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
import pi.controller.MensagensDoSistema;
import pi.controller.seguranca.ModuloAcesso;
import pi.controller.seguranca.Sessao;
import pi.dao.DaoPessoaFisica;
import static pi.dao.DaoPessoaFisica.getUsuario;
import pi.model.ModelLogin;
import pi.model.ModelPessoaFisica;
import pi.views.system.Menu;

public class UserDefault extends DaoPessoaFisica {

    private static final Logger LOG = getLogger(UserDefault.class.getName());
    private String USER_LOGIN_DEFAULT = "adm";
    private String USER_SENHA_DEFAULT = "adm";

    static {
        System.out.println(LOG.getName());
    }

    public UserDefault() {
    }

    public boolean getStatusSistema() {
        return !getUsuario().isEmpty();
    }

    public void criaDadosDoUsuarioDefault() {
        try {
            ModelPessoaFisica ps = new ModelPessoaFisica();
            ps.setId(0);
            ps.setNome("ADM");
            ps.setRg("12.123.123-1");
            ps.setCpf("000.000.000-00");
            ps.setTelefone("(11) 0000-0000");
            ps.setEmail("exemplo@exemplo.com");
            ps.setSite("exemplo.com.br");
            ps.setCidade("São Paulo");
            ps.setEstado("SP");
            ps.setPais("Brasil");
            ps.setBairro("JD");
            ps.setRua("Rua");
            ps.setNumero("0");
            ps.setComplemento("complem.");
            ps.setCep("04872-290");

            ModelLogin login = new ModelLogin();
            login.setId(0);
            login.setUsername(USER_LOGIN_DEFAULT);
            login.setPass(USER_SENHA_DEFAULT);

            getUsuario().add(ps);
            createXml(getUsuario());

            CadastrarLogin cadastro = new CadastrarLogin();
            cadastro.creat(login);

            List menu = new ArrayList<>();
            menu.add(Menu.SISTEMA);
            menu.add(Menu.CADASTRO_GERAL);
            ModuloAcesso moduloAcesso = new ModuloAcesso();
            moduloAcesso.addModuloAcesso(ps.getId(), menu);
        } catch (GeneralSecurityException | UnsupportedEncodingException ex) {
        }
    }

    public void criaUsuarioDefault() {
        criaDadosDoUsuarioDefault();
        CadastrarLogin login = new CadastrarLogin();
        ModelLogin loginCallBack = login.autenticaLogin(USER_LOGIN_DEFAULT, USER_SENHA_DEFAULT);
        if (loginCallBack != null) {
            Sessao sessao = new Sessao(loginCallBack);
            sessao.newSessao();
        }
        showMessageDialog(null, MensagensDoSistema.SISTEMA.MSG_000_0.getCodigo() + "\n" + MensagensDoSistema.SISTEMA.MSG_000_0.getMenssagem());
    }
}
