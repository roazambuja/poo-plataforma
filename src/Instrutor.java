import java.util.ArrayList;
import java.util.Scanner;

public class Instrutor extends Usuario {
    public ArrayList<Curso> cursos;
    public ArrayList<TrilhaDeEstudos> trilhas;

    Instrutor(String senha, String username, String nome) {
        super(senha, username, nome);
        this.cursos = new ArrayList<>();
        this.trilhas = new ArrayList<>();
        Plataforma.usuarios.add(this);
    }

    public static Instrutor criar() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite o nome: ");
        String nome = leitor.nextLine();
        System.out.println("Digite um nome de usuário para login: ");
        String username = leitor.nextLine();
        System.out.println("Digite uma senha: ");
        String senha = leitor.nextLine();
        return new Instrutor(senha, username, nome);
    }

    @Override
    public void listarCursos() {
        System.out.println("MEUS CURSOS -----------------------------------------");
        for (Curso curso : this.cursos) {
            curso.imprimir();
            System.out.println("Quantidade de alunos: " + curso.alunos.size());
            System.out.println("-----------------------------------------------------------------------");
        }
    }

    public Curso cadastrarCurso() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite o título do curso: ");
        String titulo = leitor.nextLine();
        return new Curso(titulo, this);
    }

    public void listarMinhasTrilhas() {
        System.out.println("MINHAS TRILHAS DE ESTUDO -----------------------------------------");
        for (TrilhaDeEstudos t : this.trilhas) {
            t.imprimir();
        }
        if (this.trilhas.size() == 0) {
            System.out.println("Você ainda não tem nenhuma trilha de estudos cadastrada!");
            System.out.println("-----------------------------------------------------------------------");
        }
    }

    public void criarTrilhaDeEstudos() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Qual será o nome da trilha de estudos? ");
        String titulo = leitor.nextLine();
        this.trilhas.add(new TrilhaDeEstudos(titulo));
        System.out.println("Trilha cadastrada! Agora, adicione os cursos que deseja nela.");
    }

    public void adicionarCursoEmUmaTrilha() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Qual o nome da trilha que você deseja incluir o curso?");
        String nomeTrilha = leitor.nextLine();
        TrilhaDeEstudos trilha = this.getTrilhaByName(nomeTrilha);
        if (trilha == null) {
            System.out.println("Não encontramos uma trilha cadastrada com esse nome.");
        } else {
            System.out.println("Qual o nome do curso que você deseja incluir na trilha?");
            String nomeCurso = leitor.nextLine();
            Curso curso = Usuario.getCursoByName(nomeCurso);
            if (curso == null) {
                System.out.println("Curso não encontrado.");
            } else {
                if (curso.instrutor != this) {
                    System.out.println("Você pode adicionar apenas seus cursos na trilha de estudos.");
                } else {
                    trilha.cursos.add(curso);
                    System.out.println("Curso adicionado na trilha de estudos com sucesso.");
                }
            }
        }
    }

    public TrilhaDeEstudos getTrilhaByName(String nome) {
        for (TrilhaDeEstudos t : this.trilhas) {
            if (t.nome.equals(nome)) {
                return t;
            }
        }
        return null;
    }
}
