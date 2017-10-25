package ilyb;

import java.util.*;


public class Profile { 
   private Map<String,Answer> answers = new HashMap<>();
   private int score;
   private String name;

   public Profile(String name) {
      this.name = name;
   }
   
   public String getName() {
      return name;
   }

   public void add(Answer answer) { 
      answers.put(answer.getQuestionText(), answer);
   }
   
   public boolean matches(Criteria criteria) { 
      score = 0;
      
      boolean kill = false;
      boolean anyMatches = false; 
      for (Criterion criterion: criteria) {   
         boolean match = criterion.checkmatch(criterion, getAnswer(criterion));
               
         if (!match && isWeightMust(criterion)) {  
            kill = true;
         }
         if (match) {         
            score += criterion.getWeight().getValue();
         }
      }
      if (kill)       
         return false;
      return anyMatches; 
   }

public boolean isWeightMust(Criterion criterion){
	return criterion.getWeight()== Weight.MustMatch;
}

public Answer getAnswer(Criterion criterion){
	return answers.get(criterion.getAnswer().getQuestionText());
}

private boolean anyMatches(Criteria criteria){
	boolean anyMatches = false;
		for(Criterion criterion : criteria)
			anyMatches = criterion.checkmatch(criterion,getAnswer(criterion));
		return anyMatches;
}
public int score() {
      return score;
   }
}

