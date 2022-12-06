function solution(num, total) {
  var answer = [];

  let x = -49;
  while (x < 100) {
    if (num * x + parseInt((num * (num - 1)) / 2) == total) break;
    x += 1;
  }

  for (let i = x; i < x + num; i++) answer.push(i);

  return answer;
}
