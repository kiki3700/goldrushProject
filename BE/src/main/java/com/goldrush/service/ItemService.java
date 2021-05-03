package com.goldrush.service;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.goldrush.dao.ItemDAO;
import com.goldrush.dao.MemberDAO;
import com.goldrush.dto.ItemDTO;
import com.goldrush.dto.ItemListDTO;
import com.goldrush.dto.ResponseDTO;

public class ItemService {
	private ItemDAO itemDAO;
	
	public ItemService() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:dao-context.xml");
		this.itemDAO = (ItemDAO) ctx.getBean("ItemDAO");
	}
	
	public List<ItemListDTO> getItemList(){
		return itemDAO.selectItemListForView();
	}
	
	public List<ItemListDTO> getItemListByStage(String stgae){
		return itemDAO.selectItemListForViewByStage(stgae);
	}
	
	public ItemListDTO getItem(int itemsId) {
		return itemDAO.selectItemForView(itemsId);
	}
	

	public String postPicture(String code, MultipartHttpServletRequest request) {
		String path = "eclipse-workspace/Goldrush/BE/src/main/webapp/WEB-INF/views/resources/img/item";
		String address = "/WEB-INF/views/resources/img/item/";
		MultipartFile mf = request.getFile("img");
		String ext = mf.getOriginalFilename().substring(mf.getOriginalFilename().indexOf("."));
		try {
			byte[] byteImg = mf.getBytes();
			File file = new File(path, code+ext);
			FileCopyUtils.copy(byteImg, file);
			ItemService it = new ItemService();
			it.postThumnail(code, ext, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return address+code+ext;
	}
	
	public ResponseDTO postThumnail(String code, String ext ,File file) {
		String path = "eclipse-workspace/Goldrush/BE/src/main/webapp/WEB-INF/views/resources/img/item/thumnail/";
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
			ImageIO.write(tImage, "jpg", thFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseDTO(0, "이미지 등록에 실패했습니다.");
		}
		return new ResponseDTO(1, "이미지 등록에 성공했습니다.");
	}
	public ResponseDTO postNewItem(ItemDTO dto) {
		return itemDAO.insertNewItem(dto);
	}
	public ResponseDTO putItem(ItemDTO dto) {
		return itemDAO.updateItem(dto);
	}
	public ResponseDTO deleteItem(ItemDTO dto) {
		return itemDAO.deleteItem(dto.getItemsId());
	}
	
}
