"use strict";

function HeaderView(options) {
    options = options || {};
    this.botaoAceitar = options.botaoAceitar;
    this.botaoRejeitar = options.botaoRejeitar;
    this.formBuscaPorNome = options.formBuscaPorNome;
    this.inputBuscaPorNome = options.inputBuscaPorNome;
    this.botaoBuscaPessoas = options.botaoBuscaPessoas;
    this.relacionamentos = new Relacionamentos();
    this.pessoas = new Pessoas();
}

HeaderView.prototype.registrar = function () {
    $(this.botaoAceitar.selector).click(function () {
        this.relacionamentos.Aceitar(this.botaoAceitar.attr('data-id')).done(function (res) {
            $('#header').empty();
            $('#header').append(res);
        });
    }.bind(this));

    $(this.botaoRejeitar.selector).click(function () {
        this.relacionamentos.Rejeitar(this.botaoRejeitar.attr('data-id')).done(function (res) {
            $('#header').empty();
            $('#header').append(res);
        });
    }.bind(this));

    $(this.formBuscaPorNome).submit(function () {
        this.pessoas.getPessoasPorNome(this.inputBuscaPorNome.val()).done(function (res) {
            $('#home-conteudo').empty();
            $('#home-conteudo').append(res);
        });
    }.bind(this));

    $(this.botaoBuscaPessoas).click(function(){
    this.pessoas.getPessoas().done(function (res) {
        $('#home-conteudo').empty();
        $('#home-conteudo').append(res);
    });
    }.bind(this));
};
