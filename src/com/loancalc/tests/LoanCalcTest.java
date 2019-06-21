package com.loancalc.tests;

import com.loancalc.beta.*;

public class LoanCalcTest {
	
	private static String[] loans = {"1000", "foo", "100000000000", "random", "2000", "3000"};
	private static String[] terms = {"12", "24", "wtf", "nanana", "twenty", "48"};
	private static String[] rates = {"2.9", "3.5", "4.0", "ten", "none", "bar"};
	private static String[] errors = {"", "You entered an invalid loan amount (less than 10 million $ supported)\n",
			"You entered an invalid loan amount (less than 10 million $ supported)\nYou entered an invalid term\n",
			"You entered an invalid loan amount (less than 10 million $ supported)\nYou entered an invalid term\nYou entered an invalid interest rate (< 100% only)",
			"You entered an invalid term\nYou entered an invalid interest rate (< 100% only)",
			"You entered an invalid interest rate (< 100% only)"};
	
	public static void main(String[] args)
	{
		for (int i = 0; i < 6; i++)
		{
			String equalSigns = "";
			String output = "";
			String errorCheck = "";
			LoanCalcClass calc = new LoanCalcClass();
			output += "Test " + (i + 1) + ": {" + loans[i] + ", " + terms[i] + ", " + rates[i] + "}\n";
			for(int k = 0; k < output.length(); k++)
			{
				equalSigns += "="; 
			}
			output += equalSigns + "\n";
			errorCheck += calc.errorPrint(calc.checkLoan(loans[i]), calc.checkTerm(terms[i]), calc.checkRate(rates[i]));
			switch(i)
			{
				case 0:
				{
					if (errorCheck.equals(errors[i]))
					{
						output += "No errors expected: PASS\n";
					}
					else
					{
						output += "No errors expected: FAIL\n";
					}
					break;
				}
				case 1:
				{
					if(errorCheck.equals(errors[i]))
					{
						output += "Invalid loan amount: PASS\n";
					}
					else
					{
						output += "Invalid loan amount: FAIL\n";
					}
					break;
				}
				case 2:
				{
					if(errorCheck.equals(errors[i]))
					{
						output += "Invalid loan amount and term: PASS\n";
					}
					else
					{
						output += "Invalid loan amount and term: FAIL\n";
					}
					break;
				}
				case 3:
				{
					if(errorCheck.equals(errors[i]))
					{
						output += "Invalid loan amount, term and rate: PASS\n";
					}
					else
					{
						output += "Invalid loan amount, term and rate: FAIL\n";
					}
					break;
				}
				case 4:
				{
					if(errorCheck.equals(errors[i]))
					{
						output += "Invalid term and rate: PASS\n";
					}
					else
					{
						output += "Invalid term and rate: FAIL\n";
					}
					break;
				}
				case 5:
				{
					if(errorCheck.equals(errors[i]))
					{
						output += "Invalid interest rate: PASS\n";
					}
					else
					{
						output += "Invalid interest rate: FAIL\n";
					}
					break;
				}
			}
			output += equalSigns + "\n";
			System.out.println(output);
		}
	}
}
