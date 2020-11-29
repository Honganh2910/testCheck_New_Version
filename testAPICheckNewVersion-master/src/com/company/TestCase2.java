package com.company;

public class TestCase2 {
    public static void UnitTest2() throws Exception {
        ResponseLogin res = TestCaseLoginAPI.callAPI("0965223417", "308abcd910", "12rt");
        String last_update = "9.0";
        String token = res.data1.token;
        System.out.println("Unit test 2: Token is incorrect");
        if (token.equals(" ")) {
            ResponseCheckNewVersion ress = TestCaseCheckNewVersion.callAPI(last_update, token);
            if (!(ress.code.equals("1004"))) throw new AssertionError();
            if ((!"Parameter value is invalid".equals(ress.message))) throw new AssertionError();
            if (((!res.code.equals("1000")))) throw new AssertionError();
            System.out.println("Finished");

        }
    }
}
