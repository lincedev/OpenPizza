package client.view;

import client.persistencia.Arquivos;
import java.io.*;
import javax.swing.*;

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

        // Criação da janela principal e habilitação da visualização
        TelaPrincipal janelaPrincipal = new TelaPrincipal();
        janelaPrincipal.setResizable(false);
        janelaPrincipal.setVisible(true);
    }
}
