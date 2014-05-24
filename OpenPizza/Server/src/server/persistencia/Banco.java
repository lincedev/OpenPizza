
package server.persistencia;

import javax.swing.*;
import java.sql.*;
import server.modelo.Autenticacao;
import server.modelo.Pizza;
import java.io.*;

/*
 Descrição: Classe manipulação do banco de dados
 */
public class Banco implements Serializable {
    
    /*
    Descrição: Método para cadastro de pizzas no banco de dados
    Parâmetros: autenticacao (Necessário para acesso ao banco de dados)
                novaPizza (Nova pizza que será cadastrada)
    Retorno:
    */
    public void inserirPizza(Autenticacao autenticacao, Pizza novaPizza){
        
        // Tentativa de acesso ao banco de dados
        try{
            // Recuperação dos dados contidos na nova pizza
            String descricao = novaPizza.getDescricao();
            float preco = novaPizza.getPreco();
            String tamanho = novaPizza.getTamanho();
            int qtdFatias = novaPizza.getFatias();
            String ingredientes = novaPizza.getIngredientesPizza();
            String imagem = novaPizza.getImagemPizza();
            
            // Inserção do código e descrição da pizza
            Connection conexao = DriverManager.getConnection(autenticacao.getCaminhoBanco(), autenticacao.getUsuarioBanco(), autenticacao.getUsuarioSenha());
            String inserirProduto = "INSERT INTO Produto(descricao) VALUES('" + descricao + "')";
            Statement operacao = conexao.createStatement();
            int resultadoInserirProduto = operacao.executeUpdate(inserirProduto);
            
            // Recuperação do último código de produto
            String selecionarUltimoCodigoProduto = "SELECT codigo FROM Produto ORDER BY codigo DESC LIMIT 1";
            operacao = conexao.createStatement();
            ResultSet resultadoUltimoCodigoProduto = operacao.executeQuery(selecionarUltimoCodigoProduto);

            // Inserção das demais informações da pizza
            while(resultadoUltimoCodigoProduto.next()){
                int codigoProduto = resultadoUltimoCodigoProduto.getInt("codigo");
                String inserirPizza = "INSERT INTO Pizza(codProduto, preco, tamanho, fatias, ingredientesPizza, imagem) VALUES(" + codigoProduto + "," + preco + "," + tamanho + "," + qtdFatias + "," + ingredientes + "," + imagem + ")";
                operacao = conexao.createStatement();
                int resultadoInserirPizza = operacao.executeUpdate(inserirPizza);
            }
            conexao.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar acessar o banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
