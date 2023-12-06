package edu.uw.tcss.app.starter;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/**
 * A class that asks simple arithmetic questions to the user.  
 * 
 * @author Charles Bryan
 * @version 1.0
 *
 */
public final class LambdaExpressions {

    /** The number of problems to present. */
    private static final int NUMBER_OF_PROBLEMS = 3;
    
    /** The highest value to use in the math problems. */
    private static final int MAX_VALUE = 12;
        
    /** A random number generator. */
    private static final Random GEN = new Random();

    /**
     * Empty private constructor to avoid instantiation. 
     */
    private LambdaExpressions() { }
    
    /**
     * What does this method do?
     * @param theNumberOfProblems the number of problems
     * @param theMaxValue the max value
     * @param theInput a scanner on console input
     */
    private static void doMath(final int theNumberOfProblems,
                        final IntSupplier theOperand,
                        final String theOperator,
                        final IntBinaryOperator theOperation,
                        final Scanner theInput,
                        final Consumer<String> theOutput) {

        int numberCorrect = 0;
        for (int i = 0; i < theNumberOfProblems; i++) {
            final int x = theOperand.getAsInt();
            final int y = theOperand.getAsInt();
            theOutput.accept(x + " " + theOperator +" " + y + " = ");

            final int answer = theOperation.applyAsInt(x, y);
            final int response = theInput.nextInt();
            
            if (response == answer) {
                theOutput.accept("Correct!");
                numberCorrect++;
            } else {
                theOutput.accept("Incorrect...the answer was " + answer);
            }
        }
        theOutput.accept(numberCorrect + " of " + theNumberOfProblems + " correct.");
    }
    

    /**
     * Main method. 
     * @param theArgs command line arguments
     */
    public static void main(final String[] theArgs) {
 
        doMath(NUMBER_OF_PROBLEMS,
                () -> GEN.nextInt(MAX_VALUE),
                "*",
                SimpleMathOperations::multiply,
                new Scanner(System.in),
                s -> System.out.println(s));

    }

    
    
    
    
    
    
    
    
    
    
   public static int getRando() {
       return GEN.nextInt(MAX_VALUE) + 1;
   }
    
    public static void fillArray(final int[] theArray) {
        for (int i = 0; i < theArray.length; i++) {
            theArray[i] = 10;
        }
    }
    
    public static void logMessage(final String message) {
        System.out.println(message);
    }

    public static void bubbleSort(final int theArray[]) {
        int n = theArray.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (theArray[j] < theArray[j + 1]) {
                    // swap temp and arr[i]
                    int temp = theArray[j];
                    theArray[j] = theArray[j + 1];
                    theArray[j + 1] = temp;
                }
            }
        }
    }
    
    public static String parseLineForHeader(final String theLine) {
        return theLine.split(":")[0];
    }    
}
