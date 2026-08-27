package kl.gestaoEscolar.entities;


import jakarta.persistence.*;

@Entity
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    private Double nota1;
    private Double nota2;
    private Double media;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name ="disciplina_id")
    private Disciplina disciplina;

    @Enumerated(EnumType.STRING)
    private Situacao situacao;

    public Nota(){

    }

    public Nota(Long id, Double nota1, Double nota2, Double media, Aluno aluno, Disciplina disciplina, Situacao situacao){
        this.id = id;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.media = media;
        this.aluno = aluno;
        this.disciplina = disciplina;
        this.situacao = situacao;
    }

    public Long getId(){
        return  id;
    }

    public void setId(Long id){
        this.id=id;

    }

    public Double getNota1(){
        return  nota1;
    }

    public void setNota1(Double nota1){
        this.nota1=nota1;

    }

    public Double getNota2(){
        return  nota2;
    }

    public void setNota2(Double nota2){
        this.nota2=nota2;

    }

    public Double getMedia(){
        return  media;
    }

    public void setMedia(Double media){
        this.media=media;

    }

    public Aluno getAluno(){
        return aluno;
    }

    public void setAluno(Aluno aluno){
        this.aluno=aluno;
    }

    public Disciplina getDisciplina(){
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina){
        this.disciplina =disciplina;
    }

    public Situacao getSituacao(){
        return situacao;
    }

    public void setSituacao(Situacao situacao){
        this.situacao = situacao;
    }

}
