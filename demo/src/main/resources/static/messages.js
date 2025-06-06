// 👉 쪽지함 더미 데이터 기반 대화 전환 기능

window.addEventListener('DOMContentLoaded', () => {
  const userItems = document.querySelectorAll('.user-item');
  const chatHeader = document.querySelector('.chat-header strong');
  const chatMeta = document.querySelector('.chat-meta');
  const chatContent = document.querySelector('.chat-content');
  const chatInput = document.querySelector('.chat-input input');
  const sendButton = document.querySelector('.chat-input button');

  // 더미 대화 데이터
  const conversations = {
    '김백석 멘토님': [
      { sender: '상대', text: '안녕하세요! 궁금한 게 있어요.' },
      { sender: '상대', text: '혹시 이번 주에 상담 가능하신가요?' },
      { sender: '나', text: '네 가능합니다. 날짜 알려주세요 😊' }
    ],
    '이백석 멘토님': [
      { sender: '상대', text: '안녕하세요. 문의드려요.' },
      { sender: '나', text: '네, 말씀해주세요!' }
    ]
  };

  // 유저 클릭 시 대화 불러오기
  userItems.forEach(item => {
    item.addEventListener('click', () => {
      userItems.forEach(i => i.classList.remove('active'));
      item.classList.add('active');

      const name = item.querySelector('.user-name')?.textContent || '김백석 멘토님';
      chatHeader.textContent = name;
      chatMeta.textContent = '평균 1시간 내 응답';

      const convo = conversations[name] || [];
      chatContent.innerHTML = '';

      convo.forEach(msg => {
        const bubble = document.createElement('div');
        bubble.className = 'chat-bubble ' + (msg.sender === '나' ? 'right' : 'left');
        bubble.textContent = msg.text;
        chatContent.appendChild(bubble);
      });
    });
  });

  // 전송 버튼 클릭 시 메시지 추가
  sendButton.addEventListener('click', () => {
    const text = chatInput.value.trim();
    if (!text) return;

    const bubble = document.createElement('div');
    bubble.className = 'chat-bubble right';
    bubble.textContent = text;
    chatContent.appendChild(bubble);
    chatInput.value = '';
    chatContent.scrollTop = chatContent.scrollHeight;
  });

  // Enter 키로도 메시지 전송
  chatInput.addEventListener('keypress', (e) => {
    if (e.key === 'Enter') sendButton.click();
  });
});
