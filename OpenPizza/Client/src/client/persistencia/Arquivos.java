package client.persistencia;

import client.modelo.Autenticacao;
import java.io.*;


/*
 Descrição: Classe manipulação de arquivos
 */
public class Arquivos implements Serializable {

    // Diretório onde será criado o arquivo de autenticação com o banco de dados
    public final String caminho = "../Arquivos";

    // Localização do arquivo de autenticação
    public final String documento = "../Arquivos/AutenticacaoCliente.txt";

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
     *           autenticar (Retorna os dados de autenticação armazenados)
     */
    public Autenticacao lerArquivo() throws FileNotFoundException, IOException {
        FileInputStream arquivo = new FileInputStream(documento);
        ObjectInputStream objeto = new ObjectInputStream(arquivo);
        Autenticacao autenticar;
        // Tentativa de recuperação de dados do arquivo
        try {
            autenticar = (Autenticacao) objeto.readObject();
            return autenticar;

        } catch (Exception e) {

        } finally {
            objeto.close();
            arquivo.close();
        }
        return null;
    }

    /*
     Descrição: Método de salvamento da autenticação no arquivo
     Parâmetros: 
     *           caminho (Caminho do banco de dados)
     *           usuario (Usuário do banco de dados)
     *           senha (Senha do banco de dados)
     Retorno:
     */
    public void salvarArquivo(String caminho, String usuario, String senha) throws FileNotFoundException, IOException {
        Autenticacao autenticar = new Autenticacao(caminho, usuario, senha);
        FileOutputStream arquivo = new FileOutputStream(documento);
        ObjectOutputStream objeto = new ObjectOutputStream(arquivo);

        // Tentativa de salvamento dos dados
        try {
            objeto.writeObject(autenticar);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            objeto.close();
            arquivo.close();
        }
    }
}
