package app.exercise.testing;

import java.util.Stack;

import app.exercise.algebra.Rational;

/**
 * Testklasse mit umgekehrter polnischer Notation
 */
public class RPN {

    /** Wenn übergebener Parameter eine Zahl ist, dann wird true zurückgegeben
     * @param char
     * @return boolean
     */
    public static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    /** main-Methode zum Testen von RPN */
    public static void main(String[] args) {
        int n = args.length;
        if (n > 2) {
            Stack<Rational> s = new Stack<Rational>(); //Stack wird erzeugt
            for (int i = 0; i < n; i++) { //Iteriere über alle Input-Parameter
                String input = args[i]; //input = i-ter Parameter
                System.out.print(input + " "); //Gib input aus
                if (isNumber(input.charAt(0))) { //Falls input eine Zahl ist
                    int num = Integer.valueOf(input); //Caste zu Integer als "num"
                    s.push(new Rational(num, 1)); //Adde num auf Stack
                } else { //Wenn input keine Zahl, dann ist es ein Symbol
                    Rational a = s.pop(); //hole die obersten zwei Zahlen aus dem Stack
                    Rational b = s.pop();
                    switch(input) { //Check Symbol
                        case "+": //Wenn input = +
                            b.add(a); //Füge a zu b hinzu
                            s.push(b); //Adde b auf Stack
                            break;
                        case "-": //Wenn input = -
                            b.sub(a); //Subtrahiere a von b
                            s.push(b); //Adde b auf Stack
                            break;
                        case "o": //Wenn input = * (hier "o" wegen Eclipse)
                            b.mul(a); //Multipliziere b mit a
                            s.push(b); //Adde b auf Stack
                            break;
                        case "/": //Wenn input = /
                            b.div(a); //Dividiere b mit a
                            s.push(b); //Adde b auf Stack
                            break;
                        default: //Sonst gib Zahlen in Reihenfolge zurück auf Stack
                            s.push(b);
                            s.push(a);
                            System.out.println("Falsches Zeichen: " + input); //Error
                            return;
                    }
                }
            }
            System.out.println("= " + s.pop()); //Gib Ergebnis aus (Letztes Element im Stack)
        } else {
            System.out.println("Falsche Syntax!"); //Error
        }
    }
}
