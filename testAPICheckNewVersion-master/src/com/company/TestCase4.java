package com.company;

import org.json.JSONException;

import java.io.IOException;

public class TestCase4 {
    public static void UnitTest4() throws Exception {
        ResponseLogin ress = TestCaseLoginAPI.callAPI("0965223417", "308abcd910", "12rt");
        String last_update = "9.0";
        String token = ress.token;
        System.out.println("Unit test 4: The account is blocked");
        ResponseCheckNewVersion res = TestCaseCheckNewVersion.callAPI(last_update, token);
        if (((!res.code.equals("9995")))) throw new AssertionError();
        if ((!"User is not validated".equals(res.message))) throw new AssertionError();
        ResponseLogin resp = TestCaseLoginAPI.callAPI("0965223417", "308abcd910", "12rt");
        if (((!resp.code.equals("1000")))) throw new AssertionError();
        System.out.println("Finished");
    }
}