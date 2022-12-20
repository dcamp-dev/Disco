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
            String from = r.split(" ")[0];
            String to = r.split(" ")[1];
            
            map
                .computeIfAbsent(to, i -> new ArrayList<>())
                .addAll(Arrays.asList(from));
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
