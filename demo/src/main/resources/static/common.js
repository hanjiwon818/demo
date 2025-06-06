// 👉 모든 페이지 공통: 로고 클릭 시 메인으로 이동
window.addEventListener('DOMContentLoaded', () => {
    const logo = document.querySelector('.logo');
    if (logo) {
      logo.style.cursor = 'pointer';
      logo.addEventListener('click', () => {
        window.location.href = '/users/main';
      });
    }
  });

  //로그인 버튼을 누르면 로그인 페이지로 넘어가는 기능
  function goToLogin() {
    window.location.href = '/users/login';
  }
 //마이페이지 버튼 설정
  function goToMyPage() {
    window.location.href = '/users/mypage';
  }

/*  //리뷰 작성
  function goToWriteReview(userId) {
    window.location.href = '/users/' + userId + '/write-review';
  }*/


