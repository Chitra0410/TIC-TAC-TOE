import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Tictactoe {
    static ArrayList<Integer>PlayerPositions=new ArrayList<Integer>();
    static ArrayList<Integer>CPUPositions=new ArrayList<Integer>();

	public static void main(String[] args) {
	
		char[][] board= {{' ' , '|' , ' ' , '|' ,' '},
				{'-' , '+' , '-' , '+' , '-'},
				{' ' , '|' , ' ' , '|' , ' '},
				{'-' , '+' , '-' , '+' , '-'},
				{' ' , '|' , ' ' , '|' , ' '}};
		
		printBoard(board);
		
		while(true) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your placement from (1-9):");
		int Playerpos=sc.nextInt();
		while(PlayerPositions.contains(Playerpos) || CPUPositions.contains(PlayerPositions)) {
		System.out.println("Position taken! Enter a correct position");
		Playerpos=sc.nextInt();
		}				
       
        placePiece(board, Playerpos, "Player");
        String result=winner();
        if(result.length()>0) {
        	System.out.println(result);
        	break;
        }
        
        Random rand=new Random();
        int cpuPos=rand.nextInt(9)+1;
        while(PlayerPositions.contains(cpuPos) || CPUPositions.contains(PlayerPositions)) {
		  cpuPos=rand.nextInt(9)+1;
	}
        placePiece(board, cpuPos, "CPU");
        
     
        printBoard(board);
        
        result=winner();
        if(result.length()>0) {
        	System.out.println(result);
        	break;
        }
		}
        
        winner();
	}
	
	

	//Printing the gameboarcd	
		
		public static void printBoard(char[][]  board) {
		for(char[] row:board) {  //for each row  inside the board
			for(char c:row) {    //for  each character inside the row
				System.out.print(c);
			}
			System.out.println("  ");
		}

	}
		public static void placePiece(char[][] board, int pos, String user) {
			char symbol=' ';
			if(user.equals("Player")) {
				 symbol='X';
				 PlayerPositions.add(pos);
			}
			else if(user.equals("CPU")){
				 symbol='0'; 
				 CPUPositions.add(pos);
		}
			 switch(pos) {
		        case 1: 
		        	board[0][0]=symbol;
		        	break;
		        case 2: 
		        	board[0][2]=symbol;
		        	break;
		        case 3: 
		        	board[0][4]=symbol;
		        	break;	
		        case 4: 
		        	board[2][0]=symbol;
		        	break;
		        case 5: 
		        	board[2][2]=symbol;
		        	break;
		        case 6: 
		        	board[2][4]=symbol;
		        	break;
		        case 7: 
		        	board[4][0]=symbol;
		        	break;
		        case 8: 
		        	board[4][2]=symbol;
		        	break;
		        case 9: 
		        	board[4][4]=symbol;
		        	break;
		        default:
		        	break;
		}

		}
	public static String winner() {
		List topRow=Arrays.asList(1,2,3);
		List midRow=Arrays.asList(4,5,6);
		List bottomRow=Arrays.asList(7,8,9);
		List leftcol=Arrays.asList(1,4,7);
		List midcol=Arrays.asList(2,5,8);
		List rightcol=Arrays.asList(3,6,9);
		List cross1=Arrays.asList(1,5,9);
		List cross2=Arrays.asList(7,5,3);
		
		
		List<List> winning=new ArrayList<List>();
		winning.add(topRow);
		winning.add(midRow);
		winning.add(bottomRow);
		winning.add(leftcol);
		winning.add(midcol);
		winning.add(rightcol);
		winning.add(cross1);
		winning.add(cross2);
		
		for(List l:winning) {
			if(PlayerPositions.containsAll(l)) {
				return "Congratulations you won!!";
			}
			else if(CPUPositions.contains(l)) {
				return "CPU wins! Sorry :(";
			}
			else if(PlayerPositions.size()+ CPUPositions.size()==9){
				return "CAT!";
			}
		}
		
		return "";
	}
}