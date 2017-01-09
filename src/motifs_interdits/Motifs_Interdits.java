package motifs_interdits;

public class Motifs_Interdits {

	public Motifs_Interdits(String s, int taille) {
		
		boolean graph[][] = conversion(s, taille);
		
		printGraph(graph, taille);
		
	}

	private boolean[][] conversion(String s, int taille){
		boolean res[][] = new boolean[taille][taille];
		
		for (int i = 0; i < taille; i++){
			for (int j = 0; j < taille; j++){
				if (s.charAt((i * taille) + j + 1) == '1'){
					res[i][j] = true;
				} else {
					res[i][j] = false;
				}
			}
		}
		
		return res;
	}
	
	private void printGraph(boolean graph[][], int taille){
		for (int i = 0; i < taille; i++){
			for (int j = 0; j < taille; j++){
				System.out.print(graph[i][j]);
			}
			System.out.print("\n");
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		new Motifs_Interdits("011011110011101101100111010011100111101101001010011101111111100111101101011010011101111111011011100011101101100111010011111100001110110111111010101100111100001110110111111000101100", 30);

	}

}
