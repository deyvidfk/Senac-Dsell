package com.senac.pi.controller.sis;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import static javax.swing.JOptionPane.showMessageDialog;
import com.senac.pi.model.bo.AutenticarAcessoAoSistema;
import com.senac.pi.controller.CadastrarLogin;
import com.senac.pi.model.bo.MensagensDoSistema;
import com.senac.pi.controller.seguranca.ModuloAcesso;
import com.senac.pi.controller.seguranca.Sessao;
import com.senac.pi.model.dao.DaoPessoaFisica;
import static com.senac.pi.model.dao.DaoPessoaFisica.getUsuario;
import com.senac.pi.model.vo.ModelLogin;
import com.senac.pi.model.vo.ModelPessoaFisica;
import com.senac.pi.views.system.Menu;
import com.senac.util.GerarID;

public class UserDefault extends DaoPessoaFisica {

    private static final Logger LOG = getLogger(UserDefault.class.getName());
    private final String USER_LOGIN_DEFAULT = "adm";
    private final String USER_SENHA_DEFAULT = "adm";
    private final String USER_ID_DEFAULT = new GerarID().getId();

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
            ps.setId(USER_ID_DEFAULT);
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
            login.setId(USER_ID_DEFAULT);
            login.setUsername(USER_LOGIN_DEFAULT);
            login.setPass(USER_SENHA_DEFAULT);

            getUsuario().add(ps);
            createXml(getUsuario());

            CadastrarLogin cadastro = new CadastrarLogin();
            cadastro.cadastrar(login);

            List menu = new ArrayList<>();
            menu.add(Menu.SISTEMA);
            menu.add(Menu.CADASTRO_GERAL);
            menu.add(Menu.CADASTRO);
            menu.add(Menu.RELATORIO_GERAL);
            menu.add(Menu.RELATORIO);
            menu.add(Menu.CONSULTA);
            ModuloAcesso moduloAcesso = new ModuloAcesso();
            moduloAcesso.addModuloAcesso(ps.getId(), menu);
        } catch (GeneralSecurityException | UnsupportedEncodingException ex) {
        }
    }

    public void criaUsuarioDefault() {
        criaDadosDoUsuarioDefault();
        AutenticarAcessoAoSistema login = new AutenticarAcessoAoSistema();
        ModelLogin loginCallBack = login.autenticaLogin(USER_LOGIN_DEFAULT, USER_SENHA_DEFAULT);
        if (loginCallBack != null) {
            Sessao sessao = new Sessao(loginCallBack);
            sessao.newSessao();

        }

        showMessageDialog(null, MensagensDoSistema.SISTEMA.MSG_000_0.getCodigo() + "\n" + MensagensDoSistema.SISTEMA.MSG_000_0.getMenssagem());
    }
}
