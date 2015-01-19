package me.matt.enigma.wrappers;

public class Rotor {

    int position;
    char[] wheel;

    public Rotor(int position, char[] wheel) {
        this.position = position;
        this.wheel = wheel;
        for (int i = 0; i < position; i++) {
            shiftRotor();
        }
    }

    private void shiftRotor() {
        char last = wheel[wheel.length - 1];
        System.arraycopy(wheel, 0, wheel, 1, wheel.length - 1);
        wheel[0] = last;
    }

    public boolean incrementPosition() {
        shiftRotor();
        if (position + 1 <= 26) {
            position++;
            return false;
        } else {
            position = 0;
            return true;
        }
    }

    public char swap(char c) {
        return swap(c, false);
    }

    public char swap(char c, boolean reverse) {
        if (reverse) {
            return (char) (new String(wheel).indexOf(c) + 'A'); // Find the position of the rotor and return the character at that position in the alphabet
        }
        return wheel[c - 'A']; // Find the character at the position of the current character in the alphabet
    }

}
