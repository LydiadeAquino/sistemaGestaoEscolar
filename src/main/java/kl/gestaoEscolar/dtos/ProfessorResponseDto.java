package kl.gestaoEscolar.dtos;

import kl.gestaoEscolar.entities.Professor;
import kl.gestaoEscolar.enums.Perfil;

public class ProfessorResponseDto {
    //na resposta da API para o cliente é necessário ter id para que o cliente saiva que o id de tal registro
    //pertence a tal usuário, pois quando há uma resposta, o dados da requisição já passou pela entidade
    //que é a responsável por gerar um ID(@GeneratedValue) para cada registro.

    private Long id;
    private String nome;
    private String email;
    private Perfil perfil;

    //da Entity para DTO (via construtor)
    public ProfessorResponseDto(Professor professor){
        this.id = professor.getId();
        this.nome = professor.getNome();
        this.email = professor.getEmail();
        this.perfil = professor.getPerfil();
    }


    public Long getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public String getEmail(){
        return email;
    }

}
