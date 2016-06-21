'use strict';

function Usuarios() {
    this.urlGet = '/cadastrar';
};

Usuarios.prototype.getCadastro = function () {
    return $.get(this.urlGet);
};