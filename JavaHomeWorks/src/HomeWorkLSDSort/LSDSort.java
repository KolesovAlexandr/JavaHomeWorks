package HomeWorkLSDSort;

import java.util.Arrays;
import java.util.Random;

public class LSDSort {

	private static final int MAX = 1000000;
	

	public static void main(String[] args) {
		
		int[] data = generate();
		int[] dataLSD = data.clone();
//		for (int i = 0; i < dataLSD.length; i++) {
//			
//			System.out.println(data[i] + " " + dataLSD[i]);
//		}
		
		long start = System.currentTimeMillis();
		Arrays.sort(data);
		long stop = System.currentTimeMillis();
		
		System.out.println("Elapsed = " + (stop - start));
		
		start = System.currentTimeMillis();
		MyLSDSortBt(dataLSD,4);  //4 bytes
		stop = System.currentTimeMillis();	
		
//		for (int i = 0; i < dataLSD.length; i++) {
//			
//			System.out.println(data[i] + " " + dataLSD[i]);
//		}
			
		
		System.out.println("Elapsed = " + (stop - start));
		
		
		
	}

	private static void MyLSDSortBt(int[] data, int W) {
		
		int R = 256;
		int N = data.length;
		int[] aux = new int[N];
		
		for (int d = 0; d < W; d++) {
            
            int[] count = new int [R + 1];
            
            for (int i = 0; i < N; i++) {
                count[DataByte(data[i],d) + 1]++;
            }
            
            for (int r = 0; r < R; r++) {
                count[r + 1] += count[r];
            }
            
            for (int i = 0; i < N; i++) {
                aux[count[DataByte(data[i],d)]++] = data[i];
            }
            
            for (int i = 0; i < N; i++) {
                data[i] = aux[i];
            }            
        }  
				
	}

	private static int DataByte(int data, int d) {

		data >>>= 8*d; //shift right to byte * d
        data &= 0xff; //mask ...001111111(2)
        return data;
	}

	private static int[] generate() {
		int[] data = new int[MAX];
		
		Random random = new Random();
		
		for (int i = 0; i < data.length; i++) {
			data[i] = random.nextInt(MAX); // 0 - 999999
		}
		
		return data;
	}
	
}
