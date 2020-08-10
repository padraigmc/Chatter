package com.Client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Http {
    private static final String URL = "http://127.0.0.1:80/Chatter-Server/index.php";

    private static final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) throws IOException {

        //sendGET();
        //System.out.println("GET DONE");
    }

    public static void register(String username, String password) throws IOException {
        URL obj = new URL(URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        Map<String, String> parameters = new HashMap<>();
        parameters.put("username", username);
        parameters.put("password", password);

        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();


        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);


        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println("----------------------------------Response begins here!----------------------------------");
            System.out.println(response.toString());
            System.out.println("----------------------------------Response Ends here!----------------------------------");
        } else {
            System.out.println("GET request not worked");
        }

    }

}
