'use strict';

function Relacionamentos() {
    this.urlPostAceitar = '/adicionar/amigo/aceitar';
    this.urlPostRejeitar = '/adicionar/amigo/rejeitar';
}

Relacionamentos.prototype.Aceitar = function (bd) {
    return $.post(this.urlPostAceitar, {idPerfil: bd});
};

Relacionamentos.prototype.Rejeitar = function (bd) {
    return $.post(this.urlPostRejeitar, {idPerfil: bd});
};