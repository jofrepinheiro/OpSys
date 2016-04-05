/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticasegundaunidade;

import com.sun.imageio.spi.RAFImageInputStreamSpi;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Clebeson Canuto
 */
public class SistemaOperacional implements Runnable{
    private CPU cpu;
    private Usuario usuario;
    private GerenciadorDeMemoria gm; 
    private static List<Processo> processos=new LinkedList<>();
    private ExecutorService exe=Executors.newCachedThreadPool();
    public SistemaOperacional() {
        exe.execute(this);
    }
    
    private void realizarBoot(){
       usuario=new Usuario();
       cpu= new CPU(gm);
       GerenciadorDeMemoria gm=new GerenciadorDeMemoria();
       exe.execute(usuario);
       exe.execute(cpu);
       
      ;
    }
    
     public static int getQtdProcessos(){
        return processos.size();
    }
    public static  void addNovoProcesso(Processo p){
        processos.add(p);
    }

    public static List<Processo> getProcessos() {
        return processos;
    }
    
    @Override
    public void run() {
            realizarBoot();
            exe.shutdown();
       while(true);
    }

    
}
