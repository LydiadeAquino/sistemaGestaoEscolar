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
    public ResponseEntity<List<ProfessorResponseDto>> listar (){
        List<ProfessorResponseDto> listaProfessor = professorService.listarTodos();
        return ResponseEntity.ok(listaProfessor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorResponseDto> buscarPorId (@PathVariable Long id){
        ProfessorResponseDto professor = professorService.buscarPorId(id);
        return ResponseEntity.ok(professor);

    }

    @PostMapping
    public ResponseEntity<ProfessorResponseDto> cadastrar(
             @RequestBody  ProfessorRequestDto professorRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(professorService.salvarProfessor(professorRequest));


    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessorResponseDto> atualizar(
            @PathVariable Long id, @RequestBody ProfessorRequestDto professorRequest){
        ProfessorResponseDto professorAtualizado = professorService.atualizarProfessor( id, professorRequest);
        return ResponseEntity.ok(professorAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        professorService.deletarProfessor(id);
        return ResponseEntity.noContent().build();
    }

}
