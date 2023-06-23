import java.util.ArrayList;
import java.util.Scanner;

public class Aluno extends Usuario {
    public String email;
    public String matricula;

    public ArrayList<Curso> cursosConcluidos;
    public ArrayList<Curso> cursosEmAndamento;

    public static Integer counter = 1;

    Aluno(String senha, String username, String nome, String email) {
        super(senha, username, nome);
        this.email = email;
        this.cursosConcluidos = new ArrayList<>();
        this.cursosEmAndamento = new ArrayList<>();
        this.matricula = String.format("%05d", counter++);
        Plataforma.alunos.add(this);
        Plataforma.usuarios.add(this);
    }

    public static Aluno criar() {
        System.out.println("Olá, novo aluno! Informe seus dados para o cadastro.");
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite seu nome: ");
        String nome = leitor.nextLine();
        System.out.println("Digite um nome de usuário para login: ");
        String username = leitor.nextLine();
        System.out.println("Digite uma senha: ");
        String senha = leitor.nextLine();
        System.out.println("Digite seu email: ");
        String email = leitor.nextLine();
        return new Aluno(senha, username, nome, email);
    }

    public void imprimir() {
        super.imprimir();
        System.out.println("Email: " + this.email);
        System.out.println("Matrícula: " + this.matricula);
    }
}