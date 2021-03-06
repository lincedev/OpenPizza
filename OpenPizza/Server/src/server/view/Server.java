// Pacote View
package server.view;

// Importação dos pacotes e bibliotecas necessárias
import java.io.Serializable;
import javax.swing.JOptionPane;
import server.controle.Controle;
import server.controle.SocketServidor;
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

        SocketServidor servidor = new SocketServidor(); 
        Controle controle = new Controle();
        Autenticacao autenticacao = new Autenticacao();    
        
        // Verificação da existência dos arquivos de autenticação
        boolean verificarArquivos = controle.verificarArquivos();

        // Arquivos válidos -> Iniciar aplicação
        if (verificarArquivos) {
            controle.recuperarDadosAutenticacao(autenticacao);
            TelaPrincipal telaPrincipal = new TelaPrincipal(autenticacao, controle);
            telaPrincipal.setVisible(true);
            servidor.iniciar();
        }// Arquivos inválidos -> Mensagem de erro
        else {
            JOptionPane.showMessageDialog(null, "Não foi possível criar os arquivos necessários.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
