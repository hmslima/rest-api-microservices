package br.com.hmslima.escola.controller;

import br.com.hmslima.escola.dto.AlunoResponse;
import br.com.hmslima.escola.entity.Aluno;
import br.com.hmslima.escola.feignclients.EnderecoClient;
import br.com.hmslima.escola.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class AlunoController {

    private AlunoService alunoService;

    @Autowired
    EnderecoClient enderecoClient;

    @Autowired
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping("/alunos/{id}")
    public ResponseEntity<AlunoResponse> findAluno(@PathVariable("id") Long id) {
        AlunoResponse aluno = alunoService.findAluno(id);
        return new ResponseEntity<>(aluno, HttpStatus.OK);
    }

    @GetMapping("/alunos")
    public ResponseEntity<List<AlunoResponse>> findAllAlunos() {
        List<AlunoResponse> alunos = alunoService.findAllAlunos();
        return new ResponseEntity<>(alunos, HttpStatus.OK);
    }

    @PostMapping("/alunos")
    public ResponseEntity<AlunoResponse> addAluno(@RequestBody Aluno aluno) {
        Aluno addedAluno = alunoService.addAluno(aluno);
        AlunoResponse alunoResponse = addedAluno.getDto();
        alunoResponse.setEnderecoResponse(enderecoClient.findEndereco(aluno.getEnderecoId()));
        return new ResponseEntity<>(alunoResponse, HttpStatus.CREATED);
    }

    @PutMapping("/alunos/{id}")
    public ResponseEntity<AlunoResponse> updateAluno(@RequestBody Aluno aluno, @PathVariable("id") Long id) {
        Aluno updatedAluno = alunoService.updateAluno(aluno, id);
        AlunoResponse alunoResponse = updatedAluno.getDto();
        alunoResponse.setEnderecoResponse(enderecoClient.findEndereco(aluno.getEnderecoId()));
        return new ResponseEntity<>(alunoResponse, HttpStatus.OK);
    }

    @DeleteMapping("/alunos/{id}")
    public ResponseEntity<?> deleteAluno(@PathVariable("id") Long id) {
        alunoService.deleteAluno(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
