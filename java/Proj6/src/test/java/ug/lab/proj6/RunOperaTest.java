package ug.lab.proj6;

import java.net.URL;
import java.util.*;
import org.jbehave.core.configuration.*;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.FilePrintStreamFactory.ResolveToSimpleName;
import org.jbehave.core.reporters.*;
import org.jbehave.core.steps.*;
import org.jbehave.core.steps.ParameterConverters.ParameterConverter;
import org.jbehave.core.steps.ParameterConverters.StringListConverter;
import ug.lab.proj6.steps.OperaStepsPl;

public class RunOperaTest extends JUnitStories {

	public RunOperaTest() {
		super();
	}

	@Override
	public Configuration configuration() {
		ClassLoader classLoader = this.getClass().getClassLoader();
		Locale locale = new Locale("pl");
		URL codeLocation = CodeLocations.codeLocationFromClass(this.getClass());
		Keywords keywords = new LocalizedKeywords(locale, "resources.txt", classLoader);
		Properties properties = new Properties();
		properties.setProperty("encoding", "UTF-8");
		Configuration configuration = new MostUsefulConfiguration()
				.useKeywords(keywords)
				.useStepCollector(new MarkUnmatchedStepsAsPending(keywords))
				.useStoryParser(new RegexStoryParser(keywords))
				.useStoryLoader(new LoadFromClasspath())
				.useParameterConverters(
						new ParameterConverters().addConverters(customConverters()))
				.useDefaultStoryReporter(new ConsoleOutput(keywords))
				.useStoryReporterBuilder(new StoryReporterBuilder()
						.withCodeLocation(codeLocation)
						.withPathResolver(new ResolveToSimpleName())
						.withDefaultFormats()
						.withFormats(Format.CONSOLE, Format.TXT)
						.withViewResources(properties)
						.withFailureTrace(false)
						.withKeywords(keywords));
		return configuration;
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
		return new InstanceStepsFactory(configuration(), new OperaStepsPl());
	}

	@Override
	protected List<String> storyPaths() {
		return Arrays.asList("ProjectPL.story");
	}

}
