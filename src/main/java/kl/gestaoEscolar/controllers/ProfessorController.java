package kl.gestaoEscolar.controllers;

import kl.gestaoEscolar.dtos.ProfessorRequestDto;
import kl.gestaoEscolar.dtos.ProfessorResponseDto;
import kl.gestaoEscolar.services.ProfessorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    private ProfessorService professorService;

    //injeção de dependências
    public ProfessorController (ProfessorService professorService){
        this.professorService = professorService;
    }

    @GetMapping
    public ResponseEntity<List<ProfessorResponseDto>> listarProfessor (){
        return ResponseEntity.ok(professorService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<ProfessorResponseDto> cadastrarProfessor(
             @RequestBody  ProfessorRequestDto professorRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(professorService.salvarProfessor(professorRequest));


    }


}
