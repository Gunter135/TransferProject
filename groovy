// Parse the incoming request, ignore namespaces
def xml = new XmlSlurper(false, false).parseText(mockRequest.requestContent)

// Extract <ean> value
def eanValue = xml.'soapenv:Body'.'**'.find { it.name() == 'ean' }?.text()

log.info("Extracted EAN: ${eanValue}")

// Save for use in the mock response template
context.setProperty("eanValue", eanValue)

// Choose the mock response template
return "DynamicResponse"
