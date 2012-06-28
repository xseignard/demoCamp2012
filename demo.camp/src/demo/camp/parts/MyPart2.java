package demo.camp.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class MyPart2 {
	
	private Composite parent;
	private Button button;

	@Inject
	public MyPart2(Composite parent) {
		this.parent = parent;
	}
	
	@PostConstruct
	public void postConstruct() {
		
		button = new Button(parent, SWT.NONE);
		button.setText("Hello");
		
	}
	
	@Inject
	@Optional
	void handleMessage(@UIEventTopic("demoCamp/nantes/part2") Object object) {
		button.setText(object.toString());
	}

}
