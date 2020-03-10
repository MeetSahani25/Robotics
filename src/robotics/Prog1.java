package robotics;
import java.util.Scanner;
public class Prog1 
{
		
		int i,j;
		public static double[][] rotationx(double val)
		{
			double degree=Math.toRadians(val);
			double cosval=Math.round ((Math.cos(degree))* 10000.0) / 10000.0;
			double sinval=Math.round ((Math.sin(degree))* 10000.0) / 10000.0;
			double[][] a=new double[4][4];
			a[0][0]=1;
			a[0][1]=0;
			a[0][2]=0;
			a[0][3]=0;
			a[1][0]=0;
			a[1][1]=cosval;
			a[1][2]=-sinval;
			a[1][3]=0;
			a[2][0]=0;
			a[2][1]=sinval;
			a[2][2]=cosval;
			a[2][3]=0;
			a[3][0]=0;
			a[3][1]=0;
			a[3][2]=0;
			a[3][3]=1;
			return a;
		}
		public static double[][] rotationy(double val)
		{
			double degree=Math.toRadians(val);
			double cosval=Math.round ((Math.cos(degree))* 10000.0) / 10000.0;
			double sinval=Math.round ((Math.sin(degree))* 10000.0) / 10000.0;
			double[][] a=new double[4][4];
			a[0][0]=cosval;
			a[0][1]=0;
			a[0][2]=sinval;
			a[0][3]=0;
			a[1][0]=0;
			a[1][1]=1;
			a[1][2]=0;
			a[1][3]=0;
			a[2][0]=-sinval;
			a[2][1]=0;
			a[2][2]=cosval;
			a[2][3]=0;
			a[3][0]=0;
			a[3][1]=0;
			a[3][2]=0;
			a[3][3]=1;
			return a;
		}
		public static double[][] rotationz(double val)
		{
			double degree=Math.toRadians(val);
			double cosval=Math.round ((Math.cos(degree))* 10000.0) / 10000.0;
			double sinval=Math.round ((Math.sin(degree))* 10000.0) / 10000.0;
			double[][] a=new double[4][4];
			a[0][0]=cosval;
			a[0][1]=-sinval;
			a[0][2]=0;
			a[0][3]=0;
			a[1][0]=sinval;
			a[1][1]=cosval;
			a[1][2]=0;
			a[1][3]=0;
			a[2][0]=0;
			a[2][1]=0;
			a[2][2]=1;
			a[2][3]=0;
			a[3][0]=0;
			a[3][1]=0;
			a[3][2]=0;
			a[3][3]=1;
			return a;
		}
		public static double[][] translate(int x,int y,int z)
		{
			double[][] a=new double[4][4];
			a[0][0]=1;
			a[0][1]=0;
			a[0][2]=0;
			a[0][3]=x;
			a[1][0]=0;
			a[1][1]=1;
			a[1][2]=0;
			a[1][3]=y;
			a[2][0]=0;
			a[2][1]=0;
			a[2][2]=1;
			a[2][3]=z;
			a[3][0]=0;
			a[3][1]=0;
			a[3][2]=0;
			a[3][3]=1;
			return a;
		}
		public static double[][] multiply(double a[][],double b[][])
		{
			int i,j,k;
			double c[][]=new double[4][4];
			for(i=0;i<=3;i++){    
				for(j=0;j<=3;j++){    
				c[i][j]=0;      
				for(k=0;k<=3;k++)      
				{      
				c[i][j]+=a[i][k]*b[k][j];      
				}}
			}
			return c;
		}
		public static double[][] multiply1(double a[][],double b[][])
		{
			
			double c[][]=new double[4][4];
			int j=0;
			for(int i=0;i<=3;i++){    
				{    
				c[i][j]=0;      
				for(int k=0;k<=3;k++)      
				{      
				c[i][j]+=a[i][k]*b[k][j];      
				}
				}
			}
			return c;
		}
		public static void main(String args[])
				{
		    Scanner sc= new Scanner(System.in); 
			double ans[][]=new double[4][4];
			
			double p[][]=new double[4][1];
			double org[][]=new double[4][4];
			p[3][0]=1;
			int i;
			
			System.out.println("enter original point");
			System.out.println("enter x coordinate value");
			p[0][0]=sc.nextDouble();
			System.out.println("enter y coordinate value");
			p[1][0]=sc.nextDouble();
			System.out.println("enter z coordinate value");
			p[2][0]=sc.nextDouble();
			
				
			for(i=0;i<4;i++)
			{
				System.out.println(p[i][0]);
			}
			System.out.println("Enter 1 for rotation \nEnter 2 for translation");
			int val=sc.nextInt();
			if(val==1)
			{
				System.out.println("Enter the axis to be rotated about");
				 char axis= sc.next().charAt(0); 
				System.out.println("Enter the angle");
				double angle=sc.nextDouble();
				if(axis=='x')
				{
					org=rotationx(angle);
				}
				
				else if(axis=='y')
				{
					org=rotationy(angle);
				}	
				
				else if(axis=='z')
				{
					org=rotationz(angle);
				}
				for(i=0;i<4;i++)
				{
					for(int j=0;j<4;j++)
					{
					System.out.print(org[i][j]+"\t");
				}
					System.out.println();
				}

				System.out.println();
			}
			if(val==2)
			{
				System.out.println("Enter x coordinate");
				int x1=sc.nextInt();
				System.out.println("Enter y coordinate");
				int y1=sc.nextInt();
				System.out.println("Enter z coordinate");
				int z1=sc.nextInt();
				org=translate(x1,y1,z1);
				for(i=0;i<4;i++)
				{
					for(int j=0;j<4;j++)
					{
					System.out.print(org[i][j]+"\t");
				}
					System.out.println();
				}
				System.out.println();
			}
			while(true)
			{
				System.out.println("Enter 1 for rotation \nEnter 2 for translation\nEnter -1 for exit");
			val=sc.nextInt();
			if(val==1)
			{
				System.out.println("Enter the axis to be rotated about");
				char axis = sc.next().charAt(0);
				System.out.println("Enter the angle");
				double angle=sc.nextDouble();
			
				if(axis=='x')
				{
					ans=rotationx(angle);
				}
				
				else if(axis=='y')
				{
					ans=rotationy(angle);
				}	
				
				else if(axis=='z')
				{
					ans=rotationz(angle);
				}
				for(i=0;i<4;i++)
				{
					for(int j=0;j<4;j++)
					{
					System.out.print(ans[i][j]+"\t");
				}
					System.out.println();
				}
				System.out.println("Enter 1 for transformation about current frame\nEnter 2 for transformation about original frame");
				int frame=sc.nextInt();
				if(frame==1)
				{
					org=multiply(org,ans);
				}
				else if(frame==2)
				{
					org=multiply(ans,org);
				}
				for(i=0;i<4;i++)
				{
					for(int j=0;j<4;j++)
					{
					System.out.print(org[i][j]+"\t");
				}
					System.out.println();
				}

				System.out.println();
			}
			if(val==2)
			{
				System.out.println("Enter x coordinate");
				int x1=sc.nextInt();
				System.out.println("Enter y coordinate");
				int y1=sc.nextInt();
				System.out.println("Enter z coordinate");
				int z1=sc.nextInt();
				System.out.println("Enter 1 for transformation about current frame\nEnter 2 for transformation about original frame");
				int frame=sc.nextInt();
				ans=translate(x1,y1,z1);
				if(frame==1)
				{
					org=multiply(org,ans);
				}
				else if(frame==2)
				{
					org=multiply(ans,org);
				}
				for(i=0;i<4;i++)
				{
					for(int j=0;j<4;j++)
					{
					System.out.print(org[i][j]+"\t");
				}
					System.out.println();
				}

				System.out.println();
			}
			else if(val==-1)
			{
				break;
			}
			}
			double ans1[][]=new double[4][4];
			ans1=multiply1(org,p);
			System.out.println("Final postion");
		
				System.out.println("x="+ans1[1][0]);

				System.out.println("y="+ans1[2][0]);

				System.out.println("z="+ans1[3][0]);
			
				}	
}