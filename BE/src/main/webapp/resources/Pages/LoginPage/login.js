const pLogin = `
  <div class="back">
    <div class="login_page">
      <div class="site_main">
        <a href="#/main">
          <p class="logo">Gold Rush</p>
        </a>
      </div>
      <div class="site_login">
        <div class="input">
          <form action="">
            <input class="input_id" type="text" placeholder="user_mail"> 
            <input class="input_password" type="password" placeholder="user_password">
          </form>
        </div>
        <button class="form_login">로그인</button>
      </div>
      <div class="create">
        <a href="#login"> 
          <div class="find_id_pwd">
            id / password 찾기
          </div>
        </a>
        <a href="#create">
          <div class="create_account">
            회원가입
          </div>
        </a>
      </div>
      <a href="#login">
        <div class="social_login">
          SOCIAL 로그인 KAKAO
        </div>
      </a>
    </div>
  </div>`
  
  export default pLogin;