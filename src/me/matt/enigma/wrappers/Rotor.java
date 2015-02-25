package me.matt.enigma.wrappers;

public class Rotor {

    int position;
    char[] wheel;

    public Rotor(final int position, final char[] wheel) {
        this.position = position;
        this.wheel = wheel;
        for (int i = 0; i < position; i++) {
            this.shiftRotor();
        }
    }

    public boolean incrementPosition() {
        this.shiftRotor();
        if (position + 1 <= 26) {
            position++;
            return false;
        } else {
            position = 0;
            return true;
        }
    }

    private void shiftRotor() {
        final char last = wheel[wheel.length - 1];
        System.arraycopy(wheel, 0, wheel, 1, wheel.length - 1);
        wheel[0] = last;
    }

    public char swap(final char c) {
        return this.swap(c, false);
    }

    public char swap(final char c, final boolean reverse) {
        if (reverse) {
            return (char) (new String(wheel).indexOf(c) + 'A'); // Find the position of the rotor and return the character at that position in the
                                                                // alphabet
        }
        return wheel[c - 'A']; // Find the character at the position of the current character in the alphabet
    }

}
