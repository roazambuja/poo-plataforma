import java.util.ArrayList;

public class Avaliacao {
    private Curso curso;
    private Aluno aluno;
    private Integer nota;
    private static ArrayList<Avaliacao> avaliacoes = new ArrayList<>();

    Avaliacao(Curso curso, Aluno aluno, Integer nota) {
        this.curso = curso;
        this.aluno = aluno;
        this.nota = nota;
        avaliacoes.add(this);
    }

    public Integer getNota() {
        return this.nota;
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
}
