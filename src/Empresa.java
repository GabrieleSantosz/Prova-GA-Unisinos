//Classe Empresa com os atributos pedidos:

public class Empresa {
    private String nomeEmpresa;
    private String cnpj;
    private Departamento[] departamentos;
    private int totalDepartamentos;

 // Método para poder acessar os dados que estao em =PRIVATE=

    public Empresa(String nomeEmpresa, String cnpj){
        this.nomeEmpresa = nomeEmpresa;
        this.cnpj = cnpj;
        this.departamentos = new Departamento[10];
        this.totalDepartamentos = 0;
    }

// Método para adicionar departamento na empresa se o total não for maior que 10:

    public boolean adicionarDepartamento(Departamento d){
        if (totalDepartamentos < departamentos.length){
           departamentos[totalDepartamentos++] = d;
           return true;
        }
        return false;
    }
// até aqui eu tinha feito na prova, o codigo de baixo complementa o que eu queria fazer para finalizar:

//Método para buscar departamentos que sera usado para tranferência de funcionários posteriormente;

    public Departamento getDepartamento(String nomeDepartamento){
        for (int i =0; i < totalDepartamentos; i++){
            if (departamentos[i].getNomeDepartamento().equalsIgnoreCase(nomeDepartamento)){
                return departamentos[i];
            }
        }
        return null;
    }

// Método para tranferir funcionarios como pedido:

    public boolean tranferirFuncionario(String nomeFuncionario, String departamentoAtual,String departamentoNovo){
        Departamento atual = getDepartamento(departamentoAtual);
        Departamento novo = getDepartamento(departamentoNovo);
        if (atual == null && novo == null){
            return false;
        }
        Funcionario f = atual.removerFuncionario(nomeFuncionario);
        if (f != null){
            return novo.adicionarFuncionario(f);
        }
        return false;
    }
// Método para listar todos dados da empresa criada:

    public void listarDados(){
        System.out.println("\nEmpresa: " + nomeEmpresa + "\nCNPJ: "+ cnpj);
        if (totalDepartamentos == 0){
            System.out.println("Empresa sem departamentos.");
        }else{
            for (int i = 0; i <totalDepartamentos; i++) {
                departamentos[i].listarFuncionarios();
            }
        }
    }
}
