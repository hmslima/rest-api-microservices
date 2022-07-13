package br.com.hmslima.escola.service;

import br.com.hmslima.escola.entity.Endereco;
import br.com.hmslima.escola.exception.EnderecoNotFoundExeption;
import br.com.hmslima.escola.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EnderecoService {

    private EnderecoRepository enderecoRepository;

    @Autowired
    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public Endereco findAtividade(Long id) {
        return enderecoRepository.findById(id).orElseThrow(() -> new EnderecoNotFoundExeption(id));
    }

    public List<Endereco> findAtividades() {
        return enderecoRepository.findAll();
    }

    public Endereco saveAtividade(Endereco atividade) {
        enderecoRepository.save(atividade);
        return atividade;
    }

    public Endereco updateAtividade(Endereco newEndereco, Long id) {
        return enderecoRepository.findById(id).map(endereco -> {
            endereco.setRua(newEndereco.getRua());
            endereco.setNumero(newEndereco.getNumero());
            return enderecoRepository.save(endereco);
        })
        .orElseGet(() -> {
            newEndereco.setId(id);
            return enderecoRepository.save(newEndereco);
        });
    }

    public void deleteAtividade(Long id) {
        enderecoRepository.deleteById(id);
    }
}
