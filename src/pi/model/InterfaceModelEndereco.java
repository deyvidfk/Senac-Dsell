/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.model;

/**
 *
 * @author deyvid.souza
 */
public interface InterfaceModelEndereco {

    String getBairro();

    String getCep();

    String getCidade();

    String getComplemento();

    String getEstado();

    String getNumero();

    String getPais();

    String getRua();

    void setBairro(String bairro);

    void setCep(String cep);

    void setCidade(String cidade);

    void setComplemento(String complemento);

    void setEstado(String estado);

    void setNumero(String numero);

    void setPais(String pais);

    void setRua(String rua);
    
}
