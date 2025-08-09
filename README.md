💱 Conversor de Moedas em Java
Este projeto é um Conversor de Moedas desenvolvido em Java utilizando o HttpClient para realizar requisições à ExchangeRate API e obter taxas de câmbio em tempo real.
O objetivo é permitir que o usuário realize conversões de forma simples pelo console, com um menu de opções de moedas pré-definidas.

📌 Funcionalidades
- Menu com 6 opções de conversão de moedas.
- Consulta de taxas de câmbio atualizadas via API.
- Cálculo automático da conversão com base no valor inserido.
- Uso da biblioteca Gson para processar as respostas JSON da API.
- Código modular com métodos específicos para cada conversão.

🛠️ Tecnologias Utilizadas
- Java 11+ (necessário para usar HttpClient)
- IntelliJ IDEA (IDE utilizada no desenvolvimento)
- HttpClient (java.net.http) para requisições HTTP.
- Gson (gson-2.10.1.jar) para tratamento do JSON retornado.
- ExchangeRate API para obtenção das taxas de câmbio.

📂 Estrutura do Projeto

ConversorMoedas/
│
├── src/
│   ├── CurrencyConverter.java   # Classe principal com o menu e lógica de conversão
│   ├── ApiClient.java           # Classe responsável pela comunicação com a API
│
├── lib/
│   ├── gson-2.10.1.jar          # Biblioteca Gson
│
└── README.md                    # Este arquivo

⚙️ Como Executar o Projeto no IntelliJ
1- Clonar ou criar o projeto no IntelliJ
 * Criar um Java Project (não Maven/Gradle).
 * Nome do projeto: ConversorMoedas.

2- Adicionar a biblioteca Gson
 * Coloque gson-2.10.1.jar dentro da pasta lib.
 * Clique com o botão direito no .jar > Add as Library.

3- Configurar o SDK
 * File > Project Structure > Project SDK > selecione Java 11 ou superior.

4- Inserir seu API Key
 * Cadastre-se na ExchangeRate API e copie sua chave.
 * No código da classe ApiClient, substitua "SUA_API_KEY" pela sua chave.

5- Executar
 * Rodar CurrencyConverter.java pelo IntelliJ.
 * Escolher a opção de conversão no menu.

💡 Exemplo de Uso

===== CONVERSOR DE MOEDAS =====
1 - USD → BRL
2 - BRL → USD
3 - EUR → BRL
4 - BRL → EUR
5 - USD → EUR
6 - EUR → USD
Escolha uma opção: 1
Digite o valor: 100
100.00 USD = 520.34 BRL

📜 Licença
Este projeto é de uso livre para fins de estudo e prática.
