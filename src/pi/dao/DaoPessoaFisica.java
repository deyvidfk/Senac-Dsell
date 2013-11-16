package pi.dao;

import com.thoughtworks.xstream.XStream;
import java.util.List;
import pi.model.ModelPessoaFisica;

/**
 *
 * @author deyvid.fk
 */
public class DaoPessoaFisica implements DaoInterface {

    private final Source CONEXAO_DB;
    private final XStream XSTREAM;
    private final String FILE_XML_PJ;
    private static List<ModelPessoaFisica> _pessoaJuridica;

    public DaoPessoaFisica() {
        this.FILE_XML_PJ = "db.pessoa-fisica.xml";
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

    @Override
    public void deleteXml(int id) {
        _pessoaJuridica.remove(id);
        updateXml(_pessoaJuridica);
    }

    @Override
    @SuppressWarnings("unchecked")
    public final List<ModelPessoaFisica> readXml() {
        return (List<ModelPessoaFisica>) XSTREAM.fromXML(CONEXAO_DB.readXml(this.FILE_XML_PJ));
    }

    public static List<ModelPessoaFisica> getUsuario() {
        return DaoPessoaFisica._pessoaJuridica;
    }
}
