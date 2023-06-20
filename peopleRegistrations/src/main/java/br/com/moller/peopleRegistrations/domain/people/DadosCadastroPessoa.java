package br.com.moller.peopleRegistrations.domain.people;

import java.util.Date;

public record DadosCadastroPessoa(String nome, Date dataNasc, String CPF, String Sexo) {
}
