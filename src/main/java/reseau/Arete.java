package reseau;

/**
 * La classe {@code Arete} représente une route dans un réseau routier qui relie deux points.
 */
public class Arete {

    /**
     * Identifiant du point de départ de l'arête
     */
    private int idP1;

    /**
     * Identifiant du point d'arrivée de l'arête
     */
    private int idP2;

    /**
     * Le poids de l'arête.
     *
     * Cette valeur peut se voir comme une distance ou un coût.
     */
    private double poids;

    /**
     * Constructeur de la classe {@code Arete}.
     *
     * @param idP1 identifiant du point de départ de l'arête
     * @param idP2 identifiant du point d'arrivée' de l'arête
     * @param poids pondération de l'arête
     */
    public Arete(int idP1, int idP2, double poids) {
        this.idP1 = idP1;
        this.idP2 = idP2;
        this.poids = poids;
    }

    /**
     * Renvoie l'identifiant du point de départ de l'arête
     *
     * @return identifiant d'un point
     */
    public int getIdP1() {
        return idP1;
    }

    /**
     * Modifie l'identifiant du point de départ de l'arête.
     *
     * @param idP1 nouvel identifiant de départ
     */
    public void setIdP1(int idP1) {
        this.idP1 = idP1;
    }

    /**
     * Renvoie l'identifiant du point d'arrivée' de l'arête
     *
     * @return identifiant d'un point
     */
    public int getIdP2() {
        return idP2;
    }

    /**
     * Modifie l'identifiant du point d'arrivée de l'arête.
     *
     * @param idP2 nouvel identifiant d'arrivée
     */    public void setIdP2(int idP2) {
        this.idP2 = idP2;
    }

    /**
     * Renvoie la pondération de l'arête.
     *
     * @return la pondération
     */
    public double getPoids() {
        return poids;
    }


    /**
     * Modifie la pondération de l'arête.
     *
     * @param poids nouvelle valeur de pondération de l'arête
     */
    public void setPoids(double poids) {
        this.poids = poids;
    }
}
