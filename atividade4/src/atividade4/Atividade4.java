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
        
        int coluna = i.nextInt();
        int linha = i.nextInt();
        
        
        int[][] Matriz = new int[coluna][linha];
        
        
        lim = i.nextInt();
        
        for(int x = 0; x<coluna; x++){
            for(int y = 0; y<linha; y++)
            {
                Matriz[x][y] = i.nextInt();
            }
            
        }
        //System.out.println("Colunas: "+coluna+" Linhas: "+linha);
        return Matriz;
    }
    
    public static void salvarImagem(int[][] imagem, String nameFile){
        try {
        FileWriter fw = new FileWriter(nameFile);
        fw.write("P2");
        fw.write("\n");
        fw.write(Integer.toString(imagem.length));
        fw.write(" ");
        fw.write(Integer.toString(imagem[0].length));
        fw.write("\n");
        fw.write(Integer.toString(lim));
        fw.write("\n");
        for (int i = 0; i < imagem.length; i++) {
            for (int j = 0; j < imagem[i].length; j++) {
                    fw.write(imagem[i][j] + " ");
            }
            fw.write("\n");
        }
        fw.flush();
        } catch (IOException e) {}
    }
    
    public static int[] calcularHistograma(int matriz[][]) {
        int histograma[] = new int[lim + 1];
        int coluna = matriz.length - 1;
        int linha = matriz[0].length - 1;

        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                
                histograma[matriz[i][j]] += 1;
            }
        }

        return histograma;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner in = new Scanner(new FileReader("imagem.pgm"));
        Scanner ler = new Scanner(System.in);

        int[][] imagem;
        int[][] fatiamento1;
        int[][] fatiamento2;
        int[][] transGamma;
        int[][] flip;
        double gamma;
        
        imagem = criaMatriz(in);
        
        
        
        
        
    }
    
}
