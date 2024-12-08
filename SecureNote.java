/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notetakingapp;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author m7md
 */
public class SecureNote extends Note {
    private String password;

    public SecureNote(String password, String title, String filePath) {
        super(title, filePath);
        this.password = password;
    }
    
    protected boolean verifyPassword(String password){
        return this.password.equals(password);
    }
    
    @Override
    public void saveNote() {
        super.saveNote();
        
        FileManager.saveToTextFile(super.getNoteFolderPath(), this.password);
    }
    
    public void loadNote(String folderPath) {
        super.loadNote(folderPath);
        List passList = FileManager.readFromFile(folderPath);
        this.password = passList.get(0);
    }
    
    
}
