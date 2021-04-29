import CatalogueView from './catalogue.view.js'
import CatalogueModel from './catalogue.model.js'

export default class CatalogueController{
  constructor() {
    this.model = new CatalogueModel();
    this.view = new CatalogueView();
  }
  total = () => {
    console.log('카탈로그');
  }
}