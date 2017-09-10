package bancodao;

import java.math.BigDecimal;
import java.util.Scanner;

public class AppAtualizarContaComDao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Número da conta a ser atualizada: ");
        String s = sc.nextLine();
        long numero = Long.parseLong(s);
        System.out.print("Novo valor para o saldo: ");
        s = sc.nextLine();
        BigDecimal saldo = new BigDecimal(s);
        Conta conta = new Conta(numero, saldo);
        try {
            ContaDaoInterface dao = new ContaDaoRelacional(
                                        new ConexaoJavaDb(
                                            "localhost", 1527, "app", "app", "sistema_bancario"));
            int resposta = dao.atualizar(conta);
            System.out.println("Resposta da atualização: " + resposta);
        } catch(ConexaoException e) {
            System.out.println(e.getMensagem());
        } catch(BancoDaoException e) {
            System.out.println(e.getMensagem());
        }
    }
}
