package pi.dao;

import com.thoughtworks.xstream.XStream;
import static java.util.Collections.unmodifiableList;
import java.util.List;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import pi.model.ModelLogin;

public class DaoLogin implements DaoInterface {

    private static List<ModelLogin> _login;

    public static List<ModelLogin> getLogin() {
        return DaoLogin._login;
    }
    private final Source CONEXAO_DB;
    private final XStream XSTREAM;
    private final String FILE_XML;

    public DaoLogin() {
        this.FILE_XML = "dsell-db-security.xml";
        this.XSTREAM = new XStream();
        this.CONEXAO_DB = new Source();
        DaoLogin._login = readXml();
    }

    @Override
    public void deleteXml(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createXml(List<?> data) {
        CONEXAO_DB.insertXml(this.FILE_XML, data);
    }

    @Override
    public List<ModelLogin> readXml() {
        return (List<ModelLogin>) XSTREAM.fromXML(CONEXAO_DB.readXml(this.FILE_XML));
    }

    @Override
    public void updateXml(List<?> data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static List<ModelLogin> getLogins() {
        return (DaoLogin._login);
    }
    private static final Logger LOG = getLogger(DaoLogin.class.getName());
}
