import MainController from './MainPage/main.controller.js'
import LoginController from './LoginPage/login.controller.js'
import CreateController from './CreatePage/create.controller.js'
import CatalogueController from './CataloguePage/catalogue.controller.js'
import ManagerController from './ManagerPage/manager.controller.js'
import UserInfoController from './UserInfoPage/userInfo.controller.js'
import QnaController from './QnaPage/qna.controller.js'
import ContactController from './ContactPage/contact.controller.js'
import EnrollController from './EnrollPage/enroll.controller.js'
import UserManageController from './UserManagePage/userManage.controller.js'

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
router.addRoute('userManager', new UserManageController());





