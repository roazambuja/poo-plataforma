import java.util.ArrayList;

public class Curso {
    private String titulo;
    private Instrutor instrutor;
    private ArrayList<Aluno> alunos;

    Curso(String titulo, Instrutor instrutor) {
        this.titulo = titulo;
        this.instrutor = instrutor;
        this.alunos = new ArrayList<>();
        Plataforma.getCursos().add(this);
        instrutor.getCursos().add(this);
    }

    public String getTitulo() {
        return this.titulo;
    }

    public ArrayList<Aluno> getAlunos() {
        return this.alunos;
    }

    public Instrutor getInstrutor() {
        return this.instrutor;
    }

    public void imprimir() {
        System.out.println("Titulo: " + this.titulo);
        System.out.println("Instrutor: " + this.instrutor.getNome());
        System.out.println("Nota média: " + (this.getNota() == null ? "ainda não avaliado" : this.getNota()));
    }

    public Double getNota() {
        Double soma = 0.0;
        ArrayList<Avaliacao> lista = Avaliacao.listaAvaliacoesDeUmCurso(this);
        for (Avaliacao a : lista) {
            soma += a.getNota();
        }
        if (lista.size() == 0) {
            return null;
        }
        return (soma / lista.size());
    }
}
