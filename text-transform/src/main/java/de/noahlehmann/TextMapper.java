package de.noahlehmann;

import org.pf4j.ExtensionPoint;

public interface TextMapper extends ExtensionPoint {

    String mapText(String input);

}
