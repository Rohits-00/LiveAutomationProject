package utility;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.imageio.ImageIO;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class CommonUtils {
	 public static String generatenewemail() {
	     return new Date().toString().replaceAll("\\s", "").replaceAll("\\:", "")+"@gmail.com";

	 }
	 
	 public static boolean compareTwoScreenshots(String actualimagePath, String expectedimagePath ) throws IOException{
	  
	 BufferedImage actualBImg= ImageIO.read(new File(actualimagePath));
	 BufferedImage expectedbImg= ImageIO.read(new File(expectedimagePath));
	 ImageDiffer imgDiffer = new ImageDiffer();
	 ImageDiff imgDifference = imgDiffer.makeDiff(expectedbImg,actualBImg);
	 return imgDifference.hasDiff();
	 }
     public  static Properties loadproperties () {
		 Properties prop = new Properties();
		 try {
			 FileReader ft = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\projectdata.properties");
			 prop.load(ft);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	 }
}