package bancodao;

import java.util.List;

/**
 *
 * @author Edson Lomba - 41525388
 * 
 */
public interface TitularContaDaoInterface {
    List<TitularConta> obterTodos() throws BancoDaoException;

    public int inserir(TitularConta tc) throws BancoDaoException;
}
