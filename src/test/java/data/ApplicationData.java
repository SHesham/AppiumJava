package data;

import org.testng.annotations.DataProvider;
import java.io.IOException;

public class ApplicationData
{
    @DataProvider(name = "Login")
    public Object[][] loginData() throws IOException
    {
        ReadDataFromExcel confg = new ReadDataFromExcel(System.getProperty("user.dir")+"//src//test//java//utilities//DataDrivenTest.xlsx");
        int rowsnum = confg.getRowCount(2);
        Object[][] data = new Object[rowsnum][2];

        for (int i = 0; i < rowsnum; i++)
        {
            data[i][0] = confg.getData(2, i, 0);
            data[i][1] = confg.getData(2, i, 1);
        }
        return data;
    }

    @DataProvider(name = "Registration")
    public Object[][] registrationData() throws IOException
    {
        ReadDataFromExcel confg = new ReadDataFromExcel(System.getProperty("user.dir")+"//src//test//java//utilities//DataDrivenTest.xlsx");
        int rowsnum = confg.getRowCount(1);
        Object[][] data = new Object[rowsnum][5];

        for (int i = 0; i < rowsnum; i++)
        {
            data[i][0] = confg.getData(1, i, 0);
            data[i][1] = confg.getData(1, i, 1);
            data[i][2] = confg.getData(1, i, 2);
            data[i][3] = confg.getData(1, i, 3);
            data[i][4] = confg.getData(1, i, 4);
        }
        return data;
    }

    @DataProvider(name="ForgotPassword")
    public Object[][] forgotPasswordData() throws IOException
    {
        ReadDataFromExcel confgEx = new ReadDataFromExcel(System.getProperty("user.dir")+"//src//test//java//utilities//DataDrivenTest.xlsx");
        int rowsnum = confgEx.getRowCount(0);
        Object[][] data = new Object[rowsnum][1];

        for(int i=0; i<rowsnum; i++)
        {
            data[i][0] = confgEx.getData(0, i, 0);
        }
        return data;
    }

    @DataProvider(name="NewsLetter")
    public Object[][] newsLetterData() throws IOException
    {
        ReadDataFromExcel confg = new ReadDataFromExcel(System.getProperty("user.dir")+"//src//test//java//utilities//DataDrivenTest.xlsx");
        int rowsnum = confg.getRowCount(3);
        Object[][] data = new Object[rowsnum][1];

        for(int i=0; i<rowsnum; i++)
        {
            data[i][0] = confg.getData(3, i, 0);
        }
        return data;
    }

    @DataProvider(name = "NewDesigner")
    public Object[][] newDesignerSubscriptionData() throws IOException
    {
        ReadDataFromExcel confg = new ReadDataFromExcel(System.getProperty("user.dir")+"//src//test//java//utilities//DataDrivenTest.xlsx");
        int rowsnum = confg.getRowCount(4);
        Object[][] data = new Object[rowsnum][1];

        for (int i = 0; i < rowsnum; i++)
        {
            data[i][0] = confg.getData(4, i, 0);
        }
        return data;
    }
}