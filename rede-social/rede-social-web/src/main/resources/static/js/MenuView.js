"use strict";

function MenuView(options) {
    options = options || {};
    this.botaoAdicionar = options.botaoAdicionar;
    this.id = options.idAdicionar;
    this.solicitacoes = new Solicitacoes({});
}

MenuView.prototype.registrar = function () {
    $(this.botaoAdicionar.selector).click(function (e) {
        var idAtual = e.currentTarget.getAttribute('data-id');
        this.solicitacoes.Cadastrar(idAtual === null ? this.id : idAtual).done(function(res){
            alert("Solicitação enviada com sucesso!");
        }).fail(function(res){
            alert("Já foi enviada uma solicitação para esse usuário!");
        });
    }.bind(this));
};
