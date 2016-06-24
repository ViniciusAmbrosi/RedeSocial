"use strict";

function HomeView(options) {
    options = options || {};
    this.divConteudo = options.divConteudo;
    this.idPerfil = options.idPerfil;
    this.botaoAmigos = options.botaoAmigos;
    this.botaoPublicacoes = options.botaoPublicacoes;
    this.pessoas = new Pessoas();
}

HomeView.prototype.registrar = function () {

    $(this.botaoAmigos.selector).click(function () {
        var self = this;
        this.pessoas.getAmigos($("#h-id").val()).done(function (res) {
            self.divConteudo.empty();
            self.divConteudo.append(res);
        });
    }.bind(this));

    $(this.botaoPublicacoes.selector).click(function () {
        var self = this;
        this.pessoas.getPublicacoes(this.idPerfil).done(function (res) {
            self.divConteudo.empty();
            self.divConteudo.append(res);
        });
    }.bind(this));
};
