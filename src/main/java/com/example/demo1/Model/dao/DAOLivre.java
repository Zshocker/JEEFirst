package com.example.demo1.Model.dao;

import com.example.demo1.Model.bo.Livre;

import java.util.LinkedList;
import java.util.List;

public class DAOLivre
{
    private static DAOLivre  daoLivre=null;
    List<Livre> livres=new LinkedList<Livre>();
    private DAOLivre(){
        Create(new Livre("R1111","Hajin",45,4));
        Create(new Livre("R4887","Hedo",50,6));
        Create(new Livre("R1462","new World",12,7));
        Create(new Livre("R47644","Old World",45,4));
    }
    public static DAOLivre getInstance()
    {
        if(daoLivre==null)daoLivre=new DAOLivre();
        return daoLivre;
    }
    public void Create(Livre livre){
        livres.add(livre);
    }
    public List<Livre> getLivres(){
        return livres;
    }
    public Livre findByid(int id)
    {
        return livres.stream().filter(liv -> liv.getId()==id).findFirst().get();
    }
}
