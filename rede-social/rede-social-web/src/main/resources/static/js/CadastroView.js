"use strict";

function CadastroView(options) {
    this.form = options.form;
}

CadastroView.prototype.validar = function () {
    $(this.form).validate({
        rules: {
            email: {
                required: true,
                email: true
            },
            senha: "required",
            confirmacaoSenha: {
                required: true,
                equalTo: "#senha"
            },
            'pessoa.nome': "required",
            'pessoa.dataNascimento': "required",
            'pessoa.sexo': "required"
        },
        messages: {
            email: {
                required: 'Digitar um email.',
                email: 'Formato de email inválido, tente novamente.'
            },
            senha: "Insira uma senha.",
            confirmacaoSenha: {
                required: "Confirme sua senha.",
                equalTo: "As senhas não batem, tente novamente."
            },
            'pessoa.nome': 'Informe seu nome.',
            'pessoa.dataNascimento': 'Informe uma data de nascimento.',
            'pessoa.sexo': 'Informe seu sexo.'
        },
        success: function (label) {
            label.addClass("valid").text("Ok!")
        },
        highlight: function (element, errorClass) {
            $(element).fadeOut(function () {
                $(element).fadeIn();
            });
        }
    });
};


//$(".selector").validate({
//  showErrors: function(errorMap, errorList) {
//    $("#summary").html("Your form contains "
//      + this.numberOfInvalids()
//      + " errors, see details below.");
//    this.defaultShowErrors();
//  }
//});