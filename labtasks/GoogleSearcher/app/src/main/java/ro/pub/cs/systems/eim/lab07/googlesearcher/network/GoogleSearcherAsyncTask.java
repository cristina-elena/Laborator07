package ro.pub.cs.systems.eim.lab07.googlesearcher.network;

import android.os.AsyncTask;
import android.webkit.WebView;

import java.io.IOException;

import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.ResponseHandler;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.impl.client.BasicResponseHandler;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;

public class GoogleSearcherAsyncTask extends AsyncTask<String, Void, String> {

    private WebView googleResultsWebView;

    public GoogleSearcherAsyncTask(WebView googleResultsWebView) {
        this.googleResultsWebView = googleResultsWebView;
    }

    @Override
    protected String doInBackground(String... params) {

        // TODO exercise 6b)
        // create an instance of a HttpClient object
        HttpClient httpClient = new DefaultHttpClient();
        // create an instance of a HttpGet object, encapsulating the base Internet address (http://www.google.com) and the keyword
        HttpGet httpGet = new HttpGet("http://www.google.com/" + params[0]);
        // create an instance of a ResponseHandler object
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        // execute the request, thus generating the result
        try {
            return httpClient.execute(httpGet, responseHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void onPostExecute(String content) {

        // TODO exercise 6b)
        // display the result into the googleResultsWebView through loadDataWithBaseURL() method
        // - base Internet address is http://www.google.com
        // - page source code is the response
        // - mimetype is text/html
        // - encoding is UTF-8
        // - history is null
        googleResultsWebView.loadDataWithBaseURL("http://www.google.com", content, "text/html", "UTF-8", null);

    }
}
