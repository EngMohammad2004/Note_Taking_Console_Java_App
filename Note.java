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
public class Note {
    private String title, content, noteFolderPath;
    private List<Image> images = new ArrayList<>();
    private List<Sketch> sketchs = new ArrayList<>();

    public Note() {
        
    }
    
    public Note(String title, String userFolderPath) {
        this.title = title;
        this.noteFolderPath = userFolderPath + "/" + title;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getNoteFolderPath() {
        return noteFolderPath;
    }

    public List<Image> getImages() {
        return images;
    }

    public List<Sketch> getSketch() {
        return sketchs;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public void setSketch(List<Sketch> sketchs) {
        this.sketchs = sketchs;
    }
    
    public void addImage(String path, String description) {
        Image image = new Image(path, description);
        images.addLast(image);
    }
    
    public void addSketch(String path, String description) {
        Sketch sketch = new Sketch(path, description);
        sketchs.addLast(sketch);
    }
    
    public void saveNote(){
        FileManager.createFolder(noteFolderPath);
        
        FileManager.saveToTextFile(noteFolderPath + "/content", title + "\n" + content);
        
        String imagesString = "";
        for(Image image : this.images) {
            imagesString += image.getPath() + ", " + image.getDescription() + "\n";
        }
        FileManager.saveToTextFile(noteFolderPath + "/images", imagesString);
        
        String sketchsString = "";
        for(Sketch sketch : this.sketchs) {
            sketchsString += sketch.getPath() + ", " + sketch.getDescription() + "\n";
        }
        FileManager.saveToTextFile(noteFolderPath + "/sketchs", sketchsString);
        
    }
    
    public void loadNote(String folderPath) {
        try {
            List<String> contentLines = FileManager.readFromFile(folderPath + "/content");
            this.title = contentLines.get(0);
            this.content = String.join("\n", contentLines.subList(1, contentLines.size()));
            loadImages(folderPath);
            loadSketchs(folderPath);
            
        } catch (Exception e) {
            System.out.println("Error Loading Note: " + e);
        }
    }
    
    public void loadImages(String folderPath) {
        try {
            List<String> lines = FileManager.readFromFile(folderPath + "/images");
            
            for(String line : lines) {
                String[] parts = line.split(",", 2);
                String path = parts[0].trim();
                String description = parts[1].trim();
                images.add(new Image(path, description));
            }
        } catch (Exception e) {
            System.out.println("Error Loading Images: " + e);
        }
    }
    
    public void loadSketchs(String folderPath) {
        try {
            List<String> lines = FileManager.readFromFile(folderPath + "/sketchs");
            
            for(String line : lines) {
                String[] parts = line.split(",", 2);
                String path = parts[0].trim();
                String description = parts[1].trim();
                sketchs.add(new Sketch(path, description));
            }
        } catch (Exception e) {
            System.out.println("Error Loading Sketchs: " + e);
        }
    }
    
    public void deleteNote() {
        FileManager.deleteFolder(noteFolderPath);
    }
}
