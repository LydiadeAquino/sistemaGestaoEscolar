package kl.gestaoEscolar.entities;

import jakarta.persistence.Entity;
import kl.gestaoEscolar.enums.Perfil;

@Entity
public class Aluno extends Usuario {

    //construtor
    public Aluno(){

    }

    public Aluno (Long id, String nome, String email, String senha, Perfil perfil){
        super(id,nome,email,senha,perfil);

    }

}
