package practice;

import java.util.Scanner;

public class matrixTests {
	public static void matrixRotate()
	{
		int i, j, k;
	       int arr[][] = new int[4][4];
	       
	       Scanner scan = new Scanner(System.in);
		   
	       System.out.print("Enter 4*4 Array Elements : ");
	       for(i=0; i<4; i++)
	       {
	           for(j=0; j<4; j++)
	           {
	               arr[i][j] = scan.nextInt();
	           }
	       }
		   
	       System.out.print("Transposing Array...\n");
	       for(i=0; i<4; i++)
	       {
	           for(j=i; j<4; j++)
	           {
	        	   	   int temp = arr[i][j];
	               arr[i][j] = arr[j][i];
	               arr[j][i] = temp;
	           }
	       }
	       /*//Swapping the columns of the matrix
	       for(i=0, j= 4; i<j; i++, j--)
	       {
	    	   		int temp[] = arr[i];
	    	   		arr[i] = arr[j];
	    	   		arr[j] = temp;
	       }*/
	       for (i = 0; i < 4; ++i) 
	       {
	    	   		for(j = 0, k = 3; j < k; ++j, --k)
	    	   		{
	    	   			int temp = arr[i][j];
	    	   			arr[i][j] = arr[i][k];
	    	   			arr[i][k] = temp;
	    	   		}
	    	   		//ArrayUtils.reverse(arr);
	       }
	       System.out.print("Transpose of the Matrix is :\n");
	       for(i=0; i<4; i++)
	       {
	           for(j=0; j<4; j++)
	           {
	               System.out.print(arr[i][j]+ " ");
	           }
	           System.out.println();
	       }
	       scan.close();
	}
}
