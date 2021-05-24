/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.manellaprogettomaestrisci;

import Eccezioni.EccezionePosizioneNonValida;
import Eccezioni.EccezionePosizioneNonVuota;
import Eccezioni.FileException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Marta Manella
 */
public class Main implements Serializable
{

    public static void main(String[] args)
    {
        String[] vociMenu = new String[9];
        int sceltaUtente = -1;

        Scanner tastiera = new Scanner(System.in);

        Lezioni a = new Lezioni();
        Prenotazioni prenotazioni;

        int minuti, ore, giorno, mese, anno;
        String nome;
        String cognome;
        String nomeMaestro;
        String cognomeMaestro;
        int id = 0;

        //int id=0;
        String nomeFile = "lezioni.txt";
        String nomeFileBin = "lezioni.bin";

        vociMenu[0] = "esci";
        vociMenu[1] = "aggiungi prenotazione";
        vociMenu[2] = "elimina prenotazione";
        vociMenu[3] = "visualizza tutte le prenotazioni di un cliente";
        vociMenu[4] = "visualizza tutte le ore prenotate in un determinato giorno";
        vociMenu[5] = "visualizza le lezioni prenotate per un maestro in ordine alfabetico di cliente ";
        vociMenu[6] = "visualizza tutte le prenotazioni di un giorno";
        vociMenu[7] = "Esportare in formato CSV tutti gli interventi ";
        vociMenu[8] = "Salva revisioni su file binario";

        try {
            FileInputStream f1 = new FileInputStream(nomeFileBin);

            ObjectInputStream reader = new ObjectInputStream(f1);
            try {
                a = (Lezioni) reader.readObject();
                reader.close();
                System.out.println("\nLettura da file avvevuta correttamente");

            } catch (ClassNotFoundException ex) {
                reader.close();
                System.out.println("\nErrore nella lettura");
            }
        } catch (IOException ex) {
            System.out.println("\nImpossibile accedere al file");

        }

        Menu menu = new Menu(vociMenu);

        do {

            tastiera.nextLine();
            sceltaUtente = menu.sceltaMenu();
            System.out.println("Premi un tasto per continuare...");
            tastiera.nextLine();

            switch (sceltaUtente) {
                case 0: {
                    System.out.println("L'applicazione e' terminata");
                    break;
                }
                case 1: {
                    try
                    {
                         if (a.getnPrenotazioniPresenti() >= a.getN_MAX_PARTECIPANTI()) {
                        System.out.println("Il numero massimo di partecipanti è stato raggiunto");
                        System.out.println("premi un tasto per continuar....");
                        tastiera.nextLine();
                        break;
                    }

                    System.out.println("Nome-->");
                    nome = tastiera.nextLine();
                    System.out.println("Cognome-->");
                    cognome = tastiera.nextLine();
                    System.out.println("nome maestro-->");
                    nomeMaestro = tastiera.nextLine();
                    System.out.println("cognome maestro-->");
                    cognomeMaestro = tastiera.nextLine();
                    System.out.println("Data: ");
                    System.out.println("minuti --> ");
                    minuti = tastiera.nextInt();
                    System.out.println("ora --> ");
                    ore = tastiera.nextInt();
                    System.out.println("Giorno --> ");
                    giorno = tastiera.nextInt();
                    System.out.println("Mese --> ");
                    mese = tastiera.nextInt();
                    System.out.println("Anno --> ");
                    anno = tastiera.nextInt();

                    prenotazioni = new Prenotazioni(id, anno, mese, giorno, ore, minuti, nome, cognome, nomeMaestro, cognomeMaestro);
                    id++;
                    a.aggiungiPrenotazione(prenotazioni);

                    }
                    catch(InputMismatchException e1)
                    {
                        System.out.println("impossibile salvare le informazioni, inseriscile correttamente");
                    }
                     System.out.println("premi un pulsante per continuare");
                     tastiera.nextLine();
                     break;
                        

                }

                case 2: {

                    
                    try
                        {
                            int codice, x;
                            System.out.println("codice-->");
                            codice = tastiera.nextInt();

                            x = a.eliminaPrenotazione(codice);
                            if (x == 0)
                            {
                              System.out.println("eliminazione avvenuta con successo");
                            } 
                            else 
                            {
                                System.out.println("eliminazione non avvenuta");
                            }
                        
                    }
                    catch(InputMismatchException e1)
                    {
                        System.out.println("inserisce un codice formato da solo numeri");
                    }
                    System.out.println("premi un pulsante per continuare");
                     tastiera.nextLine();
                     break;
                    

                }
                case 3: {
                    try
                    {
                        
                    Prenotazioni[] elencoPrenotazioni;
                    String nome1;
                    String cognome1;
                    System.out.println("nome-->");
                    nome1 = tastiera.nextLine();
                    System.out.println("cognome-->");
                    cognome1 = tastiera.nextLine();

                    elencoPrenotazioni = a.visualizzaPrenCliente(nome1, cognome1);

                    for (int i = 0; i < elencoPrenotazioni.length; i++) {
                        if (elencoPrenotazioni[0] == null) {
                            System.out.println("nessuna prenotazione " + nome1 + ";" + cognome1);
                        }
                        if (elencoPrenotazioni[i] != null) {
                            System.out.println(elencoPrenotazioni[i]);
                        } else {
                            break;
                        }
                            
                        }
                    }
                    catch(InputMismatchException e1)
                    {
                      System.out.println("inserisci un nome e un cognome formato da solo lettere");   
                    }
                    System.out.println("premi un pulsante per continuare");
                     tastiera.nextLine();
                     break;
                    


                    }

                

                case 4: 
                {
                    try 
                    {
                            int giorno1, mese1, anno1;
                       LocalDate m;

                       System.out.println("giorno-->");
                       giorno1 = tastiera.nextInt();
                       System.out.println("mese-->");
                       mese1 = tastiera.nextInt();
                       System.out.println("anno-->");
                       anno1 = tastiera.nextInt();


                       m = LocalDate.of(anno1, mese1, giorno1);
                       System.out.println("visualizza ore prenotate in un giorno:" + a.visualizzaOrePrenotate(m));
                    }
                    catch(InputMismatchException e1)
                    {
                        System.out.println("inserisce un codice formato da solo numeri");
                    }
                        System.out.println("premi un pulsante per continuare");
                     tastiera.nextLine();
                     break;
                   

                }
                case 5:
                {
                    Prenotazioni[] elencoMaestro;
                    String nomeMaestro1,cognomeMaestro1;
                    int giorno1, mese1, anno1;
                    LocalDate m;

                    System.out.println("giorno-->");
                    giorno1 = tastiera.nextInt();
                    System.out.println("mese-->");
                    mese1 = tastiera.nextInt();
                    System.out.println("anno-->");
                    anno1 = tastiera.nextInt();
                    
                    tastiera.nextLine();
                    System.out.println("Nome maestro-->");
                    nomeMaestro1=tastiera.nextLine();
                    System.out.println("Cognome maestro-->");
                    cognomeMaestro1=tastiera.nextLine();
                    m = LocalDate.of(anno1, mese1, giorno1);
                    elencoMaestro=a.ordineAlfabetico(m, nomeMaestro1, cognomeMaestro1);
                    try
                    {
                    for(int i=0;i<elencoMaestro.length;i++)
                        {
                            System.out.println("id--> "+elencoMaestro[i].getCodice()+" Cognome--> "+elencoMaestro[i].getCognome()+" Nome--> "+elencoMaestro[i].getNome());
                        }
                    }
                    catch(NullPointerException e1)
                    {
                        System.out.println("impossibile trovare le informazioni, controlla che siano corrette e riprova");
                    }
                    
                     System.out.println("premi un pulsante per continuare");
                     tastiera.nextLine();
                     break;

                }
                
                case 6:
                {
                    int giorno1, mese1, anno1;
                    LocalDate m;
                    Prenotazioni[] elencoLezioni;

                    System.out.println("giorno-->");
                    giorno1 = tastiera.nextInt();
                    System.out.println("mese-->");
                    mese1 = tastiera.nextInt();
                    System.out.println("anno-->");
                    anno1 = tastiera.nextInt();
                    
                   
                    m = LocalDate.of(anno1, mese1, giorno1);
                    elencoLezioni=a.visualizzaTuttePrenotazioni(m);
                    try 
                    {
                        for(int i=0;i<elencoLezioni.length;i++)
                        {
                            System.out.println("id--> "+elencoLezioni[i].getCodice()+" Cognome--> "+elencoLezioni[i].getCognome()+" Nome--> "+elencoLezioni[i].getNome()+" Cognome maestro--> "+elencoLezioni[i].getCognomeMaestro()+" Nome maestro--> "+elencoLezioni[i].getNomeMaestro());
                        }
                    }
                    catch(NullPointerException a1)
                    {
                        System.out.println("impossibile trovare le informazioni, controlla che siano corrette e riprova");
                    }
                     System.out.println("premi un pulsante per continuare");
                     tastiera.nextLine();
                     break;

                    
                        
                    
                }
                case 7:
                {
                    try
                    {
                        a.salvaPrenotazioni(nomeFile);
                        System.out.println("salvataggio avvenuto correttamente");
                                
                    }
                      
                    catch(IOException e1)
                    {
                        System.out.println("impossibile accedere al file le prenotazioni non sono state salvate");
                    }
                    catch(FileException e2)
                    {
                        System.out.println(e2.toString());
                    } 
                    break;
                               
                }
                case 8:
                {
                     try
                     {
                        a.salvaPrenotazioneBin(nomeFileBin);
                        System.out.println("salvataggio avvenuto correttamente");
                     }
                     
                     catch(IOException e1)
                     {
                        System.out.println("impossibile accedere al file binario le prenotazioni non sono state salvate");
                     }
                      catch(FileException e2)
                     {
                        System.out.println(e2.toString());
                     } 
                     break;
                                
                            
                }
                
                  
                
                
            }
                

            

        } while (sceltaUtente != 0);

    }
}
