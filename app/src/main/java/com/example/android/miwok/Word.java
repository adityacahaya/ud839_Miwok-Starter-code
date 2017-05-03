package com.example.android.miwok;

import android.content.res.Resources;

/**
 * Created by I Kadek Aditya on 5/1/2017.
 */

public class Word {

    private String defaultLanguage;
    private String miwokLanguage;
    private int imageId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int soundId;

    public Word(String defaultLanguage, String miwokLanguage){
        this.defaultLanguage = defaultLanguage;
        this.miwokLanguage = miwokLanguage;
    }

    public Word(String defaultLanguage, String miwokLanguage, int imageId){
        this.defaultLanguage = defaultLanguage;
        this.miwokLanguage = miwokLanguage;
        this.soundId = imageId;
    }

    public Word(String defaultLanguage, String miwokLanguage, int soundId, int imageId){
        this.defaultLanguage = defaultLanguage;
        this.miwokLanguage = miwokLanguage;
        this.imageId = imageId;
        this.soundId = soundId;
    }

    public String getDefaultLanguage() {
        return defaultLanguage;
    }

    public String getMiwokLanguage() {
        return miwokLanguage;
    }

    public int getImageId() { return imageId; }

    public boolean hasImage(){
        return imageId != NO_IMAGE_PROVIDED;
    }

    public int getSoundId() { return soundId; }
}
