/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticasegundaunidade;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Clebeson Canuto
 */
public class Usuario implements  Runnable{
    private Random r=new Random();
    public Usuario() {
    }
    public void criarNovoProcesso(){
        int tam=r.nextInt()%MemoriaFisica.getTamanho();
        int id=SistemaOperacional.getQtdProcessos();
        SistemaOperacional.addNovoProcesso(new Processo(tam,id));
    }
    
    @Override
    public void run() {
        Random r=new Random();
        while (true){
            if(SistemaOperacional.getQtdProcessos()<30){
               criarNovoProcesso();
            }else{
                break;
            }
            long tempo=r.nextInt()%3000;
            try {
                Thread.sleep(tempo);
            } catch (InterruptedException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        System.out.println("O usuário n4ao irá criar mais processos");
    }
}
