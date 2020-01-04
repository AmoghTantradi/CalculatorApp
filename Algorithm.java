package CalculatorApp;

class Algorithm {//does all the math

	public Algorithm() {
//do nothing
		
	}
	
	public  String update(String arguments) {
		//search for operations first and then find the values-multiplication and division first and then do the addition
		
		arguments=this.divisionandMultiplicationfirst(arguments);
	    arguments=this.additionandSubstractionsecond(arguments);
		 return arguments;
		

	}

	private String  divisionandMultiplicationfirst(String argc) {//we have to take care of the commas in the string 
	       int len =argc.length(),p1=0,p2=0;
	       double value=0,num1=0,num2=0;
	      
		for(int i=0;i<len;i++) {
			if(argc.charAt(i)=='/'||argc.charAt(i)=='*') {
				//find the numbers
				//finds the 1st num
				for(int j=i-1;j>=0;j--) {
			
					if(argc.charAt(j)=='+'||argc.charAt(j)=='-'||argc.charAt(j)=='/'||argc.charAt(j)=='*') {
				    p1=j+1;//we keep the operation in the String we only want the number
					num1=Double.parseDouble((argc.substring(p1,i)));
					break;	//out of the loop
					}
					else if(j==0) {
				p1=0;
				num1=Double.parseDouble((argc.substring(p1,i)));
					}
			}
				//finds the second num
				for(int j=i+1;j<len;j++) {
	
					if(argc.charAt(j)=='+'||argc.charAt(j)=='-'||argc.charAt(j)=='/'||argc.charAt(j)=='*') {
					p2=j;//we keep it here since the end is exclusive-the operation will remain inside the String
					num2=Double.parseDouble((argc.substring(i+1,p2)));
						break;//break out of the loop 
					}
					else if(j==len-1  ) {//if it is at the end of the String and still hasn't satisfied the requirement ^ above, then it has no end value
						p2=len;
						num2=Double.parseDouble((argc.substring(i+1,p2)));
					}
				}
				System.out.print(num1+"\n"); //Debugging stuff 
				System.out.print(num2);
			//so now we got the nums now we have to remove the String and replace it with the actual number
				if(argc.charAt(i)=='*') value=((double) num1)*num2;
				else value=num1/(double)num2;
				value*=100000;
				value=Math.floor(value);
				value/=100000;
				String replace=""+value;
				argc=argc.replace(argc.substring(p1,p2),""+replace);
				len=argc.length();
			    i=0;
			    //resets loop so it starts at the beginning again
					}
		}//ends loop
return argc;//returns the final value
	}

	
	private String additionandSubstractionsecond(String argc) {
		  int len =argc.length(),p1=0,p2=0;
	       double value=0,num1=0,num2=0;
		for(int i=0;i<len;i++) {
			if(argc.charAt(i)=='+'||argc.charAt(i)=='-') {
				//find the numbers
				//finds the 1st num
				for(int j=i-1;j>=0;j--) {
			
					if(argc.charAt(j)=='+'||argc.charAt(j)=='-') {
				    p1=j/*+1*/;//we keep the operation in the String we only want the number
					num1=Double.parseDouble((argc.substring(p1,i)));
					break;	//out of the loop
					}
					else if(j==0) {
				p1=0;
				num1=Double.parseDouble((argc.substring(p1,i)));
					}
			}
				//finds the second num
				for(int j=i+1;j<len;j++) {
	
					if(argc.charAt(j)=='+'||argc.charAt(j)=='-') {
					p2=j;//we keep it here since the end is exclusive-the operation will remain inside the String
					num2=Double.parseDouble((argc.substring(i+1,p2)));
						break;//break out of the loop 
					}
					else if(j==len-1  ) {//if it is at the end of the String and still hasn't satisfied the requirement ^ above, then it has no end value
						p2=len;
						num2=Double.parseDouble((argc.substring(i+1,p2)));
					}
				}
				System.out.print(num1+"\n"); //Debugging stuff 
				System.out.print(num2);
			//so now we got the nums now we have to remove the String and replace it with the actual number
			if(argc.charAt(i)=='+') value=((double) num1)+num2;
			else value=num1-(double)num2;
				value*=100000;
				value=Math.floor(value);
				value/=100000;
				String replace=""+value;
				argc=argc.replace(argc.substring(p1,p2),""+replace);
				len=argc.length();
			    i=0;
			    //resets loop so it starts at the beginning again
					}
		}//ends loop
		return argc; //returns the final value
	}
	
}

		
		
		
		
		

		
		
		
		
	

