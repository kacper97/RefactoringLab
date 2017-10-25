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
      calculateScore(criteria);
      if (doesNotMeetAnyMustMatchCriterion(criteria))
    	  return false;
      return anyMatches(criteria); 
   }

private void calculateScore(Criteria criteria){
	int score=0;
	for (Criterion criterion: criteria){
		score += criterion.getWeight().getValue(); 
	}
}

private boolean doesNotMeetAnyMustMatchCriterion(Criteria criteria){
	for (Criterion criterion1: criteria){
		return criterion1.getWeight()== Weight.MustMatch;
	}
	return false;
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

