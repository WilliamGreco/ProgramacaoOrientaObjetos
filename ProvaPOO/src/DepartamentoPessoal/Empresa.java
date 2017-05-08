package DepartamentoPessoal;

import java.util.Scanner;

public class Empresa {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        Funcionario vetor_funcionario[] = new Funcionario[100];
        Dependente vetor_dependente[] = new Dependente[100];
        int main = 0, contadorF = 0, contadorD = 0, codigo = 0;
        double valores;
        String nome;
        boolean codi = true;
        Funcionario empresa = new Funcionario();

        while (codi) {

            System.out.println("************************************");
            System.out.println("2 - Cadastrar Funcionario");
            System.out.println("3 - Cadastrar Dependente");
            System.out.println("4 - Excluir");
            System.out.println("5 - Alterar");
            System.out.println("6 - Bonus ");
            System.out.println("0 - Sair");
            System.out.println("************************************");
            main = ler.nextInt();

            switch (main) {
                case 0:
                    codi = false;
                    break;
                case 1:

                    
                    contadorF++;
                    break;
                case 2:
                    Funcionario func = new Funcionario();
                    System.out.println("Informe o codigo do funcionario...");
                    codigo = ler.nextInt();

                    if (!(contadorF == 0)) {
                        while (empresa.analisa_codigo(vetor_funcionario, codigo, contadorF)) {
                            System.out.println("Codigo ja existe...");
                            System.out.println("Informe o codigo do funcionario...");
                            codigo = ler.nextInt();
                        }
                    }
                    func.setnumeroFuncionario(codigo);
                    System.out.println("Informe o nome do funcionario...");
                    nome = ler.next();
                    func.setNome(nome);

                    System.out.println("Informe o Cargo...");
                    nome = ler.next();
                    func.setCargo(nome);

                    System.out.println("Informe o Salario...");
                    valores = ler.nextDouble();
                    func.setSalario(valores);

                    vetor_funcionario[contadorF] = func;

                    contadorF++;

                    break;
                case 3:
                    if (!(contadorF == 0)) {
                        Dependente dp = new Dependente();
                        System.out.println("Informe o nome do dependente...");
                        nome = ler.next();
                        dp.setNomeDependente(nome);
                        System.out.println("Informe o codigo do funcionario");
                        codigo = ler.nextInt();
                        while (!empresa.analisa_codigo(vetor_funcionario, codigo, contadorF)) {
                            System.out.println("Codigo não existe...");
                            codigo = ler.nextInt();
                        }
                        dp.setFuncionario(empresa.getFuncionario(vetor_funcionario, codigo, contadorF));

                        vetor_dependente[contadorD] = dp;
                        contadorD++;
                    } else {
                        System.out.println("Sem funcionario");
                    }

                    break;
                case 4:
                    System.out.println("Informe o codigo do funcionario");
                    codigo = ler.nextInt();
                    vetor_funcionario = empresa.deleteF(vetor_funcionario, codigo, contadorF);
                    if (!(contadorD == 0)) {
                        
                        while (!empresa.analisa_codigo(vetor_funcionario, codigo, contadorF)) {
                            System.out.println("Codigo não existe...");
                            System.out.println("");
                            System.out.println("Informe o codigo do funcionario");
                            codigo = ler.nextInt();

                        vetor_dependente = empresa.deleteDep(vetor_dependente, codigo, contadorF);

                    }
                    }
                    break;
                case 5:

                    System.out.println("Informe o codigo do funcionario...");
                    codigo = ler.nextInt();

                    if (!(contadorF == 0)) {
                        while (!empresa.analisa_codigo(vetor_funcionario, codigo, contadorF)) {
                            System.out.println("Funcionario não existe...");
                            System.out.println("");
                            System.out.println("Informe o codigo do funcionario...");
                            codigo = ler.nextInt();
                        }
                        System.out.println("Novo Salario $$$");
                        valores = ler.nextDouble();
                        vetor_funcionario = empresa.alteraFuncionario(vetor_funcionario, codigo, contadorD, valores);

                    }

                    break;
                case 6:
                    System.out.println("Novo Salario $$$");
                    empresa.bonus(vetor_funcionario, vetor_dependente, contadorF, contadorD);

                    break;

            }
        }

    }

}
