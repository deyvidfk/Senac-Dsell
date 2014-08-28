package com.senac.pi.model.dao;

import com.thoughtworks.xstream.XStream;
import java.util.List;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import com.senac.pi.model.vo.ModelModuloAcesso;
import com.senac.pi.model.vo.ModelPessoaFisica;

public class DaoModuloAcesso implements DaoInterface {

    private static List<ModelModuloAcesso> _moduloAcesso;

    private final Source CONEXAO_DB;
    private final XStream XSTREAM;
    private final String FILE_XML;

    public DaoModuloAcesso() {
        this.FILE_XML = "dsell-db-pessoa-fisica-modulo-acesso.xml";
        this.XSTREAM = new XStream();
        this.CONEXAO_DB = new Source();
        _moduloAcesso = (List<ModelModuloAcesso>) readXml();
    }

    @Override
    public void createXml(List<?> data) {
        CONEXAO_DB.insertXml(this.FILE_XML, data);
    }

    @Override
    public List<?> readXml() {
        return (List<ModelPessoaFisica>) XSTREAM.fromXML(CONEXAO_DB.readXml(this.FILE_XML));
    }

    @Override
    public void updateXml(List<?> data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteXml(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private static final Logger LOG = getLogger(DaoModuloAcesso.class.getName());
}
