package server.view;

import javax.swing.*;
import server.persistencia.Arquivos;
import java.io.*;

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

        /*
         * Parâmetros para conexão no banco de dados
         * 
         String banco = "jdbc:mysql://localhost:3306/projetosin143";
         String usuario = "projeto";
         String senha = "projeto";
         */
        // Checagem da existência dos arquivos necessários
        Arquivos arquivo = new Arquivos();
        try {
            arquivo.checarArquivos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível criar os arquivos necessários.", "Erro", JOptionPane.ERROR_MESSAGE);            
        }

        // Criação da tela principal
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        telaPrincipal.setResizable(false);
        telaPrincipal.setVisible(true);
    }

}
