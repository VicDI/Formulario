import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class Formulario extends JFrame  implements ChangeListener, ItemListener {

    JLabel [] datos = new JLabel[14];
    JTextField [] TextField = new JTextField[8];
    JTextField Otroidioma;
    String [] Paises ={"España","Francia","Belgica","Alemania","Portugal"};
    String [] TextoLabel ={"Nombre:","Apellido:","Dirección:","telefono:","CP:","NIF:","Email:","Contraseña:","Pais:","Provincia:","Poblacion:","Sexo:","Idiomas:","carta de presentación"};
    int numLabels = 14;
    int numTextField = 8;
    int anchoLabel = 100;
    int altoLabel = 30;
    int anchoTextField = 150;
    int altoTextField = 20;
    int [] xLabels = {10,10,10,10,10,10,10,10,330,330,10,330,330,330};
    int [] yLabels = {10,60,210,260,160,310,110,360,10,60,410,110,160,210};
    int [] xTextField = {120,120,120,120,120,120,120,120};
    int [] yTextField = {15,65,215,265,165,315,115,415};

    private JPasswordField contrasenia;
    private JRadioButton Hombre,Mujer,Otros;
    private ButtonGroup Sexo;
    private JComboBox Pais,Provincia;
    private JCheckBox Castellano, Ingles, Frances, Mas;


    public Formulario() {
        initLabels();
        initTextField();
        initPasswordField();
        intitRadioButton();
        intitCheckBox();
        intitCombobox();
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

    private void initPasswordField() {
        //aqui nos permite que la contraseña no sea visulizable al escribirla
        contrasenia = new JPasswordField();
        contrasenia.setBounds(150, 365, 150, 20);
        add(contrasenia);
    }

    private void intitRadioButton() {
        // Este RadioButton sirve para determinar el sexo de la persona que esta escribiendo formulario
        Sexo = new ButtonGroup();

        Hombre=new JRadioButton("Hombre");
        Hombre.setBounds(400,110,70,30);
        Hombre.addChangeListener(this);
        add(Hombre);
        Sexo.add(Hombre);

        Mujer=new JRadioButton("Mujer");
        Mujer.setBounds(500,110,70,30);
        Mujer.addChangeListener(this);
        add(Mujer);
        Sexo.add(Mujer);

        Otros=new JRadioButton("Otros");
        Otros.setBounds(600,110,70,30);
        Otros.addChangeListener(this);
        add(Otros);
        Sexo.add(Otros);
    }

    private void intitCombobox() {
        //En el combo box daremos la opción de elegir el lugar donde vive
        Pais=new JComboBox();
        Pais.setBounds(400,15,80,20);
        add(Pais);
        String paisecogido = "";

        //aqui proponemos los paises
        Pais.addItem(Paises[0]);
        Pais.addItem(Paises[1]);
        Pais.addItem(Paises[2]);
        Pais.addItem(Paises[3]);
        Pais.addItem(Paises[4]);
        Pais.addItemListener(this);



        //intente usar change itemStateChanged, pero no conseguí generar los cambios. he pensado en borrarlos cada vez que se cambiaran de
        //seleccion pero sin resultado.
        paisecogido = (String) Pais.getItemAt(Pais.getSelectedIndex());
        System.out.println(paisecogido);
        if (paisecogido.equals("España")) {
            //estas son las provincias definidas
            Provincia = new JComboBox();
            Provincia.setBounds(450, 65, 90, 20);

            add(Provincia);
            Provincia.addItem("Madrid");
            Provincia.addItem("Barcelona");
            Provincia.addItem("Valencia");
            Provincia.addItemListener(this);
        }
    }

    private void intitCheckBox() {
        //Los checkBox no ayudan a definir cuantos idiomas conoce el individuo
        Castellano = new JCheckBox("Castellano");
        Castellano.setBounds(430, 160, 90, 30);
        Castellano.setBackground(Color.WHITE);
        add(Castellano);

        Ingles = new JCheckBox("Inglés");
        Ingles.setBounds(520, 160, 70, 30);
        Ingles.setBackground(Color.WHITE);
        add(Ingles);

        Frances = new JCheckBox("Frances");
        Frances.setBounds(590, 160, 90, 30);
        Frances.setBackground(Color.WHITE);
        add(Frances);

        Mas = new JCheckBox("Otros");
        Mas.setBounds(680, 160, 90, 30);
        Mas.setBackground(Color.WHITE);
        add(Mas);
        Mas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Otroidioma = new JTextField("");
                add(Otroidioma);
                Otroidioma.setBounds(6800,300,100,30);
                Otroidioma.setOpaque(true);
                Otroidioma.setBackground(Color.WHITE);
                Otroidioma.setBorder(new LineBorder(Color.DARK_GRAY));
                Otroidioma.setForeground(Color.BLACK);


            }
        });
    }

    public static void main(String[] args) {
        new Formulario();
    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }
}
