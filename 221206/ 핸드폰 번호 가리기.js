function solution(phone_number) {
  let last = phone_number.substr(phone_number.length - 4);
  let answer = '';
  for (let i = 0; i < phone_number.length - 4; i++) answer += '*';
  answer += last;

  return answer;
}
