import static org.junit.Assert.*;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

import org.junit.Test;

import com.goldrush.util.ImgUtils;

public class junitforImg {

	@Test
	public void test() throws IOException {
		File sourceImage = new File("src/main/webapp/WEB-INF/itemImage/879.jpg");
		String path = "src/main/webapp/WEB-INF/itemImage/";
		System.out.println(sourceImage.getAbsolutePath());
		System.out.println(sourceImage.toString());
		URL url = new URL("https://i.stack.imgur.com/WxVXe.jpg");

		BufferedImage image = ImageIO.read(url);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ImageIO.write(image, "jpeg", bos);
		byte [] data = bos.toByteArray();
		System.out.println(data);
		ImgUtils img = new ImgUtils();
		try {
			img.uploadFile("sponge", data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
