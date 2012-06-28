package demo.camp.parts;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class MyPart1 {
	
	@Inject
	private Logger logger;
	
	private Composite parent;

	private Button button;

	@Inject
	public MyPart1(Composite parent) {
		this.parent = parent;
	}
	
	@PostConstruct
	public void postConstruct() {
		this.logger.info("post construct");		
		button = new Button(parent, SWT.NONE);
		button.setText("Hello");
	}
	
	@Inject
	@Optional
	void handleMessage(@UIEventTopic("demoCamp/nantes/part1") Object object) {
		button.setText(object.toString());
	}

}
