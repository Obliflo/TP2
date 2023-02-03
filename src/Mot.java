/**
 Classe representant un mot.

 @author Departement informatique
 @version 16.0128
 */
class Mot {

    protected String texte;
    /** Constructeur */
    public Mot(String texte){
        this.texte = texte;
    }

    /** Teste l'egalite, insensible a la casse
     * Fonctionne aussi avec des String parce que pourquoi pas*/
    public boolean equals(Object o){
        if (o instanceof Mot){
            return ((Mot) o).texte.toLowerCase().equals(this.texte.toLowerCase());
        } else if (o instanceof String) {
            return ((String) o).toLowerCase().equals(this.texte.toLowerCase());
        }
        return false;
    }

    /** Retourne une version String du mot */
    public String toString() {
        String s = texte;
        s = s.substring(0,1).toUpperCase() + s.substring(1);
        return s;
    }

    /**
     Tests.
     */
    public static void main(String[] args) {
        Mot y = new Mot("Yann");
        System.out.print(y);
        System.out.printf(" egal a YANN ? %s%n", y.equals(new Mot("YANN")));

        Mot x = new Mot("John");
        System.out.print(x);
        System.out.printf(" egal a YANN ? %s%n", x.equals(new Mot("YANN")));
    }
}
