package br.com.attornatus.pessoas.service;

import br.com.attornatus.pessoas.model.Endereco;
import br.com.attornatus.pessoas.repository.EnderecoRepository;

import java.util.List;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public List<Endereco> listar() {
        return (List<Endereco>) enderecoRepository.findAll();
    }
}
