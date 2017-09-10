package bancodao;

import bancodao.BancoDaoException;
import bancodao.ConexaoException;
import bancodao.ConexaoInterface;
import bancodao.ConexaoJavaDb;
import bancodao.Titular;
import bancodao.TitularDaoInterface;
import bancodao.TitularDaoRelacional;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author edson
 */
public class AppInsertTitularDao {
        public static void main(String[] args) throws BancoDaoException, ConexaoException {
        
        ConexaoInterface conexao;
        conexao = new ConexaoJavaDb("localhost",1527,"app","app","sistema_bancario");
        TitularDaoInterface dao;
        dao = new TitularDaoRelacional(conexao);
        List<Titular> titular;
        titular = dao.obterTodos();
        
        System.out.println("Contas existentes:");
        for (Titular t : titular) {
            System.out.print("Nro Titular: " + t.getNumero());
            System.out.print(" - ");
            System.out.print("Nome: " + t.getNome());
            System.out.print(" - ");
            System.out.print("RG: " + t.getRg());
            System.out.print(" - ");
            System.out.println("CPF: " + t.getCpf());
        }
        
        System.out.println("\nInserir os dados da nova conta");
        
        Scanner entradaNumero = new Scanner(System.in);
        System.out.print("Número do titular: ");
        long numero = entradaNumero.nextLong();
            
        Scanner entradaNome = new Scanner(System.in);
        System.out.print("Nome do titular: ");
        String nome = entradaNome.nextLine();
            
        Scanner entradaRg = new Scanner(System.in);
        System.out.print("RG do titular: ");
        String rg = entradaRg.nextLine();
            
        Scanner entradaCpf = new Scanner(System.in);
        System.out.print("CPF do titular: ");
        String cpf = entradaCpf.nextLine();
        
        Titular inserirTitular;
        inserirTitular = new Titular(numero,nome,rg,cpf);
        
        dao.inserir(inserirTitular);
        
        conexao.close();
        }
}
