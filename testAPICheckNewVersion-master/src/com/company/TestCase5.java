package com.company;


public class TestCase5 {
    public static void UnitTest5() throws Exception {
        ResponseLogin resp = TestCaseLoginAPI.callAPI("0965223417","308abcd910","12rt");
        String token = resp.data1.token;
        String last_update ="9.0";
        System.out.println("Unit test 5: Your version is not newest version");
        ResponseCheckNewVersion res = TestCaseCheckNewVersion.callAPI(last_update,token);
        if(!(res.data.version).equals(last_update)){
            if ((!res.code.equals("9994"))) throw new AssertionError();
            if ((!"Parameter value is invalid".equals(res.message))) throw new AssertionError();
            System.out.println("Download latest version from this link " + res.data.url);
        }


    }
}
