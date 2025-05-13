
// Classe Funcionário com os atributos pedidos:

public class Funcionario {
    private String nomeFuncionario;
    private double salario;
    private String admissao;

// Método para poder acessar os dados que estão em =PRIVATE=

    public Funcionario(String nomeFuncionario, double salario, String admissao){
        this.nomeFuncionario = nomeFuncionario;
        this.salario = salario;
        this.admissao = admissao;
    }
 // Get de nome para poder usar nas outras classes:

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

 // até aqui eu tinha feito na prova, o codigo de baixo complementa o que eu queria fazer para finalizar:

// Método base para dar aumento posteriormente em =aumento para departamento=:

    public void aumento(double percentual){
        salario += salario * percentual / 100.0;
    }
// Override para formatar bonitinho as informações no terminal:
    @Override
    public  String toString(){
        return nomeFuncionario + " // Salário atual: R$ " + String.format("%.2f", salario)
                +" // Data de Admissão: " + admissao;
    }
}