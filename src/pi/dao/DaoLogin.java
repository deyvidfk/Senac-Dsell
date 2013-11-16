package pi.dao;

import com.thoughtworks.xstream.XStream;
import java.util.List;
import pi.model.ModelLogin;


public class DaoLogin implements DaoInterface {
    
     private static Source CONEXAO_DB = new Source();

    /**
     * @return the CONEXAO_DB
     */
    public static Source getCONEXAO_DB() {
        return CONEXAO_DB;
    }

    /**
     * @param aCONEXAO_DB the CONEXAO_DB to set
     */
    public static void setCONEXAO_DB(Source aCONEXAO_DB) {
        CONEXAO_DB = aCONEXAO_DB;
    }

    /**
     * @return the _login
     */
    public static List<ModelLogin> getLogin() {
        return _login;
    }

    /**
     * @param aLogin the _login to set
     */
    public static void setLogin(List<ModelLogin> aLogin) {
        _login = aLogin;
    }
    private XStream XSTREAM;
    private String FILE_XML_PJ;
    private static List<ModelLogin> _login;

  


    @Override
    public void deleteXml(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the XSTREAM
     */
    public XStream getXSTREAM() {
        return XSTREAM;
    }

    /**
     * @param XSTREAM the XSTREAM to set
     */
    public void setXSTREAM(XStream XSTREAM) {
        this.XSTREAM = XSTREAM;
    }

    /**
     * @return the FILE_XML_PJ
     */
    public String getFILE_XML_PJ() {
        return FILE_XML_PJ;
    }

    /**
     * @param FILE_XML_PJ the FILE_XML_PJ to set
     */
    public void setFILE_XML_PJ(String FILE_XML_PJ) {
        this.FILE_XML_PJ = FILE_XML_PJ;
    }

    @Override
    public void createXml(List<?> data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<?> readXml() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateXml(List<?> data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
