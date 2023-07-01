import java.util.ArrayList;

public class TrilhaDeEstudos {
    public String nome;
    public ArrayList<Curso> cursos;

    TrilhaDeEstudos(String nome) {
        this.nome = nome;
        this.cursos = new ArrayList<>();
    }

    public void imprimir() {
        System.out.println("Trilha - " + this.nome);
        for (Curso c : this.cursos) {
            System.out.println("-- " + c.titulo);
        }
        System.out.println("-----------------------------------------------------------------------");
    }
}
