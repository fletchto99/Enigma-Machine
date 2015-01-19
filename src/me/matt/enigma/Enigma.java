package me.matt.enigma;

import java.util.Scanner;

import me.matt.enigma.wrappers.PlugBoard;
import me.matt.enigma.wrappers.PlugBoardSwitch;
import me.matt.enigma.wrappers.Reflector;
import me.matt.enigma.wrappers.Rotor;

public class Enigma {

    private static boolean DEBUG_ENABLED = false;
    private static boolean DEBUG_ROTOR = false;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // Setup the plugobard
        PlugBoardSwitch[] switches = new PlugBoardSwitch[10];

        System.out
                .println("What are your plugboard settings? (2 characters, seperated by a space)");

        for (int i = 0; i < 10; i++) {
            if (!DEBUG_ROTOR) {
                String line = s.nextLine();
                switches[i] = new PlugBoardSwitch(line.toUpperCase().charAt(0),
                        line.toUpperCase().charAt(2));
            } else {
                switches[i] = new PlugBoardSwitch('a', 'a');
            }

        }

        PlugBoard plugboard = new PlugBoard(switches);

        // Setup the rotor settings
        Rotor[] rotors = new Rotor[3];

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
        Reflector reflector = new Reflector(EnigmaSettings.REFLECTOR_C);
        // System.out.println("Which reflector should be used? (B, C, BC, CD)");
        s.nextLine();
        // Encrypt/Decrypt the message
        System.out.println("Please enter a message to encrypt/decrypt.");
        char[] msg = s.nextLine().toUpperCase().toCharArray();
        char[] encoded = new char[msg.length];
        for (int i = 0; i < msg.length; i++) {

            char encode = msg[i];
            if (encode < 65 || encode > 90) {
                encoded[i] = encode;
                continue;
            }
            debug("Encoding letter: " + encode);
            encode = plugboard.swap(encode);
            debug("After plugboard: " + encode);
            encode = rotors[0].swap(encode);
            debug("After rotor 1: " + encode);
            encode = rotors[1].swap(encode);
            debug("After rotor 2: " + encode);
            encode = rotors[2].swap(encode);
            debug("After rotor 3: " + encode);
            encode = reflector.swap(encode);
            debug("After reflector: " + encode);
            encode = rotors[2].swap(encode, true);
            debug("After rotor 3: " + encode);
            encode = rotors[1].swap(encode, true);
            debug("After rotor 2: " + encode);
            encode = rotors[0].swap(encode, true);
            debug("After rotor 1: " + encode);
            encode = plugboard.swap(encode);
            debug("After plugboard: " + encode);
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

    public static void debug(String text) {
        if (DEBUG_ENABLED) {
            System.out.println(text);
        }

    }

}
