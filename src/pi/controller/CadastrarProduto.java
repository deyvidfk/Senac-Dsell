package pi.controller;

import java.util.ArrayList;
import static java.util.Collections.unmodifiableList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.annotation.Resource;
import static javax.swing.JOptionPane.showMessageDialog;
import pi.dao.DaoProduto;
import pi.model.ModelProduto;
import static util.ValidaForm.isValid;

public class CadastrarProduto {

    private static final DaoProduto DAO_PROD = new DaoProduto();
    @SuppressWarnings("unchecked")
    private static final List<ModelProduto> PRODUTO_LIST = DAO_PROD.readXml();
    private static List<ModelProduto> listaAuxiliar;

    public static List<ModelProduto> getProduto() {
        return (PRODUTO_LIST);
    }

    static public void insertIntoXml(List<ModelProduto> data) {
        DAO_PROD.createXml(data);
    }

    public static String searchNome(int id) {
        return getProduto().get(id).getNome();
    }

    public static int searchRecordSize(int idFornecedor) {
        if (!getProduto().isEmpty()) {
            CadastrarProduto.listaAuxiliar = new ArrayList<>(getProduto());
            CadastrarProduto.listaAuxiliar.clear();
            for (int index = 0; index < getProduto().size(); index++) {
                if (getProduto().get(index).getIdFornecedor() == idFornecedor) {
                    if (getProduto().size() > 0) {
                        CadastrarProduto.listaAuxiliar.add(getProduto().get(index));
                    }
                }
            }
            return CadastrarProduto.listaAuxiliar.size();
        }
        return 0;
    }

    public boolean creat(int txtIdFornecedor, String txtNome, String txtCategoria, String txtMarca, String txtModelo, String txtTipo, String txtCor, Double txtPreco, Integer txtDesconto, String txtGarantia) {
        try {
            ModelProduto prod = new ModelProduto();
            int newId = (getProduto().size() - 1) + 1;
            prod.setIdProduto(newId);
            prod.setIdFornecedor(txtIdFornecedor);
            prod.setNome(txtNome);
            prod.setCategoria(txtCategoria);
            prod.setMarca(txtMarca);
            prod.setModelo(txtModelo);
            prod.setTipo(txtTipo);
            prod.setCor(txtCor);
            prod.setPreco(txtPreco);
            prod.setDesconto(txtDesconto);
            prod.setGarantia(txtGarantia);
            prod.setDataFrabricacao("01/01/2000");
            prod.setDataValidade("01/01/2000");
            if (isValid(prod)) {
                getProduto().add(prod);
                insertIntoXml(getProduto());
                return true;
            }
        } catch (Exception e) {
            showMessageDialog(null, e.getMessage());
            getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    public void delete(int id) {
        DAO_PROD.deleteXml(id);
    }

    public void update(int id, String txtNome, String txtMarca, String txtModelo, String txtTipo, String txtCor, Double txtPreco, Integer txtDesconto, String txtGarantia) {
        getProduto().get(id).setNome(txtNome);
        getProduto().get(id).setMarca(txtMarca);
        getProduto().get(id).setModelo(txtModelo);
        getProduto().get(id).setTipo(txtTipo);
        getProduto().get(id).setCor(txtCor);
        getProduto().get(id).setPreco(txtPreco);
        getProduto().get(id).setDesconto(txtDesconto);
        getProduto().get(id).setGarantia(txtGarantia);
        DAO_PROD.updateXml(getProduto());
    }

    public List<ModelProduto> searchRecord(int idFornecedor) {
        try {
            CadastrarProduto.listaAuxiliar = new ArrayList<>(getProduto());
            CadastrarProduto.listaAuxiliar.clear();
            for (int index = 0; index < getProduto().size(); index++) {
                if (getProduto().get(index).getIdFornecedor() == idFornecedor) {
                    if (getProduto().size() > 0) {
                        CadastrarProduto.listaAuxiliar.add(getProduto().get(index));
                    }
                }
            }
        } catch (Exception e) {
            showMessageDialog(null, e.getMessage());
            getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
        }
        return unmodifiableList(CadastrarProduto.listaAuxiliar);
    }

    public List<ModelProduto> searchRecord(String Output, int idFornecedor) {
        try {
            if (!Output.isEmpty()) {
                String txtOutput = Output.toUpperCase(Locale.ROOT);
                CadastrarProduto.listaAuxiliar = new ArrayList<>(getProduto());
                CadastrarProduto.listaAuxiliar.clear();
                for (int index = 0; index < getProduto().size(); index++) {
                    if (getProduto().get(index).getNome().toUpperCase(Locale.ROOT).contains(txtOutput) && getProduto().get(index).getIdFornecedor() == idFornecedor) {

                        if (getProduto().size() > 0) {
                            CadastrarProduto.listaAuxiliar.add(getProduto().get(index));
                        }
                    }
                }
            }
        } catch (Exception e) {
            showMessageDialog(null, e.getMessage());
            getLogger(Resource.class
                    .getName()).log(Level.SEVERE, null, e);
        }
        return unmodifiableList(CadastrarProduto.listaAuxiliar);
    }

    public List<ModelProduto> searchRecordFiltro(String Output, int idFornecedor) {
        try {
            if (!Output.isEmpty()) {
                String txtOutput = Output.toUpperCase(Locale.ROOT);
                CadastrarProduto.listaAuxiliar = new ArrayList<>(getProduto());
                CadastrarProduto.listaAuxiliar.clear();
                for (int index = 0; index < getProduto().size(); index++) {
                    if (getProduto().get(index).getCategoria().toUpperCase(Locale.ROOT).equals(txtOutput) && getProduto().get(index).getIdFornecedor() == idFornecedor) {
                        if (getProduto().size() > 0) {
                            CadastrarProduto.listaAuxiliar.add(getProduto().get(index));
                        }
                    }
                }
            }
        } catch (Exception e) {
            showMessageDialog(null, e.getMessage());
            getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
        }
        return unmodifiableList(CadastrarProduto.listaAuxiliar);
    }
    private static final Logger LOG = getLogger(CadastrarProduto.class.getName());
}
