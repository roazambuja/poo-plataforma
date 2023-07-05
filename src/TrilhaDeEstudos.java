import java.util.ArrayList;

public class TrilhaDeEstudos {
    private String nome;
    private ArrayList<Curso> cursos;

    TrilhaDeEstudos(String nome) {
        this.nome = nome;
        this.cursos = new ArrayList<>();
    }

    public String getNome() {
        return this.nome;
    }

    public ArrayList<Curso> getCursos() {
        return this.cursos;
    }

    public void imprimir() {
        System.out.println("Trilha - " + this.nome);
        for (Curso c : this.cursos) {
            System.out.println("-- " + c.getTitulo());
        }
        System.out.println("-----------------------------------------------------------------------");
    }
}
