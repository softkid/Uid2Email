import java.net.URL;
import java.util.ArrayList;

/**
 * Created by gkarlos on 29/4/2015.
 */
public class UrlUidExtractor {

    private ArrayList<URL> urls;
    private ArrayList<String> output;

    public UrlUidExtractor(ArrayList<URL> urls){
        this.urls = urls;
    }

    public UrlUidExtractor(){
        this.urls = new ArrayList<URL>();
    }

    public void addURL(URL url){
        urls.add(url);
    }

    public int size(){
        return urls.size();
    }

    public void setUrlList(ArrayList<URL> urlList){
        this.urls = urlList;
    }

    public ArrayList<String> getExtractedUidList(){
        return output;
    }






}
