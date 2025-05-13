//Classe Departamentos com os atributos pedidos:

public class Departamento {
    private String nomeDepartamento;
    private Funcionario[] funcionarios;
    private int totalFuncionarios;

// Método para poder acessar os dados que estão em =PRIVATE=

    public Departamento(String nomeDepartamento){
        this.nomeDepartamento = nomeDepartamento;
        this.funcionarios = new Funcionario[100];
        this.totalFuncionarios = 0;
    }
// GET de nome para usar em outras classes:

    public String getNomeDepartamento() {
        return nomeDepartamento;
    }

// MÉtodo para adicionar funcionários no departamento se o total não for maior que 100:

    public boolean adicionarFuncionario(Funcionario f){
        if(totalFuncionarios < funcionarios.length){
            funcionarios[totalFuncionarios++] = f;
            return true;
        }
        return false;
    }
// até aqui eu tinha feito na prova, o código de baixo complementa o que eu queria fazer para finalizar

// Método para dar aumentos em % a todos os funcionários de um determinado departamento como pedido.

    public void aumentoDepartamento(int percentual){
        for (int i = 0; i < totalFuncionarios; i++){
            funcionarios[i].aumento(percentual);
        }
    }

//Método para remover funcionários de um departamento que será usado posteriormente para tranferência;

    public Funcionario removerFuncionario(String nomeFun){
        for (int i = 0; i < totalFuncionarios; i++){
            if (funcionarios[i].getNomeFuncionario().equalsIgnoreCase(nomeFun)){
                Funcionario f = funcionarios[i];
                for (int x = i; x < totalFuncionarios - 1; x++){
                    funcionarios[x] = funcionarios[x+1];
                }
                funcionarios[--totalFuncionarios] = null;
                return f;
            }
        }
        return null;
    }
//Método para listar as infos de um departamento:

    public void listarFuncionarios() {
        System.out.println("=== " + nomeDepartamento + " ===");
        if (totalFuncionarios == 0) {
            System.out.println("Departamento vazio");
        } else {
            for (int i = 0; i < totalFuncionarios; i++) {
                System.out.println(" " + funcionarios[i]);
            }

        }
    }
}

