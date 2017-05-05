package Exercicio_POO;

import java.util.Scanner;

public class Cadastro {

    Scanner ler = new Scanner(System.in);

    Aluno[] aluno = new Aluno[5];
    Disciplina[] disciplina = new Disciplina[5];
    Matricula[] matricula = new Matricula[5];

    int contadorA = 0, contadorD = 0, contadorM = 0;

    public void cadastro() {

        int cont = 0;

        while (cont != 5) {
            System.out.println("1 - Cadastro de Disciplinas...");
            System.out.println("2 - Cadastro de Alunos...");
            System.out.println("3 - Matricular Aluno na Disciplina...");
            System.out.println("4 - Informar Matricula do Aluno...");
            System.out.println("5 - Sair...");
            System.out.print("Digite a opção:... ");
            cont = Integer.parseInt(ler.next());

            switch (cont) {
                case 1:
                    cadastrarDisciplina();
                    break;

                case 2:
                    cadastrarAluno();
                    break;

                case 3:
                    cadastrarMatricula();
                    break;

                case 4:
                    System.out.print("Informe o código do aluno:... ");
                    int codigo = Integer.parseInt(ler.next());
                    System.out.print("Informe o ano letivo:... ");
                    int ano = Integer.parseInt(ler.next());
                    buscarMatricula(codigo, ano);
                    break;

                case 5:
                    break;
            }
        }

    }

    private void cadastrarDisciplina() {
        if (contadorD < disciplina.length) {
            Disciplina dis = new Disciplina();

            System.out.print("Informe o código da disciplina:... ");
            int codigo = Integer.parseInt(ler.next());

            if (verificarDisciplina(codigo)) {
                System.out.println("Código já existente!...");
            } else {
                dis.setCodigoDiscip(codigo);
                System.out.print("Informe o nome da disciplina:... ");
                dis.setNomeDisciplina(ler.next());
                System.out.print("Informe a carga horária geral:... ");
                dis.setCargaHoraGeral(Integer.parseInt(ler.next()));

                disciplina[contadorD] = dis;
                contadorD++;
            }

        } else {
            System.out.println("Parabéns as disciplinas já foram cadastradas!...");
        }

    }

    private void cadastrarAluno() {
        if (contadorA < aluno.length) {
            Aluno alu = new Aluno();

            System.out.print("Informe o código do aluno:... ");
            int codigo = Integer.parseInt(ler.next());

            if (verificarAluno(codigo)) {
                System.out.println("Codigo já existente!...");
            } else {
                alu.setCodAluno(codigo);
                System.out.print("Informe o nome do aluno:... ");
                alu.setNomeAluno(ler.next());

                aluno[contadorA] = alu;
                contadorA++;
            }

        } else {
            System.out.println("Parabéns os alunos já foram cadastradas!...");
        }

    }

    private void cadastrarMatricula() {
        if (aluno != null && disciplina != null) {
            Matricula mat = new Matricula();

            System.out.print("Informe o ano letivo:... ");
            mat.setAnoLetivo(Integer.parseInt(ler.next()));
            System.out.print("Informe a série:... ");
            mat.setSerie(Integer.parseInt(ler.next()));

            System.out.println("Alunos disponíveis:... ");
            mostrarAluno();
            System.out.print("Código do aluno:... ");
            int codAln = Integer.parseInt(ler.next());
            mat.setAluno(buscarAluno(codAln));

            System.out.println("Disciplinas disponíveis:... ");
            mostrarDisciplina();
            System.out.print("Código da disciplina:... ");
            int codDisciplina = Integer.parseInt(ler.next());
            mat.setDisciplina(buscarDisciplina(codDisciplina));

            matricula[contadorM] = mat;
            contadorM++;

        } else {
            System.out.println("Por favor... cadastre um aluno ou disciplina primeiro...");
        }
    }

    private void buscarMatricula(int codigoAluno, int ano) {
        for (int i = 0; i < contadorM; i++) {
            if (codigoAluno == matricula[i].getAluno().getCodAluno() && ano == matricula[i].getAnoLetivo()) {

                System.out.println("Código:... " + codigoAluno);
                System.out.println("Ano:... " + ano);
                System.out.println("Aluno:... " + matricula[i].getAluno().getNomeAluno());
                System.out.println("Disciplina:... "
                        + matricula[i].getDisciplina().getNomeDisciplina());
                System.out.println("Carga horária:... "
                        + matricula[i].getDisciplina().getCargaHoraGeral());
            } else {
                System.out.println("Matrícula inválida...");
            }

        }
    }

    private void mostrarAluno() {
        for (int i = 0; i < contadorA; i++) {
            System.out.println("Código:... " + aluno[i].getCodAluno() + " | Nome:... " + aluno[i].getNomeAluno());
        }
    }

    private void mostrarDisciplina() {
        for (int i = 0; i < contadorD; i++) {
            System.out.println("Código:..." + disciplina[i].getCodigoDiscip() + " | Nome:... " + disciplina[i].getNomeDisciplina() + " | Carga horária:... " + disciplina[i].getCargaHoraGeral());
        }
    }

    private Aluno buscarAluno(int codigo) {
        Aluno al = new Aluno();
        for (int i = 0; i < contadorA; i++) {
            if (codigo == aluno[i].getCodAluno()) {
                al.setCodAluno(codigo);
                al.setNomeAluno(aluno[i].getNomeAluno());
            }
        }

        return al;
    }

    private Disciplina buscarDisciplina(int codigo) {
        Disciplina disc = new Disciplina();
        for (int i = 0; i < contadorD; i++) {
            if (codigo == disciplina[i].getCodigoDiscip()) {
                disc.setCodigoDiscip(codigo);
                disc.setNomeDisciplina(disciplina[i].getNomeDisciplina());
                disc.setCargaHoraGeral(disciplina[i].getCargaHoraGeral());
            }
        }

        return disc;
    }

    private boolean verificarAluno(int codigo) {
        for (int i = 0; i < contadorA; i++) {
            if (aluno[i].getCodAluno() == codigo) {
                return true;
            }
        }
        return false;
    }

    private boolean verificarDisciplina(int codigo) {
        for (int i = 0; i < contadorD; i++) {
            if (disciplina[i].getCodigoDiscip() == codigo) {
                return true;
            }
        }
        return false;
    }
}
