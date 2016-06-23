'use strict';

function Solicitacoes() {
    this.urlPost = '/adicionar/amigo';
};

Solicitacoes.prototype.Cadastrar = function (bd) {
    return $.post(this.urlPost, { id: bd});
};