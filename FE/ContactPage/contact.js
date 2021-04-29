 const contact = `
  <nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
      <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">toggle navgation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
        <a class="navbar-brand" href="#"><p class="logo">Gold Rush</p></a>
      </div>
      <div id="navbar" class="navbar-collapse collapse">
        <ul class="nav navbar-nav navbar-right">
          <li><a href="#">환영합니다! 이름님!</a></li>
          <li><a href="#">로그아웃</a></li>
        </ul>
      </div> 
    </div>
  </nav>
  
  <section class="merchandise_list">
    <div class="container-fluid">
      <div class="item_box">
        <div class="row">
          <div class="menu col-lg-2 col-xs-2">
            <div class="row">
              <div class="col">
                <a href=""><p>My Info</p></a>
                <a class="collapsed" data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne"><p>item</p></a>
                <ul id="collapseOne" class="nav flex-column collapse collapsed">
                  <li>
                    <a href="#">Total</a>
                  </li>
                  <li>
                    <a href="#">IPO Stage</a>
                  </li>
                  <li>
                    <a href="#">Trading Stage</a>
                  </li>
                  <li>
                    <a href="#">Clearing Stage</a>
                  </li>
                </ul>
                <a href=""><p>QNA</p></a>
                <a href="" class="selected"><p>Contact</p></a>
              </div>
            </div>
          </div>
        <div class="follow_menu col-lg-10 col-xs-10">
          <h1>추가로 궁금하신 사항이 있으시면 메일주세요!</h1>
          <div class="form-group mail-form">
            <input type="text" class="form-control required" name="name" placeholder="이름" title="Name">
          </div>
          <div class="form-group">
            <input type="text" class="form-control required" name="email" placeholder="이메일" title="Email">
          </div>
          <div class="form-group">
            <input type="text" class="form-control required" name="subject" placeholder="제목" title="Subject">
          </div>
          <div class="form-group">
            <textarea type="message" class="form-control required" name="subject" placeholder="내용" title="Message" rows="5"></textarea>
          </div>
          <div class="form-group">
            <button class="send_btn btn" type="submit">전 송</button>
            <button class="send_btn btn" type="reset">재 설 정</button>
          </div>
        </div>
      </div>
    </div>
  </section>
  

  <footer>
    <div class="col-lg-12 col-xs-12 text-center footer_content">
      4주 프로젝트
    </div>
  </footer>
`
export default contact;