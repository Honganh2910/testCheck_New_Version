package com.company;

import com.google.gson.Gson;
import org.json.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

import com.company.ResponseCheckNewVersion;

public class TestCaseCheckNewVersion {
    public static ResponseCheckNewVersion callAPI( String last_update ,String token) throws IOException, JSONException {
        URL ur = new URL(Constant.GET_UPDATE +
                            "?lastupdate="+ last_update +"&token=" +token);
        HttpURLConnection conn = (HttpURLConnection) ur.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        try (DataOutputStream writer = new DataOutputStream(conn.getOutputStream())) {

            StringBuilder content;
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()))) {
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
            String version = objectJson.getJSONObject("data").getString("version");
            String require = objectJson.getJSONObject("data").getString("require");
            String url = objectJson.getJSONObject("data").getString("url");
            String user_id = objectJson.getJSONObject("data").getString("user_id");
            String active = objectJson.getJSONObject("data").getString("active");
            ResponseCheckNewVersion t =  g.fromJson(content.toString(), ResponseCheckNewVersion.class);
            t.data[0] = version;
            t.data[1] = require;
            t.data[2] = url;
            t.data[3] = user_id;
            t.data[4] = active;
            return t;
        } finally {
            conn.disconnect();
        }
    }
}