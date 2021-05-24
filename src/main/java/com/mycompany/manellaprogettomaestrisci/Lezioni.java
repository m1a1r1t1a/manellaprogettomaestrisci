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
import java.io.Serializable;
import java.time.LocalDate;


/**
 *
 * @author Marta Manella
 */
public class Lezioni implements Serializable
{
    private Prenotazioni[] elencoPrenotazioni;
    public int nPrenotazioniPresenti;
    private final int N_MAX_PARTECIPANTI=50;
    
    
    /**
     * costruttore della classe Lezioni 
     */
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
    /**
     * permette di aggiungere una prenotazione 
     * @param m prenotazioni
     * @return 0 se la prenotazione e' andata a buon fine
     */
    public int aggiungiPrenotazione(Prenotazioni m) 
    {
        elencoPrenotazioni [nPrenotazioniPresenti]=new Prenotazioni (m);
        nPrenotazioniPresenti++;
        return 0;
    }
    
    /**
     * permette di aggiornare il codice della prenotazione
     * @param posizione  posizione a cui si trova la prenotazione
     */
    private void aggiornaPosizione(int posizione)
    {
        
        
            for(int i=posizione;i<nPrenotazioniPresenti-1; i++)
        {
            elencoPrenotazioni[i]=elencoPrenotazioni[i+1];
        }
        elencoPrenotazioni[nPrenotazioniPresenti-1]=null;
        nPrenotazioniPresenti--;
        
        }
        
        
    
    /**
     * 
     * @param posizione posizione in cui si trova la prenotazione 
     * @return posizione in cui si trovano le prenotazioni
     */
    public  Prenotazioni  getPrenotazioniPosizione ( int  posizione )
    {
        return elencoPrenotazioni [posizione];
    }

     /**
      * permette di eliminare una prenotazione 
      * @param codice codice numerico della prenotazione
      * @return  se l'eliminazione è avvenuta con successo return 0 altrimenti return -1
      */
     public int eliminaPrenotazione (int codice)
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
     /**
      * permette di visualizzare tutte le prenotazioni effettuate da un cliente 
      * @param nome nome cliente
      * @param cognome cognome cliente
      * @return visualizzaPrenCliente
      */
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
     
     /**
      * permette di visualizzare tutte le prenotazioni  di un determinato giorno 
      * @param data data in cui avvengono le lezioni 
      * @return prenotazioniGiorno, tutte le prenotazioni di quel giorno
      */
     public Prenotazioni[] visualizzaTuttePrenotazioni(LocalDate data2)
     {
         Prenotazioni[] prenotazioniGiorno=new Prenotazioni[getnPrenotazioniPresenti()];
         Prenotazioni prenotazioni;
         int x=0;
         for(int i=0; i<getnPrenotazioniPresenti(); i++)
         {
             if ( elencoPrenotazioni[i].getData2().isEqual(data2)==true)
             {
                 prenotazioni=elencoPrenotazioni[i];
                 prenotazioniGiorno[x]=prenotazioni;
                 x++;
             }
         
        }
         return prenotazioniGiorno;
     }
     /**
      * permette di visualizzare tutte le ore prenotate per un determinato giorno
      * @param data  data delle lezioni
      * @return ore prenotate in un determinato giorno
      */
     public int visualizzaOrePrenotate (LocalDate data2)
     {
         
         int x=0;
         for(int i=0; i<getnPrenotazioniPresenti(); i++)
         {
             if ( elencoPrenotazioni[i].getData2().isEqual(data2)==true)
             {
                x++;
             }
         
        }
         return x;
     }
     // prima cerchiamo il maestro che, se tutto è uguale vanno in un array, che passo a ordinatore in ordine alfabetico
     /**
      * permette di visualizzare le lezioni di un maestro scelto dall'utente in ordine alfabetico di cliente
      * @param data la data in cui viene svolta la lezione 
      * @param nomeMaestro il nome del maestro da cercare 
      * @param cognomeMaestro il cognome del maestro  da cercare
      * @return   le lezioni con un determinato maestro in ordine alfabetico di cliente
      */
     public Prenotazioni[] ordineAlfabetico(LocalDate data2, String nomeMaestro,String cognomeMaestro)
     {
          Prenotazioni[] ordinePrenotazioni=new Prenotazioni[getnPrenotazioniPresenti()];
         Prenotazioni prenotazioni;
         int x=0;
         for(int i=0; i<getnPrenotazioniPresenti(); i++)
         {
             if ( elencoPrenotazioni[i].getData2().isEqual(data2)==true && elencoPrenotazioni[i].getCognomeMaestro().compareToIgnoreCase(cognomeMaestro)==0 && elencoPrenotazioni[i].getNomeMaestro().compareToIgnoreCase(nomeMaestro)==0)
             {
                 prenotazioni=elencoPrenotazioni[i];
                 ordinePrenotazioni[x]=prenotazioni;
                 x++;
             }
         
        }
         ordinePrenotazioni= Ordinatore.selectionSortAlfabeticoPartecipanti(ordinePrenotazioni);
         return ordinePrenotazioni;
         
         
     }
     
     
     
     
     /**
      * permette di salvare le prenotazioni su un file CSV
      * @param nomeFile stringa  
      * @throws IOException eccezione che puo crearsi
      * @throws FileException eccezione che puo crearsi
      */
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
      /**
       * permette  di salvare le lezioni prenotate su un file binario 
       * @param nomeFile stringa che indica il nome del file 
       * @throws IOException eccezione che puo crearsi
       * @throws FileException eccezione che puo crearsi
       */

    public void salvaPrenotazioneBin(String nomeFile) throws IOException, FileException
    {
        FileOutputStream f1=new FileOutputStream(nomeFile);
        ObjectOutputStream writer=new ObjectOutputStream(f1);
        writer.writeObject(this);
        writer.flush();
        writer.close();
    }

    

    
     

    
    
    
   
    
}
