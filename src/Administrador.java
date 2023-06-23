import java.util.ArrayList;
import java.util.Scanner;

public class Administrador extends Usuario {

    Administrador(String senha, String username, String nome) {
        super(senha, username, nome);
        Plataforma.usuarios.add(this);
        Plataforma.administradores.add(this);
    }

    private static Administrador criar() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite o nome: ");
        String nome = leitor.nextLine();
        System.out.println("Digite um nome de usuário para login: ");
        String username = leitor.nextLine();
        System.out.println("Digite uma senha: ");
        String senha = leitor.nextLine();
        return new Administrador(senha, username, nome);
    }

    public static void main(String[] args) {
        Administrador a = Administrador.criar();
        a.imprimir();
    }

    public void listarAdministradores(){
        System.out.println("ADMINISTRADORES DA PLATAFORMA -------------------------------------------");
        for (Administrador admin : Plataforma.administradores) {
            admin.imprimir();
            System.out.println("-----------------------------------------------------------------------");
        }
    }

    public void listarFuncionarios(){
        System.out.println("INSTRUTORES DA PLATAFORMA -----------------------------------------");
        for (Instrutor instrutor : Plataforma.instrutores) {
            instrutor.imprimir();
            System.out.println("-----------------------------------------------------------------------");
        }
    }

    public void cadastrarNovoAdm() {
        Plataforma.administradores.add(Administrador.criar());
        System.out.println("Novo administrador cadastrado com sucesso!");
        System.out.println("-----------------------------------------------------------------------\n");
    }

    public void cadastrarNovoInstrutor() {
        Plataforma.instrutores.add(Instrutor.criar());
        System.out.println("Novo instrutor cadastrado com sucesso!");
        System.out.println("-----------------------------------------------------------------------\n");
    }
}
