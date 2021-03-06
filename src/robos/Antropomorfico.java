package robos;
import java.util.ArrayList;
import matrizes.Matriz;
/**
 * @author Eias Gonçalves
 * esgoncalves@ime.eb.br
 * 13/07/2015
 */
public class Antropomorfico {   
    static final int n      = 6;
    private static final double l0  =  0.5;
    private static final double l1  =  0.5;
    private static final double l2  =  0.5;
    private static final double l3  =  0.5;
    private static final double l4  =  0;
    private static final double l5  =  0;
    private static final double l6  =  0.1;
    private static int i;
    
    public static void initAntropormorfico() {     
        //Parâmetros de DH:
        double[] a      =  new double[n];
        double[] d      =  new double[n];
        double[] alpha  =  new double[n];
        double[] qa     =  new double[n];
        double[] qb     =  new double[n];
        double[] qc     =  new double[n];
        
        //Inicializar parâmetros de DH:
        a[0]=0; a[1]=l2; a[2]=0; a[3]=0; a[4]=0; a[5]=0;
        d[0]=l0+l1; d[1]=0; d[2]=0; d[3]=l3+l4; d[4]=0; d[5]=l5+l6;
        alpha[0]=Math.PI/2; alpha[1]=0; alpha[2]=Math.PI/2; 
        alpha[3]=(-Math.PI/2); alpha[4]=Math.PI/2; alpha[5]=0;
        qa[0]=0; qa[1]=0; qa[2]=0; qa[3]=0; qa[4]=0; qa[5]=0;
        qb[0]=Math.PI/2; qb[1]=0; qb[2]=Math.PI/2; qb[3]=0; 
        qb[4]=Math.PI/2; qb[5]=Math.PI/2;
        qc[0]=Math.PI/2; qc[1]=Math.PI/6; qc[2]=(2*Math.PI)/3; 
        qc[3]=0; qc[4]=0; qc[5]=Math.PI/2;
        
        //Calcular Posição para qa:
        ArrayList<double[][]> matrizes;
        matrizes = Matriz.gerarMatriz(qa, a, d, alpha, n);
        System.out.print("Posição para qa: ");
        Matriz.calcularMatrizes6DOF(
                matrizes.get(0), matrizes.get(1), matrizes.get(2), 
                matrizes.get(3), matrizes.get(4), matrizes.get(5), n
        );
        
        //Calcular posição para qb:
        matrizes = Matriz.gerarMatriz(qb, a, d, alpha, n);
        System.out.print("Posição para qb: ");
        Matriz.calcularMatrizes6DOF(
                matrizes.get(0), matrizes.get(1), matrizes.get(2), 
                matrizes.get(3), matrizes.get(4), matrizes.get(5), n
        );
        
        //Calcular posição para qc:
        matrizes = Matriz.gerarMatriz(qc, a, d, alpha, n);
        System.out.print("Posição para qc: ");
        Matriz.calcularMatrizes6DOF(
                matrizes.get(0), matrizes.get(1), matrizes.get(2), 
                matrizes.get(3), matrizes.get(4), matrizes.get(5), n
        );
    }
}
