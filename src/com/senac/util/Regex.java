package com.senac.util;

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
     * * RG
     */
    RG("^\\d{1,3}.\\d{3}.\\d{3}-[a-zA-Z0-9]$"),
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
    // EMAIL("^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"),
    EMAIL("^[\\w!#\\$%&'\\*\\+\\-/=\\?\\^`\\{\\|\\}~]+(\\.[\\w!#\\$%&'\\*\\+\\-/=\\?\\^`\\{\\|\\}~]+)*@[a-zA-Z0-9]+([\\-]?[a-zA-Z0-9])+(\\.[a-zA-Z0-9]+([\\-]?[a-zA-Z0-9]){1,})+$"),
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
    LOGIN_ADM("(\\W|^)(adm|admin|)(\\W|$)"),
    ALFA("^[a-zA-Z]+$"),
    // / <summary>
    // / Alfa e espaço
    // / </summary>
    ALFA_COM_ESPACO("^[a-zA-Z ]+$"),
    // / <summary>
    // / Alfanumérico
    // / </summary>
    ALFA_NUMERICO("^[a-zA-Z0-9]+$"),
    // / <summary>
    // / Alfanumérico e espaço
    // / </summary>
    ALFA_NUMERICO_COM_ESPACO("^[a-zA-Z0-9 ]+$"),
    // / <summary>
    // / Alfanumérico e separadores (espaço, tab, quebra de linha)
    // / </summary>
    ALFA_NUMERICO_COM_SEPARADORES("^[a-zA-Z0-9\\s]+$"),
    // / <summary>
    // / Alfa acentuado
    // / </summary>
    ALFA_ACENTUADO("^[a-zA-Z" + Regex.sAcc + "]+$"),
    // / <summary>
    // / Alfa e espaço acentuado
    // / </summary>
    ALFA_COM_ESPACO_ACENTUADO("^[a-zA-Z " + Regex.sAcc + "]+$"),
    // / <summary>
    // / Alfanumérico acentuado
    // / </summary>
    ALFA_NUMERICO_ACENTUADO("^[a-zA-Z0-9" + Regex.sAcc + "]+$"),
    // / <summary>
    // / Alfanumérico e espaço
    // / a-z / A-Z / 0-9 / " " +acentuação
    // / </summary>
    ALFA_NUMERICO_COM_ESPACO_ACENTUADO("^[a-zA-Z0-9 " + Regex.sAcc + "]+$"),
    // / <summary>
    // / Alfanumérico e separadores (espaço, tab, quebra de linha)
    // / </summary>
    ALFA_NUMERICO_COM_SEPARADORES_ACENTUADO("^[a-zA-Z0-9\\s" + Regex.sAcc + "]+$"),
    // / <summary>
    // / Word (alfanuméricos não acentuados, números e underscore)
    // / </summary>

    ALFA_NUMERICO_SUBLINHADO("^[\\w]+$"),
    // / <summary>
    // / Aceita caracteres, número, sublinhado e ponto
    // / </summary>
    ALFA_NUMERICO_SUBLINHADO_COM_PONTO("^[\\w.]+$"),
    // / <summary>
    // / Ids
    // / </summary>
    ID("^{*[\\w|-]+}*$"),
    // / <summary>
    // / CPF
    // / 999.999.999-99 ou 99999999999
    // / </summary>
    CPF("^((\\d{3}.\\d{3}.\\d{3}-\\d{2})|(\\d{3}\\d{3}\\d{3}\\d{2}))$"),
    // / <summary>
    // / CNPJ
    // / 99.999.999/9999-99 ou 99999999999999
    // / </summary>
    CNPJ("^((\\d{2}.\\d{3}.\\d{3}\\/\\d{4}-\\d{2})|(\\d{2}\\d{3}\\d{3}\\d{4}\\d{2}))$"),
    // / <summary>
    // / Ip
    // / </summary>
    IP("^\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}$"),
    // / <summary>
    // / Ip Faixa
    // / </summary>
    IP_FAIXA("^\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.(\\d{1,3}|\\*)$");

    public String expressao;
    public final static String sAcc = "|ç|ã|ñ|õ|á|é|í|ó|ú|à|è|ì|ò|ù|ä|ë|ï|ö|ü|â|ê|î|ô|û|Ç|Ã|Ñ|Õ|Á|É|Í|Ó|Ú|À|È|Ì|Ò|Ù|Ä|Ë|Ï|Ö|Ü|Â|Ê|Î|Ô|Û|";

    public String getExpressao() {

        return this.expressao;
    }

    Regex(String exp) {
        this.expressao = exp;
    }
}
