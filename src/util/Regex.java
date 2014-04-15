/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author User-001
 */
public enum Regex {

    /**
     * * String qualquer caractere é aceito
     */
    QUALQUER_CARACTER("^([^<]|<[^>]*$)*$"),
    /**
     * * Nome e Sobrenome
     */
    NOME_E_SOBRENOME("^[a-zA-ZÀ-Üà-ü]+( [a-zA-ZÀ-Üà-ü]+)+$"),
    /**
     * * CPF: 223.185.357-44
     */
    CPF("^\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}$"),
    /**
     * * RG
     */
    RG("^\\d{1,3}.\\d{3}.\\d{3}-[a-zA-Z0-9]$"),
    /**
     * * CNPJ
     */
    CNPJ("^\\d{3}.?\\d{3}.?\\d{3}/?\\d{3}-?\\d{2}$"),
    /**
     * * CEP
     */
    CEP("^\\d{5}-\\d{3}$"),
    /**
     * TELEFONE: Formato do telefone aceito: (99) 99999-9999 Outro formato
     * aceito: (99) 9999-9999 / 9 9999-9999 / 99999-9999
     */
    TELEFONE("^(\\([0-9]{2}\\))?\\s?([9]{1})?\\s?([0-9]{4})-([0-9]{4})$"),
    /**
     * * Número: 0,1,2,3,4,5,6,7,8,9,
     */
    NUMERO_DECIMAL("^[0-9]+$"),
    /**
     * * E-MAIL: EXEMPLO@EXEMPLO.COM
     */
    EMAIL("^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"),
    /**
     * * Hora:Minuto
     */
    HORA("([01]\\d|2[0-3]):[0-5]\\d"),
    /**
     * * Hora:Minuto:Segundo
     */
    HORA_E_SEGUNDOS("([01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d"),
    /**
     * * MOEDA: REAL R$
     */
    MOEDA_RS("^\\d*[0-9](,\\d*[0-9])?$"),
    /**
     * * MOEDA: DOLAR U$
     */
    MOEDA_US("^\\d*[0-9](\\.\\d*[0-9])?$"),
    /**
     * * Valida datas no formato mm/dd/yyyy ou mm-dd-yyyy
     */
    DATA("^(((((((0?[13578])|(1[02]))[.-/]?((0?[1-9])|([12]d)|(3[01])))|(((0?[469])|(11))[.-/]?((0?[1-9])|([12]d)|(30)))|((0?2)[.-/]?((0?[1-9])|(1d)|(2[0-8]))))[.-/]?(((19)|(20))?([d][d]))))|((0?2)[.-/]?(29)[.-/]?(((19)|(20))?(([02468][048])|([13579][26])))))$"),
    /**
     * * Corresponde a qualquer palavra ou frase na lista a seguir. adm admin
     */
    LOGIN_ADM("(\\W|^)(adm|admin|)(\\W|$)");
    public String expressao;

    public String getExpressao() {

        return this.expressao;
    }

    Regex(String exp) {
        this.expressao = exp;
    }
}
