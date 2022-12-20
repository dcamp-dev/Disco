import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        String[] duplicatedReport = removeDuplicates(report);
        
        return solve(duplicatedReport, id_list, k);
    }
    public String[] removeDuplicates(String[] arr) {
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(arr));
        return hashSet.stream().toArray(String[]::new);
    }
    
    public int[] solve(String[] report, String[] id_list, int k) {
        List<String> idList = Arrays.asList(id_list);
        int[] answer = new int[id_list.length];
        Map<String, List<String>> map = new HashMap<>();
        
        
        for (String r : report) {
            String[] splitArray = r.split(" ");
            String from = splitArray[0];
            String to = splitArray[1];
            
            map
                .computeIfAbsent(to, i -> new ArrayList<>())
                .add(from);
        }
        
        for (String id : map.keySet()) {
            List<String> toList = map.get(id);
            
            if (toList.size() >= k) {
                for (String from2 : toList) {
                    answer[idList.indexOf(from2)]++;
                }
            }
        }
        
        return answer;
    }
}
