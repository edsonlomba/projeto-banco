package bancodao;

public class ConexaoException extends Exception {
    private String mensagem;

    public ConexaoException() {
    }

    public ConexaoException(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
    
}
