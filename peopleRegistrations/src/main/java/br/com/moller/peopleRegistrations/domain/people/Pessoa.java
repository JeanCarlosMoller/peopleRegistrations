package br.com.moller.peopleRegistrations.domain.people;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "pessoas")
public class Pessoa {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;
    private Date dataNasc;
    private String CPF;
    private String sexo;

    public Pessoa(DadosCadastroPessoa dados){
        this.nome = dados.nome();
        this.dataNasc = dados.dataNasc();
        this.CPF = dados.CPF();
        this.sexo = dados.Sexo();

    }

    public Pessoa(){

    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataNasc=" + dataNasc +
                ", CPF='" + CPF + '\'' +
                ", Sexo='" + sexo + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public String getCPF() {
        return CPF;
    }

    public String getSexo() {
        return sexo;
    }

    public void atualizaDados(DadosAlteracaoPessoa dados){
        this.nome = dados.nome();
        this.dataNasc = dados.dataNasc();
        this.CPF = dados.CPF();
        this.sexo = dados.sexo();
    }
}
