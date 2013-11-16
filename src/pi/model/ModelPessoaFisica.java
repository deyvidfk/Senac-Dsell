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
 * @author deyvid.fk
 * @version 2.0
 */
public final class ModelPessoaFisica implements InterfaceModelContato, InterfaceModelEndereco {

    private int id;
    private int bonus;
    private String apelido;
    private String cpf;
    private String rg;
    private String nome;
    private Integer idade;
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

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        if (!apelido.equals("")) {
            this.apelido = apelido;
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

    @RequiredValidation(Required = true, label = "CPF", MaximumValue = 50, MinimumValue = 1)
    @RegularExpressionValidator(ValidationExpression = ExpressaoRegular.CPF, Label = "CPF", RegexErrorMessage = "CPF Inválido", EnableErrorMessage = true)
    @Coluna(nome = "CPF", indice = 2)
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (!cpf.equals("")) {
            this.cpf = cpf;
        }
    }

    @RequiredValidation(Required = true, label = "RG", MaximumValue = 50, MinimumValue = 1)
    @RegularExpressionValidator(ValidationExpression = ExpressaoRegular.RG, Label = "RG", RegexErrorMessage = "RG Inválido", EnableErrorMessage = true)
    @Coluna(nome = "RG", indice = 1)
    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        if (!rg.equals("")) {
            this.rg = rg;
        }
    }

    /**
     * @return the nome
     */
    @RequiredValidation(Required = true, label = "Nome", MaximumValue = 50, MinimumValue = 1)
    @RegularExpressionValidator(ValidationExpression = ExpressaoRegular.QualquerCaractere, Label = "Nome", RegexErrorMessage = "Nome Inválido", EnableErrorMessage = true)
    @Coluna(nome = "Nome", indice = 0)
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        if (!nome.equals("")) {
            this.nome = nome;
        }
    }

    /**
     * @return the idade
     */
    public Integer getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(Integer idade) {
        if (idade >= 0) {
            this.idade = idade;
        }
    }

    @RequiredValidation(Required = true, label = "ID", MaximumValue = 50, MinimumValue = 1)
    @Coluna(nome = "ID", indice = 13)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id >= 0) {
            this.id = id;
        }
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        if (bonus > 0) {
            this.bonus = bonus;
        }
    }

    @Override
    public String getSite() {
        return this.site;
        //
    }

    @RequiredValidation(Required = true, label = "Telefone", MinimumValue = 1, MaximumValue = 20)
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
