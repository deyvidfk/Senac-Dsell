/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.model;

import util.ExpressaoRegular;
import util.anotacao.RegularExpressionValidator;
import util.anotacao.RequiredValidation;
import pi.controller.Jtable.Coluna;

/**
 *
 * @author deyvid.fk
 */
// If you want you can define the order in which the fields are written
// Optional
public final class ModelPessoaJuridica implements InterfaceModelContato, InterfaceModelEndereco {

    private int id;
    private String nome;
    private String cnpj;
    private String setorDeAtuacao;
    private int qtdProduto;
    private int quant;
    private String pais;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;
    private String complemento;
    private String cep;
    private String telefone;
    private String email;
    private String site;

    @RequiredValidation(Required = true, label = "NOME", MaximumValue = 50, MinimumValue = 1)
    @RegularExpressionValidator(ValidationExpression = ExpressaoRegular.QualquerCaractere, Label = "Nome", RegexErrorMessage = "Nome Inválido", EnableErrorMessage = true)
    @Coluna(nome = "Nome", indice = 1)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (!nome.equals("")) {
            this.nome = nome;
        }
    }

    @RequiredValidation(Required = true, label = "CNPJ", MaximumValue = 50, MinimumValue = 1)
    @RegularExpressionValidator(ValidationExpression = ExpressaoRegular.CNPJ, Label = "CNPJ", RegexErrorMessage = "CNPJ Inválido", EnableErrorMessage = true)
    @Coluna(nome = "CNPJ", indice = 0)
    public String getCnpj() {

        return cnpj;
    }

    public void setCnpj(String cnpj) {
        if (!cnpj.equals("")) {
            this.cnpj = cnpj;
        }
    }

    @Coluna(nome = "CNPJ", indice = 2)
    public String getSetorDeAtuacao() {
        return setorDeAtuacao;
    }

    public void setSetorDeAtuacao(String setorDeAtuacao) {
        if (!setorDeAtuacao.equals("")) {
            this.setorDeAtuacao = setorDeAtuacao;
        }
    }

    @Coluna(nome = "ID", indice = 13)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id >= 0) {
            this.id = id;
        }
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        if (qtdProduto >= 0) {
            this.qtdProduto = qtdProduto;
        }
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        if (quant >= 0) {
            this.quant = quant;
        }
    }

    @RequiredValidation(Required = true, label = "E-MAIL", MaximumValue = 50, MinimumValue = 1)
    @RegularExpressionValidator(ValidationExpression = ExpressaoRegular.EMAIL, Label = "E-mail", RegexErrorMessage = "E-mail Inválido", EnableErrorMessage = true)
    @Coluna(nome = "E-Mail", indice = 4)
    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {

        this.email = email;

    }

    @Override
    public String getSite() {
        return this.site;
        //
    }

    @RequiredValidation(Required = true, label = "TELEFONE", MaximumValue = 50, MinimumValue = 1)
    @RegularExpressionValidator(ValidationExpression = ExpressaoRegular.TELEFONE, Label = "Telefone", RegexErrorMessage = "Telefone Inválido", EnableErrorMessage = true)
    @Coluna(nome = "Telefone", indice = 3)
    @Override
    public String getTelefone() {
        return this.telefone;
        //
    }

    @Override
    public void setSite(String site) {
        this.site = site;
        //
    }

    @Override
    public void setTelefone(String telefone) {
        this.telefone = telefone;

    }

    @Coluna(nome = "Bairro", indice = 8)
    @Override
    public String getBairro() {
        return this.bairro;
        //
    }

    @Coluna(nome = "CEP", indice = 12)
    @Override
    public String getCep() {
        return this.cep;
        //
    }

    @Coluna(nome = "Cidade", indice = 5)
    @Override
    public String getCidade() {

        return this.cidade;
        //
    }

    @Coluna(nome = "Complemento", indice = 11)
    @Override
    public String getComplemento() {
        return this.complemento;
        //
    }

    @Coluna(nome = "Estado", indice = 6)
    @Override
    public String getEstado() {
        return this.estado;
        //
    }

    @Coluna(nome = "Numero", indice = 10)
    @Override
    public String getNumero() {
        return this.numero;

    }

    @Coluna(nome = "Pais", indice = 7)
    @Override
    public String getPais() {
        return this.pais;

    }

    @Coluna(nome = "Rua", indice = 9)
    @Override
    public String getRua() {
        return this.rua;

    }

    @Override
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Override
    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public void setRua(String rua) {
        this.rua = rua;
    }
}
