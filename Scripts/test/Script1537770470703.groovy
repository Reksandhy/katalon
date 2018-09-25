import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.xmlbeans.impl.store.Locale.domNthCache
import org.junit.After as After
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import packageName.testKeyword

String articleContent = 'Katalon Testing'


WebUI.openBrowser('https://qa-auto-prod-1.glalab.local/GTConnect/UnifiedAcceptor/FrameworkDesktop.Main')


//Login
WebUI.setText(findTestObject('Object Repository/username'), 'kmmanager')

WebUI.setText(findTestObject('Object Repository/password'), '21@password')

WebUI.click(findTestObject('Object Repository/loginbtn'))

boolean kmHome = false

while (kmHome != true) {
    kmHome = WebUI.waitForElementPresent(findTestObject('Object Repository/createArticle/searchKnowledge'), 5)

    boolean warningCheck = WebUI.waitForElementPresent(findTestObject('Object Repository/warning'), 5)

    if (warningCheck == true) {
		
		WebUI.waitForElementPresent(findTestObject('Object Repository/warningOk'), 60)
		
		WebUI.delay(5)
		
		WebUI.click(findTestObject('Object Repository/warningOk')     )
		
    }
}


//Click Article
WebUI.waitForPageLoad(30)

WebUI.waitForElementPresent(findTestObject('Object Repository/createArticle/articleBtn'), 60)

WebUI.click(findTestObject('Object Repository/createArticle/articleBtn'))


//Create Article
WebUI.waitForElementPresent(findTestObject('Object Repository/createArticle/tinyMCE'), 60)

WebUI.setText(findTestObject('Object Repository/createArticle/articleTitle'), articleContent)

/*WebUI.switchToFrame(findTestObject('Object Repository/createArticle/iFrame'))

WebUI.click(findTestObject('Object Repository/createArticle/pubInfoTab'))

WebUI.setText(findTestObject('Object Repository/createArticle/enterPubInfo') , articleContent)*/

//WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/createArticle/pubInfoTab'))

/*WebUI.click(findTestObject('Object Repository/createArticle/publicInfo'))

WebUI.delay(5)


WebUI.delay(5)


WebUI.switchToFrame(findTestObject('Object Repository/createArticle/iFrame'), 60)
WebUI.setText(findTestObject('Object Repository/createArticle/publicInfo'), articleContent)
WebUI.switchToDefaultContent()
*/

WebUI.click(findTestObject('Object Repository/createArticle/publishBtn'))
WebUI.setText(findTestObject('Object Repository/createArticle/articlePopupNotes'), articleContent)
WebUI.click(findTestObject('Object Repository/createArticle/popupNotesConfirm'))

WebUI.waitForElementPresent(findTestObject('Object Repository/createArticle/searchKnowledge'), 60)
WebUI.delay(5)
WebUI.setText(findTestObject('Object Repository/createArticle/searchKnowledge'), articleContent)
WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/createArticle/searchKM'))

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/logoutBtn'))
WebUI.click(findTestObject('Object Repository/logoutConfirm'))


