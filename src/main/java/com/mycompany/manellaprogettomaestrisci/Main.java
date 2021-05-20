/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.manellaprogettomaestrisci;
import Eccezioni.FileException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author Marta Manella
 */
public class Main 
{
    public static void main(String[] args) 
    {
        String[] vociMenu=new String[10];
        LocalDate data;
        int giorno,mese,anno;
        String nome, cognome, nomeMaestro,cognomeMaestro;
        int id=0;
        //int id=0;

        String nomeFile="lezioni.txt";
        String nomeFileBin="lezioni.bin";


        vociMenu[0]="esci";
        vociMenu[1]="aggiungi prenotazione";
        vociMenu[2]="elimina prenotazione";
        vociMenu[3]="visualizza tutte le prenotazioni di un cliente";
        vociMenu[4]="visualizza tutte le ore prenotate in un determinato giorno";
        vociMenu[5]="visualizza le lezioni prenotate per un maestro in ordine alfabetico di cliente "; 
        vociMenu[6]="visualizza tutte le prenotazioni di un giorno";
        vociMenu[7]="Esportare in formato CSV tutti gli interventi ";
        vociMenu[8]="Salva revisioni su file binario";
        
         
        do
        {
            
        }
        
        
        
       
}
