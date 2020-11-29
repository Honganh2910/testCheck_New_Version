package com.company;



public class TestCase1 {
    public static void UnitTest1() throws Exception  {
        ResponseLogin resp = TestCaseLoginAPI.callAPI( "0965223417","mn674fio2i","12rt");
        String last_update="9.0";
        String token = resp.data1.token;
        System.out.println("Unit test 1: The latest version");
        ResponseCheckNewVersion res = TestCaseCheckNewVersion.callAPI(last_update,token);
        if(!("1000".equals(res.code)))throw new AssertionError();
        if ((!"OK".equals(res.message))) throw new AssertionError();

        System.out.println("Finished!");
    }
}
