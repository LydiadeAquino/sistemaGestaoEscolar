package kl.gestaoEscolar.entities;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Disciplina {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, unique = true)
        private String materia;

        //um professor ministra uma disciplina
        @ManyToOne
        @JoinColumn(name = "professor_id")
        private Professor professor;

        //uma disciplina pode ter várias notas lançadas
        @OneToMany(mappedBy = "disciplina")
        private List<Nota> notas;

        public Disciplina(){

        }

        public Disciplina(Long id, String meteria, Professor professor, List<Nota> notas){
                this.id=id;
                this.materia=materia;
                this.professor=professor;
                this.notas=notas;
        }

        public Long getId(){
                return  id;
        }

        public void setId(Long id){
                this.id=id;

        }

        public String getMateria(){
                return materia;
        }

        public void setMateria(String materia){
                this.materia =materia;
        }

        public Professor getProfessor(){
                return professor;
        }

        public void setProfessor(Professor professor){
                this.professor = professor;
        }

        public List<Nota> getNota(){
                return notas;
        }

        public void setNota(List<Nota> notas){
                this.notas = notas;
        }
}
