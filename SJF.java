import java.util.Scanner;

public class SJF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int BT[],P[],WT[],TAT[],n,total=0;
        float avg_wt,avg_tat;
        System.out.println("Enter the number of processes :");
        n= sc.nextInt();
        BT = new int[n];
        P = new int[n];
        WT = new int[n];
        TAT = new int[n];

        System.out.println("Enter the Burst time of the process :");
        for (int i = 0; i < n; i++) {
            System.out.println("P["+(i+1)+"]:");
            BT[i] = sc.nextInt();
            P[i] = i+1;
        }

        // here we will select the process which will have shortest burst time

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(BT[j]<BT[i]){
                    int temp = BT[i];
                    BT[i] =BT[j];
                    BT[j] =temp;
                    
                    temp = P[i];
                    P[i] = P[j];
                    P[j] = temp;
                }
            }
        }

        // calculating of waiting time;
         WT[0]=0;
         for (int i = 1; i < n; i++) {
            WT[i] =0;
            for (int j = 1; j < i; j++) {
                WT[i] += BT[i];
            }
            total += WT[i];
         }
        // WT[0] = 0;
        // for (int i = 1; i < n; i++) {
        //     WT[i] = WT[i - 1] + BT[i - 1];
        //     total += WT[i];
        // }
         avg_wt = (float)total/n;
         total=0;

         System.out.println("\nProcess\tBurst time\tWaiting time\tTurnAround time\n");
         for (int i = 0; i < n; i++) {
             TAT[i] = BT[i]+WT[i]; // turn around time calculation
             total+=TAT[i];
             System.out.println("\n"+P[i]+"\t\t"+BT[i]+"\t\t"+WT[i]+"\t\t"+TAT[i]+"\n");
         }
         avg_tat = (float)total/n;
         System.out.println("Average waiting time :"+avg_wt);
         System.out.println("Average TurnAroundTime :"+avg_tat);
 

    }
}
