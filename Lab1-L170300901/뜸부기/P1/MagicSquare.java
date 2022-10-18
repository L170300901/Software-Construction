package P1;

import java.io.*;
import java.util.Scanner;


public class MagicSquare {

    public static void main(String[] args) throws FileNotFoundException {
        MagicSquare main = new MagicSquare();
        for(int i=1; i<=5; i++)
            System.out.println(i+".txt "+main.isLegalMagicSquare("src/P1/txt/"+i+".txt"));
        int num;
        Scanner scan = new Scanner(System.in);
        num = scan.nextInt();
        if(generateMagicSquare(num))
            System.out.println("5.txt "+main.isLegalMagicSquare("src/P1/txt/5.txt"));
    }
    
    
    /** 
     * Determine if the Magic Square is correct.
     * 
     * @param fileName
     *          for read Data from File
     *                  
     * @return True, if it's MagicSquare
     * 
     */
    public boolean isLegalMagicSquare(String fileName) throws FileNotFoundException
    {
        final int N = 1000;
        FileReader filereader= null;
        try {
            File file = new File(fileName);
            filereader = new FileReader(file);
            BufferedReader bufferreader = new BufferedReader(filereader);
            if(file.isFile() && file.canRead())
            {
                String line = "";
                int[][] matrix = new int[N][N];
                int row=0,column=0;
                while((line = bufferreader.readLine()) !=null )
                {
                    String[] num = line.split("\t");
                    int len = num.length;
                    if((row==0&&len>column)||(row!=0&&len==column))
                        column=len;
                    else
                        return false;
                    for(int i=0; i<len; i++)
                    {
                        if(num[i].contains(".")||num[i].contains(" ")||num[i].contains("-"))
                        {
                            return false;
                        }
                        matrix[row][i]=Integer.valueOf(num[i]);
                    }
                    row++;
                }
                bufferreader.close();
                if(row!=column)
                    return false;
                int sum1,sum2,sum3,sum4;
                sum1=sum2=sum3=sum4=0;
                for(int j=0; j<column; j++)
                {
                    sum1+=matrix[0][j];
                }
                for(int i=0; i<column; i++)
                {
                    sum2=0;
                    for(int j=0; j<column; j++)
                        sum2+=matrix[i][j];
                    if(sum1!=sum2)
                        return false;
                }
                for(int i=0; i<column; i++)
                {
                    sum2=0;
                    for(int j=0; j<column; j++)
                        sum2+=matrix[j][i];
                    if(sum1!=sum2)
                        return false;
                }
                for(int i=0; i<column; i++)
                    sum3+=matrix[i][i];
                if(sum1!=sum3)
                    return false;
                for(int i=0; i<column; i++)
                    sum4+=matrix[column-1-i][i];
                if(sum1!=sum4)
                    return false;
            }
            }
            catch(FileNotFoundException e){
                e.printStackTrace();
            }
            catch(IOException e) {
                System.out.println(e);
            }
            return true;
    }
    
    /**
     * Generate MagicSquare
     * if input number is Odd Number,
     * it will print error and exit program
     * 
     * @param n
     *          generate nXn MagicSquare
     *          
     * @return boolean true, if it is MagicSquare
     *         use isLegalMagicSquare function
     */
    public static boolean generateMagicSquare(int n) { 
        if(n<0||n%2==0)
        {
            System.out.println("有错误");
            return false;
        }
        int magic[][] = new int[n][n];   
        int row = 0, col = n / 2, i, j, square = n * n; 
       
        for (i = 1; i <= square; i++) {    
            magic[row][col] = i;    
            if (i % n == 0)     
                row++;    
            else {     
                if (row == 0)      
                    row = n - 1;     
                else row--;     
                if (col == (n - 1))      
                    col = 0;     
                else      
                    col++;    
                }   
            }
        try {
            File file = new File("src/P1/txt/5.txt");
            BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
            if(file.isFile() && file.canWrite())
            {
                for (i = 0; i < n; i++) {    
                    for (j = 0; j < n; j++)     
                        bufferedwriter.write(magic[i][j] + "\t");
                    bufferedwriter.newLine();
                }
            }
            bufferedwriter.close();
        }
        catch(IOException e)
        {
           System.out.print(e);
        }
    return true;
    }
}
