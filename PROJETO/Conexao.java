import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {
    private static String log;  // Declare log no nível da classe
    private static String sen;  // Declare sen no nível da classe
    private static String status = "Não conectado...";

    public static void main(String arq[]) {
        Tela teste = new Tela();
        log = teste.login;  // Atribua o valor à variável de nível da classe
        sen = teste.senha;  // Atribua o valor à variável de nível da classe
    }

    public static Connection criarConexao()
            throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        Connection connection = null;
        String serverName = "regulus.cotuca.unicamp.br";
        String mydatabase = "ConsN";
        String username = log;  // Use a variável de nível da classe
        String password = sen;  // Use a variável de nível da classe

        connection = DriverManager.getConnection(serverName, username, password);

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            status = "Driver não encontrado";
        }

        // Teste a conexão com o banco de dados
        if (connection != null) {
            status = "Conectado com sucesso!";
        } else {
            status = "Não foi possível realizar a conexão";
        }

        return connection;
    }

    public static ResultSet executarSelect(Connection conn, String sql) throws SQLException {
        Statement query = conn.createStatement();
        return query.executeQuery(sql);
    }

    public static java.sql.PreparedStatement prepararSql(Connection conn, String sql) throws SQLException {
        return conn.prepareStatement(sql);
    }

    public static String statusConection() {
        return status;
    }
}
