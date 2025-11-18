package de.noahlehmann;

public class TestMapper implements TextMapper {
    @Override
    public String mapText(String input) {
        return input.toLowerCase();
    }
}
