import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import groovy.json.JsonSlurper
import groovy.json.JsonOutput

def addHeaderConfiguration(request) {
    def content_type_header = new TestObjectProperty("content-type", ConditionType.EQUALS, "application/json")
    request.getHttpHeaderProperties().add(content_type_header)
}

uuid = UUID.randomUUID().toString()

// Step 1: Create a user
def createUserRequest = findTestObject('Swagger Petstore (1)/createUser')
addHeaderConfiguration(createUserRequest)
def userPayloadMap = [
    username: "validUser__${uuid}__",
    password: "ValidPass123__${uuid}__"
]
def userPayload = JsonOutput.toJson(userPayloadMap)
createUserRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(userPayload)))
def createUserResponse = WSBuiltInKeywords.sendRequest(createUserRequest)
WSBuiltInKeywords.verifyResponseStatusCode(createUserResponse, 200)

// Step 2: Attempt login with invalid username
def loginVariables = [
    username: "invalidUser!",
    password: "ValidPass123"
]
def loginUserRequest = findTestObject('Swagger Petstore (1)/loginUser', loginVariables)
addHeaderConfiguration(loginUserRequest)
def loginUserResponse = WSBuiltInKeywords.sendRequest(loginUserRequest)
WSBuiltInKeywords.verifyResponseStatusCode(loginUserResponse, 400)

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

