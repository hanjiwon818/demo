// 👉 카테고리 페이지 동적 렌더링
window.addEventListener('DOMContentLoaded', () => {
    const params = new URLSearchParams(window.location.search);
    const categoryName = params.get('category') || '카테고리';
    document.querySelector('.category-title').textContent = categoryName;
  
    /*// 테스트용 더미 데이터
    const dummyMentors = Array.from({ length: 15 }, (_, i) => ({
      id: i + 1; //id 추가
      name: `김백석 멘토님`,
      rating: 5.0,
      stars: '★★★★★',
      desc: '상세설명 줄글입니다. 상세설명 줄글입니다. 상세설명 줄글입니다.',
    }));
  
    let currentPage = 1;
    const perPage = 6;
  
    const mentorGrid = document.getElementById('mentorGrid');
    const pagination = document.getElementById('pagination');
    const sortButtons = document.querySelectorAll('.sort-btn');
    const searchInput = document.getElementById('searchInput');

    function renderMentors(list) {
      mentorGrid.innerHTML = '';
      list.forEach((mentor) => {
        const div = document.createElement('div');
        div.className = 'mentor-card';
        div.innerHTML = `
          <h3>${mentor.name}</h3>
          <div class="rating">${mentor.stars} <span>${mentor.rating.toFixed(1)}</span></div>
          <p>${mentor.desc}</p>
        `;

        // 👉 클릭 시 post.html로 이동
        div.addEventListener('click', () => {
          window.location.href = `post?mentor=${encodeURIComponent(mentor.name)}`;
        });


        mentorGrid.appendChild(div);
      });
    }
  
    function paginate(data) {
      const start = (currentPage - 1) * perPage;
      const end = start + perPage;
      renderMentors(data.slice(start, end));
    }
  
    function renderPagination(total) {
      pagination.innerHTML = '';
      const pageCount = Math.ceil(total.length / perPage);
      for (let i = 1; i <= pageCount; i++) {
        const btn = document.createElement('button');
        btn.textContent = i;
        btn.className = i === currentPage ? 'active' : '';
        btn.addEventListener('click', () => {
          currentPage = i;
          paginate(filteredMentors);
          renderPagination(filteredMentors);
        });
        pagination.appendChild(btn);
      }
    }
  
    let filteredMentors = [...dummyMentors];
    paginate(filteredMentors);
    renderPagination(filteredMentors);
  
    // 🔍 검색 기능
    searchInput.addEventListener('input', () => {
      const q = searchInput.value.toLowerCase();
      filteredMentors = dummyMentors.filter(m => m.name.toLowerCase().includes(q));
      currentPage = 1;
      paginate(filteredMentors);
      renderPagination(filteredMentors);
    });
  
    // 🔁 정렬 기능
    sortButtons.forEach(btn => {
      btn.addEventListener('click', () => {
        sortButtons.forEach(b => b.classList.remove('active'));
        btn.classList.add('active');
        const sortType = btn.dataset.sort;
        if (sortType === 'latest') {
          filteredMentors = [...dummyMentors]; // 최신순: 원래 순서
        } else if (sortType === 'popular') {
          filteredMentors = [...dummyMentors].sort((a, b) => b.rating - a.rating);
        }
        currentPage = 1;
        paginate(filteredMentors);
        renderPagination(filteredMentors);
      });
    });
  });
  */