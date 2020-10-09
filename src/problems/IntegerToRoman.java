package problems;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {

	private static int findBestFit(int num, int[] values) {
        for (int i = 0; i < values.length; i++) {
            if (num - values[i] >= 0) {
                return values[i];
            }
        }
        return -1; //should never hit this case
    }
	
	public String convert_2(int num) {
		
		StringBuilder result = new StringBuilder();
		
		Map<Integer, String> vals = new HashMap<>();
        vals.put(1, "I");
        vals.put(5, "V");
        vals.put(10, "X");
        vals.put(50, "L");
        vals.put(100, "C");
        vals.put(500, "D");
        vals.put(1000, "M");
        vals.put(4, "IV");
        vals.put(9, "IX");
        vals.put(40, "XL");
        vals.put(90, "XC");
        vals.put(400, "CD");
        vals.put(900, "CM");
        
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        
        while (num > 0) {
            int key = findBestFit(num, values);
            result.append(vals.get(key));
            num-=key;
        }
        
		return result.toString();
	}
	
	public String convert_1(int num) {
		
		if(num == 0) 
            return "";
        
        StringBuilder result = new StringBuilder();
        
        if(num / 1000 != 0) {
            int div = num / 1000;
            for(int i=0 ; i<div ; i++)
                result.append("M");
            num %= 1000;
        }
        if(num / 900 != 0) {
            result.append("CM");
            num %= 900;
        }
        if(num / 500 != 0) {
            int div = num / 500;
            for(int i=0 ; i<div ; i++)
                result.append("D");
            num %= 500;
        }
        if(num / 400 != 0) {
            result.append("CD");
            num %= 400;
        }
        if(num / 100 != 0) {
            int div = num / 100;
            for(int i=0 ; i<div ; i++)
                result.append("C");
            num %= 100;
        }
        if(num / 90 != 0) {
            result.append("XC");
            num %= 90;
        }
        if(num / 50 != 0) {
            int div = num / 50;
            for(int i=0 ; i<div ; i++)
                result.append("L");
            num %= 50;
        }
        if(num / 40 != 0) {
            result.append("XL");
            num %= 40;
        }
        if(num / 10 != 0) {
            int div = num / 10;
            for(int i=0 ; i<div ; i++)
                result.append("X");
            num %= 10;
        }
        if(num / 9 != 0) {
            result.append("IX");
            num %= 9;
        }
        if(num / 5 != 0) {
            int div = num / 5;
            for(int i=0 ; i<div ; i++)
                result.append("V");
            num %= 5;
        }
        if(num / 4 != 0) {
            result.append("IV");
            num %= 4;
        }
        if(num / 1 != 0) {
            int div = num / 1;
            for(int i=0 ; i<div ; i++)
                result.append("I");
        }
        
        return result.toString();
	}
	
	public static void main(String[] args) {
		
		IntegerToRoman obj = new IntegerToRoman();
		
		int num = 2986;
		
		System.out.println(obj.convert_1(num));
		System.out.println(obj.convert_2(num));
	}
}
