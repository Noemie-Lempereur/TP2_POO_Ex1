import java.util.ArrayList;

public class Main {
    static ArrayList<Nourriture> nourritures = new ArrayList<Nourriture>();
    static ArrayList<Pigeon> pigeons = new ArrayList<Pigeon>();
    public static void main(String[] args){
        try {
            while (true) {
                //Nourriture
                int coordoonneeNourriture=0;    //à modifier par rapport à l'endroit où clique l'utilisateur
                boolean rajoutNourriture = true;
                //Update de la nourriture
                for(Nourriture n : nourritures){
                    n.setEtat();
                    if(n.getEtat()== Nourriture.etatNourriture.Perimee){
                        nourritures.remove(n);
                    }
                    //Verification que la coordonnée est libre pour ajouter la nouvelle nourriture
                    if(coordoonneeNourriture!=0 && n.getCoordonnee()==coordoonneeNourriture && rajoutNourriture){
                        rajoutNourriture = false;
                    }
                }
                //Ajout de nouvelle nourriture si aucune nourriture à la même place
                if (coordoonneeNourriture!=0 && rajoutNourriture) {
                    Nourriture nourriture = new Nourriture(coordoonneeNourriture);
                    nourritures.add(nourriture);
                }

                //Pigeon
                int ajout = 1 + (int)(Math.random() * 500000000);
                if (ajout==1) {
                    boolean rajoutPigeon = true;
                    int coordAleatoire = 1 + (int) (Math.random() * (Fenetre.TAILLE));
                    for (Pigeon p : pigeons) {
                        //Verification que la coordonnée est libre pour ajouter le nouveau pigeon
                        if (p.getCoordonnee() == coordAleatoire && rajoutPigeon) {
                            rajoutPigeon = false;
                            break;
                        }

                    }
                    if(rajoutPigeon){
                        Pigeon pigeon=new Pigeon(coordAleatoire);
                        pigeon.start();
                        pigeons.add(pigeon);
                        System.out.println("Ajout pigeon :"+coordAleatoire);
                    }
                }


            }
        }catch(Exception e){
            System.out.println("Erreur dans le main : "+e);
        }
    }
}
