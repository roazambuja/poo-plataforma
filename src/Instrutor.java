import java.util.ArrayList;
import java.util.Scanner;

public class Instrutor extends Usuario {
    public ArrayList<Curso> cursos;

    Instrutor(String senha, String username, String nome) {
        super(senha, username, nome);
        this.cursos = new ArrayList<>();
        Plataforma.instrutores.add(this);
        Plataforma.usuarios.add(this);
    }

    public static Instrutor criar() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite o nome: ");
        String nome = leitor.nextLine();
        System.out.println("Digite um nome de usuário para login: ");
        String username = leitor.nextLine();
        System.out.println("Digite uma senha: ");
        String senha = leitor.nextLine();
        return new Instrutor(senha, username, nome);
    }
}
