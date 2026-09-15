package kl.gestaoEscolar.dtos;

public class ProfessorRequestDto {
    //não é necessário ter um atributo de id, porque nãao há registro do usúario no sistema ainda, o registro
    //é feito quando os dados é salvo no banco de dados.
    private String nome;
    private String email;
    private String senha;

    public String getNome(){
        return nome;
    }

    public String getEmail(){
        return email;
    }

    public String getSenha(){
        return senha;
    }

}
