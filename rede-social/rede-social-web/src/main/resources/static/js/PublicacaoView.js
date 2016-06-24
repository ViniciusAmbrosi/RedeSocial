"use strict";

function PublicacaoView(options) {
    options = options || {};
    this.formPublicacao = options.formPublicacao;
    this.inputPublicacao = options.inputPublicacao;
    this.publicacoes = new Publicacoes();
}

PublicacaoView.prototype.registrar = function () {
    var self = this;
    self.inputPublicacao.val('');
    $(this.formPublicacao).submit(function (e) {
        this.publicacoes.publicar(this.inputPublicacao.val()).done(function (res) {
            $('#conteudo-publicacoes').empty();
            $('#conteudo-publicacoes').append(res);
        });
        e.preventDefault();
    }.bind(this));
};

