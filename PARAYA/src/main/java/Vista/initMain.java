package Vista;

import Controlador.cUsuarios;
import Modelo.mUsuarios;
import java.util.List;

/**
 * @author laionel
 * @github https://github.com/leoneldc
 */
public class initMain {

    cUsuarios usuario = new cUsuarios();
    mUsuarios modeloUsuario = new mUsuarios();

    public static void main(String[] args) {
        initMain a = new initMain();
        a.actualizar();
    }

    public void buscar() {
        List<cUsuarios> usuariosList = modeloUsuario.obtenerTodosLosUsuarios();
        for (cUsuarios usuario : usuariosList) {
            System.out.println(usuario);
        }
    }

    public void consultar() {
        List<cUsuarios> usuariosList = modeloUsuario.obtenerUsuarioPorId(1);
        for (cUsuarios usuario : usuariosList) {
            System.out.println(usuario);
        }
    }

    public void guardar() {
        usuario.setId("1");
        usuario.setNombre("laionel");
        usuario.setApellido("Dominguez");
        usuario.setUsuario("laionel");
        usuario.setPassword("00000");
        usuario.setPreguntaSeguridad("jugador fav?");
        usuario.setRespuestaSeguridad("Dempelé");
        usuario.setCorreo("laionel@gmail.com");
        usuario.setEstado("activo");
        modeloUsuario.agregarUsuario(usuario);
    }

    public void actualizar() {
        List<cUsuarios> usuariosList = modeloUsuario.obtenerUsuarioPorId(1);
        cUsuarios usuarioActualizado = new cUsuarios();
        for (cUsuarios usuario : usuariosList) {
            usuarioActualizado = usuario;
        }
        usuarioActualizado.setPassword("123345");
        usuarioActualizado.setPreguntaSeguridad("jugador fav?");
        usuarioActualizado.setRespuestaSeguridad("meeeeessi");
        modeloUsuario.actualizarUsuario(usuarioActualizado);
    }

    public void eliminar() {
        modeloUsuario.eliminarUsuarioPorId(1);
    }
}
