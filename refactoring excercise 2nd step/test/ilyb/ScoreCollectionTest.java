package ilyb;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*; 
import org.junit.Test;

import ilyb.ScoreCollection;

public class ScoreCollectionTest {
   @Test
   public void answersArithmeticMeanOfTwoNumbers() {
      // Arrange
      ScoreCollection collection = new ScoreCollection();
      collection.add(() -> 5);
      collection.add(() -> 7);
      
      // Act
      int actualResult = collection.arithmeticMean();
      
      // Assert
      assertThat(actualResult, equalTo(6));
   }
}

