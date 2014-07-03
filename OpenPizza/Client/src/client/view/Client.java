package client.view;

import client.control.Controle;
import client.model.Autenticacao;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


/*
 Descrição: Classe principal do cliente
 */
public class Client implements Serializable {
 
    public static Controle controle = new Controle();
    
    public static Autenticacao autenticacao = new Autenticacao();
    /*
     Descrição: Método principal.
     Parâmetros: 
     Retorno:
     */
    public static void main(String[] args) {

        boolean verificarArquivos = controle.verificarArquivos();
        if(verificarArquivos){
            autenticacao = controle.recuperarDadosAutenticacao();
            New_TelaPrincipal telaPrincipal = new New_TelaPrincipal(autenticacao, controle);
            telaPrincipal.setIconImage(new ImageIcon("../Imagens/pedaco_pizza.png").getImage());
            telaPrincipal.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null, "Não foi possível criar os arquivos necessários.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
        
        
    }
}
