/**
 Classe representant une personne associee a son numero de telephone.

 @author Departement informatique
 @version 16.0128
 */
public class Personne {

    protected Mot nom;
    protected Mot prenom;
    protected int tel;

    public Personne(String prenom, String nom){
        this.nom = new Mot(nom);
        this.prenom = new Mot(prenom);
    }

    /** Associe le numero de telephone. */
    public void setTel(int tel) {
        this.tel = tel;
    }

    /** Fournit le numero de telephone. */
    public int getTel() {
        return tel;
    }

    /** Teste l'égalite du nom et du prenom */
    public boolean equals(Object o){
        if (o instanceof Personne){
            return this.nom.equals(((Personne) o).nom) && this.prenom.equals(((Personne) o).prenom);
        }
        return false;
    }

    /**
     Produit une chaine indiquant la personne.
     (Par exemple Jules CESAR)
     */
    public String toString() {
        String s = this.prenom.toString() + " " + this.nom.toString().toUpperCase();
        return s;
    }

    /**
     * Regarde si la personne passée est après alphabetiquement
     * @param p Persone à comparer
     * @return True = this est avant
     */
    public boolean estAvant(Personne p){
        if (p == null){
            return true;
        }
        int nomAv = this.nom.texte.compareToIgnoreCase(p.nom.texte);
        if (nomAv < 1){ //Nom avant
            return true;
        } else if (nomAv == 0) { //Nom pareil, on regarde le prénom
            int prenomAv = this.prenom.texte.compareToIgnoreCase(p.prenom.texte);
            if (prenomAv < 1) {
                return true;
            }
        }
        return false;
    }
    /**
     Tests.
     */
    public static void main (String[] args) {

        Personne toto = new Personne("Jean-Claude","Dusse");

        System.out.println(toto);
        System.out.println(toto.toString());

        toto.setTel(4321);
        System.out.println(toto.getTel());

        System.out.println(toto.equals(new Personne("Jean-Claude","DUSSE")));
        System.out.println(toto.equals(new Personne("Jean-Claude","Musse")));
        System.out.println(toto.estAvant(new Personne("Jean-Claude","Van Damme")));

        Personne bornibus = new Personne("Borni", "Bus");
        bornibus.setTel(3421);
        Personne ornicar = new Personne("Orni", "Car");
        ornicar.setTel(2345);

        Annuaire ens = new Annuaire();
        ens.ajouter(toto);
        ens.ajouter(new Personne("Claude", "Jean"));
        ens.ajouter(bornibus);

        System.out.println(ens);

        Annuaire ens2 = new Annuaire();
        ens2.ajouter(toto);
        ens2.ajouter(ornicar);
        ens2.ajouter(ornicar);

        System.out.println(ens2);

        ens.ajouter(toto);
        ens.ajouter(ornicar);
        ens.ajouter(ornicar);

        System.out.println(ens);
        System.out.println(ens.telTrie("Borni", "Bus"));
        System.out.println(ens.tel("Borni", "Bus"));

        //System.out.println(ens.union(ens2));
        //System.out.println(ens.inter(ens2));




    }
}