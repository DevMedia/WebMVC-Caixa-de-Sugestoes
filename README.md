# Aplicação Spring Boot MVC de caixa de sugestões 

Ao obter o código dessa aplicação você terá à sua disposição exemplos de como configurar uma aplicação Spring Boot com os frameworks Spring Framework, Spring MVC, usando como motor de templates o Thymeleaf, bem como o Spring Data JPA.

Confira uma explicação completa desse código e o passo a passo para criar essa aplicação em https://www.devmedia.com.br/primeiros-passos-java/.

## Destaques do projeto

* Spring Boot
* Spring Framework
* Spring MVC
* Spring Data JPA
* Bean Validation

## Clonando o projeto a partir do GitHub

Para clonar o repositório deste projeto a partir do GitHub você precisa ter o GIT instalado em seu computador. Caso você esteja em um ambiente Windows, vá até a página https://git-scm.com/download/win, faça o download do instalador do GIT e prossiga com a instalação. Após isso, abra o prompt de comandos para executar o seguinte:

```
git clone https://github.com/estevaodias/caixa-de-sugestoes.git
```

Aguarde até que todos os arquivos sejam baixados para o seu computador.

## Fazendo o deploy da aplicação no Heroku

Para enviar o seu projeto para o Heroku e publicar a sua aplicação você deve ter uma conta criada, além de instalar em seu computador o Heroku CLI. Nas URLs abaixo você conseguirá realizar ambos esses passos.

https://devcenter.heroku.com/articles/heroku-cli
https://id.heroku.com/login

Acesse o prompt de comandos novamente e vá até o diretório no qual o projeto foi clonado do GitHub.

```
cd caixa-de-sugestoes
```

No diretório do projeto digite os seguintes comandos:

```
heroku login
heroku create
heroku git push heroku master
heroku create
heroku logs --app dm-caixa-de-sugestoes --tail
```

Agora, precisamos configurar o banco de dados da aplicação no arquivo application.yaml, bem como adicionar suporte a um banco de dados no projeto que criamos com o Heroku CLI nos passos acima. Aqui utilizaremos o ClearDB, um addon que possui uma versão gratuita, para instalar o MySQL. Antes de instalar o ClearDB certifique-se de habilitar a cobrança no Heroku, pois essa é uma exigência para a instalação deste addon.

https://dashboard.heroku.com/account/billing

No prompt de comandos execute os seguintes comandos.

```
heroku addons:create cleardb:ignite
heroku config
```

O comando heroku config exibirá a URL de conexão com o banco de dados, a partir da qual modificaremos as configurações do arquivo aplication.yaml, de acordo com essas necessidades de deploy.

```
CLEARDB_DATABASE_URL: 
  mysql://bbd1ca985a75ae:b3270a98@us-cdbr-iron-east-03.cleardb.net/heroku_eb3ec026f66e354?reconnect=true
```

Levando em consideração a URL acima, para conectar essa aplicação com o banco de dados heroku_eb3ec026f66e354, devemos modificar o arquivo application.yaml da seguinte forma:

```
spring:
  datasource:
    url: jdbc:mysql://us-cdbr-iron-east-03.cleardb.net/heroku_eb3ec026f66e354?reconnect=true
    username: bbd1ca985a75ae
    password: b3270a98

  jpa:
    hibernate:
      ddl-auto: update
    show_sql: true
```

Uma vez que cada um desses passos tenha sido executado com sucesso, podemos executar a aplicação com o seguinte comando:

```
heroku open
```

## Glossário

#### Spring Boot

O Spring Boot é uma ferramenta para o desenvolvimento de aplicações que utilizam o framework Spring sem que seja necessária praticamente nenhuma configuração.

#### Spring Framework

Esse framework implementa um grande número de funções, como injeção de dependência, persistência de dados e uma implementação para o padrão MVC para a criação de aplicações WEB.

#### Spring MVC

O Framework Spring MVC é um framework web MVC desenvolvido pela Spring Source e de código aberto. Ele é projetado em torno de um Servlet, o DispatcherServlet, que despacha pedidos para os controladores. Um controlador padrão do Spring MVC faz uso das anotações @Controller e @RequestMapping, que oferecem uma ampla gama de recursos flexíveis para manipulação das requisições.

#### Spring Data JPA

Spring Data JPA simplifica o desenvolvimento de projetos que envolvam operações entre objetos e dados de uma tabela.

#### Bean Validation

A garantia de que os dados sejam utilizados de forma correta e as regras sobre estes permaneçam consistentes para uma eficaz utilização das aplicações computacionais, sempre foram um desafio para os programadores. Com a chegada da JSR 303, conhecida como Bean Validation, os programadores Java passaram a ter um rápido recurso de validação e controle sobre os dados utilizados nas aplicações, mantendo o código claro e enxuto.