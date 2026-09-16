package kl.gestaoEscolar.services;


import kl.gestaoEscolar.dtos.ProfessorRequestDto;
import kl.gestaoEscolar.dtos.ProfessorResponseDto;
import kl.gestaoEscolar.entities.Professor;
import kl.gestaoEscolar.repositories.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorService {

    ProfessorRepository professorRepository;

    //injeção de dependências
    public ProfessorService(ProfessorRepository professorRepository){
        this.professorRepository = professorRepository;
    }


    //metodo que converte um RequestDto em uma Entidade Professor
    public Professor converterParaEntidade(ProfessorRequestDto professorRequest){
        Professor professor = new Professor();
        professor.setNome(professorRequest.nome());
        professor.setEmail(professorRequest.email());
        professor.setSenha(professorRequest.senha());
        return professor;


    }


    //é um metodo que "JOGA" os dados da entidade para o construtor que tem em DTO de resposta.
    public ProfessorResponseDto converterParaDto(Professor professor){
        return new ProfessorResponseDto(
                professor.getId(),
                professor.getNome(),
                professor.getEmail(),
                professor.getPerfil()
        );

    }


   public List<ProfessorResponseDto> listarTodos(){
        return professorRepository.findAll()
                .stream()
                .map(this::converterParaDto)
                .collect(Collectors.toList());

   }

   public ProfessorResponseDto buscarPorId(Long id){
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado com o ID: " + id));
        return converterParaDto(professor);

   }

   public ProfessorResponseDto salvarProfessor(ProfessorRequestDto professorRequest){
        Professor professor = converterParaEntidade(professorRequest);
        Professor professorSalvo = professorRepository.save(professor);
        return converterParaDto(professorSalvo);

   }

   public ProfessorResponseDto atualizarProfessor(Long id, ProfessorRequestDto professorRequest){
        Professor professorExistente = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado com o ID: " + id));

        professorExistente.setNome(professorRequest.nome());
        professorExistente.setEmail(professorRequest.email());
        professorExistente.setSenha(professorRequest.senha());
        professorExistente.setPerfil(professorRequest.perfil());
        Professor professorAtualizado = professorRepository.save(professorExistente);
        return converterParaDto(professorAtualizado);

   }

   public void deletarProfessor(Long id){
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado com ID: " + id));
        professorRepository.delete(professor);

   }






}
