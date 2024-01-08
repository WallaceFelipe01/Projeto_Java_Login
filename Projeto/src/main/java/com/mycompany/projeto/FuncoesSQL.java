
package com.mycompany.projeto;

import java.sql.*;

public class FuncoesSQL
{
    //Cria a Connection e a CLASSE MySQLConnection para uso da conexao SQL
    private Connection connection;
    private MySQLConnection conexao;
    
    //Linhas contadas nos metodos Execute()
    int rowCount = 0;
    
     public void setRowCount(int x) {
        rowCount = x;
    }
    
    //Configura a classe FuncoesSQL instanciando a classe MySQLConnection e inicia a connection utilizando getConnection
    public FuncoesSQL()
    {
        conexao = new MySQLConnection();
        this.connection = conexao.getConnection();
    }
    
    //função para executar tarefas de update no banco de dados (insert, delete, update...)
    public void executeUpdate(String comando)
    {
        try(PreparedStatement statement = connection.prepareStatement(comando))
        {
            statement.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (conexao != null)
            {
                conexao.closeConnection();
                
            }
        }
    }
    
    //função para executar tarefas no banco de dados (select, etc..)
    public void execute(String comando)
    {
        try(PreparedStatement statement = connection.prepareStatement(comando))
        {
            statement.execute();
            ResultSet resultSet = statement.executeQuery();
            
            
            while (resultSet.next())
            {
                rowCount++;
            }
            System.out.println("Quantidade de linhas encontradas: " + rowCount);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
    }
}
