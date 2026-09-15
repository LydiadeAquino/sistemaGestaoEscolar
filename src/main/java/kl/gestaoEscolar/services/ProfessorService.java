package kl.gestaoEscolar.services;


import kl.gestaoEscolar.dtos.ProfessorRequestDto;
import kl.gestaoEscolar.dtos.ProfessorResponseDto;
import kl.gestaoEscolar.entities.Professor;
import kl.gestaoEscolar.enums.Perfil;
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

    public List<ProfessorResponseDto> listarTodos(){
        return professorRepository.findAll()
                .stream()
                .map(ProfessorResponseDto::new)
                .collect(Collectors.toList());
    }

    public ProfessorResponseDto salvarProfessor(ProfessorRequestDto professorRequest){
        if(professorRepository.findByEmail(professorRequest.getEmail()).isPresent()){
            throw new RuntimeException("Email já cadastrado");
        }

        //da RequestDto para Entity
        Professor professor = new Professor();
        professor.setNome(professorRequest.getNome());
        professor.setEmail(professorRequest.getEmail());
        professor.setSenha(professorRequest.getSenha());
        professor.setPerfil(Perfil.PROFESSOR);
        Professor professorSalvo = professorRepository.save(professor);
        return new ProfessorResponseDto(professorSalvo);

    }


}
