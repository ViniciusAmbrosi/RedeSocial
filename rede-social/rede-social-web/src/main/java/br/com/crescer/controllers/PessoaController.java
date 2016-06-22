package br.com.crescer.controllers;

import br.com.crescer.entity.Pessoa;
import br.com.crescer.service.PessoaService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author vinicius.ambrosi
 */
@Controller
public class PessoaController {

    @Autowired
    PessoaService service;

    @RequestMapping(value = "/home/menu-lateral")
    public String perfil(Model m) {
        return "lateral-pessoa";
    }
}
