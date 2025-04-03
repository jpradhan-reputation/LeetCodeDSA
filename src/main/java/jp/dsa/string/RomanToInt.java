package jp.dsa.string;

class RomanToInt {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        int romanToInteger = 0;
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            if (s.charAt(i) == 'I') {
                if (i < length-1 && s.charAt(i+1) == 'V'){
                    romanToInteger += 4;
                    ++i;
                } else if (i < length-1 && s.charAt(i+1) == 'X') {
                    romanToInteger += 9;
                    ++i;
                } else{
                    romanToInteger += 1;
                }
            } else if (s.charAt(i) == 'V') {
                romanToInteger += 5;
            } else if (s.charAt(i) == 'X') {
                if (i < length-1 && s.charAt(i + 1) == 'L') {
                    romanToInteger += 40;
                    ++i;
                } else if (i < length-1 && s.charAt(i + 1) == 'C') {
                    romanToInteger += 90;
                    ++i;
                } else {
                    romanToInteger += 10;
                }
            } else if (s.charAt(i) == 'L') {
                romanToInteger += 50;
            } else if (s.charAt(i) == 'C') {
                if (i < length-1 && s.charAt(i+1) == 'D'){
                    romanToInteger += 400;
                    ++i;
                } else if (i < length-1 && s.charAt(i+1) == 'M') {
                    romanToInteger += 900;
                    ++i;
                } else {
                    romanToInteger += 100;
                }
            } else if (s.charAt(i) == 'D') {
                romanToInteger += 500;
            } else if (s.charAt(i) == 'M') {
                romanToInteger += 1000;
            }
        }
        return romanToInteger;
    }
}