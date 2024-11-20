/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesVista.Clasesproxybridge;

import ClasesControl.FacadeServicios;
import ClasesVista.Interfaceproxybridge.VistaUsuario;
import Clasesmodelo.Interfacesmodelo.Usu;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class VistaUsuarioSwing implements VistaUsuario {
    private FacadeServicios facade; 
    Usu usuariodo;
    private JFrame frame;
    protected JTextField campoNombre;
    private JTextField campoCorreo;
    private JTextField campoTelefono;
    private JPasswordField campoContraseña;
    
     
    
    public JTextField getCampoNombre() {
        return campoNombre;
    }

    public void setCampoNombre(JTextField campoNombre) {
        this.campoNombre = campoNombre;
    }

    public JTextField getCampoCorreo() {
        return campoCorreo;
    }

    public void setCampoCorreo(JTextField campoCorreo) {
        this.campoCorreo = campoCorreo;
    }

    public JTextField getCampoTelefono() {
        return campoTelefono;
    }

    public void setCampoTelefono(JTextField campoTelefono) {
        this.campoTelefono = campoTelefono;
    }

    public JPasswordField getCampoContraseña() {
        return campoContraseña;
    }

    public void setCampoContraseña(JPasswordField campoContraseña) {
        this.campoContraseña = campoContraseña;
    }
    
    
    
    
    public VistaUsuarioSwing() {
        
        facade = new FacadeServicios();
        
         
        // Configuración del marco principal
        frame = new JFrame("Registro de Usuario");
        frame.setSize(800, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        // Panel para las pestañas
        JTabbedPane tabbedPane = new JTabbedPane();
        // Cambiar el color de fondo de las pestañas
        tabbedPane.setBackground(new Color(255, 233, 244)); 

        
        // Panel de Registro
        JPanel panelRegistro = new JPanel();
        panelRegistro.setLayout(new GridLayout(10, 2, 5, 5)); // 10 filas, 2 columnas, espacios de 5px entre elementos
        panelRegistro.setBorder(new EmptyBorder(20, 50, 20, 40));
        panelRegistro.setBackground(new Color(255, 233, 244)); // Fondo rosa pastel
        // Sección de Datos Personales
        
        JLabel labelnombre= new JLabel("Nombre:"); 
        panelRegistro.add(labelnombre);        
        Font fuente = new Font("Arial", Font.BOLD, 14);
        labelnombre.setFont(fuente);
        campoNombre = new JTextField();
        panelRegistro.add(campoNombre);
        
        JLabel labelcorreo= new JLabel("Correo:"); 
        panelRegistro.add(labelcorreo);
        labelcorreo.setFont(fuente);
        
        campoCorreo = new JTextField();
        panelRegistro.add(campoCorreo);
        
        JLabel labeltelef= new JLabel("Teléfono:"); 
        panelRegistro.add(labeltelef);
        labeltelef.setFont(fuente);
        campoTelefono = new JTextField();
        panelRegistro.add(campoTelefono);
        
        
        panelRegistro.add(new JLabel("Contraseña:")).setFont(fuente);
        
        campoContraseña = new JPasswordField();
        panelRegistro.add(campoContraseña);

        // Sección de Preferencias
        panelRegistro.add(new JLabel("Preferencias")).setFont(fuente);
        JButton btnPreferencias = new JButton("Tabla de preferencias");
        btnPreferencias.addActionListener(e -> mostrarMensaje("Abrir tabla de preferencias"));
        panelRegistro.add(btnPreferencias);
        btnPreferencias.setBackground(new Color(255, 105, 180)); // Rosa oscuro para el fondo
        btnPreferencias.setForeground(Color.WHITE); // Texto blanco
        
        // Sección de Restricciones
        panelRegistro.add(new JLabel("Restricciones")).setFont(fuente);
        JButton btnRestricciones = new JButton("Tabla de restricciones");
        btnRestricciones.addActionListener(e -> mostrarMensaje("Abrir tabla de restricciones"));
        panelRegistro.add(btnRestricciones);
        btnRestricciones.setBackground(new Color(255, 105, 180)); // Rosa oscuro para el fondo
        btnRestricciones.setForeground(Color.WHITE); // Texto blanco

        // Botón Guardar
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBackground(new Color(255, 105, 180)); // Rosa oscuro para el fondo
        btnGuardar.setForeground(Color.WHITE); // Texto blanco
        
        
        
        btnGuardar.addActionListener(e -> {
            String nombre = campoNombre.getText();
            String correo = campoCorreo.getText();
            //String telefono = campoTelefono.getText();
            String contraseña = new String(campoContraseña.getPassword());
            String telefono= campoTelefono.getText(); 
            int cont=49 ; 
            cont=cont+1; 
                    
            usuariodo= facade.registrarUsuario(cont, nombre , correo,telefono, contraseña) ;
            
            mostrarMensaje("Datos guardados: " + nombre) ;
        });
        panelRegistro.add(btnGuardar);

        // Botón Cerrar
        JButton btnCerrar = new JButton("Cerrar");
        
        btnCerrar.addActionListener(e -> cerrar());
        panelRegistro.add(btnCerrar);
        btnCerrar.setBackground(new Color(255, 105, 180)); // Rosa oscuro para el fondo
        btnCerrar.setForeground(Color.WHITE); // Texto blanco

        //botón actualizar 
        JButton btnActualizar = new JButton("Actualizar");
        
        
        btnActualizar.addActionListener(new ActionListener() {
            
            

            @Override
            public void actionPerformed(ActionEvent e) {
                
                    String nombre = campoNombre.getText();
                    String correo = campoCorreo.getText();
                    String telefono = campoTelefono.getText();
                    String contraseña = new String(campoContraseña.getPassword());
                     
                    int cont=49 ; 
                    cont=cont+1; 
                               
                    facade.actualizarusuario(usuariodo, nombre, correo, telefono, contraseña);

                    mostrarMensaje("Datos actualizados: " + nombre);
            }
        
        
        });
        panelRegistro.add(btnActualizar);
        btnActualizar.setBackground(new Color(255, 105, 180)); // Rosa oscuro para el fondo
        btnActualizar.setForeground(Color.WHITE); // Texto blanco
        
        
        // Agregar panel de Registro a las pestañas
        tabbedPane.addTab("Registro", panelRegistro);
        
        // Panel Principal para Cuestionario
JPanel panelPrincipalCuestionario = new JPanel(new BorderLayout());
panelPrincipalCuestionario.setBorder(new EmptyBorder (20, 50,20,40));
panelPrincipalCuestionario.setBackground(new Color(255, 233, 244)); // Rosa pastel

// Panel de botones de Cuestionario (izquierda)
JPanel panelBotonesCuestionario = new JPanel();
panelBotonesCuestionario.setLayout(new BoxLayout(panelBotonesCuestionario, BoxLayout.Y_AXIS));
panelBotonesCuestionario.setBackground(new Color(255, 233, 244)); // Fondo rosa pastel

    JButton btnPreferencia = new JButton("Preferencias alimenticias");
    JButton btnRestriccione = new JButton("Restricciones alimenticias");

btnPreferencia.setBackground(new Color(255, 105, 180)); // Rosa oscuro para el fondo
btnPreferencia.setForeground(Color.WHITE); // Texto blanco
btnRestriccione.setBackground(new Color(255, 105, 180)); // Rosa oscuro para el fondo
btnRestriccione.setForeground(Color.WHITE); // Texto blanco

panelBotonesCuestionario.add(btnPreferencia);
panelBotonesCuestionario.add(Box.createVerticalStrut(20)); // Espaciado entre botones
panelBotonesCuestionario.add(btnRestriccione);

panelPrincipalCuestionario.add(panelBotonesCuestionario, BorderLayout.WEST);

// Panel de contenido dinámico (derecha)
JPanel panelContenidoCuestionario = new JPanel(new CardLayout());

JPanel panelPreferencias = new JPanel();
panelPreferencias.setLayout(new BoxLayout(panelPreferencias, BoxLayout.Y_AXIS)); // Organiza los elementos en columna
panelPreferencias.setBackground(new Color(255, 233, 244));
panelPreferencias.setBorder(new EmptyBorder (20, 50,20,40));
// Preguntas de Preferencias Alimenticias
panelPreferencias.add(new JLabel("1. ¿Qué tipo de postre prefieres?"));
JComboBox<String> comboTipoPostre = new JComboBox<>(new String[]{"Helado", "Pastel", "Galletas", "Frutas"});
panelPreferencias.add(comboTipoPostre);

panelPreferencias.add(new JLabel("2. ¿Cuál es tu nivel de actividad física actual?"));
JRadioButton radioAlta = new JRadioButton("Alta");
JRadioButton radioMedia = new JRadioButton("Media");
JRadioButton radioBaja = new JRadioButton("Baja");
ButtonGroup grupoActividad = new ButtonGroup();
grupoActividad.add(radioAlta);
grupoActividad.add(radioMedia);
grupoActividad.add(radioBaja);
JPanel panelActividad = new JPanel();
panelActividad.add(radioAlta);
panelActividad.add(radioMedia);
panelActividad.add(radioBaja);
panelPreferencias.add(panelActividad);
panelActividad.setBackground(new Color(255, 233, 244)); // Fondo rosa pastel

panelPreferencias.add(new JLabel("3. ¿Cuántas veces comes al día?"));
JComboBox<String> comboFrecuenciaComida = new JComboBox<>(new String[]{"1", "2", "3", "4", "5+"});
panelPreferencias.add(comboFrecuenciaComida);

panelPreferencias.add(new JLabel("4. ¿Te gustan los postres basados en productos orgánicos?"));
JRadioButton radioOrganicoSi = new JRadioButton("Sí");
JRadioButton radioOrganicoNo = new JRadioButton("No");
ButtonGroup grupoOrganico = new ButtonGroup();
grupoOrganico.add(radioOrganicoSi);
grupoOrganico.add(radioOrganicoNo);
JPanel panelOrganico = new JPanel();
panelOrganico.add(radioOrganicoSi);
panelOrganico.add(radioOrganicoNo);
panelPreferencias.add(panelOrganico);
panelOrganico.setBackground(new Color(255, 233, 244)); // Fondo rosa pastel

// Pregunta 5: Recetas bajas en azúcar
panelPreferencias.add(new JLabel("5. ¿Quieres ver recetas de postres bajos en azúcar?"));
JRadioButton radioAzucarSi = new JRadioButton("Sí");
JRadioButton radioAzucarNo = new JRadioButton("No");
ButtonGroup grupoAzucar = new ButtonGroup();
grupoAzucar.add(radioAzucarSi);
grupoAzucar.add(radioAzucarNo);
JPanel panelAzucar = new JPanel();
panelAzucar.add(radioAzucarSi);
panelAzucar.add(radioAzucarNo);
panelPreferencias.add(panelAzucar);
panelAzucar.setBackground(new Color(255, 233, 244)); // Fondo rosa pastel

// Pregunta 6: Alta proteína
panelPreferencias.add(new JLabel("6. ¿Prefieres consumir postres que tengan alta proteína?"));
JRadioButton radioAzucarSi2 = new JRadioButton("Sí");
JRadioButton radioAzucarNo2 = new JRadioButton("No");
ButtonGroup grupoAzucar2 = new ButtonGroup();
grupoAzucar2.add(radioAzucarSi2);
grupoAzucar2.add(radioAzucarNo2);
JPanel panelAzucar2 = new JPanel();
panelAzucar2.add(radioAzucarSi2);
panelAzucar2.add(radioAzucarNo2);
panelPreferencias.add(panelAzucar2);
panelAzucar2.setBackground(new Color(255, 233, 244)); // Fondo rosa pastel

// Botones Guardar y Cerrar en Preferencias
JPanel panelBotonesPreferencias = new JPanel(new FlowLayout(FlowLayout.RIGHT));
panelBotonesPreferencias.setBackground(new Color(255, 233, 244)); // Fondo rosa pastel
JButton btnGuardarPreferencias = new JButton("Guardar");
btnGuardarPreferencias.setBackground(new Color(255, 105, 180)); // Fondo rosa oscuro
btnGuardarPreferencias.setForeground(Color.WHITE); // Texto blanco
panelBotonesPreferencias.add(btnGuardarPreferencias);
panelPreferencias.add(panelBotonesPreferencias);

// Panel Restricciones
JPanel panelRestricciones = new JPanel();
panelRestricciones.setLayout(new BoxLayout(panelRestricciones, BoxLayout.Y_AXIS));
panelRestricciones.setBackground(new Color(255, 233, 244));
panelRestricciones.setBorder(new EmptyBorder (20, 50,20,40));
// Preguntas de Restricciones
panelRestricciones.add(new JLabel("7. ¿Tienes alergias alimenticias?"));
JTextField campoAlergias = new JTextField();
panelRestricciones.add(campoAlergias);


panelRestricciones.add(new JLabel("8. ¿Prefieres alimentos bajos en azúcar?"));
JRadioButton radioBajoAzucarSi = new JRadioButton("Sí");
JRadioButton radioBajoAzucarNo = new JRadioButton("No");
ButtonGroup grupo = new ButtonGroup();
grupo.add(radioBajoAzucarSi);
grupo.add(radioBajoAzucarNo);
JPanel panelAzuca = new JPanel();
panelAzuca.add(radioBajoAzucarSi);
panelAzuca.add(radioBajoAzucarNo);
panelRestricciones.add(panelAzuca);
panelAzuca.setBackground(new Color(255, 233, 244));

panelRestricciones.add(new JLabel("9. ¿Tienes intolerancia a la lactosa?"));
JRadioButton radioLactosaSi = new JRadioButton("Sí");
JRadioButton radioLactosaNo = new JRadioButton("No");
ButtonGroup grupoLactosa = new ButtonGroup();
grupoLactosa.add(radioLactosaSi);
grupoLactosa.add(radioLactosaNo);
JPanel panelLactosa = new JPanel();
panelLactosa.add(radioLactosaSi);
panelLactosa.add(radioLactosaNo);
panelRestricciones.add(panelLactosa);
panelLactosa.setBackground(new Color(255, 233, 244));
//PREGUNTA 10
panelRestricciones.add(new JLabel("10. ¿Puedes consumir azúcares?"));
JRadioButton radioconSi = new JRadioButton("Sí");
JRadioButton radioconNo = new JRadioButton("No");
ButtonGroup grupoconsumo = new ButtonGroup();
grupoconsumo.add(radioconSi);
grupoconsumo.add(radioconNo);
JPanel panelconsu = new JPanel();
panelconsu.add(radioconSi);
panelconsu.add(radioconNo);
panelRestricciones.add(panelconsu);
panelconsu.setBackground(new Color(255, 233, 244));

//PREGUNTA 11
panelRestricciones.add(new JLabel("11. ¿Eres vegano?"));
JRadioButton radioveg = new JRadioButton("Sí");
JRadioButton radiovegNo = new JRadioButton("No");
ButtonGroup grupovega = new ButtonGroup();
grupovega.add(radioveg);
grupovega.add(radiovegNo);
JPanel panelvegano = new JPanel();
panelvegano.add(radioveg);
panelvegano.add(radiovegNo);
panelRestricciones.add(panelvegano);
panelvegano.setBackground(new Color(255, 233, 244));

//PREGUNTA 12
panelRestricciones.add(new JLabel("12. ¿Puedes consumir cítricos?"));
JRadioButton radiocitri = new JRadioButton("Sí");
JRadioButton radiocitriNo = new JRadioButton("No");
ButtonGroup grupocitri = new ButtonGroup();
grupocitri.add(radiocitri);
grupocitri.add(radiocitriNo);
JPanel panelcitri = new JPanel();
panelcitri.add(radiocitri);
panelcitri.add(radiocitriNo);
panelRestricciones.add(panelcitri);
panelcitri.setBackground(new Color(255, 233, 244));

//PREGUNTA 13
panelRestricciones.add(new JLabel("13. ¿Consumes postres bajos en grasa?"));
JRadioButton radiograsa = new JRadioButton("Sí");
JRadioButton radiograsaNo = new JRadioButton("No");
ButtonGroup grupograsa = new ButtonGroup();
grupograsa.add(radiograsa);
grupograsa.add(radiograsaNo);
JPanel panelgrasa = new JPanel();
panelgrasa.add(radiograsa);
panelgrasa.add(radiograsaNo);
panelRestricciones.add(panelgrasa);
panelgrasa.setBackground(new Color(255, 233, 244));

// Botones Guardar y Cerrar en Restricciones
JPanel panelBotonesRestricciones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
panelBotonesRestricciones.setBackground(new Color(255, 233, 244)); // Fondo rosa pastel
JButton btnGuardarRestricciones = new JButton("Guardar");
btnGuardarRestricciones.setBackground(new Color(255, 105, 180)); // Fondo rosa oscuro
btnGuardarRestricciones.setForeground(Color.WHITE); // Texto blanco
panelBotonesRestricciones.add(btnGuardarRestricciones);
panelRestricciones.add(panelBotonesRestricciones);

// Agregar paneles al CardLayout
panelContenidoCuestionario.add(panelPreferencias, "Preferencias");
panelContenidoCuestionario.add(panelRestricciones, "Restricciones");

panelPrincipalCuestionario.add(panelContenidoCuestionario, BorderLayout.CENTER);

// Acciones de los botones
btnPreferencia.addActionListener(e -> {
    CardLayout cl = (CardLayout) (panelContenidoCuestionario.getLayout());
    cl.show(panelContenidoCuestionario, "Preferencias");
});
btnRestriccione.addActionListener(e -> {
    CardLayout cl = (CardLayout) (panelContenidoCuestionario.getLayout());
    cl.show(panelContenidoCuestionario, "Restricciones");
});
btnGuardarPreferencias.addActionListener(e -> {
    mostrarMensaje("Preferencias guardadas con éxito.");
});
btnGuardarRestricciones.addActionListener(e -> {
    mostrarMensaje("Restricciones guardadas con éxito.");
});

// Añadir el panel principal de cuestionario a las pestañas
tabbedPane.addTab("Cuestionario", panelPrincipalCuestionario);




        
        
/////////////////////////////////////////////////////////////////////////////////////
// Dentro del constructor de `VistaUsuarioSwing`, debajo de donde defines `panelNotificaciones`
JPanel panelPrincipalNotificaciones = new JPanel(new BorderLayout());
panelPrincipalNotificaciones.setBorder(new EmptyBorder(0,0,0,40));
panelPrincipalNotificaciones.setBackground(new Color(255,233,244));//rosa pastel
// Panel de botones de notificación (izquierda)

JPanel panelBotonesNotificaciones = new JPanel(new GridLayout(2, 1, 10, 60));
panelBotonesNotificaciones.setLayout(new BoxLayout(panelBotonesNotificaciones, BoxLayout.Y_AXIS)); // Alineación vertical
panelBotonesNotificaciones.setBackground(new Color(255, 233, 244)); // Fondo rosa pastel
panelPrincipalNotificaciones.setBackground(new Color(255, 233, 244)); // Fondo rosa pastel

JButton btnNotificarCorreo = new JButton("Notificar por correo electrónico");

JButton btnNotificarSMS = new JButton("Notificar por SMS");

btnNotificarCorreo.setBackground(new Color(255, 105, 180)); // Rosa oscuro para el fondo
btnNotificarCorreo.setForeground(Color.WHITE); // Texto blanco

btnNotificarSMS.setBackground(new Color(255, 105, 180)); // Rosa oscuro para el fondo
btnNotificarSMS.setForeground(Color.WHITE); // Texto blanco

panelBotonesNotificaciones.add(btnNotificarCorreo);
panelBotonesNotificaciones.add(Box.createVerticalStrut(20)); // Separación de 20 píxeles
panelBotonesNotificaciones.add(btnNotificarSMS);
panelPrincipalNotificaciones.add(panelBotonesNotificaciones, BorderLayout.WEST);

// Panel de contenido dinámico (derecha)
JPanel panelContenidoNotificaciones = new JPanel();
panelContenidoNotificaciones.setLayout(new CardLayout()); // CardLayout para alternar entre paneles

// Panel de Notificaciones por Correo
JPanel panelCorreo = new JPanel();
panelPrincipalCuestionario.setBorder(new EmptyBorder (20, 50,20,40)); 
panelCorreo.setLayout(new GridLayout(8, 2, 5, 5)); // Configuración del diseño de cuadrícula
panelCorreo.setBackground(new Color(255, 233, 244)); // Fondo rosa pastel

// ¿Quieres recibir notificaciones por correo?
panelCorreo.add(new JLabel("¿Quieres recibir notificaciones por correo?"));
JRadioButton radioNotificarSi = new JRadioButton("Sí");
JRadioButton radioNotificarNo = new JRadioButton("No");
ButtonGroup grupoNotificaciones = new ButtonGroup();
grupoNotificaciones.add(radioNotificarSi);
grupoNotificaciones.add(radioNotificarNo);
JPanel panelNotificar = new JPanel();
panelNotificar.add(radioNotificarSi);
panelNotificar.add(radioNotificarNo);
panelCorreo.add(panelNotificar);
panelNotificar.setBackground(new Color(255, 233, 244)); // Rosa pastel para el fondo

// Número de veces por semana
panelCorreo.add(new JLabel("Número de veces por semana"));
JSpinner spinnerVecesPorSemana = new JSpinner(new SpinnerNumberModel(1, 1, 7, 1));
panelCorreo.add(spinnerVecesPorSemana);

// Días de la semana
panelCorreo.add(new JLabel("Días de la semana"));
JPanel panelDiasSemana = new JPanel(new GridLayout(1, 7));
String[] dias = { "L", "M", "Mi", "J", "V", "S", "D" };
for (String dia : dias) {
    JCheckBox checkDia = new JCheckBox(dia);
    panelDiasSemana.add(checkDia);
}
panelCorreo.add(panelDiasSemana);

// Hora de envío de notificación
panelCorreo.add(new JLabel("Hora de envío de notificación"));
JTextField campoHora = new JTextField(2);
JTextField campoMinutos = new JTextField(2);
JRadioButton radioAM = new JRadioButton("am");
JRadioButton radioPM = new JRadioButton("pm");
ButtonGroup grupoHora = new ButtonGroup();
grupoHora.add(radioAM);
grupoHora.add(radioPM);
JPanel panelHora = new JPanel();
panelHora.add(campoHora);
panelHora.add(new JLabel(":"));
panelHora.add(campoMinutos);
panelHora.add(radioAM);
panelHora.add(radioPM);
panelCorreo.add(panelHora);
panelHora.setBackground(new Color(255, 233, 244)); // Rosa pastel para el fondo
panelDiasSemana.setBackground(new Color(255, 233, 244)); // Rosa pastel para el fondo

// Panel para el botón Guardar
JPanel panelBotonGuardado = new JPanel();
panelBotonGuardado.setLayout(new FlowLayout(FlowLayout.RIGHT)); // Centrar el botón dentro del panel
panelBotonGuardado.setBackground(new Color(255, 233, 244)); // Fondo rosa pastel para el panel
// Botón Guardar en el panel de Notificaciones por Correo

JButton btnGuardarCorreo = new JButton("Guardar");
btnGuardarCorreo.addActionListener(e -> {
    // Aquí puedes agregar la lógica para guardar la información
    mostrarMensaje("Configuración de notificaciones por correo guardada.");
    

});
// Agregar el botón al nuevo panel
panelBotonGuardado.add(btnGuardarCorreo);

btnGuardarCorreo.setBackground(new Color(255, 105, 180)); // Rosa oscuro para el fondo
btnGuardarCorreo.setForeground(Color.WHITE); // Texto blanco
// Agregar el panel con el botón Cerrar al panel principal (en la parte inferior)
panelCorreo.add(panelBotonGuardado, BorderLayout.SOUTH);

panelCorreo.add(btnGuardarCorreo);
panelCorreo.add(new JLabel("")); // Espacio en blanco
// Añadir borde con título al panel de notificaciones por correo
        panelCorreo.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.BLACK), 
            "Notificaciones por Correo", 
            TitledBorder.LEFT, TitledBorder.TOP));

// Panel de Notificaciones por SMS (placeholder)
JPanel panelSMS = new JPanel();
panelSMS.setLayout(new GridLayout( 8, 2, 5, 5));
panelSMS.setBackground(new Color(255, 233, 244)); // Fondo rosa pastel

// ¿Quieres recibir notificaciones por correo?
panelSMS.add(new JLabel("¿Quieres recibir notificaciones por SMS?"));
JRadioButton radioNotificarSi2 = new JRadioButton("Sí");
JRadioButton radioNotificarNo2 = new JRadioButton("No");
ButtonGroup grupoNotificaciones2 = new ButtonGroup();
grupoNotificaciones2.add(radioNotificarSi2);
grupoNotificaciones2.add(radioNotificarNo2);
JPanel panelNotificar2 = new JPanel();
panelNotificar2.add(radioNotificarSi2);
panelNotificar2.add(radioNotificarNo2);
panelSMS.add(panelNotificar2);
panelNotificar2.setBackground(new Color(255, 233, 244)); // Fondo rosa pastel

// Número de veces por semana
panelSMS.add(new JLabel("Número de veces por semana"));
JSpinner spinnerVecesPorSemana2 = new JSpinner(new SpinnerNumberModel(1, 1, 7, 1));
panelSMS.add(spinnerVecesPorSemana2);
panelSMS.setBackground(new Color(255, 233, 244)); // Fondo rosa pastel
// Días de la semana
panelSMS.add(new JLabel("Días de la semana"));
JPanel panelDiasSemana2 = new JPanel(new GridLayout(1, 7));
String[] dias2 = { "L", "M", "Mi", "J", "V", "S", "D" };
for (String dia2 : dias2) {
    JCheckBox checkDia2 = new JCheckBox(dia2);
    panelDiasSemana2.add(checkDia2);
}
panelSMS.add(panelDiasSemana2);
panelDiasSemana2.setBackground(new Color(255, 233, 244)); // Fondo rosa pastel

// Hora  de envío de notificación
panelSMS.add(new JLabel("Hora de envío de notificación"));
JTextField campoHora2 = new JTextField(2);
JTextField campoMinutos2 = new JTextField(2);
JRadioButton radioAM2 = new JRadioButton("am");
JRadioButton radioPM2 = new JRadioButton("pm");
ButtonGroup grupoHora2 = new ButtonGroup();
grupoHora2.add(radioAM);
grupoHora2.add(radioPM);
JPanel panelHora2 = new JPanel();
panelHora2.add(campoHora2);
panelHora2.add(new JLabel(":"));
panelHora2.add(campoMinutos2);
panelHora2.add(radioAM2);
panelHora2.add(radioPM2);
panelSMS.add(panelHora2);

panelHora2.setBackground(new Color(255, 233, 244)); // Fondo rosa pastel


JButton btnGuardarSMS= new JButton("Guardar"); 
btnGuardarSMS.addActionListener( e -> {
    mostrarMensaje("Configuración de notificación de SMS guardada"); 
});
btnGuardarSMS.setBackground(new Color(255, 105, 180)); // Rosa oscuro para el fondo
btnGuardarSMS.setForeground(Color.WHITE); // Texto blanco
panelSMS.add(btnGuardarSMS); 
panelSMS.add(new JLabel("")); 
// Añadir borde con título al panel de notificaciones por SMS
        panelSMS.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.BLACK),
            "Notificaciones por SMS", 
            TitledBorder.LEFT, TitledBorder.TOP));

// Agregar los paneles de correo y SMS al panel de contenido con CardLayout
panelContenidoNotificaciones.add(panelCorreo, "Correo");
panelContenidoNotificaciones.add(panelSMS, "SMS");

// Agregar `panelContenidoNotificaciones` al centro del `panelPrincipalNotificaciones`
panelPrincipalNotificaciones.add(panelContenidoNotificaciones, BorderLayout.CENTER);

// Agregar el panel de Notificaciones a las pestañas
tabbedPane.addTab("Notificaciones", panelPrincipalNotificaciones);

// Eventos para cambiar entre los paneles
btnNotificarCorreo.addActionListener(e -> {
    CardLayout cl = (CardLayout)(panelContenidoNotificaciones.getLayout());
    cl.show(panelContenidoNotificaciones, "Correo");
});

btnNotificarSMS.addActionListener(e -> {
    CardLayout cl = (CardLayout)(panelContenidoNotificaciones.getLayout());
    cl.show(panelContenidoNotificaciones, "SMS");
});

// Panel de postres////////////////////////////////////////////////////////////////////7
JPanel panelRecetas = new JPanel();
panelRecetas.setLayout(new BorderLayout()); // Usar BorderLayout para organizar los componentes
panelRecetas.setBorder(new EmptyBorder(20, 50, 20, 40));
panelRecetas.setBackground(new Color(255, 233, 244)); // Rosa pastel de fondo

// Barra de búsqueda encima de la cuadrícula de imágenes
JPanel panelBusqueda = new JPanel();
panelBusqueda.setLayout(new FlowLayout(FlowLayout.CENTER)); // Centrar los componentes dentro del panel
panelBusqueda.setBackground(new Color(255, 233, 244)); // Fondo rosa pastel

// Etiqueta de búsqueda
panelBusqueda.add(new JLabel("Buscar receta:"));

// Campo de texto para la búsqueda 
JTextField campoBusqueda = new JTextField(30); 
panelBusqueda.add(campoBusqueda);

// Botón de búsqueda
JButton btnBuscar = new JButton("Buscar");
panelBusqueda.add(btnBuscar);

// Cambiar color de fondo y texto del botón de búsqueda
btnBuscar.setBackground(new Color(255, 105, 180)); // Rosa oscuro para el fondo
btnBuscar.setForeground(Color.WHITE); // Texto blanco

// Agregar el panel de búsqueda al panel principal, en la parte superior
panelRecetas.add(panelBusqueda, BorderLayout.NORTH);

// Panel de botones (Recetas Populares y Recetas Personalizadas)
JPanel panelBotones = new JPanel();
panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS)); // Alineación vertical
panelBotones.setBackground(new Color(255, 233, 244)); // Fondo rosa pastel

JButton btnRecetasPopulares = new JButton("Recetas Populares");
JButton btnRecetasPersonalizadas = new JButton("Recetas Personalizadas");

// Cambiar color de fondo y texto de los botones
btnRecetasPopulares.setBackground(new Color(255, 105, 180)); // Rosa oscuro
btnRecetasPopulares.setForeground(Color.WHITE); // Texto blanco

btnRecetasPersonalizadas.setBackground(new Color(255, 105, 180)); // Rosa oscuro
btnRecetasPersonalizadas.setForeground(Color.WHITE); // Texto blanco

// Crear el panel de cuadrícula para postres populares
JPanel panelCuadriculaPopulares = new JPanel();
panelCuadriculaPopulares.setLayout(new GridLayout(0, 3, 10, 10)); // Cuadrícula con 3 columnas y espacio entre los elementos
panelCuadriculaPopulares.setBorder(new EmptyBorder(10, 10, 10, 10));

// Rellenar cuadrícula con postres populares
String[] nombresPostresPopulares = {"Torta de Zanahoria", "Yogurt de Cúrcuma", "Brownie con frutas",
"Bavaroise de Lima", "Sorbete de Melecotón", "Flan de manzana"};
for (String nombrePostre : nombresPostresPopulares) {
    JPanel panelPostre = new JPanel();
    panelPostre.setLayout(new BorderLayout());
    panelPostre.setBackground(new Color(255, 233, 244));
    panelPostre.setBorder(BorderFactory.createLineBorder(Color.PINK)); // Borde alrededor de cada postre

    // Imagen de ejemplo (ajusta la ruta de la imagen)
    JLabel imagenPostre = new JLabel(new ImageIcon("ruta/a/imagen.jpg"));
    panelPostre.add(imagenPostre, BorderLayout.CENTER);

    // Nombre del postre encima de la imagen
    JLabel nombrePostreLabel = new JLabel(nombrePostre, SwingConstants.CENTER);
    panelPostre.add(nombrePostreLabel, BorderLayout.NORTH);

    // Botones debajo de la imagen
    JPanel panelBotonesPostre = new JPanel();
    panelBotonesPostre.setLayout(new FlowLayout(FlowLayout.CENTER));
    JButton btnValorar = new JButton("Valorar");
    JButton btnLeer = new JButton("Leer");

    // Establecer colores para los botones debajo de la imagen
    btnValorar.setBackground(new Color(255, 105, 180)); // Rosa oscuro
    btnValorar.setForeground(Color.WHITE); // Texto blanco

    btnLeer.setBackground(new Color(255, 105, 180)); // Rosa oscuro
    btnLeer.setForeground(Color.WHITE); // Texto blanco

    panelBotonesPostre.add(btnValorar);
    panelBotonesPostre.add(btnLeer);
    panelPostre.add(panelBotonesPostre, BorderLayout.SOUTH);

    panelCuadriculaPopulares.add(panelPostre);
}

// Crear el panel de cuadrícula para postres personalizados
JPanel panelCuadriculaPersonalizadas = new JPanel();
panelCuadriculaPersonalizadas.setLayout(new GridLayout(0, 3, 10, 10)); // Cuadrícula con 3 columnas y espacio entre los elementos
panelCuadriculaPersonalizadas.setBorder(new EmptyBorder(10, 10, 10, 10));

// Rellenar cuadrícula con postres personalizados
String[] nombresPostresPersonalizados = {"Bavaroise de Lima", "Sorbete de Melecotón", "Flan de manzana"};
for (String nombrePostre : nombresPostresPersonalizados) {
    JPanel panelPostre = new JPanel();
    panelPostre.setLayout(new BorderLayout());
    panelPostre.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Borde alrededor de cada postre

    // Imagen de ejemplo (ajusta la ruta de la imagen)
    JLabel imagenPostre = new JLabel(new ImageIcon("ruta/a/imagen.jpg"));
    panelPostre.add(imagenPostre, BorderLayout.CENTER);

    // Nombre del postre encima de la imagen
    JLabel nombrePostreLabel = new JLabel(nombrePostre, SwingConstants.CENTER);
    panelPostre.add(nombrePostreLabel, BorderLayout.NORTH);

    // Botones debajo de la imagen
    JPanel panelBotonesPostre = new JPanel();
    panelBotonesPostre.setLayout(new FlowLayout(FlowLayout.CENTER));
    JButton btnValorar = new JButton("Valorar");
    JButton btnLeer = new JButton("Leer");

    // Establecer colores para los botones debajo de la imagen
    btnValorar.setBackground(new Color(255, 105, 180)); // Rosa oscuro
    btnValorar.setForeground(Color.WHITE); // Texto blanco

    btnLeer.setBackground(new Color(255, 105, 180)); // Rosa oscuro
    btnLeer.setForeground(Color.WHITE); // Texto blanco

    panelBotonesPostre.add(btnValorar);
    panelBotonesPostre.add(btnLeer);
    panelPostre.add(panelBotonesPostre, BorderLayout.SOUTH);

    panelCuadriculaPersonalizadas.add(panelPostre);
}

// Crear un Layout de tipo CardLayout para cambiar entre las cuadrículas
CardLayout cardLayout = new CardLayout();
JPanel panelCuadricula = new JPanel(cardLayout);
panelCuadricula.add(panelCuadriculaPopulares, "Recetas Populares");
panelCuadricula.add(panelCuadriculaPersonalizadas, "Recetas Personalizadas");

// Acción para cambiar entre las cuadrículas al hacer clic en los botones
btnRecetasPopulares.addActionListener(e -> cardLayout.show(panelCuadricula, "Recetas Populares"));
btnRecetasPersonalizadas.addActionListener(e -> cardLayout.show(panelCuadricula, "Recetas Personalizadas")); 

// Agregar los botones al panel de botones
panelBotones.add(btnRecetasPopulares);
panelBotones.add(Box.createVerticalStrut(20)); // Separación de 10 píxeles
panelBotones.add(btnRecetasPersonalizadas);
panelRecetas.add(panelBotones, BorderLayout.WEST);

// Panel para el botón Cerrar
JPanel panelBotonCerrar = new JPanel();
panelBotonCerrar.setLayout(new FlowLayout(FlowLayout.RIGHT)); // Centrar el botón dentro del panel
panelBotonCerrar.setBackground(new Color(255, 233, 244)); // Fondo rosa pastel para el panel

// Botón Cerrar
JButton btnCerrar2 = new JButton("Cerrar");
btnCerrar2.setBackground(new Color(255, 105, 180)); // Rosa oscuro
btnCerrar2.setForeground(Color.WHITE); // Texto blanco

// Ajustar el tamaño del botón para hacerlo más pequeño
btnCerrar2.setPreferredSize(new Dimension(100, 30)); // Ancho: 100px, Alto: 30px

// Acción para cerrar la aplicación
btnCerrar2.addActionListener(e -> System.exit(0));

// Agregar el botón al nuevo panel
panelBotonCerrar.add(btnCerrar2);

// Agregar el panel con el botón Cerrar al panel principal (en la parte inferior)
panelRecetas.add(panelBotonCerrar, BorderLayout.SOUTH);

// Agregar la cuadrícula de postres (con CardLayout) al panel principal
panelRecetas.add(panelCuadricula, BorderLayout.CENTER);

// Agregar el panel al TabbedPane
tabbedPane.addTab("Catalogo Postres", panelRecetas);

        
// Agregar componentes al marco principal
     frame.add(tabbedPane, BorderLayout.CENTER);
    
    }
    @Override
    public void mostrar() {
        frame.setVisible(true);
    }

    @Override
    public void cerrar() {
        frame.dispose();
    }

    @Override
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(frame, mensaje);
    }


}

  
