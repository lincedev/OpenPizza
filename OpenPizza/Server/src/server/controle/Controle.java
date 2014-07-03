/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server.controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import net.proteanit.sql.DbUtils;
import server.modelo.Autenticacao;
import server.persistencia.Arquivos;
import server.persistencia.Banco;

/**
 *
 * @author Wellington
 */
public class Controle {
    
    //Telas CRUD
    private Autenticacao autenticacaoServer;
    private Banco banco = new Banco(autenticacaoServer);   
    private Statement statement;
    private JMenu menuExibir;
    private JMenu menuProdutos;
    private JMenu menuMesas;
    private JTable tabelaCRUDPizza;   
    private JTable tabelaCRUDLanches;    
    private JTable tabelaCRUDBebidas;    
    private JTable tabelaCRUDOutros;
    
    //Pizzas
    private Connection connection;
    private String descricaoPizza;    
    private JList jsTamanhoPizza;
    private int tamanhoPizza;
    private String tamanhoPizzaFinal;
    private int quantidadeFatiasPizza;
    private int quantidadeFatiasPizzaFinal;    
    private String ingredientesPizza;
    private String precoPizza;
    private float precoPizzaFinal;                 
    
    //Lanches
    private String descricaoLanche;
    private String ingredientesLanche;
    private String precoLanche;
    private float precoLancheFinal;
    
    
    
    public Controle(){};
    public Controle(Autenticacao autenticacaoServer, JMenu menuExibir, JMenu menuProdutos, JMenu menuMesas){
        this.setAutenticacaoServer(autenticacaoServer);
        this.setMenuExibir(menuExibir);
        this.setMenuProdutos(menuProdutos);
        this.setMenuMesas(menuMesas);
    }
    
    public Autenticacao getAutenticacaoServer() {
        return autenticacaoServer;
    }

    public void setAutenticacaoServer(Autenticacao autenticacaoServer) {
        this.autenticacaoServer = autenticacaoServer;
    }

    public JMenu getMenuExibir() {
        return menuExibir;
    }

    public void setMenuExibir(JMenu menuExibir) {
        this.menuExibir = menuExibir;
    }

    public JMenu getMenuProdutos() {
        return menuProdutos;
    }

    public void setMenuProdutos(JMenu menuProdutos) {
        this.menuProdutos = menuProdutos;
    }

    public JMenu getMenuMesas() {
        return menuMesas;
    }

    public void setMenuMesas(JMenu menuMesas) {
        this.menuMesas = menuMesas;
    }

    public JTable getTabelaCRUDPizza() {
        return tabelaCRUDPizza;
    }

    public void setTabelaCRUDPizza(JTable tabelaCRUDPizza) {
        this.tabelaCRUDPizza = tabelaCRUDPizza;
    }
    
    public JTable getTabelaCRUDLanches() {
        return tabelaCRUDLanches;
    }

    public void setTabelaCRUDLanches(JTable tabelaCRUDLanches) {
        this.tabelaCRUDLanches = tabelaCRUDLanches;
    }
    
    public JTable getTabelaCRUDBebidas() {
        return tabelaCRUDBebidas;
    }

    public void setTabelaCRUDBebidas(JTable tabelaCRUDBebidas) {
        this.tabelaCRUDBebidas = tabelaCRUDBebidas;
    }
    
    public JTable getTabelaCRUDOutros() {
        return tabelaCRUDOutros;
    }

    public void setTabelaCRUDOutros(JTable tabelaCRUDOutros) {
        this.tabelaCRUDOutros = tabelaCRUDOutros;
    }    
        
    public String getDescricaoPizza() {
        return descricaoPizza;
    }

    public void setDescricaoPizza(String descricaoPizza) {
        this.descricaoPizza = descricaoPizza;
    }

    public int getTamanhoPizza() {
        return tamanhoPizza;
    }

    public void setTamanhoPizza(int tamanhoPizza) {
        this.tamanhoPizza = tamanhoPizza;
    }

    public int getQuantidadeFatiasPizza() {
        return quantidadeFatiasPizza;
    }

    public void setQuantidadeFatiasPizza(int quantidadeFatiasPizza) {
        this.quantidadeFatiasPizza = quantidadeFatiasPizza;
    }
            
    public String getIngredientesPizza() {
        return ingredientesPizza;
    }

    public void setIngredientesPizza(String ingredientesPizza) {
        this.ingredientesPizza = ingredientesPizza;
    }

    public String getPrecoPizza() {
        return precoPizza;
    }

    public void setPrecoPizza(String precoPizza) {
        this.precoPizza = precoPizza;
    }

    public float getPrecoPizzaFinal() {
        return precoPizzaFinal;
    }

    public void setPrecoPizzaFinal(float precoPizzaFinal) {
        this.precoPizzaFinal = precoPizzaFinal;
    }                                    
    
    public JList getJsTamanhoPizza() {
        return jsTamanhoPizza;
    }

    public void setJsTamanhoPizza(JList jsTamanhoPizza) {
        this.jsTamanhoPizza = jsTamanhoPizza;
    }

    public String getDescricaoLanche() {
        return descricaoLanche;
    }

    public void setDescricaoLanche(String descricaoLanche) {
        this.descricaoLanche = descricaoLanche;
    }

    public String getIngredientesLanche() {
        return ingredientesLanche;
    }

    public void setIngredientesLanche(String ingredientesLanche) {
        this.ingredientesLanche = ingredientesLanche;
    }

    public String getPrecoLanche() {
        return precoLanche;
    }

    public void setPrecoLanche(String precoLanche) {
        this.precoLanche = precoLanche;
    }

    public float getPrecoLancheFinal() {
        return precoLancheFinal;
    }

    public void setPrecoLancheFinal(float precoLancheFinal) {
        this.precoLancheFinal = precoLancheFinal;
    }
    
    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }
    
    /*
     Descrição: Método para tentativa de autenticação dos dados do banco de dados.
     Parâmetros:
     Retorno:
     */
    public void verificarAutenticacao() {
        Arquivos arquivo = new Arquivos();
        try {
            autenticacaoServer = arquivo.lerArquivo();
            try {
                // Se a conexão foi efetuada, o botão de autenticação é desabilitado e o botão para abrir pedido é habilitado.
                Connection conexao = DriverManager.getConnection(autenticacaoServer.getCaminhoBanco(), autenticacaoServer.getUsuarioBanco(), autenticacaoServer.getUsuarioSenha());
                conexao.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Não foi possível autenticar a conexão.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível estabelecer conexão automática com o banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            this.menuExibir.setEnabled(false);
            this.menuProdutos.setEnabled(false);
            this.menuMesas.setEnabled(false);
        }
    }

    
        /*
     Descrição: Método para exibição das pizzas cadastrados
     Parâmetros:
     *           autenticacao (Necessário para acesso/consulta no banco de dados)
     Retorno:
     Data Última Alteração: 07/06/2014
     */
    public void exibirPizzasCadastradas(Autenticacao autenticacaoServer, JTable tabelaCRUDPizza) {
        
        this.setAutenticacaoServer(autenticacaoServer);
        this.setTabelaCRUDPizza(tabelaCRUDPizza);        
        
        this.verificarAutenticacao();
        try {
            String query = null;
            //int indiceTabela = this.tabelaCardapio.getSelectedIndex();
            JTable tabelaPizzas = null;
            
            query = "SELECT p.descricao, pp.preco, pp.tamanho , pp.fatias FROM Produto AS p JOIN Pizza AS pp ON p.codigo = pp.codProduto";
            
            // Recuperação dos produtos cadastrados de acordo com a categoria selecionada
            Connection con = DriverManager.getConnection(this.getAutenticacaoServer().getCaminhoBanco(), this.getAutenticacaoServer().getUsuarioBanco(), this.getAutenticacaoServer().getUsuarioSenha());
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            tabelaPizzas = this.tabelaCRUDPizza;
            
            // Formatação do modelo da tabela de exibição
            tabelaPizzas.setModel(DbUtils.resultSetToTableModel(rs));
            tabelaPizzas.setRowSelectionAllowed(true);

            // Exibição centralizada dos registros
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);

            // Formatação das colunas da tabela de exibição
            tabelaPizzas.getColumnModel().getColumn(0).setHeaderValue("Descrição");
            tabelaPizzas.getColumnModel().getColumn(1).setHeaderValue("Preço");
            tabelaPizzas.getColumnModel().getColumn(2).setHeaderValue("Tamanho");
            tabelaPizzas.getColumnModel().getColumn(3).setHeaderValue("Fatias");
            //tabelaPizzas.getColumnModel().getColumn(4).setHeaderValue("Ingredientes");

            // Formatação das demais tabelas de produtos (Lanches, Bebidas, Outros)
            //if (indiceTabela != 0) {
            //    tabela.getColumnModel().getColumn(1).setHeaderValue("Preço");
            //    tabela.getColumnModel().getColumn(1).setMaxWidth(70);
            //    tabela.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
            //}

            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível exibir as pizzas cadastrados.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }       
    
        /*
     Descrição: Método para exibição dos Lanches cadastrados
     Parâmetros:
     *           autenticacao (Necessário para acesso/consulta no banco de dados)
     Retorno:
     Data Última Alteração: 07/06/2014
     */
    public void exibirLanchesCadastrados(Autenticacao autenticacaoServer, JTable tabelaCRUDLanches) {
        
        this.setAutenticacaoServer(autenticacaoServer);
        this.setTabelaCRUDLanches(tabelaCRUDLanches);        
        
        this.verificarAutenticacao();
        try {
            String query = null;
            //int indiceTabela = this.tabelaCardapio.getSelectedIndex();
            JTable tabelaLanches = null;
            
            query = "SELECT p.descricao, l.preco FROM Produto AS p JOIN Lanche AS l ON p.codigo = l.codProduto";
            
            // Recuperação dos produtos cadastrados de acordo com a categoria selecionada
            Connection con = DriverManager.getConnection(this.getAutenticacaoServer().getCaminhoBanco(), this.getAutenticacaoServer().getUsuarioBanco(), this.getAutenticacaoServer().getUsuarioSenha());
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            tabelaLanches = this.tabelaCRUDLanches;
            
            // Formatação do modelo da tabela de exibição
            tabelaLanches.setModel(DbUtils.resultSetToTableModel(rs));
            tabelaLanches.setRowSelectionAllowed(true);

            // Exibição centralizada dos registros
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);

            // Formatação das colunas da tabela de exibição
            tabelaLanches.getColumnModel().getColumn(0).setHeaderValue("Descrição");
            tabelaLanches.getColumnModel().getColumn(1).setHeaderValue("Preço");
            //tabelaOutros.getColumnModel().getColumn(2).setHeaderValue("Tamanho");
            //tabelaOutros.getColumnModel().getColumn(3).setHeaderValue("Fatias");
            //tabelaPizzas.getColumnModel().getColumn(4).setHeaderValue("Ingredientes");

            // Formatação das demais tabelas de produtos (Lanches, Bebidas, Outros)
            //if (indiceTabela != 0) {
            //    tabela.getColumnModel().getColumn(1).setHeaderValue("Preço");
            //    tabela.getColumnModel().getColumn(1).setMaxWidth(70);
            //    tabela.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
            //}

            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível exibir as pizzas cadastrados.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    /*
     Descrição: Método para exibição das Bebidas cadastradas
     Parâmetros:
     *           autenticacao (Necessário para acesso/consulta no banco de dados)
     Retorno:
     Data Última Alteração: 07/06/2014
     */
    public void exibirBebidasCadastrados(Autenticacao autenticacaoServer, JTable tabelaCRUDBebidas) {
        
        this.setAutenticacaoServer(autenticacaoServer);
        this.setTabelaCRUDBebidas(tabelaCRUDBebidas);
        
        this.verificarAutenticacao();
        try {
            String query = null;
            //int indiceTabela = this.tabelaCardapio.getSelectedIndex();
            JTable tabelaBebidas = null;

            //query = "SELECT p.descricao, b.preco FROM Produto AS p JOIN Bebidas AS b ON p.codigo = b.codProduto";
            query = "SELECT p.codigo, p.descricao, b.preco FROM Produto AS p JOIN Bebidas AS b ON p.codigo = b.codProduto";

            // Recuperação dos produtos cadastrados de acordo com a categoria selecionada
            Connection con = DriverManager.getConnection(this.getAutenticacaoServer().getCaminhoBanco(), this.getAutenticacaoServer().getUsuarioBanco(), this.getAutenticacaoServer().getUsuarioSenha());
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            tabelaBebidas = this.tabelaCRUDBebidas;

            // Formatação do modelo da tabela de exibição
            tabelaBebidas.setModel(DbUtils.resultSetToTableModel(rs));
            tabelaBebidas.setRowSelectionAllowed(true);

            // Exibição centralizada dos registros
            DefaultTableCellRenderer centralizarTexto = new DefaultTableCellRenderer();
            centralizarTexto.setHorizontalAlignment(JLabel.CENTER);

            tabelaBebidas.getColumnModel().getColumn(0).setMaxWidth(0);
            tabelaBebidas.getColumnModel().getColumn(0).setMinWidth(0);
            tabelaBebidas.getColumnModel().getColumn(0).setPreferredWidth(0);
            
            // Formatação das colunas da tabela de exibição
            tabelaBebidas.getColumnModel().getColumn(1).setHeaderValue("Descrição");

            tabelaBebidas.getColumnModel().getColumn(2).setHeaderValue("Preço");
            tabelaBebidas.getColumnModel().getColumn(2).setCellRenderer(centralizarTexto);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível exibir as pizzas cadastrados.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    /*
     Descrição: Método para exibição de Outros cadastrados
     Parâmetros:
     *           autenticacao (Necessário para acesso/consulta no banco de dados)
     Retorno:      
     Data Última Alteração: 07/06/2014 
    */
    public void exibirOutrosCadastrados(Autenticacao autenticacaoServer, JTable tabelaCRUDOutros) {
        
        this.setAutenticacaoServer(autenticacaoServer);
        this.setTabelaCRUDOutros(tabelaCRUDOutros);
        
        this.verificarAutenticacao();
        try {
            String query = null;
            //int indiceTabela = this.tabelaCardapio.getSelectedIndex();
            JTable tabelaOutros = null;
            
            query = "SELECT p.descricao, o.preco FROM Produto AS p JOIN Outros AS o ON p.codigo = o.codProduto";
            
            // Recuperação dos produtos cadastrados de acordo com a categoria selecionada
            Connection con = DriverManager.getConnection(this.getAutenticacaoServer().getCaminhoBanco(), this.getAutenticacaoServer().getUsuarioBanco(), this.getAutenticacaoServer().getUsuarioSenha());
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            tabelaOutros = this.tabelaCRUDOutros;
            
            // Formatação do modelo da tabela de exibição
            tabelaOutros.setModel(DbUtils.resultSetToTableModel(rs));
            tabelaOutros.setRowSelectionAllowed(true);

            // Exibição centralizada dos registros
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);

            // Formatação das colunas da tabela de exibição
            tabelaOutros.getColumnModel().getColumn(0).setHeaderValue("Descrição");
            tabelaOutros.getColumnModel().getColumn(1).setHeaderValue("Preço");
            //tabelaOutros.getColumnModel().getColumn(2).setHeaderValue("Tamanho");
            //tabelaOutros.getColumnModel().getColumn(3).setHeaderValue("Fatias");
            //tabelaPizzas.getColumnModel().getColumn(4).setHeaderValue("Ingredientes");

            // Formatação das demais tabelas de produtos (Lanches, Bebidas, Outros)
            //if (indiceTabela != 0) {
            //    tabela.getColumnModel().getColumn(1).setHeaderValue("Preço");
            //    tabela.getColumnModel().getColumn(1).setMaxWidth(70);
            //    tabela.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
            //}

            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível exibir as pizzas cadastrados.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }   
    
    public void botaoCadastrarPizzas(JTextField textDescricaoPizza, JList jsListaTamanhoPizza, JComboBox comboBoxQuantidadeFatiasPizza, JTextField textIngredientesPizza, JTextField textPrecoPizza){
        
        this.verificarAutenticacao();
        
        this.setDescricaoPizza(textDescricaoPizza.getText());
        this.setTamanhoPizza(jsListaTamanhoPizza.getSelectedIndex());        
        this.setQuantidadeFatiasPizza(comboBoxQuantidadeFatiasPizza.getSelectedIndex());
        this.setIngredientesPizza(textIngredientesPizza.getText());
        this.setPrecoPizza(textPrecoPizza.getText());
                                  
        JOptionPane.showMessageDialog(null, "Primeiro");
        JOptionPane.showMessageDialog(null, this.getDescricaoPizza());
        JOptionPane.showMessageDialog(null, this.getTamanhoPizza());
        JOptionPane.showMessageDialog(null, this.getQuantidadeFatiasPizza());
        JOptionPane.showMessageDialog(null, this.getIngredientesPizza());
        JOptionPane.showMessageDialog(null, this.getPrecoPizza());
        
        
        
        
        
        if(this.getDescricaoPizza().equals("")){
            JOptionPane.showMessageDialog(null, "Por favor preencha o campo 'Descrição'");
        } else if(this.getIngredientesPizza().equals("")){
                    JOptionPane.showMessageDialog(null, "Preencha o campo 'Ingredientes'");
                } else if(this.getPrecoPizza().equals("")){
                            JOptionPane.showMessageDialog(null, "Por favor, preencha o campo 'Preço'");                                                                                                            
                        } else {
                            this.setPrecoPizzaFinal(Float.parseFloat(textPrecoPizza.getText()));
                            if(this.getPrecoPizzaFinal() <= 0.00){
                                JOptionPane.showMessageDialog(null, "Por favor, preencha com valores Positivos o campo 'Preço'");
                            }
                    }

        switch(this.getTamanhoPizza()){            
            case -1:
                this.tamanhoPizzaFinal = "Mini";
                break;
            case 0:
                this.tamanhoPizzaFinal = "Pequena";
                break;
            case 1:
                this.tamanhoPizzaFinal = "Média";                
                break;
            case 2:
                this.tamanhoPizzaFinal = "Grande";
                break;
        }
        
        switch(this.getQuantidadeFatiasPizza()){
            case 0:
                this.quantidadeFatiasPizzaFinal = 4;
                break;
            case 1:
                this.quantidadeFatiasPizzaFinal = 6;
                break;                
            case 2:
                this.quantidadeFatiasPizzaFinal = 8;
                break;
            case 3:
                this.quantidadeFatiasPizzaFinal = 10;
                break;
        }
        
        JOptionPane.showMessageDialog(null, "Segundo");
        JOptionPane.showMessageDialog(null, this.getDescricaoPizza());
        JOptionPane.showMessageDialog(null, this.getTamanhoPizza());
        JOptionPane.showMessageDialog(null, this.getQuantidadeFatiasPizza());
        JOptionPane.showMessageDialog(null, this.getIngredientesPizza());
        JOptionPane.showMessageDialog(null, this.getPrecoPizza());
        JOptionPane.showMessageDialog(null, this.tamanhoPizzaFinal);
        JOptionPane.showMessageDialog(null, this.quantidadeFatiasPizzaFinal);
                
        
        if((!(this.getDescricaoPizza().equals(""))) && (!(this.tamanhoPizzaFinal.equals(""))) && 
           (!(this.getIngredientesPizza().equals(""))) && (this.quantidadeFatiasPizzaFinal != 0) &&
           (!(this.getPrecoPizza().equals(""))) && (!(this.getPrecoPizzaFinal() <= 0.00))){
                                                
            try{                
              boolean retorno = banco.inserirPizzaSemImagem(this.getAutenticacaoServer(), this.getDescricaoPizza(), this.tamanhoPizzaFinal, this.quantidadeFatiasPizzaFinal, this.getIngredientesPizza(), this.getPrecoPizzaFinal());
                if(retorno == true){
                    JOptionPane.showMessageDialog(null, "Pizza cadastrada com sucesso!!!");
                }else{
                    JOptionPane.showMessageDialog(null, "Não foi possível cadastrar a Pizza");
                }                                    
            } catch(Exception e){
                JOptionPane.showMessageDialog(null, "Não foi possível cadastrar a Pizza");
            }            
        }         
        //this.setEnabled(false);
        //this.setVisible(false);
        //this.telaCrudPizzas.setEnabled(true);
        //this.telaCrudPizzas.setVisible(true);        
    }
    
    public void botaoCadastrarLanches(JTextField textDescricaoLanche, JTextField textPrecoLanche, JTextField textIngredientesLanche){
        
        this.verificarAutenticacao();        
        this.banco.abrirConexao(autenticacaoServer);
        this.setDescricaoLanche(textDescricaoLanche.getText());
        this.setPrecoLanche(textPrecoLanche.getText());
        this.setIngredientesLanche(textIngredientesLanche.getText());
               
        if(this.getDescricaoLanche().equals("")){
            JOptionPane.showMessageDialog(null, "Por favor preencha o campo 'Descrição'");
        } else if(this.getPrecoLanche().equals("")){
                JOptionPane.showMessageDialog(null, "Preencha o campo 'Preço'");
                } else if(this.getIngredientesLanche().equals("")){
                    JOptionPane.showMessageDialog(null, "Preencha o campo 'Ingredientes'");
                } else {
                    this.setPrecoLancheFinal(Float.parseFloat(textPrecoLanche.getText()));
                    if(this.getPrecoLancheFinal() <= 0.00){
                        JOptionPane.showMessageDialog(null, "Por favor, preencha com valores Positivos o campo 'Preço'");
                    }
                }
        
        JOptionPane.showMessageDialog(null, this.getDescricaoLanche());
        JOptionPane.showMessageDialog(null, this.getPrecoLanche());
        JOptionPane.showMessageDialog(null, this.getPrecoLancheFinal());
        JOptionPane.showMessageDialog(null, this.getIngredientesLanche());
        if((!(this.getDescricaoLanche().equals(""))) && (!(this.getPrecoLanche().equals(""))) && (!(this.getIngredientesLanche().equals(""))) && (!(this.getPrecoLancheFinal() <= 0.00))){
            try{               
                JOptionPane.showMessageDialog(null, this.getAutenticacaoServer().getUsuarioBanco());
                JOptionPane.showMessageDialog(null, this.getAutenticacaoServer().getCaminhoBanco());
                JOptionPane.showMessageDialog(null, this.getAutenticacaoServer().getUsuarioSenha());
                boolean retorno = banco.inserirLanche(this.getAutenticacaoServer(), this.getDescricaoLanche(), this.getPrecoLancheFinal(), this.getIngredientesLanche());
                
                JOptionPane.showMessageDialog(null, "Valor de Retorno " + retorno);
                
                if(retorno == true){
                    JOptionPane.showMessageDialog(null, "Lanche cadastrado com sucesso!!!");
                }else{
                    JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o Lanche");
                }                                    
            } catch(Exception e){
                JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o Lanche");
            }
        }                       
        //this.setEnabled(false);
        //this.setVisible(false);
        //this.telaCrudLanches.setEnabled(true);
        //this.telaCrudLanches.setVisible(true);        
    }
    
}
