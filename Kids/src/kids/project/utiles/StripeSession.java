/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kids.project.utiles;

/**
 *

 */
public final class StripeSession {

    private static StripeSession instance;
    private String url;

    public StripeSession(String url) {
        this.url = url;
    }

    public static StripeSession getInstance() {
        return instance;
    }

    public static StripeSession getInstance(String url) {
        if (instance == null) 
        {
            instance = new StripeSession(url);
        }
        return instance;
    }

    public static void setInstance(StripeSession instance) {
        StripeSession.instance = instance;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
