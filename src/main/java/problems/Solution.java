package problems;

import java.util.Arrays;

/*
 * trainname, arrival, depature
T1, 900, 930
T2, 1000, 1100
T3, 1030, 1240
T4, 1100, 200
T5, 800, 1330
 */
public class Solution {
	public static void main(String[] args) {
		int arrival[] = { 900, 1000, 1030, 1100, 800 };
		int departure[] = { 930, 1100, 1240, 1400, 1330 };
		
		Arrays.sort(arrival);
		Arrays.sort(departure);
		int i = 1, j=0, plat_counter=1, train_count;
		train_count = arrival.length;
		while(i < train_count || j < train_count) {
			System.out.println("infinite loop");
			if(arrival[i] < departure[j] && departure[i] > arrival[j]) {
				j++;
				plat_counter++;
			}else if(departure[i] < arrival[j] || arrival[i] > departure[j]){
				plat_counter--;
				i++;
			}
		}
		System.out.println(plat_counter);
	}
}
