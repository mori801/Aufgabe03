package exercise.algebra;

/**
 * Beinhaltet die Implementation des Interface Fractional und Vorschrift zum Setzen von Zähler und Nenner
 */
public abstract class BasisFraction implements Fractional{

    /**
     * @param Zähler
     * @param Nenner
     */
    protected abstract void setND(long numerator, long denominator);

    /**
     * Addiert um parameter des Typs Fractional
     * @param Fractional
     */
    public void add(Fractional operand) {
        if(getN() > Long.MAX_VALUE / operand.getD() || operand.getN() > Long.MAX_VALUE / getD() || getD() > Long.MAX_VALUE / operand.getD() || ((getN() * operand.getD()) > Long.MAX_VALUE - Math.abs(getD() * operand.getN()))){
            throw new IllegalArgumentException("ERROR compareTo expects Parameter of Type CompRational");
        }
        long newNum = (getN() * operand.getD()) + (getD() * operand.getN()); //Neuer Zähler
        long newDen = getD() * operand.getD(); //Neuer Nenner

        setND(newNum, newDen); //Setze Ergebnis als Zähler und Nenner des Objekts
    }

    /** Subtrahiert um parameter des Typs Fractional
     * @param Fractional
     * @return
     */
    public void sub(Fractional operand){
        add(operand.negation());
    }; //Addition mit negativem operand

    /** Multipliziert mit parameter des Typs Fractional
     * @param Fractional
     */
    public void mul(Fractional operand){ //Zähler mit Zähler und Nenner mit Nenner werden multipliziert
        long numerator = operand.getN() * getN();
        long denominator = operand.getD() * getD();
        setND(numerator, denominator);
    };

    /** Dividiert mit parameter des Typs Fractional
     * @param Fractional
     */
    public void div(Fractional operand){
        mul(operand.reciprocal()); //kehrert wird multipliziert
    };

    /** Negiert Bruch */
    public Fractional negation(){
        setND(-getN(), getD()); // zähler wird negiert
        return this;
    };

    /** Bildet Kehrbruch */
    public Fractional reciprocal(){
        if(getN() == 0){ //Falls Zähler = 0, dann wird Nenner = 0 sein -> Error
            throw new IllegalArgumentException("Kehrbruch kann nicht gebildet werden");
        }
        setND(getD(), getN()); //Setze verkehrt Zähler und Nenner
        return this;
    };
}
