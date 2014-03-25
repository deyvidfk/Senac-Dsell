package pi.controller.seguranca;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import static java.util.UUID.randomUUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import pi.controller.CadastrarUsuario;
import pi.dao.DaoSessao;
import pi.model.ModelLogin;
import pi.model.ModelPessoaFisica;
import pi.model.ModelSessao;
import pi.views.system.FrmMDI;
import static util.Time.getTime;

public class Sessao {

    private static ModelPessoaFisica user;
    private static ModelSessao sessao;
    private static DaoSessao dao;
    private static List<ModelSessao> list;

    public static List<ModelSessao> getSessao() {
        dao = new DaoSessao();
        return dao.readXml();
    }
    private final ModelLogin dataLogin;

    public Sessao(ModelLogin login) {
        list = new ArrayList<>();
        dataLogin = login;
    }

    public void newSessao() {
        //user = new ModelPessoaFisica();
        ModuloAcesso acesso = new ModuloAcesso();
        CadastrarUsuario cad = new CadastrarUsuario();
        user = cad.getUserPeloId(this.dataLogin.getId());
        sessao = new ModelSessao();
        sessao.setIdSessao(randomUUID().toString());
        sessao.setUser(user);
        sessao.setHora(getTime().toString());
        list.add(sessao);
        dao = new DaoSessao();
        dao.createXml(list);
        FrmMDI frmMdi;
        try {
            frmMdi = new FrmMDI(acesso.getModuloAcesso(this.dataLogin.getId()));
            frmMdi.pack();
            frmMdi.setVisible(true);
            frmMdi.setLocationRelativeTo(null);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | IllegalArgumentException | InvocationTargetException ex) {
            getLogger(Sessao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static final Logger LOG = getLogger(Sessao.class.getName());
}
