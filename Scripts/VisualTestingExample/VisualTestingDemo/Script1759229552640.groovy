import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling

// --- Test begins ---
WebUI.openBrowser('')

// Navigate to login page
WebUI.navigateToUrl('https://opensource-demo.orangehrmlive.com/web/index.php/auth/login')

// Wait until username input is visible (timeout 10 seconds)
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_OrangeHRM/Page_OrangeHRM/input_Username_username'), 10)

// Take a visual checkpoint 
WebUI.takeScreenshotAsCheckpoint('LoginPage_Visual_Check')

// Also take a normal screenshot in your custom folder
// Compose the file path (escape backslashes)
String customPath = "C:\\Users\\Diksha\\Katalon Studio\\DemoTest\\Screenshots\\LoginPage_Visual_Check_" + System.currentTimeMillis() + ".png"
WebUI.takeScreenshot(customPath)

// Now do the login steps
WebUI.setText(findTestObject('Object Repository/Page_OrangeHRM/Page_OrangeHRM/input_Username_username'), 'Admin')
WebUI.setEncryptedText(findTestObject('Object Repository/Page_OrangeHRM/Page_OrangeHRM/input_Password_password'), 'hUKwJTbofgPU9eVlw/CnDQ==')
WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Page_OrangeHRM/button_Password_oxd-button oxd-button--medi_8860b7'))


// Close browser
WebUI.closeBrowser()
