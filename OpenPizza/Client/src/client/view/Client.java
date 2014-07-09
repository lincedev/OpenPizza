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

        boolean verificarArquivos = controle.verificarArquivos();
        if (verificarArquivos) {
            controle.recuperarDadosAutenticacao(autenticacao);
            New_TelaPrincipal telaPrincipal = new New_TelaPrincipal(autenticacao, controle);
            telaPrincipal.setIconImage(new ImageIcon("../Imagens/pedaco_pizza.png").getImage());
            telaPrincipal.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível criar os arquivos necessários.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
