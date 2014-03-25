/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.model;

import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import util.Regex;
import util.anotacao.RegularExpressionValidator;
import util.anotacao.RequiredValidation;
import util.jTable.Tabela;

/**
 * @author deyvid.fk
 * @version 2.0
 */
public class ModelPessoaFisica implements InterfaceModelContato, InterfaceModelEndereco {

    private String idUser;
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
        if (!apelido.isEmpty()) {
            this.apelido = apelido;
        }
    }

    @RequiredValidation(Required = true, label = "E-MAIL", MaximumValue = 50, MinimumValue = 1)
    @RegularExpressionValidator(ValidationExpression = Regex.EMAIL, Label = "E-mail", RegexErrorMessage = "E-mail Inválido")
    @Tabela(Coluna = "E-Mail", Indice = 4)
    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {

        this.email = email;

    }

    @RequiredValidation(Required = true, label = "CPF", MaximumValue = 50, MinimumValue = 1)
    @RegularExpressionValidator(ValidationExpression = Regex.CPF, Label = "CPF", RegexErrorMessage = "CPF Inválido")
    @Tabela(Coluna = "CPF", Indice = 2)
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (!cpf.isEmpty()) {
            this.cpf = cpf;
        }
    }

    @RequiredValidation(Required = true, label = "RG", MaximumValue = 50, MinimumValue = 1)
    @RegularExpressionValidator(ValidationExpression = Regex.RG, Label = "RG", RegexErrorMessage = "RG Inválido")
    @Tabela(Coluna = "RG", Indice = 1)
    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        if (!rg.isEmpty()) {
            this.rg = rg;
        }
    }

    /**
     * @return the Coluna
     */
    @RequiredValidation(Required = true, label = "Nome", MaximumValue = 50, MinimumValue = 1)
    @RegularExpressionValidator(ValidationExpression = Regex.QualquerCaractere, Label = "Nome", RegexErrorMessage = "Nome Inválido")
    @Tabela(Coluna = "Nome", Indice = 0)
    public String getNome() {
        return nome;
    }

    /**
     * @param Coluna the Coluna to set
     */
    public void setNome(String nome) {
        if (!nome.isEmpty()) {
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
    @Tabela(Coluna = "ID", Indice = 13)
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
    @RegularExpressionValidator(ValidationExpression = Regex.TELEFONE, Label = "Telefone", RegexErrorMessage = "Telefone Inválido")
    @Tabela(Coluna = "Telefone", Indice = 3)
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

    @Tabela(Coluna = "Bairro", Indice = 8)
    @Override
    public String getBairro() {
        return this.bairro;
        //
    }

    @Tabela(Coluna = "CEP", Indice = 12)
    @Override
    public String getCep() {
        return this.cep;
        //
    }

    @Tabela(Coluna = "Cidade", Indice = 5)
    @Override
    public String getCidade() {

        return this.cidade;
        //
    }

    @Tabela(Coluna = "Complemento", Indice = 11)
    @Override
    public String getComplemento() {
        return this.complemento;
        //
    }

    @Tabela(Coluna = "Estado", Indice = 6)
    @Override
    public String getEstado() {
        return this.estado;
        //
    }

    @Tabela(Coluna = "Numero", Indice = 10)
    @Override
    public String getNumero() {
        return this.numero;

    }

    @Tabela(Coluna = "Pais", Indice = 7)
    @Override
    public String getPais() {
        return this.pais;

    }

    @Tabela(Coluna = "Rua", Indice = 9)
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

    /**
     * @return the idUser
     */
    public String getIdUser() {
        return idUser;
    }

    /**
     * @param idUser the idUser to set
     */
    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
    private static final Logger LOG = getLogger(ModelPessoaFisica.class.getName());
}
