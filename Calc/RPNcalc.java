import java.util.*;
import java.io.*;

public class RPNcalc {
	public static void main(String[] args) {
		Queue oq = new QueueLL();
		oq = toRPN();
		
		int result;
		result = runQuery(oq);
		
		println();
		println(result);
	}
	
	public static Queue toRPN() {
		
		Scanner inp = new Scanner(System.in);
		Stack operatorStack = new StackLL();
		Queue outputQueue = new QueueLL();
		
		char[] query;
		query = inp.nextLine().toCharArray();
		
		print("Input: ");
		for (int i=0; i<query.length; i++)
			print(query[i]);
		println();
		
		print("Output: ");
		boolean done; char nextChar;
		for (int i=0; i<query.length; i++) {
			if (Character.isDigit(query[i])) {
				outputQueue.enqueue(query[i]);
				print(query[i]);
			}
			else if (query[i]=='*' || query[i]=='+' || query[i]=='-' || query[i]=='/' || query[i]=='(') {
				operatorStack.push(query[i]);
			}
			else if (query[i]==')') {
				done=false;
				while (done==false) {
					nextChar=(char)operatorStack.pop();
					if (nextChar!='(') {
						outputQueue.enqueue(nextChar);
						print(nextChar);
					}
					else {done=true;}
				}
			}
			//print(" "+i+":"+query[i]);
		}
		println();
		return outputQueue;
	}
	
	public static int runQuery(Queue q) {
		int ans,res,o1,o2; char charCur;
		Stack calcStack = new StackLL();
		
		while (!q.isEmpty()) {
			charCur=(char)q.dequeue();
			println("  "+charCur);
			if (Character.isDigit(charCur)) {
				calcStack.push(Character.getNumericValue(charCur));
			}
			else if (charCur=='+') {
				res=(int)calcStack.pop()+(int)calcStack.pop();
				//println(res+"+");
				calcStack.push(res);
			}
			else if (charCur=='-') {
				res=(int)calcStack.pop()-(int)calcStack.pop();
				//println(res);
				calcStack.push(res);
			}
			else if (charCur=='*') {
				res=(int)calcStack.pop()*(int)calcStack.pop();
				//println(res);
				calcStack.push(res);
			}
			else if (charCur=='/') {
				o1 = (int)calcStack.pop();
				//print("o1");
				o2 = (int)calcStack.pop();
				//print(calcStack.pop());
				res=o2/o1;
				calcStack.push(res);
			}
		}
		ans = (int)calcStack.pop();
		println("answer: "+ans);
		return ans;
	}
	
	public static void print(Object s) {System.out.print(s);}
	public static void println(Object s) {System.out.println(s);}
	public static void println() {System.out.println();}
}