package DepartamentoPessoal;

public class Funcionario {

    private int numeroFuncionario;
    private String nome, cargo;
    private double salario;

    public int getnumeroFuncionario() {
        return numeroFuncionario;
    }

    public void setnumeroFuncionario(int numeroFuncionario) {
        this.numeroFuncionario = numeroFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public boolean analisa_codigo(Funcionario vetor[], int codigo, int contador) {

        for (int x = 0; x <= contador - 1; x++) {
            if (vetor[x] != null) {
                if (vetor[x].getnumeroFuncionario() == codigo) {

                    return true;
                }

            }

        }
        return false;

    }

    public Funcionario getFuncionario(Funcionario vetor[], int codigo, int contador) {

        Funcionario obj = new Funcionario();
        for (int x = 0; x <= contador - 1; x++) {
            if (vetor[x] != null) {
                if (vetor[x].getnumeroFuncionario() == codigo) {
                    obj = vetor[x];

                }
            }
        }

        return obj;
    }

    public Funcionario[] deleteF(Funcionario vetor[], int codigo, int contador) {

        for (int x = 0; x <= contador - 1; x++) {
            if (vetor[x] != null) {
                if (vetor[x].getnumeroFuncionario() == codigo) {
                    vetor[x] = null;

                }
            }

        }
        return vetor;
    }

    public Dependente[] deleteDep(Dependente vetor[], int codigo, int contador) {

        for (int x = 0; x <= contador - 1; x++) {
            if (vetor[x] != null) {
                if (vetor[x].getFuncionario().getnumeroFuncionario() == codigo) {
                    vetor[x] = null;
                }
            }

        }
        return vetor;
    }

    public Funcionario[] alteraFuncionario(Funcionario vetor[], int codigo, int contador, double novoSalario) {

        Funcionario obj = new Funcionario();
        for (int x = 0; x <= contador - 1; x++) {

            if (vetor[x] != null) {
                if (vetor[x].getnumeroFuncionario() == codigo) {
                    vetor[x].setSalario(novoSalario);
                }
            }

        }

        return vetor;
    }

    public void bonus(Funcionario vetor[], Dependente vetor2[], int contadorf, int contadord) {

        for (int x = 0; x <= contadorf - 1; x++) {
            if (vetor[x] != null) {
                int quant = getQuantDep(vetor2, contadord, vetor[x].getnumeroFuncionario());
                System.out.println("Nome - " + vetor[x].getNome());
                System.out.println("Salario - " + vetor[x].getSalario());
                System.out.println("Quantidade dependentes - " + quant);
                System.out.println("Bonus - " + (vetor[x].getSalario() * 0.02) * quant);
            }
        }
    }

    private int getQuantDep(Dependente vetor[], int contador, int codigo) {
        int cont = 0;
        for (int x = 0; x <= contador - 1; x++) {
            if (vetor[x] != null) {
                if (vetor[x].getFuncionario().getnumeroFuncionario() == codigo) {
                    cont++;
                }
            }

        }
        return cont;

    }

}
