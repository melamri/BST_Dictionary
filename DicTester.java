/** 
 *	Ikbel Amri
 *	Data Structures
 *	Realization of a map by means of a binary search tree.
 *	Adapted by Michael Goodrich
 */
  
  import java.util.Scanner;
  import java.util.StringTokenizer; 

  public class DicTester {

	public static void main (String [] args) { 
		// create an instance of the first tree to store the words
		BSTree dict = new BSTree(); 

		System.out.println("*** user input");
		System.out.println("Please write a command.");
		System.out.println("You may type 'insert', 'search', 'remove', 'print', 'printBST', or 'quit'.");
		
		// will run infinity loop & take user input until 'quit' command
		boolean running=true; 
		System.out.println("*** user input test");
		
		while(running) {
			// create scanner object to take user input
			Scanner kbd = new Scanner(System.in); 

			System.out.print("Type expression > ");	//text before input
			String inStr = kbd.nextLine();			//keyboard scanner input
			
			// parsing a string (tokenize)
			StringTokenizer st = new StringTokenizer(inStr, " ");
			String command = ""; // declare and initialize command, word and definition Strings
			String word = "";
			String definition = "";
			while (st.hasMoreTokens()){
				command = st.nextToken();
				if (command.compareTo("insert")!=0 && command.compareTo("search")!=0 && command.compareTo("remove")!=0)
				// in case the user selects to quit the program or print
				// they will not type additional commands
					break; // break through the while loop
				word = st.hasMoreTokens() ? st.nextToken() : null; // assign the second word to 'word'
				if (command.compareTo("search")==0 || command.compareTo("remove")==0)
				// in case the user selects to search or remove a word
				// they will not type any definition
					break; // break through the while loop at this point
				definition = "";
				while (st.hasMoreTokens()) {
					// get one token (separated by whitespace)
					definition = definition + st.nextToken() + " ";
					// the definition takes all the remaining words
				}
			}
		
			// in case the user wants to quit the program
			// if it returns 0, it means the string is identical to the given one
			if (command.compareTo("quit")==0) {
				running = false;	// this will terminate while loop
				System.out.println("Good-Bye!");	// output
			}
			// if user selects to add, search for or remove a word
			else if (command.compareTo("insert")==0 || command.compareTo("search")==0 || command.compareTo("remove")==0){ 
				//error detection
				if (word!= null){
					if (command.compareTo("insert")==0){ // if user selects to "insert" a word
						dict.insert( word, definition); // insert the word into dictionary in an alphabetical way
						System.out.println("result> word " + word + " is inserted"); // output message
						// System.out.println(myDeque.size); // size check
					}
					else if (command.compareTo("search")==0){ // if user selects to "search" a word
						dict.search(word); // search the word in the dectionary
					}
					else if (command.compareTo("remove")==0){ // if the user selects to "remove" a word
						dict.removeEntry(word); // run the remove method
					}
				}
				else System.out.println("Invalid input. The entry may not be empty"); //error message
			}
			else if (command.compareTo("print")==0){
				dict.printEntries(); // run the print dictionary method from the BSTree
			}
			else if (command.compareTo("printBST")==0){
				BSTPrinter.printBST(dict.root());
			}
			else {
				// In case the user does not select a command that is offered 
				// or if the mistype the command, then echo the input string
				System.out.println("Command not recognized. Please try again."); // output showing the error
				// System.out.println(myDeque.size); // size check
			}
		}
	}
}