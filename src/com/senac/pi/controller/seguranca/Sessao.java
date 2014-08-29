package com.senac.pi.controller.seguranca;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import com.senac.pi.model.bo.CadastrarUsuario;
import com.senac.pi.model.dao.DaoSessao;
import com.senac.pi.model.vo.ModelLogin;
import com.senac.pi.model.vo.ModelPessoaFisica;
import com.senac.pi.model.vo.ModelSessao;
import com.senac.pi.views.system.FrmMDI;
import com.senac.util.GerarID;
import static com.senac.util.Time.getTime;

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
