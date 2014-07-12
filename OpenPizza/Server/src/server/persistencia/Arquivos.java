// Pacote Persistência
package server.persistencia;

// Importação dos pacotes e bibliotecas necessárias
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.io.Serializable;
import server.modelo.Autenticacao;

/*
 Descrição: Classe de manipulação de arquivos
 */
public class Arquivos implements Serializable {

    // Diretório onde será criado o arquivo de autenticação com o banco de dados
    public final String caminho = "./Arquivos";

    // Localização do arquivo de autenticação
    public final String documento = "./Arquivos/AutenticacaoServidor.txt";

    /*
     Descrição: Método de verificação da existência dos arquivos necessários
     Parâmetros: 
     Retorno:
     */
    public void checarArquivos() throws IOException {

        // Tentativa de leitura dos arquivos
        try {
            Reader arquivo = new FileReader(documento);
            arquivo.close();
        } // Criação dos arquivos, caso não sejam encontrados
        catch (FileNotFoundException ex) {
            criarArquivos();
        }
    }

    /*
     Descrição: Método de criação dos arquivos necessários
     Parâmetros: 
     Retorno:
     */
    public void criarArquivos() {
        File diretorio = new File(caminho);
        diretorio.mkdir();
        File arquivo = new File(diretorio, documento);
        FileWriter criarArquivo;
        try {
            criarArquivo = new FileWriter(documento);
            criarArquivo.close();
        } catch (Exception e) {
        }
    }

    /*
     Descrição: Método de leitura do arquivo de autenticação
     Parâmetros: 
     Retorno:
     autenticar (Retorna os dados de autenticação armazenados)
     */
    public void recuperarDadosDeAutenticacao(Autenticacao autenticacao) throws FileNotFoundException, IOException {
        FileInputStream arquivo = new FileInputStream(documento);
        ObjectInputStream objeto = new ObjectInputStream(arquivo);
        Autenticacao autenticar;
        // Tentativa de recuperação de dados do arquivo
        try {
            autenticar = (Autenticacao) objeto.readObject();
            autenticacao.setCaminhoBanco(autenticar.getCaminhoBanco());
            autenticacao.setUsuarioBanco(autenticar.getUsuarioBanco());
            autenticacao.setUsuarioSenha(autenticar.getUsuarioSenha());
            objeto.close();
            arquivo.close();

        } catch (Exception e) {
            objeto.close();
            arquivo.close();
        }
    }
    
    /*
     Descrição: Método de salvamento da autenticação no arquivo
     Parâmetros: 
     caminho (Caminho do banco de dados)
     usuario (Usuário do banco de dados)
     senha (Senha do banco de dados)
     Retorno:
     */
    public boolean salvarAutenticacao(String caminho, String usuario, String senha) throws FileNotFoundException, IOException {
        Autenticacao autenticar = new Autenticacao(caminho, usuario, senha);
        FileOutputStream arquivo = new FileOutputStream(documento);
        ObjectOutputStream objeto = new ObjectOutputStream(arquivo);

        // Tentativa de salvamento dos dados
        try {
            objeto.writeObject(autenticar);
            objeto.close();
            arquivo.close();
            return true;
        } catch (Exception e) {
            objeto.close();
            arquivo.close();
            return false;
        }
    }
}
