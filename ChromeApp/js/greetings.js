const loginForm = document.querySelector('#login-form');
const loginInput = document.querySelector('#login-form input');
const loginButton = document.querySelector('#login-form button');
const greeting = document.querySelector('#greeting');

// console.dir(loginForm);

const HIDDEN_CLASSNAME = 'hidden';
const USERNAME_KEY = 'username';
//위에것들처럼 중요하지 않음 & 문자열임 - 대문자로
function onLoginSubmit(event) {
  event.preventDefault();
  loginForm.classList.add(HIDDEN_CLASSNAME);
  //유저네임이 저장되어있지않을때 인풋으로 받아서 넣는다
  const username = loginInput.value;
  localStorage.setItem(USERNAME_KEY, username);
  paintGreetings(username);
}

function paintGreetings(username) {
  greeting.classList.remove(HIDDEN_CLASSNAME);
  greeting.innerText = `Hello ${username}:)`;
}

loginForm.addEventListener('submit', onLoginSubmit);

const savedUsername = localStorage.getItem(USERNAME_KEY);
if (savedUsername === null) {
  loginForm.classList.remove(HIDDEN_CLASSNAME);
} else {
  //username이 localstorge에 존재한다면 거기서 불러와서 넣어준다
  paintGreetings(savedUsername);
}
