import java.util.ArrayList;
import java.util.Scanner;

public class Curso {
    public String titulo;

    public Instrutor instrutor;
    public ArrayList<Aluno> alunos;

    Curso(String titulo, Instrutor instrutor) {
        this.titulo = titulo;
        this.instrutor = instrutor;
    }

//    public static Curso criar() {
//        Curso curso = new Curso();
//        Scanner leitor = new Scanner(System.in);
//        System.out.println("Digite o título do curso: ");
//        curso.titulo = leitor.nextLine();
//        return curso;
//    }

    public void imprimir() {

        System.out.println("Titulo: " + this.titulo);
        System.out.println("Instrutor: " + this.instrutor.nome);
    }
}
