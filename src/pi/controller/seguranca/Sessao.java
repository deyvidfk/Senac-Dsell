package pi.controller.seguranca;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import pi.controller.CadastrarUsuario;
import pi.dao.DaoSessao;
import pi.model.ModelLogin;
import pi.model.ModelPessoaFisica;
import pi.model.ModelSessao;
import pi.views.system.FrmMDI;
import util.GerarID;
import static util.Time.getTime;

public class Sessao {

    private ModelPessoaFisica user;
    private ModelSessao sessao;
    private static DaoSessao dao;
    private final List<ModelSessao> list;
    private final ModelLogin dataLogin;

    public Sessao(ModelLogin login) {
        list = new ArrayList<>();
        dataLogin = login;
    }

    public void newSessao() {
        ModuloAcesso acesso = new ModuloAcesso();
        CadastrarUsuario cad = new CadastrarUsuario();
        user = cad.getUserPeloId(0);
        sessao = new ModelSessao();
        sessao.setIdSessao(new GerarID().getId());
        sessao.setUser(user);
        sessao.setHora(getTime());
        list.add(sessao);
        dao = new DaoSessao();
        dao.createXml(list);
        FrmMDI frmMdi;
        try {
            frmMdi = new FrmMDI(acesso.getModuloAcesso(user.getId()));
            frmMdi.pack();
            frmMdi.setVisible(true);
            frmMdi.setLocationRelativeTo(null);
        } catch (IllegalArgumentException ex) {
            getLogger(Sessao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<ModelSessao> getSessao() {
        dao = new DaoSessao();
        return dao.readXml();
    }
    private static final Logger LOG = getLogger(Sessao.class.getName());
}
