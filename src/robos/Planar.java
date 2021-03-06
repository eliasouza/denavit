package robos;

import java.util.ArrayList;
import matrizes.Matriz;
/**
 * @author Eias Gonçalves
 * esgoncalves@ime.eb.br
 * 25/07/2015
 */
public class Planar {    
    static final int n = 3;  
    private static int i;
    
    public static void initPlanar() {     
        //Parâmetros de DH:
        double[] a      =  new double[n];
        double[] d      =  new double[n];
        double[] alpha  =  new double[n];
        double[] q     =  new double[n];
        
        //Inicializar parâmetros de DH:
        a[0]     = 0.5; a[1]     = 0.5; a[2]        = 0.5;
        d[0]     = 0;   d[1]     = 0; d[2]          = 0;
        alpha[0] = 0; alpha[1]   = 0; alpha[2]      = 0;         
        q[0]     = Math.PI; q[1] = Math.PI/2; q[2]  = Math.PI/2;      
        
         //Calcular matrizes:
        ArrayList<double[][]> matrizes;
        matrizes = Matriz.gerarMatriz(q, a, d, alpha, n);
        
        //Obter parâmetros do Jacobiano:
        ArrayList<double[]> pontos = Matriz.calcularMatrizes3DOF(
            matrizes.get(0), matrizes.get(1), matrizes.get(2), n
        );
        
        //Calcular o Jacobiano:
        Matriz.calcularJacobiano(pontos, n);
        
        /*
        //Obter matriz total direta:
        System.out.print("Posição para q: ");
        double x0 = ((a[0]*Math.cos(q[0])) + (a[1]*Math.cos(q[0]+q[1])) + (a[2]*Math.cos(q[0]+q[1]+q[2])));
        double y0 = ((a[0]*Math.sin(q[0])) + (a[1]*Math.sin(q[0]+q[1])) + (a[2]*Math.sin(q[0]+q[1]+q[2])));
        double z0 = (d[0] + d[0] + d[2]);
        System.out.println("[" + x0 + " " + y0 + " " + z0 + "]");        
        */
    }   
}
