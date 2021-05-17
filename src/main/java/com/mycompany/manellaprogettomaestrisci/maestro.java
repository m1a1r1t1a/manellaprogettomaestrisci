/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.manellaprogettomaestrisci;

import java.time.LocalDateTime;

/**
 *
 * @author Marta Manella
 */
public class maestro 
{
    private int codice;
    private LocalDateTime data;
    private String nome;
    private String cognome;
    private String nomeMaestro;
    private String cognomeMaestro;

    public maestro(int codice, LocalDateTime data, String nome, String cognome, String nomeMaestro, String cognomeMaestro) {
        this.codice = codice;
        this.data = data;
        this.nome = nome;
        this.cognome = cognome;
        this.nomeMaestro = nomeMaestro;
        this.cognomeMaestro = cognomeMaestro;
    }
    

    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNomeMaestro() {
        return nomeMaestro;
    }

    public void setNomeMaestro(String nomeMaestro) {
        this.nomeMaestro = nomeMaestro;
    }

    public String getCognomeMaestro() {
        return cognomeMaestro;
    }

    public void setCognomeMaestro(String cognomeMaestro) {
        this.cognomeMaestro = cognomeMaestro;
    }

    @Override
    public String toString() {
        return "maestro{" + "codice=" + codice + ", data=" + data + ", nome=" + nome + ", cognome=" + cognome + ", nomeMaestro=" + nomeMaestro + ", cognomeMaestro=" + cognomeMaestro + '}';
    }

   
    
    

    
     
    
}
