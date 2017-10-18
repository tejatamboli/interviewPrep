package Collection;

public class findNextChar {
	public static void main(String[] args) {
		char[] l1 = {'c','f','j','p','v'};
		char[] target = {'a','c','f','k','v','z'};
		for(char c: target) {
			System.out.println(" " + c + " : " + getNextChar(l1,c));
		}
	}
	public static char getNextChar(char[] l1, char c) {
		
		int s = 0;
		int e = l1.length - 1;
		char result = l1[0];
		while(s < e) {
			int mid = (s + e)/2;
			if(l1[mid] == c) {
				if(mid < l1.length-1) { //to check end
					if(l1[mid+1] > c) // to check duplicate chars
						return l1[mid+1];
					else
						s = mid + 1; //for duplicate search again from next char
				} else
					return result;
			} else if(l1[mid] < c)
				s = mid + 1;
			else {
				result = l1[mid];
				e = mid - 1;
			}	
		}
		return result;
	}
}
