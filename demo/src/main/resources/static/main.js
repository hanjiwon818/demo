// 👉 로고 클릭 시 메인으로 이동
const logo = document.querySelector('.logo');
if (logo) {
  logo.addEventListener('click', () => {
    window.location.href = '/main';
  });
}

// 👉 배너 넘기기 기능
const banners = ['banner1.png', 'banner2.png', 'banner3.png'];
let currentBanner = 0;

function updateBanner() {
  const bannerBox = document.querySelector('.banner-box');
  if (bannerBox) {
    bannerBox.innerHTML = `<img src="../assets/${banners[currentBanner]}" alt="배너" style="width:100%; height:100%; object-fit:cover; border-radius:10px;">`;
  }
}

function nextBanner() {
  currentBanner = (currentBanner + 1) % banners.length;
  updateBanner();
}

function prevBanner() {
  currentBanner = (currentBanner - 1 + banners.length) % banners.length;
  updateBanner();
}

// 👉 초기 배너 설정
updateBanner();

// 👉 검색 자동완성
const categories = [
  "운동", "음악", "요리", "컴퓨터", "공부",
  "패션", "번역", "지역입시", "상담"
];

const relatedKeywords = {
  "운동": ["운동", "헬스", "러닝", "요가"],
  "음악": ["음악","작곡", "기타", "피아노"],
  "요리": ["요리","한식", "디저트", "레시피"],
  "컴퓨터": ["컴퓨터", "프로그래밍", "코딩", "IT"],
  "공부": ["공부", "학습법", "시험", "노트"],
  "패션": ["패션", "코디", "스타일", "쇼핑몰"],
  "번역": ["번역", "영어", "일본어", "자막"],
  "지역입시": ["지역입시", "학군", "학원", "학교"],
  "상담": ["상담", "진로", "고민", "멘탈"]
};

const searchInput = document.getElementById('searchInput');
const suggestionBox = document.createElement('div');
suggestionBox.classList.add('suggestion-box');
document.body.appendChild(suggestionBox);

searchInput.addEventListener('input', () => {
  const query = searchInput.value.trim().toLowerCase();
  suggestionBox.innerHTML = '';
  if (!query) return;

  const matched = Object.entries(relatedKeywords).flatMap(([cat, words]) => {
    return words.filter(word => word.toLowerCase().startsWith(query));
  });

  if (matched.length) {
    suggestionBox.style.display = 'block';
    suggestionBox.style.position = 'absolute';
    suggestionBox.style.top = `${searchInput.offsetTop + searchInput.offsetHeight + 5}px`;
    suggestionBox.style.left = `${searchInput.offsetLeft}px`;
    suggestionBox.style.width = `${searchInput.offsetWidth}px`;
    matched.forEach(keyword => {
      const div = document.createElement('div');
      div.textContent = keyword;
      div.classList.add('suggestion-item');
      div.style.padding = '10px';
      div.style.cursor = 'pointer';
      div.style.backgroundColor = '#fff';
      div.style.borderBottom = '1px solid #eee';
      div.addEventListener('click', () => {
        searchInput.value = keyword;
        suggestionBox.innerHTML = '';
      });
      suggestionBox.appendChild(div);
    });
  } else {
    suggestionBox.style.display = 'none';
  }
});

searchInput.addEventListener('keypress', (e) => {
  if (e.key === 'Enter') {
    const query = searchInput.value.trim();
    if (query) {
      window.location.href = `search.html?query=${encodeURIComponent(query)}`;
    }
  }
});