// Pacote Controle
package server.controle;

// Importação das bibliotecas necessárias
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

/*
Descrição: Classe de comunicação TCP (Server-Client)
*/
public class SocketServidor extends Thread {

    /*
     Descrição: Método para iniciar o socket do servidor. (Utilizado para comunicação via TCP)
     Parâmetros:
     Retorno:
     */
    public void iniciar() {

        // String contendo a mensagem enviada pelo Client
        String mensagemDoCliente;
        
        // Tentativa de criação do socket e espera pela conexão dos clientes
        try {
            ServerSocket socket = new ServerSocket(40000);
            JOptionPane.showMessageDialog(null, "Servidor iniciado. \nAguardando conexão dos clientes.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            
            // Execução contínua da thread
            while (!Thread.currentThread().isInterrupted()) {
                Socket connectionSocket = socket.accept();
                BufferedReader entradaDoCliente = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                mensagemDoCliente = entradaDoCliente.readLine();
                JOptionPane.showMessageDialog(null, mensagemDoCliente, "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException e) {

        }
    }
}
