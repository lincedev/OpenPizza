
package server.modelo;

import java.io.*;
import java.sql.*;

/*
 Descrição: Classe de autenticação do banco de dados
 */
public class Autenticacao implements Serializable {

    private String caminhoBanco;
    private String usuarioBanco;
    private String usuarioSenha;

    public Autenticacao() {
    }

    public Autenticacao(String caminhoBanco, String usuarioBanco, String senhaBanco) {
        this.setCaminhoBanco(caminhoBanco);
        this.setUsuarioBanco(usuarioBanco);
        this.setUsuarioSenha(senhaBanco);
    }

    public void testarAutenticacao(String caminho, String usuario, String senha) throws Exception {
        Connection conexao = null;
        try {
            // Testando conexão com o banco de dados
            conexao = DriverManager.getConnection(caminho, usuario, senha);
        } finally {
            conexao.close();
        }
    }

    public String getCaminhoBanco() {
        return caminhoBanco;
    }

    public void setCaminhoBanco(String caminhoBanco) {
        this.caminhoBanco = caminhoBanco;
    }

    public String getUsuarioBanco() {
        return usuarioBanco;
    }

    public void setUsuarioBanco(String usuarioBanco) {
        this.usuarioBanco = usuarioBanco;
    }

    public String getUsuarioSenha() {
        return usuarioSenha;
    }

    public void setUsuarioSenha(String usuarioSenha) {
        this.usuarioSenha = usuarioSenha;
    }
}
