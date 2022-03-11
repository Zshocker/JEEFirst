package com.example.demo1.Model.bo;

import java.util.Objects;

public class Livre
{
    private static int Count=0;
    private int id=++Count;
    private String isbn;
    private String name;
    private double prix;
    private int qte;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String ISBN) {
        this.isbn = ISBN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Livre(String isbn, String nom, double prix,int qt) {
        this.isbn = isbn;
        name = nom;
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
        Livre livre=new Livre(isbn, name,prix,0);
        Count--;
        livre.id=id;
        return livre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livre livre = (Livre) o;
        return id == livre.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
