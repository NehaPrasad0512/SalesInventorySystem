CREATE TABLE TBL_STOCK(Product_ID Varchar(6) Primary Key, Product_Name Varchar(20) UNIQUE, Quantity_On_Hand Number CHECK(Quantity_On_Hand>0),Product_Unit_Price Number CHECK(Product_Unit_Price>0),Recorder_Level Number CHECK(Recorder_Level>0));

CREATE TABLE TL_SALES( Sales_ID Varchar(6) Primary Key,Sales_Date DATE,Product_ID Varchar(6), Foreign Key(Product_ID) REFERENCES TBL_STOCK(Product_ID),Quantity_Sold Number CHECK(Quantity_Sold>0),Sales_Price_Per_Unit Number CHECK(Sales_Price_Per_Unit>0));
 
INSERT INTO TBL_STOCK VALUES('RE1001','REDMI NOTE 3',20,12000,5);

INSERT INTO TBL_STOCK VALUES('ip1002','Iphone 55',10,21000,2);

INSERT INTO TBL_STOCK VALUES('PA1003','Panasonic 55',50,5500,5);

CREATE SEQUENCE SEQ_SALES_ID START WITH 1000 INCREMENT BY 1;

CREATE SEQUENCE SEQ_PRODUCT_ID START WITH 1004 INCREMENT BY 1;


CREATE OR REPLACE VIEW V_SALES_REPORT AS
Select TBL_SALES.Sales_ID,TBL_SALES.Sales_Date,
TBL_STOCK.Product_ID,TBL_Stock.Product_Name,
TBL_SALES.Quantity_Sold,TBL_STOCK.Product_Unit_Price,
TBL_SALES.Sales_Price_Per_Unit,
TBL_SALES.Sales_Price_Per_Unit-TBL_STOCK.Product_Unit_Price as Profit_Amount
from TBL_SALES,TBL_STOCK
where TBL_SALES.Product_ID=TBL_STOCK.Product_ID
order by Profit_Amount desc,
TBL_SALES.Sales_ID asc;