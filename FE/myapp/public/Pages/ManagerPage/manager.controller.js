import ManagerView from './manager.view.js'
import ManagerModel from './manager.model.js'

export default class ManagerController{
  constructor() {
    this.model = new ManagerModel();
    this.view = new ManagerView();
  }

  getlist = async(callback) => {
    // console.log(await callback());
    console.log('list 생성');
    this.list = await callback();
    this.view.makeList(this.list);
  }

  getItem = async(callback) => {
    console.log('item 생성');
    this.item = await callback(window.location.hash.match(/[0-9]*$/)[0] || 1);
    this.view.updateItemDetail(this.item);
  }
  
  total = async() => {
    await this.getlist(this.model.GetItemList);
    await this.getItem(this.model.GetItem);

    this.view.BindInputButton(this.updateImageDisplay);
    this.view.BindUpdateItem(this.update);
    this.view.BindDeleteItem(this.delete);
    this.view.BindLogoutButton(this.clickLogout);
  }

  update = (e) => {
    e.preventDefault();
    console.log(this.view.formData);
    const formData = new FormData(this.view.formData);
    this.itemId = window.location.hash.match(/[0-9]*$/)[0] || 1;
    
    for (let key of formData.keys()) {
      console.log(key);
    }
    
    // FormData의 value 확인
    for (let value of formData.values()) {
      console.log(value);
    }
    this.model.PostUpdateItem(formData, this.itemId);
    
  }
  delete = (e) => {
    e.preventDefault();
    console.log('delete 버튼이 눌렸다.');
    this.itemId = window.location.hash.match(/[0-9]*$/)[0] || 1;
    this.model.DeleteItem(this.itemId);
  }

  updateImageDisplay = () => {
    console.log('눌리긴하니?');
    const preview = this.view.previewImage;
    const input = this.view.inputBtn;
    const fileTypes = [
      "image/apng",
      "image/bmp",
      "image/gif",
      "image/jpeg",
      "image/pjpeg",
      "image/png",
      "image/svg+xml",
      "image/tiff",
      "image/webp",
      "image/x-icon"
    ];
    
    function validFileType(file) {
      return fileTypes.includes(file.type);
    }

    while(preview.firstChild) {
      preview.removeChild(preview.firstChild);
    }
  
    const curFiles = input.files;
    console.log(input);
    console.log(curFiles[0]);
    if(curFiles.length === 0 || curFiles.length > 1) {
      const para = document.createElement('p');
      para.textContent = '이미지는 단 하나만 삽입할 수 있습니다.';
      preview.appendChild(para);
    } else {
      const list = document.createElement('ul');
      preview.appendChild(list);
  
      for(const file of curFiles) {
        const listItem = document.createElement('li');
        
        if(validFileType(file)) {
        
          const image = document.createElement('img');
          image.src = URL.createObjectURL(file);
          console.log(image.src);
          listItem.appendChild(image);
        
        }
  
        list.appendChild(listItem);
      }
    }
  }

  clickLogout = () => {
    window.localStorage.removeItem('userInfo');
  }
}