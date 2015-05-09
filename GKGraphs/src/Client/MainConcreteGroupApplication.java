package Client;

import Client.Concrete.JungGraphConverterHelper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.*;
import edu.uci.ics.jung.visualization.decorators.EdgeShape;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.DefaultVertexLabelRenderer;
import edu.uci.ics.jung.visualization.renderers.Renderer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

/**
 * Основное приложение (GUI) для построения графов простых чисел конкретных простых групп.
 *
 * @author v.kolpakova
 */
public class MainConcreteGroupApplication extends JFrame {

    protected Map<Integer, Graph<?, ?>> g = Maps.newHashMap();
    protected ArrayList<BasicVisualizationServer<Object, Object>> vv;

    /** Файл с текстовыми элементами интерфейса */
    protected static Properties properties;

    /** Основная панель, в которой происходит отрисовка графов */
    protected JScrollPane scrollPane;
    /** Панель с окном ввода наименования группы и кнопками управления */
    protected JPanel upperPanel;
    /** Бокс для расположения радио-кнопок вертикально */
    protected Box verticalBox;
    /** Поле для ввода наименования группы */
    protected JTextField groupNameField;
    /** Элемент для обозначения поля {@link #groupNameField} в интерфейсе */
    protected JLabel groupNameLabel;
    /** Группа для радио-кнопок с выбором вида графа */
    protected static ButtonGroup radioGroup;
    /** Кнопка для построения графа */
    protected JButton okButton;
    /** Кнопка для сброса наименования группы и очистки формы с графами */
    protected JButton resetButton;
    /** Формирует ответное действие при нажатии на "ОК" */
    protected TextHandler handler = null;
    /** Радио-кнопка для построения ГПЧ группы */
    protected JRadioButton groupGraphRadio;
    /** Радио-кнопка для построения графа Inndiag группы */
    protected JRadioButton inndiagGraphRadio;
    /** Радио-кнопка для построения графа расширения полевым автоморфизмом группы */
    protected JRadioButton fieldAutGraphRadio;
    /** Радио-кнопка для построения графа расширения графовым автоморфизмом группы */
    protected JRadioButton graphAutGraphRadio;

    protected static final String EMPTY_STRING = "";
    protected static final String GROUP_RADIO_AC = "group";
    protected static final String INND_RADIO_AC = "inndiag";
    protected static final String FIELD_RADIO_AC = "field";
    protected static final String GRAPH_RADIO_AC = "graph";


    public MainConcreteGroupApplication() {
        super("Графы простых чисел");
        loadProperties();
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        initUpperPanel(container);
        initScrollPanel(container);
        initRightPanel(container);
        initGraphPanel(EMPTY_STRING);
        g = computeG(EMPTY_STRING);
        this.setSize(500, 500);
        this.setVisible(true);
    }

    private void initUpperPanel(Container container) {
        upperPanel = new JPanel();
        upperPanel.setLayout(new FlowLayout());
        container.add(upperPanel, BorderLayout.PAGE_START);
        initGroupNameLabel();
        initGroupNameField();
        initOkButton();
        initResetButton();
    }

    private void initGroupNameLabel() {
        groupNameLabel = new JLabel(loadPropertiesText("GROUP_NAME_LABEL_TEXT"));
        upperPanel.add(groupNameLabel);
    }

    private void initGroupNameField() {
        groupNameField = new JTextField(10);
        upperPanel.add(groupNameField);
        handler = new TextHandler();
        groupNameField.addActionListener(handler);
    }

    private class TextHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == groupNameField) {
                initGraphPanel(groupNameField.getText());
            }
        }

    }

    private void initOkButton() {
        okButton = new JButton(loadPropertiesText("OK_BUTTON_TEXT"));
        okButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (groupNameField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, loadPropertiesText("OK_BUTTON_EMPTY_ERROR_MESSAGE"),
                            loadPropertiesText("ERROR_MESSAGE"), JOptionPane.ERROR_MESSAGE);
                } else {
                    initGraphPanel(groupNameField.getText());
                }
            }

        });
        upperPanel.add(okButton);
    }

    private void initResetButton() {
        resetButton = new JButton(loadPropertiesText("RESET_BUTTON_TEXT"));
        resetButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                groupNameField.setText(EMPTY_STRING);
                if (vv != null) {
                    clearVv();
                }
            }

        });
        upperPanel.add(resetButton);
    }

    private void clearVv() {
        JPanel view = (JPanel)scrollPane.getViewport().getView();
        if (view != null) {
            view.removeAll();
        } else {
            scrollPane.getViewport().removeAll();
        }
        vv = Lists.newArrayList();
        SwingUtilities.updateComponentTreeUI(scrollPane);
    }

    private void initScrollPanel(Container container) {
        scrollPane = new JScrollPane(new JPanel());
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setSize(new Dimension(350, 350));
        container.add(scrollPane, BorderLayout.CENTER);
        vv = Lists.newArrayList();
        for (BasicVisualizationServer<?, ?> v : vv) {
            scrollPane.getViewport().add(v);
        }
    }

    private void initGraphPanel(String groupName) {
        // The Layout<V, E> is parametrized by the vertex and edge types
        this.g = computeG(groupName);
        if (vv != null) {
            // нужно, чтобы поле с графом очистилось перед построением нового.
            // по-нормальному не получается обновлять значение пересчитанного графа, поэтому удаляем и создаем новые компоненты.
            clearVv();
        }
        initVisualizationServer();
        SwingUtilities.updateComponentTreeUI(upperPanel);
    }

    protected void initVisualizationServer() {
        for (Integer key : this.g.keySet()) {
            CircleLayout<Object, Object> layout = (CircleLayout<Object, Object>) new CircleLayout<>(this.g.get(key));
            layout.setSize(new Dimension(300, 300));
            BasicVisualizationServer<Object, Object> newV = new BasicVisualizationServer<>(layout);
            newV.setPreferredSize(new Dimension(350, 350)); //Sets the viewing area size
            //newV.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller<>());
            newV.getRenderContext().setEdgeShapeTransformer(new EdgeShape.Line<>());
            newV.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<>());
            newV.getRenderContext().setVertexLabelRenderer(new DefaultVertexLabelRenderer(Color.WHITE));
            newV.getRenderer().getVertexLabelRenderer().setPosition(Renderer.VertexLabel.Position.S);
            if (!key.equals(1)) {
                String rc = radioGroup.getSelection().getActionCommand();
                String beginLabel = EMPTY_STRING;
                switch (rc) {
                    case FIELD_RADIO_AC : beginLabel = loadPropertiesText("FIELD_AUT_ORDER_LABEL");
                        break;
                    case GRAPH_RADIO_AC : beginLabel = loadPropertiesText("GRAPH_AUT_ORDER_LABEL");
                        break;
                }
                newV.add(new JLabel(beginLabel + key.toString()));
            }
            vv.add(newV);
        }
        for (BasicVisualizationServer<?, ?> v : vv) {
            JPanel view = ((JPanel)scrollPane.getViewport().getView());
            if (view != null) { // на этапе инициализации тут null
                view.add(v);
            } else {
                scrollPane.getViewport().add(v);
            }
        }
    }

    protected static Map<Integer, Graph<?, ?>> computeG(String groupName) {
        Map<Integer, Graph<?, ?>> g = Maps.newHashMap();
        String rc = radioGroup.getSelection().getActionCommand();
        switch (rc) {
            case GROUP_RADIO_AC : g = JungGraphConverterHelper.convertConcreteLieTypeGroupGraph(groupName);
                break;
            case INND_RADIO_AC : g = JungGraphConverterHelper.convertConcreteInndiagLieTypeGroupGraph(groupName);
                break;
            case FIELD_RADIO_AC : g = JungGraphConverterHelper.convertConcreteFieldAutLieTypeGroupGraph(groupName);
                break;
            case GRAPH_RADIO_AC : g = JungGraphConverterHelper.convertConcreteGammaAutLieTypeGroupGraph(groupName);
                break;
        }
        return g;
    }

    private void initRightPanel(Container container) {
        verticalBox = Box.createVerticalBox();
        radioGroup = new ButtonGroup();
        groupGraphRadio = new JRadioButton(loadPropertiesText("GROUP_RADIO_TEXT"));
        groupGraphRadio.setActionCommand(GROUP_RADIO_AC);
        groupGraphRadio.setSelected(true);
        inndiagGraphRadio = new JRadioButton(loadPropertiesText("INND_RADIO_TEXT"));
        inndiagGraphRadio.setActionCommand(INND_RADIO_AC);
        fieldAutGraphRadio = new JRadioButton(loadPropertiesText("FIELD_RADIO_TEXT"));
        fieldAutGraphRadio.setActionCommand(FIELD_RADIO_AC);
        graphAutGraphRadio = new JRadioButton(loadPropertiesText("GRAPH_RADIO_TEXT"));
        graphAutGraphRadio.setActionCommand(GRAPH_RADIO_AC);
        radioGroup.add(groupGraphRadio);
        radioGroup.add(inndiagGraphRadio);
        radioGroup.add(fieldAutGraphRadio);
        radioGroup.add(graphAutGraphRadio);
        verticalBox.add(groupGraphRadio);
        verticalBox.add(inndiagGraphRadio);
        verticalBox.add(fieldAutGraphRadio);
        verticalBox.add(graphAutGraphRadio);
        container.add(verticalBox, BorderLayout.LINE_END);
    }

    private String loadPropertiesText(String code) {
        return properties.get(code).toString();
    }

    private void loadProperties() {
        properties = new Properties();
        String fileName = "application.properties";
        try {
            properties.load(new InputStreamReader(getClass().getResourceAsStream(fileName), "windows-1251"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        MainConcreteGroupApplication test = new MainConcreteGroupApplication();
        test.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}