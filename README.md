# My-Retail-Application
My retail service to fetch pricing and update pricing data for product

MONGODB SETUP:
--------------
        1.install mongodb from the below url
        https://fastdl.mongodb.org/win32/mongodb-win32-x86_64-2008plus-3.2.8-signed.msi
        2.Create folder structure c:/data/db
        3.open cmd from start menu and go to C:\Program Files\MongoDB\Server\3.2\bin
        4.run mongod.exe and leave it runnning.

Setting MyRetailApplication in local:
--------------------------------------

      1.Set the eclipse workspace for the git link below.
          https://github.com/vairava/My-Retail-Application.git
      2.Use Apache Tomcat 8.0 for running the application and java-1.8(all the dependent jars are included in the workspace itself) .
      3.Set test data in mongodb(see heading "Setting MongoDB data" below)
      4.Hit the MyRetail service and validate results(see heading "Test and validate MyRetailService" below)

Setting MONGODB data:
----------------------------
        1.Use Poster or Postman chrome plugin to insert data to MONGODB.
        2.Use the below service url(for interviewer's convenience I made data setup easy through a POST Webservice)
        http://localhost:8080/MyRetailService/rs/MyRetail/setdata
        
        RequestMethod=POST
        
        2.use the below json format to insert data
        {"id":13860428,"productName":"BIG LEBOWSKI, THE Blu-ray","currency_code":"RUPEE","value":96.99}
        			where "id"=product id
        				  "productname"=Name of product for the product id
        				  "currency_code"=currency code for the product
        				  "value"=price value for the product
        				  
        3.Insert as many product data as required
        4.Run GenerateTOHelper.java main method under com.work.myretail.util package to see all the data inserted into db through console.

Test and validate MyRetailService:
---------------------------------
 1.Testing GET service to retrieve Product details:
 ---------------------------------------------------
 
    	1.Use the below url in the browser
    			http://localhost:8080/MyRetailService/rs/MyRetail/products/{productId}
    				eg if product id is 13860428 then service url will be like below
    				http://localhost:8080/MyRetailService/rs/MyRetail/products/13860428
    				
    	2.The output will be a json with id,name and current_price
    	3.If Target url for getting data needs to be changed then edit the url's first part and second part in ApplicationConstants.java under com.work.myretail.util package.
	
 2.Testing PUT service for updating pricing data:
 -----------------------------------------------
 
        1.Use the same url we used for GET service above
      	http://localhost:8080/MyRetailService/rs/MyRetail/products/{productId}
      				eg if product id is 13860428 then service url will be like below
      				http://localhost:8080/MyRetailService/rs/MyRetail/products/13860428
      				
        2.Use Poster or Postman chrome plugin and set the Request Type as "PUT" and 
        				Header name="Content-type" and Value = "application/json"
        3.Use the below json to update the pricing data with appropriate currency_code and value for the product Id mentioned in the URL
        		eg:
        		{"currency_code":"USD","value":96.99}
	
        4.Once updated is success we can see the updated pricing by hitting the GET service url mention above in "1.Testing GET service to retrieve Product details:" section.
        5.Or we can see the update result by running the GenerateTOHelper.java under com.work.myretail.util package by "run as java application" which gives all the results from database.


