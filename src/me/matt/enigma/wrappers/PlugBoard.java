package me.matt.enigma.wrappers;

public class PlugBoard {

    PlugBoardSwitch[] switches;

    public PlugBoard(final PlugBoardSwitch[] switches) {
        this.switches = switches;
    }

    public char swap(final char c) {
        for (final PlugBoardSwitch s : switches) {
            if (s.checkSwap(c)) {
                return s.swap(c);
            }
        }
        return c;
    }

}
