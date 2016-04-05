/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticasegundaunidade;

/**
 *
 * @author Clebeson Canuto
 */
public class Processo {
   private int tam;
   private int id;

    public Processo(int tam, int id) {
        this.tam = tam;
        this.id = id;
    }
 public Processo( int id) {
        this.id = id;
    }
    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    public int getId() {
        return id;
    }

    
   
}
