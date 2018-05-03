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
public class HammingDetector {
    static int[][] mat1 = {
        {0, 0, 0, 0},
        {0, 0, 1, 0},
        {0, 1, 0, 0},
        {0, 1, 1, 0},
        {1, 0, 0, 0},
        {1, 0, 1, 0},
        {1, 1, 0, 0},
        {1, 1, 1, 1},
    };
    static int[][] mat2 = {
        {0, 0, 0, 0},
        {0, 0, 1, 0},
        {0, 1, 0, 1},
        {0, 1, 1, 0},
        {1, 0, 0, 0},
        {1, 0, 1, 0},
        {1, 1, 0, 0},
        {1, 1, 1, 0},
    };
    static int[][] mat3 = {
        {0, 0, 0, 0},
        {0, 0, 1, 0},
        {0, 1, 0, 1},
        {0, 1, 1, 0},
        {1, 0, 0, 0},
        {1, 0, 1, 0},
        {1, 1, 0, 0},
        {1, 1, 1, 0},
    };
     
    static SimpleNeuron n1 = new SimpleNeuron(mat1,1);
    static SimpleNeuron n2 = new SimpleNeuron(mat2,2);
    static SimpleNeuron n3 = new SimpleNeuron(mat3,3);   
    
    public static void train() {
         n1.train();
         n2.train();
         n3.train();
    }
    
    public static int[] predict(double[] ar) {
        int a1[] = {(int)ar[0], (int)ar[1], (int)ar[2]};
        int a2[] = {(int)ar[3], (int)ar[4], (int)ar[5]};
        int a3[] = {(int)ar[6], (int)ar[7], (int)ar[8]};
        int out[] = {n1.getOutput(a1), n2.getOutput(a2), n3.getOutput(a3)};
        return out;
    }
    

}




class SimpleNeuron {
    int i1;
    int i2;
    int i3;
    
    int id;
    
    int[][] mat;

    public SimpleNeuron(int[][] mat, int id) {
        this.mat = mat;
        this.id = id;
    }
    
    public int getOutput(int[] a) {
        for(int i = 0; i < mat.length; i++){
            if(mat[i][0] == a[0] && mat[i][1] == a[1] && mat[i][2] == a[2]) {
                return mat[i][3];
            }
        }
        return 0;
    }
    
    public void train(){
        for(int i = 0; i < mat.length; i++){
            int T1, T0;
            if(this.id == 1) {
                T1 = (mat[i][0] != 1 ? 1 : 0) + (mat[i][1] != 1 ? 1 : 0) + (mat[i][2] != 1 ? 1 : 0);
                T0 = (mat[i][0] != 1 ? 1 : 0) + (mat[i][1] != 0 ? 1 : 0) + (mat[i][2] != 1 ? 1 : 0);
                //System.out.println("T1 = " + T1 + " . T0 = " + T0 + " in " + mat[i][0] + " " +  mat[i][1] + " " + mat[i][2]);
                if(T1 < T0) {
                    mat[i][3] = 1;
                }
                else {
                    mat[i][3] = 0;
                }
            }
            else if(this.id == 2) {
                T1 = (mat[i][0] != 0 ? 1 : 0) + (mat[i][1] != 1 ? 1 : 0) + (mat[i][2] != 0 ? 1 : 0);
                T0 = (mat[i][0] != 1 ? 1 : 0) + (mat[i][1] != 1 ? 1 : 0) + (mat[i][2] != 1 ? 1 : 0);
                if(T1 < T0) {
                    mat[i][3] = 1;
                }
                else {
                    mat[i][3] = 0;
                }
            }
            else if(this.id == 3) {
                T1 = (mat[i][0] != 0 ? 1 : 0) + (mat[i][1] != 1 ? 1 : 0) + (mat[i][2] != 0 ? 1 : 0);
                T0 = (mat[i][0] != 1 ? 1 : 0) + (mat[i][1] != 0 ? 1 : 0) + (mat[i][2] != 1 ? 1 : 0);
                if(T1 < T0) {
                    mat[i][3] = 1;
                }
                else {
                    mat[i][3] = 0;
                }
            }
            
        }
    }
}


