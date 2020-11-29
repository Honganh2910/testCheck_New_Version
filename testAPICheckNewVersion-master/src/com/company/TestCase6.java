package com.company;


public class TestCase6 {
    public static void UnitTest6() throws Exception {
        ResponseLogin resp = TestCaseLoginAPI.callAPI("0965223417","308abcd910","12rt");
        String token = resp.data1.token;
        String last_update ="9.0";
        System.out.println("Unit test 6:New version is not exist");
        ResponseCheckNewVersion res = TestCaseCheckNewVersion.callAPI(last_update,token);
        if (((!res.code.equals("9994")))) throw new AssertionError();
        System.out.println("Your version is the latest now");




    }
}
