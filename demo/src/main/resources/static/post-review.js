window.addEventListener("DOMContentLoaded", () => {
  const titleEl = document.querySelector(".post-title");
  const dateEl = document.querySelector(".post-date");
  const contentBox = document.querySelector(".post-box");
  const ratingEl = document.querySelector(".review-rating");

  const params = new URLSearchParams(window.location.search);
  const mentorId = params.get("mentor") || "defaultUser";

//  const dummyReview = {
//    title: `${mentorId}님에 대한 리뷰`,
//    date: "2025.01.01",
//    content: `정말 유익한 멘토링이었습니다! 친절하시고 설명도 잘 해주셨어요.\n다음에도 꼭 다시 신청하고 싶어요.`,
//    rating: 4.5,
//    image: "../images/sample-review.jpg"
//  };

//  titleEl.textContent = dummyReview.title;
//  dateEl.textContent = dummyReview.date;
//  ratingEl.textContent = "★".repeat(Math.round(dummyReview.rating)) + "☆".repeat(5 - Math.round(dummyReview.rating));
//
//  contentBox.innerHTML = `
//    <p>${dummyReview.content.replace(/\n/g, '<br>')}</p>
//    <img src="${dummyReview.image}" alt="리뷰 이미지">
//  `;
//
//  const inquiryDiv = document.createElement("div");
//  inquiryDiv.className = "inquiry-link";
//  inquiryDiv.innerHTML = `<a href="yourpage.html?user=${mentorId}">멘토에게 문의하러 가기 ></a>`;
//  document.querySelector("main").appendChild(inquiryDiv);
//});
