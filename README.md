# goldrushProject
 골드러시는 리셀투자 플랫폼으로 리셀은 희소성이 높은 상품들을 매입 후 리셀 프리미엄을 붙여서 판매하는 행위를 말합니다.
일반적을 희소성이 높은 미술품, 한정판 스니커즈 골동품 등은 고가이기 때문에 투자 접근성이 떨어지는 단점이 있습니다. 
골드러시는 희소성이 높은 재화를 매입 후 지분을 투자자에게 분배하고, 청산 전까지 투자자는 이를 매매할 수 있습니다. 재화의 청산 후에는
지분에 비례하여 투자자에게 수익금을 배분하게 됩니다.
<divider>
<h3>사용기술<h3>
<h4>프론트엔드</h4>
<ul>
<li>Vanilla JS MVC</li>
<li>Fetch API</li>
</ul>
<h4>백엔드</h4>
<ul>
  <li>스프링</li>
    DI 의존성 주입 ⇒ xml context 방식 사용
    어노테이션</li>
 <li>scheduler</li>
 <li>restTemplate</li>
 <li>jackson</li>
    통신을 통해 주고받는 json 형식 파싱 및 필요한 json 형식 생성
 <li> multipart</li>
    사진데이터를 업로드 하기위해 사용함 . 사진은 자바에서 편집 후 thumnail로 조정됨
 <li> thymeleaf ⇒ html을 사용하기 위해서</li>
 <li> Open banking api</li>
 <li> Cookie=>토큰 및 오픈 뱅킹 인증 데이터 사용</li>
 <li>jdbc(mysql)</li>
</ul>
<divider>
<h2>시나리오별 기능<h2>
<h3>관리자 기능</h3>
<ol>
<li>아이템 등록, 수정, 삭제</li>
관리자는 상품사진, 이름, 코드, 카테고리, 매입가, 조각의 개수, 상세 설명, 스케줄 등을 입력할 수 있다.
<li>청산</li>
clear 스테이지에 있는 아이템을 청산하고, 수익금을 회원들의 가상 계좌에 지분 만큼 배분할 수 있다.
</ol>
<h3>아이템 스테이지</h3>
<ol>
<li>unopen</li>
아이템이 등록되었을 때 상태이며 회원들은 unopen stage에 있는 아이템을 열람할 수 없다.
<li>open</li>
회원들은 정해진 지분 수 이내에서 청약을 할 수 있다.
<li>trade</li>
ipo이후 배분된 지분을 회원들은 매매 할 수 있는 기간을 말한다.
<li>clear</li>
아이템을 청산하기 전 상태를 말하며, 회원들이 등록했던 호가들은 취소 최적의 조건을 제시하는 매수와 현물을 거래한다.
<li>close</li>
아이템을 청산한 뒤 닫힌 상태를 말한다 아이템은 회원들이 다시 열람 할 수 없다.
</ol>
<h3>회원 기능</h3>
<ol>
<li>회원가입</li>
모든 투자 활동은 회원들만 이용할 수 있다.
<li>입금/출금</li>
회원들은 오픈뱅킹을 통해 가상계좌에 입출금을 할 수 있다. 모든 매매 활동은 가상계좌의 잔액을 통해 이뤄진다.
<li>청약</li>
open stage에 있는 아이템 지분에 청약하는 것을 의미한다. ipo 시 청약한 지분만큼 증권을 배분 받는다.
<li>매수/ 매도</li>
회원은 매수 의사결정은 3가지 분기를 갖게된다. 매수/ 매도, 적절한 호가를 찾았을 시 거래 체결, 적절한 조건을 찾지 못했을 시 호가를 할 수 있다.
</ol>

