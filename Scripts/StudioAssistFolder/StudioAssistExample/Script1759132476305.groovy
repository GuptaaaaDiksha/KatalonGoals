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

// Load CSV file from Data Files (make sure it's added as loginData.xlsx)
def data = findTestData('Data Files/loginData')

// Get total number of rows
int rows = data.getRowNumbers()

for (int r = 1; r <= rows; r++) {
	String username = data.getValue(1, r)   // first column
	String password = data.getValue(2, r)   // second column

	WebUI.openBrowser('')
	WebUI.navigateToUrl('https://opensource-demo.orangehrmlive.com/web/index.php/auth/login')

	// enter username from CSV
	
	WebUI.setText(findTestObject('Object Repository/Page_OrangeHRM/input_Username_username'), username)

	// enter password from CSV (must be encrypted string)
	WebUI.setEncryptedText(findTestObject('Object Repository/Page_OrangeHRM/input_Password_password'), password)

	// click login
	WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/button_Password_oxd-button oxd-button--medi_8860b7'))

	// verify dashboard text is present (fixed, not data-driven)
	WebUI.verifyElementPresent(findTestObject('Object Repository/Page_OrangeHRM/span_PIM_oxd-text oxd-text--span oxd-main-m_a32acf'), 10)

	// close browser

}