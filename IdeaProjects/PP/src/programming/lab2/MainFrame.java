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

    private static final int WIDTH = 800;
    private static final int HEIGHT = 400;
    double result, sum;

    private JTextField textFieldX;  //значение x
    private JTextField textFieldY;  //занчение y
    private JTextField textFieldZ;  //значение z

    private JTextField textFieldResult; //значение результата
    private JTextField Memory;

    private ButtonGroup radioButtons = new ButtonGroup();   //группа радиокнопок

    private Box HBoxFormulaType = Box.createHorizontalBox();    //контейнер для отображения кнопок
    private int formulaId = 1; //переменная для выбора номера формулы

    public Double calculate1(Double x, Double y, Double z) {
        return (Math.pow(Math.cos(Math.PI * x * x * x) + Math.pow(Math.log(1 + y), 2), 1 / 4) * Math.pow(2.718, Math.pow(z, 2)) + Math.sqrt(1 / x) + Math.cos(Math.pow(2.781, y)));
    }

    public Double calculate2(Double x, Double y, Double z) {
        return ((Math.pow(x, x)) / (Math.sqrt(y * y * y + 1) + Math.log(z)));
    }

    private void addRadioButton(String ButtonName, final int formulaId) {  //создание метода который добавляет радиокнопки
        JRadioButton button = new JRadioButton(ButtonName); //создаём экземпляр радиокнопки с заданным текстом
        button.addActionListener(ev -> MainFrame.this.formulaId = formulaId);    //создаём обработчик, который будет будет устанавливать индификатор выбранной формулы равным formulaId
        radioButtons.add(button);   //добавили кнопку в группу
        HBoxFormulaType.add(button);    //добавили кнопку в контейнер
    }

    public MainFrame() {
        super("Вычисление формулы");    //заголовок окна
        setSize(WIDTH, HEIGHT); //размеры окна
        Toolkit kit = Toolkit.getDefaultToolkit();   //получение инфы от ОС
        //центрировать окно приложения на экране
        setLocation((kit.getScreenSize().width - WIDTH) / 2,
                (kit.getScreenSize().height - HEIGHT) / 2);
        Box HBoxVariables = Box.createHorizontalBox();


        HBoxFormulaType.add(Box.createHorizontalGlue()); // Добавить «клей» C1-H1 с левой стороны
        addRadioButton("Формула 1", 1); // Создать радио-кнопку для формулы 1
        addRadioButton("Формула 2", 2); // Создать радио-кнопку для формулы 2
        radioButtons.setSelected(radioButtons.getElements().nextElement().getModel(), true); // Установить выделенной 1-ую кнопку из группы
        HBoxFormulaType.add(Box.createHorizontalGlue()); // Добавить «клей» C1-H2 с правой стороны
        HBoxVariables.setBorder(BorderFactory.createLineBorder(Color.GREEN)); // Задать рамку для коробки с помощью класса BorderFactory


        JLabel LabelForX = new JLabel("X:"); //Создать подпись “X:” для переменной X
        textFieldX = new JTextField("0", 10); // для значения x стоит 0 по умолчанию
        textFieldX.setMaximumSize(textFieldX.getPreferredSize()); // Установить макс размер = желаемому для предотвращения масштабирования

        JLabel LabelForY = new JLabel("Y:"); //Создать подпись “Y:” для переменной Y
        textFieldY = new JTextField("0", 10); // для значения y стоит 0 по умолчанию
        textFieldY.setMaximumSize(textFieldY.getPreferredSize()); // Установить макс размер = желаемому для предотвращения масштабирования

        JLabel LabelForZ = new JLabel("Z:"); //Создать подпись “Z:” для переменной z
        textFieldZ = new JTextField("0", 10); // для значения y стоит 0 по умолчанию
        textFieldZ.setMaximumSize(textFieldZ.getPreferredSize()); // Установить макс размер = желаемому для предотвращения масштабирования

        Box hboxVariables = Box.createHorizontalBox(); // Создать контейнер «коробка с горизонтальной укладкой»



        hboxVariables.add(LabelForX); // Добавить подпись для переменной Х
        hboxVariables.add(Box.createHorizontalStrut(10)); // Добавить «распорку» C2-H2 шириной 10 пикселов для отступа между надписью и текстовым полем для ввода значения X
        hboxVariables.add(textFieldX); // Добавить само текстовое поле для ввода Х
        hboxVariables.add(Box.createHorizontalGlue()); // Добавить в контейнер ряд объектов: Добавить «клей» C2-H1 – для максимального удаления от левого края
        hboxVariables.add(Box.createHorizontalStrut(100)); // Добавить «распорку» C2-H3 шириной 100 пикселов для отступа между текстовым полем для ввода X и подписью для Y
        hboxVariables.add(LabelForY); // Добавить подпись для переменной Y
        hboxVariables.add(Box.createHorizontalStrut(10)); // Добавить «распорку» C2-H4 шириной 10 пикселов для отступа между надписью и текстовым полем для ввода значения Y
        hboxVariables.add(textFieldY); // Добавить само текстовое поле для ввода Y
        hboxVariables.add(Box.createHorizontalGlue()); // Добавить в контейнер ряд объектов: Добавить «клей» C2-H1 – для максимального удаления от левого края
        hboxVariables.add(Box.createHorizontalStrut(100)); // Добавить «распорку» C2-H3 шириной 100 пикселов для отступа между текстовым полем для ввода X и подписью для Y
        hboxVariables.add(LabelForZ); // Добавить подпись для переменной Z
        hboxVariables.add(Box.createHorizontalStrut(10)); // Добавить «распорку» C2-H4 шириной 10 пикселов для отступа между надписью и текстовым полем для ввода значения Y
        hboxVariables.add(textFieldZ); // Добавить само текстовое поле для ввода Z



        JLabel labelForResult = new JLabel("Результат:"); // Создать подпись для поля с результатом
        textFieldResult = new JTextField("0", 10); // Создать текстовое поле для вывода результата, начальное значение - 0

        JLabel labelForMemory = new JLabel("Память суммы:"); // Создать подпись для поля с результатом
        Memory = new JTextField("0", 10); // Создать текстовое поле для вывода результата, начальное значение - 0

        Box hboxResult = Box.createHorizontalBox(); // Создать контейнер «коробка с горизонтальной укладкой»
        hboxResult.add(Box.createHorizontalStrut(100)); // Добавить в контейнер ряд объектов добавить «клей» C3-H1 для отступа от левого края
        hboxResult.add(labelForResult); // Добавить подпись для результата
        hboxResult.add(Box.createHorizontalStrut(10)); // Добавить «распорку» C3-H2 в 10 пикселов между подписью и полем результата
        hboxResult.add(textFieldResult); // Добавить текстовое поле для вывода результата
        hboxResult.add(Box.createHorizontalStrut(10)); // Добавить «распорку» C3-H2 в 10 пикселов между подписью и полем результата
        hboxResult.add(labelForMemory); // Добавить подпись для памяти
        hboxResult.add(Box.createHorizontalStrut(10)); // Добавить «распорку» C3-H2 в 10 пикселов между подписью и полем результата
        hboxResult.add(Memory); // Добавить текстовое поле для вывода памяти
        hboxResult.add(Box.createHorizontalStrut(150)); // Добавить «клей» C3-H3 справа
        hboxResult.setBorder(BorderFactory.createLineBorder(Color.BLUE)); // Задать рамку для контейнера


        JButton buttonCalc = new JButton("Вычислить"); // Создать кнопку «Вычислить»

        buttonCalc.addActionListener(new ActionListener() { // Определить и зарегистрировать обработчик нажатия на кнопку
            public void actionPerformed(ActionEvent ev) {

                try {   // Преобразование введенных строк в числа с плавающей точкой может спровоцировать исключительную ситуацию при неправильном формате чисел, поэтому необходим блок try-catch
                    Double x = Double.parseDouble(textFieldX.getText()); // Получить значение X

                    Double y = Double.parseDouble(textFieldY.getText()); // Получить значение Y

                    Double z = Double.parseDouble(textFieldZ.getText()); // Получить значение Y
                    if (formulaId == 1) // Вычислить результат
                        result = calculate1(x, y, z);
                    else
                        result = calculate2(x, y, z);

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
                textFieldX.setText("0");
                textFieldY.setText("0");
                textFieldZ.setText("0");
            }

        });

        JButton buttonM = new JButton("M+");

        buttonM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                sum = sum + result;

                String str = String.format("%f", sum);
                Memory.setText("SumRez = " + str);
            }
        });

        JButton buttonMC = new JButton("MC");

        buttonMC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                sum = 0;

                String str = String.format("%f", sum);
                Memory.setText(str);
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
        contentBox.add(Box.createVerticalStrut(30));


        contentBox.add(hboxVariables); // Добавить контейнер с переменными

        contentBox.add(Box.createVerticalGlue()); // Добавить «клей» V1 сверху
        contentBox.add(Box.createVerticalStrut(30));
        contentBox.add(Box.createVerticalGlue()); // Добавить «клей» V1 сверху
        contentBox.add(Box.createVerticalStrut(50));

        contentBox.add(hboxResult); // Добавить контейнер с результатом вычислений

        contentBox.add(Box.createVerticalGlue()); // Добавить «клей» V1 сверху
        contentBox.add(Box.createVerticalStrut(30));
        contentBox.add(Box.createVerticalGlue()); // Добавить «клей» V1 сверху
        contentBox.add(Box.createVerticalStrut(60));

        contentBox.add(hboxButtons); // Добавить контейнер с кнопками

        contentBox.add(Box.createVerticalGlue()); // Добавить «клей» V1 сверху
        contentBox.add(Box.createVerticalStrut(30));

        contentBox.add(HBoxFormulaType); // Добавить контейнер с выбором формулы

        contentBox.add(Box.createVerticalGlue()); // Добавить «клей» V2 снизу
        contentBox.add(Box.createVerticalStrut(30));

        getContentPane().add(contentBox, BorderLayout.CENTER); // Установить «вертикальную коробку» в область содержания главного окна
    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}




