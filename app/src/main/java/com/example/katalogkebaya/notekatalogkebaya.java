package com.example.katalogkebaya;

public class notekatalogkebaya {
    private String jeniskebaya, modelkebaya, deskripsi;

    public  notekatalogkebaya(String jeniskebaya, String modelkebaya, String deskripsi) {
        this.jeniskebaya =jeniskebaya;
        this.modelkebaya = modelkebaya;
        this.deskripsi = deskripsi;
    }

    public String getJeniskebaya() {
        return jeniskebaya;
    }

    public void setJeniskebaya(String jeniskebaya) {
        this.jeniskebaya = jeniskebaya;
    }

    public String getModelkebaya() {
        return modelkebaya;
    }

    public void setModelkebaya(String modelkebaya) {
        this.modelkebaya = modelkebaya;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
