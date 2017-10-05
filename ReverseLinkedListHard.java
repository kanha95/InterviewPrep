import java.io.*;
import java.util.*;



class node{
    int data;
    node next;
    
    node(int data){
        this.data=data;
        next=null;
    }
    
    
}


 class Main
{
  static node head=null;
 
  
     static void reverseUtil(int l,int r){
         l=l-1;
         
         
         node ptr1=head,ptr2=head,temp=null;
         
         while(r-->0){
             ptr2=ptr2.next;
             if(r==1) temp=ptr2;
         }
         while(--l>0){
             ptr1=ptr1.next;
         }
         
         
         node head2=ptr1.next;
         ptr1.next=null;
         temp.next=null;
                 
        
         reverse(head2,null);
         head2=temp2;
         
      
         ptr1.next=head2;
         
         while(ptr1.next!=null){
             ptr1=ptr1.next;
         }
         ptr1.next=ptr2;
         
         
         node print=head;
         
         while(print!=null){
             System.out.print(print.data+" ");
             print=print.next;
         }
         System.out.println("");
         
     }
  
     static node temp2;
     static void reverse(node curr,node prev){
         
         if(curr==null){
          temp2=prev;  
           return;  
         }
         
         node next=curr.next;
         curr.next=prev;
         
         reverse(next,curr);
         
         
       
         
     }
     
     
     static void insert(int data){
         
         node n=new node(data);
         
         if(head==null){
             head=n;
         }
         else{
             node temp=head;
             
             while(temp.next!=null){
                 temp=temp.next;
             }
             temp.next=n;
         }
         
     }
     
   public static void main(String args[]) throws Exception
	{
		InputReader sc=new InputReader(System.in);		
		PrintWriter w=new PrintWriter(System.out);
    
                
         int n=sc.nextInt();
         
            for (int i = 0; i < n; i++) {
                insert(sc.nextInt());
            }
                
           int l=sc.nextInt();
           int r=sc.nextInt();
            
          reverseUtil(l,r);
           
           
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
