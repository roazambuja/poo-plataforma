import java.util.ArrayList;

public class Avaliacao {
    public Curso curso;
    public Aluno aluno;
    public Integer nota;

    public static ArrayList<Avaliacao> avaliacoes = new ArrayList<>();

    Avaliacao(Curso curso, Aluno aluno, Integer nota) {
        this.curso = curso;
        this.aluno = aluno;
        this.nota = nota;
        avaliacoes.add(this);
        this.curso.atualizaNota();
    }

    public static ArrayList<Avaliacao> listaAvaliacoesDeUmCurso(Curso curso) {
        ArrayList<Avaliacao> lista = new ArrayList<>();
        for (Avaliacao a : Avaliacao.avaliacoes) {
            if (a.curso == curso) {
                lista.add(a);
            }
        }
        return lista;
    }

    public void imprimir() {
        System.out.println("Nota: " + this.nota);
    }
}
