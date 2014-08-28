package com.senac.pi.model.dao;

import com.thoughtworks.xstream.XStream;
import java.util.ArrayList;
import static java.util.Collections.sort;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import static com.senac.pi.controller.CadastrarProduto.getProduto;
import static com.senac.pi.model.dao.DaoPessoaJuridica.getFornecedor;
import com.senac.pi.model.vo.ModelPessoaJuridica;

public class DaoPessoaJuridica implements DaoInterface {

    private static List<ModelPessoaJuridica> _pessoaJuridica;

    @SuppressWarnings("unchecked")
    public static List<ModelPessoaJuridica> getFornecedorAtivo() {
        Map<Integer, Integer> map = new HashMap<>();
        int cont;
        if (getFornecedor() != null) {

            for (int i = 0; i < getFornecedor().size(); i++) {
                cont = 0;
                for (int j = 0; j < getProduto().size(); j++) {
                    if (getFornecedor().get(i).getId().equals(getProduto().get(j).getIdFornecedor())) {
                        if (map.containsKey(i)) {
                            map.remove(i);
                            map.put(i, cont++);
                        } else {
                            map.put(i, cont++);
                        }
                    }
                }
                // Atribuindo os produos aos fornecedores;
                getFornecedor().get(i).setQtdProduto(cont);
            }

            List<ModelPessoaJuridica> ListaAuxiliar = new ArrayList<>(getFornecedor());

            for (int i = 0; i < ListaAuxiliar.size(); i++) {
                if (i == ListaAuxiliar.size()) {
                    i--;
                    if (i > ListaAuxiliar.size() && ListaAuxiliar.get(i).getQtdProduto() == 0) {
                        ListaAuxiliar.remove(i);
                    }
                    break;
                }
                while (i < ListaAuxiliar.size() && ListaAuxiliar.get(i).getQtdProduto() == 0) {
                    ListaAuxiliar.remove(i);
                }
                if (i > ListaAuxiliar.size()) {
                    ListaAuxiliar.get(i).setQuant(ListaAuxiliar.size());
                }
            }

            /* Ordena os fornecedores pela quantidade de produtos, em ordem decrescente. */
            sort(ListaAuxiliar, new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    ModelPessoaJuridica p1 = (ModelPessoaJuridica) o1;
                    ModelPessoaJuridica p2 = (ModelPessoaJuridica) o2;
                    return p1.getQtdProduto() < p2.getQtdProduto() ? +1 : (p1.getQtdProduto() > p2.getQtdProduto() ? -1 : 0);
                }
            });
            return ListaAuxiliar;
        }
        return null;
    }

    /**
     * Lista de fornecedores inativos (Fornecedores sem produtos cadastrados no
     * sistema).
     *
     * @return
     */
    public static List<ModelPessoaJuridica> getForInativos() {
        Map<Integer, Integer> map = new HashMap<>();
        int cont;
        for (int i = 0; i < getFornecedor().size(); i++) {
            cont = 0;
            for (int j = 0; j < getProduto().size(); j++) {
                if (getFornecedor().get(i).getId().equals(getProduto().get(j).getIdFornecedor())) {
                    if (map.containsKey(i)) {
                        map.remove(i);
                        map.put(i, cont++);
                    } else {
                        map.put(i, cont++);
                    }
                }
            }
            // Atribuindo os produos aos fornecedores;
            getFornecedor().get(i).setQtdProduto(cont);
        }

        List<ModelPessoaJuridica> listaAuxiliar = new ArrayList<>(getFornecedor());

        for (int i = 0; i < listaAuxiliar.size(); i++) {
            if (i == listaAuxiliar.size()) {
                i--;
                if (listaAuxiliar.get(i).getQtdProduto() > 0) {
                    listaAuxiliar.remove(i);
                }
                break;
            }

            while (i < listaAuxiliar.size() && listaAuxiliar.get(i).getQtdProduto() > 0) {
                listaAuxiliar.remove(i);
            }

            if (i > listaAuxiliar.size()) {
                listaAuxiliar.get(i).setQuant(listaAuxiliar.size());
            }
        }
        // Ordena os fornecedores pela quantidade de produtos em ordem decrescente.
        sort(listaAuxiliar, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                ModelPessoaJuridica p1 = (ModelPessoaJuridica) o1;
                ModelPessoaJuridica p2 = (ModelPessoaJuridica) o2;
                return p1.getQtdProduto() < p2.getQtdProduto() ? +1 : (p1.getQtdProduto() > p2.getQtdProduto() ? -1 : 0);
            }
        });
        return listaAuxiliar;
    }

    /**
     * Buscar registro por nome ou cnpj.
     *
     *
     * @param Output
     * @return
     */
    public static List<ModelPessoaJuridica> searchRecord(String Output) {
        ArrayList<ModelPessoaJuridica> ListaAuxiliar = new ArrayList<>(getFornecedor());
        if (!Output.isEmpty()) {
            String txtOutput = Output.toUpperCase(Locale.ROOT);

            ListaAuxiliar.clear();
            for (int index = 0; index < getFornecedor().size(); index++) {
                if (getFornecedor().get(index).getCnpj().toUpperCase(Locale.ROOT).contains(txtOutput) || getFornecedor().get(index).getCnpj().toUpperCase(Locale.ROOT).contains(txtOutput)) {
                    if (getFornecedor().size() > 0) {
                        ListaAuxiliar.add(getFornecedor().get(index));
                    }
                }
            }
        }
        return ListaAuxiliar;
    }

    public static List<ModelPessoaJuridica> getFornecedor() {
        return (DaoPessoaJuridica._pessoaJuridica);
    }

    private final Source CONEXAO_DB;
    private final String FILE_XML;
    private final XStream XSTREAM;

    public DaoPessoaJuridica() {
        this.FILE_XML = "dsell-db-pessoa-juridica.xml";
        this.XSTREAM = new XStream();
        this.CONEXAO_DB = new Source();
        DaoPessoaJuridica._pessoaJuridica = readXml();
    }

    @Override
    public void createXml(List<?> data) {
        CONEXAO_DB.insertXml(this.FILE_XML, data);
    }

    @Override
    public void updateXml(List<?> data) {
        createXml(data);
    }

    @Override
    public void deleteXml(int id) {
        _pessoaJuridica.remove(id);
        createXml(_pessoaJuridica);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ModelPessoaJuridica> readXml() {
        return (List<ModelPessoaJuridica>) XSTREAM.fromXML(CONEXAO_DB.readXml(this.FILE_XML));
    }
    private static final Logger LOG = getLogger(DaoPessoaJuridica.class.getName());
}
