import java.io.*;
import java.util.*;



 class Main
{
     
    static int mergeSort(int[] ar,int start,int end){
        int inv_count=0;
        if(start<end){
        int mid=start+((end-start)/2);
        inv_count=mergeSort(ar,start,mid);
        inv_count+=mergeSort(ar,mid+1,end);
        inv_count+=merge(ar,start,mid,end);
        }  
       return inv_count;
    }
    
    static int merge(int[] ar,int start,int mid,int end){
        int inv_count=0;
        int n1=mid-start+1;
        int n2=end-mid;
        
        
        int[] temp=new int[ar.length];
        int[] L=new int[n1];
        int[] R=new int[n1];
        
        for (int i = 0; i < n1; i++) {
            L[i]=ar[start+i];
        }
        
        for (int i = 0; i < n2; i++) {
            R[i]=ar[mid+1+i];
        }
        
        int k=start;
        int i=0,j=0;
        
        while(i<n1 && j<n2){
            
            if(L[i]<=R[j]){
                ar[k]=L[i];
                i++;
            }
            else{
                ar[k]=R[j];
                j++;
                inv_count+=(mid-(start+i)+1);
            }
            k++;
        }
        
        while(i<n1){
            ar[k]=L[i];
            i++;k++;
        }
         while(j<n2){
            ar[k]=R[j];
            j++;k++;
        }
         //System.out.println(inv_count);
        return inv_count;
    }
   public static void main(String args[]) throws Exception
	{
		InputReader sc=new InputReader(System.in);		
		PrintWriter w=new PrintWriter(System.out);
    
              int[] ar={2,4,1,3,5,1,1,1,2};
            
            System.out.println(mergeSort(ar,0,ar.length-1));
          
             for(int i=0;i<ar.length;i++){
            System.out.print(ar[i]+" ");
          }
          
                
 }
 }
	 class InputReader
	{
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;
		
		public InputReader(InputStream stream)
		{
			this.stream = stream;
		}
		
		public int read()
		{
			if (numChars==-1) 
				throw new InputMismatchException();
			
			if (curChar >= numChars)
			{
				curChar = 0;
				try 
				{
					numChars = stream.read(buf);
				}
				catch (IOException e)
				{
					throw new InputMismatchException();
				}
				
				if(numChars <= 0)				
					return -1;
			}
			return buf[curChar++];
		}
	 
		public String nextLine()
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
		}
		public int nextInt()
		{
			int c = read();
			
			while(isSpaceChar(c)) 
				c = read();
			
			int sgn = 1;
			
			if (c == '-') 
			{
				sgn = -1;
				c = read();
			}
			
			int res = 0;
			do 
			{
				if(c<'0'||c>'9') 
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			}
			while (!isSpaceChar(c)); 
			
			return res * sgn;
		}
		
		public long nextLong() 
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') 
			{
				sgn = -1;
				c = read();
			}
			long res = 0;
			
			do 
			{
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			}
			while (!isSpaceChar(c));
				return res * sgn;
		}
		
		public double nextDouble() 
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') 
			{
				sgn = -1;
				c = read();
			}
			double res = 0;
			while (!isSpaceChar(c) && c != '.') 
			{
				if (c == 'e' || c == 'E')
					return res * Math.pow(10, nextInt());
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			}
			if (c == '.') 
			{
				c = read();
				double m = 1;
				while (!isSpaceChar(c)) 
				{
					if (c == 'e' || c == 'E')
						return res * Math.pow(10, nextInt());
					if (c < '0' || c > '9')
						throw new InputMismatchException();
					m /= 10;
					res += (c - '0') * m;
					c = read();
				}
			}
			return res * sgn;
		}
		
		public String readString() 
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do 
			{
				res.appendCodePoint(c);
				c = read();
			} 
			while (!isSpaceChar(c));
			
			return res.toString();
		}
	 
		public boolean isSpaceChar(int c) 
		{
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
	 
		public String next() 
		{
			return readString();
		}
		
		public interface SpaceCharFilter 
		{
			public boolean isSpaceChar(int ch);
		}
	} 
