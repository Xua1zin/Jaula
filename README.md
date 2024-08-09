# Jaula

**Jaula** é um aplicativo em Java desenvolvido para a gestão de clínicas de nutricionistas. Este projeto foi criado como parte de um trabalho acadêmico e oferece funcionalidades para o gerenciamento de usuários e pacientes.

## Descrição

Jaula é um sistema desenvolvido para facilitar a administração de clínicas de nutrição, permitindo o gerenciamento de usuários, pacientes e suas respectivas fichas. O projeto é inteiramente desenvolvido em Java, incluindo a criação da interface gráfica utilizando Java Swing.

As fichas dos pacientes são associadas a eles no banco de dados e não podem ser excluídas, garantindo a integridade dos dados. Além disso, cada ficha possui um status que permite o controle do andamento dos exames, podendo estar marcado como **Concluído**, **Cancelado** ou **Em Andamento**. O uso de Java Swing para a interface gráfica proporciona uma experiência de usuário funcional, totalmente gerenciada em Java puro, infelizmente não tem muitos enfeites.


## Funcionalidades

- **Criação de Usuário**: Apenas administradores podem criar novos usuários no sistema.
- **Cadastro de Pacientes**: Registro e gerenciamento de pacientes.
- **Fichas de Pacientes**: Criação e visualização das fichas dos pacientes. As fichas são permanentemente associadas aos pacientes e não podem ser removidas.

## Tecnologias

- **Linguagem**: Java
- **Banco de Dados**: MySQL
- **IDE**: NetBeans
