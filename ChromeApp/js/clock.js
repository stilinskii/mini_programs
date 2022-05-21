const clock = document.getElementById('clock');

function getClock() {
  const date = new Date();
  clock.innerText = `${date.getHours()}:${date.getMinutes()}:${date.getSeconds()}`;
}

getClock(); //페이지가 로드되면 바로 시간을 보여주기 so cool~
setInterval(getClock, 1000);
// setTimeout(getClock, 5000);
