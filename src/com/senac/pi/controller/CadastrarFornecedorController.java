package com.senac.pi.controller;

import com.senac.pi.controller.Jtable.JtableFornecedor;
import com.senac.pi.model.bo.CadastrarFornecedor;
import com.senac.pi.model.vo.ModelPessoaJuridica;
import com.senac.pi.views.FrmCadastrarPJ;
import java.awt.Color;
import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showMessageDialog;

public class CadastrarFornecedorController {

    private final FrmCadastrarPJ form;

    public CadastrarFornecedorController(FrmCadastrarPJ form) {
        this.form = form;
    }

    public void resetForm() {
        this.form.getTxtRazaoS().setText("");
        this.form.getTxtCnpj().setText("");
        this.form.getTxtSetorAt().setText("");
        this.form.getTxtBairro().setText("");
        this.form.getTxtRua().setText("");
        this.form.getTxtNumero().setText("");
        this.form.getTxtComplemento().setText("");
        this.form.getTxtCep().setText("");
        this.form.getTxtCidade().setText("");
        this.form.getTxtEstado().setText("");
        this.form.getTxtPais().setText("");
        this.form.getTxtTelefone().setText("");
        this.form.getTxtEmail().setText("");
        this.form.getTxtSite().setText("");
    }

    public void atualizarCadastro() {
        CadastrarFornecedor instanceCadastrarFornecedorBO = new CadastrarFornecedor();
        ModelPessoaJuridica passagem = instanceCadastrarFornecedorBO.passagem(
                this.form.getTxtID().getText(),
                this.form.getTxtCnpj().getText(),
                this.form.getTxtRazaoS().getText(),
                this.form.getTxtSetorAt().getText(),
                this.form.getTxtTelefone().getText(),
                this.form.getTxtEmail().getText(),
                this.form.getTxtSite().getText(),
                this.form.getTxtCidade().getText(),
                this.form.getTxtEstado().getText(),
                this.form.getTxtPais().getText(),
                this.form.getTxtBairro().getText(),
                this.form.getTxtRua().getText(),
                this.form.getTxtNumero().getText(),
                this.form.getTxtComplemento().getText(),
                this.form.getTxtCep().getText());
        boolean update = instanceCadastrarFornecedorBO.update(parseInt(this.form.getTxtID().getText()), passagem);
        if (update) {
            resetForm();
            /*// Visibilidade dos botões.*/
            this.form.getBtnUpdateEmpresa().setVisible(false);
            this.form.getBtnInsertEmpresa().setVisible(true);
            this.form.getBtnInsertEmpresa().setEnabled(true);
            this.form.getBtnDeletePJ().setEnabled(false);
            this.form.getBtnLinkProduto().setVisible(false);
        }
    }

    public void salvarCadastro() {
        if (!this.form.getTxtRazaoS().getText().isEmpty() && !this.form.getTxtCnpj().getText().isEmpty() && !this.form.getTxtEmail().getText().isEmpty()) {
            CadastrarFornecedor instanceCadastrarFornecedorBO = new CadastrarFornecedor();
            ModelPessoaJuridica dados = instanceCadastrarFornecedorBO.passagem(null, this.form.getTxtCnpj().getText(),
                    this.form.getTxtRazaoS().getText(),
                    this.form.getTxtSetorAt().getText(),
                    this.form.getTxtTelefone().getText(),
                    this.form.getTxtEmail().getText(),
                    this.form.getTxtSite().getText(),
                    this.form.getTxtCidade().getText(),
                    this.form.getTxtEstado().getText(),
                    this.form.getTxtPais().getText(),
                    this.form.getTxtBairro().getText(),
                    this.form.getTxtRua().getText(),
                    this.form.getTxtNumero().getText(),
                    this.form.getTxtComplemento().getText(),
                    this.form.getTxtCep().getText());

            if (instanceCadastrarFornecedorBO.creat(dados)) {
                this.resetForm();
                JtableFornecedor instanceControllerJtable = new JtableFornecedor(this.form);
                instanceControllerJtable.updateJtable();
                this.form.getjTableFornecedor().setBackground(Color.gray);
                showMessageDialog(null, "Cadastrado com Sucesso!");
            }
        }
    }
}
