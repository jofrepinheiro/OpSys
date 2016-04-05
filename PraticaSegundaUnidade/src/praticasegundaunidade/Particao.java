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
public class Particao {

    private int id;
    private int tam;
    private Processo processo;
    private boolean livre=true;
    private int fragmentacao;

    public Particao(int id, int tam, Processo processo) {
        this.id = id;
        this.tam = tam;
        this.processo = processo;
    }

    public Particao(int id, int tam) {
        this.id = id;
        this.tam = tam;
        this.processo = processo;
    }

    public int getId() {
        return id;
    }

    public int getTam() {
        return tam;
    }
public boolean alocarProcesso(Processo processo) throws ProcessAlocationException{
   if(processo.getTam()>tam){
       throw new ProcessAlocationException("O tamanho do processo excede o tamanho da partição");
   }
    if(livre){
        this.processo=processo;
        livre=false;
        tam-=processo.getTam();
        return true;
    }else{
      return false; 
    }
}
    public Processo getProcesso() {
        return processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
    }

}
class ProcessAlocationException extends Exception{

    public ProcessAlocationException(String message) {
        super(message);
    }
   
}
