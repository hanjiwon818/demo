// write-review.js

window.addEventListener("DOMContentLoaded", () => {
  const submitBtn = document.querySelector(".submit-btn");
  const titleInput = document.querySelector(".write-title");
  const contentInput = document.querySelector(".write-content");
  const imageInput = document.getElementById("reviewImageInput");
  const imageCount = document.getElementById("imageCount");

  // ⭐ 별점 요소 생성 및 이벤트 처리
  const ratingContainer = document.createElement("div");
  ratingContainer.className = "rating-stars";
  ratingContainer.style.margin = "10px 0";
  let currentRating = 0;

  for (let i = 1; i <= 5; i++) {
    const star = document.createElement("span");
    star.textContent = "☆";
    star.dataset.value = i;
    star.style.fontSize = "24px";
    star.style.cursor = "pointer";
    star.addEventListener("click", () => {
      currentRating = i;
      updateStars();
    });
    ratingContainer.appendChild(star);
  }

  const updateStars = () => {
    const stars = ratingContainer.querySelectorAll("span");
    stars.forEach((s, index) => {
      s.textContent = index < currentRating ? "★" : "☆";
      s.style.color = index < currentRating ? "#ffaa00" : "#999";
    });
  };

  const form = document.querySelector(".write-form");
  form.insertBefore(ratingContainer, contentInput);

  imageInput.addEventListener("change", () => {
    const files = imageInput.files;
    const count = files.length;
    imageCount.textContent = `${count} / 10`;

    if (count > 10) {
      alert("이미지는 최대 10개까지 업로드할 수 있습니다.");
      imageInput.value = "";
      imageCount.textContent = "0 / 10";
      return;
    }

    [...files].forEach((file) => {
      const reader = new FileReader();
      reader.onload = function (e) {
        const imageTag = `<img src="${e.target.result}" style="max-width:100%; height:auto; margin:10px 0;" alt="업로드 이미지"/>`;
        contentInput.value += "\n" + imageTag + "\n";
      };
      reader.readAsDataURL(file);
    });
  });

  submitBtn.addEventListener("click", () => {
    const title = titleInput.value.trim();
    const content = contentInput.value.trim();

    if (!title || !content || currentRating === 0) {
      alert("제목, 내용, 별점을 모두 입력해주세요.");
      return;
    }

    // 👉 서버로 넘길 준비 예시
    const reviewData = {
      title,
      content,
      rating: currentRating, // 1~5 점
      images: [...imageInput.files] // 실제 전송은 FormData로 처리
    };

    console.log("등록할 리뷰 데이터:", reviewData);
    alert("리뷰가 성공적으로 등록되었습니다!");
    window.location.href = "yourpage.html";
  });

  titleInput.addEventListener("keydown", (e) => {
    if (e.key === "Enter") {
      e.preventDefault();
    }
  });
});
