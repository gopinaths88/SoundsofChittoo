package com.tamilnadu.myapplication;

class MusicData {
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getUrl() {
        return url;
    }

    public String getImage() {
        return image;
    }

    public String getThumbnail_image() {
        return thumbnail_image;
    }

    String title,  artist,  url,  image,  thumbnail_image;

    public MusicData(String title, String artist, String url, String image, String thumbnail_image) {
        this.title=title;
        this.artist=artist;
        this.url=url;
        this.image=image;
        this.thumbnail_image=thumbnail_image;
    }
}
