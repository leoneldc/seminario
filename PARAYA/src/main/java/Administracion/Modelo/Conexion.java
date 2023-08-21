package Administracion.Modelo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

/**
 * @author laionel
 * @github https://github.com/leoneldc
 */
public class Conexion {

    private static final String DB_HOST = "localhost";
    private static final int DB_PORT = 27017;
    private static final String DB_NAME = "PARAYA";

    private MongoClient mongoClient;
    private MongoDatabase database;

    public Conexion() {
        this.mongoClient = MongoClients.create("mongodb://" + DB_HOST + ":" + DB_PORT);
        this.database = mongoClient.getDatabase(DB_NAME);
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public void close() {
        mongoClient.close();
    }
}
