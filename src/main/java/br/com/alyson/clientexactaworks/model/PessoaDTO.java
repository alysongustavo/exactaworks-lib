package br.com.alyson.clientexactaworks.model;

import java.util.ArrayList;
import java.util.List;

/**
 * description: Classe que representa uma Pessoa na aplicação
 */
public class PessoaDTO {

    /**
     * description: Representa o Id da Pessoa.
     */
    private Integer id;

    /**
     * description: Representa o nome da Pessoa.
     */
    private String name;

    /**
     * description: Representa os gastos da Pessoa.
     */
    private List<GastoDTO> gastos = new ArrayList<>();

    /**
     * description: Representa o email de uma Pessoa.
     */
    private String email;

    /**
     * description: Representa o CPF de uma pessoa.
     */
    private String cpf;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addGastos(GastoDTO gasto){
        this.gastos.add(gasto);
    }

    public List<GastoDTO> getGastos() {
        return gastos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
