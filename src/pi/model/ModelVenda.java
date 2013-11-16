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

    @Coluna(nome = "ID", indice = 0)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id >= 0) {
            this.id = id;
        }
    }

    @Coluna(nome = "ID Produto", indice = 3)
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

    @Coluna(nome = "Comprador", indice = 2)
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

    @Coluna(nome = "Preço", indice = 4)
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

    @Coluna(nome = "Total", indice = 6)
    public double getPrecoFinal() {
        return precoFinal = (Math.floor((this.getPreco() * this.getDesconto()) / 100));
    }

    public void setPrecoFinal(double precoFinal) {
        if (precoFinal >= 0) {
            this.precoFinal = precoFinal;
        } else {
            throw new IllegalArgumentException("O preço para o produto deve ser maior ou igual a zero.");
        }
    }

    @Coluna(nome = "Desconto", indice = 5)
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

    @Coluna(nome = "Data da venda", indice = 1)
    public String getDataDaVenda() {
        return dataDaVenda;
    }

    public void setDataDaVenda(String dataDaVenda) {
        if (!dataDaVenda.equals("")) {
            this.dataDaVenda = dataDaVenda;
        } else {
            throw new IllegalArgumentException("Data invalida.");
        }

    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        if (!data.equals("")) {
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
}
