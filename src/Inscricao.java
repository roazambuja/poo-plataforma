import java.time.LocalDate;

public class Inscricao {
    private Boolean concluido;
    private Boolean avaliado;
    public LocalDate dataInicial;
    public LocalDate dataFinal;
    public Aluno aluno;
    public Curso curso;

    Inscricao(Aluno aluno, Curso curso) {
        this.aluno = aluno;
        this.curso = curso;
        this.concluido = false;
        this.avaliado = false;
        this.dataInicial = LocalDate.now();
        aluno.minhasInscricoes.add(this);
        curso.alunos.add(aluno);
    }

    public String imprimeData(LocalDate data) {
        return data.getDayOfMonth() + "/" + data.getMonthValue() + "/" + data.getYear();
    }

    public void imprimir() {
        System.out.println("Curso: " + this.curso.titulo);
        System.out.println("Status: " + (this.concluido ? "Concluído" : "Em andamento"));
        System.out.println("Data de início: " + imprimeData(this.dataInicial));
        if (this.concluido) {
            System.out.println("Data de conclusão: " + imprimeData(this.dataFinal));
            if (!this.avaliado) {
                System.out.println("Avaliação pendente.");
            }
        }
        System.out.println("---------------------------------------------------------------");
    }

    public boolean concluiCurso() {
        if (this.concluido) {
            return false;
        } else {
            this.concluido = true;
            this.dataFinal = LocalDate.now();
        }
        return true;
    }

    public boolean getConcluido() {
        return concluido;
    }

    public boolean getAvaliado() {
        return avaliado;
    }

    public void cadastraAvaliacao(Integer nota) {
        if (nota > 5 || nota < 0) {
            System.out.println("Você deve avaliar o curso com uma nota válida!");
        } else {
            new Avaliacao(curso, aluno, nota);
            this.avaliado = true;
            System.out.println("Curso avaliado com sucesso! Agradecemos sua contribuição.");
        }
    }
}
