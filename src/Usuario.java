import java.util.Scanner;


public abstract class Usuario {
    private String senha;
    private String username;
    private String nome;
    private static Scanner scanner = new Scanner(System.in);

    Usuario(String senha, String username, String nome) {
        this.senha = senha;
        this.username = username;
        this.nome = nome;
    }

    public void imprimir() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Username: " + this.username);
    }

    public String getSenha() {
        return this.senha;
    }

    public String getNome() {
        return this.nome;
    }

    public void alterarSenha() {
        System.out.println("Digite sua senha atual: ");
        String atual = scanner.nextLine();
        System.out.println("Digite a sua nova senha: ");
        String nova = scanner.nextLine();
        if (validaTrocaDeSenha(atual, nova)) {
            System.out.println("Senha alterada com sucesso\n");
        } else {
            System.out.println("Não foi possível alterar sua senha, tente novamente.\n");
        }
    }

    public void alterarUsername() {
        System.out.println("Digite sua senha: ");
        String senha = scanner.nextLine();
        System.out.println("Digite seu novo username: ");
        String username = scanner.nextLine();
        if (validaTrocaDeUsername(senha, username)) {
            System.out.println("Username alterado com sucesso!\n");
        } else {
            System.out.println("Não foi possível alterar seu username, tente novamente.\n");
        }
    }

    private boolean validaTrocaDeUsername(String senha, String username) {
        if (senha.equals(this.senha)) {
            this.username = username;
            return true;
        }
        return false;
    }

    private boolean validaTrocaDeSenha(String senhaAntiga, String senhaNova) {
        if (senhaAntiga.equals(this.senha)) {
            this.senha = senhaNova;
            return true;
        }
        return false;
    }

    public static Usuario login(String username, String senha) {
        Usuario user = Usuario.getByUsername(username);
        if (user != null) {
            if (user.senha.equals(senha)) {
                return user;
            }
        }
        return null;
    }

    private static Usuario getByUsername(String username) {
        for (Usuario user : Plataforma.getUsuarios()) {
            if (user.username.equals(username)) {
                return user;
            }
        }
        return null;
    }

    public void listarCursos() {
        System.out.println("CURSOS DISPONIVEIS -----------------------------------------");
        for (Curso curso : Plataforma.getCursos()) {
            curso.imprimir();
            System.out.println("-----------------------------------------------------------------------");
        }
    }

    public static Curso getCursoByName(String nome) {
        for (Curso c : Plataforma.getCursos()) {
            if (c.getTitulo().equals(nome)) {
                return c;
            }
        }
        return null;
    }
}
