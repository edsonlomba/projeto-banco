package bancodao;

public class BancoDaoException extends Exception {
    private String mensagem;

    public BancoDaoException() {
    }

    public BancoDaoException(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
    
}
