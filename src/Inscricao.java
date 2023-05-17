public class Inscricao {
    public Boolean concluido;

    public Aluno aluno;
    public Curso curso;

    Inscricao() {
        this.concluido = false;
    }

    public static Inscricao criar() {
        return new Inscricao();
    }

    public void imprimir() {
        System.out.println("Concluido: " + this.concluido);
    }

    public static void main(String[] args) {
        Inscricao i = Inscricao.criar();
        i.imprimir();
    }
}
