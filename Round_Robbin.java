import java.util.Scanner;

public class Round_Robbin
{
    public static void main(String[] args) 
    {
        int process[],AT[],BT[],WT[],TAT[],avg_wt,atat,n,RTime [],quantum,total;
        process = new int[10];
        AT = new int[10];
        BT = new int[10];
        WT = new int[10];
        TAT = new int[10];
        RTime = new int[10];

        Scanner sc = new Scanner(System.in);
        

        System.out.println("Enter the number of process :");
        n = sc.nextInt();

        System.out.println("Enter the burst time of the process :");
        for (int i = 0; i < n; i++) 
        {
            System.out.println("P["+(i+1)+"]:");
            BT[i] = sc.nextInt();
            RTime[i] = BT[i];
            process[i] = i+1;
            WT[i] =0;
        }
        System.out.print("Enter the quantum number for the process exeucution :");
        quantum = sc.nextInt();

        int rp =n;
        int i =0;
        int time =0;

        System.out.println("0");
        WT[0]=0;
        while (rp!=0) 
        {
            if (RTime[i]>quantum) {
                RTime[i] = RTime[i]-quantum;
                System.out.println("|P["+(i+1)+"]|");
                rp--;
                System.out.println(time);                
            }
            else if(RTime[i]<quantum && RTime[i]>0){
                time +=RTime[i];
                RTime[i] = RTime[i]-RTime[i];
                System.out.println("|["+(i+1)+"]|");
                rp--;
                System.out.println(time);
            }
            i++;
            if (i==n) {
                i=0;
            }
        }

    }
}