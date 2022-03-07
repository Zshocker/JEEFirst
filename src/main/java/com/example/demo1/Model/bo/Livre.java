package com.example.demo1.Model.bo;

public class Livre
{
    private static int Count=0;
    private int id=++Count;
    private String ISBN;
    private String Nom;
    private double prix;
    private int qte;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Livre(String ISBN, String nom, double prix,int qt) {
        this.ISBN = ISBN;
        Nom = nom;
        this.prix = prix;
        this.qte=qt;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }
    public Livre()
    {

    }
    public Livre Clone()
    {
        Livre livre=new Livre(ISBN,Nom,prix,0);
        Count--;
        livre.id=id;
        return livre;
    }
}
