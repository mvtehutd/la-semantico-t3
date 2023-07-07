# T3 - Analisador Semântico
Marcos Cardoso Vendrame - 790725 <br/>
Carlos Eduardo Nascimento dos Santos - 791029


## 1.	Programas Necessários
Para compilar e executar o programa, é necessário ter instalado na máquina o Java, o Maven e o Antlr4. 
Nas compilações e execuções realizadas nesse trabalho, as versões utilizadas para esses softwares foram:

- Java (JDK 17.0.1 e JDK 17.0.6)
- Apache Maven 3.9.2
- ANTLR 4.11.0

É possível que outras versões também sejam compatíveis, então verifique a compatibilidade caso já os tenha instalado na máquina.

## 2.	Compilação e Execução do Programa
Para compilar o código, acesse o diretório em que foi salvo o projeto em sua máquina pelo terminal.
 
   ![image](https://github.com/mvtehutd/la-semantico-t3/assets/100847921/7813eaae-7263-426f-b60d-7d19daed3551)

 <p align="center"><i><b>Imagem 1:</b> Acessando o Diretório do Projeto</i></p>

Em seguida, execute o comando ```mvn package``` no terminal para que o Maven crie os arquivos e o programa com extensão *.jar* necessários.
  
   ![image](https://github.com/mvtehutd/la-semantico-t3/assets/100847921/eb02209a-b408-4586-b337-34442bc7494c)

<p align="center"><i><b>Imagem 2:</b> Realizando a Compilação</i></p>

![image](https://github.com/mvtehutd/la-semantico-t3/assets/100847921/748ce8f3-8d2b-4c6a-9013-12cbb79e722d)

<p align="center"><i><b>Imagem 3:</b> Mensagem Indicando Sucesso na Compilação</i></p>

Com a compilação finalizada, é possível executar o programa. Para isso, o comando a ser realizado é:

```java -jar <caminho do compilador> <arquivo de entrada> <arquivo de saída>```

  Sendo que: </br>
-	```<caminho do compilador>``` é o caminho completo até o arquivo de extensão *.jar* criado, lembrando de escolher o com as dependências. Ele está localizado na pasta target:
 
 ![image](https://github.com/mvtehutd/la-semantico-t3/assets/100847921/c9a17efa-81d1-4eb0-af6f-17085d9be03c)

<p align="center"><i><b>Imagem 4:</b> Localizando o Compilador no Projeto</i></p>

-	```<arquivo de entrada>``` é o caminho completo até o arquivo de extensão *.txt* com o algoritmo a ser analisado.

 ![image](https://github.com/mvtehutd/la-semantico-t3/assets/100847921/be8c7296-fbba-46f5-9416-4c7fdf1d4681)

<p align="center"><i><b>Imagem 5:</b> Exemplo de Arquivo de Entrada</i></p>

-	```<arquivo de saída>``` é o caminho completo até o arquivo de extensão *.txt* na qual serão salvos os resultados da análise.

 ![image](https://github.com/mvtehutd/la-semantico-t3/assets/100847921/439e714c-1e89-457d-9b39-22607c7a3326)

<p align="center"><i><b>Imagem 6:</b> Exemplo de Arquivo de Saída</i></p>

Exemplo de como o analisador deve rodar:
```
java -jar c:\compilador\meu-compilador.jar c:\casos-de-teste\arquivo1.txt c:\temp\saida.txt
```
