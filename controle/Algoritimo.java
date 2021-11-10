package controle;

public class Algoritimo {
	// Gustavo 
	// Lucas

	public static int R = 0;
	public static int C = 0;


	// Esta função irá trocar
	// duas linhas da matrix
	static void swap(int mat[][], int row1, int row2, int col) {
		for (int i = 0; i < col; i++) {
			int temp = mat[row1][i];
			mat[row1][i] = mat[row2][i];
			mat[row2][i] = temp;
		}
	}

	// função irá mostrar a matrix
	public static void display(int mat[][], int row, int col) {
		for (int i = 0; i < row; i++) {

			for (int j = 0; j < col; j++)

				System.out.print(" " + mat[i][j]);

			System.out.print("\n");
		}
	}

	// Função principal para calcular o posto
	public static int rankOfMatrix(int mat[][]) {


		int rank = Math.min(C, R);
		Algoritimo.display(mat, R, C);

		for (int row = 0; row < rank; row++) {

			// Antes de visitar 
			// os elementos da linha, precisamos fazer com que
			// mat[row][0],....mat[row][row-1]
			// é igual a 0. Ou seja, todos os elementos da mesma
			// coluna abaixo sejam igual a zero

			// Caso o elemento da diagonal não seja igual a 0
			// Precisaremos então efetuar a operação
			if (mat[row][row] != 0) {
				for (int col = 0; col < R; col++) {
					if (col != row) {
						// Esta condicional irá
						// garantir que mat[row][row] (o elemento que estamos trabalhando)
						// não seja zerada

						double mult = (double) mat[col][row] / mat[row][row];

						for (int i = 0; i < rank; i++)

							mat[col][i] -= mult * mat[row][i];
					}
				}
			}

			// Mas se o elemento da diagonal já for zero
			// Existem duas possibilidades:
			// 1) Se existe alguma linha abaixo
			// que não seja zero, então é só trocar
			// as linhas e operar a linha que não seja zero

			// 2) Se todos os elementos da coluna
			// abaixo de mat[r][row] são iguais a 0
			// não faz sentido manter esta coluna
			// então removeremos esta coluna
			// trocando a primeira coluna com a ultima
			// e diminuindo o número de colunas por 1
			
			else {
				// Esse valor booleano significará que
				// até o momento, não encontramos algum
				// elemento diferente de 0
				boolean reduce = true;

				// devemos encontrar o elemento
				// que não seja zero nesta coluna
				for (int i = row + 1; i < R; i++) {

					// Esta condicional irá
					// cuidar do caso e trocar as linhas
					if (mat[i][row] != 0) {
						swap(mat, row, i, rank);
						reduce = false;
						break;
					}
				}

				// Se não foi encontrado algum elemento diferente de 0
				// nesta coluna, isto significa
				// que todos os elementos são iguais a 0
				if (reduce) {
					// Diminuiremos o número de colunas
					rank--;

					// Vamos colocar a ultima coluna nesta
					// detalhe que não precisamos apagar a ultima
					// coluna, pois é só fingirmos que ela não existe
					for (int i = 0; i < R; i++)
						mat[i][row] = mat[i][rank];
				}

				// Vamo na mesma linha agora dnvo
				row--;
			}

		}

		Algoritimo.display(mat, R, C);
		return rank;
	}

	// Usamos apenas para testes
	public static void main(String[] args) {

		//int mat[][] = {{ 10, 10, 10 },{ 10, 10, 10},{ 40, 30, 30 }};

		//System.out.print("Rank of the matrix is : " + rankOfMatrix(mat));
	}

}
