package reseau;

import java.util.Objects;


/**
 * La classe Point permet de localiser un client, un entrepôt, un lieu dans le réseau routier.
 * <p></p>
 * La classe contient un moyen de nommer un lieu par un identifiant unique {@code id} et les coordonnés {@code (x,y)} du point dans le réseau routier.
 */
public class Point {

    /**
     * Un identifiant unique du point
     */
    private final int id;

    /**
     * Abscisse du point
     */
    private int x;

    /**
     * Ordonnée du point
      */
    private int y;


    /**
     * Constructeur de la classe Point
     */
    public Point() {
        this(0,0,0);
    }

    /**
     * Constructeur de la classe point avec les paramètres
     *
     * @param id int Identifiant unique du point
     * @param x int abscisse du point
     * @param y int ordonnée du point
     */
    public Point(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    /**
     * Renvoie l'abscisse du point
     *
     * @return int abscisse du point
     */
    public int getX() {
        return x;
    }

    /**
     * Modifie l'abscisse du point
     * @param x nouvelle abscisse du point
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Renvoie l'ordonnée du point
     *
     * @return int ordonnée du point
     */
    public int getY() {
        return y;
    }

    /**
     * Modifie l'ordonnée du point
     * @param x nouvelle ordonnée du point
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Renvoie l'identifiant du point
     *
     * @return identifiant du point
     */
    public int getId() {
        return id;
    }

    /**
     * (non-javadoc)
     *
     * @see  Object#equals(Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return id == point.id;
    }

    /**
     * (non-javadoc)
     *
     * @see  Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * (non-javadoc)
     *
     * @see  Object#toString()
     */
    @Override
    public String toString() {
        return id + " { " + x + " ; " + y + " }";
    }
}
