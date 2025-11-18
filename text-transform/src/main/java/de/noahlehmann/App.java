package de.noahlehmann;

import org.pf4j.DefaultPluginManager;
import org.pf4j.PluginManager;

import java.util.List;

public class App {

    public static void main(String[] args) {
        String input = " TesDy  Rs y .  ", temp = input;

        PluginManager pluginManager = new DefaultPluginManager();
        pluginManager.loadPlugins();
        pluginManager.startPlugins();

        List<TextMapper> mappers = pluginManager.getExtensions(TextMapper.class);
        System.out.printf("Found %d extensions for extension point '%s'%n", mappers.size(), TextMapper.class.getName());

        System.out.println("Extension classes by classpath:");
        List<Class<? extends TextMapper>> classes = pluginManager.getExtensionClasses(TextMapper.class);
        classes.forEach(mapper -> System.out.println(mapper.getCanonicalName()));
        int classNameLength = classes.stream()
                .map(Class::getSimpleName)
                .map(String::length)
                .max(Integer::compareTo).orElse(0);

        System.out.printf("%-" + classNameLength + "s: |%-" + input.length() + "s|%n", "Input", input);

        for (TextMapper mapper : mappers) {
            System.out.printf(
                    "%-" + classNameLength + "s: |%-" + input.length() + "s| > |%-" + input.length() + "s|%n",
                    mapper.getClass().getSimpleName(),
                    temp,
                    mapper.mapText(temp)
            );
            temp = mapper.mapText(temp);
        }

        Runtime.getRuntime().addShutdownHook(new Thread(pluginManager::stopPlugins));
    }

}
