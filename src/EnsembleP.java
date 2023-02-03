/**
 Classe representant un ensemble de personnes.

 @author Departement informatique
 @version 16.0128
 */
public class EnsembleP {
    protected static final int CAPACITE_INITIAL = 2; //Capacité du tableau au départ, on crée un tableau surdimensionné
    protected int cardinal; //Quantité de personnes dans l'ensemble
    protected Personne[] elements; //Le tableau de personnes

    public EnsembleP(){
        this.elements = new Personne[CAPACITE_INITIAL];
        this.cardinal = 0;
    }

    public void ajouter(Personne p){ //Ajoute à la fin du tableau si le tableau est trop petit on l'augmente ne permet pas les doublons
        if (!contient(p)){
            if (elements.length == cardinal){
                Personne[] e = new Personne[cardinal + 1];
                for (int i = 0; i < cardinal; i++) e[i] = elements[i];
                elements = e;
            }
            elements[cardinal] = p;
            cardinal += 1;
        }
    }

    public void oter(Personne p){
        /* Retire toutes les occurences de p,
        j'ai changer le ajouter
        donc plus besoin d'etre pret
        à enlever plusieurs éléments
        en meme temps mais pas grave
        ça fonctionne */
        int j = 0; //2e variable pour parcourir
        for (int i = 0; i + j < cardinal; i++){
            while (elements[i + j].equals(p)){ //on regarde l'élément i puis i + 1 jusqu'à que i + j soit pas p
                j += 1;
            } //on a donc i + j != p
            if (i+j < cardinal){
                elements[i] = elements[i + j];
            } else {
                elements[i] = null;
            }
        }
        cardinal -= j;
    }

    public boolean contient(Personne p){
        for (int i = 0; i < cardinal; i++){
            if (p.equals(elements[i])){
                return true;
            }
        }
        return false;
    }

    public EnsembleP union(EnsembleP e){
        EnsembleP r = new EnsembleP();
        for (int i = 0; i < this.cardinal; i++){
            r.ajouter(elements[i]);
        }
        for (int i = 0; i < e.cardinal; i++){
            Personne p = e.elements[i];
            if (!r.contient(p)){
                r.ajouter(p);
            }
        }
        return r;
    }

    public EnsembleP inter(EnsembleP e){
        EnsembleP r = new EnsembleP();
        for (int i = 0; i < this.cardinal; i++){
            Personne p = this.elements[i];
            if (e.contient(p)){
                r.ajouter(p);
            }
        }
        return r;
    }

    public String toString(){
        String s = "";
        for (int i = 0; i < cardinal - 1; i++){
            s += "{ " + elements[i].toString() + " }, ";
        }
        s += "{ " + elements[cardinal - 1].toString() + " }";
        return s;
    }
}
