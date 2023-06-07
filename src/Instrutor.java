import java.util.ArrayList;
import java.util.Scanner;

public class Instrutor extends Usuario {
    public ArrayList<Curso> cursos;

    Instrutor(String senha, String username, String nome) {
        super(senha, username, nome);
        this.cursos = new ArrayList<>();
    }

    public static Instrutor criar() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite seu nome: ");
        String nome = leitor.nextLine();
        System.out.println("Digite um nome de usuário para login: ");
        String username = leitor.nextLine();
        System.out.println("Digite uma senha: ");
        String senha = leitor.nextLine();
        return new Instrutor(senha, username, nome);
    }

    public static void main(String[] args) {
        Instrutor i = Instrutor.criar();
        i.imprimir();
    }

    private static Instrutor getByUsername(String user, ArrayList<Instrutor> instrutores) {
        for (Instrutor instrutor : instrutores) {
            if (instrutor.username.equals(user)) {
                return instrutor;
            }
        }
        return null;
    }

    public static Instrutor login(String user, String senha, ArrayList<Instrutor> instrutores) {
        Instrutor instrutor = Instrutor.getByUsername(user, instrutores);
        if (instrutor != null) {
            if (instrutor.senha.equals(senha)) {
                return instrutor;
            }
        }
        return null;
    }
}
