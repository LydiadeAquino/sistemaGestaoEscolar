package kl.gestaoEscolar.entities;
import jakarta.persistence.*;
import kl.gestaoEscolar.enums.Perfil;

@Table(name = "tb_secretaria")
@Entity
public class Secretaria extends Usuario {

    public Secretaria(){
        super();
    }

    public Secretaria(Long id, String nome, String email, String senha, Perfil perfil){
        super(id, nome, email, senha, perfil);
    }


}
