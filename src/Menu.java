import java.util.Scanner;

public abstract class Menu {
    public static Scanner scanner = new Scanner(System.in);

    public static Integer menuPrincipal(String nome) {
        System.out.println("Seja bem vindo a plataforma " + nome + "!");
        System.out.println("1 - Fazer login");
        System.out.println("2 - Criar conta");
        System.out.println("0 - Sair");
        return scanner.nextInt();
    }

    public static Integer menuAluno() {
        System.out.println("1 - Ver cursos da plataforma");
        System.out.println("2 - Ver meus cursos em andamento");
        System.out.println("3 - Ver meus cursos concluídos");
        System.out.println("4 - Ver todas as minhas inscrições");
        System.out.println("5 - Ver meu perfil");
        System.out.println("6 - Alterar senha");
        System.out.println("7 - Alterar email");
        System.out.println("8 - Alterar username");
        System.out.println("9 - Realizar inscrição em um curso");
        System.out.println("10 - Finalizar curso");
        System.out.println("11 - Avaliar um curso");
        System.out.println("0 - Sair");
        return scanner.nextInt();
    }

    public static Integer menuInstrutor() {
        System.out.println("1 - Listar seus cursos");
        System.out.println("2 - Ver informações de um curso");
        System.out.println("3 - Visualizar suas trilhas de estudo");
        System.out.println("4 - Alterar senha");
        System.out.println("5 - Alterar username");
        System.out.println("6 - Cadastrar um novo curso");
        System.out.println("7 - Criar trilha de estudos");
        System.out.println("0 - Sair");
        return scanner.nextInt();
    }

    public static Integer menuAdministrador() {
        System.out.println("1 - Visualizar todos administradores");
        System.out.println("2 - Visualizar todos instrutores");
        System.out.println("3 - Visualizar todos os cursos");
        System.out.println("4 - Alterar senha");
        System.out.println("5 - Alterar username");
        System.out.println("6 - Cadastrar outro administrador");
        System.out.println("7 - Cadastrar novo instrutor");
        System.out.println("0 - Sair");
        return scanner.nextInt();
    }
}
