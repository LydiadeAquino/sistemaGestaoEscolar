package kl.gestaoEscolar.services;

import kl.gestaoEscolar.entities.Aluno;
import kl.gestaoEscolar.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository; //herda do jpaRepository - possui os metodos.findAll;.findById();.save();.delete()

    // Buscar todos os alunos
    public List<Aluno> buscarTodos() {
        return alunoRepository.findAll();
    }

    // Buscar por ID (com tratamento caso não encontre)
    public Aluno buscarPorId(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com o ID: " + id));
                //optional do metodo .findById(); se não achar, devolve esse .orElseThrow -- sem ele, daria erro de nulo
    }

    // Salvar novo aluno
    public Aluno salvar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    // Atualizar aluno existente
    public Aluno atualizar(Long id, Aluno dadosAtualizados) {
        Aluno alunoExistente = buscarPorId(id); // Garante que o aluno existe

        // Atualiza os campos necessários
        alunoExistente.setNome(dadosAtualizados.getNome());
        alunoExistente.setEmail(dadosAtualizados.getEmail());
        alunoExistente.setSenha(dadosAtualizados.getSenha());
        alunoExistente.setPerfil(dadosAtualizados.getPerfil());

        return alunoRepository.save(alunoExistente);
    }

    // Deletar aluno
    public void deletar(Long id) {
        Aluno aluno = buscarPorId(id); // Garante que existe antes de deletar
        alunoRepository.delete(aluno);
    }
}

