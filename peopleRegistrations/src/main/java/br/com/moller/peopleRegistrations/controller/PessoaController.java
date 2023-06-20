package br.com.moller.peopleRegistrations.controller;

import br.com.moller.peopleRegistrations.domain.people.DadosCadastroPessoa;
import br.com.moller.peopleRegistrations.domain.people.Pessoa;
import br.com.moller.peopleRegistrations.domain.people.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository repository;

    @PostMapping
    @Transactional
    public String cadastroPessoa(DadosCadastroPessoa dados){
        var pessoa = new Pessoa(dados);
        repository.save(pessoa);

        return "cadastro";

    }
}
