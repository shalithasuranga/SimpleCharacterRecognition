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
public class Neuron {
    private double i1;
    private double i2;
    private double i3;
    
    private double w1;
    private double w2;
    private double w3;
    
    public double oj;
    public double tj;
    
    public static final double bias = -1;
    public static final double learningRate = 1.0;

    
    public void setInputs(double i1, double i2, double i3) {
        this.i1 = i1;
        this.i2 = i2;
        this.i3 = i3;
    }
    
    public Neuron(double w1, double w2,double w3) {
        this.w1 = w1;
        this.w2 = w2;
        this.w3 = w3;
    }
    
    
        public void updateWeights() {
        this.getOj();
        this.w1 += learningRate * (this.tj - this.oj) * (1 - this.oj) * this.oj * i1;
        this.w2 += learningRate * (this.tj - this.oj) * (1 - this.oj) * this.oj * i2;
        this.w3 += learningRate * (this.tj - this.oj) * (1 - this.oj) * this.oj * i3;
    }
    
    
    
    public double getOj() {
        double x = (i1 * w1 + i2 * w2 + i3 * w3) + bias;
        this.oj = 1 / (1 + Math.pow(Math.E, -x ));
        return Math.round(this.oj * 100) / 100.0;
    }
    

}
 