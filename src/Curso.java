import java.util.ArrayList;
import java.util.Scanner;

public class Curso {
    public String titulo;

    public Instrutor instrutor;
    public ArrayList<Aluno> alunos;

    Curso(String titulo, Instrutor instrutor) {
        this.titulo = titulo;
        this.instrutor = instrutor;
        this.alunos = new ArrayList<>();
        Plataforma.cursos.add(this);
        instrutor.cursos.add(this);
    }

    public void imprimir() {

        System.out.println("Titulo: " + this.titulo);
        System.out.println("Instrutor: " + this.instrutor.nome);
    }
}
