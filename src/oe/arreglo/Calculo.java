package oe.arreglo;

import java.util.Random;

public class Calculo {

    int respuesta,c;
    float cm;
    Random r = new Random();
    public int Mejor(int N) {
        int A[] = new int[N];
        for(int i=0;i<N;i++){
            A[i]= i;
        }
        Ordenar(A);
        return respuesta = (5*N*N + 7*N - 6) / 2;
    }

    public int Peor(int N) {
        int A[] = new int[N];
        for(int i=0;i<N;i++){
            A[i] = N-i;
        }
        Ordenar(A);
        return respuesta = 6*N*N - 3; 
    }

    public double Medio(int N) {
        int A[] = new int[N];
        for(int i=0;i<N;i++){
            A[i]= r.nextInt(N);
        }
        Ordenar(A);
        return cm = (float) (17*N*N + 7*N - 12)/4;
    }
    
    public void Ordenar(int arr[]){
        c=3;
        for(int i=0; i<arr.length-1;i++){
            c = c + 6 ;
            for(int j=i+1;j<arr.length;j++){
                c = c+5;
                if(arr[i]>arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                    c=c+7;
                }
            }
        }
    }
    
    public int getcontador(){
        return c;
    }
    
    
}
