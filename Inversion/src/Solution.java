import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Solution {
public static int [] a=new int [65537+100];
public static int[] b=new int [65537+100];
public static int[] c=new int[65537+100];
public static int inf=(int) (Math.pow(10, 9)+100);
public static int counter=0;
public static void mergeSort(int s, int t){
	if(s==t || s+1==t)
		return;
	int mid=(s+t)/2;
	mergeSort(s, mid);
	mergeSort(mid, t);
	merge(s, mid, t);
}
public static void merge(int s, int mid, int t){
	int mid1=mid;
	for(int i=s; i<mid; i++)
		b[i]=a[i];
	for(int i=mid; i<t; i++)
		c[i]=a[i];
	
	b[mid]=inf;
	c[t]=inf;
	int temp=s;
	while(b[s]!=inf || c[mid]!=inf){	
		 if(b[s]<=c[mid]  ){
			a[temp]=b[s];
			temp++;
			s++;	
			
			continue;
		
		}
		 if(b[s]>c[mid] )
		{
			 if(s<mid)
				counter+=(mid1-s);
			a[temp]=c[mid];
			mid++;
			temp++;
			continue;
			

		}
	
	}
}
	public static void main(String[] args) throws IOException {
	//	System.out.println("How many numbers?");
	//	Scanner read=new Scanner(System.in);
	//	 int n=read.nextInt();
			 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(in.readLine());
			int n=Integer.parseInt(st.nextToken());
			st=new StringTokenizer(in.readLine());
			 for(int i=0; i < n; i++){
				a[i]=Integer.parseInt(st.nextToken());
			 }

		  //  a[i] = Integer.parseInt(st.nextToken());
		    
	//		 a[i]=read.nextInt();
			mergeSort(0,n);
	
	//for(int i=0; i<n; i++)
	//	System.out.print (a[i]+"\t");
//	System.out.print("\n");
	System.out.println(counter);

	
	}

}

