// Pacote Modelo
package server.modelo;

// Importação dos pacotes e bibliotecas necessárias
import java.io.Serializable;
import server.persistencia.Banco;

/*
 Descrição: Classe de autenticação do banco de dados
 */
public class Autenticacao implements Serializable {

    // Atributos encapsulados
    private String caminhoBanco;
    private String usuarioBanco;
    private String usuarioSenha;

    /*
     Descrição: Construtor padrão da classe Autenticação
     Parâmetros:
     Retorno:
     */
    public Autenticacao() {
    }

    /*
     Descrição: Construtor completo da classe Autenticação
     Parâmetros:
     caminhoBanco (String contendo o caminho do banco de dados)
     usuarioBanco (String contendo o usuário do banco de dados)
     senhaBanco (String contendo a senha do banco de dados)
     Retorno:
     */
    public Autenticacao(String caminhoBanco, String usuarioBanco, String senhaBanco) {
        this.setCaminhoBanco(caminhoBanco);
        this.setUsuarioBanco(usuarioBanco);
        this.setUsuarioSenha(senhaBanco);
    }

    /*
     Descrição: Método para verificação dos dados informados com o banco de dados
     Parâmetros:
     caminhoBanco (String contendo o caminho do banco de dados)
     usuarioBanco (String contendo o usuário do banco de dados)
     senhaBanco (String contendo a senha do banco de dados)
     Retorno:
     */
    public void testarAutenticacao(String caminho, String usuario, String senha) throws Exception {
        Autenticacao autenticacao = new Autenticacao(caminho, usuario, senha);
        try {
            // Testando conexão com o banco de dados
            Banco banco = new Banco();
            banco.verificarConexao(autenticacao);
        } catch (Exception e) {

        }
    }

    /*
     Descrição: Método get do caminho do banco de dados
     Parâmetros:
     Retorno:
     caminhoBanco (Caminho do banco de dados)
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
     usuarioBanco (Usuário do banco de dados)
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
     usuarioSenha (Senha do usuário do banco de dados)
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
