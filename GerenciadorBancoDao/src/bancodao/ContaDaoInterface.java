package bancodao;

import java.util.List;

public interface ContaDaoInterface {
    List<Conta> obterTodos() throws BancoDaoException;
    
    // outras operações
    int inserir(Conta conta) throws BancoDaoException;
    int atualizar(Conta conta) throws BancoDaoException;
    int apagar(long numero) throws BancoDaoException;
    Conta buscar(long numero) throws BancoDaoException;
}