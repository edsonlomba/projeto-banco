package bancodao;

import java.util.List;

public interface TitularDaoInterface {
    List<Titular> obterTodos() throws BancoDaoException;

    public int inserir(Titular t) throws BancoDaoException;
}
