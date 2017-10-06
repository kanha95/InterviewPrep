
import java.io.PrintWriter;

class jam
{
     static int gindex=-1;

     static int fmaxmob(int[] ar,int[] dir){
        
         int maxmob=-1;
         for(int i=0;i<ar.length;i++){
             if(i==0){
                 if(dir[i]==-1) continue;        
             }
             if(i==ar.length-1){
                 if(dir[i]==1) continue;
             }
             
             if(dir[i]==1 && ar[i+1]<ar[i]){
                 if(ar[i]>maxmob){
                     maxmob=ar[i];
                     gindex=i;
                 }
             }
             
             if(dir[i]==-1 && ar[i]>ar[i-1]){
                   if(ar[i]>maxmob){
                     maxmob=ar[i];
                     gindex=i;
                 }
             }
             
             
         }
         
         
         
         return maxmob;
         
     }
     
     static void swap(int[] ar,int index,int[] dir){
     if(dir[index]==1){
         int temp=ar[index];
         ar[index]=ar[index+1];
         ar[index+1]=temp;
         int temp2=dir[index];
         dir[index]=dir[index+1];
         dir[index+1]=temp2;
     }
     else{
          int temp=ar[index];
         ar[index]=ar[index-1];
         ar[index-1]=temp; 
         int temp2=dir[index];
         dir[index]=dir[index-1];
         dir[index-1]=temp2;
         
     }
     
     
 }
     static void dirchange(int maxmob,int[] dir,int[] ar){
         
         for(int i=0;i<ar.length;i++){
             if(ar[i]>maxmob){
                dir[i]= (dir[i]==1)?-1:1;
             }
         }
         
     }
     static void find(int[] ar,int[] dir){
         
         int maxmob=fmaxmob(ar,dir);
         if(maxmob!=-1){
         swap(ar,gindex,dir);
         for(int i=0;i<ar.length;i++){
             System.out.print(ar[i]+" ");
         }
         System.out.println("");
         
         dirchange(maxmob,dir,ar);
         find(ar,dir);
         }
         
         
     }
     
	public static void main(String args[]) throws Exception
	{
		InputReader sc=new InputReader(System.in);		
		PrintWriter pw=new PrintWriter(System.out);
      
                
              int[] ar={2,2,3};
              
              int[] dir={-1,-1,-1};
              
              
              for(int i=0;i<ar.length;i++){
                  System.out.print(ar[i]+" ");
              }
              System.out.println("");
              
              find(ar,dir);
                
                
                
                 }
 }
