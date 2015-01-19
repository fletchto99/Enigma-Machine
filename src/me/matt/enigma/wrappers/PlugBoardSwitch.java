package me.matt.enigma.wrappers;

public class PlugBoardSwitch {

    char in;
    char out;

    public PlugBoardSwitch(char in, char out) {
        this.in = in;
        this.out = out;
    }
    
    public boolean checkSwap(char c) {
        return c == in || c == out;
    }

    public char swap(char c) {
        if (c == in) {
            return out;
        }
        return c == out ? in : c;
    }

}
