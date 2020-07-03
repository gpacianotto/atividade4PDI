/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author SAMSUNG
 */
public class Atividade4 {

    
    public static int lim;
    
    
    public static int[][] criaMatriz(Scanner i){
        
        String lixo = i.nextLine();
        //System.out.println(lixo);
        lixo = i.nextLine();
        //System.out.println(lixo);
        
        int linha = i.nextInt();
        int coluna = i.nextInt();
        
        
        int[][] Matriz = new int[linha + 1][coluna + 1];
        
        
        lim = i.nextInt();
        
        for(int x = 0; x<linha; x++){
            for(int y = 0; y<coluna; y++)
            {
                Matriz[x][y] = i.nextInt();
            }
            
        }
        System.out.println("Colunas: "+coluna+" Linhas: "+linha);
        return Matriz;
    }
    
    public static void salvarImagem(int[][] imagem, String nameFile){
        
        int coluna = imagem[0].length - 1;
        int linha = imagem.length - 1;
        
        try {
        FileWriter fw = new FileWriter(nameFile);
        fw.write("P2");
        fw.write("\n");
        fw.write(Integer.toString(linha));
        fw.write(" ");
        fw.write(Integer.toString(coluna));
        fw.write("\n");
        fw.write(Integer.toString(lim));
        fw.write("\n");
        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                    fw.write(imagem[i][j] + " ");
            }
            //fw.write("\n");
        }
        fw.flush();
        } catch (IOException e) {}
    }
    
    public static int[] calcularHistograma(int matriz[][]) {
        int histograma[] = new int[lim + 1];
        int coluna = matriz[0].length - 1;
        int linha = matriz.length - 1;

        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                
                histograma[matriz[i][j]] += 1;
            }
        }

        return histograma;
    }
    
    
    public static int[][] equalizarHistograma(int img[][], int[] histograma) {
        
        int coluna = img[0].length - 1;
        int linha = img.length - 1;
        
        int mn = linha * coluna;
        float[] pr = new float[lim + 1];
        int[] sk = new int[lim + 1];

        for (int i = 0; i < pr.length; i++) {
            pr[i] = ((float) histograma[i]) / mn;
        }

        float acumulado = 0.0f;
        for (int i = 0; i < sk.length; i++) {
            acumulado += pr[i];
            sk[i] = (int) Math.round(lim * acumulado);
        }
        
        
        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                img[i][j] = sk[img[i][j]];
            }
        }

        return img;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner in = new Scanner(new FileReader("imagem.pgm"));
        Scanner ler = new Scanner(System.in);

        int[][] imagem;
        int[] histograma;
        int[][] imagemEqualizada;
        double gamma;
        
        imagem = criaMatriz(in);
        
        salvarImagem(imagem, "copia.pgm");
        
        histograma = calcularHistograma(imagem);
        System.out.println("Histograma: ");
        for(int i = 0; i <histograma.length; i++)
        {
            System.out.println(histograma[i]+" ");
        }
        
        imagemEqualizada = equalizarHistograma(imagem, histograma);
        
        salvarImagem(imagemEqualizada, "equalizada.pgm");
        
        
        
    }
    
}
