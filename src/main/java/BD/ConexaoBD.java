package BD;

// import java.nio.file.Paths; // import para gerar o instalador(.exe)
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Uma classe utilitária para estabelecer uma conexão com o banco de dados.
 * 
 * Os parâmetros de conexão com o banco de dados (nome do banco de dados, URL,
 * nome de usuário, senha) são definidos aqui.
 * 
 * @author Raphael Vilete
 */

public class ConexaoBD {

    /**
     * Obtem uma conexão com o banco de dados.
     * 
     * @return Um objeto de conexão com o banco de dados.
     * @throws SQLException Se ocorrer um erro relacionado ao banco de dados.
     */

    public Connection getConexao() throws SQLException {

        Connection conexao = null;

        try {
            String dbNome = "BDsyslink";

            String dbUrl = "jdbc:h2:./src/main/resources/" + dbNome; // conexão na ide

            // String dbUrl = "jdbc:h2:./" + dbNome; // conexão para o .jar

            /*
             * Conexão para gerar o instalador(.exe)
             * 
             * String caminhoDocumentos = Paths.get(System.getProperty("user.home"),
             * "Documents").toString();
             * String caminhoBancoDados = Paths.get(caminhoDocumentos, "Syslink",
             * dbNome).toString();
             * String dbUrl = "jdbc:h2:" + caminhoBancoDados;
             */

            // Estabelece uma conexão com o banco de dados usando a URL, nome de usuário e
            // senha especificados
            conexao = DriverManager.getConnection(dbUrl, "root", "root");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conexao;
    }
}