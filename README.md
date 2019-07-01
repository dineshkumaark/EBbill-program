# EBbill-program
EB bill problem in java

The consolidated power consumption for a commercial complex is sent in the following format by EB department for a month. The complex has 5 shops each having a separate meter box and the electricity tariff total for a month has to be calculated for each shop separately based on the number of units consumed.
NOTE: The same shop may have more than one entry in a single line.
Sometimes if a shop does not consume energy it will not be part of the list
On power shutdown days the entry will be nothing just the date
 
Please find the format below:
Jan 1, 2020: shop1 320$shop2 220$shop3 330$shop4 420$shop5 5
Jan 2, 2020: shop5 318$shop4 320$shop3 330$shop2 420$shop1 5
Jan 3, 2020: shop1 316$shop1 820$shop3 330$shop4 420$shop5 5
Jan 4, 2020: shop1 314$shop2 110$shop3 68$shop4 420$shop5 5
Jan 5, 2020: shop1 323$shop2 220$shop3 330$shop4 420$shop5 5
Jan 6, 2020: shop1 324$shop3 $330$shop4 420$shop5 5
Jan 7, 2020: shop1 320$shop2 220$shop3 $330$shop4 420$shop5 51
Jan 8, 2020: 

Find the total power consumed if each shop is charged in the following slabs
First 1000 - 2000 units: 0.33/unit
2001-5000 units: 0.30/unit
5000+units: 0.20/unit

Output:
Shop1 bill:
Shop2 bill:
Shop3 bill:
Shop4 bill:
Shop5 bill:
