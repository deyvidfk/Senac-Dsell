/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.dao;

import com.thoughtworks.xstream.XStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import static pi.dao.DaoVenda.getVENDAS;
import pi.model.ModelVenda;

/**
 *
 * @author deyvid.fk
 */
public class DaoVenda implements DaoInterface {

    private final static Source CONEXAO_DB = new Source();
    private static List<ModelVenda> _venda;

    /* Busca o registro pelo id da compra. */
    public static List<ModelVenda> searchRecord(int Output) {
        List<ModelVenda> listaAuxiliar = new ArrayList<>(getVENDAS());
        listaAuxiliar.clear();
        for (int index = 0; index < getVENDAS().size(); index++) {
            if (getVENDAS().get(index).getId() == Output) {
                if (getVENDAS().size() > 0) {
                    listaAuxiliar.add(getVENDAS().get(index));
                }
            }
        }
        return listaAuxiliar;
    }

    /* Busca o registro pelo nome do usuário. */
    public static List<ModelVenda> searchRecordByUser(int Output) {
        List<ModelVenda> listaAuxiliar = new ArrayList<>(getVENDAS());
        listaAuxiliar.clear();
        for (int index = 0; index < getVENDAS().size(); index++) {
            if (getVENDAS().get(index).getId() == Output) {
                if (getVENDAS().size() > 0) {
                    listaAuxiliar.add(getVENDAS().get(index));
                }
            }
        }
        return listaAuxiliar;
    }

    public static List<ModelVenda> getVENDAS() {
        return (DaoVenda._venda);
    }
    private final String FILE_XML_PJ;
    private final XStream XSTREAM;

    public DaoVenda() {
        this.XSTREAM = new XStream();
        this.FILE_XML_PJ = "dsell-db-vendas.xml";
        _venda = readXml();
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
        _venda.remove(id);
        updateXml(_venda);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ModelVenda> readXml() {
        return (List) XSTREAM.fromXML(CONEXAO_DB.readXml(this.FILE_XML_PJ));

    }
    private static final Logger LOG = getLogger(DaoVenda.class.getName());
}
