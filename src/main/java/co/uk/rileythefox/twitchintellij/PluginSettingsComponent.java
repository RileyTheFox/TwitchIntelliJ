package co.uk.rileythefox.twitchintellij;

import com.intellij.ui.components.JBTextField;
import com.intellij.util.ui.FormBuilder;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class PluginSettingsComponent {

    private final JPanel mainPanel;
    private final JBTextField twitchClientId = new JBTextField();

    public PluginSettingsComponent() {
        mainPanel = FormBuilder.createFormBuilder()
                .addLabeledComponent(new JLabel("Twitch Client ID"), twitchClientId, 1, false)
                .addComponentFillVertically(new JPanel(), 0)
                .getPanel();
    }

    public JPanel getPanel() {
        return mainPanel;
    }

    public JComponent getPreferredFocusedComponent() {
        return mainPanel;
    }

    @NotNull
    public String getTwitchClientId() {
        return twitchClientId.getText();
    }

    public void setTwitchClientId(@NotNull String newTwitchClientId) {
        twitchClientId.setText(newTwitchClientId);
    }

}
