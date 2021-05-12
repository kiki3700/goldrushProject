package com.goldrush.service;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


import com.goldrush.dao.ItemDAO;
import com.goldrush.dto.ItemDTO;
import com.goldrush.dto.ItemListDTO;
import com.goldrush.dto.ResponseDTO;

public class ItemService {
	private ItemDAO itemDAO;
	
	public ItemService() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:dao-context.xml");
		this.itemDAO = (ItemDAO) ctx.getBean("ItemDAO");
	}
	private static final Logger logger = LoggerFactory.getLogger(ItemService.class);
	
	public List<ItemListDTO> getItemList(){
		logger.info("get all item list");
		return itemDAO.selectItemListForView();
	}
	
	public List<ItemListDTO> getItemListByStage(String stage){
		logger.info("get "+stage+" items list");
		return itemDAO.selectItemListForViewByStage(stage);
	}
	
	public ItemListDTO getItem(int itemsId) {
		return itemDAO.selectItemForView(itemsId);
	}
	

	public String postPicture(String code, MultipartHttpServletRequest request) {
		logger.info(code+" post picture");
		String path = "eclipse-workspace/Goldrush/BE/src/main/webapp/resources/img/item";
		//request.getSession().getServletContext().getRealPath("/resources/")+
		String address = "/img/item/";
		MultipartFile mf = request.getFile("img");
		String ext = mf.getOriginalFilename().substring(mf.getOriginalFilename().indexOf("."));
		try {
			byte[] byteImg = mf.getBytes();
			File file = new File(path, code+ext);
			FileCopyUtils.copy(byteImg, file);
			ItemService it = new ItemService();
			it.postThumnail(request,code, ext, file);
		} catch (IOException e) {
			logger.debug("posting picture is failed");
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		logger.info("posting picture is success");
		return address+code+ext;
	}

	
	public ResponseDTO postThumnail(MultipartHttpServletRequest request, String code, String ext ,File file) {
		logger.info("thumnail picture is trying to post");
		String path = "eclipse-workspace/Goldrush/BE/src/main/webapp/resources/img/item/thumnail/";
		File thFile = new File(path,code+ext);
		try {
			BufferedImage Image = ImageIO.read(file);
			int tWidth = 100;
			int tHeight = 100;
			BufferedImage tImage = new BufferedImage(tWidth, tHeight, BufferedImage.TYPE_3BYTE_BGR);
			Graphics2D graphic = tImage.createGraphics();
			Image image = Image.getScaledInstance(tWidth, tHeight, Image.SCALE_SMOOTH);
			graphic.drawImage(image,0,0,tWidth, tHeight, null);
			graphic.dispose();
			ImageIO.write(tImage, ext.substring(1), thFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.info("posting thumnail is failed");
			e.printStackTrace();
			return new ResponseDTO(0, "이미지 등록에 실패했습니다.");
		}
		logger.info("posting thumnail is success");
		return new ResponseDTO(1, "이미지 등록에 성공했습니다.");
	}
	public ResponseDTO postNewItem(ItemDTO dto) {
		logger.info("insert new item");
		return itemDAO.insertNewItem(dto);
	}
	public ResponseDTO putItem(ItemDTO dto) {
		logger.info("put edit");
		return itemDAO.updateItem(dto);
	}
	public ResponseDTO deleteItem(ItemDTO dto) {
		logger.info("delete item");
		return itemDAO.deleteItem(dto.getItemsId());
	}
}
