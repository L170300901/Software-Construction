import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.Instant;
import java.util.*;














public class Main {
	
	
	public static int[][] text =  new int[500][500];//is magic square
			
	public static int n = 0;//n*n magic square
			
			public static void main(String[] args){
		         
		     int i=0,j=0;
		   
			System.out.println("Input the number you want to search file.\n 1: 1.txt\n 2: 2.txt\n 3: 3.txt\n 4: 4.txt\n 5: 5.txt");
		    
		    Scanner keySc = new Scanner(System.in);
			int k = keySc .nextInt();//is the number of text file
		    
		    
		    File file = null;
		    
		    if(k == 1)
		    {
		    	file = new File("1.txt");
		        n = 9;
		    }
		    else if(k == 2)//select the file number
		    {
		    	file = new File("2.txt");
		    	n = 8;
		    }
		    else if(k == 3)
		    {
		    	file = new File("3.txt");
		    	n = 21;
		    }
		    else if(k == 4)
		    {
		    	file = new File("4.txt");
		    	n = 7;
		    }
		    else if(k == 5)
		    {
		    	file = new File("5.txt");
		    	n = 121;
		    }
		    else
		    {
		    	file = new File("");
		    }
		   keySc.close();
		   
			try {
			  
				Scanner sc = new Scanner(file);
				
				while(sc.hasNextInt())//if square have number
				{
					 
					text[i][j] = sc.nextInt();//put the number of text file into magic square
					j++;
					if(j == n)//the last of column
					{
						i++;//increase row
						j=0;
						
					}
					
					
				}
				
				
				
			   sc.close();
				
			  }catch (FileNotFoundException e) {
				
			    
			}
			
			boolean o = true;
			o = isLegalMagicSquares(k);//magic square is true or false
			
			if(o == true)
			{
				System.out.println("correct!");
			}
			else
			{
				System.out.println("sorry is not magic square...");
			}
			
		}
			
			



			
			public static boolean isLegalMagicSquares(int k)
			{
				int sum1 = 0;
				int sumfirst = 0;
				int sum = 0;
				
				
					for(int i=0 ; i<n ; i++)//this is sum of column
					{
						for(int j = 0 ; j<n ; j++)
						{   
						   sum1 += text[i][j]; 
						}
						if(i<1) 
						{
						   sumfirst = sum1;
						   sum = sumfirst;
						   
						}
						if(sumfirst!=sum1)
						{
							return false;
						}
						
						sum1 = 0;
					}
					
					sum1 = 0;
					
					for(int j=0 ; j<n ; j++)//this is sum of row
					{
						for(int i=0 ; i<n ; i++)
						{
							sum1 += text[i][j];
						}
						
						if(j<1)
						{
							sumfirst = sum1;
						}
						if(sumfirst!=sum1 || sum!=sum1)
						{
							return false;
						}
						
						sum1 = 0;
					}
					
					sum1 = 0;
					
					for(int i=0,j=0 ; i<n ; j++,i++)//this is sum of left diagonal
					{
						sum1 += text[i][j];
						
						
					}
					if(sum!=sum1)
					{
						return false;
					}
					
					sum1 = 0;
					
					for(int i=0,j=n-1 ; i<n ; i++,j--)//this is sum of right diagonal
					{
		                sum1 += text[i][j];
		                
		            }
					if(sum!=sum1)
					{
						return false;
					}
					
					sum1 = 0;
					
				
				return true;
				
			}
	
    
    

}