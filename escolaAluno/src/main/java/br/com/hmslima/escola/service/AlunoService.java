package br.com.hmslima.escola.service;

import br.com.hmslima.escola.dto.AlunoResponse;
import br.com.hmslima.escola.dto.EnderecoResponse;
import br.com.hmslima.escola.entity.Aluno;
import br.com.hmslima.escola.exception.AlunoNotFoundExeption;
import br.com.hmslima.escola.feignclients.EnderecoClient;
import br.com.hmslima.escola.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AlunoService {

    private AlunoRepository alunoRepository;

    @Autowired
    EnderecoClient enderecoClient;

    @Autowired
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public AlunoResponse findAluno(Long id) {
        Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new AlunoNotFoundExeption(id));
        AlunoResponse alunoResponse = new AlunoResponse(aluno);

        alunoResponse.setEnderecoResponse(enderecoClient.findEndereco(aluno.getEnderecoId()));

        return alunoResponse;
    }

    public List<AlunoResponse> findAllAlunos() {
        List<AlunoResponse> alunos = alunoRepository.findAll().stream().map(aluno -> {
            AlunoResponse alunoResponse = aluno.getDto();
            alunoResponse.setEnderecoResponse(enderecoClient.findEndereco(aluno.getEnderecoId()));
            return alunoResponse;
        }).collect(Collectors.toList());
        return alunos;
    }

    public Aluno addAluno(Aluno aluno) {

        aluno.setId(0L);
        Aluno savedAluno = alunoRepository.save(aluno);
        return savedAluno;
    }

    public Aluno updateAluno(Aluno newAluno, Long id) {
        return alunoRepository.findById(id).map(aluno -> {
              aluno.setNome(newAluno.getNome());
              aluno.setSobrenome(newAluno.getSobrenome());
              aluno.setAno(newAluno.getAno());
              aluno.setEnderecoId(newAluno.getEnderecoId());
              return alunoRepository.save(aluno);
        })
        .orElseGet(() -> {
              newAluno.setId(id);
              return alunoRepository.save(newAluno);
        });
    }

    public void deleteAluno(Long id) {
        alunoRepository.deleteById(id);
    }
}
