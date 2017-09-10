package bancodao;

import java.util.List;

public class AppSelectContasComDao {

    public static void main(String[] args) {
        ConexaoInterface conexao = new ConexaoJavaDb("127.0.0.1", 1527, "app", "app", "sistema_bancario");
        try {
            ContaDaoInterface dao = new ContaDaoRelacional(conexao);
            List<Conta> todasContas = dao.obterTodos();
            for (Conta c : todasContas) {
                System.out.print("Número: " + c.getNumero() + " - ");
                System.out.println("Saldo: R$ " + c.getSaldo());
            }
            conexao.close();
        } catch(ConexaoException ex) {
            System.out.println("Erro de conexão!");
            System.out.println(ex.getMensagem());
        } catch (BancoDaoException ex) {
            System.out.println("Erro ao executar operação na base de dados!");
            System.out.println(ex.getMensagem());
        }
    }
}
