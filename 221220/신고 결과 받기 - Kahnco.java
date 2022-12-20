import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        String[] duplicatedReport = removeDuplicates(report);
        
        Map<String, List<String>> answerMap = new HashMap<String, List<String>>();
        initValue(answerMap, id_list);
        
        return solve(duplicatedReport, answerMap, id_list, k);
    }
    
    public void initValue(Map<String, List<String>> map, String[] id_list) {
        for(String id: id_list) {
            map.put(id, Collections.<String>emptyList());
        }
    }
    
    public String[] removeDuplicates(String[] arr) {
        HashSet<String> hashSet = new HashSet<>();
        for(String item : arr){
            hashSet.add(item);
        }
        return hashSet.stream().toArray(String[]::new);
    }
    
    public int[] solve(String[] report, Map<String, List<String>> map, String[] id_list, int k) {
        List<String> idList = Arrays.asList(id_list);
        int[] answer = new int[map.keySet().size()];
        Arrays.fill(answer, 0);
        
        for (String r : report) {
            String from = r.split(" ")[0];
            String to = r.split(" ")[1];
            
            List<String> temp = new ArrayList<>();
            temp.addAll(map.get(to));
            temp.add(from);
            map.put(to, temp);
        }
        
        for (String id : map.keySet()) {
            if (map.get(id).size() >= k) {
                List<String> toList = map.get(id);
                
                for (String from2 : toList) {
                    answer[idList.indexOf(from2)]++;
                }
            }
        }
        
        return answer;
    }
}
