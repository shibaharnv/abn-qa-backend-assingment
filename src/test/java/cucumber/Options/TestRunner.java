package cucumber.Options;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import utilities.Email;



@RunWith(Cucumber.class)
@CucumberOptions(publish = true,features="src/test/java/features",plugin ="json:target/jsonReports/cucumber-report.json",glue= {"stepDefinitions"},tags="@EdgeCase or @Crud")



public class TestRunner {


    /**
     * This is a set up method which will be executed before the start of the execution
     * @param  *none
     * @return  none
     */
    @BeforeClass
    public static void setUp(){
        System.out.println("This is set up method.");
    }


    /**
     * This is tear down method which reads the recipient value passed in the command through pom.xml
     * and calls the email trigger method which will send email with execution report
     * @param  *none
     * @return  none
     */

    @AfterClass
    public static void tearDown()  {

        String recipient=System.getProperty("RecipientList");
        System.out.println(recipient);

        Email.emailTrigger(recipient);


    }
}
