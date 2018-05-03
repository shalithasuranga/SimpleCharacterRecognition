/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characterrecognition;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Shalitha Suranga
 */
public class BackPropagation {
    static final double error = 0.2; // adjust the accepted error.. e = 0.002 gave good output after 30 seconds.
    static boolean reqTraining = true;
    static int iterations = 0;
    static NeuralNetwork net = new NeuralNetwork();
    static int [][] data = net.dataSet;
    static int [][] outputs = net.trainData;
    static double[] predict = new double[9];  
    
    public static void train(){

        
        System.out.println("Started training...");
        System.out.println("Accepted Error = " + error + " | Bias = " + Neuron.bias + " | Learning Rate = " + Neuron.learningRate);
        System.out.println("...........");
        
        while(true) {
            reqTraining = false;
            
            for(int i = 0; i < data.length; i++){

                net.n1.setInputs(data[i][0], data[i][1], data[i][2]);
                net.n2.setInputs(data[i][3], data[i][4], data[i][5]);
                net.n3.setInputs(data[i][6], data[i][7], data[i][8]);
                net.n1.tj = outputs[i][0];
                net.n2.tj = outputs[i][1];
                net.n3.tj = outputs[i][2];
                net.train();
                if(net.calcError() > error) reqTraining = true;
                
                //if(verbose)
                    System.out.println("i = "+ i + " IN " + Arrays.toString(data[i]) + " E = " + net.calcError());
            }
            iterations ++;
            
            if(!reqTraining) break;
            
           
            
        }
        

    }
    
    
    public static double[] preditIt(double[] pred){
        predict = pred;
        System.out.println("Traning Iterations = " + iterations);
        System.out.println("Testing with predict array");
        System.out.println(".............");
        
       // for(int i = 0; i < predict.length; i++){
           
            net.n1.setInputs(predict[0], predict[1], predict[2]);
            net.n2.setInputs(predict[3], predict[4], predict[5]);
            net.n3.setInputs(predict[6], predict[7], predict[8]);
            
            System.out.println("PREDICT => " +  Arrays.toString(predict) + " EXPETED OUT =>  NETWORK OUT => " + "["+ net.n1.getOj() + ", " + net.n2.getOj() + ", " + net.n3.getOj() + "]");
       // }
        
        double out[] = {net.n1.getOj(), net.n2.getOj(), net.n3.getOj()};
        return out;
    }
    
    public static String getOutputFromTrainData(int [][] A, int i){
        if(A.length > i) return Arrays.toString(A[i]);
        return "[UNKNOWN]";
    }
    

}
