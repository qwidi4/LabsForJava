package programming.lab2;

import com.sun.tools.javac.Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.xml.transform.Result;


@SuppressWarnings("serial")
public class MainFrame extends JFrame{

    private static final int Width = 840;  //ширина окна
    private static final int Height = 700; //высота окна
    double result, sum;

    private JTextField meaning_x;  //значение x
    private JTextField meaning_y; //значение y
    private JTextField meaning_z; //значение z

    private JTextField textFieldResult; //значение результата

    private ButtonGroup radioButtons = new ButtonGroup(); //группа радиокнопок

    private Box  HBoxFormulaType = Box.createHorizontalBox(); //контейнер для отображения кнопок

    private int FormulaNumber = 1; //переменная для выбора номера формулы



    public double CalculateFormula1(Double x, Double y, Double z){  //метод для расчёта первой формулы
        return (Math.sin(Math.PI*y*y*y)+Math.log(y*y))/(Math.sin(Math.PI*z*z)+Math.sin(x)+Math.log(z*z)+x*x+Math.pow(Math.E,Math.cos(x*z)));
    }

    public double CalculateFormula2(Double x, Double y, Double z){  //етод для расчёта второй формулы
        return y*x*x/(Math.log(Math.pow(z,y) + Math.pow(Math.cos(Math.cbrt(x)), 2)));
    }

    private void AddRadioButton(String ButtonName, final int FormulaNumber) { //создание метода который добавляет радиокнопки
        JRadioButton button = new JRadioButton(ButtonName); //создаём экземпляр радиокнопки с заданным текстом

        button.addActionListener(ev -> MainFrame.this.FormulaNumber = FormulaNumber); //создаём обработчик, который будет будет устанавливать индификатор выбранной формулы равным FormulaNimber

        radioButtons.add(button); //добавили кнопку в группу
        HBoxFormulaType.add(button); //добавили кнопку в контейнер

    }

    public MainFrame() {
        super("Вычисление формулы");  //заголовок окна
        setSize(Width, Height); //размеры окна
        Toolkit kit = Toolkit.getDefaultToolkit();                                                            //// Центрировать окно приложения на экране
        setLocation((kit.getScreenSize().width - WIDTH) / 2, (kit.getScreenSize().height - HEIGHT) / 2);
        Box HBoxVariables = Box.createHorizontalBox();



        HBoxFormulaType.add(Box.createHorizontalGlue()); // Добавить «клей» C1-H1 с левой стороны
        AddRadioButton("Формула 1", 1); // Создать радио-кнопку для формулы 1
        AddRadioButton("Формула 2", 2); // Создать радио-кнопку для формулы 2
        radioButtons.setSelected(radioButtons.getElements().nextElement().getModel(), true); // Установить выделенной 1-ую кнопку из группы
        HBoxFormulaType.add(Box.createHorizontalGlue()); // Добавить «клей» C1-H2 с правой стороны
        HBoxVariables.setBorder(BorderFactory.createLineBorder(Color.YELLOW)); // Задать рамку для коробки с помощью класса BorderFactory

        JLabel LabelForX = new JLabel("X:"); //Создать подпись “X:” для переменной X
        meaning_x = new JTextField("0", 10); // для значения x стоит 0 по умолчанию
        meaning_x.setMaximumSize(meaning_x.getPreferredSize()); // Установить макс размер = желаемому для предотвращения масштабирования

        JLabel LabelForY = new JLabel("Y:"); //Создать подпись “Y:” для переменной Y
        meaning_y = new JTextField("0", 10); // для значения y стоит 0 по умолчанию
        meaning_y.setMaximumSize(meaning_y.getPreferredSize()); // Установить макс размер = желаемому для предотвращения масштабирования

        JLabel LabelForZ = new JLabel("Z:"); //Создать подпись “Z:” для переменной z
        meaning_z = new JTextField("0", 10); // для значения y стоит 0 по умолчанию
        meaning_z.setMaximumSize(meaning_z.getPreferredSize()); // Установить макс размер = желаемому для предотвращения масштабирования


        Box hboxVariables = Box.createHorizontalBox(); // Создать контейнер «коробка с горизонтальной укладкой»
        hboxVariables.add(Box.createHorizontalGlue()); // Добавить в контейнер ряд объектов: Добавить «клей» C2-H1 – для максимального удаления от левого края
        hboxVariables.add(LabelForX); // Добавить подпись для переменной Х
        hboxVariables.add(Box.createHorizontalStrut(10)); // Добавить «распорку» C2-H2 шириной 10 пикселов для отступа между надписью и текстовым полем для ввода значения X
        hboxVariables.add(meaning_x); // Добавить само текстовое поле для ввода Х
        hboxVariables.add(Box.createHorizontalStrut(100)); // Добавить «распорку» C2-H3 шириной 100 пикселов для отступа между текстовым полем для ввода X и подписью для Y
        hboxVariables.add(LabelForY); // Добавить подпись для переменной Y
        hboxVariables.add(Box.createHorizontalStrut(10)); // Добавить «распорку» C2-H4 шириной 10 пикселов для отступа между надписью и текстовым полем для ввода значения Y
        hboxVariables.add(meaning_y); // Добавить само текстовое поле для ввода Y
        hboxVariables.add(Box.createHorizontalStrut(100)); // Добавить «распорку» C2-H3 шириной 100 пикселов для отступа между текстовым полем для ввода X и подписью для Y
        hboxVariables.add(LabelForZ); // Добавить подпись для переменной Z
        hboxVariables.add(Box.createHorizontalStrut(10)); // Добавить «распорку» C2-H4 шириной 10 пикселов для отступа между надписью и текстовым полем для ввода значения Y
        hboxVariables.add(meaning_z); // Добавить само текстовое поле для ввода Z
        hboxVariables.add(Box.createHorizontalGlue());// Добавить «клей» C2-H5 для максимального удаления от правого края


        JLabel labelForResult = new JLabel("Результат:"); // Создать подпись для поля с результатом
        textFieldResult = new JTextField("0", 10); // Создать текстовое поле для вывода результата, начальное значение - 0
        Box hboxResult = Box.createHorizontalBox(); // Создать контейнер «коробка с горизонтальной укладкой»
        hboxResult.add(Box.createHorizontalGlue()); // Добавить в контейнер ряд объектов добавить «клей» C3-H1 для отступа от левого края
        hboxResult.add(labelForResult); // Добавить подпись для результата
        hboxResult.add(Box.createHorizontalStrut(10)); // Добавить «распорку» C3-H2 в 10 пикселов между подписью и полем результата
        hboxResult.add(textFieldResult); // Добавить текстовое поле для вывода результата
        hboxResult.add(Box.createHorizontalGlue()); // Добавить «клей» C3-H3 справа
        hboxResult.setBorder(BorderFactory.createLineBorder(Color.BLUE)); // Задать рамку для контейнера



        JButton buttonCalc = new JButton("Вычислить"); // Создать кнопку «Вычислить»

        buttonCalc.addActionListener(new ActionListener() { // Определить и зарегистрировать обработчик нажатия на кнопку
            public void actionPerformed(ActionEvent ev) {

                try {   // Преобразование введенных строк в числа с плавающей точкой может спровоцировать исключительную ситуацию при неправильном формате чисел, поэтому необходим блок try-catch
                    Double x = Double.parseDouble(meaning_x.getText()); // Получить значение X

                    Double y = Double.parseDouble(meaning_y.getText()); // Получить значение Y

                    Double z = Double.parseDouble(meaning_z.getText()); // Получить значение Y
                    if (FormulaNumber==1) // Вычислить результат
                        result = CalculateFormula1 (x, y, z);
                    else
                        result = CalculateFormula2(x, y, z);

                    String str = String.format("%f", result);
                    textFieldResult.setText(str); // Установить текст надписи равным результату
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MainFrame.this, "Ошибка в формате записи числа с плавающей точкой", "Ошибочный формат числа", JOptionPane.WARNING_MESSAGE); // В случае исключительной ситуации показать сообщение
                }
            }
        });

        JButton buttonReset = new JButton("Очистить поля"); // Создать кнопку «Очистить поля»

        buttonReset.addActionListener(new ActionListener() { // Определить и зарегистрировать обработчик нажатия на кнопку
            public void actionPerformed(ActionEvent ev) {
                meaning_x.setText("0");
                meaning_y.setText("0");
                meaning_z.setText("0");
            }

        });

        JButton buttonM = new JButton("M+");

        buttonM.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent ev){
               sum = sum + result;

               String str = String.format("%f", sum);
               textFieldResult.setText("SumRez = " + str);
           }
        });

        JButton buttonMC = new JButton("MC");

        buttonMC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev){
                sum = 0;

                String str = String.format("%f", sum);
                textFieldResult.setText(str);
            }
        });

        Box hboxButtons = Box.createHorizontalBox(); // Создать коробку с горизонтальной укладкой
        hboxButtons.add(Box.createHorizontalGlue()); // Добавить «клей» C4-H1 с левой стороны
        hboxButtons.add(buttonCalc); // Добавить кнопку «Вычислить» в компоновку
        hboxButtons.add(Box.createHorizontalStrut(30)); // Добавить распорку в 30 пикселов C4-H2 между кнопками
        hboxButtons.add(buttonReset); // Добавить кнопку «Очистить поля» в компоновку
        hboxButtons.add(Box.createHorizontalStrut(30)); // Добавить распорку в 30 пикселов C4-H2 между кнопками
        hboxButtons.add(buttonM); // Добавить кнопку «М+» в компоновку
        hboxButtons.add(Box.createHorizontalStrut(30)); // Добавить распорку в 30 пикселов C4-H2 между кнопками
        hboxButtons.add(buttonMC); // Добавить кнопку «МС» в компоновку
        hboxButtons.add(Box.createHorizontalGlue()); // Добавить «клей» C4-H3 с правой стороны
        hboxButtons.setBorder(BorderFactory.createLineBorder(Color.GREEN)); // Задать рамку для контейнера


        Box contentBox = Box.createVerticalBox(); // Создать контейнер «коробка с вертикальной укладкой»
        contentBox.add(Box.createVerticalGlue()); // Добавить «клей» V1 сверху
        contentBox.add(HBoxFormulaType); // Добавить контейнер с выбором формулы
        contentBox.add(hboxVariables); // Добавить контейнер с переменными
        contentBox.add(hboxResult); // Добавить контейнер с результатом вычислений
        contentBox.add(hboxButtons); // Добавить контейнер с кнопками
        contentBox.add(Box.createVerticalGlue()); // Добавить «клей» V2 снизу
        getContentPane().add(contentBox, BorderLayout.CENTER); // Установить «вертикальную коробку» в область содержания главного окна
    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}




