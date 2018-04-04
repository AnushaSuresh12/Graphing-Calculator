package graph;
public class Validatefunction {

	public boolean validate(String function) {
		// check whether the function is empty
		if (function.isEmpty()) {
			return false;
			} 
		// if it is not empty then proceed 
		else
		{
			char[] temp1 = function.toCharArray();
			
			
			for (int i = 0; i < temp1.length; i++) 
			{
				// if it is a number store it in the stringbuffer
			if ((temp1[i] >= '0' && temp1[i] <= '9') || (temp1[i] == '.'))
			{ 

			StringBuffer sbuf = new StringBuffer();
			int Count = 0;
			
			while (i < temp1.length && ((temp1[i] >= '0' && temp1[i] <= '9') || (temp1[i] == '.')))
			{
			if (temp1[i] == '.')
			{
			Count++;
			}
			if (Count > 1)
			{
			return false;
			}
			sbuf.append(temp1[i++]);
			if ((i < temp1.length) && !((temp1[i] >= '0' && temp1[i] <= '9') || (temp1[i] == '.')))
			{
			--i;
			break;
			}
		}
	}
	// check whether it is x
			else if(temp1[i] == 'x')
			{ 
			if((i+1) < temp1.length && CheckCharNum(temp1[i+1]) || (i-1) >= 0 && CheckCharNum(temp1[i-1])) 
			{
			return false;
			} 
			else if (((i-1) >= 0 && temp1[i-1] >= 'a' && temp1[i-1] <= 'z') || ((i+1) < temp1.length && temp1[i+1] >= 'a' && temp1[i+1] <= 'z'))
			{ 
			return false;
			}
			else if(CheckPreviousOp(i, temp1) && CheckNextCharOp(i, temp1)) 
			{
			continue;
			}
			
			}
			// check whether it is sin function
			else if(temp1[i] == 's')
			{ 
				
			if((i+1) < temp1.length && temp1[i+1] == 'i') 
			{
			if((i+2) < temp1.length &&temp1[i+2] == 'n' ) 
			{
			if((i+3) < temp1.length &&temp1[i+3] == '(') 
			{
			if((i+4) < temp1.length) {
			int j = i+4;
			int opcount = 0;
			while(temp1[j] != ')') {
			if(temp1[j] == '+' || temp1[j] == '*' || temp1[j] == '^' ) 
			{
			opcount++;
			if(opcount > 1) { 
				// if it is more than 1 it is having polynomial
			return false;
			} 
			else
			{
			if((CheckCharNum(temp1[j-1])) && (j+1) < temp1.length && CheckCharNum(temp1[j+1])) {
			return false;
			}
			if(j+1 < temp1.length) {
			j++;
			} else {
			return false;
			}
			}
			 } else 
			 {
			 if(!CheckChar(j, temp1)) 
			 {
			 return false;
			 }
			 else if((j+1 < temp1.length) && (temp1[j] == 'x' && ((j-1) >= 0 && temp1[j-1] >= 'a' && temp1[j-1] <= 'z') || ((j+1) < temp1.length && temp1[j+1] >= 'a' && temp1[j+1] <= 'z') || 
			((j+1) < temp1.length && (CheckCharNum(temp1[j+1]) || (j-1) >= 0 && CheckCharNum(temp1[j-1])) && !CheckCharNum(temp1[j])))) 
			 { 

			return false;
			} 
			 else if(j+1 < temp1.length)
			 {
			j++;
			}
			 else 
			 {
			return false;
			} 
			} 
			}
			if((j+1 < temp1.length) && temp1[j+1] == '^') {
			return false;
			} 
			else
			{
			 i = j+1;
			}
		}
			else
			{
				return false;
			}
		} 
			else 
			{
			return false;
			}
			} else {
			return false;
			}
			} else {
			return false;
			}
			}
			// check if it is cos function similar to sin function
			else if(temp1[i] == 'c') 
			{ 
			if((i+1) < temp1.length && temp1[i+1] == 'o')
			{
				if((i+2) < temp1.length &&temp1[i+2] == 's' )
				{
					
			if((i+3) < temp1.length &&temp1[i+3] == '(') {
			if((i+4) < temp1.length) {
			int j = i+4;
			int opcount = 0;
			while(temp1[j] != ')') {
			if(temp1[j] == '+' || temp1[j] == '*' ||temp1[j] == '^' ) {
			opcount++;
			if(opcount > 1) 
			{ 
			return false;
			} 
			else 
			{
			if((CheckCharNum(temp1[j-1])) && (j+1) < temp1.length && CheckCharNum(temp1[j+1])) {
			return false;
			}
			if(j+1 < temp1.length) {
			j++;
			} else {
			return false;
			}
			}
			 } else {
			 if(!CheckChar(j, temp1)) {
			 return false;
			 } else if((j+1 < temp1.length) && (temp1[j] == 'x' && ((j-1) >= 0 && temp1[j-1] >= 'a' && temp1[j-1] <= 'z') 
			|| ((j+1) < temp1.length && temp1[j+1] >= 'a' && temp1[j+1] <= 'z') || 
			((j+1) < temp1.length && (CheckCharNum(temp1[j+1]) || (j-1) >= 0 && CheckCharNum(temp1[j-1])) && !CheckCharNum(temp1[j])))) 
			 { 

			return false;
			}
			 else if(j+1 < temp1.length) {
			j++;
			} 
			 else
			 {
			return false;
			} 
			} 
			}
			if((j+1 < temp1.length) && temp1[j+1] == '^') { 
			return false;
			} else {
			i = j+1;
			}
			} else {
			return false;
			}
			} else {
			return false;
			}
			} else {
			return false;
			}
			} else {
			return false;
			}
			} 
			//Check if it is a tan function
			else if(temp1[i] == 't') {
				
			if((i+1) < temp1.length && temp1[i+1] == 'a') {
			if((i+2) < temp1.length &&temp1[i+2] == 'n' ) {
			//correct tan operation
			if((i+3) < temp1.length &&temp1[i+3] == '(') {
			if((i+4) < temp1.length) {
			int j = i+4;
			int opcount = 0;
			while(temp1[j] != ')') {
			if(temp1[j] == '+'  || temp1[j] == '*'  ||	temp1[j] == '^' ) {
			opcount++;
			if(opcount > 1) 
			{
			return false;
			} else {
			if((CheckCharNum(temp1[j-1])) && (j+1) < temp1.length && CheckCharNum(temp1[j+1])) 
			{
				
			return false;
			}
			if(j+1 < temp1.length) {
			j++;
			} else {
			return false;
			}
			}
			 } else {
			 if(!CheckChar(j, temp1)) {
			 return false;
			 } else if((j+1 < temp1.length) && (temp1[j] == 'x' && ((j-1) >= 0 && temp1[j-1] >= 'a' && temp1[j-1] <= 'z') 
			|| ((j+1) < temp1.length && temp1[j+1] >= 'a' && temp1[j+1] <= 'z') || 
			((j+1) < temp1.length && (CheckCharNum(temp1[j+1]) || (j-1) >= 0 && CheckCharNum(temp1[j-1])) && !CheckCharNum(temp1[j])))) {
			return false;
			} else if(j+1 < temp1.length) {
			j++;
			} else {
			return false;
			} 
			} 
			}
			if((j+1 < temp1.length) && temp1[j+1] == '^')
			{ 
			return false;
			} else {
			i = j+1;
			}
			} else {
			return false;
			}
			} else {
			return false;
			}
			} else {
			return false;
			}
			} else {
			return false;
			}
			} else if(temp1[i] == 'l') {
			if((i+1) < temp1.length && temp1[i+1] == 'n') {
			if((i+2) < temp1.length && temp1[i+2] == '(') {
			int j = i+3;
			while(temp1[j] != ')') {
			//loop
			if(CheckChar(j, temp1)) {
			continue;
			} else {
			return false;
			}
			}
			continue;
			} else {
			return false;
			}
			} else {
			return false;
			}
			} else if(temp1[i] == '+'  || temp1[i] == '*'  ||temp1[i] == '^' ) {
			if(CheckPreviousOp(i, temp1)) {
			return false;
			} else {
			continue;
			}
			} else if(temp1[i] == '(') {
			continue;
			} else if(temp1[i] == ')') {
			continue;
			} else {
			return false;
			}
			}
			return true;
			}
			}
	// to check whether it is a valid character 
	private boolean CheckChar(int j, char[] temp1) {
		if(CheckNextCharOp(j-1,temp1))
			return true;
		else if(CheckCharNum(temp1[j]))
		{
			return true;
		}
		else if(temp1[j]=='x')
		{
			return true;
		}
		return false;
	}

		// to check whether it is a character n
		 private boolean CheckCharNum(Character character) {
			if(character >= '0' && character <= '9' || character == '.') {
			return true;
			}
			return false;
			}
		 // to check whether it has previous operator
			private boolean CheckPreviousOp(int i, char temp1[]) {
			if (i == 0) {
			return true;
			}

			if (temp1[i - 1] == '+' || temp1[i - 1] == '*' || temp1[i - 1] == '(' || temp1[i - 1] == '^') {
			return true;
			}
			return false;
			}
			// to check whether the next character is a operator
			private boolean CheckNextCharOp(int i, char[] temp1) {
			if(i == temp1.length - 1) {
			return true;
			}
			if(temp1[i+1] == '+'|| temp1[i+1] == '*'  || temp1[i+1] == '^' || temp1[i+1] == ')' || temp1[i+1] == '(') {
			return true;
			}
			return false;
			}
}





		

	
