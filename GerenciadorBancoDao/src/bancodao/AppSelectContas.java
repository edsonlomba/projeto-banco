package bancodao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AppSelectContas {

    public static void main(String[] args) 
            throws ClassNotFoundException, SQLException {
        
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection conexao;
        String url = "jdbc:derby://127.0.0.1:1527/sistema_bancario";
        String usuario = "app";
        String senha = "app";
        conexao = DriverManager.getConnection(url, usuario, senha);
        
        Statement st;
        st = conexao.createStatement();
        
        String sql = "SELECT nro_conta, saldo FROM contas";
        ResultSet resultados = st.executeQuery(sql);
        
        System.out.println("Dados das contas:");
        while (resultados.next()) {
            System.out.print("Número: " + resultados.getLong("nro_conta") + " - ");
            System.out.println("Saldo: R$ " + resultados.getBigDecimal("saldo"));
        }
        
        conexao.close();
    }
    
}
