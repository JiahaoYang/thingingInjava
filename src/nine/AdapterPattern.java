package nine;

class WaveForm {
	private static long counter = 0;
	private final long id = counter++;
	@Override
	public String toString() {
		return "Waveform" + id;
	}
}

class Filter {
	public String name() { 
		return getClass().getSimpleName();
	}
	public WaveForm process(WaveForm input) {
		return input;
	}
}

class LowPass extends Filter {
	private int cutoff;
	public LowPass(int cutoff) {
		this.cutoff = cutoff;
	}
	public WaveForm process(WaveForm input) {
		return input;
	}
}

class HighPass extends Filter {
	private int cutoff;
	public HighPass(int cutoff) {
		this.cutoff = cutoff;
	}
	public WaveForm process(WaveForm input) {
		return input;
	}
}

interface ProcessorInterface {
	String name();
	Object process(Object input);
}

class Apply {
	public static void process(ProcessorInterface p, Object s) {
		System.out.println("use" + p.name());
		p.process(s);
	}
}

class FilterAdapter implements ProcessorInterface {
	private Filter filter;
	public FilterAdapter(Filter filter) {
		this.filter = filter;
	}
	@Override
	public String name() { 
		return filter.name();
	}
	@Override
	public WaveForm process(Object input) {
		return filter.process((WaveForm)input);
	}
}

public class AdapterPattern {
	public static void main(String[] args) {
		WaveForm waveForm = new WaveForm();
		Apply.process(new FilterAdapter(new LowPass(1)), waveForm);
		Apply.process(new FilterAdapter(new HighPass(1)), waveForm);
	}
}
