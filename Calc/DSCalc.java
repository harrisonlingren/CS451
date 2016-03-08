import java.util.*;
import java.io.*;

public class DSCalc {
	
	public static void main(String[] args) {
		Queue qs = new QueueLL();
		qs = loadQuery();
		
		String result = "";
		result = runQuery(qs);
		
		println();
		println(result);
	}
	
	public static Queue loadQuery() {
		Scanner inp = new Scanner(System.in);
		Queue queryQueue = new QueueLL();
		char[] query;
		
		query = inp.nextLine().toCharArray();
		
		print("Input: ");
		for (int i=0; i<query.length; i++) {
			queryQueue.enqueue(query[i]);
			 print(" "+i+":"+query[i]);
		}
		println();
		
		return queryQueue;
	}
	
	public static String runQuery(Queue q) {
		
		// stateCurs: 0-7, 0 = init and 8 = accept
		int stateCur = 0;
		
		// outQueue = dequeueped from q
		char charCur;
		Queue outQueue = new QueueLL();
		
		//result string
		String r = "";
		
		while (!q.isEmpty() ) {
			charCur = (char)q.dequeue();
			print(stateCur+":"+charCur+" ");
			switch(stateCur) {
				case 0:
					if (charCur==' ' || Character.isDigit(charCur) ) {
						stateCur=1;
						println("state: 0->1");
						break;
					}
				case 1:
					if (charCur=='(' || charCur==' ') {
						stateCur=1;
						println("state: 1->1");
						break;
					}
					else if (Character.isDigit(charCur)) {
						stateCur=2;
						println("state: 1->2");
						break;
					}
				case 2:
					if (Character.isDigit(charCur)) {
						stateCur=2;
						println("state: 2->2");
						break;
					}
					else if (charCur=='/') {
						stateCur=4;
						println("state: 2->4");
						break;
					}
					else if (charCur=='*' || charCur=='+' || charCur=='-') {
						stateCur=3;
						println("state: 2->3");
						break;
					}
				case 3:
					if (Character.isDigit(charCur)) {
						stateCur=5;
						println("state: 3->5");
						break;
					}
				case 4:
					if (Character.isDigit(charCur)) {
						stateCur=5;
						println("state: 4->5");
						break;
					}
				case 5:
					if (Character.isDigit(charCur)) {
						stateCur=5;
						println("state: 5->5");
						break;
					} 
					else if (charCur=='*' || charCur=='+' || charCur=='-') {
						stateCur=3;
						println("state: 5->3");
						break;
					}
					else if (charCur=='/') {
						stateCur=4;
						println("state: 5->4");
						break;
					}
					else if (charCur==')' || charCur=='(') {
						stateCur=6;
						println("state: 5->6");
						break;
					}
					else if (charCur=='=') {
						stateCur=7;
						println("state: 5->7");
						break;
					}
				case 6:
					if (charCur==')') {
						stateCur=6;
						println("state: 6->6");
						break;
					}
					else if (Character.isDigit(charCur)) {
						stateCur=5;
						println("state: 6->5");
						break;
					}
					else if (charCur=='*' || charCur=='+' || charCur=='-') {
						stateCur=3;
						println("state: 6->3");
						break;
					}
					else if (charCur=='/') {
						stateCur=4;
						println("state: 6->4");
						break;
					}
					else if (charCur=='=') {
						stateCur=7;
						println("state: 6->7");
						break;
					}
				case 7:
					println("state: 7->accept");
					break;
				default:
					println("none found");
					break;
			}
			outQueue.enqueue(charCur);
		}
		for (int i=0; i<outQueue.size(); i++) {
			r = r + outQueue.dequeue().toString();
		}
		return r;
	}
	
	public static void print(Object s) {System.out.print(s);}
	public static void println(Object s) {System.out.println(s);}
	public static void println() {System.out.println();}
}