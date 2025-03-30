/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

/**
 *
 * @author Rafael
 */
public class MathUtils {
    public static int maxN(int... numbers) {
        int maxNumber = 0;
                
        for (int number: numbers) {
            maxNumber = Math.max(maxNumber, number);
        }
        return maxNumber;
     }
    
    public static int minN(int... numbers) {
        int minNumber = 0;
                
        for (int number: numbers) {
            minNumber = Math.min(minNumber, number);
        }
        return minNumber;
     }
}
