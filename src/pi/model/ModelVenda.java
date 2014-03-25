/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.model;

import static java.lang.Math.floor;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import util.jTable.Tabela;

/**
 *
 * @author deyvid.fk
 */
public class ModelVenda {

    private int id;
    public String Guid;
    private int idProduto;
    private int idComprador;
    private double preco;
    private double precoFinal;
    private double desconto;
    private String dataDaVenda;
    private String data;
    private int mes;
    private int ano;
    private int hora;
    private int totalDeVendas;

    @Tabela(Coluna = "ID", Indice = 0)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id >= 0) {
            this.id = id;
        }
    }

    @Tabela(Coluna = "ID Produto", Indice = 3)
    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        if (idProduto >= 0) {
            this.idProduto = idProduto;
        } else {
            throw new IllegalArgumentException("O Id deve ser maior ou igual a zero.");
        }
    }

    @Tabela(Coluna = "Comprador", Indice = 2)
    public int getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(int idComprador) {
        if (idComprador >= 0) {
            this.idComprador = idComprador;
        } else {
            throw new IllegalArgumentException("O Id deve ser maior ou igual a zero.");
        }
    }

    @Tabela(Coluna = "Preço", Indice = 4)
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco >= 0.0) {
            this.preco = preco;
        } else {
            throw new IllegalArgumentException("O preço para o produto deve ser maior ou igual a zero.");
        }

    }

    @Tabela(Coluna = "Total", Indice = 6)
    public double getPrecoFinal() {
        return precoFinal = (floor((this.getPreco() * this.getDesconto()) / 100));
    }

    public void setPrecoFinal(double precoFinal) {
        if (precoFinal >= 0) {
            this.precoFinal = precoFinal;
        } else {
            throw new IllegalArgumentException("O preço para o produto deve ser maior ou igual a zero.");
        }
    }

    @Tabela(Coluna = "Desconto", Indice = 5)
    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        if (desconto >= 0) {
            this.desconto = desconto;
        } else {
            throw new IllegalArgumentException("O Id deve ser maior ou igual a zero.");
        }
    }

    @Tabela(Coluna = "Data da venda", Indice = 1)
    public String getDataDaVenda() {
        return dataDaVenda;
    }

    public void setDataDaVenda(String dataDaVenda) {
        if (!dataDaVenda.isEmpty()) {
            this.dataDaVenda = dataDaVenda;
        } else {
            throw new IllegalArgumentException("Data invalida.");
        }

    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        if (!data.isEmpty()) {
            this.data = data;
        } else {
            throw new IllegalArgumentException("Data invalida.");
        }
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        if (hora >= 0 || hora <= 24) {
            this.hora = hora;
        } else {
            throw new IllegalArgumentException("Hora invalida!");
        }
    }

    public int getMes() {

        return mes;
    }

    public void setMes(int mes) {
        if (mes > 0 || mes <= 12) {
            this.mes = mes;
        } else {
            throw new IllegalArgumentException("Mês invalido!");
        }

    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        if (ano > 0) {
            this.ano = ano;
        } else {
            throw new IllegalArgumentException("O Id deve ser maior ou igual a zero.");
        }
    }

    public int getTotalDeVendas() {
        return totalDeVendas;
    }

    public void setTotalDeVendas(int totalDeVendas) {
        if (totalDeVendas >= 0) {
            this.totalDeVendas = totalDeVendas;
        } else {
            throw new IllegalArgumentException("O valor deve ser maior ou igual a zero.");
        }
    }
    private static final Logger LOG = getLogger(ModelVenda.class.getName());
}
