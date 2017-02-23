package hei.projetJEE.entity;


/**
 * Created by nicol on 23/02/2017.
 */
public class URL {

    private String url;

    public URL(){};

    public URL(String pUrl){
        this.url = pUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
