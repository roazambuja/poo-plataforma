import java.util.Scanner;

public class Avaliacao {
    public Curso curso;
    public Aluno aluno;
    public Integer nota;

    public static Avaliacao criar() {
        Avaliacao avaliacao = new Avaliacao();
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite sua nota para o curso: ");
        avaliacao.nota = leitor.nextInt();
        return avaliacao;
    }

    public void imprimir() {
        System.out.println("Nota: " + this.nota);
    }

    public static void main(String[] args) {
        Avaliacao a = Avaliacao.criar();
        a.imprimir();
    }
}
