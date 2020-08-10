package com.Client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Register {

    private static final String REGISTER_URL = "http://127.0.0.1:80/Chatter-Server/register.php";
    private static final String USER_AGENT = "Mozilla/5.0";

    public static boolean register_user() throws IOException {

        Scanner uInput = new Scanner(System.in);
        String username, password;

        System.out.println("Username:");
        username = uInput.nextLine();

        System.out.println("Password:");
        password = uInput.nextLine();

        // get hash of password using sha-512
        password = Hash.encrypt512(password);

        http_request(username, password);

        return true;
    }

    private static boolean http_request(String username, String password) throws IOException {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("username", username);
        parameters.put("password", password);

        String urlParameters = ParameterStringBuilder.getParamsString(parameters);
        byte[] postData = urlParameters.getBytes( StandardCharsets.UTF_8 );
        int postDataLength = postData.length;
        URL url = new URL(REGISTER_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setInstanceFollowRedirects(false);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("charset", "utf-8");
        conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
        conn.setUseCaches(false);
        try(DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
            wr.write(postData);
        }

        int responseCode = conn.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);


        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println("------" + response.toString() + "------");
            return true;
        } else {
            System.out.println("GET request not worked");
            return false;
        }
    }
}
