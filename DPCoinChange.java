import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by student on 4/6/2019.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Number of coins: ");
        int d=scan.nextInt();
        System.out.print("Amount of money: ");
        int M=scan.nextInt();
        System.out.print("Value of coins: ");
        ArrayList<Integer> c=new ArrayList<>(d);
        c.add(0);
        while (d>0){
            c.add(scan.nextInt());
            d--;
        }
        DPChange(M,c,c.size());
    }
    public static void DPChange(int M,ArrayList<Integer> c,int d){
        int[] bestNumCoins=new int[M+1];
        //System.out.println(M+1);
        int coinTaken[]=new int[M+1];
        coinTaken[0]=0;
        bestNumCoins[0]=0;
        for(int m=1;m<=M;m++){
            bestNumCoins[m]=Integer.MAX_VALUE;
            for(int i=1;i<d;i++){
                if(m>=c.get(i)){
                    if((bestNumCoins[m-c.get(i)]+1)<=bestNumCoins[m]){
                        bestNumCoins[m]=bestNumCoins[m-c.get(i)]+1;
                        coinTaken[m]=c.get(i);
                    }
                }
            }
        }

        System.out.println("Coin needed: "+bestNumCoins[M]);
        System.out.print("Coins taken: ");
        coinsTaken(coinTaken,M);
    }
    public static void coinsTaken(int[] coinTaken,int M){
        if(M==0){
            return;
        }
        else {
            coinsTaken(coinTaken,M-coinTaken[M]);
            System.out.print(coinTaken[M] +" ");
        }
    }
}
