package kl.gestaoEscolar.dtos;

import kl.gestaoEscolar.entities.Professor;

public class ProfessorResponseDto {


    private Long id;
    private String nome;
    private String email;

    //da Entity para DTO (via construtor)
    public ProfessorResponseDto(Professor professor){
        this.id = professor.getId();
        this.nome = professor.getNome();
        this.email = professor.getEmail();
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
