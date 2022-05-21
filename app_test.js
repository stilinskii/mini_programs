let hellos = document.getElementsByClassName('hello');

console.dir(hellos);

let he = document.body.getElementsByTagName('h1');
let title = document.querySelector('div.hello:first-child h1');
let titleAll = document.querySelectorAll('.hello h1');
titleAll.forEach((e) => console.log(e));

console.dir(title);
title.style.color = 'red';

function handleTitleClick() {
  alert('hey!');
}

function handleMouseEnter() {
  title.innerText = 'mouse here';
}

function handleMouseLeave() {
  title.innerText = 'mouse gone';
}

window.addEventListener('resize', handleWindowResize);

function handleWindowResize() {
  document.body.style.backgroundColor = 'tomato';
}

window.addEventListener('copy', handleWindowCopy);
function handleWindowCopy() {
  alert('wanna copy?');
}

function handleWindowOnline() {
  alert('wifi on');
}
function handleWindowOffline() {
  alert('wifi off');
}
//title.addEventListener('click', handleTitleClick);
//not 'handleTitleClick()' 이렇게하면 js가 실행될떄 ()를 만나면 자동적으로 실행됨

// title.addEventListener('mouseenter', handleMouseEnter);
// title.addEventListener('mouseleave', handleMouseLeave);

title.onclick = handleTitleClick;
title.onmouseenter = handleMouseEnter;
title.onmouseleave = handleMouseLeave;
window.addEventListener('online', handleWindowOnline);
window.addEventListener('offline', handleWindowOffline);

//--------------
let header = document.body.getElementsByTagName('header')[0];
console.dir(header);
console.log(`${header}`);

function handleHeaderClick() {
  const currentColor = this.style.color;
  let newColor;

  if (currentColor === '' || currentColor == 'black') {
    newColor = 'tomato';
  } else if (currentColor === 'tomato') {
    newColor = 'orange';
  } else if (currentColor === 'orange') {
    newColor = 'yellow';
  } else if (currentColor === 'yellow') {
    newColor = 'green';
  } else if (currentColor === 'green') {
    newColor = 'blue';
  } else if (currentColor === 'blue') {
    newColor = 'purple';
  } else if (currentColor === 'purple') {
    newColor = 'black';
  }
  this.style.color = newColor;
}

header.addEventListener('click', handleHeaderClick);

//const h1 = document.querySelector('div.hello:first-child h1');
//왜 안돼?
const h1 = document.getElementsByTagName('h1')[0];

//변수에 클래스이름을 저장해서 오타오류때문에 삽질하는 것을 방지
//근데 이건 그 객체의 클래스이름이 바뀌길 원하지 않을때 문제가 될 수 있다.
// function handleTitleClick() {
//   const clickedClass = 'active';
//   if (h1.class === clickedClass) {
//     h1.className = '';
//   } else {
//     h1.className = clickedClass;
//   }
// }
//대신 클래스 리스트를 써주세용 유후~
function handleTitleClick() {
  h1.classList.toggle('active');
  //토클을 쓰면 한번만 쓰면 되니 클래스이름을 담을 변수도 필요없음!
}
h1.addEventListener('click', handleTitleClick);
