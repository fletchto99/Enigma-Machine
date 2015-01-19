package me.matt.enigma.wrappers;

public class PlugBoard {
    
    PlugBoardSwitch[] switches;
    
    public PlugBoard(PlugBoardSwitch[] switches) {
        this.switches = switches;
    }
    
    public char swap(char c) {
        for(PlugBoardSwitch s : switches) {
            if (s.checkSwap(c)) {
                return s.swap(c);
            }
        }
        return c;
    }

}
