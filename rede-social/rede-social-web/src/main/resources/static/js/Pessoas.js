'use strict';

function Pessoas() {
    this.urlGetAmigos = '/perfil/amigos';
    this.urlGetPublicacoes = '/perfil/publicacoes';
    this.urlGetPessoas = '/buscar/pessoas';
    this.urlGetPessoasPorNome = '/buscar/pessoas/nome'
}

Pessoas.prototype.getAmigos = function (idPerfil) {
    return $.get(this.urlGetAmigos, {idPerfil: idPerfil});
};

Pessoas.prototype.getPublicacoes = function (idPerfil) {
    return $.get(this.urlGetPublicacoes, {idPerfil: idPerfil});
};

Pessoas.prototype.getPessoas = function () {
    return $.get(this.urlGetPessoas);
};

Pessoas.prototype.getPessoasPorNome = function (nome) {
    return $.post(this.urlGetPessoasPorNome, {nome: nome});
};