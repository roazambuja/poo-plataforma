import java.util.Scanner;

public abstract class Usuario {
    public String senha;
    public String username;
    public String nome;

    Usuario(String senha, String username, String nome) {
        this.senha = senha;
        this.username = username;
        this.nome = nome;
    }

    public void imprimir() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Username: " + this.username);
        System.out.println("Senha: " + this.senha);
    }
}
