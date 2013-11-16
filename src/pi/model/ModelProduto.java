/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.model;

import pi.controller.Jtable.Coluna;

/**
 *
 * @author deyvid.fk
 */
public final class ModelProduto {

    private int id;
    private int idFornecedor;
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

    @Coluna(nome = "Nome", indice = 0)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (!nome.equals("")) {
            this.nome = nome;
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (!descricao.equals("")) {
            this.descricao = descricao;
        }
    }

    @Coluna(nome = "Preço", indice = 3)
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco > 0.0) {
            this.preco = preco;
        }
    }

    @Coluna(nome = "Descricao", indice = 4)
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
        if (!fornecedor.equals("")) {
            this.fornecedor = fornecedor;
        }
    }

    @Coluna(nome = "Marca", indice = 1)
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        if (!marca.equals("")) {
            this.marca = marca;
        }
    }

    @Coluna(nome = "Modelo", indice = 2)
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        if (!modelo.equals("")) {
            this.modelo = modelo;
        }
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        if (!cor.equals("")) {
            this.cor = cor;
        }
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        if (!tamanho.equals("")) {
            this.tamanho = tamanho;
        }
    }

    public String getGarantia() {
        return garantia;
    }

    @Coluna(nome = "Garantia", indice = 5)
    public void setGarantia(String garantia) {
        if (!garantia.equals("")) {
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
        if (!tipo.equals("")) {
            this.tipo = tipo;
        }
    }

    public String getDataFrabricacao() {
        return dataFrabricacao;
    }

    public void setDataFrabricacao(String dataFrabricacao) {
        if (!dataFrabricacao.equals("")) {
            this.dataFrabricacao = dataFrabricacao;
        }
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        if (!dataValidade.equals("")) {
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

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        if (idFornecedor >= 0) {
            this.idFornecedor = idFornecedor;
        }
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        if (!categoria.equals("")) {
            this.categoria = categoria;
        }
    }
}
