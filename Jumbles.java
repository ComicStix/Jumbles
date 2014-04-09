import java.util.*;
import java.io.*;

public class Jumbles
{
	public static void main( String args[] ) throws Exception
	{
		if (args.length < 2 )
		{
			System.out.println("FATAL ERROR: Must enter a dictionary file and a jumbled words file on the command line\n");
			System.exit(0);
		}

		ArrayList<String> dictionary = new ArrayList<String>();
		ArrayList<String> jumblesArray = new ArrayList<String>();
		HashMap<String,String> jumblesHashmap = new HashMap<String,String>();

		Scanner infile =  new Scanner( new File( args[0] ) );
		while (infile.hasNextLine())
		{
			String dictionaryWord = infile.nextLine();
			dictionary.add(dictionaryWord);
		}
		Collections.sort(dictionary);
		
		infile = new Scanner (new File( args[1] ));
		while (infile.hasNextLine())
		{
			String jumbledWord = infile.nextLine();
			jumblesArray.add(jumbledWord);
		}
		Collections.sort(jumblesArray);

		for(String s:dictionary){
			char [] characterArray = s.toCharArray();
			Arrays.sort(characterArray);
			String sortedWord = new String(characterArray);

			if (!jumblesHashmap.containsKey(sortedWord))
				jumblesHashmap.put(sortedWord,s);

			else 
				jumblesHashmap.put(sortedWord,jumblesHashmap.get(sortedWord) + " " + s);
		}
			
		for (String s:jumblesArray){
			System.out.print(s + " ");
			char [] characterArray = s.toCharArray();
			Arrays.sort(characterArray);
			String sortedJumbledWord = new String(characterArray);

			if(jumblesHashmap.containsKey(sortedJumbledWord)){
				System.out.println(jumblesHashmap.get(sortedJumbledWord));
			}
			else {
				System.out.println();
			}
		}
	}//EndOfMain
}//EOF