/* 
- 한 번에 한 명의 유저를 신고
- 동일한 유저에 대한 신고 횟수는 1회로 처리
- 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송

해설
정확성 10초인 것을 보고, 효율성 문제는 아니겠구나 싶었음.


*/

function solution(id_list, report, k) {
  let answer = new Array(id_list.length).fill(0);

  // 신고한 사람  (신고 한 사람 : Set[신고 당한 사람들])
  const reporter = new Map();

  // 신고 당한 사람   (신고 당한 사람 : Set[신고 한 사람들])
  const reported = new Map();

  // 신고 당한 횟수  신고 당한 사람 : 횟수
  const reportedCount = new Map();

  // init
  for (let i = 0; i < id_list.length; i++) {
    const id = id_list[i];

    reporter.set(id, new Set());
    reported.set(id, new Set());
    reportedCount.set(id, 0);
  }

  for (let i = 0; i < report.length; i++) {
    const [from, to] = report[i].split(" ");

    // 신고 당한 사람 : [신고한 사람들] 중에서 신고 한 적없으면 count++
    if (!reported.get(to).has(from)) {
      const newReportedCount = reportedCount.get(to) + 1;
      reportedCount.set(to, newReportedCount);
    }

    // 신고 한 사람 : [신고 당한 사람들], 신고 당한 사람 : [신고 한 사람들] 갱신. set기 때문에 중복 제거
    const newReporter = reporter.get(from).add(to);
    const newReported = reported.get(to).add(from);

    reporter.set(from, newReporter);
    reported.set(to, newReported);
  }

  // console.log(reporter, reported, reportedCount);

  // k번 넘게 신고 당한 악질 유저들
  const realReported = [];

  reportedCount.forEach((value, key) => {
    if (value >= k) realReported.push(key);
  });

  // 신고한 사람 : [신고 당한 사람들]에서 [신고 당한 사람들].forEach하면서 악질 유저 검거
  [...reporter].forEach((r, index) => {
    const [from, to] = r;

    [...to].forEach((t) => {
      if (realReported.includes(t)) answer[index]++;
    });
  });

  console.log(answer);

  return answer;
}

solution(
  ["muzi", "frodo", "apeach", "neo"],
  ["muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"],
  2
);
solution(["con", "ryan"], ["ryan con", "ryan con", "ryan con", "ryan con"], 3);
