package pi.controller;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.swing.JOptionPane;
import pi.model.ModelPessoaJuridica;
import util.GeraString;

/**
 *
 * @author deyvid.fk
 */
public class TesteDeDesepenhoDoSistema {

    private CadastrarUsuario instanceControllerCadastrarUsuario;
    private CadastrarFornecedor instanceControllerCadastrarFornecedor;
    private CadastrarProduto instanceControllerCadastrarPrdoduto;
    private CadastrarVenda instanceControllerCadastrarVendas;
    private static final GeraString instanceControllerGerarString = new GeraString();

    /**
     * Cria usuários aleatórios no sistema.
     *
     * @param valor
     * @return
     */
    public boolean creatUser(int valor) {
        try {
            instanceControllerCadastrarUsuario = new CadastrarUsuario();
            for (int i = 0; i < valor; i++) {

                instanceControllerCadastrarUsuario.creat(
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
            JOptionPane.showMessageDialog(null, e.getMessage());
            Logger.getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
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
                        -1,
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
            JOptionPane.showMessageDialog(null, e.getMessage());
            Logger.getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);

        }
        return false;
    }

    public boolean creatProduto(int valor) {
        try {
            if (CadastrarFornecedor.getFornecedor().size() > 0) {
                Random ramdom = new Random();
                instanceControllerCadastrarPrdoduto = new CadastrarProduto();
                for (int i = 0; i <= valor; i++) {
                    instanceControllerCadastrarPrdoduto.creat(
                            ramdom.nextInt(CadastrarFornecedor.getFornecedor().size()),
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
            JOptionPane.showMessageDialog(null, e.getMessage());
            Logger.getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    /**
     * Cria produtos aleatórios no sistema.
     *
     * @param valor
     * @return
     */
    public boolean creatVenda(int valor) {
        try {
            if (CadastrarUsuario.getUsuario().size() > 0 && CadastrarProduto.getProduto().size() > 0) {
                instanceControllerCadastrarVendas = new CadastrarVenda();
                Random ramdom = new Random();
                for (int i = 0; i < valor; i++) {
                    instanceControllerCadastrarVendas.cadastrar(
                            ramdom.nextInt(ramdom.nextInt(CadastrarProduto.getProduto().size()) + 1),
                            ramdom.nextInt(ramdom.nextInt(CadastrarUsuario.getUsuario().size()) + 1),
                            instanceControllerGerarString.getPrecoQualquer(),
                            instanceControllerGerarString.getDescontoQualquer());
                }
                return true;
            } else {
                throw new IllegalArgumentException(MensagensDoSistema.SISTEMA.MSG_001_001.getCodigo() + "\n" + MensagensDoSistema.SISTEMA.MSG_001_001.getMenssagem());
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            Logger.getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
}
