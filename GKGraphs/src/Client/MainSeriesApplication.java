package Client;

import Client.Series.JungSeriesConverterHelper;
import Client.Util.GUIUtils;
import Logic.Series.ASeries.A1.A1Series;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.EdgeShape;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

/**
 * Компонента построения графов для серий
 * TODO вынести текст в properties
 * Created by v.kolpakova on 08.05.2015.
 */
public class MainSeriesApplication extends JFrame {

    protected Map<Integer, Graph<?, ?>> g = Maps.newHashMap();
    protected ArrayList<BasicVisualizationServer<Object, Object>> vv;

    /** Файл с текстовыми элементами интерфейса */
    protected static Properties properties;

    /** Первоначальная панель с выбором серии */
    protected JPanel initPanel;
    protected JLabel selectSeriesLabel;
    protected static ButtonGroup seriesGroup;
    protected Box seriesRadioBox;
    protected JButton initOkButton;

    protected JRadioButton aSeries;
    protected JRadioButton _aSeries;
    protected JRadioButton cSeries;
    protected JRadioButton gSeries;
    protected JRadioButton szSeries;
    protected static final String AC_A = "a";
    protected static final String AC__A = "_a";
    protected static final String AC_C = "c";
    protected static final String AC_G = "g";
    protected static final String AC_SZ = "sz";

    /** Панель выбора серии A */
    protected JPanel aInitPanel;
    protected static ButtonGroup aSeriesGroup;
    protected Box aSeriesBox;
    protected JButton aOkButton;

    protected JRadioButton a1Series;
    protected JRadioButton a2Series;
    protected JRadioButton a3Series;
    protected static final String AC_A1 = "a1";
    protected static final String AC_A2 = "a2";
    protected static final String AC_A3 = "a3";

    /** Панель ввода характеристики поля для серии типа A */
    protected JPanel aCharInitPanel;
    protected JLabel aCharLabel;
    protected JTextField aCharText;
    protected JButton aCharOkButton;

    /** Панель выбора серии _A */
    protected JPanel _aInitPanel;
    protected static ButtonGroup _aSeriesGroup;
    protected Box _aSeriesBox;
    protected JButton _aOkButton;

    protected JRadioButton _a2Series;
    protected JRadioButton _a3Series;
    protected static final String AC__A2 = "_a2";
    protected static final String AC__A3 = "_a3";

    /** Map для хранения текстовых полей с описанием группы */
    protected Map<String, JTextField> elementMap;

    /** Наименование группы (формат: Класс_ранг)*/
    private String name;
    /** Мощность поля */
    private String characteristic;

    /** Основная панель, в которой происходит отрисовка графов */
    protected JScrollPane scrollPane;
    /** Панель с окном ввода наименования группы и кнопками управления */
    protected JPanel upperPanel;
    /** Бокс для расположения радио-кнопок вертикально */
    protected Box verticalBox;
    /** Группа для радио-кнопок с выбором вида графа */
    protected static ButtonGroup radioGroup;
    /** Кнопка для построения графа */
    protected JButton okButton;
    /** Кнопка для сброса наименования группы и очистки формы с графами */
    protected JButton resetButton;
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

    private static final String TITLE = "Графы простых чисел";


    public MainSeriesApplication() {
        super(TITLE);
        loadProperties();
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        elementMap = Maps.newHashMap();
        initInitPanel(container);
        this.setSize(500, 500);
        this.setVisible(true);
    }

    private void initGraphPanel(Container container, JPanel up) {
        container.removeAll();
        initUpperPanel(container, up);
        initScrollPanel(container);
        initRightPanel(container);
        initGraphPanel(EMPTY_STRING);
        g = computeG(EMPTY_STRING);
        SwingUtilities.updateComponentTreeUI(container);
    }

    private void initInitPanel(final Container container) {
        initPanel = new JPanel();
        initPanel.setLayout(new BorderLayout());
        seriesRadioBox = Box.createVerticalBox();
        seriesGroup = new ButtonGroup();
        selectSeriesLabel = new JLabel("Выберете тип серии");
        aSeries = new JRadioButton("L_n(q)");
        aSeries.setActionCommand(AC_A);
        _aSeries = new JRadioButton("U_n(q)");
        _aSeries.setActionCommand(AC__A);
        cSeries = new JRadioButton("B_n(q)");
        cSeries.setActionCommand(AC_C);
        gSeries = new JRadioButton("G_n(q)");
        gSeries.setActionCommand(AC_G);
        szSeries = new JRadioButton("Sz(q)");
        szSeries.setActionCommand(AC_SZ);
        GUIUtils.multiAdditionToBox(seriesRadioBox, aSeries, _aSeries, cSeries, gSeries, szSeries);
        GUIUtils.multiAdditionToGroup(seriesGroup, aSeries, _aSeries, cSeries, gSeries, szSeries);
        initOkButton = new JButton("OK");
        initOkButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (seriesGroup.getSelection() == null) {
                    // TODO оформить окно в стиле ошибки
                    JOptionPane.showMessageDialog(null, "Выберете что-нибудь");
                } else {
                    switch (seriesGroup.getSelection().getActionCommand()) {
                        case AC_A:
                            initASeriesInitPanel(container);
                            break;
                        case AC__A:
                            init_ASeriesInitPanel(container);
                            break;
                    }
                }
            }

        });
        initPanel.add(selectSeriesLabel, BorderLayout.NORTH);
        initPanel.add(seriesRadioBox, BorderLayout.CENTER);
        initPanel.add(initOkButton, BorderLayout.SOUTH);
        container.add(initPanel);
    }

    private void initASeriesInitPanel(final Container container) {
        aInitPanel = new JPanel();
        aInitPanel.setLayout(new BorderLayout());
        aSeriesBox = Box.createVerticalBox();
        aSeriesGroup = new ButtonGroup();
        a1Series = new JRadioButton("L_2(q)");
        a1Series.setActionCommand(AC_A1);
        a2Series = new JRadioButton("L_3(q)");
        a2Series.setActionCommand(AC_A2);
        a3Series = new JRadioButton("L_4(q)");
        a3Series.setActionCommand(AC_A3);
        GUIUtils.multiAdditionToBox(aSeriesBox, a1Series, a2Series, a3Series);
        GUIUtils.multiAdditionToGroup(aSeriesGroup, a1Series, a2Series, a3Series);
        aOkButton = new JButton("OK");
        aOkButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (aSeriesGroup.getSelection() == null) {
                    JOptionPane.showMessageDialog(null, "Выберете что-нибудь");
                } else {
                    switch (aSeriesGroup.getSelection().getActionCommand()) {
                        case AC_A1:
                            name = "A_1";
                            initASeriesCharInitPanel(container);
                            break;
                    } // TODO add logic
                }
            }

        });
        aInitPanel.add(selectSeriesLabel, BorderLayout.NORTH);
        aInitPanel.add(aSeriesBox, BorderLayout.CENTER);
        aInitPanel.add(aOkButton, BorderLayout.SOUTH);
        container.removeAll();
        container.add(aInitPanel);
        SwingUtilities.updateComponentTreeUI(container);
    }

    private void initASeriesCharInitPanel(final Container container) {
        aCharInitPanel = new JPanel();
        aCharInitPanel.setLayout(new FlowLayout());
        aCharLabel = new JLabel("Мощность поля");
        aCharText = new JTextField(10);
        aCharText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == aCharText) {
                    // TODO add logic
                }
            }
        });
        aCharOkButton = new JButton("OK");
        aCharOkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (aCharText.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Введите мощность поля");
                } else {
                    characteristic = aCharText.getText();
                    if (characteristic.startsWith("2")) {
                        initASeries2CharGraphPanel(container);
                    } else {
                        initASeriesPCharGraphPanel(container);
                    }
                }
            }
        });
        aCharInitPanel.add(aCharLabel, BorderLayout.PAGE_START);
        aCharInitPanel.add(aCharText, BorderLayout.SOUTH);
        aCharInitPanel.add(aCharOkButton, BorderLayout.PAGE_END);
        container.removeAll();
        container.add(aCharInitPanel);
        SwingUtilities.updateComponentTreeUI(container);
    }

    private JPanel initASeries2CharPanel() {
        JPanel result = new JPanel();
        result.setLayout(new BorderLayout());
        Box compPanel = Box.createVerticalBox();
        JPanel comp1Panel = new JPanel();
        comp1Panel.setLayout(new FlowLayout());
        JPanel comp2Panel = new JPanel();
        comp2Panel.setLayout(new FlowLayout());
        JLabel qm1Label = new JLabel(A1Series.P_EVEN_COMP_1);
        JLabel qp1Label = new JLabel(A1Series.P_EVEN_COMP_2);
        JTextField qm1Text = new JTextField(20);
        elementMap.put(A1Series.P_EVEN_COMP_1, qm1Text);
        JTextField qp1Text = new JTextField(20);
        elementMap.put(A1Series.P_EVEN_COMP_2, qp1Text);
        qm1Label.setLabelFor(qm1Text);
        qp1Label.setLabelFor(qp1Text);
        comp1Panel.add(qm1Label);
        comp1Panel.add(qm1Text);
        comp2Panel.add(qp1Label);
        comp2Panel.add(qp1Text);
        compPanel.add(comp1Panel);
        compPanel.add(comp2Panel);
        result.add(compPanel, BorderLayout.CENTER);
        return result;
    }

    private void initASeries2CharGraphPanel(Container container) {
        initGraphPanel(container, initASeries2CharPanel());
    }

    private JPanel initASeriesPCharPanel() {
        JPanel result = new JPanel();
        result.setLayout(new BorderLayout());
        Box compPanel = Box.createVerticalBox();
        JPanel comp1Panel = new JPanel();
        comp1Panel.setLayout(new FlowLayout());
        JPanel comp2Panel = new JPanel();
        comp2Panel.setLayout(new FlowLayout());
        JPanel epsilonPanel = new JPanel();
        epsilonPanel.setLayout(new FlowLayout());
        JLabel qm1Label = new JLabel(A1Series.P_ODD_COMP_1);
        JLabel qp1Label = new JLabel(A1Series.P_ODD_COMP_2);
        JLabel epsilonLabel = new JLabel("epsilon");
        JTextField qm1Text = new JTextField(20);
        elementMap.put(A1Series.P_ODD_COMP_1, qm1Text);
        JTextField qp1Text = new JTextField(20);
        elementMap.put(A1Series.P_ODD_COMP_2, qp1Text);
        JTextField epsilonText = new JTextField(20);
        elementMap.put("epsilon", epsilonText);
        qm1Label.setLabelFor(qm1Text);
        qp1Label.setLabelFor(qp1Text);
        epsilonLabel.setLabelFor(epsilonText);
        comp1Panel.add(qm1Label);
        comp1Panel.add(qm1Text);
        comp2Panel.add(qp1Label);
        comp2Panel.add(qp1Text);
        epsilonPanel.add(epsilonLabel);
        epsilonPanel.add(epsilonText);
        compPanel.add(comp1Panel);
        compPanel.add(comp2Panel);
        compPanel.add(epsilonPanel);
        result.add(compPanel, BorderLayout.CENTER);
        return result;
    }

    private void initASeriesPCharGraphPanel(Container container) {
        initGraphPanel(container, initASeriesPCharPanel());
    }

    private void init_ASeriesInitPanel(Container container) {
        _aInitPanel = new JPanel();
        _aInitPanel.setLayout(new BorderLayout());
        _aSeriesBox = Box.createVerticalBox();
        _aSeriesGroup = new ButtonGroup();
        _a2Series = new JRadioButton("U_3(q)");
        _a2Series.setActionCommand(AC__A2);
        _a3Series = new JRadioButton("U_4(q)");
        _a3Series.setActionCommand(AC__A3);
        GUIUtils.multiAdditionToBox(_aSeriesBox, _a2Series, _a3Series);
        GUIUtils.multiAdditionToGroup(_aSeriesGroup, _a2Series, _a3Series);
        _aOkButton = new JButton("OK");
        _aOkButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (aSeriesGroup.getSelection() == null) {
                    JOptionPane.showMessageDialog(null, "Выберете что-нибудь");
                } // TODO добавить логику
            }

        });
        _aInitPanel.add(selectSeriesLabel, BorderLayout.NORTH);
        _aInitPanel.add(_aSeriesBox, BorderLayout.CENTER);
        _aInitPanel.add(_aOkButton, BorderLayout.SOUTH);
        container.removeAll();
        container.add(_aInitPanel);
        SwingUtilities.updateComponentTreeUI(container);
    }

    private void initUpperPanel(Container container, JPanel up) {
        upperPanel = up;
        container.add(upperPanel, BorderLayout.PAGE_START);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        initOkButton(panel);
        initResetButton(panel);
        upperPanel.add(panel, BorderLayout.PAGE_END);
    }

    private void initOkButton(JPanel panel) {
        okButton = new JButton(loadPropertiesText("OK_BUTTON_TEXT"));
        okButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!validateElementMap()) {
                    JOptionPane.showMessageDialog(null, loadPropertiesText("OK_BUTTON_EMPTY_ERROR_MESSAGE"),
                            loadPropertiesText("ERROR_MESSAGE"), JOptionPane.ERROR_MESSAGE);
                } else {
                    initGraphPanel(computeGroupDeclaration());
                }
            }

        });
        panel.add(okButton);
    }

    private boolean validateElementMap() {
        for (String key : elementMap.keySet()) {
            if (elementMap.get(key).getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private String computeGroupDeclaration() {
        String result = "";
        if (this.name.equals("A_1") && this.characteristic.startsWith("2")) {
            result = computeASeries2CharDescription();
        }
        return result;
    }

    private String computeASeries2CharDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append("(");
        sb.append(characteristic);
        sb.append("), ");
        for (String key : elementMap.keySet()) {
            sb.append(key);
            sb.append(" = {");
            sb.append(elementMap.get(key).getText());
            sb.append("}, ");
        }
        return  sb.toString();
    }

    private void initResetButton(JPanel panel) {
        resetButton = new JButton(loadPropertiesText("RESET_BUTTON_TEXT"));
        resetButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                clearElementMapText();
                if (vv != null) {
                    clearVv();
                }
            }

        });
        panel.add(resetButton);
    }

    private void clearElementMapText() {
        for (String key : elementMap.keySet()) {
            elementMap.get(key).setText(EMPTY_STRING);
        }
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
            newV.getRenderContext().setEdgeShapeTransformer(new EdgeShape.Line<>());
            newV.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<>());
            newV.getRenderContext().setVertexLabelRenderer(new DefaultVertexLabelRenderer(Color.WHITE));
            newV.getRenderer().getVertexLabelRenderer().setPosition(edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position.S);
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
            case GROUP_RADIO_AC : g = JungSeriesConverterHelper.convertSeriesGraph(groupName);
                break;
            case INND_RADIO_AC : g = JungSeriesConverterHelper.convertInndiagSeriesGraph(groupName);
                break;
            //case FIELD_RADIO_AC : g = JungSeriesConverterHelper.convertConcreteFieldAutLieTypeGroupGraph(groupName);
            //    break;
            case GRAPH_RADIO_AC : g = JungSeriesConverterHelper.convertGraphAutSeriesGraph(groupName);
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
        MainSeriesApplication test = new MainSeriesApplication();
        test.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
