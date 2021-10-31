# Reverse Polish Summation
This program recursively adds numbers in reverse Polish notation.

Recursive Polish notation (RPN) is a type of mathematical notation in which the operators are placed in front of the operands.

This program currently supports 3 types of operators working on numbers between 0 and 9:
- The addition operator +
- The subtraction operator -
- The summation operator &

Normally, calculations are written with the operators in between the operands (e.g. 3+4 or 9-5). In RPN, the operator is placed _before_ the operands (e.g. +34 and -95 respectively).

The input
```
Please enter an expression
+34
```
would yield 7.

Similarly, the input
```
Please enter an expression
-95
```
would give a result of 4.

&nbsp;

The summation operator & is used to calculate the sum of a number from 1 to the number in question:
```
Please enter an expression
&5
```
The result would be 15 because &5 = 5+4+3+2+1

&nbsp;

You can also combine the summation operator and another calculation together. 

&nbsp;
The input would give a result of 15.
```
Please enter an expression
&-94
```
