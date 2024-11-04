package com.example.Banco.model;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import jakarta.annotation.PostConstruct;

@Repository
public class clienteDAO {

    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc;

    @PostConstruct
    private void Initialize(){
        jdbc = new JdbcTemplate(dataSource);
    }

    public void Inserir(cliente cli){
        String sql = "INSERT INTO CLIENTE(nome,cpf) VALUES (?,?);";
        Object[] parametros = new Object[2];
        parametros[0] = cli.getNome();
        parametros[1] = cli.getCpf();
        jdbc.update(sql, parametros);
    }
}
