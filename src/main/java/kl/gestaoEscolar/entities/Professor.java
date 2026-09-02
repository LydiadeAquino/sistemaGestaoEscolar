package kl.gestaoEscolar.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import kl.gestaoEscolar.enums.Perfil;

import java.util.ArrayList;
import java.util.List;

@Table(name= "tb_professor")
@Entity
public class Professor extends Usuario {

    @OneToMany(mappedBy = "professor")// O QUE DIZ QUE UM PROFESSOR PODE TER MUITAS DISCIPLINAS. MAPEAMENTO PELO "PROFESSOR"
    private List<Disciplina> disciplinas = new ArrayList<Disciplina>();

    //Construtor
    public Professor(){

    }

    public Professor (Long id, String nome, String email,String senha, Perfil perfil){
        super(id,nome,email,senha,perfil);
    }
    //GET E SET

    public List<Disciplina> getDisciplinas(){
        return disciplinas;
    }
    public void setDisciplinas(List<Disciplina> disciplinas ){
        this.disciplinas=disciplinas;
    }
}
