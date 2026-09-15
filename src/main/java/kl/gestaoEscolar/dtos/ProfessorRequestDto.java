package kl.gestaoEscolar.dtos;

public record ProfessorRequestDto (
    //não é necessário ter um atributo de id, porque nãao há registro do usúario no sistema ainda, o registro
    //é feito quando os dados é salvo no banco de dados.
    //record já gera automaticamente privates,getters e setters e toString
    String nome,
    String email,
    String senha
){ }




