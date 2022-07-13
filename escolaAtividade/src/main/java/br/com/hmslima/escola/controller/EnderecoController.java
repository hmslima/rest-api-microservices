package br.com.hmslima.escola.controller;

import br.com.hmslima.escola.entity.Endereco;
import br.com.hmslima.escola.service.EnderecoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class EnderecoController {
    private EnderecoService enderecoService;

    public EnderecoController(EnderecoService atividadeService) {
        this.enderecoService = atividadeService;
    }

    @GetMapping("/enderecos")
    public ResponseEntity<List<Endereco>> findEnderecos() {
        List<Endereco> atividades = enderecoService.findAtividades();
        return new ResponseEntity<>(atividades, HttpStatus.OK);
    }

    @GetMapping("/enderecos/{id}")
    public ResponseEntity<Endereco> findEndereco(@PathVariable("id") Long id) {
        Endereco endereco = enderecoService.findAtividade(id);
        return new ResponseEntity<>(endereco, HttpStatus.OK);
    }

    @PostMapping("/enderecos")
    public ResponseEntity addEndereco(@RequestBody Endereco atividade) {
        atividade.setId(0L);
        Endereco savedEndereco = enderecoService.saveAtividade(atividade);
        return new ResponseEntity<>(savedEndereco, HttpStatus.CREATED);
    }

    @PutMapping("/enderecos/{id}")
    public ResponseEntity updateEndereco(@RequestBody Endereco atividade, @PathVariable("id") Long id) {
        Endereco updatedEndereco = enderecoService.updateAtividade(atividade, id);
        return new ResponseEntity<>(updatedEndereco, HttpStatus.OK);
    }

    /*@PutMapping("/enderecos/")
    public ResponseEntity updateEndereco(@RequestBody Endereco atividade) {
        Endereco updatedEndereco = enderecoService.saveAtividade(atividade);
        return new ResponseEntity<>(updatedEndereco, HttpStatus.OK);
    }*/

    @DeleteMapping("/enderecos/{id}")
    public ResponseEntity deleteEndereco(@PathVariable("id") Long id) {
        enderecoService.deleteAtividade(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
