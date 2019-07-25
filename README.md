# retrofitnetworkcall
Android library for displaying data based on JSON configuration fetched from server. This library supports PUT, POST, and GET method. It also handle success and failure of the responses.

## How to add the library

```
'implementation com.nehalkumar:apicalling:1.3'
```

* [x]  envirement setup

- add your envirements base url like development, production in gradle.properties file
    ```
        base_url="https://reqres.in/api/"
        debug_url="https://reqres.in/api/"
    ```
- add timout option also in gradle.properties file
    ```
        connect_timeout=30000
        read_timeout=30000
    ```
- set up your envirements in gradle file(project level gradle file)
     ```
        buildTypes {
            def CONFIG = { k -> "${project.properties.get(k)}" }

            debug {
                buildConfigField "String", "BASE_URL", CONFIG("debug_url")
            }

            release {
                buildConfigField "String", "BASE_URL", CONFIG("base_url")

                minifyEnabled false
                proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
            }
        }
    ```
- add network module and Gson dependencyes in your gradle file(project level gradle file)
     ```
        implementation project(path: ':networkcall')
        
        implementation 'com.google.code.gson:gson:2.8.5'
     ```

* [x]  Step for execution

- implements NetworkResponseListener interface to your class with their overridden metods for handling response
     ```
        Like :- class YourClassName : NetworkResponseListener // Kotlin
        
        override fun onSuccessResponse(apiName: String, response: String) {} // Success response handling
        override fun onErrorResponse(apiName: String, response: String) {} // Error response handling
        override fun onFailureResponse(apiName: String, message: String?) {} // Timout and any other failure handling
     ```
- Get Request and response
     ```
        /**
             * Calling get api request
             * apiName is your url name. Easy to bifurcate which context calling which url
             * Url is api your name
             * Last param is Hash map for header.
             * If you have custom params for header then and only you have to add in method arguments.
        */
        
        Reuest :-
            
            RetrofitApiLogic(this).callingGetApi("UserDetail", BuildConfig.BASE_URL + "users/2")
            
        Response :-
        
            override fun onSuccessResponse(apiName: String, response: String) {
                if(apiName.equals("UserDetail", true)){
                    // Handle success response here
                }
            }
            
            override fun onErrorResponse(apiName: String, response: String) {
                if(apiName.equals("UserDetail", true)){
                    // Handle error response here
                }
            }
     ```
     
- Post Request and response
     ```
        /**
             * Calling post api request
             * apiName is your url name. Easy to bifurcate which context calling which url
             * Url is api your name
             * JsonObject for request parameter
             * Last param is Hash map for header.
             * If you have custom params for header then and only you have to add in method arguments.
        */
        
        Reuest :-
        
            val jsonObject = JsonObject().apply {
                addProperty("email", "eve.holt@reqres.in")
                addProperty("password", "pistol")
            }
            
            RetrofitApiLogic(this).callingPostApi("Registration",BuildConfig.BASE_URL + "register", jsonObject)
            
        Response :-
        
            override fun onSuccessResponse(apiName: String, response: String) {
                if(apiName.equals("Registration", true)){
                    // Handle success response here
                }
            }
            
            override fun onErrorResponse(apiName: String, response: String) {
                if(apiName.equals("Registration", true)){
                    // Handle error response here
                }
            }
     ```

- Put Request and response
     ```
        /**
             * Calling put api request
             * apiName is your url name. Easy to bifurcate which context calling which url
             * Url is api your name
             * JsonObject for request parameter
             * Last param is Hash map for header.
             * If you have custom params for header then and only you have to add in method arguments.
        */
        
        Reuest :-
        
            val jsonObject = JsonObject().apply {
                addProperty("name", "morpheus")
                addProperty("job", "zion resident")
            }
            
            RetrofitApiLogic(this).callingPostApi("UpdateDetails",BuildConfig.BASE_URL + "users/2", jsonObject)
            
        Response :-
        
            override fun onSuccessResponse(apiName: String, response: String) {
                if(apiName.equals("UpdateDetails", true)){
                    // Handle success response here
                }
            }
            
            override fun onErrorResponse(apiName: String, response: String) {
                if(apiName.equals("UpdateDetails", true)){
                    // Handle error response here
                }
            }
     ```
     
- Delete Request and response
     ```
        /**
             * Calling delete api request
             * apiName is your url name. Easy to bifurcate which context calling which url
             * Url is api your name
             * JsonObject for request parameter
             * Last param is Hash map for header.
             * If you have custom params for header then and only you have to add in method arguments.
        */
        
        Reuest :-
        
            val jsonObject = JsonObject().apply {
                addProperty("user_id", 2)
            }
            
            RetrofitApiLogic(this).callingDeleteApi("DeleteUser",BuildConfig.BASE_URL + "users", jsonObject)
            
                                    OR
                                    
            RetrofitApiLogic(this).callingDeleteApi("Delete",BuildConfig.BASE_URL + "users/2")
            
        Response :-
        
            override fun onSuccessResponse(apiName: String, response: String) {
                if(apiName.equals("DeleteUser", true)){
                    // Handle success response here
                }
            }
            
            override fun onErrorResponse(apiName: String, response: String) {
                if(apiName.equals("DeleteUser", true)){
                    // Handle error response here
                }
            }
     ```
     
- Get Request and response with custom headers
     ```
        /**
             * Calling get api request
             * apiName is your url name. Easy to bifurcate which context calling which url
             * Url is api your name
             * Last param is Hash map for header.
             * If you have custom params for header then and only you have to add in method arguments.
        */
        
        Reuest :-
        
            val headerMap = HashMap<String, String>()
            hashmap["Accept"] = "application/json"
            hashmap["Content-Type"] = "application/json"
            
            RetrofitApiLogic(this).callingGetApi("UserDetail", BuildConfig.BASE_URL + "users/2", headerMap)
            
        Response :-
        
            override fun onSuccessResponse(apiName: String, response: String) {
                if(apiName.equals("UserDetail", true)){
                    // Handle success response here
                }
            }
            
            override fun onErrorRhttp://gitlab.volansys.com/shrenik.shah/mobile_components/tree/NetworkManageresponse(apiName: String, response: String) {
                if(apiName.equals("UserDetail", true)){
                    // Handle error response here
                }
            }
     ```

**Utility Class**
A common class to aid users in development of android project.

**Features**

* Added common functions to hide keyboard from activty and frgment
```
    How to use : Activity.hideSoftKeyboard() and Fragment.hideSoftKeyboard()
```

* Added common functions to convert double, int, and float value to string
```
    How to use : Double.toString(), Int.toString(), and Float.toString()
```

* Added common functions to int time to 2 digit String
```
    How to use : Int.twoDigitTime() // return string  if time is less then 10, return same otherwise
```

* Added common functions to converts a number to a string in cool format
```
    How to use : Number.coolFormat() // For example, 7800000 will be formatted as '7.80M'. Numbers under 1000 will be unchanged.
```

* Added common functions to inflate layout for ViewGroup
```
    How to use : ViewGroup.inflate(layoutID: Int)
```

* Basic Extensions 

**Extensions**
* String Extension

1. Validate Email-PhoneNumber-Password (According to developer's selected options i.e. Numeric Value, Capital or Small Alphabet, Special Character) 
    ```
    Option - 1 : Validate Password
    -------------------------------
    val newPass = "Abc123@abc"
    newPass.isValidPassword(forceLetter: true, forceSpecialChar: true, forceCapitalLetter: true, forceNumber: true, minLength: 5, maxLength: 15)
    Output : true
    
    Option - 2 : Validate Email Address
    -----------------------------------
    val email = "abc@gmail.com"
    email.isValidEmail()  // returns true
    
    Option - 3 : Validate Mobile number
    -------------------------------------
    val phoneNumber = "+919990099009"
    phoneNumber.isValidPhoneNumber()  // returns true

    ```
2. String To Date conversion
    ```
    Input : "28/05/1990".stringToDate(format: "dd/MM/yyyy")
    Output : Mon May 28 00:00:00 GMT+05:30 1990
    ```
3. String to Int
    ```
    Input : "12".toInt()
    Output : 12
    ```
4. Check if String is Number 
    ```
    Input : "12".isNumeric()
    Output : true
    ```
5. SpannableString with Bold text from start to end
    ```
    Input : "Hello World".spannableBold(6, 9)
    Output : "Hello World" // Wor is bold
    ```
6. Convert Json string to respective class. Response parser using Gson dependency
    ```
    val jsonObject = "{\"data\": {\"name\": \"Volansys\"}}"
    Input : jsonObject.fromJson(classOfT: Class<T>)
    Output : T // return class which you have pass in method param
    ```
    
* Encryption Extension

1. Encrypt input text by AES-128/256-CBC algorithm 
    ```
    val message = "Hello World"
    // if you pass 16 characters key then it performs AES128 and if you pass 32 Characters key then it perform AES256
    val secretKey : String = "abcdefghijklmnop"
    Input : message.encryptAES(secretKey)
    Output : enycypted string // like this :- 3G4OU62dM9zXhkbXy8pmuA==
    ```
2. Decrypt encoded text by AES-128/256-CBC algorithm 
    ```
    val enycyptedString = "3G4OU62dM9zXhkbXy8pmuA=="
    // if you pass 16 characters key then it performs AES128 and if you pass 32 Characters key then it perform AES256
    // pass same key which you have used in encryption
    val secretKey : String = "abcdefghijklmnop"
    Input : enycyptedString.decryptAES(secretKey)
    Output : Actual string // like this :- Hello World
    ```
3. Reversible encryption of the specified string based on the specified key and algorithm 
    ```
    val message = "Hello World"
    // Method requied these input from user like algorithm name, key object, and vector if required by algorithm or not
    Input : message.encrypt(key: Key, algorithm: String, initVector: Boolean)  
    Output : enycypted string // like this :- 3G4OU62dM9zXhkbXy8pmuA==
    ```
4. Decrypt encoded text based on the specified key and algorithm 
    ```
    val enycyptedString = "3G4OU62dM9zXhkbXy8pmuA=="
    // Method requied these input from user like algorithm name, key object, and vector if required by algorithm or not
    // Input same param which you have enter in encryption
    val secretKey : String = "abcdefghijklmnop"
    Input : enycyptedString.decrypt(key: Key, algorithm: String, initVector: Boolean)
    Output : Actual string // like this :- Hello World
    ```
    
* View Extension

    ```
    1. Hide view
        How to use : View.gone()
        Output : This view is gone
    
    2. Invisible view
        How to use : View.invisible()
        Output : This view is invisible
    
    3. Show view
        How to use : View.visible()
        Output : This view is visible
    
    4. Added common functions to display snackbar on your screen
        // For snackbar androidx add dependency "com.google.android.material:material:version"
        How to use : View.snack(message: String, duration: Int = Snackbar.LENGTH_LONG, function: Snackbar.() -> Unit)
        Output : Display snackbar on your screen with custom action
    ```

* Context Extension

    ```
    1. Extension method to convert from dp unit to px (pixel) according to the resolution of the phone
        How to use : Context.dip2px(dpValue: Float)
        Output : return pixel value in int
        
    2. Extension method to convert from px (pixels) to dp depending on the resolution of the phone
        How to use : Context.px2dip(pxValue: Float)
        Output : return dp value in int
    
    3. Extension method to open your play store app.
        How to use : Context.openPlayStore()
        Output : open your play store page.
    
    4. Extension method to check whether network is connected or not.
        How to use : Context.isNetworkAvailable()
        Output : return true if network is connected, otherwise false.
        
    5. Extension method to find a device width in pixels.
        How to use : Context.displayWidth
        Output : return width value in pixels
        
    6. Extension method to find a device height in pixels.
        How to use : Context.displayHeight
        Output : return height value in pixels
        
    7. Extension method to display toast message on your screen.
        How to use : Context?.toast(text: CharSequence, duration: Int = Toast.LENGTH_LONG)
        Output : display toast message on your screen
    ```
    
    
