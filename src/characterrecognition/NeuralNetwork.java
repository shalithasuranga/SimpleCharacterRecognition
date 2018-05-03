/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characterrecognition;

/**
 *
 * @author Shalitha Suranga
 */
public class NeuralNetwork {
    public Neuron n1 = new Neuron(0.1, 0.2, 0.1);
    public Neuron n2 = new Neuron(0.1, 0.2, 0.1);
    public Neuron n3 = new Neuron(0.1, 0.2, 0.2);
    
    
    public int[][] dataSet =  {
        {1, 1, 1, 0, 1, 0, 0, 1, 0},
        {1, 0, 1, 1, 1, 1, 1, 0, 1},

        
    };
    
    
    public int[][] trainData = {
        {1, 1, 1},
        {0, 0, 0},


    
    };
    
    
    /*public int[][] predictData = {
        {1,1,1,0,1,0,0,1,0},
        {1,0,1,1,1,1,1,0,1},  
        {1,1,1,0,0,0,0,1,0}
    };*/
    
    
    public void train(){
        this.n1.updateWeights();
        this.n2.updateWeights();
        this.n3.updateWeights();
    }
    
    
    public double calcError(){
        return Math.abs((this.n1.tj - this.n1.oj) + (this.n2.tj - this.n2.oj) + (this.n3.tj - this.n3.oj));
    }
}
