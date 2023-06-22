package br.com.moller.peopleRegistrations.domain.people;

import java.util.Date;

public record DadosAlteracaoPessoa(Long id, String nome, Date dataNasc, String CPF, String sexo) {
}
