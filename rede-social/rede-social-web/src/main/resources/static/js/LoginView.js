"use strict";

function LoginView(options) {
    options = options || {};
    this.botaoCadastrar = options.botaoCadastrar;
    this.divConteudo = options.divConteudo;
    this.usuarios = new Usuarios({});
}

LoginView.prototype.registrar = function () {
    var self = this;
    $(this.botaoCadastrar.selector).click(function () {
        this.usuarios.getCadastro().done(function (res) {
            self.divConteudo.empty();
            self.divConteudo.append(res);
        });
    }.bind(this));
};

