import java.util.Scanner;

public class FCFS
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bt[],at[],wt[],tat[],p[],n,total=0;
        float avg_wt,avg_tat;
        System.out.println("Enter the number of process :");
        n = sc.nextInt();
        bt = new int[n];
        at = new int[n];
        wt = new int[n];
        tat = new int[n];
        p = new int[n];


        System.out.println("Enter the arrival time and burst time of the process :");
        for (int i = 0; i < n; i++) {
            System.out.println("P["+(i+1)+"]:");
            at[i] = sc.nextInt();
            bt[i] = sc.nextInt();
            p[i] =i+1;
        }

        // sorting the processes according to arrival time

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(at[j]<at[i]){
                    int temp = at[i];
            at[i] = at[j];
            at[j] = temp;

            temp = bt[i];
            bt[i] = bt[j];
            bt[j] = temp;

            temp = p[i];
            p[i] = p[j];
            p[j]= temp;
                }
                
            }
            
              
        }
        // Waiting time of the processes

        // wt[0] =0;
        // for (int i = 1; i < n; i++) {
        //     wt[i] += wt[i];
        //     total += wt[i];
        // }
        for (int i = 1; i < n; i++) {
            wt[i] =0;
            for (int j = 1; j < i; j++) {
                wt[i] += bt[i];
            }
            total += wt[i];
        }
        avg_wt = (float) total/n;

        // calculate turn around time 

        System.out.println("\nProcess\tArrival Time\tBurst Time\tWaiting Time\tTurnAroundTime\n");
        for (int i = 0; i < n; i++) {
            tat [i] = wt[i]+bt[i];
            total += tat[i];
            System.out.println("\n"+p[i]+"\t\t"+at[i]+"\t\t"+bt[i]+"\t\t"+wt[i]+"\t\t"+tat[i]+"\n");
        }
        avg_tat = (float)total/n;
        System.out.println("Average waiting time :"+avg_wt);
        System.out.println("Average Turn Around Time :"+avg_tat);
    }
}