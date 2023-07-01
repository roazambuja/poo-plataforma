import java.util.ArrayList;
import java.util.Scanner;

public class Aluno extends Usuario {
    public String email;
    public String matricula;

    public ArrayList<Inscricao> minhasInscricoes;

    public static Integer counter = 1;

    Aluno(String senha, String username, String nome, String email) {
        super(senha, username, nome);
        this.email = email;
        this.minhasInscricoes = new ArrayList<>();
        this.matricula = String.format("%05d", counter++);
        Plataforma.alunos.add(this);
        Plataforma.usuarios.add(this);
    }

    public static Aluno criar() {
        System.out.println("Olá, novo aluno! Informe seus dados para o cadastro.");
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite seu nome: ");
        String nome = leitor.nextLine();
        System.out.println("Digite um nome de usuário para login: ");
        String username = leitor.nextLine();
        System.out.println("Digite uma senha: ");
        String senha = leitor.nextLine();
        System.out.println("Digite seu email: ");
        String email = leitor.nextLine();
        return new Aluno(senha, username, nome, email);
    }

    public void imprimir() {
        super.imprimir();
        System.out.println("Email: " + this.email);
        System.out.println("Matrícula: " + this.matricula);
        System.out.println("-----------------------------------------------------------------------");
    }


    public Inscricao getInscricaoByNomeDoCurso(String nome) {
        for (Inscricao i : this.minhasInscricoes) {
            if (i.curso.titulo.equals(nome)) {
                return i;
            }
        }
        return null;
    }

    public void realizarInscricao() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite o nome do curso que deseja se inscrever: ");
        String nome = leitor.nextLine();
        Curso curso = Usuario.getCursoByName(nome);
        if (curso == null) {
            System.out.println("Ops, não encontramos o curso!");
        } else {
            Inscricao i = this.getInscricaoByNomeDoCurso(nome);
            if (i == null) {
                new Inscricao(this, curso);
                System.out.println("Parabéns, você está inscrito no curso " + curso.titulo + "!");
            } else {
                System.out.println("Você não pode se cadastrar duas vezes em um curso!");
            }
        }
        System.out.println("-----------------------------------------------------------------------");
    }

    public void listarMinhasInscricoes(boolean status) {
        int cont = 0;
        System.out.println("MEUS CURSOS " + (status ? "CONCLUÍDOS" : "EM ANDAMENTO") + " -------------------------------------------");
        for (Inscricao i : this.minhasInscricoes) {
            if (i.getConcluido() == status) {
                i.imprimir();
                cont++;
            }
        }
        if (cont == 0) {
            System.out.println("Você não tem nenhum curso para listar!");
        }
    }

    public void listarMinhasInscricoes() {
        System.out.println("MEUS CURSOS -------------------------------------------");
        for (Inscricao i : this.minhasInscricoes) {
            i.imprimir();
        }
        if (this.minhasInscricoes.size() == 0) {
            System.out.println("Você não se inscreveu em nenhum curso ainda!");
        }
    }

    public void alterarEmail() {
        System.out.println("Digite sua senha: ");
        String senha = scanner.nextLine();
        System.out.println("Digite seu novo email: ");
        String username = scanner.nextLine();
        if (validaTrocaDeUsername(senha, username)) {
            System.out.println("Email alterado com sucesso!\n");
        } else {
            System.out.println("Não foi possível alterar seu Email, tente novamente.\n");
        }
    }

    private boolean validaTrocaDeUsername(String senha, String email) {
        if (senha.equals(this.getSenha())) {
            this.email = email;
            return true;
        }
        return false;
    }

    public void finalizarCurso() {
        System.out.println("FINALIZAR CURSO -------------------------------------------");

        if (this.minhasInscricoes.size() == 0) {
            System.out.println("Você ainda não está inscrito em nenhum curso!");
            return;
        }
        System.out.println("Digite o nome do curso que deseja finalizar:");
        String nome = scanner.nextLine();
        Inscricao i = this.getInscricaoByNomeDoCurso(nome);
        if (i == null) {
            System.out.println("Ops, você não está matriculado no curso informado.");
        } else {
            if (i.concluiCurso()) {
                System.out.println("Parabéns! O curso " + i.curso.titulo + " foi concluído!");
            } else {
                System.out.println("Esse curso já foi concluído por você anteriormente!");
            }
        }
        System.out.println("-----------------------------------------------------------------------");
    }

    public void avaliarCurso() {
        System.out.println("FINALIZAR CURSO -------------------------------------------");
        System.out.println("Digite o nome do curso que deseja avaliar:");
        String nome = scanner.nextLine();
        Inscricao i = this.getInscricaoByNomeDoCurso(nome);
        if (i == null) {
            System.out.println("Ops, você não se matriculou nesse curso.");
        } else {
            if (i.getConcluido()) {
                if (i.getAvaliado()) {
                    System.out.println("Você já avaliou esse curso!");
                } else {
                    System.out.println("De 1 a 5, qual sua nota para o curso?");
                    Integer nota = scanner.nextInt();
                    scanner.nextLine(); // limpar o scanner
                    i.cadastraAvaliacao(nota);
                }
            } else {
                System.out.println("Para avaliar um curso, você precisa primeiro finalizá-lo!");
            }
        }
        System.out.println("-----------------------------------------------------------------------");
    }

}