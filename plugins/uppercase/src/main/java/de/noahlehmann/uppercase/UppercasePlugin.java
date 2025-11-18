package de.noahlehmann.uppercase;

import de.noahlehmann.TextMapper;
import org.pf4j.Extension;
import org.pf4j.Plugin;
import org.pf4j.PluginWrapper;

public class UppercasePlugin extends Plugin {

    public UppercasePlugin(PluginWrapper wrapper) {
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

    @Extension(ordinal = 1)
    public static class Uppercase implements TextMapper {

        @Override
        public String mapText(String input) {
            return input.toUpperCase();
        }
    }

}
