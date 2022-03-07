package com.example.demo1.Model.bo;

import java.util.LinkedList;
import java.util.List;

public class Panier
{
    List<Livre> livres=new LinkedList<Livre>();

    public List<Livre> getLivres() {
        return livres;
    }

    public void setLivres(List<Livre> livres) {
        this.livres = livres;
    }
    public void AddLivre(Livre livre,int qte)
    {
        Livre livre1=livre.Clone();
        livre.setQte(qte);
        livres.add(livre1);
    }
    public void AddLivre(Livre livre)
    {
        AddLivre(livre,1);
    }
}
