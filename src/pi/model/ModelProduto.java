package pi.model;

import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import util.jTable.Tabela;

public class ModelProduto {

    private int id;
    private String idFornecedor;
    private String categoria;
    private String nome;
    private String descricao;
    private double preco;
    private int desconto;
    private String fornecedor;
    private String marca;
    private String modelo;
    private String tipo;
    private String cor;
    private String tamanho;
    private String garantia;
    private int quantidade;
    private String dataFrabricacao;
    private String dataValidade;

    @Tabela(Coluna = "Nome", Indice = 0)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (!nome.isEmpty()) {
            this.nome = nome;
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (!descricao.isEmpty()) {
            this.descricao = descricao;
        }
    }

    @Tabela(Coluna = "Preço", Indice = 3)
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco > 0.0) {
            this.preco = preco;
        }
    }

    @Tabela(Coluna = "Descricao", Indice = 4)
    public int getDesconto() {
        return desconto;
    }

    public void setDesconto(int desconto) {
        if (desconto >= 0) {
            this.desconto = desconto;
        }
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        if (!fornecedor.isEmpty()) {
            this.fornecedor = fornecedor;
        }
    }

    @Tabela(Coluna = "Marca", Indice = 1)
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        if (!marca.isEmpty()) {
            this.marca = marca;
        }
    }

    @Tabela(Coluna = "Modelo", Indice = 2)
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        if (!modelo.isEmpty()) {
            this.modelo = modelo;
        }
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        if (!cor.isEmpty()) {
            this.cor = cor;
        }
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        if (!tamanho.isEmpty()) {
            this.tamanho = tamanho;
        }
    }

    public String getGarantia() {
        return garantia;
    }

    @Tabela(Coluna = "Garantia", Indice = 5)
    public void setGarantia(String garantia) {
        if (!garantia.isEmpty()) {
            this.garantia = garantia;
        }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade >= 0) {
            this.quantidade = quantidade;
        }
    }

    public int getIdProduto() {
        return getId();
    }

    public void setIdProduto(int idProduto) {
        if (idProduto >= 0) {
            this.setId(idProduto);
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (!tipo.isEmpty()) {
            this.tipo = tipo;
        }
    }

    public String getDataFrabricacao() {
        return dataFrabricacao;
    }

    public void setDataFrabricacao(String dataFrabricacao) {
        if (!dataFrabricacao.isEmpty()) {
            this.dataFrabricacao = dataFrabricacao;
        }
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        if (!dataValidade.isEmpty()) {
            this.dataValidade = dataValidade;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id >= 0) {
            this.id = id;
        }
    }

    public String getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(String idFornecedor) {

        this.idFornecedor = idFornecedor;

    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        if (!categoria.isEmpty()) {
            this.categoria = categoria;
        }
    }
    private static final Logger LOG = getLogger(ModelProduto.class.getName());
}
