package com.example.demo1.Model.bo;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Panier
{
    Set<Livre> livres=new HashSet<Livre>();

    public Set<Livre> getLivres() {
        return livres;
    }

    public void setLivres(Set<Livre> livres) {
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
