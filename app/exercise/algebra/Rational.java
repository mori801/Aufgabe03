package exercise.algebra;

/**
 * Klasse Rational erbt von BasisFractions und beinhaltet Grundlegende Methoden zum Arbeiten mit Brüchen
 */
public class Rational extends BasisFraction{

    long numerator = 0;

    long denominator = 1;

    public Rational(long numerator, long denominator){
        setND(numerator, denominator);//erstellen des Objektes plus kürzen
    }

    /** Prüfe und übernehme Zähler und Nenner
     * @param long Zähler
     * @param long Nenner
     */
    @Override
    protected void setND(long numerator, long denominator) {
        if(denominator == 0){
            throw new IllegalArgumentException("Fraction kann nicht erstellt werden");
        }else if(denominator < 0){ //Wenn negativer Nenner, negiere Zähler und mache Nenner positiv
            numerator *= -1;
            denominator *= -1;
        }
        long gcd = gcd(numerator, denominator);

        this.numerator = numerator/gcd; //Kürze Zähler mit gcd
        this.denominator = denominator/gcd; //Kürze Nenner mit gcd

        if (this.denominator < 0) { //Falls negativer Nenner, negiere Zähler und mache Nenner positiv
            this.numerator *= -1;
            this.denominator *= -1;
        }

    }

    /** @return Nenner */
    @Override
    public long getN() {
        return this.numerator;
    }

    /** @return Zähler */
    @Override
    public long getD() {
        return this.denominator;
    }

    /** Greatest Common Divisor mit dem Euklidischen Algorithmus
     * @param long Zahl1
     * @param long Zahl2
     * @return long ggT(Zahl1, Zahl2)
     */
    private long gcd(long numerator, long denominator){
        long gcd = numerator % denominator;
        long a = denominator;
        long b;

        while (a != 0) {
            b = gcd%a;
            gcd = a;
            a = b;
        }

        return gcd;
    }

    /** Gibt neu erzeugtes Objekt mit gleichem Zähler und Nenner zurück
     * @return Rational
     */
    @Override
    public Rational clone() {
        return new Rational(getN(), getD());
    }

    /** Gibt Hashcode-Repräsentation von toString() zurück
     * @return int
     */
    @Override
    public int hashCode() {
        setND(getN(), getD());
        return this.toString().hashCode();
    }

    /** Bruchkürzung und Prüfung auf Gleichheit
     * @param Object
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        setND(getN(), getD()); //Nur für den Fall, dass der Bruch kürzbar ist oder Nenner = 0

        Rational rat = (Rational) obj; //Damit man bei Benutzung von obj nicht jedes mal casten muss
        rat.setND(rat.getN(), rat.getD()); //Ebenfalls für den Fall, dass Bruch kürzbar...

        return getN() == rat.getN() && getD() == rat.getD(); //Gib zurück ob die Zähler und Nenner gleich sind
    }

    /** Bruch als String-Output darstellen
     * @return Bruch als String
     */
    @Override
    public String toString() {
        if (getD() > 1) {
            return "(" + getN() + "/" + getD() + ")"; //Wenn Nenner größer 1 ist, dann muss Nenner mit angegeben werden
        } else {
            return "" + getN(); //Sonst reicht Angabe des Zählers
        }
    }
}
