package bancodao;

/**
 *
 * @author Edson Lomba - 41525388
 * 
 */
public class TitularConta {
    private long nroConta;
    private long nroTitular;
    private Conta conta;
    private Titular titular;

    public TitularConta(long conta, long titular) {
        this.nroConta = conta;
        this.nroTitular = titular;
    }

    public TitularConta(Conta conta, Titular titular) {
        this.conta = conta;
        this.titular = titular;
    }

    public long getNroConta() {
        return nroConta;
    }

    public void setNroConta(int nroConta) {
        this.nroConta = nroConta;
    }

    public long getNroTitular() {
        return nroTitular;
    }

    public void setNroTitular(int nroTitular) {
        this.nroTitular = nroTitular;
    }

    public Conta getConta() {
        return conta;
    }

    public Titular getTitular() {
        return titular;
    }
    
}
