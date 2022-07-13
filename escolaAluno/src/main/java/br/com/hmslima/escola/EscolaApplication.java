package br.com.hmslima.escola;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EscolaApplication {

	@Value("${endereco.service.url}")
	private String enderecoServiceUrl;

	public static void main(String[] args) {
		SpringApplication.run(EscolaApplication.class, args);
	}

}
