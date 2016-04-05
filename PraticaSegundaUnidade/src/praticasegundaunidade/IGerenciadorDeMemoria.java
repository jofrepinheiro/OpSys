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
public interface IGerenciadorDeMemoria {
   public void realizarSwapping();
   public void alocarProcesso();
   public void selecionarParticao();
   public Processo solicitandoProcesso(CPU cpu);

}
