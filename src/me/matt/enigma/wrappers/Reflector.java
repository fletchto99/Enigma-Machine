package me.matt.enigma.wrappers;

public class Reflector {

    char[][] reflector;

    public Reflector(final char[][] reflector) {
        this.reflector = reflector;
    }

    public char swap(final char c) {
        for (int i = 0; i < reflector[0].length; i++) {
            if (c == reflector[0][i]) {
                return reflector[1][i];
            } else if (c == reflector[1][i]) {
                return reflector[0][i];
            }
        }
        return c;// This line should never be reached, acts as a failsafe.
    }

}
