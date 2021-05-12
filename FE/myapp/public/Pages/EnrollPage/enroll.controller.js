import EnrollView from './enroll.view.js';
import EnrollModel from './enroll.model.js';

export default class QnaController {
  constructor() {
    this.view = new EnrollView();
    this.model = new EnrollModel();
    
  }
  total = () => {
    this.view.BindEnrollButton(this.enrollButton);
    this.view.BindInputButton(this.updateImageDisplay);
    this.view.BindLogoutButton(this.clickLogout);
  } 
  enrollButton = (e) => {
    e.preventDefault();
    let formData = new FormData(this.view.formData);
    // FormData의 key 확인
    for (let key of formData.keys()) {
      console.log(key);
    }

    // FormData의 value 확인
    for (let value of formData.values()) {
      console.log(value);
    }
    
    this.model.postEnrollItem(formData);
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