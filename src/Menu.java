import java.util.Scanner;

public abstract class Menu {
    public static Scanner scanner = new Scanner(System.in);

    public static Integer menuPrincipal(String nome){
        System.out.println("Seja bem vindo a plataforma " + nome + "!");
        System.out.println("1 - Fazer login");
        System.out.println("2 - Criar conta");
        System.out.println("0 - Sair");
        return scanner.nextInt();
    }

    public static Integer menuOpcoes() {
        System.out.println("Como deseja fazer login?");
        System.out.println("1 - Aluno");
        System.out.println("2 - Administrador");
        System.out.println("3 - Instrutor");
        System.out.println("0 - Voltar");
        return scanner.nextInt();
    }

    public static Integer menuAluno() {
        System.out.println("1 - Ver cursos disponíveis");
        System.out.println("2 - Ver cursos em andamento");
        System.out.println("3 - Ver cursos concluídos");
        System.out.println("4 - Alterar senha");
        System.out.println("5 - Alterar email");
        System.out.println("6 - Alterar username");
        System.out.println("7 - Realizar inscrição em um curso");
        System.out.println("8 - Finalizar curso");
        System.out.println("9 - Avaliar um curso");
        return scanner.nextInt();
    }

    public static Integer menuInstrutor(){
        System.out.println("1 - Listar seus cursos");
        System.out.println("2 - Ver informações de um curso");
        System.out.println("3 - Visualizar suas trilhas de estudo");
        System.out.println("4 - Alterar senha");
        System.out.println("5 - Alterar username");
        System.out.println("6 - Cadastrar um novo curso");
        System.out.println("7 - Criar trilha de estudos");
        return scanner.nextInt();
    }

    public static Integer menuAdministrador(){
        System.out.println("1 - Visualizar todos administradores");
        System.out.println("2 - Visualizar todos instrutores");
        System.out.println("3 - Visualizar todos os cursos");
        System.out.println("4 - Alterar senha");
        System.out.println("5 - Alterar username");
        System.out.println("6 - Cadastrar outro administrador");
        System.out.println("7 - Cadastrar novo instrutor");
        return scanner.nextInt();
    }
}
