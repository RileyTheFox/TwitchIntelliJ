package co.uk.rileythefox.twitchintellij;

import com.intellij.openapi.options.Configurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class PluginSettingsConfigurable implements Configurable {

    private PluginSettingsComponent settingsComponent;

    @Nls(capitalization = Nls.Capitalization.Title)
    @Override
    public String getDisplayName() {
        return "TwitchIntelliJ Settings";
    }

    @Override
    public @Nullable JComponent getPreferredFocusedComponent() {
        return settingsComponent.getPreferredFocusedComponent();
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        settingsComponent = new PluginSettingsComponent();
        return settingsComponent.getPanel();
    }

    @Override
    public boolean isModified() {
        PluginSettingsState settings = PluginSettingsState.getInstance();
        boolean modified = !settingsComponent.getTwitchClientId().equals(settings.twitchClientId);

        return modified;
    }

    @Override
    public void apply() {
        PluginSettingsState settings = PluginSettingsState.getInstance();
        settings.twitchClientId = settingsComponent.getTwitchClientId();
    }

    @Override
    public void reset() {
        PluginSettingsState settings = PluginSettingsState.getInstance();
        settingsComponent.setTwitchClientId(settings.twitchClientId);
    }

    @Override
    public void disposeUIResources() {
        settingsComponent = null;
    }
}
