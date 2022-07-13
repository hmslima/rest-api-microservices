package br.com.hmslima.escola.exception;

public class AlunoNotFoundExeption extends RuntimeException{

    public AlunoNotFoundExeption(Long id) {
        super("Não foi possível encontrar o aluno " + id);
    }
}
