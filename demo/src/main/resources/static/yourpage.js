// yourpage.js

window.addEventListener("DOMContentLoaded", () => {
  const reviewList = document.querySelector(".review-list");
  const pagination = document.getElementById("reviewPagination");
  const writeReviewBtn = document.querySelector(".write-review-btn");


/*  const reviews = Array.from({ length: 12 }, (_, i) => ({
    user: `baekseok123`,
    rating: 5 - (i % 3) * 0.5,
    content: `리뷰 상세내용입니다. `.repeat(5)
  }));*/

  const perPage = 3;
  let currentPage = 1;

/*  function renderReviews() {
    reviewList.innerHTML = "";
    const start = (currentPage - 1) * perPage;
    const end = start + perPage;

    reviews.slice(start, end).forEach((r) => {
      const li = document.createElement("li");
      li.innerHTML = `
        <h4>${r.user} ★★★★★</h4>
        <p>${r.content}</p>
      `;
      reviewList.appendChild(li);
    });
  }

  function renderPagination() {
    pagination.innerHTML = "";
    const pageCount = Math.ceil(reviews.length / perPage);
    for (let i = 1; i <= pageCount; i++) {
      const btn = document.createElement("button");
      btn.textContent = i;
      if (i === currentPage) btn.classList.add("active");
      btn.addEventListener("click", () => {
        currentPage = i;
        renderReviews();
        renderPagination();
      });
      pagination.appendChild(btn);
    }
  }*/

/*  function goToWriteReview() {
  const mentorName = document.querySelector('.mentor-info h2')?.textContent.trim();
  if (mentorName) {
    const encodedName = encodeURIComponent(mentorName);
    window.location.href = `../html/write-review.html?mentor=${encodedName}`;
  } else {
    alert("멘토 정보를 불러오지 못했습니다.");
  }
}*/

  // 💡 버튼 연결
/*  if (writeReviewBtn) {
    writeReviewBtn.addEventListener("click", goToWriteReview);
  }*/

//  renderReviews();
//  renderPagination();

  
});
