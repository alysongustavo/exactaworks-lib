package br.com.alyson.clientexactaworks.util;

import br.com.alyson.clientexactaworks.model.GastoDTO;
import br.com.alyson.clientexactaworks.model.PessoaDTO;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestClientImpl implements RestClient {

    private String endPoint;

    public RestClientImpl(){
        this.endPoint = EndPoint.obterEndPoint();
    }

    @Override
    public List<PessoaDTO> listarPessoas() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        StringBuilder url = new StringBuilder(this.endPoint);
        url.append("/pessoas");

        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<PessoaDTO[]> responseEntity = restTemplate.exchange(url.toString(), HttpMethod.GET, requestEntity, PessoaDTO[].class);
        PessoaDTO[] pessoas = responseEntity.getBody();
        List<PessoaDTO> pessoasRetorno = Arrays.asList(pessoas);

        return pessoasRetorno;
    }

    @Override
    public String cadastrarPessoa(PessoaDTO pessoaDTO) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();

        StringBuilder url = new StringBuilder(this.endPoint);
        url.append("/pessoas");
        HttpEntity<PessoaDTO> requestEntity = new HttpEntity<>(pessoaDTO, headers);
        URI uri = restTemplate.postForLocation(url.toString(), requestEntity);

        return uri.getPath();
    }

    @Override
    public PessoaDTO buscarPessoaPorId(Integer id) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        StringBuilder url = new StringBuilder(this.endPoint);
        url.append("/pessoas/{id}");

        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<PessoaDTO> responseEntity = restTemplate.exchange(url.toString(), HttpMethod.GET, requestEntity, PessoaDTO.class, id);
        PessoaDTO pessoa = responseEntity.getBody();

        return pessoa;
    }

    @Override
    public List<GastoDTO> listarGastosPorPessoa(Integer id) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        StringBuilder url = new StringBuilder(this.endPoint);
        url.append("/pessoas/{id}/gastos");

        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<GastoDTO[]> responseEntity = restTemplate.exchange(url.toString(), HttpMethod.GET, requestEntity, GastoDTO[].class, id);
        GastoDTO[] gastos = responseEntity.getBody();
        List<GastoDTO> gastosRetorno = Arrays.asList(gastos);

        return gastosRetorno;
    }

    @Override
    public GastoDTO adicionarGastos(GastoDTO gasto, Integer funcionarioID) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();

        StringBuilder url = new StringBuilder(this.endPoint);
        url.append("/pessoas/{id}/gastos");
        HttpEntity<GastoDTO> requestEntity = new HttpEntity<>(gasto, headers);

        ResponseEntity<GastoDTO> responseEntity = restTemplate.exchange(url.toString(), HttpMethod.POST, requestEntity, GastoDTO.class, funcionarioID);

        return responseEntity.getBody();
    }

    @Override
    public List<GastoDTO> listarGastos() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        StringBuilder url = new StringBuilder(this.endPoint);
        url.append("/gastos");

        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<GastoDTO[]> responseEntity = restTemplate.exchange(url.toString(), HttpMethod.GET, requestEntity, GastoDTO[].class);
        GastoDTO[] gastos = responseEntity.getBody();
        List<GastoDTO> gastosRetorno = Arrays.asList(gastos);

        return gastosRetorno;
    }

    @Override
    public GastoDTO buscarGastosPorId(Integer id){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        StringBuilder url = new StringBuilder(this.endPoint);
        url.append("/gastos/{id}");

        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<GastoDTO> responseEntity = restTemplate.exchange(url.toString(), HttpMethod.GET, requestEntity, GastoDTO.class, id);
        GastoDTO gasto = responseEntity.getBody();

        return gasto;
    }

}
