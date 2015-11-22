package com.jason.leetcode;

public class UglyNumber {
	
	public static void main(String[] args) {
		UglyNumber uglyNumber = new UglyNumber();
		
		System.out.println(uglyNumber.nthUglyNumber(1500));
	}
	
	public long nthUglyNumber(int n) {
		if( n <= 0) {
			return 0;
		}
		
		if( n == 1) {
			return 1;
		}
		
		long[] uglyNumbers = new long[n];
		
		int numberFounded = 0;
		uglyNumbers[numberFounded++] = 1;
		while(numberFounded < n) {
			
			long M2 = findM(uglyNumbers, numberFounded, 2);
			long M3 = findM(uglyNumbers, numberFounded, 3);
			long M5 = findM(uglyNumbers, numberFounded, 5);
			
			uglyNumbers[numberFounded++] = findMin(M2, M3, M5);
			
		}
		
        return uglyNumbers[n - 1];
    }	
	
	private long findMin(long M2, long M3, long M5) {
		long min = M2 < M3 ? M2 : M3;		
		
		return min < M5 ? min : M5;
	}
	
	private long findM(long[] uglyNumbers, int numberFound, int number) {
		if(uglyNumbers == null)
			return 1;
		
		long M = 1;
		long currentMax = uglyNumbers[numberFound - 1];
		for(int i = numberFound - 1; i >= 0; i--) {
			long tmp = uglyNumbers[i] * number;
			 if(tmp > currentMax) {
				 M = tmp;
			 }
			 
			 if(tmp <= currentMax) {
				 break;
			 }
		}
		
		return M;
	}
	
	public boolean isUgly(int num) {
        if(num <= 0) {
        	return false;
        }
        
        
        
        while(num % 2 == 0) {
        	num = num / 2;
        }
        
        while(num % 3 == 0) {
        	num = num / 3;
        }
        
        while(num % 5 == 0) {
        	num = num / 5;
        }
        
        return num == 1;
    }
	

}
