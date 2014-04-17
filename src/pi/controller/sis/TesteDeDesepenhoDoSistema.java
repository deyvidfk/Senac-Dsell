package pi.controller.sis;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.annotation.Resource;
import static javax.swing.JOptionPane.showMessageDialog;
import pi.controller.CadastrarFornecedor;
import pi.controller.CadastrarProduto;
import static pi.controller.CadastrarProduto.getProduto;
import pi.controller.CadastrarUsuario;
import pi.controller.CadastrarVenda;
import pi.controller.MensagensDoSistema;
import static pi.dao.DaoPessoaFisica.getUsuario;
import static pi.dao.DaoPessoaJuridica.getFornecedor;
import pi.model.ModelPessoaJuridica;
import util.GeraString;
import util.GerarID;

public class TesteDeDesepenhoDoSistema {

    private static final GeraString instanceControllerGerarString = new GeraString();
    private CadastrarUsuario instanceControllerCadastrarUsuario;
    private CadastrarFornecedor instanceControllerCadastrarFornecedor;
    private CadastrarProduto instanceControllerCadastrarPrdoduto;
    private CadastrarVenda instanceControllerCadastrarVendas;

    /**
     * Cria usuários aleatórios no sistema.
     *
     * @param valor
     * @return
     */
    public boolean creatUser(int valor) {
        try {
            instanceControllerCadastrarUsuario = new CadastrarUsuario();
            for (int i = 0; i <= valor; i++) {

                boolean cr = instanceControllerCadastrarUsuario.creat(
                        instanceControllerGerarString.getNomeQualquer(),
                        instanceControllerGerarString.getRg(),
                        instanceControllerGerarString.getCpf(),
                        instanceControllerGerarString.getTelefoneQualquer(),
                        instanceControllerGerarString.getEmail(),
                        instanceControllerGerarString.getStringQualquer(),
                        instanceControllerGerarString.getCidadeQualquer(),
                        instanceControllerGerarString.getStringQualquer(),
                        instanceControllerGerarString.getStringQualquer(),
                        instanceControllerGerarString.getStringQualquer(),
                        instanceControllerGerarString.getStringQualquer(),
                        instanceControllerGerarString.getStringQualquer(),
                        instanceControllerGerarString.getStringQualquer(),
                        instanceControllerGerarString.getCep());
            }
            return true;
        } catch (Exception e) {
            showMessageDialog(null, e.getMessage());
            getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    /**
     * Cria fornecedores aleatórios no sistema.
     *
     * @param valor
     * @return
     */
    public boolean creatFornecedor(int valor) {
        try {
            instanceControllerCadastrarFornecedor = new CadastrarFornecedor();
            for (int i = 0; i <= valor; i++) {
                ModelPessoaJuridica passagem = instanceControllerCadastrarFornecedor.passagem(
                        new GerarID().getId(),
                        instanceControllerGerarString.getCnpj(),
                        instanceControllerGerarString.getEmpresaQualquer(),
                        instanceControllerGerarString.getStringQualquer(),
                        instanceControllerGerarString.getTelefoneQualquer(),
                        instanceControllerGerarString.getEmail(),
                        instanceControllerGerarString.getStringQualquer(),
                        instanceControllerGerarString.getCidadeQualquer(),
                        instanceControllerGerarString.getStringQualquer(),
                        instanceControllerGerarString.getStringQualquer(),
                        instanceControllerGerarString.getStringQualquer(),
                        instanceControllerGerarString.getStringQualquer(),
                        instanceControllerGerarString.getStringQualquer(),
                        instanceControllerGerarString.getStringQualquer(),
                        instanceControllerGerarString.getCep());
                instanceControllerCadastrarFornecedor.creat(passagem);
            }
            return true;
        } catch (Exception e) {
            showMessageDialog(null, e.getMessage());
            getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);

        }
        return false;
    }

    public boolean creatProduto(int valor) {
        try {
            if (getFornecedor() != null && getFornecedor().size() > 0) {
                Random ramdom = new Random();

                instanceControllerCadastrarPrdoduto = new CadastrarProduto();
                for (int i = 0; i <= valor; i++) {
                    int id = ramdom.nextInt(getFornecedor().size());
                    instanceControllerCadastrarPrdoduto.creat(
                            getFornecedor().get(id).getId(),
                            instanceControllerGerarString.getNomePordutoQualquer(),
                            instanceControllerGerarString.getStringQualquer(),
                            instanceControllerGerarString.getStringQualquer(),
                            instanceControllerGerarString.getStringQualquer(),
                            instanceControllerGerarString.getStringQualquer(),
                            instanceControllerGerarString.getStringQualquer(),
                            instanceControllerGerarString.getPrecoQualquer(),
                            instanceControllerGerarString.getDescontoQualquer(),
                            instanceControllerGerarString.getStringQualquer());
                }
                return true;
            } else {
                throw new IllegalArgumentException(MensagensDoSistema.SISTEMA.MSG_001_000.getCodigo() + "\n" + MensagensDoSistema.SISTEMA.MSG_001_000.getMenssagem());
            }
        } catch (IllegalArgumentException e) {
            showMessageDialog(null, e.getMessage());
            getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    /**
     * Cria produtos aleatórios no sistema.
     *
     * @param valor
     * @return
     */
    public boolean criarVendaAleatoria(int valor) {
        try {
            if (getUsuario().size() > 0 && getProduto().size() > 0) {
                instanceControllerCadastrarVendas = new CadastrarVenda();
                Random ramdom = new Random();
                for (int i = 0; i < valor; i++) {
                    instanceControllerCadastrarVendas.cadastrar(
                            ramdom.nextInt(ramdom.nextInt(getProduto().size()) + 1),
                            ramdom.nextInt(ramdom.nextInt(getUsuario().size()) + 1),
                            instanceControllerGerarString.getPrecoQualquer(),
                            instanceControllerGerarString.getDescontoQualquer());
                }
                return true;
            } else {
                throw new IllegalArgumentException(MensagensDoSistema.SISTEMA.MSG_001_001.getCodigo() + "\n" + MensagensDoSistema.SISTEMA.MSG_001_001.getMenssagem());
            }
        } catch (IllegalArgumentException e) {
            showMessageDialog(null, e.getMessage());
            getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    private static final Logger LOG = getLogger(TesteDeDesepenhoDoSistema.class.getName());
}
