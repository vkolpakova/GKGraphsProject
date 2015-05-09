package Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Класс основного приложения
 * TODO вынести текст в properties
 * Created by v.kolpakova on 08.05.2015.
 */
public class MainApplication extends JFrame {

    protected JLabel label;

    protected static ButtonGroup selectionButtonGroup;
    protected Box verticalBox;
    protected JRadioButton concreteButton;
    protected JRadioButton seriesButton;

    private static final String AC_CONCRETE = "concrete";
    private static final String AC_SERIES = "series";

    protected JPanel downPanel;
    protected JButton okButton;

    public MainApplication() {
        // TODO проблема с кодировкой
        super("Графы простых чисел");
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        label = new JLabel("Choose type of group:");
        container.add(label, BorderLayout.NORTH);
        initButtonGroup(container);
        initDownPanel(container);
        this.setSize(500, 500);
        this.setVisible(true);
    }

    private void initButtonGroup(Container container) {
        selectionButtonGroup = new ButtonGroup();
        verticalBox = Box.createVerticalBox();
        concreteButton = new JRadioButton("Concrete");
        concreteButton.setActionCommand(AC_CONCRETE);
        seriesButton = new JRadioButton("Series");
        seriesButton.setActionCommand(AC_SERIES);
        selectionButtonGroup.add(concreteButton);
        selectionButtonGroup.add(seriesButton);
        verticalBox.add(concreteButton);
        verticalBox.add(seriesButton);
        container.add(verticalBox, BorderLayout.CENTER);
    }

    private void initDownPanel(Container container) {
        downPanel = new JPanel();
        downPanel.setLayout(new FlowLayout());
        okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonModel selection = selectionButtonGroup.getSelection();
                if (selection == null) {
                    // TODO оформить окно в стиле ошибки
                    JOptionPane.showMessageDialog(null, "Error! Choose anything");
                }
                switch (selection.getActionCommand()) { // TODO переделать
                    case AC_CONCRETE : new MainConcreteGroupApplication();
                        break;
                    case AC_SERIES : new MainSeriesApplication();
                        break;
                }
            }

        });
        downPanel.add(okButton);
        container.add(downPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        MainApplication ma = new MainApplication();
        ma.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
