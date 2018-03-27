package com.newera.test;

import java.util.ArrayList;
import java.util.Scanner;
public class NombreSup {

	  /**
     * @param args the command line arguments
     */
    private int indice;
    private boolean vf;
    
    private static Scanner sc;
    
    
    public static void main(String[] args) {
    	sc = new Scanner(System.in);
    	System.out.println("Entrer un nombre: ");
        System.out.println("le nombre supérieur suivant en utilisant seulement les chiffres du nombre donné est : "+nombreSuivant(sc.nextInt()));
       
    }
    
    
    public static int nombreSuivant(int n)
    {
        String ns=n+"";
        String[] tab=ns.split(""); 
        boolean ok=true;
        String[] recup; 
        String ni="";
        int cpt=0;
        while(ok)
        {
                n++;
                ni=n+"";
                recup=ni.split("");
                ArrayList<NombreSup> l=new ArrayList<NombreSup>();
           newera:for(int i=0;i<tab.length;i++)
                {

                    l=verif(tab,recup,tab[i]);
                    if(l.get(0).isVf()){
                        cpt++;
                        if(cpt==tab.length)
                        {
                            ok=false;
                            break newera;
                        }
                    }else{
                        cpt=0;
                        break newera;
                    }
                }

        }

        return Integer.parseInt(ni);
    }
    
    public static ArrayList<NombreSup> verif(String[]tab,String recup[],String n)
    {
        ArrayList<NombreSup> list=new ArrayList<NombreSup>();
        NombreSup p=new NombreSup();
        p.setVf(false);
        list.add(p);
        
        if(NombreSup.appartient(recup,tab))
        {
                for(int i=0;i<recup.length;i++)
                {
                    if(recup[i].equals(n))
                    {
                        list.get(0).setVf(true);
                        return list;
                    }
                }
        }
        return list;
    }
    
    
    public static boolean appartient(String[]tab1,String[]tab2)
    {
        int k;
        for(String i:tab1)
        {
            k=0;
            for(String j:tab2)
            {
                if(i.equals(j)) k++;
            }
            if(k==0) return false;
        }
        return true;
    }
    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public boolean isVf() {
        return vf;
    }

    public void setVf(boolean vf) {
        this.vf = vf;
    }

}
