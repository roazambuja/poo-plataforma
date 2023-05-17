import java.util.ArrayList;
import java.util.Scanner;

public class Curso {
    public String titulo;

    public Instrutor instrutor;
    public ArrayList<Aluno> alunos;

    public static Curso criar() {
        Curso curso = new Curso();
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite o título do curso: ");
        curso.titulo = leitor.nextLine();
        return curso;
    }

    public void imprimir() {
        System.out.println("Titulo: " + this.titulo);
    }

    public static void main(String[] args) {
        Curso c = Curso.criar();
        c.imprimir();
    }
}
