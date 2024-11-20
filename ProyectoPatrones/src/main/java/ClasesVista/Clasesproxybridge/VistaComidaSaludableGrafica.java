/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesVista.Clasesproxybridge;
import ClasesModelo.Preferencias;
import ClasesModelo.RecetaPostres;
import ClasesModelo.RestriccionAlimenticia;
import ClasesModelo.Usuario;
import ClasesControl.FacadeServicios;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ClasesVista.Interfaceproxybridge.VistaComidaSaludable;

public class VistaComidaSaludableGrafica implements VistaComidaSaludable {
    private JTextArea textArea;
    private FacadeServicios facade;

    public VistaComidaSaludableGrafica(FacadeServicios facade) {
        this.facade = facade;
        textArea = new JTextArea(10, 30);
        JFrame frame = new JFrame("Recomendaciones de Comidas Saludables");
        JButton btnRegistrar = new JButton("Registrar Usuario");
        JButton btnCrearRestriccion = new JButton("Crear Restricción Alimentaria");
        JButton btnCrearPreferencia = new JButton("Crear Preferencia");
        JButton btnCrearReceta = new JButton("Crear Receta de Postre");
        // Acción para registrar usuario
//        btnRegistrar.addActionListener(e -> {
//            String nombre = JOptionPane.showInputDialog("Nombre:");
//            String email = JOptionPane.showInputDialog("Email:");
//            String idStr = JOptionPane.showInputDialog("ID (número entero):");
//            String password = JOptionPane.showInputDialog("Contraseña:");
//
//            // Validar ID
//            int id = -1;
//            try {
//                id = Integer.parseInt(idStr);
//            } catch (NumberFormatException ex) {
//                mostrarMensaje("ID inválido. Debe ser un número entero.");
//                return;
//            }
//
//            //Usuario usuario = facade.registrarUsuario(id, nombre, email, password);
//            if (usuario != null) {
//                mostrarMensaje("Usuario registrado: " + nombre);
//            } else {
//                mostrarMensaje("Error al registrar el usuario.");
//            }
//        });

        // Acción para crear restricción alimentaria
        btnCrearRestriccion.addActionListener(e -> {
            String idStr = JOptionPane.showInputDialog("ID (número entero):");
            String alergias = JOptionPane.showInputDialog("Alergias:");
            String glutenStr = JOptionPane.showInputDialog("¿Sin Gluten? (true/false):");
            String lactosaStr = JOptionPane.showInputDialog("¿Sin Lactosa? (true/false):");
            String azucarStr = JOptionPane.showInputDialog("¿Sin Azúcar? (true/false):");
            String veganoStr = JOptionPane.showInputDialog("¿Vegano? (true/false):");
            String citricoStr = JOptionPane.showInputDialog("¿Cítrico? (true/false):");
            String bajoEngrasaStr = JOptionPane.showInputDialog("¿Bajo en Grasa? (true/false):");

            // Validar ID
            int id = -1;
            try {
                id = Integer.parseInt(idStr);
            } catch (NumberFormatException ex) {
                mostrarMensaje("ID inválido. Debe ser un número entero.");
                return;
            }

            boolean gluten = Boolean.parseBoolean(glutenStr);
            boolean lactosa = Boolean.parseBoolean(lactosaStr);
            boolean azucar = Boolean.parseBoolean(azucarStr);
            boolean vegano = Boolean.parseBoolean(veganoStr);
            boolean citrico = Boolean.parseBoolean(citricoStr);
            boolean bajoEngrasa = Boolean.parseBoolean(bajoEngrasaStr);

//            RestriccionAlimenticia restriccion = facade.crearRestriccion(id, alergias, gluten, lactosa, azucar, vegano, citrico, bajoEngrasa);
//            mostrarMensaje("Restricción alimentaria creada: " + alergias);
        });

        // Acción para crear preferencia
        btnCrearPreferencia.addActionListener(e -> {
            String tipopostre = JOptionPane.showInputDialog("Tipo de postre:");
            String nivelactividad = JOptionPane.showInputDialog("Nivel de actividad:");
            String comidasaldiaStr = JOptionPane.showInputDialog("Comidas al día (número entero):");

            // Validar comidas al día
            int comidasaldia = -1;
            try {
                comidasaldia = Integer.parseInt(comidasaldiaStr);
            } catch (NumberFormatException ex) {
                mostrarMensaje("Número de comidas al día inválido.");
                return;
            }

            String prefiereOrganicoStr = JOptionPane.showInputDialog("¿Prefiere Orgánico? (true/false):");
            String bajoEnAzucarStr = JOptionPane.showInputDialog("¿Bajo en Azúcar? (true/false):");
            String altoEnProteinasStr = JOptionPane.showInputDialog("¿Alto en Proteínas? (true/false):");

            boolean prefiereOrganico = Boolean.parseBoolean(prefiereOrganicoStr);
            boolean bajoEnAzucar = Boolean.parseBoolean(bajoEnAzucarStr);
            boolean altoEnProteinas = Boolean.parseBoolean(altoEnProteinasStr);

//            Preferencias preferencia = facade.crearpreferencia(tipopostre, nivelactividad, comidasaldia, prefiereOrganico, bajoEnAzucar, altoEnProteinas);
//            mostrarMensaje("Preferencia creada: " + tipopostre);
        });

        // Acción para crear receta de postre
        btnCrearReceta.addActionListener(e -> {
            String idStr = JOptionPane.showInputDialog("ID (número entero):");
            String nombre = JOptionPane.showInputDialog("Nombre de la receta:");
            String tipopostre = JOptionPane.showInputDialog("Tipo de postre:");
            String ingredientes = JOptionPane.showInputDialog("Ingredientes:");
            String descripcionreceta = JOptionPane.showInputDialog("Descripción de la receta:");

            // Validar ID
            int id = -1;
            try {
                id = Integer.parseInt(idStr);
            } catch (NumberFormatException ex) {
                mostrarMensaje("ID inválido. Debe ser un número entero.");
                return;
            }

//            RecetaPostres receta = facade.crearservicioReceta(id, nombre, tipopostre, ingredientes, descripcionreceta);
//            mostrarMensaje("Receta de postre creada: " + nombre);
        });

        frame.add(btnRegistrar);
        frame.add(btnCrearRestriccion);
        frame.add(btnCrearPreferencia);
        frame.add(btnCrearReceta);
        frame.add(new JScrollPane(textArea));
        frame.setLayout(new java.awt.FlowLayout());
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void mostrarMensaje(String mensaje) {
        textArea.append(mensaje + "\n");
    }
    
}
