package com.goldrush.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

public class ImgUtils {
	private static final Logger logger = LoggerFactory.getLogger(ImgUtils.class);
	
	public static String uploadFile(String name, byte[] fileData) throws Exception{
		String path = "src/main/webapp/WEB-INF/itemImg/";
		File target = new File(path,name+".jpg");
		FileCopyUtils.copy(fileData, target);
		return null;
	}
	


}
	