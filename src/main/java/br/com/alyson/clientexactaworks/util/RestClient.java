package br.com.alyson.clientexactaworks.util;

import br.com.alyson.clientexactaworks.model.GastoDTO;
import br.com.alyson.clientexactaworks.model.PessoaDTO;

import java.util.List;

public interface RestClient {

    public List<PessoaDTO> listarPessoas();
    public String cadastrarPessoa(PessoaDTO pessoaDTO);
    public PessoaDTO buscarPessoaPorId(Integer id);
    public List<GastoDTO> listarGastosPorPessoa(Integer id);
    public GastoDTO adicionarGastos(GastoDTO gasto, Integer funcionarioID);
    public List<GastoDTO> listarGastos();
    public GastoDTO buscarGastosPorId(Integer id);
}
