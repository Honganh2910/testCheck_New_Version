package com.company;

import com.google.gson.Gson;
import org.json.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestCaseLoginAPI {
    public static ResponseLogin callAPI(String phonenumber, String password, String uuid) throws Exception {
        URL url = new URL(Constant.LOG_IN + "?phonenumber=" + phonenumber + "&password=" + password + "&uuid=" + uuid);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        try (DataOutputStream writer = new DataOutputStream(con.getOutputStream())) {

            StringBuilder content;
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {
                String line;
                content = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }
            Gson g = new Gson();
            System.out.println(content.toString());
            JSONObject objectJson = new JSONObject(content.toString());
            String code = objectJson.getString("code");
            if(code.equals("1000")) {
                String token = objectJson.getJSONObject("data").getString("token");
                ResponseLogin t = g.fromJson(content.toString(), ResponseLogin.class);
                t.token = token;
                return t;
            } else {
                ResponseLogin m = g.fromJson(content.toString(), ResponseLogin.class);
                return m;
            }
        } finally {
            con.disconnect();
        }
    }
}

