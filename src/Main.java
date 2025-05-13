//aqui no main, a minha ideia na prova era criar um menu interativo, mas nao consegui terminar devido ao tempo
//e também agora percebi que menus não são meu forte, como nao foi pedido o menu acredito que dessa forma funciona
// tudo que esta sendo pedido e é o jeito que achei melhor para implementar o que foi pedido conforme o que sei.
public class Main {
    public static void main(String[] args) {
        // Criação de Empresa:
        Empresa empresa = new Empresa("Cookies da gabi", "22.006.004/0001-89");

        // Adição de departamentos à Empresa:
        Departamento vendas = new Departamento("VENDAS");
        Departamento financeiro = new Departamento("FINANCEIRO");
        empresa.adicionarDepartamento(vendas);
        empresa.adicionarDepartamento(financeiro);

        // Adição de Funcionários aos Departamentos:
        vendas.adicionarFuncionario(new Funcionario("Markus", 1000, "22/03/2025"));
        vendas.adicionarFuncionario(new Funcionario("Ellen", 500, "21/04/2025"));
        financeiro.adicionarFuncionario(new Funcionario("Gabriele", 2000,"19/03/2025"));

        // Mostra no terminal a criação da Empresa e os seus dados:
        System.out.println("\n== Empresa Criada ==\n");
        empresa.listarDados();

        // Chamando método para aumento em um departamento:
        vendas.aumentoDepartamento(5);
        System.out.println("\n** Aplicando aumento a um departamento de 5% **");
        vendas.listarFuncionarios();

        // Transferência de funcionario de um departamento para outro.
        empresa.tranferirFuncionario("Gabriele","FINANCEIRO","VENDAS");
        System.out.println("\n** Tranferindo funcionario de departamento **");
        empresa.listarDados();


    }
}