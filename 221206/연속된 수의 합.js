function solution(num, total) {
  var answer = [];

  let x = -1000;
  while (x < 1000) {
    if (num * x + parseInt((num * (num - 1)) / 2) == total) break;
    x += 1;
  }

  for (let i = x; i < x + num; i++) answer.push(i);

  return answer;
}
