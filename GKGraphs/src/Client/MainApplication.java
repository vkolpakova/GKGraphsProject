package Client;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.*;
import edu.uci.ics.jung.visualization.decorators.EdgeShape;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApplication extends JFrame {

    protected Graph<?, ?> g;
    protected BasicVisualizationServer<Object, Object> vv;

    protected JScrollPane scrollPane;
    protected JPanel upperPanel;
    protected Box verticalBox;
    protected JTextField groupNameField;
    protected JLabel groupNameLabel;
    protected JButton okButton;
    protected JButton resetButton;
    protected TextHandler handler = null;
    protected JRadioButton groupGraphRadio;
    protected JRadioButton inndiagGraphRadio;
    protected JRadioButton fieldAutGraphRadio;
    protected JRadioButton graphAutGraphRadio;

    protected static final String EMPTY_STRING = "";
    protected static final String FRAME_NAME = "Simple Graph View";
    protected static final String GROUP_NAME_LABEL_TEXT = "Наименование группы";
    protected static final String OK_BUTTON_TEXT = "OK";
    protected static final String RESET_BUTTON_TEXT = "Сброс";
    protected static final String OK_BUTTON_EMPTY_ERROR_MESSAGE = "Наименование группы не задано. Введите наименование и повторите попытку.";
    protected static final String ERROR_MESSAGE = "Ошибка";

    public MainApplication() {
        super(FRAME_NAME);
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
        groupNameLabel = new JLabel(GROUP_NAME_LABEL_TEXT);
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
        okButton = new JButton(OK_BUTTON_TEXT);
        okButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (groupNameField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, OK_BUTTON_EMPTY_ERROR_MESSAGE, ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE);
                } else {
                    initGraphPanel(groupNameField.getText());
                }
            }

        });
        upperPanel.add(okButton);
    }

    private void initResetButton() {
        resetButton = new JButton(RESET_BUTTON_TEXT);
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
        scrollPane.getViewport().remove(vv);
        SwingUtilities.updateComponentTreeUI(scrollPane);
    }

    private void initScrollPanel(Container container) {
        scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setSize(new Dimension(350, 350));
        container.add(scrollPane, BorderLayout.CENTER);
        scrollPane.getViewport().add(vv);
    }

    private void initGraphPanel(String groupName) {
        // The Layout<V, E> is parametrized by the vertex and edge types
        this.g = computeG(groupName);
        if (vv != null) {
            // нужно, чтобы поле с графом очистилось перед построением нового.
            // по-нормальному не получается обновлять значение пересчитанного графа, поэтому удаляем и создаем новые компоненты.
            scrollPane.getViewport().remove(vv);
        }
        initVisualizationServer();
        SwingUtilities.updateComponentTreeUI(upperPanel);
    }

    protected void initVisualizationServer() {
        CircleLayout<Object, Object> layout = (CircleLayout<Object, Object>) new CircleLayout<>(this.g);
        layout.setSize(new Dimension(300, 300));
        vv = new BasicVisualizationServer<>(layout);
        vv.setPreferredSize(new Dimension(350, 350)); //Sets the viewing area size
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<>());
        vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller<>());
        vv.getRenderContext().setEdgeShapeTransformer(new EdgeShape.Line<>());
        vv.getRenderer().getVertexLabelRenderer().setPosition(Renderer.VertexLabel.Position.CNTR);
        scrollPane.getViewport().add(vv);
    }

    protected static Graph<?, ?> computeG(String groupName) {
        return JungGraphConverterHelper.convertConcreteLieTypeGroupGraph(groupName);
    }

    private void initRightPanel(Container container) {
        verticalBox = Box.createVerticalBox();
        ButtonGroup radioGroup = new ButtonGroup();
        groupGraphRadio = new JRadioButton("ГПЧ группы");
        groupGraphRadio.setSelected(true);
        inndiagGraphRadio = new JRadioButton("ГПЧ Inndiag");
        fieldAutGraphRadio = new JRadioButton("ГПЧ Phi");
        graphAutGraphRadio = new JRadioButton("ГПЧ Gamma");
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

    public static void main(String args[]) {
        MainApplication test = new MainApplication();
        test.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}