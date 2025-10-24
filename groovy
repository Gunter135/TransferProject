def xml = new XmlSlurper(false, false).parseText(mockRequest.requestContent)
def eanValue = xml.'soapenv:Body'.'**'.find { it.name() == 'ean' }?.text()
log.info("Extracted EAN: ${eanValue}")
context.setProperty("eanValue", eanValue)
return "DynamicResponse"
def xml = new XmlSlurper(false, false).parseText(mockRequest.requestContent)
def eanValue = xml.'**'.find { it.name() == 'ean' }?.text()
log.info("EAN: ${eanValue}")


// response timeout
def requestStep = testRunner.testCase.testSteps["MySOAPRequest"]
requestStep.httpRequest.setPropertyValue("Connect Timeout", "10000")
requestStep.httpRequest.setPropertyValue("Socket Timeout", "30000") 
log.info "Timeouts set: Connect=10s, Socket=30s"

// response delay
def delay = 100 + new Random().nextInt(200)
Thread.sleep(delay)
return "Response 1"
