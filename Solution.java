//import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		// This board has 4 chains - result should be 4
		// Row 1 has 1 horizontal chain: 3,3,3
		// Row 2 has 1 horizontal chain: 0,0,0
		// Column 1 has 1 vertical chain: 0,0,0,0
		// Column 4 has 1 vertical chain: 2,2,2
		//Assumption column size not changing
		int[][] board = new int[][] { { 0, 3, 3, 3 }, { 0, 0, 0, 2 }, { 0, 1, 4, 2 }, { 0, 9, 8, 2 } };
		int result = Solution.countChains(board);
        System.out.println("Result:"+result);
	}

	public static int countChains(int board[][]) {
		int chainCount = 0;

		// Rotated Board to get columns as rows in input matrix
		int[][] rotatedBoard = getRotatedBoard(board);

		int row = 0;
		while (row < board.length) {
			if (checkChain(board[row])) {
			//	System.out.println("Horizontal:" + Arrays.toString(board[row]));
				chainCount++;
			}
			
			row++;
		}
		
		
		
		int column = 0;
		while (column < rotatedBoard.length) {
			
			if (checkChain(rotatedBoard[column])) {
			//	System.out.println("vertical:" + Arrays.toString(rotatedBoard[column]));
				chainCount++;
			}

			column++;
		}
		return chainCount;
	}

	//check consecutive 3 values are same or not for given array 
	public static boolean checkChain(int chain[]) {
		int count = 0;
	
		while ((count + 2) < chain.length) {
			if (chain[count] == chain[count + 1] && chain[count + 1] == chain[count + 2]) {
				return true;
			}
			count++;
		}
		return false;
	}

	//board rotate columns to rows
	public static int[][] getRotatedBoard(int board[][]) {
		int[][] rotatedBoard = new int[board[0].length][board.length];
		int row = 0;

		while (row < board.length) {
			int column = 0;
			while (column < board[0].length) {
				rotatedBoard[column][row] = board[row][column];
				column++;
			}
			row++;
		}
		return rotatedBoard;
	}

}
