// Pacote Controle
package client.control;

// Importação das bibliotecas necessárias
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 Descrição: Classe de comunicação TCP (Server-Client)
 */
public class SocketCliente {
    
    /*
     Descrição: Método para iniciar o socket do cliente. (Utilizado para comunicação via TCP)
     Parâmetros:
     numeroDaMesa (Inteiro contendo o número da mesa que requisitou a conexão com o servidor)
     numeroDoPedido (Inteiro contendo o número do pedido que foi gerado pelo cliente)
     Retorno:
     */
    public void notificarServidor(int numeroDaMesa, int numeroDoPedido) {

        // String contendo a mensagem que será enviada ao servidor
        String mensagemDoCliente = "Mesa " + numeroDaMesa + " acabou de incluir um produto no Pedido " + numeroDoPedido;

        // Tentativa de conexão com o servidor e envio da mensagem
        try {
            Socket client = new Socket("localhost", 40000);
            DataOutputStream saidaParaServidor = new DataOutputStream(client.getOutputStream());
            saidaParaServidor.writeBytes(mensagemDoCliente);
            client.close();
        } catch (UnknownHostException e) {

        } catch (IOException e) {

        }
    }
}
