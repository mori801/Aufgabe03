package app.exercise.adt;

import app.exercise.visualtree.DrawableTreeElement;

/**
 * Klassen zum Erzeugen von Knoten-Objekten
 * @param <E> typ
 */
public class Node<E extends Comparable<E>> implements DrawableTreeElement<E> {

    /**
     * Objekt-Variablen
     * inhalt, red, right, left
     */
    private E inhalt;
    private boolean red;
    private Node<E> right, left;

    /**
     * Konstrukor zum erzeugen von Node-Objekten
     * @param E inhalt
     */
    public Node(E inhalt) {
        this.inhalt = inhalt;
        this.red = Math.random() < 0.5;
    }

    /*
     * Inhalt des Knotens setzen
     * @param E inhalt
     */
    public void setValue(E inhalt) {
        this.inhalt = inhalt;
    }

    /**
     * getter um auf linkes Listenelement zuzugreifen
     * @return DrawableTreeElement<E>
     */
    @Override
    public DrawableTreeElement<E> getLeft() {
        return left;
    }

    /**
     * getter um auf rechtes Listenelement zuzugreifen
     * @return DrawableTreeElement<E>
     */
    @Override
    public DrawableTreeElement<E> getRight() {
        return right;
    }

    /**
     * Methode um zu prüfen ob Knoten rot ist
     * @return boolean
     */
    @Override
    public boolean isRed() {
        return red;
    }

    /**
     * Methode um typisierten Wert zurückzugeben
     * @return E
     */
    @Override
    public E getValue() {
        return inhalt;
    }

    /**
     * getter um auf linkes Listenelement zuzugreifen
     * @return Node<E>
     */
    public Node<E> getLeftNode() {
        return left;
    }

    /**
     * getter um auf rechtes Listenelement zuzugreifen
     * @return Node<E>
     */
    public Node<E> getRightNode() {
        return right;
    }

    /**
     * Methode um den rechten Unterknoten zu setzen
     * @param Node<E> right
     */
    public void setRightNode(Node<E> right) {
        this.right = right;
    }

    /**
     * Methode um den linken Unterknoten zu setzen
     * @param Node<E> left
     */
    public void setLeftNode(Node<E> left) {
        this.left = left;
    }
}