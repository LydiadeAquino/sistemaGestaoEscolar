package kl.gestaoEscolar.entities;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Disciplina {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, unique = true)
        private String nome;

        //um professor ministra uma disciplina
        @ManyToOne
        @JoinColumn(name = "professor_id")
        private Professor professor;

        //uma disciplina pode ter várias notas lançadas
        @OneToMany(mappedBy = "disciplina")
        private List<Nota> notas;
}
