package Client.Util;

import javax.swing.*;

/**
 * ������� GUI
 *
 * Created by v.kolpakova on 09.05.2015.
 */
public class GUIUtils {

    /**
     * ������������� ���������� radio � ������
     */
    public static void multiAdditionToGroup(ButtonGroup group, JRadioButton ... buttons) {
        for (JRadioButton button : buttons) {
            group.add(button);
        }
    }

    /**
     * ������������� ���������� radio � ����
     */
    public static void multiAdditionToBox(Box box, JRadioButton... buttons) {
        for (JRadioButton button : buttons) {
            box.add(button);
        }
    }

}
