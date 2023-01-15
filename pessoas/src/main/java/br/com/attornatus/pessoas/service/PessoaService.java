package br.com.attornatus.pessoas.service;

import br.com.attornatus.pessoas.model.Pessoa;
import br.com.attornatus.pessoas.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public Pessoa salvar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Pessoa editar(Pessoa pessoa, Long id){
        Pessoa pessoaFound = pessoaRepository.findById(id).orElseThrow(null);

        pessoaFound.setNome(pessoa.getNome());
        pessoaFound.setDataNascimento(pessoa.getDataNascimento());
        pessoaFound.setEndereco(pessoa.getEndereco());

        pessoaRepository.save(pessoaFound);

        return pessoaFound;
    }

    public List<Pessoa> listar() {
        return (List<Pessoa>) pessoaRepository;
    }

    public Pessoa buscarPorId(Long id) {
        return pessoaRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public List<Pessoa> consultar(String filtro) {
        return (List<Pessoa>) pessoaRepository.findByNome(filtro);
    }
}
