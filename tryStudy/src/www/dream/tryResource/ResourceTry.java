package www.dream.tryResource;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ResourceTry {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("null");
		list.add("null2");
		list.add("null3");
		list.add("null4");
		
		try (PrintWriter pw = new PrintWriter("myOut.txt")) {
			int i = 0;
			for (String val : list) {
				pw.println(val);
				i++;
				if (i == 2) {
					int j = i / 0;
				}
			}
		} catch (FileNotFoundException e) {
			
		}
	}

}
