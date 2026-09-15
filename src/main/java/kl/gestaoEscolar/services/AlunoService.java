package kl.gestaoEscolar.services;

import kl.gestaoEscolar.dtos.AlunoRequestDto;
import kl.gestaoEscolar.dtos.AlunoResponseDto;
import kl.gestaoEscolar.entities.Aluno;
import kl.gestaoEscolar.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository; //herda do jpaRepository - possui os metodos.findAll;.findById();.save();.delete()

    // Métodos auxiliares de conversão
    private AlunoResponseDto converterParaDTO(Aluno aluno) {
        return new AlunoResponseDto(
                aluno.getId(),
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getPerfil()
        );
    }

    private Aluno converterParaEntidade(AlunoRequestDto dto) {
        Aluno aluno = new Aluno();
        aluno.setNome(dto.nome());
        aluno.setEmail(dto.email());
        aluno.setSenha(dto.senha());
        aluno.setPerfil(dto.perfil());
        return aluno;
    }

    // Listar todos
    public List<AlunoResponseDto> buscarTodos() {
        return alunoRepository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    // Buscar por ID
    public AlunoResponseDto buscarPorId(Long id) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com o ID: " + id));
        return converterParaDTO(aluno);
    }

    // Salvar novo aluno
    public AlunoResponseDto salvar(AlunoRequestDto dto) {
        Aluno aluno = converterParaEntidade(dto);
        Aluno alunoSalvo = alunoRepository.save(aluno);
        return converterParaDTO(alunoSalvo);
    }

    // Atualizar aluno existente
    public AlunoResponseDto atualizar(Long id, AlunoRequestDto dto) {
        Aluno alunoExistente = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com o ID: " + id));

        alunoExistente.setNome(dto.nome());
        alunoExistente.setEmail(dto.email());
        alunoExistente.setSenha(dto.senha());
        alunoExistente.setPerfil(dto.perfil());

        Aluno alunoAtualizado = alunoRepository.save(alunoExistente);
        return converterParaDTO(alunoAtualizado);
    }

    // Deletar aluno
    public void deletar(Long id) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com o ID: " + id));
        alunoRepository.delete(aluno);
    }
}
