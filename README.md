# API REST onde uso microsserviços

Se trata de uma API em que aplico a prática de microsserviços:

[(Link)](https://alunoservice.herokuapp.com/api/alunos)

*Pode demorar um pouco para carregar porque fiz uso de um serviço gratuito e o servidor fica nos Estados Unidos. Espero que vocês compreendam.* <br> **Se der alguma mensagem de erro, eu peço que você atualize a página mais algumas vezes, é assim mesmo...***

Reparem que cada aluno tem um endereço. Pois bem, os endereços são carregados de OUTRA API, que é esta aqui:

[(Link)](https://enderecoservice.herokuapp.com/api/enderecos)

A comunicação entre as APIs foi feita por meio do Spring Cloud OpenFeign.

Sei que não é um dos projetos mais chamativos, como o Mural de Recados que eu tinha feito anteriormente que, ao menos, tinha uma interface gráfica graças ao Angular, mas este projeto foi importante para que eu treinasse a prática de microsserviços.