public class Annuaire extends EnsemblePTrie{
    public Annuaire(){
        super();
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < cardinal; i++){
            if (elements[i] == null) break;
            if (elements[i].getTel() != 0){
                s += "%s\t \t \t | \t%s\n".formatted(elements[i].toString(),
                        elements[i].getTel());
            } else {
                s += "%s\t \t \t |\n".formatted(elements[i].toString());
            }
        }
        return s;
    }

    public int tel(String prenom, String nom){ //-1 si pas dedans, sans trie
        Personne p = new Personne(prenom, nom);
        if (contient(p)){
            for (int i = 0; i < cardinal; i++){
                if (elements[i].equals(p)) return elements[i].getTel();
            }
        }
        return -1;
    }

    public int telTrie(String prenom, String nom){
        Personne p = new Personne(prenom, nom);
        int iD = 0;
        int iF = cardinal - 1;
        int iM = (iD + iF) / 2;
        while (iD <= iF){
            if (p.equals(elements[iM])) {
                return elements[iM].getTel();
            }
            if (p.estAvant(elements[iM])){
                iF = iM - 1;
            } else {
                iD = iM + 1;
            }
            iM = (iD = iF) / 2;
        }

        return -1; // Pas prèsent
    }

    public Personne telInverse(int t){ // null si pas dedans
        for (int i = 0; i < cardinal; i++){
            if (elements[i].getTel() == t) return elements[i];
        }
        return null;
    }
}
