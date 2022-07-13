package br.com.hmslima.escola.exception;

public class EnderecoNotFoundExeption extends RuntimeException{

    public EnderecoNotFoundExeption(Long id) {
        super("Não foi possível encontrar o endereço " + id);
    }
}
