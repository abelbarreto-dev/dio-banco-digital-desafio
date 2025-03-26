# DIO Banco Digital - Desafio
Implmentar desafio da DIO de um banco digital.

## Definição do Desafio

Desafio: Considerando nosso conhecimento no domínio bancário, 
iremos abstrair uma solução Orientada a Objetos em Java. Para isso, 
vamos interpretar o seguinte cenário: “Um banco oferece aos seus 
clientes dois tipos de contas (corrente e poupança), as quais possuem 
as funcionalidades de depósito, saque e transferência (entre contas da 
própria instituição).”

## Fucionalidades

* Criar Nova Conta Bancária;
  * Nome do titular;
  * Tipo da conta (enum); [aqui](src/com/abel/bank/enums/EnumAccountType.java)
    * NONE é o valor padrão mas não é válido para criar nova conta bancária;
  * Saldo (não pode ser negativo, é uma String em formato #.#);
* Realizar Depósito;
  * Nome do titular;
  * Valor em BigDecimal (positivo);
* Realizar Retirada;
  * Nome do titular;
  * Valor em BigDecimal (positivo);
* Realizar Consulta;
  * Nome do titular;
* Realizar Transferência;
  * Nome de quem envia;
  * Nome de quem recebe;
  * Valor em BigDecimal (positivo);
* Excluir Conta Bancária
  * Nome do titular

**Observação:** O nome do titular funciona como uma especie de ID para essa aplicação.

* Não existe restrição sobre transferência entre tipos de conta bancárias, (saving ou checking)
que é o mesmo que *conta poupança* ou *conta corrente* em português.

## Curiosidades

* Uilizo um java.Record para inferir os dados, no mesmo já existe validações dentro de um
construtor compacto. [Ver aqui](src/com/abel/bank/records/BankAccountRecord.java).
* Utilizo a integração com exceção genérica que aponta qual incossitência em linguagem
amigável ao usuário.

---
*That's All Folks*
