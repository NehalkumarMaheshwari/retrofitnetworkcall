# retrofitnetworkcall
Android library for displaying data based on JSON configuration fetched from server. This library supports PUT, POST, and GET method. It also handle success and failure of the responses.

## How to add the library

```
'implementation com.nehalkumar:apicalling:1.1'
```
## Prerequisite
You need to have the Gson and Retrofit dependecy already installed.

### Steps to start api calling
- Add the following line to the activity or the screen where you want to call the API. The code snippet for the initialization is shown below. In the code *this* reprents that you need to implemnt *NetworkResponseListener* to the activity in which you are initializing the RetrofitApiLogic.

```
RetrofitApiLogic(this).callingGetApi(1,"URL")
```
