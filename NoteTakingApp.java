/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.notetakingapp;

/**
 *
 * @author m7md
 */
public class NoteTakingApp {

    public static void main(String[] args) {
        Note note = new Note("note1", "users/mohamed");
        
        note.setContent("as;ldmkvjads;ip ia usfdoiadfa;lkdjfoie upof\n a;lskdfj a;ldkfj a;ldkfj f a;lkdjf a;fjd; \n ;lakjdf ;adfj oieqpu tyqp y");
        note.addImage("image1", "discre;flaksjdfa;klndv;alv");
        note.addImage("image2", "discre;flaksjdfa;klndv;alv");
        note.addSketch("sketch1", "discre;flaksjdfa;klndv;alv");
        note.addSketch("sketch2", "discre;flaksjdfa;klndv;alv");
        note.saveNote();
    }
}
