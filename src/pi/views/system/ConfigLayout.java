/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.views.system;

/**
 *
 * @author User-001
 */
public enum ConfigLayout {

    LookAndFeelDefault("com.jtattoo.plaf.fast.FastLookAndFeel"), LookAndFeel2("com.jtattoo.plaf.smart.SmartLookAndFeel");

    private final String lookAndFeel;

    private ConfigLayout(String look) {
        lookAndFeel = look;
    }

    /**
     * @return the lookAndFeel
     */
    public String getLookAndFeel() {
        return lookAndFeel;
    }
}
