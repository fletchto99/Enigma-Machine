package me.matt.enigma.wrappers;

public class PlugBoardSwitch {

    char in;
    char out;

    public PlugBoardSwitch(final char in, final char out) {
        this.in = in;
        this.out = out;
    }

    public boolean checkSwap(final char c) {
        return c == in || c == out;
    }

    public char swap(final char c) {
        if (c == in) {
            return out;
        }
        return c == out ? in : c;
    }

}
