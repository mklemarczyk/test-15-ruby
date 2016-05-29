package ug.lab.proj6;

import java.util.*;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.*;
import org.jbehave.core.steps.ParameterConverters.ParameterConverter;
import org.jbehave.core.steps.ParameterConverters.StringListConverter;
import ug.lab.proj6.steps.HtmlUnitSteps;

public class RunHtmlUnitTest extends JUnitStories {

	public RunHtmlUnitTest() {
		super();
	}

	@Override
	public Configuration configuration() {
		return new MostUsefulConfiguration()
				// where to find the stories
				.useStoryLoader(new LoadFromClasspath())
				.useParameterConverters(
						new ParameterConverters().addConverters(customConverters()))
				// CONSOLE and TXT reporting
				.useStoryReporterBuilder(
						new StoryReporterBuilder().withDefaultFormats()
						.withFormats(Format.CONSOLE, Format.TXT));
	}

	private ParameterConverter[] customConverters() {
		List<ParameterConverter> converters = new ArrayList<>();
		converters.add(new StringListConverter(";"));
		return converters.toArray(new ParameterConverter[converters.size()]);
	}

	// Here we specify the steps classes
	@Override
	public InjectableStepsFactory stepsFactory() {
		// varargs, can have more that one steps classes
		return new InstanceStepsFactory(configuration(), new HtmlUnitSteps());
	}

	@Override
	protected List<String> storyPaths() {
		return Arrays.asList("Login.story");
	}

}
