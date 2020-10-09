package problems;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class NiceTeamsHackerrank {
	
	public static void main(String[] args) {
		
		List<Integer> skillLevel = new ArrayList<>();
		
		skillLevel.add(25107191);
		skillLevel.add(123232501);
		skillLevel.add(151290765);
		skillLevel.add(183012194);
		skillLevel.add(473251358);
		skillLevel.add(579542802);
		skillLevel.add(689345248);
		skillLevel.add(709552565);
		skillLevel.add(803612259);
		skillLevel.add(862726097);
		skillLevel.add(994391793);
		
		int minDiff = 440987423;
		
		System.out.println(maxPairs(skillLevel, minDiff));
	}

	public static int maxPairs(List<Integer> skillLevel, int minDiff) {
        
        int result = 0;
        if(skillLevel == null)
            return result;

        boolean[] isPaired = new boolean[skillLevel.size()];
        
        Collections.sort(skillLevel);

        int i=0 ; int j = 1;
        while(j < skillLevel.size()) {

        	if(isPaired[i])
        		i++;
        	else if(isPaired[j])
        		j++;
        	else if(skillLevel.get(j) - skillLevel.get(i) >= minDiff) {
                result += 1;
                isPaired[i] = isPaired[j] = true;
                i++; j++;
            } else 
            	j++;
        }

        return result;
    }

}
