package com.company;

import java.io.IOException;

public class TestCase7 {
    public void Unitest7() throws Exception {
        ResponseLogin resp = TestCaseLoginAPI.callAPI("0965223417", "308abcd910", "12rt");
        String token = resp.token;
        String last_update = "9.0";
        ResponseCheckNewVersion res = TestCaseCheckNewVersion.callAPI(last_update, token);
        if (res.data[4].equals(0)) {
            if (((!res.code.equals("9995")))) throw new AssertionError();
            System.out.println("Bạn đã bị khoá tài khoản");

            ResponseLogin ress = TestCaseLoginAPI.callAPI("0965223417", "308abcd910", "12rt");
            if (((!ress.code.equals("1000")))) throw new AssertionError();
            System.out.println("Finished");
        }
    }

}