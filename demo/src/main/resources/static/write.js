// write.js

window.addEventListener("DOMContentLoaded", () => {
  const imageInput = document.getElementById("imageInput");
  const imageCount = document.getElementById("imageCount");
  const contentArea = document.querySelector(".write-content");

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

/*    [...files].forEach((file) => {
      const reader = new FileReader();
      reader.onload = function (e) {
        const imageTag = `<img src="${e.target.result}" style="max-width:100%; height:auto; margin:10px 0;" alt="업로드 이미지"/>`;
        contentArea.value += "\n" + imageTag + "\n";
      };
      reader.readAsDataURL(file);
    });
  });*/

  // 등록 버튼 유효성 검사 + 예시 저장 처리
  const submitBtn = document.querySelector(".submit-btn");
  submitBtn.addEventListener("click", () => {
    const title = document.querySelector(".write-title").value.trim();
    const content = contentArea.value.trim();

    if (!title || !content) {
      alert("제목과 내용을 모두 입력해주세요.");
      return;
    }

    alert("게시물이 등록되었습니다! (DB 연동은 추후 구현 예정)");
    location.href = "category.html";
  });
      const titleInput = document.querySelector(".write-title");
  titleInput.addEventListener("keydown", (e) => {
    if (e.key === "Enter") {
      e.preventDefault();
    }
  });
});
