package com.aa183.sinta;

public class Model {
    private String id;
    private String negara;
    private String presiden;
    private String benua;
    private String populasi;

    public Model(String id, String negara, String presiden, String benua, String populasi) {
        this.id = id;
        this.negara = negara;
        this.presiden = presiden;
        this.benua = benua;
        this.populasi = populasi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNegara() {
        return negara;
    }

    public void setNegara(String negara) {
        this.negara = negara;
    }

    public String getPresiden() {
        return presiden;
    }

    public void setPresiden(String presiden) {
        this.presiden = presiden;
    }

    public String getBenua() {
        return benua;
    }

    public void setBenua(String benua) {
        this.benua = benua;
    }

    public String getPopulasi() {
        return populasi;
    }

    public void setPopulasi(String populasi) {
        this.populasi = populasi;
    }

}
