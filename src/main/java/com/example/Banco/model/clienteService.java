package com.example.Banco.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class clienteService {

    @Autowired
    clienteDAO cdao;

    public void Inserir(cliente cli){
        cdao.Inserir(cli);
    }
}
