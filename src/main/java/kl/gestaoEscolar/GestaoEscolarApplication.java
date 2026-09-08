package kl.gestaoEscolar;

import kl.gestaoEscolar.entities.*;
import kl.gestaoEscolar.enums.Perfil;
import kl.gestaoEscolar.enums.Situacao;
import kl.gestaoEscolar.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class GestaoEscolarApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoEscolarApplication.class, args);
	}

	@Bean
	public CommandLineRunner testarBancoDeDados(
			UsuarioRepository usuarioRepository,
			AlunoRepository alunoRepository,
			ProfessorRepository professorRepository,
			SecretariaRepository secretariaRepository,
			DisciplinaRepository disciplinaRepository,
			NotaRepository notaRepository){
		return args-> {
			System.out.println("\n----Testando Banco de Dados:---");

			//CRIA E SALVA UM USUARIO DO TIPO SECRETARIA
			Secretaria secretaria = new Secretaria();
			secretaria.setNome("Gabriela Santos");
			secretaria.setEmail("gabi32@email.com");
			secretaria.setSenha("123456");
			secretaria.setPerfil(Perfil.SECRETARIA);
			secretariaRepository.save(secretaria);

            //CRIA E SALVA UM USUARIO DO TIPO ALUNO
            Aluno aluno = new Aluno();
            aluno.setNome("Joseph Clinton");
            aluno.setEmail("joseph98@email.com");
            aluno.setSenha("jojo12345");
            aluno.setPerfil(Perfil.ALUNO);
            alunoRepository.save(aluno);

            //CRIA E SALVA TABELA NOTA
            Nota nota = new Nota();
            nota.setNota1(10.0);
            nota.setNota2(7.3);
            nota.setMedia(null);
            nota.setAluno(null);
            nota.setDisciplina(null);
            nota.setSituacao(null);
            nota.calcularMediaESituacao();
            notaRepository.save(nota);

            //ADICIONANDO OBJETO NOTA DENTRO DO ARRAYLIST PARA COLOCAR A VARIAVEL DENTRO DE DISCIPLINA
            List<Nota> listaNotas = new ArrayList<>();
            listaNotas.add(nota);

            //CRIA E SALVA TABELA DISCIPLINA
            Disciplina disciplina = new Disciplina();
            disciplina.setMateria("Matemática");
            disciplina.setProfessor(null);
            disciplina.setNota(listaNotas);
            disciplinaRepository.save(disciplina);

            //ADICIONANDO OBJETO DISCIPLINA DENTRO DO ARRAYLIST PARA COLOCAR A VARIAVEL DENTRO DE PROFESSOR
            List<Disciplina> listaDisciplinas = new ArrayList<>();
            listaDisciplinas.add(disciplina);

            //CRIA E SALVA USUARIO DO TIPO PROFESSOR
            Professor professor = new Professor();
            professor.setNome("Jurandir Werneck");
            professor.setEmail("juju1@email.com");
            professor.setSenha("123juju456");
            professor.setDisciplinas(listaDisciplinas);
            professor.setPerfil(Perfil.PROFESSOR);
            professorRepository.save(professor);


		};
	}

}
