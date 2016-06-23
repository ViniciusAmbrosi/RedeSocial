"use strict";

function HeaderView(options) {
    options = options || {};
    this.botaoAceitar = options.botaoAceitar;
    this.botaoRejeitar = options.botaoRejeitar;
    this.relacionamentos = new Relacionamentos({});
}

HeaderView.prototype.registrar = function () {
    $(this.botaoAceitar.selector).click(function () {
        this.relacionamentos.Aceitar(this.botaoAceitar.attr('data-id')).done(function(res){
            $('#header').empty();
            $('#header').append(res);
        });
    }.bind(this));

    $(this.botaoRejeitar.selector).click(function () {
        this.relacionamentos.Rejeitar(this.botaoRejeitar.attr('data-id')).done(function(res){
            $('#header').empty();
            $('#header').append(res);
        });
    }.bind(this));
};
