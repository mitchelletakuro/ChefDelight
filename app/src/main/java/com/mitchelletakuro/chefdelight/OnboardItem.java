package com.mitchelletakuro.chefdelight;

public class OnboardItem {

        int imageID;
        int  backgroundColor;
        String title;
        String description;



    public OnboardItem (){}

        public int getImageID() {
            return imageID;
        }

        public void setImageID(int imageID) {
            this.imageID = imageID;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setBackgroundColor(int backgroundColor) { this.backgroundColor = backgroundColor; }

        public int getBackgroundColor() { return backgroundColor; }

}

