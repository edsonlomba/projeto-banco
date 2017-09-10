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
public class TitularDaoRelacional implements TitularDaoInterface{

    private PreparedStatement stListAll;
    private PreparedStatement stmInserir;
    
    public TitularDaoRelacional(ConexaoInterface conexao)  throws BancoDaoException, ConexaoException {
    String sql= "";
    try {
        sql = "SELECT NRO_TITULAR, NOME, RG, CPF FROM TITULARES";
        stListAll = conexao.getConnection().prepareStatement(sql);
        sql = "INSERT INTO TITULARES VALUES (?,?,?,?)";
        stmInserir = conexao.getConnection().prepareStatement(sql);
        }catch (SQLException ex) {
            throw new BancoDaoException("Erro ao preparar sentença SQL: " + sql);
        }
    }
    @Override
    public List<Titular> obterTodos() throws BancoDaoException {
        List<Titular> titular;
        titular = new ArrayList<>();
        try {
            ResultSet resultados = stListAll.executeQuery();
            
            while (resultados.next()) {
                long nu = resultados.getLong("NRO_TITULAR");
                String no = resultados.getString("NOME");
                String r = resultados.getString("RG");
                String c = resultados.getString("CPF");
                Titular t = new Titular(nu, no, r, c);
                titular.add(t);
            }
        } catch (SQLException ex) {
            throw new BancoDaoException("Erro ao executar consulta de todas as contas versus titulares");
        }
        return titular;
    } 
    
    @Override
    public int inserir(Titular t) throws BancoDaoException{
        int ret = -1;
        try {
            stmInserir.setLong(1, t.getNumero());
            stmInserir.setString(2, t.getNome());
            stmInserir.setString(3, t.getRg());
            stmInserir.setString(4, t.getCpf());
            ret = stmInserir.executeUpdate();
        } catch (SQLException ex) {
            throw new BancoDaoException("Erro na operação de inserir nova conta!");
        }
        return ret;
    }
    
}
