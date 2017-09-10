package bancodao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoJavaDb implements ConexaoInterface {
    private String hostname;
    private int porta;
    private String usuario;
    private String senha;
    private String nomeBancoDados;
    private Connection connection;

    public ConexaoJavaDb() {
    }

    public ConexaoJavaDb(String hostname, int porta, String usuario, String senha, String nomeBancoDados) {
        this.hostname = hostname;
        this.porta = porta;
        this.usuario = usuario;
        this.senha = senha;
        this.nomeBancoDados = nomeBancoDados;
    }

    @Override
    public Connection getConnection() throws ConexaoException {
        if (connection == null) {
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                String url = "jdbc:derby://" + hostname + ":" + porta + "/" + nomeBancoDados;
                connection = DriverManager.getConnection(url, usuario, senha);
            } catch (ClassNotFoundException ex) {
                throw new ConexaoException("Driver JDBC não encontrado!");   
            } catch (SQLException ex) {
                throw new ConexaoException("Falha ao abrir conexão!");
            }
        }
        return connection;
    }

    @Override
    public void close() throws ConexaoException {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                throw new ConexaoException("Falha ao fechar a conexão!");
            }
        }
    }
    
    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNomeBancoDados() {
        return nomeBancoDados;
    }

    public void setNomeBancoDados(String nomeBancoDados) {
        this.nomeBancoDados = nomeBancoDados;
    }
    
}
