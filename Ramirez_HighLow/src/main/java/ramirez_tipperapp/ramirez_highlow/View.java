/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ramirez_tipperapp.ramirez_highlow;
import java.util.Random;
import java.util.Scanner;
/**
 * Angel Ramirez-Rivera IT DEV 110 Assignment 7
 * @author angelramirez-rivera
 */
public class View {
    Scanner input = new Scanner(System.in);
    public void directions(){
        System.out.println("Start by selecting the range for the game Good Luck!");
    }
    public int inputNum(){ 
        int inputNum;
        System.out.println("Enter your guess");
        inputNum = input.nextInt();
        return inputNum;
    } 
    public int inputWager(){
        int wager;
        System.out.println("Enter amount wagered: ");
        wager = input.nextInt();
        return wager;
    }
}