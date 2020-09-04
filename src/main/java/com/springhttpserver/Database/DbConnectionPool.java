package com.springhttpserver.Database;

import com.springhttpserver.Exceptions.NoAvailableConnectionException;
import com.springhttpserver.Models.AppSettings.DatabaseSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class DbConnectionPool {

    private List<Connection> connectionPool = new ArrayList<>();
    private List<Connection> usedConnections = new ArrayList<>();

    @Autowired
    private DatabaseSettings databaseSettings;
    private String DatabaseConnectionUrl;

    public DbConnectionPool() {
        DatabaseConnectionUrl = "jdbc:mysql://" + databaseSettings.Endpoint + ":" +
                databaseSettings.Port + "/" + databaseSettings.DbName + "?user=" +
                databaseSettings.Username + "&password=" + databaseSettings.Password;
    }

//    public void SetDriver(DriverType driverType)
//    {
//        switch (driverType) {
//            case JDBC:
//                DatabaseConnectionUrl = "jdbc:mysql://" + databaseSettings.Endpoint + ":" +
//                        databaseSettings.Port + "/" + databaseSettings.DbName + "?user=" +
//                        databaseSettings.Username + "&password=" + databaseSettings.Password;
//                break;
//            default:
//                // Print warning
//                break;
//        }
//    }

    public DbConnectionPool CreateConnectionPool() throws SQLException {
        for (int i = 0; i < databaseSettings.MaxDBConnections; i++)
        {
            Connection con = DriverManager.getConnection(this.DatabaseConnectionUrl);
            this.connectionPool.add(con);
        }

        return this;
    }

    public Connection GetConnection() throws NoAvailableConnectionException {
        if (this.connectionPool.isEmpty())
        {
            throw new NoAvailableConnectionException("Maximum number of connections exceeded.");
        }

        Connection connection = connectionPool.remove(connectionPool.size() - 1);
        usedConnections.add(connection);
        return connection;
    }

    public boolean ReleaseConnection(Connection connection)
    {
        connectionPool.add(connection);
        return usedConnections.remove(connection);
    }
}
