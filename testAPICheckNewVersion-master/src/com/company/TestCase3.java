package com.company;

import java.io.IOException;

public class TestCase3 {
    public static void UnitTest3() throws Exception {
        ResponseLogin resp = TestCaseLoginAPI.callAPI("0965223417","308abcd910","12rt");
        String last_update ="9.0";
        String token = resp.data1.token;
        System.out.println("Unit test 3: Cant't find data you are looking for");
        ResponseCheckNewVersion res = TestCaseCheckNewVersion.callAPI(last_update,token);
        if (!(res.code.equals("1001"))) throw new AssertionError();
        if ((!"Can not connect to DB".equals(res.message))) throw new AssertionError();
        System.out.println("Can not connect to DB");
        System.out.println("Finished");
    }
}
