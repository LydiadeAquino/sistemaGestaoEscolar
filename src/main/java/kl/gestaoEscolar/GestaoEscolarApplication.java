package kl.gestaoEscolar;

import kl.gestaoEscolar.entities.Secretaria;
import kl.gestaoEscolar.enums.Perfil;
import kl.gestaoEscolar.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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


		};
	}

}
