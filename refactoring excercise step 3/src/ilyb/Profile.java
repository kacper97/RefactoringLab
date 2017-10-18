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
         Answer answer = answers.get(
               criterion.getAnswer().getQuestionText()); 
         
         boolean match = checkmatch(criterion,answer);
               

         if (!match && criterion.getWeight() == Weight.MustMatch) {  
            kill = true;
         }
         if (match) {         
            score += criterion.getWeight().getValue();
         }
         anyMatches |= match;  
      }
      if (kill)       
         return false;
      return anyMatches; 
   }

   private boolean checkmatch(Criterion criterion, Answer answer) {
	   return criterion.getWeight()== Weight.DontCare || answer.match(criterion.getAnswer());
}

public int score() {
      return score;
   }
}

