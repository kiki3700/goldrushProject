const enroll = `
  <nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
      <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">toggle navgation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
        <a class="navbar-brand" href="#manager"><p class="logo">Gold Rush</p></a>
      </div>
      <div id="navbar" class="navbar-collapse collapse">
        <ul class="nav navbar-nav navbar-right">
          <li><a href="#manager" class="welcome">환영합니다! 관리자님!</a></li>
          <li><a href="#main" class="logout">로그아웃</a></li>
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
                <a href="#manager"><p>상품 관리</p></a>
                <a href="#enroll" class="selected"><p>상품 등록</p></a>
                <a href="#userManage"><p>회원 관리</p></a>
              </div>
            </div>
          </div>
          <div class="follow_menu col-lg-10 col-xs-10">
            <form class='enroll_form' enctype="multipart/form-data">  
              <div class="item_image">
                <div class='image_form'>
                  <div>
                    <label for="image_uploads">첨부할 사진을 올려주세요 (click!)</label>
                    <input type="file" id="image_uploads" name="img" accept=".jpg, .jpeg, .png" multiple>
                  </div>
                  <div class="preview">
                    <p>100*100px의 크기로 들어가요!</p>
                  </div>
                </div>
              </div>
              <div class="item_container">
                <div class='necessary_form'>
                  <div class="item_info">
                    <p class="name">상품이름</p>
                    <input type="text" name='name'>
                  </div>
                  <div class="item_info">
                    <p class="cost">상품코드</p>
                    <input type="text" name='code'>
                  </div>
                  <div class="item_info">
                    <p class="piece">원가</p>
                    <input type="text" name='cost'>
                  </div>
                  <div class="item_info">
                    <p class="piece">조각</p>
                    <input type="text" name='quantity'>
                  </div>
                  <div class="item_info">
                    <p class="opening">Opening Stage</p>
                    <input type="date" name='openingDate'>
                  </div>
                  <div class="item_info">
                    <p class="ipo">IPO Stage</p>
                    <input type="date" name='ipoDate'>
                  </div>
                  <div class="item_info">
                    <p class="trading">Trading Stage</p>
                    <input type="date" name='tradingDate'>
                  </div>
                  <div class="item_info">
                    <p class="clearing">Clearing Stage</p>
                    <input type="date" name='clearingDate'>
                  </div>
                  <div class="item_info">
                    <p class="piece">카테고리</p>
                    <input type="text" name='category'>
                  </div>
                  <div class="item_info">
                    <textarea name="description"></textarea>
                  </div>
                </div>  
                
                <div class="button-group">
                  <input type="submit" class="btn enroll_button"></input>
                </div>
              </div>
            </form>   
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
  export default enroll;