//package h;

import java.util.Arrays;
import java.util.Scanner;

public class bakneralgorithm {
    Scanner sc=new Scanner(System.in);

    int np=5;     // no of process
    int nr=3;      // no of resource

    int allocation[][]=new int[np][nr];
    int maxneed[][]=new int[np][nr];
    int need[][]=new int[np][nr];
    int avilable[]=new int[nr];
    boolean visited[]= new boolean[np];
    int count=0;
    int safe[]=new int[np];
    void initilize()
    {
        System.out.println("enter allocation ");
        for(int i=0;i<np;i++)
        {
            for(int j=0;j<nr;j++)
            {
                allocation[i][j]=sc.nextInt();
            }
        }
        System.out.println("enter max need");
        for(int i=0;i<np;i++)
        {
            for(int j=0;j<nr;j++)
            {
                maxneed[i][j]=sc.nextInt();
            }
        }
        System.out.println("enter avilable ");
        for(int i=0;i<nr;i++)
        {
            avilable[i]=sc.nextInt();
        }
        System.out.println("need initialize started... ");
        for(int i=0;i<np;i++)
        {
            for(int j=0;j<nr;j++)
            {
                need[i][j]=maxneed[i][j]-allocation[i][j];
            }
        }
        for(int i=0;i<np;i++)
        {
            visited[i]=false;
        }
    }
    void mainwork()
    {
      while (count<np)
      {
          boolean flag=false;
          for(int i=0;i<np;i++)
          {
              if(visited[i]==false)
              {
                  int j;
                  for(j=0;j<nr;j++)
                  {
                      if(need[i][j]>avilable[j])
                      {
                          break;
                      }
                  }
                  if(j==nr)
                  {
                      System.out.println("value of j :"+j);
                     safe[count++]=i;
                     visited[i]=true;
                     flag=true;
                     for(j=0;j<nr;j++)
                     {
                         avilable[j]=avilable[j]+allocation[i][j];
                     }
                  }
              }
          }
          if(flag==false)
          {
              break;
          }


      }
        if (count < np)
        {
            System.out.println("The System is UnSafe!");
        }
        else
        {
            //System.out.println("The given System is Safe");
            System.out.println("Following is the SAFE Sequence");
            for (int i = 0;i < np; i++)
            {
                System.out.print("P" + safe[i]);
                if (i != np-1)
                    System.out.print(" -> ");
            }
            System.out.println("avilable :"+ Arrays.toString(avilable));
        }

    }

    public static void main(String[] args) {
        bakneralgorithm b=new bakneralgorithm();
        b.initilize();
        b.mainwork();
    }
}
