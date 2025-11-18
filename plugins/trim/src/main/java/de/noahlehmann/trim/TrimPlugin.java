package de.noahlehmann.trim;

import de.noahlehmann.TextMapper;
import org.pf4j.Extension;
import org.pf4j.Plugin;
import org.pf4j.PluginWrapper;

public class TrimPlugin extends Plugin {

    public TrimPlugin(PluginWrapper wrapper) {
        super(wrapper);
    }

    @Override
    public void start() {
        System.out.printf("%s.start()%n", this.getClass().getName());
    }

    @Override
    public void stop() {
        System.out.printf("%s.stop()%n", this.getClass().getName());
    }

    @Extension
    public static class Trim implements TextMapper {

        @Override
        public String mapText(String input) {
            return input.trim();
        }
    }

}
