package Administracion.Modelo;

import Administracion.Controlador.cUsuarios;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONArray;

/**
 * @author laionel
 * @github https://github.com/leoneldc
 */
public class mUsuarios {

    private final String COLLECTION_NAME = "usuarios";
    private MongoCollection<Document> usuariosCollection;
    Conexion conexion = new Conexion();

    public void agregarUsuario(cUsuarios usuario) {
        try {
            MongoDatabase database = conexion.getDatabase();
            MongoCollection<Document> usuariosCollection = database.getCollection(COLLECTION_NAME);

            Document doc = new Document("id", Integer.valueOf(usuario.getId()))
                    .append("nombre", usuario.getNombre())
                    .append("usuario", usuario.getUsuario())
                    .append("password", usuario.getPassword())
                    .append("preguntaSeguridad", usuario.getPreguntaSeguridad())
                    .append("respuestaSeguridad", usuario.getRespuestaSeguridad())
                    .append("correo", usuario.getCorreo())
                    .append("estado", usuario.getEstado());
            usuariosCollection.insertOne(doc);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void actualizarUsuario(cUsuarios usuario) {
        try {
            MongoDatabase database = conexion.getDatabase();
            MongoCollection<Document> usuariosCollection = database.getCollection(COLLECTION_NAME);

            Document query = new Document().append("id", Integer.valueOf(usuario.getId()));
            Bson updates = Updates.combine(
                    Updates.set("nombre", usuario.getNombre()),
                    Updates.set("usuario", usuario.getUsuario()),
                    Updates.set("password", usuario.getPassword()),
                    Updates.set("preguntaSeguridad", usuario.getPreguntaSeguridad()),
                    Updates.set("respuestaSeguridad", usuario.getRespuestaSeguridad()),
                    Updates.set("correo", usuario.getCorreo()),
                    Updates.set("estado", usuario.getEstado()));

            UpdateOptions options = new UpdateOptions().upsert(true);
            UpdateResult result = usuariosCollection.updateOne(query, updates, options);

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void eliminarUsuarioPorId(int id) {
        try {
            MongoDatabase database = conexion.getDatabase(); // Supongo que "conexion" es tu objeto de conexión a la base de datos.
            MongoCollection<Document> usuariosCollection = database.getCollection(COLLECTION_NAME);
            Document query = new Document("id", id);
            usuariosCollection.deleteOne(query);
        } catch (Exception ex) {
            System.out.println("Error al eliminar el registro: " + ex.getMessage());
        }
    }

    public cUsuarios obtenerUsuarioPorId(int id) {
        cUsuarios usuario = new cUsuarios();
        try {
            MongoDatabase database = conexion.getDatabase();
            MongoCollection<Document> usuariosCollection = database.getCollection(COLLECTION_NAME);
            Document query = new Document("id", id);
            FindIterable<Document> results = usuariosCollection.find(query);
            JSONArray jsonArray;
            jsonArray = new JSONArray(results);
            for (int i = 0; i < jsonArray.length(); i++) {
                Document doc = Document.parse(jsonArray.getJSONObject(i).toString());
                usuario.setId(String.valueOf(doc.getInteger("id")));
                usuario.setNombre(doc.getString("nombre"));
                usuario.setUsuario(doc.getString("usuario"));
                usuario.setPassword(doc.getString("password"));
                usuario.setPreguntaSeguridad(doc.getString("preguntaSeguridad"));
                usuario.setRespuestaSeguridad(doc.getString("respuestaSeguridad"));
                usuario.setCorreo(doc.getString("correo"));
                usuario.setEstado(doc.getString("estado"));
            }
            return usuario;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return usuario;
    }

    public List<cUsuarios> obtenerTodosLosUsuarios() {
        List<cUsuarios> usuariosList = new ArrayList<>();
        try {
            MongoDatabase database = conexion.getDatabase();
            MongoCollection<Document> usuariosCollection = database.getCollection(COLLECTION_NAME);
            FindIterable<Document> documents = usuariosCollection.find();
            JSONArray jsonArray;
            jsonArray = new JSONArray(documents);
            for (int i = 0; i < jsonArray.length(); i++) {
                Document doc = Document.parse(jsonArray.getJSONObject(i).toString());
                cUsuarios usuario = new cUsuarios();
                usuario.setId(String.valueOf(doc.getInteger("id")));
                usuario.setNombre(doc.getString("nombre"));
                usuario.setUsuario(doc.getString("usuario"));
                usuario.setPassword(doc.getString("password"));
                usuario.setPreguntaSeguridad(doc.getString("preguntaSeguridad"));
                usuario.setRespuestaSeguridad(doc.getString("respuestaSeguridad"));
                usuario.setCorreo(doc.getString("correo"));
                usuario.setEstado(doc.getString("estado"));
                usuariosList.add(usuario);
            }
            return usuariosList;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return usuariosList;
    }

    public int obtenerMaxId() {
        try {
            MongoDatabase database = conexion.getDatabase();
            MongoCollection<Document> usuariosCollection = database.getCollection(COLLECTION_NAME);

            AggregateIterable<Document> result = usuariosCollection.aggregate(
                    Arrays.asList(
                            Aggregates.group(null, Accumulators.max("maxId", "$id")),
                            Aggregates.project(Projections.computed("maxId",
                                    new Document("$ifNull", Arrays.asList(
                                            new Document("$toInt", "$maxId"), 0))))
                    )
            );

            Document maxIdDoc = result.first();
            if (maxIdDoc != null) {
                Object maxId = maxIdDoc.get("maxId");
                if (maxId != null) {
                    return ((Number) maxId).intValue() + 1;
                }
            }
        } catch (Exception ex) {
            System.out.println("Error al obtener el máximo ID: " + ex.getMessage());
        }

        return 1;
    }
}
