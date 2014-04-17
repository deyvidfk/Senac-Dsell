package pi.dao;

import com.thoughtworks.xstream.XStream;
import java.util.List;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import pi.model.ModelSessao;

public final class DaoSessao implements DaoInterface {

    private static List<ModelSessao> _sessao;

    private final Source CONEXAO_DB;
    private final XStream XSTREAM;
    private final String FILE_XML;

    public DaoSessao() {
        this.FILE_XML = "dsell-db-sessao.xml";
        this.XSTREAM = new XStream();
        this.CONEXAO_DB = new Source();
        _sessao = readXml();
    }

    @Override
    public void createXml(List<?> data) {
        CONEXAO_DB.insertXml(this.FILE_XML, data);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ModelSessao> readXml() {
        return (List<ModelSessao>) XSTREAM.fromXML(CONEXAO_DB.readXml(this.FILE_XML));
    }

    @Override
    public void updateXml(List<?> data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteXml(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private static final Logger LOG = getLogger(DaoSessao.class.getName());
}
