package br.com.attornatus.pessoas.repository;

import br.com.attornatus.pessoas.model.Pessoa;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

    List<Pessoa> findByNome(String filtro);
}
