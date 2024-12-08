/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notetakingapp;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author m7md
 */
public class FileManager {
    public static void saveToTextFile(String filePath, String content){
        System.out.println("Text File Was Saved To: " + filePath + ".txt");
        System.out.println("Content:\n" + content);
    }
    
    public static void createFolder(String folderPath){
        System.out.println("Folder Was Created To: " + folderPath);
    }
    
    public static List<String> readFromFile(String filePath) {
        List list = new ArrayList();
        list.add("Mohamed");
        list.add("Mod");
        list.add(filePath);
        return list;
    }
    
    public static void deleteFolder(String folderPath) {
        System.out.println("deleted");
    }
}
