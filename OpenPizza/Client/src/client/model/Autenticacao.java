// Revert
package client.model;

import java.io.Serializable;
import java.sql.*;

/*
 Descrição: Classe de autenticação do usuário com o banco de dados
 */
public class Autenticacao implements Serializable {

    // Variável de armazenamento do caminho do banco de dados
    private String caminhoBanco;

    // Variável de armazenamento do usuário do banco de dados
    private String usuarioBanco;

    // Variável de armazenamento da senha do banco de dados
    private String usuarioSenha;

    /*
     Descrição: Construtor padrão do objeto autenticação
     Parâmetros: 
     Retorno:
     */
    public Autenticacao() {
    }

    /*
     Descrição: Construtor completo do objeto autenticação
     Parâmetros: 
     *           caminhoBanco (Necessário para acesso ao banco de dados)
     *           usuarioBanco (Necessário para login no banco de dados)
     *           senhaBanco (Necessário para autenticação no bando de dados)
     Retorno:
     */
    public Autenticacao(String caminhoBanco, String usuarioBanco, String senhaBanco) {
        this.setCaminhoBanco(caminhoBanco);
        this.setUsuarioBanco(usuarioBanco);
        this.setUsuarioSenha(senhaBanco);
    }

    /*
     Descrição: Método de teste de autenticação do banco de dados.
     Parâmetros: 
     *           caminho (Necessário para acesso ao banco de dados)
     *           usuario (Necessário para login no banco de dados)
     *           senha (Necessário para autenticação no banco de dados)
     Retorno:
     */
    public void testarAutenticacao(String caminho, String usuario, String senha) throws Exception {
        Connection conexao = null;
        // Tentativa de conexão com o banco de dados
        try {
            conexao = DriverManager.getConnection(caminho, usuario, senha);
        } finally {
            conexao.close();
        }
    }

    /*
     Descrição: Método get do caminho do banco de dados
     Parâmetros:
     Retorno:
     *           caminhoBanco (Caminho do banco de dados)
     */
    public String getCaminhoBanco() {
        return caminhoBanco;
    }

    /*
     Descrição: Método set do caminho do banco de dados
     Parâmetros: caminhoBanco (Caminho do banco de dados)
     Retorno:
     */
    public void setCaminhoBanco(String caminhoBanco) {
        this.caminhoBanco = caminhoBanco;
    }

    /*
     Descrição: Método get do usuário do banco de dados
     Parâmetros:
     Retorno:
     *           usuarioBanco (Usuário do banco de dados)
     */
    public String getUsuarioBanco() {
        return usuarioBanco;
    }

    /*
     Descrição: Método set do usuário do banco de dados
     Parâmetros: usuarioBanco (Usuário do banco de dados)
     Retorno:
     */
    public void setUsuarioBanco(String usuarioBanco) {
        this.usuarioBanco = usuarioBanco;
    }

    /*
     Descrição: Método get da senha do banco de dados
     Parâmetros:
     Retorno:
     *           usuarioSenha (Senha do usuário do banco de dados)
     */
    public String getUsuarioSenha() {
        return usuarioSenha;
    }

    /*
     Descrição: Método set da senha do banco de dados
     Parâmetros: senhaBanco (Senha do banco de dados)
     Retorno:
     */
    public void setUsuarioSenha(String usuarioSenha) {
        this.usuarioSenha = usuarioSenha;
    }
}
