/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticasegundaunidade;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Clebeson Canuto
 */
public class MemoriaSecundaria {
    List<Processo> processos = new LinkedList<>();
    public boolean addprocesso(Processo p){
        if(processos.contains(p))
            return false;
        processos.add(p);
        return true;
    }

    public Processo getProcesso(int PID) {
        for (Processo processo : processos) {
            if(PID==processo.getId())
                return processo;
        }
        return null;
    }
    
   
    
}
