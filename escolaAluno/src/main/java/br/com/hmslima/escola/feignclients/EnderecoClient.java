package br.com.hmslima.escola.feignclients;

import br.com.hmslima.escola.dto.EnderecoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "${endereco.service.url}", value = "endereco-client")
public interface EnderecoClient {

    @GetMapping("/enderecos/{id}")
    public EnderecoResponse findEndereco(@PathVariable("id") Long id);

}
