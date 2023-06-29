import java.util.ArrayList;

public class Curso {
    public String titulo;
    public Instrutor instrutor;
    public ArrayList<Aluno> alunos;
    private Double nota;

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
        System.out.println("Nota média: " + (this.nota == null ? "ainda não avaliado" : this.nota));
    }

    public void atualizaNota() {
        Double soma = 0.0;
        ArrayList<Avaliacao> lista = Avaliacao.listaAvaliacoesDeUmCurso(this);
        for (Avaliacao a : lista) {
            soma += a.nota;
        }
        this.nota = soma / lista.size();
    }
}
