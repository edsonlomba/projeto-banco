package bancodao;

import java.sql.Connection;

public interface ConexaoInterface {
    Connection getConnection() throws ConexaoException;
    void close() throws ConexaoException;
}

