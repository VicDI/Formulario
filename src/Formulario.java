import org.w3c.dom.Text;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.html.HTMLEditorKit;
import java.awt.*;
import java.awt.event.*;

public class Formulario extends JFrame  implements ChangeListener, ItemListener {

    JLabel [] datos = new JLabel[14];
    JTextField [] TextField = new JTextField[8];
    JTextField Otroidioma;
    String [] Paises ={"España","Francia","Belgica","Alemania","Portugal"};
    String [] TextoLabel ={"Nombre:","Apellido:","Dirección:","Teléfono:","CP:","NIF:","Email:","Contraseña:","Pais:","Provincia:","Poblacion:","Sexo:","Idiomas:","CARTA DE PRESENTACIÓN"};
    int numLabels = 14;
    int numTextField = 8;
    int anchoLabel = 100;
    int altoLabel = 30;
    int anchoTextField = 120;
    int altoTextField = 20;
    int [] xLabels = {10,10,10,10,10,10,10,10,330,330,10,330,330,330};
    int [] yLabels = {10,60,210,260,160,310,110,360,10,60,410,110,160,250};
    int [] xTextField = {120,120,120,120,120,120,120,120};
    int [] yTextField = {15,65,215,265,165,315,115,415};

    char[] letraDni = {
            'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D',  'X',  'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'
    };

    JPasswordField contrasenia;
    JRadioButton Hombre,Mujer,Otros;
    ButtonGroup Sexo;
    JComboBox Pais,Provincia;
    JCheckBox Castellano, Ingles, Frances, Mas;
    JTextArea Carta_de_presesentación;
    JMenu Colores;
    JMenuItem AMARILLO, CYAN, ROJO, VERDE, Salir, Limpiar;
    JMenuBar menuBar;

    int ind;
    private JMenuBar menuBar1;
    private JMenu Fuentes;
    private JMenuItem a20,a25,a15,a10, a27;

    JTextPane ejecutado = new JTextPane();
    JButton generar;

    public Formulario() {

        initLabels();
        initTextField();
        initPasswordField();
        intitRadioButton();
        intitCheckBox();
        intitCombobox();
        initTextArea();
        initMenu();
        initButton();
        initTextPane();
        initPantalla();

    }




    private void initPantalla() {

        setLayout(null);
        setTitle("Formulario");
        setSize(450,510);
        setBackground(Color.GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.PINK);
        setVisible(true);
    }

    private void initPasswordField() {

        contrasenia = new JPasswordField();
        contrasenia.setBounds(120, 365, 150, 20);
        add(contrasenia);
    }

    public void initLabels(){

        for(int i = 0; i < numLabels; i++){
            datos[i] = new JLabel(TextoLabel[i]);
            int ancho = (i == 8 ||i == 11) ? 50 : anchoLabel;
            if (i == 13) ancho = 250;
            if (i == 7) ancho = 120;
            datos[i].setBounds(xLabels[i], yLabels[i], ancho, altoLabel);
            datos[i].setFont(new Font("Laguna7",Font.PLAIN,16));
            datos[i].setOpaque(true);
            datos[i].setBackground(Color.PINK);
            datos[i].setForeground(Color.BLACK);
            add(datos[i]);
        }
    }

    private void initTextField() {

        for(int i = 0; i < numTextField; i++){
            TextField[i] = new JTextField();
            TextField[i].setBounds(xTextField[i], yTextField[i], anchoTextField, altoTextField);
            TextField[i].setFont(new Font("Laguna7",Font.PLAIN,16));
            TextField[i].setOpaque(true);
            TextField[i].setBackground(Color.WHITE);
            TextField[i].setBorder(new LineBorder(Color.DARK_GRAY));
            TextField[i].setForeground(Color.BLACK);
            add(TextField[i]);
        }


        TextField[4].addKeyListener(new KeyAdapter(){

                                        public void keyTyped(KeyEvent e)

                                        {
                                            if (TextField[4].getText().length()== 5)

                                                e.consume();
                                        }
                                    }
        );

        TextField[3].addKeyListener(new KeyAdapter(){

                                        public void keyTyped(KeyEvent e)

                                        {
                                            if (TextField[3].getText().length()== 9)

                                                e.consume();
                                        }
                                    }
        );


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







        TextField[4].addKeyListener(new KeyAdapter() {
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




    private void intitRadioButton() {

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

        Castellano = new JCheckBox("Castellano");
        Castellano.setBounds(430, 160, 90, 30);
        Castellano.setBackground(Color.WHITE);
        add(Castellano);

        Ingles = new JCheckBox("Inglés");
        Ingles.setBounds(520, 160, 90, 30);
        Ingles.setBackground(Color.WHITE);
        add(Ingles);

        Frances = new JCheckBox("Frances");
        Frances.setBounds(590, 160, 90, 30);
        Frances.setBackground(Color.WHITE);
        add(Frances);

        Mas = new JCheckBox("Otros");
        Mas.setBounds(680, 160, 70, 30);
        Mas.setBackground(Color.WHITE);
        add(Mas);
        Mas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Otroidioma = new JTextField("");
                add(Otroidioma);
                Otroidioma.setBounds(430,210,100,23);
                Otroidioma.setOpaque(true);
                Otroidioma.setBackground(Color.WHITE);
                Otroidioma.setBorder(new LineBorder(Color.DARK_GRAY));
                Otroidioma.setForeground(Color.BLACK);


            }
        });
    }

    private void initTextArea() {

        Carta_de_presesentación = new JTextArea();
        Carta_de_presesentación.setBounds(330, 300, 400, 300);
        Carta_de_presesentación.setBorder(new LineBorder(Color.DARK_GRAY));
        Carta_de_presesentación.setLineWrap(true);
        add(Carta_de_presesentación);
    }

    private void initMenu() {

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        Colores = new JMenu("Colores");
        menuBar.add(Colores);


        AMARILLO = new JMenuItem("AMARILLO");
        Colores.add(AMARILLO);

        CYAN = new JMenuItem("CYAN");
        Colores.add(CYAN);

        ROJO = new JMenuItem("ROJO");
        Colores.add(ROJO);

        VERDE = new JMenuItem("VERDE");
        Colores.add(VERDE);



        AMARILLO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().setBackground(Color.YELLOW);
                for (int i = 0; i < 14; i++) {
                    datos[i].setBackground(Color.yellow);
                    Castellano.setBackground(Color.yellow);
                    Ingles.setBackground(Color.yellow);
                    Frances.setBackground(Color.yellow);
                    Mas.setBackground(Color.yellow);
                }
            }

        });
        CYAN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 14; i++) {
                    getContentPane().setBackground(Color.CYAN);
                    datos[i].setBackground(Color.CYAN);
                    Castellano.setBackground(Color.cyan);
                    Ingles.setBackground(Color.cyan);
                    Frances.setBackground(Color.cyan);
                    Mas.setBackground(Color.cyan);
                }
            }
        });
        ROJO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().setBackground(Color.RED);
                for (int i = 0; i < 14; i++) {
                    datos[i].setBackground(Color.RED);

                    Castellano.setBackground(Color.red);
                    Ingles.setBackground(Color.red);
                    Frances.setBackground(Color.red);
                    Mas.setBackground(Color.red);
                }
            }
        });
        VERDE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().setBackground(Color.GREEN);
                for (int i = 0; i < 14; i++) {
                    datos[i].setBackground(Color.GREEN);

                }
            }
        });








        Fuentes = new JMenu("Tamaño");
        menuBar.add(Fuentes);

        a20 = new JMenuItem("20");
        Fuentes.add(a20);

        a25 = new JMenuItem("18");
        Fuentes.add(a25);

        a15 = new JMenuItem("15");
        Fuentes.add(a15);


        a10 = new JMenuItem("10");
        Fuentes.add(a10);



        a27 = new JMenuItem("8");
        Fuentes.add(a27);


        Limpiar = new JMenuItem("Limpiar");
        menuBar.add(Limpiar);


        Salir = new JMenuItem("Salir");
        menuBar.add(Salir);



        Limpiar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                for(int i = 0; i < numTextField; i++){
                    TextField[i] = new JTextField();

                    TextField[i].setText("");

                    add(TextField[i]);
                }


            }

        });


        Salir.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }

        });


        a20.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < 14; i++) {
                    datos[i].setFont(new Font("Monospaced", Font.PLAIN, 17));
                    contrasenia.setFont(new Font("Monospaced", Font.PLAIN, 17));


                }
            }
        });

        a25.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < 14; i++) {
                    datos[i].setFont(new Font("Monospaced", Font.PLAIN, 16));
                    contrasenia.setFont(new Font("Monospaced", Font.PLAIN, 16));


                }
            }
        });

        a27.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < 14; i++) {
                    datos[i].setFont(new Font("Monospaced", Font.PLAIN, 8));
                    contrasenia.setFont(new Font("Monospaced", Font.PLAIN, 8));


                }
            }
        });

        a10.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < 14; i++) {
                    datos[i].setFont(new Font("Monospaced", Font.PLAIN, 10));
                    contrasenia.setFont(new Font("Monospaced", Font.PLAIN, 10));


                }
            }
        });

        a15.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < 14; i++) {
                    datos[i].setFont(new Font("Monospaced", Font.PLAIN, 15));
                    contrasenia.setFont(new Font("Monospaced", Font.PLAIN, 15));


                }
            }
        });







    }



    private void initButton() {

        generar = new JButton("GENERAR FORMULARIO");
        generar.setBounds(420, 630, 200, 100);
        generar.setFont(new Font("Monospaced", Font.PLAIN, 16));
        generar.setOpaque(true);
        generar.setBackground(Color.WHITE);
        generar.setBorder(new LineBorder(Color.DARK_GRAY));
        generar.setForeground(Color.BLACK);
        generar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == generar) {
                    ejecutado.setVisible(true);
                    String sexo;
                    String numero_idiomas = "";
                    if (Hombre.isSelected()) {
                        sexo = "Hombre";
                    } else if (Mujer.isSelected()) {
                        sexo = "Mujer";
                    } else {
                        sexo = "Otro";
                    }
                    if (Castellano.isSelected()) {
                        numero_idiomas = numero_idiomas + "Castelllano";
                    }
                    if (Frances.isSelected()) {
                        numero_idiomas = numero_idiomas + " Frances";
                    }
                    if (Ingles.isSelected()) {
                        numero_idiomas = numero_idiomas + " Inglés";
                    }
                    if (Mas.isSelected()) {
                        numero_idiomas = numero_idiomas + Otroidioma.getText() ;
                    }
                    ejecutado.setText(

                            "<span style='margin-left:50px;'>&nbsp;&nbsp;" +

                                    "<br>Nombre:  " +TextField[0].getText() + "<br>"+
                                    "<br>Apellido:  " +TextField[1].getText() + "<br>"+
                                    "<br>Dirección:  " +TextField[2].getText() + "<br>"+
                                    "<br>Teléfono:  " +TextField[3].getText() + "<br>"+
                                    "<br>CP:  " +TextField[4].getText() + "<br>"+
                                    "<br>NIF:  " +TextField[5].getText() + "<br>"+
                                    "<br>Contraseña:  " +TextField[6].getText() + "<br>"+
                                    "<br>Contraseña:  " +contrasenia.getText() + "<br>"+
                                    "<br>Pais:  " + Pais.getItemAt(Pais.getSelectedIndex()) + "<br>"+
                                    "<br>Provincia:  " + Provincia.getItemAt(Provincia.getSelectedIndex()) + "<br>"+
                                    "<br>Población:  " + TextField[7].getText() + "<br>"+
                                    "<br>Sexo  " + sexo + "<br>"+
                                    "<br>Idiomas:  " + numero_idiomas + "<br>"+
                                    "<br>Idiomas:  " + Carta_de_presesentación.getText().replaceAll("\n", "<br>")  + "<br>"



                    );
                }
            }
        });
        add(generar);
    }

    private void initTextPane() {

        ejecutado.setBounds(800, 10, 400, 650);
        ejecutado.setBorder(new LineBorder(Color.DARK_GRAY));
        ejecutado.setVisible(false);
        add(ejecutado);
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        ejecutado.setEditorKit(htmlEditorKit);

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