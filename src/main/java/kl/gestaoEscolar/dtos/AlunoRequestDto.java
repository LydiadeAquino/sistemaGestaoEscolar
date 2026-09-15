package kl.gestaoEscolar.dtos;

import kl.gestaoEscolar.enums.Perfil;

//record já gera automaticamente privates,getters e setters e toString
public record AlunoRequestDto (
        String nome,
        String email,
        String senha,
        Perfil perfil
){ }
