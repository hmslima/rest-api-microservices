package br.com.hmslima.escola.repository;

import br.com.hmslima.escola.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
}