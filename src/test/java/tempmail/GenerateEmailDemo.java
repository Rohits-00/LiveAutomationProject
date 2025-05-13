package tempmail;

import java.util.Date;

public class GenerateEmailDemo {

	public static void main(String[] args) {
		Date date=new Date();
		String dateString =date.toString();
		String noSpaceDateString=dateString.replaceAll("\\s", "");
		String noSpaceAndColonDateString=noSpaceDateString.replaceAll("\\:", "");
		String emailformat = noSpaceAndColonDateString+"@gmail.com";
		System.out.println(emailformat);
	}

}
 