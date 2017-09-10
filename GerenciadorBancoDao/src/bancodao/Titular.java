package bancodao;

public class Titular {
    private long numero;
    private String nome;
    private String rg;
    private String cpf;

    public Titular() {
    }

    public Titular(long numero, String nome, String rg, String cpf) {
        this.numero = numero;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}