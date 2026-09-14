package kl.gestaoEscolar.controllers;

import kl.gestaoEscolar.entities.Aluno;
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

    // GET: Listar todos os alunos (http://localhost:8080/alunos)
    @GetMapping // atende requisições HTTP get
    public ResponseEntity<List<Aluno>> listarTodos() {
        List<Aluno> alunos = alunoService.buscarTodos();
        return ResponseEntity.ok(alunos);
    }

    // GET: Buscar aluno por ID (http://localhost:8080/alunos/1)
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable Long id) {
        Aluno aluno = alunoService.buscarPorId(id);
        return ResponseEntity.ok(aluno);
    }

    // POST: Cadastrar um novo aluno
    @PostMapping
    public ResponseEntity<Aluno> criar(@RequestBody Aluno aluno) {
        Aluno novoAluno = alunoService.salvar(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAluno);
    }

    // PUT: Atualizar os dados de um aluno existente
    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizar(@PathVariable Long id, @RequestBody Aluno aluno) {
        Aluno alunoAtualizado = alunoService.atualizar(id, aluno);
        return ResponseEntity.ok(alunoAtualizado);
    }

    // DELETE: Remover um aluno por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        alunoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
