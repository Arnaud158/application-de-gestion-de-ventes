package reseau;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * La classe implémente un graphe de points {@code Point} qui sont reliés par des arêtes {@code Arete}.
 *
 * Le réseau routier est un graphe dirigé de points.
 */
public class ReseauRoutier {
    /**
     * Structure de données qui stocke le réseau routier
     */
    private List<Arete> routes = new ArrayList<>();

    /**
     * Structure de données dictionnaire qui permet de retrouver facilement le point à partir de son identifiant.
     */
    private Map<Integer, Point> mapPoints = new HashMap<>();

    /**
     * Lecture d'un fichier texte {@code filename} qui permet de récupérer les points et les arêtes du réseau.
     *
     * Le format du fichier est le suivant :
     * <pre>
     *
     * <code>
     *
     *     v id x y
     *     ...
     *     e id1 id2 poids
     *     ...
     * </code>
     * </pre>
     *
     * Avec
     * <ul>
     *     <li>{@code v} un sommet (point) du graphe, {@code id} identifiant, {@code (x,y)} les coordonnées</li>
     *     <li>{@code e} une arête du graphe, {@code id1} identifiant du point de départ, {@code id2} identifiant du point d'arrivée et {@code poids} la pondération de l'arête</li>
     *
     * </ul>
     *
     * @param filename
     */
    public void lireCarte(String filename) {
        Scanner sc = null;
        try {
            sc = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while(sc.hasNext()) {
            String type = sc.next();
            if ("v".equals(type)) {
                int id = Integer.parseInt(sc.next());
                int x = Integer.parseInt(sc.next());
                int y = Integer.parseInt(sc.next());
                // Si on a 2 identifiants identiques, on ne garde que le dernier.
                mapPoints.put(id, new Point(id,x,y));
            } else if ("e".equals(type)) {
                int id1 = Integer.parseInt(sc.next());
                int id2 = Integer.parseInt(sc.next());
                double poids = Double.parseDouble(sc.next());
                if(mapPoints.get(id1) == null || mapPoints.get(id2) == null) {
                    throw new IllegalArgumentException("Identifiant d'un point inconnu");
                }
                routes.add(new Arete(id1, id2, poids));
            } else
                continue;
        }
        sc.close();
    }

    public List<Arete> getRoutes() {
        return routes;
    }

    /**
     * Renvoie une liste des points connus dans le réseau.
     *
     * @return la liste des points.
     */
    public List<Point> getPoints() {
        return new ArrayList<>(mapPoints.values());
    }


    /**
     * Renvoie le point du réseau à partir de son identifiant
     *
     * @param id identifiant du point recherché
     * @return un point {@code Point} du réseau ou {@code null}  si l'identifiant n'est pas trouvé.
     */
    public Point getPointById(int id) {
        return mapPoints.get(id);
    }

}
