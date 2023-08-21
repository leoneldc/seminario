package Administracion.Controlador;

import java.io.File;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * @author laionel
 * @github https://github.com/leoneldc
 */
public class CodigoLimpio {

    Date fecha = new Date();

    String currentDir = System.getProperty("user.dir");
    String assetPathReady = currentDir + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "Assets" + File.separator + "listo.png";
    public Icon iconoReady = new ImageIcon(assetPathReady);
    String assetPathAsk = currentDir + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "Assets" + File.separator + "pregunta.png";
    public Icon iconoAsk = new ImageIcon(assetPathAsk);

    //procesos repetidos
    public String getFechaActual(String formato) {
        SimpleDateFormat formatoFecha = null;
        if (formato.equals("gt")) {
            formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        }
        if (formato.equals("us")) {
            formatoFecha = new SimpleDateFormat("YYYY/MM/dd");
        }
        return formatoFecha.format(fecha);
    }

    //Validaciones
    public boolean isEmpty(JTextField... componentes) {
        for (JTextField componente : componentes) {
            String texto = componente.getText();
            texto = texto.replaceAll(" ", "");
            if (texto.isEmpty()) {
                accionErronea("¡ERROR!", "Existen campos vacios.");
                return false;
            }
        }
        return true;
    }

    public boolean isEmail(String... textos) {
        String regexPattern = "^(?=.{1,64}@)[\\p{L}0-9_-]+(\\.[\\p{L}0-9_-]+)*@[^-][\\p{L}0-9-]+(\\.[\\p{L}0-9-]+)*(\\.[\\p{L}]{2,})$";
        Pattern pattern = Pattern.compile(regexPattern);
        for (String email : textos) {
            Matcher matcher = pattern.matcher(email);
            if (!matcher.matches()) {
                accionErronea("¡ERROR!", "El correo ingresado es invalido.");
                return false;
            }
        }
        return true;
    }

    public boolean isSelected(JComboBox... componentes) {
        for (JComboBox componente : componentes) {
            if (componente.getSelectedIndex() == 0) {
                accionErronea("¡ERROR!", "No se ah seleccionado una opción.");
                return false;
            }
        }
        return true;
    }

    public boolean validateNonNullProperties(Object obj, List<String> propertyNames) throws IllegalAccessException {
        Class<?> objClass = obj.getClass();

        for (String propertyName : propertyNames) {
            try {
                Field field = objClass.getDeclaredField(propertyName);
                field.setAccessible(true);
                Object fieldValue = field.get(obj);
                if (fieldValue == null) {
                    return false;
                }
            } catch (NoSuchFieldException e) {
                accionErronea("¡ERROR!", "HUBO UN ERROR DE INFORMACIÓN EN LA BASE DE DATOS DEL ITEM SELECCIONADO .");
                return false;
            }
        }

        return true;
    }

    //Notificaiones
    public void accionExitosa(String titulo, String descripcion) {
        JOptionPane.showMessageDialog(null, descripcion, titulo, 0, iconoReady);
    }

    public void accionErronea(String titulo, String descripcion) {
        JOptionPane.showMessageDialog(null, descripcion, titulo, JOptionPane.ERROR_MESSAGE);
    }

    public boolean validarAccion(String titulo, String descripcion) {
        int confirmar = JOptionPane.showConfirmDialog(null, descripcion, titulo, 0, JOptionPane.YES_NO_OPTION, iconoAsk);
        return confirmar == 0;
    }
}
