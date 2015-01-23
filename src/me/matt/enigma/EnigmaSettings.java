package me.matt.enigma;

public class EnigmaSettings {

    public static char[] ROTOR_I = new char[] { 'E', 'K', 'M', 'F', 'L', 'G',
            'D', 'Q', 'V', 'Z', 'N', 'T', 'O', 'W', 'Y', 'H', 'X', 'U', 'S',
            'P', 'A', 'I', 'B', 'R', 'C', 'J' };
    public static char[] ROTOR_II = new char[] { 'A', 'J', 'D', 'K', 'S', 'I',
            'R', 'U', 'X', 'B', 'L', 'H', 'W', 'T', 'M', 'C', 'Q', 'G', 'Z',
            'N', 'P', 'Y', 'F', 'V', 'O', 'E' };
    public static char[] ROTOR_III = new char[] { 'B', 'D', 'F', 'H', 'J', 'L',
            'C', 'P', 'R', 'T', 'X', 'V', 'Z', 'N', 'Y', 'E', 'I', 'W', 'G',
            'A', 'K', 'M', 'U', 'S', 'Q', 'O' };
    public static char[] ROTOR_IV = new char[] { 'E', 'S', 'O', 'V', 'P', 'Z',
            'J', 'A', 'Y', 'Q', 'U', 'I', 'R', 'H', 'X', 'L', 'N', 'F', 'T',
            'G', 'K', 'D', 'C', 'M', 'W', 'B' };
    public static char[] ROTOR_V = new char[] { 'V', 'Z', 'B', 'R', 'G', 'I',
            'T', 'Y', 'U', 'P', 'S', 'D', 'N', 'H', 'L', 'X', 'A', 'W', 'M',
            'J', 'Q', 'O', 'F', 'E', 'C', 'K' };
    public static char[] ROTOR_VI = new char[] { 'J', 'P', 'G', 'V', 'O', 'U',
            'M', 'F', 'Y', 'Q', 'B', 'E', 'N', 'H', 'Z', 'R', 'D', 'K', 'A',
            'S', 'X', 'L', 'I', 'C', 'T', 'W' };
    public static char[] ROTOR_VII = new char[] { 'N', 'Z', 'J', 'H', 'G', 'R',
            'C', 'X', 'M', 'Y', 'S', 'W', 'B', 'O', 'U', 'F', 'A', 'I', 'V',
            'L', 'P', 'E', 'K', 'Q', 'D', 'T' };
    public static char[] ROTOR_VIII = new char[] { 'N', 'Z', 'J', 'H', 'G',
            'R', 'C', 'X', 'M', 'Y', 'S', 'W', 'B', 'O', 'U', 'F', 'A', 'I',
            'V', 'L', 'P', 'E', 'K', 'Q', 'D', 'T' };

    public static char[][] REFLECTOR_B = new char[][] {
            { 'A', 'Y', 'B', 'R', 'C', 'D', 'E', 'F', 'G', 'I', 'J', 'K', 'M',
                    'T', 'V' },
            { 'Y', 'R', 'U', 'H', 'Q', 'S', 'L', 'P', 'X', 'N', 'O', 'Z', 'W' } };
    public static char[][] REFLECTOR_C = new char[][] {
            { 'A', 'B', 'C', 'D', 'E', 'G', 'H', 'K', 'L', 'M', 'N', 'T', 'S' },
            { 'F', 'V', 'P', 'J', 'I', 'O', 'Y', 'R', 'Z', 'X', 'W', 'Q', 'U' } };
    public static char[][] REFLECTOR_BD = new char[][] {
            { 'A', 'B', 'C', 'D', 'F', 'G', 'H', 'I', 'L', 'M', 'R', 'S', 'T' },
            { 'E', 'N', 'K', 'Q', 'U', 'Y', 'W', 'J', 'O', 'P', 'X', 'Z', 'V' } };
    public static char[][] REFLECTOR_CD = new char[][] {
            { 'A', 'B', 'C', 'E', 'F', 'G', 'H', 'I', 'L', 'P', 'Q', 'S', 'U' },
            { 'R', 'D', 'O', 'J', 'N', 'T', 'K', 'V', 'M', 'W', 'Z', 'X', 'Y' } };

}
