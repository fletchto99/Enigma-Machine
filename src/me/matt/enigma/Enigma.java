package me.matt.enigma;

import java.util.Scanner;

import me.matt.enigma.wrappers.PlugBoard;
import me.matt.enigma.wrappers.PlugBoardSwitch;
import me.matt.enigma.wrappers.Reflector;
import me.matt.enigma.wrappers.Rotor;

public class Enigma {

    public static void debug(final String text) {
        if (Enigma.DEBUG_ENABLED) {
            System.out.println(text);
        }

    }

    public static void main(final String[] args) {
        final Scanner s = new Scanner(System.in);

        // Setup the plugobard
        final PlugBoardSwitch[] switches = new PlugBoardSwitch[10];

        System.out
                .println("What are your plugboard settings? (2 characters, seperated by a space)");

        for (int i = 0; i < 10; i++) {
            if (!Enigma.DEBUG_ROTOR) {
                final String line = s.nextLine();
                switches[i] = new PlugBoardSwitch(line.toUpperCase().charAt(0),
                        line.toUpperCase().charAt(2));
            } else {
                switches[i] = new PlugBoardSwitch('a', 'a');
            }

        }

        final PlugBoard plugboard = new PlugBoard(switches);

        // Setup the rotor settings
        final Rotor[] rotors = new Rotor[3];

        // TODO: Setup rotor choosing

        System.out.println("Please enter your rotor settings.");

        System.out.println("What is the first rotor's starting position?");
        rotors[0] = new Rotor(s.nextInt(), EnigmaSettings.ROTOR_I);
        System.out.println("What is the second rotor's starting position?");
        rotors[1] = new Rotor(s.nextInt(), EnigmaSettings.ROTOR_II);
        System.out.println("What is the third rotor's starting position?");
        rotors[2] = new Rotor(s.nextInt(), EnigmaSettings.ROTOR_III);

        // Setup the reflector

        // TODO: Setup reflector choosing
        final Reflector reflector = new Reflector(EnigmaSettings.REFLECTOR_C);
        // System.out.println("Which reflector should be used? (B, C, BC, CD)");
        s.nextLine();
        // Encrypt/Decrypt the message
        System.out.println("Please enter a message to encrypt/decrypt.");
        final char[] msg = s.nextLine().toUpperCase().toCharArray();
        final char[] encoded = new char[msg.length];
        for (int i = 0; i < msg.length; i++) {

            char encode = msg[i];
            if (encode < 65 || encode > 90) {
                encoded[i] = encode;
                continue;
            }
            Enigma.debug("Encoding letter: " + encode);
            encode = plugboard.swap(encode);
            Enigma.debug("After plugboard: " + encode);
            encode = rotors[0].swap(encode);
            Enigma.debug("After rotor 1: " + encode);
            encode = rotors[1].swap(encode);
            Enigma.debug("After rotor 2: " + encode);
            encode = rotors[2].swap(encode);
            Enigma.debug("After rotor 3: " + encode);
            encode = reflector.swap(encode);
            Enigma.debug("After reflector: " + encode);
            encode = rotors[2].swap(encode, true);
            Enigma.debug("After rotor 3: " + encode);
            encode = rotors[1].swap(encode, true);
            Enigma.debug("After rotor 2: " + encode);
            encode = rotors[0].swap(encode, true);
            Enigma.debug("After rotor 1: " + encode);
            encode = plugboard.swap(encode);
            Enigma.debug("After plugboard: " + encode);
            encoded[i] = encode;
            if (rotors[0].incrementPosition()) {
                if (rotors[1].incrementPosition()) {
                    rotors[2].incrementPosition();
                }
            }
        }
        System.out.println("The message is: " + new String(encoded));
        s.close();
    }

    private static boolean DEBUG_ENABLED = false;

    private static boolean DEBUG_ROTOR = false;

}
