package com.senac.pi.dao;

import com.thoughtworks.xstream.XStream;
import java.util.List;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import com.senac.pi.model.ModelProduto;

public final class DaoProduto implements DaoInterface {

    private static List<ModelProduto> _produto;

    private final Source CONEXAO_DB;
    private final String FILE_XML_PJ;
    private final XStream XSTREAM;

    public DaoProduto() {
        this.XSTREAM = new XStream();
        this.FILE_XML_PJ = "dsell-db-produto.xml";
        this.CONEXAO_DB = new Source();
        DaoProduto._produto = readXml();
    }

    @Override
    public void createXml(List<?> data) {
        CONEXAO_DB.insertXml(this.FILE_XML_PJ, data);
    }

    @Override
    public void updateXml(List<?> data) {
        createXml(data);
    }

    @Override
    public void deleteXml(int id) {
        _produto.remove(id);
        updateXml(_produto);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ModelProduto> readXml() {
        return (List) XSTREAM.fromXML(CONEXAO_DB.readXml(this.FILE_XML_PJ));
    }
    private static final Logger LOG = getLogger(DaoProduto.class.getName());
}
