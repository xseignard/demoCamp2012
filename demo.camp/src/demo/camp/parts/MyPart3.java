package demo.camp.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class MyPart3 {
	
	private Composite parent;
	private Label label;

	@Inject
	public MyPart3(Composite parent) {
		this.parent = parent;
	}
	
	@PostConstruct
	public void postConstruct() {
		
		label = new Label(parent, SWT.NONE);
		label.setText("Hello");
	}
	
	@Inject
	@Optional
	void handleMessage(@UIEventTopic("demoCamp/nantes/part3") Object object) {
		label.setText(object.toString());
	}

}
