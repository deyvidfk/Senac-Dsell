package com.senac.pi.model.dao;

import com.thoughtworks.xstream.XStream;
import java.util.List;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import com.senac.pi.model.vo.ModelPessoaFisica;

public class DaoPessoaFisica implements DaoInterface {

    private static List<ModelPessoaFisica> _pessoaJuridica;

    public static List<ModelPessoaFisica> getUsuario() {
        return DaoPessoaFisica._pessoaJuridica;
    }

    private final Source CONEXAO_DB;
    private final XStream XSTREAM;
    private final String FILE_XML_PJ;

    public DaoPessoaFisica() {
        this.FILE_XML_PJ = "dsell-db-pessoa-fisica.xml";
        this.XSTREAM = new XStream();
        this.CONEXAO_DB = new Source();
        DaoPessoaFisica._pessoaJuridica = readXml();
    }

    @Override
    public void createXml(List<?> data) {
        CONEXAO_DB.insertXml(this.FILE_XML_PJ, data);
    }

    @Override
    public void updateXml(List<?> data) {
        createXml(data);
    }

    public String getNomePeloId(int id) {
        return _pessoaJuridica.get(id).getNome();
    }

    public ModelPessoaFisica getUserPeloId(int id) {
        return _pessoaJuridica.get(id);
    }

    @Override
    public void deleteXml(int id) {
        _pessoaJuridica.remove(id);
        updateXml(_pessoaJuridica);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ModelPessoaFisica> readXml() {
        return (List<ModelPessoaFisica>) XSTREAM.fromXML(CONEXAO_DB.readXml(this.FILE_XML_PJ));
    }
    private static final Logger LOG = getLogger(DaoPessoaFisica.class.getName());
}
