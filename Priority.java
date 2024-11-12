import java.util.Scanner;

public class Priority {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int P[],PP[],BT[],WT[],TAT[],n;
        float awt,atat;
        System.out.println("Enter the number of process :");
        n = sc.nextInt();
        P= new int[n];
        PP= new int[n];
        BT = new int[n];
        WT = new int[n];
        TAT = new int[n];

        
        System.out.println("Enter the burst time and priorities time :");
        for (int i = 0; i < n; i++) {
            System.out.println("P["+(i+1)+"]:");
            BT[i] = sc.nextInt();
            PP[i] = sc.nextInt();
            P[i] = i+1;

        }

        // sorting on the basis of priority

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(PP[i]<PP[j]){
                    int temp = PP[i];
                    PP[i] = PP[j];
                    PP[j] = temp;

                    temp = BT[i];
                    BT[i]= BT[j];
                    BT[j]=temp;

                    temp = P[i];
                    P[i] = P[j];
                    P[j] = temp;
                }
            }
        }

        WT[0]=0;
        awt =0;
        TAT[0]=0;
        atat = TAT[0];

        for (int i = 1; i < n; i++) {
            WT[i] = TAT[i-1];
            awt += WT[i];
            TAT[i] = WT[i]+BT[i];
            atat +=TAT[i];

        }
        System.out.println("\n\tProcess\tPriority \tBurst Time \tTurn_Around_Time\tWait_Time\n");
        for (int i = 0; i < n; i++) {
            
            System.out.println("\n"+P[i]+"\t\t"+PP[i]+"\t\t"+BT[i]+"\t\t"+TAT[i]+"\t\t"+WT[i]+"\n");

            
            
        }
        awt = (float)awt/n;
        atat = (float)atat/n;
        System.out.println("Average waiting time ="+awt);
        System.out.println("Avearge Turn Around Time ="+atat);

    }
}
