# Challenge-conversor-de-moedas_ONE -T08
Praticando Java: Challenge conversor de moedas

# Conversor de Moedas - Projeto Java

## Descrição

Este projeto é um Conversor de Moedas desenvolvido em Java, que utiliza a API Exchange Rate API para obter taxas de câmbio atualizadas e realizar conversões entre diferentes moedas. O objetivo é oferecer uma ferramenta simples e eficiente para converter valores entre moedas selecionadas, usando recursos modernos do Java como HttpClient e Gson para manipulação de dados JSON.

## Tecnologias Utilizadas

- Java JDK 11 ou superior  
- Biblioteca Gson 2.10.1 ou superior  
- API Exchange Rate API (https://www.exchangerate-api.com/)  
- IntelliJ IDEA (IDE recomendada, opcional)  
- Postman (para testes da API, opcional)

## Funcionalidades

- Consulta dinâmica das taxas de câmbio através de requisições HTTP para a API Exchange Rate API  
- Conversão de valores entre as moedas: ARS (Peso Argentino), BOB (Boliviano), BRL (Real Brasileiro), CLP (Peso Chileno), COP (Peso Colombiano) e USD (Dólar Americano)  
- Interface textual interativa no console para facilitar a interação com o usuário  
- Validação e tratamento de entradas do usuário para garantir robustez  
- Modularização do código com métodos específicos para requisição, processamento dos dados e cálculo das conversões  

## Como Rodar o Projeto

1. **Pré-requisitos:**  
   - Ter o Java JDK 11 ou superior instalado  
   - Baixar a biblioteca Gson e adicioná-la ao projeto (pode ser via IntelliJ, conforme tutorial)  
   - Obter uma chave de API válida na Exchange Rate API (https://www.exchangerate-api.com/)  

2. **Configuração:**  
   - Inserir sua chave de API no código, na variável destinada para isso  

3. **Execução:**  
   - Compile e rode a aplicação pela sua IDE ou terminal  
   - No console, escolha as moedas para conversão e insira o valor desejado  

## Estrutura do Código

- **HttpClient:** utilizado para enviar requisições HTTP e receber respostas da API  
- **HttpRequest:** configura as requisições com a URL e parâmetros necessários  
- **HttpResponse:** gerencia as respostas da API, incluindo códigos de status e corpo da resposta JSON  
- **Gson:** faz o parsing do JSON e mapeia os dados para objetos Java para fácil manipulação  
- **Scanner:** captura as entradas do usuário no console para interação dinâmica  

## Exemplo de Uso

Bem-vindo ao Conversor de Moedas!
Escolha a moeda de origem:
1 - Real Brasileiro (BRL)
2 - Dólar Americano (USD)
3 - Peso Argentino (ARS)
...

Informe o valor a ser convertido: 100
Escolha a moeda de destino:
1 - Dólar Americano (USD)
2 - Peso Colombiano (COP)
...

Resultado: 100 BRL equivalem a 18.75 USD



## Testes e Validação

O programa foi testado em diferentes cenários, incluindo valores inválidos, moedas não suportadas e casos extremos, para garantir estabilidade e precisão nas conversões.

## Contato

Tatiane Souza – Sowzatech   
LinkedIn: [https://www.linkedin.com/in/tatiane-souza-tech/]
