import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
// Open browser , Navigate TO URL Which is defined globally , Define a data provider for invalid login credentials , and enter it in fields and click on login button

// Open a new browser window
WebUI.openBrowser('')

// Navigate to the URL defined in GlobalVariable
WebUI.navigateToUrl(GlobalVariable.url)

// Define a list of invalid login credentials as data provider
def invalidCredentials = [
    [username: 'invalidUser1', password: 'wrongPass1'],
    [username: 'invalidUser2', password: 'wrongPass2'],
]

// Iterate over each set of invalid credentials
for (def creds : invalidCredentials) {
    // Set the username field with invalid username
    WebUI.setText(findTestObject('Object Repository/Page_OrangeHRM/input_Username_username'), creds.username)
    
    // Set the password field with invalid password
    WebUI.setText(findTestObject('Object Repository/Page_OrangeHRM/input_Password_password'), creds.password)
    
    // Click the login button
    WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/button_Password_oxd-button oxd-button--medi_8860b7'))
    
    // Optional: Add a small delay to observe the result before next iteration
    WebUI.delay(2)
    
    // Clear username and password fields for next iteration
    WebUI.clearText(findTestObject('Object Repository/Page_OrangeHRM/input_Username_username'))
    WebUI.clearText(findTestObject('Object Repository/Page_OrangeHRM/input_Password_password'))
}