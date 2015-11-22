package com.jason.leetcode;

public class ReverseInteger {
	
	public static void main(String[] arg) {
		ReverseInteger reverseInteger = new ReverseInteger();
		System.out.println(reverseInteger.reverse(1534236469));
	}
	
	public int reverse(int x) {
		
		int ret = 0;
		
		while(x != 0) {
			ret = ret * 10 + x %10;
			x /= 10;
		}
		return ret;
		
    }

}
