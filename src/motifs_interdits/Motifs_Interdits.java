package motifs_interdits;

public class Motifs_Interdits {

	public int t;
	public boolean graph[][];
	public boolean contrainte[][][][];
	public boolean unaire[][];
	
	public Motifs_Interdits(String s) {
		
		t = (int) Math.sqrt(s.length());
		graph = new boolean[t][t];
		contrainte = new boolean[t][t][3][3];
		unaire = new boolean[t][3];
		
		conversion(s);
		remplirContrainte();
		
		if (coloriable()){
			System.out.println("Graphe coloriable");
		} else {
			System.out.println("Graphe non coloriable");
		}
		
		//printGraph();
		
	}

	/**
	 * converti une chaine de caractères representant un graphe sous forme d'une ùatrice d'adjacence
	 * en une matrice d'adjacence de booleens
	 * @param s chaine de carac representant le graphe
	 */
	private void conversion(String s){
		for (int i = 0; i < t; i++){
			for (int j = 0; j < t; j++){
				if (s.charAt((i * (t)) + j) == '1'){
					graph[i][j] = true;
				} else {
					graph[i][j] = false;
				}
			}
		}
	}
	
	/**
	 * remplit le tableau de contraintes pour formaliser la contrainte de colorabilité du graphe
	 */
	private void remplirContrainte(){
		for (int i = 0; i < t; i++){
			for (int j = 0; j < t; j++){
				if (graph[i][j]){
					for (int k = 0; k < 3; k++)
						contrainte[i][j][k][k] = true;
				}
			}
		}
	}
	
	/**
	 * teste 10 * (2 ^ (n/2)) fois si le graphe est coloriable selon l'algorithme du sujet
	 * @return colorabilité du graphe avec un taux d'echec de 0.005%
	 */
	private boolean coloriable(){
		return randomColoriable();
	}
	
	/**
	 * teste si le graphe est coloriable selon l'algorithme du sujet
	 * @return colorabilité du graphe avec une probabilité de réussite de 1/(2 ^ (n/2))
	 */
	private boolean randomColoriable(){		
		for (int i = 0; i < t; i++){
			int nb_unaire = 0;
			int derniere_couleur = 0; //sert dans le 3eme cas ou il n'y a que une contrainte unaire, evite de recherche la couleur concernee par la contrainte
			
			for (int k = 0; k < 3; k++){
				if (unaire[i][k]){
					nb_unaire++;
					derniere_couleur = k;
				}
			}
			
			switch (nb_unaire){
			case 3:
				return false;
			case 2:
				//elimVariable(i);
				break;
			case 1:
				elimContrainte(i, derniere_couleur);
			}
		}
		return false;
	}
	
	/**
	 * elimine les contraintes de la forme [(variable, couleur),(autre variable, n'importe quelle couleur)]
	 * @param variable
	 * @param couleur
	 */
	private void elimContrainte(int variable, int couleur){
		//contrainte[variable][][couleur][] = false;
		//contrainte[][variable][][couleur] = false;
	}
	
	private void printGraph(){
		for (int i = 0; i < t; i++){
			for (int j = 0; j < t; j++){
				if (graph[i][j])
					System.out.print("1");
				else 
					System.out.print("0");
			}
			System.out.print("\n");
		}
	}
	
	public static void main(String[] args) {
		
		String s = "011011110011101101100111010011100111101101001010011101111111100111101101011010011101111111011011100011101101100111010011111100001110110111111010101100111100001110110111111000101100111100011110110111111010101100100000101101011010011101111111011011110011101100100111010011011011110011001111100111010011100111101101011010011100111111111100011110110111111010101100100111101001011010011101111111001011110011101101100111010011111100011110110111111000101100100111101101011010011101011111011011110111101101100111010011100111100101011010011101111111100111101101011010011101111111011011110011101101100101010011011011110011101101100101010011111100011110110111111010101100100110101101010010000101111111111100011100110111111010101100011011110011101001100111010011111100011110110111111010101100011011110011101101100111010011011011110011101101100111010011111100011110110111111010101100111100011110110111111010101100";
		
		new Motifs_Interdits(s);

	}

}
