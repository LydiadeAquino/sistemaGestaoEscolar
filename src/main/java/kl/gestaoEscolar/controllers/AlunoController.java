package kl.gestaoEscolar.controllers;

import kl.gestaoEscolar.dtos.AlunoRequestDto;
import kl.gestaoEscolar.dtos.AlunoResponseDto;
import kl.gestaoEscolar.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // faz com que as respostas dos metodos sejam enviadas diretamente no corpo da resposta HTTP
@RequestMapping("/alunos")

public class AlunoController {
    @Autowired //injeção de dependencia
    private AlunoService alunoService;

    // GET: Listar todos os alunos -> lista de AlunoResponseDTO
    @GetMapping // atende requisições HTTP get
    public ResponseEntity<List<AlunoResponseDto>> listarTodos() {
        List<AlunoResponseDto> alunos = alunoService.buscarTodos();
        return ResponseEntity.ok(alunos);
    }

    // GET: Buscar aluno por ID -> devolve um AlunoResponseDTO de acordo com o ID
    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponseDto> buscarPorId(@PathVariable Long id) {
        AlunoResponseDto aluno = alunoService.buscarPorId(id);
        return ResponseEntity.ok(aluno);
    }

    // POST: Cadastrar um novo aluno -> recebe AlunoRequestDTO e devolve Aluno ResponseDTO
    @PostMapping
    public ResponseEntity<AlunoResponseDto> criar(@RequestBody AlunoRequestDto dto) {
        AlunoResponseDto novoAluno = alunoService.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAluno);
    }

    // PUT: Atualizar os dados de um aluno existente -> recebe AlunoRequestDTO e devolve AlunoResponseDTO atualizado
    @PutMapping("/{id}")
    public ResponseEntity<AlunoResponseDto> atualizar(@PathVariable Long id, @RequestBody AlunoRequestDto dto) {
        AlunoResponseDto alunoAtualizado = alunoService.atualizar(id, dto);
        return ResponseEntity.ok(alunoAtualizado);
    }

    // DELETE: Remover um aluno por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        alunoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
