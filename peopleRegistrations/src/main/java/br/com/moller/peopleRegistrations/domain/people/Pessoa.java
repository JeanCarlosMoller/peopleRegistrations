package br.com.moller.peopleRegistrations.domain.people;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "pessoas")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    //private Date dataNasc;
    private String CPF;
    private String sexo;

    public Pessoa(DadosCadastroPessoa dados){
        this.nome = dados.nome();
        //this.dataNasc = dados.dataNasc();
        this.CPF = dados.CPF();
        this.sexo = dados.sexo();

    }

    public Pessoa(){

    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                //", dataNasc=" + dataNasc +
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

    //public Date getDataNasc() {
        //return dataNasc;
    //}

    public String getCPF() {
        return CPF;
    }

    public String getSexo() {
        return sexo;
    }

    public void atualizaDados(DadosAlteracaoPessoa dados){
        this.nome = dados.nome();
        //this.dataNasc = dados.dataNasc();
        this.CPF = dados.CPF();
        this.sexo = dados.sexo();
    }
}
