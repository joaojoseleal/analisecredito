AnaliseCredito
=====

Projeto desenvolvido com a finalidade de facilitar a análise de crédito através de um classificador IBk treinado para essa finalidade.

# Tecnologias

Para desenvolver o sistema AnaliseCredito foram utilizados as seguintes ferramentas/frameworks:

- AnaliseCreditoBackend com Spring-boot

- AnaliseCreditoFrontend com AngularJs

- Banco de dados Mongodb

- Weka para treinar o classificador responsável pela tomada de decisão

# Composição da Stack

A Stack do AnaliseCredito é composta por 3 aplicações, são elas:

- AnaliseCreditoBackend: Serviço responsável pela comunicação com o frontend e tomada de decisão da análise de crédito

- Mongodb: Banco de dados

- AnaliseCreditoFrontend: frontend


## O que preciso para subir a aplicação

- Sistema Operacional Linux

- Docker, docker-compose, java e maven instalados

  
## Rodando a aplicação

Para rodar a aplicação você precisa abrir um terminal e ir até a pasta raiz do projeto e executar o arquivo start.sh com o comando :

sudo ./start.sh

Após rodar o comando e subir todos os serviços é só acessar o endereço :

http://localhost:80

## Documentação API
Com a finalidade de documentar as APIs foi adicionado o swagger para tal finalidade. O mesmo pode ser acessado pelos endereços abaixo:

- http://localhost:8080/analisecredito/swagger-ui.html
