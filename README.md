Unidade Curricular: Lógica de Programação Trabalho Final - Sistema de Cadastro e Consulta de Orientações WEG

Objetivo: Desenvolver um sistema para o cadastro e consulta de regras de condutas WEG. Este sistema denominado WegOne visa permitir que os colaboradores da empresa possam acessar orientações relacionadas a diversos equipamentos e procedimentos operacionais da Weg de forma simples e eficiente. O sistema deve permitir a pesquisa, cadastro, edição e exclusão de orientações, além de oferecer opções de leitura em português, inglês e Alemão.

Contextualização: A WEG é uma empresa que fabrica uma ampla gama de equipamentos industriais. Para garantir que os colaboradores saibam como operar e manter esses equipamentos corretamente e como devem agir segundo as normas da empresa, faz-se necessário a criação de um sistema de orientações, onde as instruções de uso, segurança, manutenção e procedimentos operacionais nos setores da empresa estejam organizadas e facilmente acessíveis. O sistema deve permitir que os usuários escolham entre diferentes tipos de orientações, como manuais de operação, procedimentos de segurança, manutenção, testes e condutas no setor.

Requisitos do Sistema: Cadastro de Equipamentos e Orientações: O sistema deve permitir o cadastro limitado de orientações.

Para cada orientação, o sistema deve permitir o cadastro de:

Título da Orientação.

Tipo da Orientação (Escolha entre "Manual de Operação", "Procedimento de Segurança", "Manutenção e Reparos", "Testes e Diagnóstico" ou "Manual de Conduta e Operações Setoriais"). Conteúdo da Orientação em Português. Conteúdo da Orientação em Inglês. Conteúdo da Orientação em Alemão.

Pesquisa de Orientações: O sistema deve permitir que o usuário pesquise uma orientação pelo título ou por código referente a orientação.

Caso a orientação seja encontrada, o sistema deve exibir o conteúdo de acordo com o idioma escolhido (português, inglês ou alemão).

Edição de Orientações: O sistema deve permitir que o usuário edite o conteúdo de uma orientação existente, seja no idioma português, inglês ou alemão. (PLUS)

Exclusão de Orientações: O sistema deve permitir que o usuário exclua uma orientação já cadastrada. Ao excluir, o sistema deve remover a orientação da lista.

Exibição de Orientações: O sistema deve permitir que o colaborador visualize as orientações de um equipamento ou procedimento tanto em português, inglês ou alemão.

Menu de Opções: O sistema deve apresentar um menu de opções, que será exibido tanto em português quanto em inglês e alemão conforme a escolha do usuário.

O menu deve apresentar as seguintes opções:

Cadastrar Orientação.

Pesquisar Orientação.

Editar Orientação. (PLUS)

Excluir Orientação.

Sair.

Funcionalidades do Sistema: Escolha de Idioma: O sistema deve permitir que o usuário escolha entre português, inglês ou alemão para a interação.

Cadastro de Orientações: Ao cadastrar uma nova orientação, o usuário escolhe o tipo: (Manual de Operação, Procedimento de Segurança, Manutenção e Reparos, Testes e Diagnóstico ou Manual de Conduta e Operações Setoriais) e insere as informações.

Pesquisa e Exibição: O sistema deve exibir as orientações, permitindo ao usuário visualizar os detalhes conforme o idioma escolhido.

Edição de Orientações: O usuário pode editar qualquer orientação já cadastrada. (PLUS)

Exclusão de Orientações: O sistema deve permitir que o usuário exclua orientações já cadastradas e reorganize a lista corretamente.

Categorias de Orientações: Manual de Operação:

Orientações detalhadas sobre o uso correto e eficiente dos equipamentos.

Exemplos: Manual de operação de motores, transformadores, geradores, etc.

Procedimento de Segurança:

Manutenção e Reparos:

Orientações sobre como realizar manutenção e reparos nos equipamentos.

Exemplos: Manutenção de motores elétricos, reparo de transformadores, etc.

Testes e Diagnóstico:

Procedimentos para realizar testes de operação e diagnóstico de falhas nos equipamentos.

Exemplos: Testes de funcionamento de motores, diagnóstico de falhas em sistemas de automação, etc.

Manual de Conduta e Operações Setoriais:

Orientações sobre como os colaboradores devem agir em determinados setores da empresa, com foco em boas práticas e processos específicos de cada área.

Exemplos: Conduta no setor de montagem, procedimentos operacionais no setor de manutenção, processos no setor de controle de qualidade, etc. Estrutura de Dados: Utilize arrays para armazenar os seguintes dados: Títulos das Orientações.

Tipos das Orientações.

Conteúdos das Orientações em Português, Inglês, alemão.

O sistema deve ser inicializado com 10 orientações já cadastradas, mas deixando espaço para mais cadastros..

Instruções de Implementação: Linguagem de Programação: O sistema deve ser desenvolvido em Java.

Estrutura de Controle: Utilize estruturas de repetição (como for ou while) para navegar entre as opções do menu. Utilize condicionais (if/else) para verificar as escolhas do usuário e implementar as funcionalidades necessárias.

Interação com o Usuário: O sistema deve ser interativo e permitir que o usuário execute as operações de cadastro, pesquisa, edição e exclusão de orientações de forma clara e eficiente.

Critérios de Avaliação: Funcionalidade Completa:

O sistema deve implementar todas as funcionalidades de maneira correta: cadastro, pesquisa, edição, exclusão e exibição das orientações, com suporte para os 3 idiomas.

Utilização de Arrays Unidimensionais:

O sistema deve utilizar apenas arrays para armazenar os dados das orientações.

Organização e Clareza do Código:

O código deve ser bem organizado, legível e comentado. As variáveis e blocos de código devem ter nomes claros e representativos. (CLEAN CODE)

Interface do Usuário:

O sistema deve ser fácil de usar, com um menu intuitivo que permita ao usuário realizar as operações de forma simples, elegante e criativa ;) .

Pontos Importantes: Cadastro de Orientações: O sistema deve garantir que as orientações sejam cadastradas corretamente, com tutoriais em português, inglês e alemão.

Limitação de Orientações: O sistema deve ser inicializado com 10 orientações, mas possuir espaço para mais.

Pesquisa e Exibição de Orientações: O sistema deve garantir que o usuário consiga pesquisar e visualizar as orientações de cada tipo no idioma escolhido.

Edição de Orientações: O sistema deve permitir a edição de orientações já cadastradas, com a possibilidade de alterar título, tipo e conteúdo. (PLUS)

Exclusão de Orientações: O sistema deve permitir a exclusão de orientações e reorganizar a lista corretamente. O sistema deve garantir que as entradas erradas não travem o sistema.

Entrega: O código-fonte do sistema deve ser enviado pelo notion e também em formato Java.

O sistema deve estar totalmente funcional, com as opções de cadastro, pesquisa, edição e exclusão operando conforme descrito