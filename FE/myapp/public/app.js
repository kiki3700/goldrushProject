import MainController from './Pages/MainPage/main.controller.js'
import LoginController from './Pages/LoginPage/login.controller.js'
import CreateController from './Pages/CreatePage/create.controller.js'
import CatalogueController from './Pages/CataloguePage/catalogue.controller.js'
import ManagerController from './Pages/ManagerPage/manager.controller.js'
import UserInfoController from './Pages/UserInfoPage/userInfo.controller.js'
import QnaController from './Pages/QnaPage/qna.controller.js'
import ContactController from './Pages/ContactPage/contact.controller.js'
import EnrollController from './Pages/EnrollPage/enroll.controller.js'
import UserManageController from './Pages/UserManagePage/userManage.controller.js'
import BuyController from './Pages/BuyPage/buy.controller.js'
import SellController from './Pages/SellPage/sell.controller.js'
import ClearController from './Pages/ClearPage/clear.controller.js'

import Router from './Route/router.js'

const router = new Router();

router.addRoute('main', new MainController());
router.addRoute('login', new LoginController());
router.addRoute('create', new CreateController());
router.addRoute('catalogue', new CatalogueController());
router.addRoute('manager', new ManagerController());
router.addRoute('userInfo', new UserInfoController());
router.addRoute('qna', new QnaController());
router.addRoute('contact', new ContactController());
router.addRoute('enroll', new EnrollController());
router.addRoute('userManage', new UserManageController());
router.addRoute(`buy`, new BuyController());
router.addRoute(`sell`, new SellController());
router.addRoute('clear', new ClearController());