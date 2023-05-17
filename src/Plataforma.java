import java.util.ArrayList;
import java.util.Scanner;

public class Plataforma {
    public String nome;
    public String cnpj;
    public String email;

    public ArrayList<Administrador> administradores;
    public ArrayList<Instrutor> instrutores;
    public ArrayList<Curso> cursos;

    Plataforma(String nome, String cnpj, String email) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.email = email;
        this.administradores = new ArrayList<>();
        this.administradores.add(new Administrador("admin", "admin123", "Admin"));
        this.instrutores = new ArrayList<>();
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

    public static void main(String[] args) {
        Plataforma p = Plataforma.criar();
        p.imprimir();

        Plataforma p2 = Plataforma.criar();
        p2.imprimir();
    }
}
