package com.example.reshal.testapp1;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class retrieveAPIData extends AsyncTask<Void, Void, Void> {

    private String apilink = "http://numbersapi.com/";
    String partURL = "";
    public static TextView txt;

    Context context;
    public retrieveAPIData(String partURL, TextView txt) {
        this.partURL = partURL;
        this.txt = txt;
    }

    String data = "";

    /*Android does not allow blocking tasks such as retrieving data from the server in the
    * MainActivity.java class. This will freeze the app as it waits for data to be received from
    * the server.
    * Rather the task is created in another java class (retrieveAPIData.java) and the method
    * is run asynchronously.*/

    /*Background thread: */
    @Override
    protected Void doInBackground(Void... voids) {

        try {

//            Initiate a URL. This only creates the URL and nothing else.
            URL apiLink = new URL(apilink+partURL);

//            Establish a connection to the specified URL.
            HttpURLConnection urlConnection = (HttpURLConnection) apiLink.openConnection();

//            Create a stream to retrieve the input data.
            InputStream inputStream = urlConnection.getInputStream();

//            Create a buffer to store the stream of data as it comes through.
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line = bufferedReader.readLine();
            data = line;
            /*while(line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }*/

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /*UI thread:
    * Once data has been retrieved from the server and converted to readable text,
    * the next step is to display the data in the UI by setting the text property of the TextView
    * to the data retrieved.*/
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        /*Problem is that the TextView can only be initiated in the MainActivity.java class and
        * therefore, it cannot be initiated here. The workaround is to set the TextView object
        * to public and static*/

        txt.setTextSize(25);
        txt.setText(this.data);

    }
}
