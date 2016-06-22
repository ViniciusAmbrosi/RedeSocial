"use strict";

function CadastroView(options) {
    this.form = options.form;
}

CadastroView.prototype.validar = function () {
    $(this.form).validate({
        rules: {
            dsEmail: {
                required: true,
                email: true
            },
            dsSenha: "required",
            confirmacaoSenha: {
                required: true,
                equalTo: "#dsSenha"
            },
            'pessoaIdPessoa.nmPessoa': "required",
            'pessoaIdPessoa.dtNascPessoa': "required",
            'pessoaIdPessoa.tpSexoPessoa': "required"
        },
        messages: {
            dsEmail: {
                required: 'Digitar um email.',
                email: 'Formato de email inválido, tente novamente.'
            },
            dsSenha: "Insira uma senha.",
            confirmacaoSenha: {
                required: "Confirme sua senha.",
                equalTo: "As senhas não batem, tente novamente."
            },
            'pessoaIdPessoa.nmPessoa': 'Informe seu nome.',
            'pessoaIdPessoa.dtNascPessoa': 'Informe uma data de nascimento.',
            'pessoaIdPessoa.tpSexoPessoa': 'Informe seu sexo.'
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