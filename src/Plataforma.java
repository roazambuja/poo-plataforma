import java.util.ArrayList;
import java.util.Scanner;

public class Plataforma {
    private String nome;
    private String cnpj;
    private String email;
    private static ArrayList<Curso> cursos = new ArrayList<>();
    private static ArrayList<Usuario> usuarios = new ArrayList<>();


    Plataforma(String nome, String cnpj, String email) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.email = email;
        new Administrador("admin", cnpj, "Admin");
    }

    public static ArrayList<Curso> getCursos() {
        return Plataforma.cursos;
    }

    public static ArrayList<Usuario> getUsuarios() {
        return Plataforma.usuarios;
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
        Aluno.criar();
        System.out.println("Sua conta foi criada com sucesso! Agora, faça login para continuar.");
        System.out.println("-----------------------------------------------------------------------\n");
    }

    public static ArrayList<Administrador> getAdministradores() {
        ArrayList<Administrador> admins = new ArrayList<>();
        for (Usuario u : Plataforma.usuarios) {
            if (u instanceof Administrador) {
                admins.add((Administrador) u);
            }
        }
        return admins;
    }

    public static ArrayList<Instrutor> getInstrutores() {
        ArrayList<Instrutor> instrutores = new ArrayList<>();
        for (Usuario u : Plataforma.usuarios) {
            if (u instanceof Instrutor) {
                instrutores.add((Instrutor) u);
            }
        }
        return instrutores;
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

        new Aluno("123", "mariazinha", "Maria", "maria@gmail.com");
        new Aluno("123", "joaozinho", "Joao", "joao@gmail.com");

        new Curso("POO I - Classes e Atributos", instrutor);
        new Curso("POO II - Métodos", instrutor);
        new Curso("HTML", instrutor2);
        new Curso("CSS", instrutor2);


        int menu = 1;

        while (menu != 0) {
            menu = Menu.menuPrincipal(plataforma.nome);

            switch (menu) {
                case 1:
                    System.out.println("Digite seu username: ");
                    String username = scanner.nextLine();
                    System.out.println("Digite sua senha: ");
                    String senha = scanner.nextLine();
                    Usuario usuarioLogado = Usuario.login(username, senha);
                    if (usuarioLogado == null) {
                        System.out.println("Dados incorretos!");
                    } else {
                        System.out.println("Seja bem vindo, " + usuarioLogado.getNome() + "!");
                        int menuUsuario;
                        if (usuarioLogado instanceof Administrador) {
                            do {
                                menuUsuario = Menu.menuAdministrador();
                                switch (menuUsuario) {
                                    case 1:
                                        ((Administrador) usuarioLogado).listarAdministradores();
                                        break;
                                    case 2:
                                        ((Administrador) usuarioLogado).listarFuncionarios();
                                        break;
                                    case 3:
                                        usuarioLogado.listarCursos();
                                        break;
                                    case 4:
                                        usuarioLogado.alterarSenha();
                                        break;
                                    case 5:
                                        usuarioLogado.alterarUsername();
                                        break;
                                    case 6:
                                        ((Administrador) usuarioLogado).cadastrarNovoAdm();
                                        break;
                                    case 7:
                                        ((Administrador) usuarioLogado).cadastrarNovoInstrutor();
                                        break;
                                }

                            } while (menuUsuario != 0);
                        } else if (usuarioLogado instanceof Instrutor) {
                            do {
                                menuUsuario = Menu.menuInstrutor();
                                switch (menuUsuario) {
                                    case 1:
                                        usuarioLogado.listarCursos();
                                        break;
                                    case 2:
                                        ((Instrutor) usuarioLogado).listarMinhasTrilhas();
                                        break;
                                    case 3:
                                        usuarioLogado.alterarSenha();
                                        break;
                                    case 4:
                                        usuarioLogado.alterarUsername();
                                        break;
                                    case 5:
                                        ((Instrutor) usuarioLogado).cadastrarCurso();
                                        break;
                                    case 6:
                                        ((Instrutor) usuarioLogado).criarTrilhaDeEstudos();
                                        break;
                                    case 7:
                                        ((Instrutor) usuarioLogado).adicionarCursoEmUmaTrilha();
                                }
                            } while (menuUsuario != 0);
                        } else if (usuarioLogado instanceof Aluno) {
                            do {
                                menuUsuario = Menu.menuAluno();
                                switch (menuUsuario) {
                                    case 1:
                                        usuarioLogado.listarCursos();
                                        break;
                                    case 2:
                                        ((Aluno) usuarioLogado).listarMinhasInscricoes(false);
                                        break;
                                    case 3:
                                        ((Aluno) usuarioLogado).listarMinhasInscricoes(true);
                                        break;
                                    case 4:
                                        ((Aluno) usuarioLogado).listarMinhasInscricoes();
                                        break;
                                    case 5:
                                        usuarioLogado.imprimir();
                                        break;
                                    case 6:
                                        usuarioLogado.alterarSenha();
                                        break;
                                    case 7:
                                        ((Aluno) usuarioLogado).alterarEmail();
                                        break;
                                    case 8:
                                        usuarioLogado.alterarUsername();
                                        break;
                                    case 9:
                                        ((Aluno) usuarioLogado).realizarInscricao();
                                        break;
                                    case 10:
                                        ((Aluno) usuarioLogado).finalizarCurso();
                                        break;
                                    case 11:
                                        ((Aluno) usuarioLogado).avaliarCurso();
                                        break;
                                }

                            } while (menuUsuario != 0);
                        }

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
