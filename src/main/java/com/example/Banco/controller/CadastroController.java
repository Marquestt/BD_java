package com.example.Banco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.context.ApplicationContext;
import com.example.Banco.model.cliente;
import com.example.Banco.model.clienteService;

import org.springframework.ui.Model;

@Controller
public class CadastroController {
    @Autowired
    private ApplicationContext context;

    @GetMapping("/")
    public String principal(){
        return "principal";
    }

    @GetMapping("/cadastro")
    public String cadastro(Model model){
        model.addAttribute("cliente",new cliente("",""));
        return "cadastro";
    }

    @PostMapping
    public String cadastrar(Model model,@ModelAttribute cliente cli){
        clienteService cs = context.getBean(clienteService.class);
        cs.Inserir(cli);
        return "sucesso";
    }
}
