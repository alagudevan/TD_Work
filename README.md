# TD_Work

This applications aims to calculate the Quadratic equations for a given valid coefficients(a, b, c).

The input shall be a csv file as provided in the resouces/input.csv file path and output path where the output file need to be written.

All the invalid records will be written to invalid_records.csv file in the same location as output.

There are also multiple unit test cases written for the QE calculation. Located in test folder.

There are 3 possible test scenarios. 
    1. The Discriminant being 1 real root
    2. The Discriminant being a 2 possible real root
    3. The Discriminant being a 2 complex roots. In this case, we cannot calculate the QE as we need to consider a imaginary discriminant.
    
Sample Arguments to run the applications:

/Users/vijay/IdeaProjects/QuadraticEquations/src/main/resources/input.csv,/Users/vijay/IdeaProjects/QuadraticEquations/src/main/resources

The applications also a trait for the QE service, a case class for the coefficients and helper classes to handle the csv and arguments.
