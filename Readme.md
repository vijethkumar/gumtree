Task1: UI Test: https://github.com/vijethkumar/gumtree/tree/master/src/test/java/vijethgumtree/uitest.java
Visit gumtree.com.au
Search for "Sennheiser Headphones"
In Category "Electronics & Computer"
In "Sydney Region, NSW"
Within 20km
In the search results, open a random result
Verify the ad details page opens
Verify a numeric ad id is displayed in the breadcrumbs
Verify atleast one similar ad is displayed in the page

Note : can try to implement this using POM if necesary

Task2: API Test:  https://github.com/vijethkumar/gumtree/tree/master/src/test/java/vijethgumtree/apitest_validate.java
Write a test for the route
https://ecg-api.gumtree.com.au/api/papi/ads/search?categoryId=0&categoryRedirected=1&includeTopAds=1&keyword=Table&locationId=3003435&page=1&size=20&sortType=DATE_D
Validate the response type, response code, headers and some of the data displayed.

Note: Have done a very Simple and basic Validation.