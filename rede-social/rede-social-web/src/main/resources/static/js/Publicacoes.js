'use strict';

function Publicacoes() {
    this.urlPublicar = "/publicacoes/publicar";
    this.urlGetPublicacoes = '/perfil/publicacoes';
}

Publicacoes.prototype.publicar = function (conteudo) {
    return $.post(this.urlPublicar, {post: conteudo});
};

Publicacoes.prototype.getPublicacoes = function (idPerfil) {
    return $.get(this.urlGetPublicacoes, {idPerfil: idPerfil});
};
