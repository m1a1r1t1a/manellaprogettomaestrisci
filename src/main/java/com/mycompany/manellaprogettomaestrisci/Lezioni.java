/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.manellaprogettomaestrisci;

import Eccezioni.FileException;
import java.time.LocalDateTime;
import eccezioni.*;
import java.io.IOException;
import file.TextFile;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;


/**
 *
 * @author Marta Manella
 */
public class Lezioni 
{
    private Prenotazioni[] elencoPrenotazioni;
    private int nPrenotazioniPresenti;
    private final int N_MAX_PARTECIPANTI=50;
    

    public Lezioni() 
    {
        elencoPrenotazioni = new Prenotazioni[N_MAX_PARTECIPANTI];
    }
    
    public int getN_MAX_PARTECIPANTI()
    {
        return N_MAX_PARTECIPANTI;
    }

    public int getnPrenotazioniPresenti() 
    {
        return nPrenotazioniPresenti;
    }
    
    private int aggiungiPrenotazione(Prenotazioni m)
    {
        elencoPrenotazioni [nPrenotazioniPresenti]=new Prenotazioni (m);
        nPrenotazioniPresenti++;
        return 0;
    }
       
    private void aggiornaPosizione(int posizione)
    {
        for(int i=posizione;i<nPrenotazioniPresenti-1; i++)
        {
            elencoPrenotazioni[i]=elencoPrenotazioni[i+1];
        }
        elencoPrenotazioni[nPrenotazioniPresenti-1]=null;
        nPrenotazioniPresenti--;
        
    }
    public  Prenotazioni  getPrenotazioniPosizione ( int  posizione )
    {
        return elencoPrenotazioni [posizione];
    }

     
     public int eliminaPosizione (int codice)
     {
         for(int i=0; i<nPrenotazioniPresenti; i++)
         {
             if(elencoPrenotazioni[i]!=null)
             {
                 if (elencoPrenotazioni[i].getCodice()==codice)
                 {
                     aggiornaPosizione(i);
                     return 0;
                 }
                 
             }
         }
         return -1;
     }
     
     public Prenotazioni []visualizzaPrenCliente(String nome, String cognome)
     {
         Prenotazioni[] visualizzaPrenCliente=new Prenotazioni[getnPrenotazioniPresenti()];
         Prenotazioni prenotazioni;
         int x=0;
         for(int i=0; i<getnPrenotazioniPresenti(); i++)
         {
             if (elencoPrenotazioni[i].getNome().compareToIgnoreCase(nome)==0 && elencoPrenotazioni[i].getCognome().compareToIgnoreCase(cognome)==0 )
             {
                 prenotazioni=elencoPrenotazioni[i];
                 visualizzaPrenCliente[x]=prenotazioni;
                 x++;
             }
         
        }
         return visualizzaPrenCliente;
     }
     
     
     public Prenotazioni[] visualizzaTuttePrenotazioni(LocalDateTime data)
     {
         Prenotazioni[] prenotazioniGiorno=new Prenotazioni[getnPrenotazioniPresenti()];
         Prenotazioni prenotazioni;
         int x=0;
         for(int i=0; i<getnPrenotazioniPresenti(); i++)
         {
             if ( elencoPrenotazioni[i].getData().isEqual(data)==true)
             {
                 prenotazioni=elencoPrenotazioni[i];
                 prenotazioniGiorno[x]=prenotazioni;
                 x++;
             }
         
        }
         return prenotazioniGiorno;
     }
     
     //public Prenotazioni[] visualizzaOrePrenotate()
     
     
     
     
      public  void  salvaPrenotazioni ( String  nomeFile ) throws IOException, FileException  
    {
        
       TextFile f1=new TextFile(nomeFile,'W'); 
       Prenotazioni prenotazioni;
        for ( int i = 0 ; i < nPrenotazioniPresenti; i ++ )
            {
               prenotazioni = getPrenotazioniPosizione (i);
                if (prenotazioni != null )
                {
                    f1 . toFile (prenotazioni . getCodice () + " ; " + prenotazioni . getData () + ";" + prenotazioni . getNome () + ";" + prenotazioni . getCognome () + ";" + prenotazioni . getNomeMaestro() + " ; " +prenotazioni. getCognomeMaestro () + " ; " );
                }
            }
        f1.close();
    }

    public void salvaRevisioneBin(String nomeFile) throws IOException, FileException
    {
        FileOutputStream f1=new FileOutputStream(nomeFile);
        ObjectOutputStream writer=new ObjectOutputStream(f1);
        writer.writeObject(this);
        writer.flush();
        writer.close();
    }
     

    
    
    
   
    
}
