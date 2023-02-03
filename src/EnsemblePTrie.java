public class EnsemblePTrie extends EnsembleP {
    public EnsemblePTrie(){
        super();
    }

    @Override
    public void ajouter(Personne p) {
        if (contient(p)) {
            return;
        }
        Personne[] n = new Personne[cardinal + 1];
        int j = 0;
        for (int i = 0; i < cardinal; i++){
            if(elements[i].estAvant(p)){
                n[i] = elements[i];
            } else {
                j = i; //place trouvé
                break;
            }
        }
        n[j] = p;
        for (int i = j; i < cardinal; i++){
            n[i + 1] = elements[i];
        }
        cardinal += 1;
        elements = n;
    }
}
