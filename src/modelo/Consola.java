package modelo;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public final class Consola {

    public static final Scanner IN = new Scanner(System.in, StandardCharsets.UTF_8);

    static {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
    }

    public static void init() {
        // Fuerza la carga de esta clase (y su bloque estático) antes de cualquier System.out.print.
    }

    private Consola() {
    }
}
