/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticasegundaunidade;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Clebeson Canuto
 */
public class CPU implements Runnable{
   private Processo processo;
   private IGerenciadorDeMemoria gerenciador;
   private boolean flag=true;

    public CPU(IGerenciadorDeMemoria gerenciador) {  
        this.gerenciador = gerenciador;
        
    }
   
    public void setProcesso(Processo processo) {
        this.processo = processo;
    }
    
    private void solicitarNovoProcesso() {
        processo=gerenciador.solicitandoProcesso(this);
        if(processo==null){
          flag=false;
        }
    }

    @Override
    public void run(){
        Random aleatorio=new Random();
        long tempo;
        while(flag){
            tempo=aleatorio.nextInt()%3000;
            solicitarNovoProcesso();                
            try {
                Thread.sleep(tempo);
            } catch (InterruptedException ex) {
                Logger.getLogger(CPU.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        JOptionPane.showMessageDialog(null, "CPU parou de executar...");
        //System.out.println("");
    }    
}

class CPUExecuteException extends Exception{

    public CPUExecuteException(String message) {
        super(message);
    }

    
   
}
