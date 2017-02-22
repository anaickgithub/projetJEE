package hei.projetJEE.entity;

import javax.persistence.*;

/**
 * Created by nicol on 10/02/2017.
 */

@Entity
public class URLPerso {

    static String newURL="";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String url;
    private String urlCourt;
    private boolean perso;

    // Constructeurs
    public URLPerso(){}

    public URLPerso(String pUrl){
        this.url=pUrl;
    }

    // Getters/Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlCourt() {
        return urlCourt;
    }

    public void setUrlCourt(String urlCourt) {
        this.urlCourt = urlCourt;
    }

    public boolean isPerso() {
        return perso;
    }

    public void setPerso(boolean perso) {
        this.perso = perso;
    }


    //Génération urlCourt
    public void raccourcir() {
        String str = newURL;
        int length=str.length();
        byte[] byteStr = str.getBytes();
        int up=length-1;

        while(byteStr[up]>121){
            up--;
            if(up==-1)break;
        }

        if (up==-1)
        {
            str="";
            for(int i=0;i<length+1;i++)
                str+="a";
        }
        else{
            char c=str.charAt(up);
            c++;
            str=str.substring(0,up)+c;
            for(int i=up;i<length-1;i++)
                str+="a";
        }
        newURL=str;
    }

}
