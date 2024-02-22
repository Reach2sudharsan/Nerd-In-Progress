package com.company;

//public class Main {
//
//    public static void main(String[] args) {
//	// write your code here
//        System.out.println(fibCalc(5));
//
//    }
//    public static int fibCalc(int num){
//        if(num == 0 || num == 1){
//            return num;
//        }
//        else{
//            return fibCalc(num-2) + fibCalc(num-1);
//        }
//
//
//
//
//
//
//    }
//
//
//
//}
public class Main {
    private String word;

    public static void main(String[] args) {
        Main getIt = new Main("Spider");
        System.out.println(getIt.getFirstLetter());
        System.out.println(getIt.getLastLetter());
        System.out.println(getIt);
    }

    public Main(String s) {
        setString(s);


    }
    public void setString(String s) {
        this.word = s;

    }
    public char getLastLetter() {
        return (word.charAt(word.length()-1));

    }
    public char getFirstLetter() {
        return (word.charAt(0));

    }
    public String toString() {
        return word;

    }

}