package pi.controller;

public class MensagensDoSistema {

    public enum SISTEMA {

        // 000_0_ SISTEMA
        MSG_000_0("CONFIGURAÇÃO DEFAULT DO SISTEMA CRIADA COM SUCESSO.\n"
                + "Para segurança do sistema altere a senha padrão para uma senha de sua escolha. \n"
                + "Obs:  Os menus estão desativados. Altere seus dados e os Ative-os, após isso faça o logon novamente.", "COD: 000_0"),
        // 000_1_ CADASTRO
        MSG_001_000("Você não pode cadastrar produtos sem antes haver fornecedores cadastrados no sistema.", "COD: 001_000"),
        MSG_001_001("Você não pode gerar vendas sem antes haver produtos cadastrados.", "COD: 001_001"),
        // 000_2_ AVISO
        MSG_002_000("Você não pode excluir este fornecedor, pois existem dependencências. Ele contém produtos cadastrados no sistema.", "COD: 002_000"),
        MSG_002_001("Não há dados para montar a tabela", "COD: 002_001"),
        MSG_002_002("Não há dados para montar o grafico", "COD: 002_002"),
        // 000_3_ ERRO
        MSG_003_000("Erro ao escrever dados na tabela", "COD: 003_000");
        private final String codigo;
        private final String menssagem;

        SISTEMA(String menssagem, String codigo) {
            this.menssagem = menssagem;
            this.codigo = codigo;
        }

        public String getCodigo() {
            return this.codigo;
        }

        public String getMenssagem() {
            return this.menssagem;
        }
    }
}
