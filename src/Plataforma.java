import java.util.ArrayList;
import java.util.Scanner;

public class Plataforma {
    public String nome;
    public String cnpj;
    public String email;

    public static ArrayList<Administrador> administradores = new ArrayList<>();
    public static ArrayList<Instrutor> instrutores = new ArrayList<>();
    public static ArrayList<Aluno> alunos = new ArrayList<>();
    public static ArrayList<Curso> cursos = new ArrayList<>();
    public static ArrayList<Usuario> usuarios = new ArrayList<>();


    Plataforma(String nome, String cnpj, String email) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.email = email;
        administradores.add(new Administrador("admin", cnpj, "Admin"));
        instrutores = new ArrayList<>();
        alunos = new ArrayList<>();
        cursos = new ArrayList<>();
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

    public void cadastrarAluno() {
        alunos.add(Aluno.criar());
        System.out.println("Sua conta foi criada com sucesso! Agora, faça login para continuar.");
        System.out.println("-----------------------------------------------------------------------\n");
    }

    public void imprimir() {
        System.out.println("Nome: " + this.nome);
        System.out.println("CNPJ: " + this.cnpj);
        System.out.println("E-mail: " + this.email);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Plataforma plataforma = new Plataforma("Cursos", "000111222000134", "plataforma@gmail.com");
        Instrutor instrutor = new Instrutor("12345", "fulaninho", "Fulano");
        Instrutor instrutor2 = new Instrutor("12345", "fulaninha", "Fulana");
        instrutores.add(instrutor);
        instrutores.add(instrutor2);

        alunos.add(new Aluno("123", "mariazinha", "Maria", "maria@gmail.com"));
        cursos.add(new Curso("POO I - Classes e Atributos", instrutor));
        cursos.add(new Curso("POO II - Métodos", instrutor));
        cursos.add(new Curso("HTML", instrutor2));
        cursos.add(new Curso("CSS", instrutor2));


        Integer menu = 1;

        while (menu != 0) {
            menu = Menu.menuPrincipal(plataforma.nome);

            switch (menu) {
                case 1:
                    Integer menuLogin = Menu.menuOpcoes();
                    String user, senha;

                    switch (menuLogin) {
                        case 1:
                            System.out.println("Digite seu email: ");
                            user = scanner.nextLine();
                            System.out.println("Digite sua senha: ");
                            senha = scanner.nextLine();
                            Aluno alunoLogado = Aluno.login(user, senha, plataforma.alunos);
                            if (alunoLogado == null) {
                                System.out.println("Dados incorretos!");
                            } else {
                                Integer menuAluno;
                                System.out.println("Seja bem vindo, " + alunoLogado.nome + "!");
                                do {
                                    menuAluno = Menu.menuAluno();

                                } while (menuAluno != 0);
                            }
                            System.out.println(
                                    "-----------------------------------------------------------------------\n");
                            break;
                        case 2:
                            System.out.println("Digite seu username: ");
                            user = scanner.nextLine();
                            System.out.println("Digite sua senha: ");
                            senha = scanner.nextLine();
                            Administrador admLogado = Administrador.login(user, senha, plataforma.administradores);
                            if (admLogado == null) {
                                System.out.println("Dados incorretos!");
                            } else {
                                System.out.println("Seja bem vindo, " + admLogado.nome + "!");
                                Integer menuAdmin;
                                do {
                                    menuAdmin = Menu.menuAdministrador();
                                    switch (menuAdmin) {
                                        case 1:
                                            admLogado.listarAdministradores();
                                            break;
                                        case 2:
                                            admLogado.listarFuncionarios();
                                            break;
                                        case 3:
                                            admLogado.listarCursos();
                                            break;
                                        case 4:
                                            admLogado.alterarSenha();
                                            break;
                                        case 5:
                                            admLogado.alterarUsername();
                                            break;
                                        case 6:
                                            admLogado.cadastrarNovoAdm();
                                            break;
                                        case 7:
                                            admLogado.cadastrarNovoInstrutor();
                                            break;
                                    }

                                } while (menuAdmin != 0);
                            }
                            System.out.println(
                                    "-----------------------------------------------------------------------\n");
                            break;
                        case 3:
                            System.out.println("Digite seu username: ");
                            user = scanner.nextLine();
                            System.out.println("Digite sua senha: ");
                            senha = scanner.nextLine();
                            Instrutor instrutorLogado = Instrutor.login(user, senha, plataforma.instrutores);
                            if (instrutorLogado == null) {
                                System.out.println("Dados incorretos!");
                            } else {
                                System.out.println("Seja bem vindo, " + instrutorLogado.nome + "!");
                                Integer menuInstrutor;
                                do {
                                    menuInstrutor = Menu.menuInstrutor();

                                } while (menuInstrutor != 0);
                            }
                            System.out.println(
                                    "-----------------------------------------------------------------------\n");
                            break;
                    }

                    break;
                case 2:
                    plataforma.cadastrarAluno();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Digite um valor válido!");
            }
        }
        scanner.close();
    }
}
