import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Formulario extends JFrame {

    JLabel [] datos = new JLabel[14];
    JTextField [] TextField = new JTextField[8];
    String [] TextoLabel ={"Nombre:","Apellido:","Dirección:","telefono:","CP:","NIF:","Email:","Contraseña:","Pais:","Provincia:","Poblacion:","Sexo:","Idiomas:","carta de presentación"};
    int numLabels = 14;
    int numTextField = 8;
    int anchoLabel = 100;
    int altoLabel = 30;
    int anchoTextField = 150;
    int altoTextField = 20;
    int [] xLabels = {10,330,10,330,10,330,10,300,10,160,360,10,330,10};
    int [] yLabels = {10,10,60,60,110,110,160,160,210,210,210,260,260,315};
    int [] xTextField = {120,450,120,450,120,450,120,460};
    int [] yTextField = {15,15,65,65,115,115,165,215};


    public Formulario() {
        initLabels();
        initTextField();
        initPantalla();
    }

    private void initPantalla() {
        //aqui definimos la Pantalla de nuestro proyecto
        setLayout(null);
        setTitle("Formulario");
        setSize(450,510);
        setBackground(Color.GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.PINK);
        setVisible(true);
    }

    public void initLabels(){
        // los labels son todos los nombres que les hemos puestos a nuestros objetos
        for(int i = 0; i < numLabels; i++){
            datos[i] = new JLabel(TextoLabel[i]);
            int ancho = (i == 8 ||i == 11) ? 50 : anchoLabel;
            if (i == 13) ancho = 250;
            if (i == 7) ancho = 120;
            datos[i].setBounds(xLabels[i], yLabels[i], ancho, altoLabel);
            datos[i].setFont(new Font("Monospaced",Font.PLAIN,16));
            datos[i].setOpaque(true);
            datos[i].setBackground(Color.WHITE);
            datos[i].setForeground(Color.BLACK);
            add(datos[i]);
        }
    }

    private void initTextField() {
        // generamos las zonas de texto
        for(int i = 0; i < numTextField; i++){
            TextField[i] = new JTextField();
            TextField[i].setBounds(xTextField[i], yTextField[i], anchoTextField, altoTextField);
            TextField[i].setFont(new Font("Monospaced",Font.PLAIN,16));
            TextField[i].setOpaque(true);
            TextField[i].setBackground(Color.WHITE);
            TextField[i].setBorder(new LineBorder(Color.DARK_GRAY));
            TextField[i].setForeground(Color.BLACK);
            add(TextField[i]);
        }
        TextField[3].addKeyListener(new KeyAdapter() {
                                        public void keyTyped(KeyEvent e) {
                                            char caracter = e.getKeyChar();
                                            if (((caracter < '0') || (caracter > '9'))
                                                    && (caracter != '\b')) {
                                                e.consume();
                                            }
                                        }
                                    }
        );
    }

    public static void main(String[] args) {
        new Formulario();
    }

}
