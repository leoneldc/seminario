package Modelo;

import Controlador.cUsuarios;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
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

            Document doc = new Document("pk_id_usuario", Integer.valueOf(usuario.getId()))
                    .append("nombre_usuario", usuario.getNombre())
                    .append("apellido_usuario", usuario.getApellido())
                    .append("username_usuario", usuario.getUsuario())
                    .append("password_usuario", usuario.getPassword())
                    .append("preguntaSeguridad", usuario.getPreguntaSeguridad())
                    .append("respuestaSeguridad", usuario.getRespuestaSeguridad())
                    .append("correo_usuario", usuario.getCorreo())
                    .append("estado_usuario", usuario.getEstado());
            usuariosCollection.insertOne(doc);
        } catch (Exception ex) {
            System.out.println("error en guardar usuario");
        } finally {
            conexion.close();
        }
    }

    public void actualizarUsuario(cUsuarios usuario) {
        try {
            MongoDatabase database = conexion.getDatabase();
            MongoCollection<Document> usuariosCollection = database.getCollection(COLLECTION_NAME);

            Document query = new Document().append("pk_id_usuario", Integer.valueOf(usuario.getId()));
            Bson updates = Updates.combine(
                    Updates.set("nombre_usuario", usuario.getNombre()),
                    Updates.set("apellido_usuario", usuario.getApellido()),
                    Updates.set("username_usuario", usuario.getUsuario()),
                    Updates.set("password_usuario", usuario.getPassword()),
                    Updates.set("preguntaSeguridad", usuario.getPreguntaSeguridad()),
                    Updates.set("respuestaSeguridad", usuario.getRespuestaSeguridad()),
                    Updates.set("correo_usuario", usuario.getCorreo()),
                    Updates.set("estado_usuario", usuario.getEstado()));

            UpdateOptions options = new UpdateOptions().upsert(true);
            UpdateResult result = usuariosCollection.updateOne(query, updates, options);

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            conexion.close();
        }
    }

    public void eliminarUsuarioPorId(int id) {
        try {
            MongoDatabase database = conexion.getDatabase();
            MongoCollection<Document> usuariosCollection = database.getCollection(COLLECTION_NAME);
            
            Document query = new Document("pk_id_usuario", id);

            usuariosCollection.deleteOne(query);
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            conexion.close();
        }
    }

    public List<cUsuarios> obtenerUsuarioPorId(int id) {
        List<cUsuarios> usuariosList = new ArrayList<>();
        try {
            MongoDatabase database = conexion.getDatabase();
            MongoCollection<Document> usuariosCollection = database.getCollection(COLLECTION_NAME);

            Document query = new Document("pk_id_usuario", id);
            FindIterable<Document> results = usuariosCollection.find(query);

            JSONArray jsonArray;
            jsonArray = new JSONArray(results);

            for (int i = 0; i < jsonArray.length(); i++) {
                Document doc = Document.parse(jsonArray.getJSONObject(i).toString());
                cUsuarios usuario = new cUsuarios();

                usuario.setId(String.valueOf(doc.getInteger("pk_id_usuario")));
                usuario.setNombre(doc.getString("nombre_usuario"));
                usuario.setApellido(doc.getString("apellido_usuario"));
                usuario.setUsuario(doc.getString("username_usuario"));
                usuario.setPassword(doc.getString("password_usuario"));
                usuario.setCorreo(doc.getString("correo_usuario"));
                usuario.setEstado(doc.getString("estado_usuario"));
                usuariosList.add(usuario);
            }
            return usuariosList;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return usuariosList;
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
                usuario.setId(String.valueOf(doc.getInteger("pk_id_usuario")));
                usuario.setNombre(doc.getString("nombre_usuario"));
                usuario.setApellido(doc.getString("apellido_usuario"));
                usuario.setUsuario(doc.getString("username_usuario"));
                usuario.setPassword(doc.getString("password_usuario"));
                usuario.setCorreo(doc.getString("correo_usuario"));
                usuario.setEstado(doc.getString("estado_usuario"));
                usuariosList.add(usuario);
            }

            return usuariosList;
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            conexion.close();
        }
        return usuariosList;
    }
}
