package mack.controllers.impl;

import bancodao.BancoDaoException;
import bancodao.ConexaoException;
import bancodao.ConexaoInterface;
import bancodao.ConexaoJavaDb;
import bancodao.Conta;
import bancodao.ContaDaoInterface;
import bancodao.ContaDaoRelacional;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mack.controllers.AbstractController;

/**
 *
 * @author Edson Lomba - 41525388
 * 
 */
public class RemoveController extends AbstractController{

    @Override
    public void execute() {
        try {
            ConexaoInterface conexao = new ConexaoJavaDb("localhost", 1527, "app", "app", "sistema_bancario");
            boolean conexaoEstabelecida = false;
            ContaDaoInterface dao = null;
            String sNumero = this.getRequest().getParameter("numero");
            try {
                dao = new ContaDaoRelacional(conexao);
                conexaoEstabelecida = true;
            } catch (ConexaoException e) {
                conexaoEstabelecida = false;
            } catch (BancoDaoException ex) {
                conexaoEstabelecida = false;
            }
            if (conexaoEstabelecida) {
                long numero = Long.parseLong(sNumero);
                List<Conta> contas;
                try {
                    dao.apagar(numero);
                    contas = dao.obterTodos();
                    this.setReturnPage("/remove_conta.jsp");
                    this.getRequest().setAttribute("lista_contas", contas);
                } catch (BancoDaoException ex) {
                    this.setReturnPage("/erro.jsp");
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(RemoveController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
