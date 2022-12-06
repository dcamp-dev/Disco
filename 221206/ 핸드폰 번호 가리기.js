function solution(phone_number) {
  return phone_number
    .split('')
    .map((v, i) => {
      return i >= phone_number.length - 4 ? v : '*';
    })
    .join('');
}
