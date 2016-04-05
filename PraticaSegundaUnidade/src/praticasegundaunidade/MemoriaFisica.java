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
public class MemoriaFisica {
    private static List<Particao> particoes=new LinkedList<>();
    private static int tam;
    private static int restante;

    public MemoriaFisica(int tam) {
        this.tam = tam;
    }
    
    public static void addParticao(Particao p) throws PartitionException{
         int tam=p.getTam();
        if(tam==0){
          throw new PartitionException("Não pode ser alocada uma partição de tamanho 0 (zero)");  
        }
        if(restante<p.getTam()){
            throw new PartitionException("O tamanho da partição excede o tamanho restante de memória não particionada");
        }
       particoes.add(p);
       restante-=p.getTam();
    }

    public static int getTamanho() {
        return tam;
    }
    
    
}
class PartitionException extends Exception{

    public PartitionException(String message) {
        super(message);
    }
    
}
