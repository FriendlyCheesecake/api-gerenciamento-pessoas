package br.com.attornatus.pessoas.controller;

import br.com.attornatus.pessoas.model.Pessoa;
import br.com.attornatus.pessoas.service.PessoaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    public Pessoa salvar(@RequestBody Pessoa pessoa){
        return pessoaService.salvar(pessoa);
    }

    @PutMapping("/id")
    public Pessoa editarPorId(@RequestBody Pessoa pessoa, @PathVariable Long id) {
        return pessoaService.editar(pessoa, id);
    }

    @GetMapping("/{id}")
    public Pessoa consultarPorId(@PathVariable Long id) {
        return pessoaService.buscarPorId(id);
    }

    @GetMapping("/buscaNome")
    public List<Pessoa> consultarPorNome(@RequestParam String nome) {
        return pessoaService.consultar(nome);
    }

    @GetMapping
    public List<Pessoa> listar() {
        return pessoaService.listar();
    }
}
