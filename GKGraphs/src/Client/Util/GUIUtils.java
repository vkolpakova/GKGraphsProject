package Client.Util;

import javax.swing.*;

/**
 * Утилиты GUI
 *
 * Created by v.kolpakova on 09.05.2015.
 */
public class GUIUtils {

    /**
     * Множественное добавление radio в группу
     */
    public static void multiAdditionToGroup(ButtonGroup group, JRadioButton ... buttons) {
        for (JRadioButton button : buttons) {
            group.add(button);
        }
    }

    /**
     * Множественное добавление radio в бокс
     */
    public static void multiAdditionToBox(Box box, JRadioButton... buttons) {
        for (JRadioButton button : buttons) {
            box.add(button);
        }
    }

}
