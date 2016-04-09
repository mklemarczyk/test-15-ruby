package ug.lab.project3;

import static org.junit.Assert.*;

import java.util.List;

import org.jbehave.core.annotations.*;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.steps.*;

public class MySteps implements CandidateSteps{

	private Boolean lastOperationResult;
	private Exception lastOperationException;
	private BinaryTree tree;

	@BeforeScenario
	public void beforeEachScenario() {
	    tree = new BinaryTree();
	}

	@AfterScenario
	public void afterAnyScenario() {
		tree = null;
	}

	@When("getting number")
	public void whenGettingNumber(){
		try{
			tree.getNumber();
		}catch(Exception ex){
			lastOperationException = ex;
		}
	}
	
	@Then("operation should throw an exception")
	public void thenOperationShouldExceptionFalse() {
		if(lastOperationResult == null){
			fail("Nie otrzymano zadnego wyjatku.");
		}
	}

	@When("navigate to parent")
	public void whenNavigateToParent(){
		lastOperationResult = tree.moveUp();
	}

	@When("navigate to left child")
	public void whenNavigateToLeftChild(){
		lastOperationResult = tree.moveLeft();
	}

	@When("navigate to right child")
	public void whenNavigateToRightChild(){
		lastOperationResult = tree.moveRight();
	}

	@Then("operation should return $value")
	public void thenOperationShouldReturn(@Named("value") boolean value){
		if(lastOperationResult == null){
			fail("Nie uruchomiono zadnej metody.");
		}
		if(lastOperationResult != value){
			fail("Oczekiwano innego stanu");
		}
	}

	public List<StepCandidate> listCandidates() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<BeforeOrAfterStep> listBeforeOrAfterStories() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<BeforeOrAfterStep> listBeforeOrAfterStory(boolean givenStory) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<BeforeOrAfterStep> listBeforeOrAfterScenario(ScenarioType type) {
		// TODO Auto-generated method stub
		return null;
	}

	public Configuration configuration() {
		// TODO Auto-generated method stub
		return null;
	}
}