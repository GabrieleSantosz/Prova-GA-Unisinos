// Aqui no main, a minha ideia na prova era criar um menu interativo, mas eu nao tive tempo para terminar e tambem nao consegui fazer
//a aplicação do switch case
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Empresa empresa = null;

        while (true) {
            System.out.println(
                    "\n ************ MENU DE CRIAÇÃO ************ \n" +
                            "1- Criar uma nova Empresa.\n" +
                            "2- Adicionar Departamentos a Empresa.\n" +
                            "3- Adicionar Novo Funcionário a um Departamento da Empresa.\n" +
                            "4- Dar aumento (em %) a determinado Departamento.\n" +
                            "5- Tranferência de Funcionários para outro Departamento.\n " +
                            "6- Status da sua Empresa.\n" +
                            "7- Sair do Menu e Encerrar Programa.\n" +
                            "Escolha uma das opções acima: "
            );
            int opcao = scanner.nextInt();
            scanner.nextLine();
// Até aqui foi feito na prova, porém eu tinha feito o menu com vários System.out.println, agora eu fiz com o + e o \n para quebrar linhas
            // Em todas cases tem a opção de voltar ao menu após regsitros e se a empresa ou departamento nao existir.
            // Case 1 para criação da empresa, conforme pedido.
            switch (opcao) {
                case 1 -> {
                    System.out.println("Digite o nome da sua Empresa: ");
                    String nomeEmpresa = scanner.nextLine();
                    System.out.println("Informe o CNPJ: XX.XXX.XXX/0001-XX");
                    String cnpj = scanner.nextLine();
                    empresa = new Empresa(nomeEmpresa, cnpj);
                    System.out.println("Sua Empresa foi Registrada!");
                    System.out.println("Pressione qualquer tecla para voltar ao menu...");
                    scanner.nextLine();
                }
            // Case 2 para criação de departamentos, conforme pedido.(aqui também verifica se a empresa ja foi criada)
                case 2 -> {
                    if (empresa == null) {
                        System.out.println("Você não criou uma Empresa ainda!");
                        System.out.println("Pressione qualquer tecla para voltar ao menu...");
                        scanner.nextLine();
                        break;
                    }
                    System.out.println("Digite o nome do novo Departamento: ");
                    String nomeDepartamento = scanner.nextLine();
                    empresa.adicionarDepartamento(new Departamento(nomeDepartamento));
                    System.out.println("Seu novo Departamento foi Registrado!");
                    System.out.println("Pressione qualquer tecla para voltar ao menu...");
                    scanner.nextLine();
                }
            // Case 3 para adicionar funcionários, conforme pedido.(verifica se a empresa foi criada e se o departamento existe)
                case 3 -> {
                    if (empresa == null) {
                        System.out.println("Você não criou uma Empresa ainda!");
                        System.out.println("Pressione qualquer tecla para voltar ao menu...");
                        scanner.nextLine();
                        break;
                    }
                    System.out.println("Digite o Departamento desejado para registro de novo Funcionário: ");
                    String nomeDepartamento = scanner.nextLine();
                    Departamento d = empresa.getDepartamento(nomeDepartamento);
                    if (d == null) {
                        System.out.println("Departamento não Existe!");
                        System.out.println("Pressione qualquer tecla para voltar ao menu...");
                        scanner.nextLine();
                        break;
                    }
                    System.out.println("Digite o Nome do Funcionário: ");
                    String nomeFuncionario = scanner.nextLine();
                    System.out.println("Informe o Salário: ");
                    double salario = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Informe a data de Admissão: dd/mm/yyyy");
                    String admissao = scanner.nextLine();
                    d.adicionarFuncionario(new Funcionario(nomeFuncionario, salario, admissao));
                    System.out.println("O funcionário foi Registrado!");
                    System.out.println("Pressione qualquer tecla para voltar ao menu...");
                    scanner.nextLine();
                }
            // Case 4 para dar aumento a um departamento, conforme pedido.(verifica se a empresa foi criada e se o departamento existe)
                case 4 -> {
                    if (empresa == null) {
                        System.out.println("Você não criou uma Empresa ainda!");
                        System.out.println("Pressione qualquer tecla para voltar ao menu...");
                        scanner.nextLine();
                        break;

                    }
                    System.out.println("Digite o Departamento desejado aplicar o aumento: ");
                    String nomeDepartamento = scanner.nextLine();
                    Departamento d = empresa.getDepartamento(nomeDepartamento);
                    if (d == null) {
                        System.out.println("Departamento não Existe!");
                        System.out.println("Pressione qualquer tecla para voltar ao menu...");
                        scanner.nextLine();
                        break;
                    }
                    System.out.println("Digite o Percentual(%) do Aumento a este Departamento: ");
                    int percentual = scanner.nextInt();
                    scanner.nextLine();
                    d.aumentoDepartamento(percentual);
                    System.out.println("Aumento Registrado e Aplocado! ");
                    System.out.println("Pressione qualquer tecla para voltar ao menu...");
                    scanner.nextLine();
                }
            // Case 5 para tranferência de funcionários entre departamentos, conforme pedido.(verifica se a empresa foi criada, e retorna se a traferência foi feita)
                case 5 -> {
                    if (empresa == null) {
                        System.out.println("Você não criou uma Empresa ainda!");
                        System.out.println("Pressione qualquer tecla para voltar ao menu...");
                        scanner.nextLine();
                        break;
                    }
                    System.out.println("Informe o Funcionário para Tranferência: ");
                    String nomeFuncionario = scanner.nextLine();
                    System.out.println("Informe em qual Departamento se Encontra: ");
                    String departamentoAtual = scanner.nextLine();
                    System.out.println("Informe para qual Departamento deseja fazer a Tranferência: ");
                    String departamentoNovo = scanner.nextLine();
                    boolean tranferido = empresa.tranferirFuncionario(nomeFuncionario, departamentoAtual,departamentoNovo);
                    System.out.println( tranferido ? "O funcionário doi tranferido para o departamento desejado!" : "Erro ao tranferir o funcionario entra os departamentoss.");
                    System.out.println("Pressione qualquer tecla para voltar ao menu...");
                    scanner.nextLine();
                }
            // Case 6 para listar os dados da empresa (verifica se a empresa foi criada).
                case 6 -> {
                    if (empresa == null) {
                        System.out.println("Você não criou uma Empresa ainda!");
                        System.out.println("Pressione qualquer tecla para voltar ao menu...");
                        scanner.nextLine();
                    } else {
                        empresa.listarDados();
                        System.out.println("Pressione qualquer tecla para voltar ao menu...");
                        scanner.nextLine();
                    }
                }
            // Case 7 para encerrar o programa e sair do loop.
                case 7 ->{

                    System.out.println("Encerrando programa...");
                    scanner.close();
                    return;
                }
            // default de opção invalida para cases que nâo funcionam.
                default -> System.out.println("Opção Inválida!");
            }
        }
    }
}