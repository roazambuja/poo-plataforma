import java.util.ArrayList;
import java.util.Scanner;

public class Administrador extends Usuario {

    Administrador(String senha, String username, String nome) {
        super(senha, username, nome);
    }

    public static Administrador criar() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite seu nome: ");
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

    private static Administrador getByUsername(String user, ArrayList<Administrador> admins) {
        for (Administrador admin : admins) {
            if (admin.username.equals(user)) {
                return admin;
            }
        }
        return null;
    }

    public static Administrador login(String user, String senha, ArrayList<Administrador> admins) {
        Administrador admin = Administrador.getByUsername(user, admins);
        if (admin != null) {
            if (admin.senha.equals(senha)) {
                return admin;
            }
        }
        return null;
    }

}
