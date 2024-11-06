
# MyApplication

MyApplication é um aplicativo Android projetado para gerenciar e exibir informações específicas do usuário, com funcionalidades de autenticação, notificações, visualização de sinistros e ajustes de conta. Este README serve para orientar o uso do aplicativo, explicar como configurá-lo e fornecer uma visão geral técnica de suas funcionalidades.

## Índice

- [Instalação](#instalação)
- [Configuração Inicial](#configuração-inicial)
- [Funcionalidades Principais](#funcionalidades-principais)
  - [Registro de Usuário](#registro-de-usuário)
  - [Login de Usuário](#login-de-usuário)
  - [Exibição de Sinistros](#exibição-de-sinistros)
  - [Notificações](#notificações)
  - [Informações da Conta](#informações-da-conta)
  - [Ajustes](#ajustes)
- [APIs Utilizadas](#apis-utilizadas)
- [Configurações de Projeto](#configurações-de-projeto)
- [Contribuição](#contribuição)

## Instalação

1. Clone o repositório do GitHub:
   ```bash
   git clone https://github.com/seu_usuario/MyApplication.git
   ```

2. Abra o projeto no Android Studio.

3. Conecte o Android Studio à sua conta do Firebase para sincronizar a configuração `google-services.json` do Firebase.

4. Compile e execute o aplicativo em um emulador ou dispositivo físico.

## Configuração Inicial

Antes de usar o aplicativo, siga estas instruções para configurar corretamente as APIs e autenticações necessárias:

1. **Configurar Firebase**: Certifique-se de que as configurações do Firebase estão corretas. Isso inclui a autenticação de e-mail e senha.

2. **Dependências**: Verifique o arquivo `build.gradle` para assegurar que todas as dependências estão atualizadas e corretamente configuradas, especialmente as que tratam da autenticação e armazenamento de dados do usuário.

## Funcionalidades Principais

### Registro de Usuário

Para registrar um novo usuário:

1. Abra o aplicativo e selecione **Registrar**.
2. Preencha o formulário de registro com as seguintes informações:
   - Nome de usuário
   - CPF
   - E-mail
   - Senha
3. Clique em **Registrar**. O aplicativo verificará os dados inseridos e, caso estejam corretos, criará uma nova conta de usuário. Os dados do usuário são então salvos no Firebase.

### Login de Usuário

Após ter registrado uma conta:

1. Abra o aplicativo e vá para a tela de **Login**.
2. Insira seu e-mail e senha cadastrados.
3. Clique em **Entrar**. Se as credenciais estiverem corretas, o aplicativo autentica o usuário e redireciona para a tela principal do aplicativo (Home).

### Exibição de Sinistros

A tela de sinistros permite ao usuário visualizar consultas odontológicas e identificar sinistros com valores altos ou incomuns:

1. Na tela inicial, selecione **Sinistros**.
2. A tela de sinistros exibe uma lista de registros, com cada item mostrando o **nome do paciente**, **CPF** e **data da consulta**.
3. Para obter mais detalhes sobre um sinistro, o usuário pode clicar no item para expandir e ver informações adicionais, como **nome do dentista**, **custo** e **descrição do tratamento**.

### Notificações

A funcionalidade de notificações mantém o usuário atualizado com informações importantes:

1. Acesse **Notificações** no menu principal.
2. A tela de notificações exibe uma lista de mensagens e alertas relevantes. A funcionalidade pode ser integrada com Firebase Cloud Messaging (FCM) para notificações push em tempo real.

### Informações da Conta

Esta funcionalidade permite que o usuário visualize e edite informações pessoais:

1. Na tela principal, selecione **Minha Conta**.
2. O usuário pode visualizar informações como nome, CPF, e-mail e outros dados cadastrados.
3. Para atualizar as informações, edite os campos desejados e clique em **Salvar Alterações**.

### Ajustes

O aplicativo permite ao usuário ajustar preferências e configurações do aplicativo:

1. Vá para a tela de **Ajustes**.
2. Nessa tela, o usuário pode personalizar notificações, preferências de segurança e outras configurações.

## APIs Utilizadas

O MyApplication utiliza várias APIs para oferecer suporte a suas funcionalidades principais:

- **Firebase Authentication**: Gerencia o login e registro de usuários, utilizando autenticação de e-mail e senha.
- **Firebase Realtime Database / Firestore**: Armazena dados dos usuários, como informações de conta e sinistros.
- **Firebase Cloud Messaging (FCM)**: Para envio de notificações push, atualizando o usuário com novas mensagens e alertas em tempo real.

## Configurações de Projeto

Certifique-se de que o projeto possui os seguintes arquivos e configurações:

1. `google-services.json`: Necessário para a integração com o Firebase. Este arquivo deve ser colocado no diretório `app/`.
2. Dependências em `build.gradle`:
   - **Firebase**: Autenticação, Realtime Database, Firestore e Cloud Messaging.
   - **Coroutines** e **LiveData**: Para uma melhor gestão de dados assíncronos e atualização em tempo real dos dados exibidos.

## Contribuição

Sinta-se à vontade para contribuir com o MyApplication. Para isso:

1. Faça um fork do repositório.
2. Crie um branch com a sua feature:
   ```bash
   git checkout -b minha-nova-feature
   ```
3. Commit suas mudanças:
   ```bash
   git commit -m 'Adicionei uma nova funcionalidade'
   ```
4. Envie para o branch principal:
   ```bash
   git push origin minha-nova-feature
   ```
5. Crie um Pull Request.
