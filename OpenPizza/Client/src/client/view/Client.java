// Pacote View
package client.view;

// Importação dos pacotes e bibliotecas necessárias
import client.control.Controle;
import client.model.Autenticacao;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 Descrição: Classe principal do cliente
 */
public class Client implements Serializable {

    /*
     Descrição: Método principal.
     Parâmetros: 
     Retorno:
     */
    public static void main(String[] args) {

        Controle controle = new Controle();
        Autenticacao autenticacao = new Autenticacao();

        // Verificação da existência dos arquivos de autenticação
        boolean verificarArquivos = controle.verificarArquivos();
        // Arquivos válidos -> Iniciar aplicação
        if (verificarArquivos) {
            controle.recuperarDadosAutenticacao(autenticacao);
            TelaPrincipal telaPrincipal = new TelaPrincipal(autenticacao, controle);
            telaPrincipal.setIconImage(new ImageIcon("../Imagens/pedaco_pizza.png").getImage());
            telaPrincipal.setVisible(true);
        }// Arquivos inválidos -> Mensagem de erro
        else {
            JOptionPane.showMessageDialog(null, "Não foi possível criar os arquivos necessários.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
