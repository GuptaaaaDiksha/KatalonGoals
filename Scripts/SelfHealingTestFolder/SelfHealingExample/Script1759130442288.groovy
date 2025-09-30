import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://opensource-demo.orangehrmlive.com/web/index.php/auth/login')

WebUI.doubleClick(findTestObject('Object Repository/Page_OrangeHRM/p_Login_oxd-text oxd-text--p'))

WebUI.setText(findTestObject('Object Repository/Page_OrangeHRM/input_Username_username'), 'Admin')

WebUI.doubleClick(findTestObject('Object Repository/Page_OrangeHRM/p_Login_oxd-text oxd-text--p_1'))

WebUI.setEncryptedText(findTestObject('Object Repository/Page_OrangeHRM/input_Password_password'), 'hUKwJTbofgPU9eVlw/CnDQ==')

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/button_Password_oxd-button oxd-button--medi_8860b7'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/i_Today_oxd-icon bi-stopwatch'))

WebUI.setText(findTestObject('Object Repository/Page_OrangeHRM/textarea_Note_oxd-textarea oxd-textarea--fo_bc10e6'), 'Test')

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/button_Note_oxd-button oxd-button--medium o_d0e972'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/a_Claim_oxd-main-menu-item'))

