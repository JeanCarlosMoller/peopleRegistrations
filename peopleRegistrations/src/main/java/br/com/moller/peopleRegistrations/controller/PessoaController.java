package br.com.moller.peopleRegistrations.controller;

import br.com.moller.peopleRegistrations.domain.people.DadosAlteracaoPessoa;
import br.com.moller.peopleRegistrations.domain.people.DadosCadastroPessoa;
import br.com.moller.peopleRegistrations.domain.people.Pessoa;
import br.com.moller.peopleRegistrations.domain.people.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository repository;

    @GetMapping("/formulario")
    public String carregaPaginaFormulario(Long id, Model model){
        if(id != null){
            var pessoa = repository.getReferenceById(id);
            model.addAttribute("pessoa", pessoa);
        }
        return "pessoas/formulario";
    }

    @GetMapping
    public String carregaPaginaListagem(Model model){
        model.addAttribute("lista", repository.findAll());

        return "pessoas/listagem";
    }

    @PostMapping
    @Transactional
    public String cadastroPessoa(DadosCadastroPessoa dados){
        var pessoa = new Pessoa(dados);
        repository.save(pessoa);

        return "redirect:/pessoas";
    }

    @PutMapping
    @Transactional
    public String alteraPessoa(DadosAlteracaoPessoa dados){
        var pessoa = repository.getReferenceById(dados.id());
        pessoa.atualizaDados(dados);

        return "redirect:/pessoas";
    }

    @DeleteMapping
    @Transactional
    public String removePessoa(Long id){
        repository.deleteById(id);

        return "redirect:/pessoas";

    }
}
