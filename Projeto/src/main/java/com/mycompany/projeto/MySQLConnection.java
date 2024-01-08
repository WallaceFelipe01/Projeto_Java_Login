
package com.mycompany.projeto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


//Define a classe MySQLConnection para uso de conexões e seus atributos de config.
public class MySQLConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/Projeto";
    private static final String USER = "root";
    private static final String PASSWORD = "7355608Wa";
    private Connection connection;

//Configura a classe MySQLConnection e sua conexão
    public MySQLConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão com o banco de dados estabelecida!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
//Inicia a conexão com banco
    public Connection getConnection() {
        return connection;
    }

//Encerra a conexão com o banco
//Verifica se a conexão com o banco nao é nula e se já nao está fechada
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexão com o banco de dados fechada!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Ou trate a exceção de outra forma
        }
    }
   
}

