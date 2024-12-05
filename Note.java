/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notetakingapp;

import java.util.List;

/**
 *
 * @author m7md
 */
public class Note {
    private String title, content;
    private List<Image> images;
    private List<Sketch> sketchs;

    public Note(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
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
        images.add(image);
    }
    
    public void addSketch(String path, String description) {
        Sketch sketch = new Sketch(path, description);
        sketchs.add(sketch);
    }
    
    public void saveNote(){
        String noteFolderPath = userFolderPath;
        
        StringBuilder note = null;
        
        note.append("Content:\n" + this.content + "\n\n");
        
        note.append("Images:\n");
        int imageCounter = 0;
        for(Image image : this.images) {
            note.append(++imageCounter + ". Path: " + image.getPath());
            note.append("Description: " + image.getDescription());
        }
        
        note.append("Sketchs:\n");
        int sketchCounter = 0;
        for(Sketch sketch : this.sketchs) {
            note.append(++sketchCounter + ". Path: " + sketch.getPath());
            note.append("Description: " + sketch.getDescription());
        }
        
        FileManager.saveToTextFile(noteFolderPath, note.toString());
        
    }
    
    
    
}
