package bancodao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Edson Lomba - 41525388
 * 
 */
public class TitularContaDaoRelacional implements TitularContaDaoInterface{

    private PreparedStatement stListAll;
    private PreparedStatement stmInserir;

    public TitularContaDaoRelacional(ConexaoInterface conexao)  throws BancoDaoException, ConexaoException {
        String sql= "";
        try {
            sql = "SELECT NRO_CONTA, NRO_TITULAR FROM CONTAS_TITULARES";
            stListAll = conexao.getConnection().prepareStatement(sql);
            sql = "INSERT INTO CONTAS_TITULARES VALUES (?,?)";
            stmInserir = conexao.getConnection().prepareStatement(sql);
        }catch (SQLException ex) {
            throw new BancoDaoException("Erro ao preparar sentença SQL: " + sql);
        }
    }
    
    @Override
    public List<TitularConta> obterTodos() throws BancoDaoException {
        List<TitularConta> titularConta;
        titularConta = new ArrayList<>();
        try {
            ResultSet resultados = stListAll.executeQuery();
            
            while (resultados.next()) {
                long nc = resultados.getLong("NRO_CONTA");
                long nt = resultados.getLong("NRO_TITULAR");
                TitularConta t = new TitularConta(nc,nt);
                titularConta.add(t);
            }
        } catch (SQLException ex) {
            throw new BancoDaoException("Erro ao executar consulta de todas as contas versus titulares");
        }
        return titularConta;
    } 


    @Override
    public int inserir(TitularConta tc) throws BancoDaoException{
        int ret = -1;
        try {
            stmInserir.setLong(1, tc.getNroConta());
            stmInserir.setLong(2, tc.getNroTitular());
            ret = stmInserir.executeUpdate();
        } catch (SQLException ex) {
            throw new BancoDaoException("Erro na operação de inserir nova conta!");
        }
        return ret;
    }
}
