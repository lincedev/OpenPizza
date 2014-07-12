// Pacote View
package server.view;

// Importação dos pacotes e bibliotecas necessárias
import java.io.Serializable;
import server.controle.Controle;
import server.modelo.Autenticacao;

/*
 Descrição: Classe principal do servidor
 */
public class Server implements Serializable {

    /*
     Descrição: Método principal
     Parâmetros:
     Retorno:
     */
    public static void main(String[] args) {

        Controle controle = new Controle();
        Autenticacao autenticacao = new Autenticacao();
        try{
            autenticacao = controle.recuperarDadosDeAutenticacao();
        }
        catch(Exception e){
            
        }
        
        // Criação da tela principal
        TelaPrincipal telaPrincipal = new TelaPrincipal(autenticacao, controle);
        telaPrincipal.setResizable(false);
        telaPrincipal.setVisible(true);
    }

}
