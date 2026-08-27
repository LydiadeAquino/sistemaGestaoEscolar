package kl.gestaoEscolar.entities;

import jakarta.persistence.*;
import kl.gestaoEscolar.enums.Perfil;

    @Entity
    @Inheritance(strategy = InheritanceType.JOINED) //Define a estratégia de tabelas vinculadas por ID

public abstract class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senha;

    @Enumerated(EnumType.STRING) //enum será salvo no MySQL como String
    @Column(nullable = false)// informa que não pode incluir usuario sem informar o perfil
    private Perfil perfil;

    //construtor
    public Usuario(){

    }

    public Usuario(Long id, String nome, String email, String senha, Perfil perfil){
        this.id=id;
        this.nome=nome;
        this.email=email;
        this.senha=senha;
        this.perfil=perfil;
    }


    // GET E SET
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome=nome;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public String getSenha(){
        return senha;
    }

    public void setSenha(String senha){
        this.senha=senha;
    }

    public Perfil getPerfil(){
        return perfil;
    }

    public void setPerfil (Perfil perfil){
        this.perfil=perfil;
    }

}
