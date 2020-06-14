public class NumberProcessor {
	/** 
	    *
	    *  This method returns true if its integer argument is "special", otherwise it returns false
	    *  A number is defined to be special if where sum of its positive divisors equals to the number itself.   
	    *  For example, 6 and 28 are "special whereas 4 and 18 are not.
	    *  
   */
	         public static boolean isSpecial(int input) 
	         {
	        	 // DELETE THE LINE BELOW ONCE YOU IMPLEMENT THE CALL!
	        	 //throw new RuntimeException("not implemented!");
	        	 int factorSum=0;
	        	 if(input==0) //checks if input is zero which has no positive divisors
	        	 {
	        		 return false;
	        	 }
	        	 for(int i=input-1;i>0;i--) //runs all numbers lower than input until it finds prime factors
	        	 {
	        		 if(input%i==0)
	        		 {
	        			 factorSum = factorSum+i;
	        		 }
	        	 }
	        	 if(factorSum==input) // returns an output true/false
	        	 {
	        		 return true;
	        	 }
	        	 else
	        	 {
	        		 return false;
	        	 }
	        			 		
	         }
	 
	   	 
	  /**  
	    * 
	    * This method returns true if a number is "UniquePrime", false otherwise. 
	    * A number is called "UniquePrime", if the number is a prime number and if
	    *  we repeatedly move the first digit of the number  to the end, the number still remains prime. 
	    *  For example, 197 is a prime number, if we move the first digit to the end, 
	    *  we will have a number 971, which is a prime number, if we again move the first digit to the end, we get 719, which is a prime number.
	    * 
	    */
	         public static boolean isUniquePrime(int num) 
	         {
	        	 // DELETE THE LINE BELOW ONCE YOU IMPLEMENT THE CALL!
	        	 //throw new RuntimeException("not implemented!");
	        	 
	     		String strnum = String.valueOf(Math.abs(num));
	        	char[] NumArray = strnum.toCharArray();
	        	char temp= NumArray[0];
	     		int iternum=0; 
	     		if(num<0) //if value is below zero the case is instantly false
	     		{
	     			return false;
	     		}
	     		
	     		 
	     		/////////////////////////////////////////// 
	     		 
	     		for(int j=0;j<strnum.length();j++) //running loop for length of the string
	        	 {
	        		 
		        	 for(int i=num-1;i>1;i--) //check prime
		        	 {
		        		 if(num%i==0)
		        		 {
		        			 return false;
		        		 }
		        		 

		        		 
		        	 }
		        	 iternum++;
		        	 if(num-1==1 && strnum.length()==1) //if input is only 1 digit long then return true
		        	 {
		        		 return true;
		        	 }
		        	 else
		        	 {
		        		 for(int k=0;k<strnum.length()-1;k++) // shifts all digits left by one 
			     		 {
			     			 
			     			 NumArray[k]=NumArray[k+1];
			     		 }
			     		 
			     		 NumArray[strnum.length()-1]= temp; //places the first number from original to end of new number
			     		 String str = new String(NumArray);
			     		 temp=NumArray[0];
			     		 //System.out.println(temp);
			     		 num = Integer.valueOf(str); //previous statements set to string and then reads integer value of string 
		        	 }

	        	 }
	     		 
	     		if(iternum==strnum.length()) // returns output true/false
	        	 {
	        		 return true;
	        	 }
	        	 return false;
	     		 
	         }

	  
	 
	     /** 
		    * 
		    * This method accepts an  integer and returns true if the number is SquareAdditive, false otherwise.
		    * onsider a k-digit number n. Square it and add the right k digits to the left k or k-1 digits. If the resultant sum is n, then n is called a SquareAdditive number. 
		    * For example, 9 is a SquareAdditive number
		    *
		    */  
	  
	         public static boolean isSquareAdditive(int num) 
	         {
	        	// TODO Auto-generated method stub
	     		
	     		num=num*num; //squaring input
	     		String strnum = String.valueOf(Math.abs(num)); //string object of squared input
	     		
	        	 	//char[] LeftNum;
	        	 	//char[] RightNum;
	        	 	int iternum=0;
	        	 	int Tsum=0;
	        	 	int Rval=0;
	        	 	int Lval=0;
	        	 	//String Rstr;
	        	 	//String Lstr;
	        	 	if(strnum.length()%2==0) //sets 2 cases if number is even digits long or odd
	        	 	{
	        	 		char[]RightNum=new char[strnum.length()/2];
	        	 		char[] LeftNum=new char[strnum.length()/2];
	        	 		
	        	 		
	        	 		//iternum=0;
	     	 		for(int i=strnum.length()/2; i<strnum.length();i++) //using established char arrays creates and adds right side digits
	     	 		{
	     	 			RightNum[iternum]=strnum.charAt(i);
	     	 			iternum++;
	     	 			//System.out.println(RightNum);
	     	 		}
	     	 		for(int j=0; j<strnum.length()/2;j++) //using established char arrays creates and adds left side digits
	     	 		{
	     	 			LeftNum[j]=strnum.charAt(j);
	     	 			//System.out.println(LeftNum[j]);
	     	 		}
	     	 		
	     	 		String Rstr = new String(RightNum); //converts to string to int and then adds values to get total 
	     	 		//System.out.println(Rstr);
	      			Rval = Integer.parseInt(Rstr);
	      			//System.out.println(Rval);
	      			String Lstr = new String(LeftNum);
	      			//System.out.println(Lstr);
	      			Lval=Integer.valueOf(Lstr);
	      			//System.out.println(Lval);
	     	 		Tsum=Lval+Rval;
	     	 		//System.out.println(Tsum);
	        	 		
	        	 	}
	        	 	else if(strnum.length()%2==1) // works similar to above but takes into account extra digit
	     	 	{
	     	 		char[]RightNum=new char[strnum.length()/2+1];
	     	 		char[] LeftNum=new char[strnum.length()/2];
	     	 		
	     	 		for(int i=strnum.length()/2; i<strnum.length();i++)
	     	 		{
	     	 			RightNum[iternum]=strnum.charAt(i);
	     	 			iternum++;
	     	 			//System.out.println(RightNum);
	     	 		}
	     	 		for(int j=0; j<(strnum.length()-1)/2;j++)
	     	 		{
	     	 			LeftNum[j]=strnum.charAt(j);
	     	 			//System.out.println(LeftNum[j]);
	     	 		}
	     	 		
	     	 		String Rstr = new String(RightNum);
	     	 		System.out.println(Rstr);
	      			Rval = Integer.parseInt(Rstr);
	      			System.out.println(Rval);
	      			String Lstr = new String(LeftNum);
	      			System.out.println(Lstr);
	      			Lval=Integer.valueOf(Lstr);
	      			System.out.println(Lval);
	     	 		Tsum=Lval+Rval;
	     	 		System.out.println(Tsum);
	     	 	}
	        	 	
	        	 	if(Tsum==Math.sqrt(num)) //returns output true/false
	        	 	{
	        	 		//System.out.println("true");
	        	 		return true;
	        	 	}
	        	 	else
	        	 	{
	        	 		//System.out.println("false");
	        	 		return false;
	        	 	}
	        	 	

	         }
	 
	     /** 
		    * 
		    * Considering the sequence 
	        *            1, 3, 6, 10, 15, 21, 28, 36, ...

	        * The method returns the nth sequence number. If n is <= 0, it returns 0
		    *
		    */
	     
	         public static int masonSequence(int num)
	         {
	        	 // DELETE THE LINE BELOW ONCE YOU IMPLEMENT THE CALL!
	        	 //throw new RuntimeException("not implemented!");
	        	 
	        	
	     		//int retval=-1;
	     		int startval=1; //sets startval
	     		
	     		if(num<=0) //if num==0 then startval returns 0
	     		{
	     			startval=0; 
	     		}
	     		else //iterates using a for loop to the element and sets to startval
	     		{
	     			for(int i=2;i<=num;i++)
	     			{
	     				startval+=i;
	     			}
	     		}
	     		
	     		return startval; //returns startval
	          }
	 
	  /** 
	    * 
	    * A composite integer is called ReversibleSum if it fulfills the following two conditions:
	    * 
	    * 1. The sum of its digits is the same as the sum of the digits of its prime factors. For example, 121 has two prime factors 11 * 11. 
	    *        The sum of the digits of the two prime factors is 1 + 1 + 1 + 1 = 4 and the sum of the digits of 121 is 1 + 2 + 1 = 4.
	    * 2. The reverse of the number equals to the number itself. For example, 121 has a reverse 121.
	    *
	    *   The method returns true if the number is ReversibleSum
	    */
	     public static boolean isReversibleSum(int num) 
	     {
	    	 // DELETE THE LINE BELOW ONCE YOU IMPLEMENT THE CALL!
	        //throw new RuntimeException("not implemented!");
	    	 
	    	
	 		String strnum = String.valueOf(Math.abs(num));
	 		
	     	char[] NumArray = strnum.toCharArray();
	     	
	     	int numsum=0;
	     	int primesum=0;
	 		String reverse="";
	 		char [] primehold ; 
	  		for(int i = strnum. length() - 1; i >= 0; i--) //reverses number and sets to string reverse
	  		{
	  			reverse = reverse + strnum. charAt(i); 
	  		}
	  		if(strnum.contentEquals(reverse)) //sets if else to check if normal and reverse are equal
	  		{
	  			for(int i=0;i<strnum.length();i++) //sums of the digits of the num
	  			{
	  				numsum= numsum+ Character.getNumericValue(NumArray[i]);
	  				//System.out.println(NumArray[i]);
	  			}
	  			//System.out.println(numsum);
	  			
	  			for(int j=2;j<=num;j++) //handles getting prime factors and adds to primesum
	  			{
	  				if(num%j==0)
	  				{	
	  					String prime = String.valueOf(Math.abs(j));
	  					primehold= prime.toCharArray();
	 					//System.out.println(primehold);
	 					for(int k=0;k<prime.length();k++)
	 					{
	 						primesum=primesum+Character.getNumericValue(primehold[k]);
	 					}
	  					num=num/j;
	  					j--;
	  					//System.out.println(num);
	  				}
	  			}
	  			
	  			if(primesum==numsum) //return output true/false
	  			{
	  				//System.out.println("True");
	  				return true;
	  			}
	  			else
	  			{
	  				//System.out.println("False");
	  				return false;
	  			}
	  			
	  			
	  		}
	  			
	  		else
	  		{
	  			//System.out.println("False");
	  			return false;
	  		}
    	 
	     }
	 
	    
	     /** 
		    * 
		    * This method returns true if the array is Incremental false otherwise. 
		    * An array is called Incremental if it has the following properties:
	        *        - The value of the first element equals the sum of the next two elements, which is equals to the next three elements, equals to the sum of the next four elements, etc.
	        *        - It has a size of x*(x+1)/2 for some positive integer x .
	        *
	        *  For example {6, 2, 4, 2, 2, 2, 1, 5, 0, 0} isIncremental, whereas {2, 1, 2, 3, 5, 6} is not
		    */
	     
	     public static  boolean isIncremental(int array[]) 
	     {
	    	 // DELETE THE LINE BELOW ONCE YOU IMPLEMENT THE CALL!
	         //throw new RuntimeException("not implemented!");
	    	 
	    	//int array[]= {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	 		int counter=1; 
	 		//int j=0;
	 		int firstnum=array[0];
	 		int total=0;
	 		int emptycheck=0;
	 		int x=0;
	 		
	 		for(int k=0;k<=array.length*2;k++) //if satisfies 2nd condition then sets to value x
	 		{
	 			if(k*(k+1)/2==array.length)
	 			{
	 				x=k;
	 			}
	 		}
	 		
	 		
	 		
	 		
	 		if(x>0) //if x value is postive 
	 		{
	 			
	 			
	 			for(int g=0;g<array.length;g++) //checks if array is empty which is always true
	 			{
	 				if(array[g]==0)
	 				{
	 					emptycheck++;
	 				}
	 			}
	 			
	 			if(emptycheck==array.length)
	 			{
	 				return true;
	 				//System.out.println("empty");
	 			}
	 			
	 			
	 			
	 			
	 			
	 			for(int i=1;i<array.length;i=i+counter) // adds each set of incremental test values
	 			{
	 				if(total%firstnum==0)
	 				{
	 					for(int j = i;j<i+counter+1;j++)
	 					{
	 						total=total+array[j];
	 					}
	 					//System.out.println(total);
	 				}	
	 				else
	 				{
	 					//System.out.println("false");
	 					return false;
	 					//break;
	 				}
	 				counter++;
	 			}
	 			if(total%firstnum!=0) //returns output true/false
	 			{
	 				return false;
	 				//System.out.println("false");
	 			}
	 			else 
	 			{
	 				return true;
	 				//System.out.println("true");
	 			}
	 		}
	 		else
	 		{
	 			return false;
	 			//System.out.println("false");
	 		}
	 		
	     }

	  /** 
	    * 
	    * TThis method accepts array of integers and sort the array 
	    */
	     public static void descendingSort (int [ ] data)
	     {
	    	 // DELETE THE LINE BELOW ONCE YOU IMPLEMENT THE CALL!
	        //throw new RuntimeException("not implemented!");
	    	 
	    	 int temp;  //sets temp value
		     for (int i=0;i < data.length-1;i++) //enters the array and searches each element after it to exchange if larger  
		     {
		          for (int j=i+1; j<data.length;j++)
		          {
		               if(data[i] < data[j])         
		               {
		                       temp = data[i]; 
		                       data[i] = data[j];
		                       data[j] = temp; 
		                }           
		          }
		     }
			
	    }
	 
	     /** 
		    * 
		    * This method returns true if the array is PairArray, false otherwise.
		    * An array is called PairArray if exactly one pair of its elements sum to 18. 
		    * For example, {4,16,14, 13} is PairArray as only 4 and 14 sum to 18
		    * The array {18,3,0,15,5} is not PairArray as more than one pair (18,0) and (3,15) sum to 18. 
		    * {4,1,11} is not also PairArray as no pair sums to 18
		    *
		    *
		    */
	     public static boolean isPairArray(int array[]) 
	     {
	    	 // DELETE THE LINE BELOW ONCE YOU IMPLEMENT THE CALL!
	        //throw new RuntimeException("not implemented!");
	    	//int array [] = {18,3,0,15,5};
	 		int checknum=0;
	 		
	 		for(int i=0; i<array.length;i++) //if the condition is true by iterating throug the array only 2 times should it be true
	 		{
	 			for(int j=0;j<array.length;j++)
	 			{
	 				//System.out.println(j);
	 				if(array[i]+array[j]==18)
	 				{
	 					checknum++;
	 				}
	 			}
	 			
	 		}
	 		if(checknum==2) // if checksum is only 2 then it returns true which is the only win condition
	 		{
	 			//System.out.println("true");
	 			return true;
	 		}
	 		else
	 		{
	 			//System.out.println("false");
	 			return false;
	 		}
	    }
	 
		/** 
		    * 
		    *  this method accepts positive integer and returns an array of size n2 with elements in a specific pattern. 
		    *  For example, for n = 2, the method returns an array with elements {0,1,2,1}.
		    */
	     public static int [ ] arrayPattern(int n) 
	     {
	    	 // DELETE THE LINE BELOW ONCE YOU IMPLEMENT THE CALL!
	         //throw new RuntimeException("not implemented!");
	 		
	 		int array[]= new int [n*n]; //sets array size n^2
	 		int nset=0; //used to keep track of which set of n we are working with
	 		
	 		for(int i=1;i<=n;i++) 
	 		{
	 			
	 			for(int j=0;j<n;j++) //enters the first n of the array
	 			{
	 				
	 				array[j+(n*nset)]=n-j; //works to print 4321 repeat
	 				
	 				
	 				if((j+1)%n==0) //increments every n
	 				{
	 					nset++;
	 				}
	 				
	 			}
	 			
	 			for(int k=0; k<n-i; k++) //overwrites one less digit every iteration
	             { 
	                  
	 				array[k+(n*(nset-1))]=0; 
	             } 
	 			
	 		}
	 		
	 		return array; //returns the array

	     }

	   
	 
	  
	  /** 
	    * 
	    * This method returns true if the array is Summative, false otherwise.
	    * An array is called Summative if the nth element (n >0) of the array is the sum of the first n elements. 
	    * 
	    * For example, {2, 2, 4, 8, 16, 32, 64} is Summative, whereas {1, 1, 2, 4, 9, 17} is not.
	    *
	    */
	     
	    
	     public static boolean isSummative(int array[]) 
	     {
	    	 // DELETE THE LINE BELOW ONCE YOU IMPLEMENT THE CALL!
	        //throw new RuntimeException("not implemented!");
	    	//int array [] = {2};
	 		int checknum=1;
	 		int total=0;
	 		if(array.length>=3) //in order for the condition to work the array must be 3 or larger at the very least
	 		{
	 			total=array[0]+array[1];
	 			for(int i=2; i<array.length;i++) //adds each subsequent element except last one
	 			{
	 				if(total==array[i])
	 				{
	 					total=total+array[i];
	 					checknum++;
	 				}
	 					
	 				
	 				
	 				
	 			}
	 			//System.out.println(checknum);
	 			//System.out.println(total);
	 			if(checknum==(array.length-1)) // if checknum equals the last element then true else false
	 			{
	 				//System.out.println("true");
	 				return true;
	 			}
	 			else
	 			{
	 				//System.out.println("false");
	 				return false;
	 			}
	 		}
	 		else if(array.length==1) //special case where if array length is 1 then it is always true
	 		{
	 			//System.out.println("true");
	 			return true;
	 		}
	 		else //else false for any array of less the 3 length
	 		{
	 			//System.out.println("false");
	 			return false;
	 		}
	     }

	  

}