# AfricaTalkSmsService

Dependency on jar through gradle
```aidl
repositories {
  maven {
    url  "http://dl.bintray.com/africastalking/java"
  }
}

dependencies{
  // Get all services
  compile 'com.africastalking:core:3.4.2'
}
```  
The SDK needs to be initialized with your app username and API key, which you get from the here https://account.africastalking.com/
```aidl
// Initialize
String username = "YOUR_USERNAME";    // use 'sandbox' for development in the test environment
String apiKey = "YOUR_API_KEY";       // use your sandbox app API key for development in the test environment
AfricasTalking.initialize(username, apiKey);

// Initialize a service e.g. SMS
SmsService sms = AfricasTalking.getService(AfricasTalking.SERVICE_SMS);

// Use the service
List<Recipient> response = sms.send("Hello Message!", new String[] {"+2547xxxxxx"}, true);
```

Africa talk Sandbox is used for sms and ussd service and those can ve created using below links:
 
service code for ussd:
https://account.africastalking.com/apps/sandbox/ussd/codes

SMS - Short Codes
https://account.africastalking.com/apps/sandbox/sms/shortcodes

ngrok can be used to point to local repo instance