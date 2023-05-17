import java.util.ArrayList;
import java.util.Scanner;

public class Plataforma {
    public String nome;
    public String cnpj;
    public String email;

    public ArrayList<Administrador> administradores;
    public ArrayList<Instrutor> instrutores;
    public ArrayList<Aluno> alunos;
    public ArrayList<Curso> cursos;

    Plataforma(String nome, String cnpj, String email) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.email = email;
        this.administradores = new ArrayList<>();
        this.administradores.add(new Administrador("admin", "admin123", "Admin"));
        this.instrutores = new ArrayList<>();
        this.alunos = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }

    public static Plataforma criar() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite o nome da plataforma: ");
        String nome = leitor.nextLine();
        System.out.println("Digite o CNPJ: ");
        String cnpj = leitor.nextLine();
        System.out.println("Digite o email: ");
        String email = leitor.nextLine();
        return new Plataforma(nome, cnpj, email);
    }

    public void imprimir() {
        System.out.println("Nome: " + this.nome);
        System.out.println("CNPJ: " + this.cnpj);
        System.out.println("E-mail: " + this.email);
    }

    public static void menu() {
        System.out.println("Como deseja fazer login?");
        System.out.println("1 - Aluno");
        System.out.println("2 - Administrador");
        System.out.println("3 - Instrutor");
        System.out.println("0 - Voltar");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Plataforma plataforma = new Plataforma("Cursos TSI", "000111222000134", "plataforma@gmail.com");
        plataforma.instrutores.add(new Instrutor("12345", "fulaninho", "Fulano"));
        plataforma.alunos.add(new Aluno("123", "mariazinha", "Maria", "maria@gmail.com"));

        Integer menu = 1;
        while (menu != 0) {
            System.out.println("Seja bem vindo a plataforma " + plataforma.nome + "!");
            System.out.println("1 - Fazer login");
            System.out.println("2 - Criar conta");
            System.out.println("0 - Sair");
            menu = scanner.nextInt();

            switch (menu) {
                case 1:
                    Plataforma.menu();
                    Integer menuLogin = scanner.nextInt();
                    scanner.nextLine(); // limpa o scanner

                    switch (menuLogin) {
                        case 1:
                            System.out.println("Digite seu email: ");
                            String email = scanner.nextLine();
                            System.out.println("Digite sua senha: ");
                            String senha = scanner.nextLine();
                            Aluno alunoLogado = Aluno.login(email, senha, plataforma.alunos);
                            if (alunoLogado == null) {
                                System.out.println("Dados incorretos!");
                            } else {
                                System.out.println("Seja bem vindo, " + alunoLogado.nome + "!");
                            }
                            System.out.println(
                                    "-----------------------------------------------------------------------\n");
                    }

                    break;
                case 2:
                    Aluno.criar();
                    System.out.println("Sua conta foi criada com sucesso! Agora, faça login para continuar.");
                    System.out.println("-----------------------------------------------------------------------\n");
                    break;
                default:
                    System.out.println("Digite um valor válido!");
            }
        }

        scanner.close();
    }
}
