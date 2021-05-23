/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eccezioni;

/**
 *
 * @author Marta Manella
 */
public class EccezionePosizioneNonVuota extends Exception
{
    private int ripiano;
    private int posizione;
    
    public EccezionePosizioneNonVuota(int ripiano, int posizione)
    {
        this.ripiano=ripiano;
        this.posizione=posizione;
                
    }

    public int getRipiano() {
        return ripiano;
    }

    public void setRipiano(int ripiano) {
        this.ripiano = ripiano;
    }

    public int getPosizione() {
        return posizione;
    }

    public void setPosizione(int posizione) {
        this.posizione = posizione;
    }
    
    public String toString()
    {
        String s="";
        s+="la posizione ripiano: "+getRipiano()+ "posizione"+getPosizione()+"non è vuota";
        return s;
    }
    
    
}
